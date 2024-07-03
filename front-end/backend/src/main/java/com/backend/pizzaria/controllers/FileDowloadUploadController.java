package com.backend.pizzaria.controllers;

import com.backend.pizzaria.models.FilesModel;
import com.backend.pizzaria.repository.FilesRepository;
import com.backend.pizzaria.services.FileStorageService;
import com.backend.pizzaria.vo.v1.UploadFileResponseVO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/file/v1")

public class FileDowloadUploadController {
    private Logger logger = Logger.getLogger(FileDowloadUploadController.class.getCanonicalName());

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private FilesRepository filesRepository;

    @PostMapping("/uploadFile")
    public UploadFileResponseVO uploadFile(@RequestParam("file")MultipartFile file){
        logger.info("Storing file to disk");
        var fileName = fileStorageService.storeFile(file);
        String fileDowloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/file/v1/dowloadFile/")
                .path(fileName)
                .toUriString();
        return new UploadFileResponseVO(fileName, fileDowloadUri, file.getContentType(), file.getSize());
    }

    public FilesModel saveFilesInDatabase(FilesModel filesModel, MultipartFile file){
        filesModel.setRelativePath(file.getOriginalFilename());
        filesModel.setFileSize(filesModel.getFileSize());
        filesModel.setFile(true);
        filesModel.setImage(false);
        return filesRepository.save(filesModel);
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponseVO> uploadMultipleFiles(@RequestParam("files")MultipartFile[] files, FilesModel filesModel){
        logger.info("Storing files to disk");
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }
    //MY_file.txt
    @GetMapping("/dowloadFile/{fileName:.+}")
    public ResponseEntity<Resource> dowloadFile(@PathVariable String fileName, HttpServletRequest request){
        //preciso passar o nome do arquivo que ele deu ao salvar, exemplo:
        //Captura%20de%20Tela%20(1).png
        logger.info("Storing file to disk");
        Resource resource = fileStorageService.loadFileAsResource(fileName);
        String contentType = "";
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

        }catch(Exception e){
            logger.info("Could not determine file type!");
        }

        if(contentType.isBlank()){
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
