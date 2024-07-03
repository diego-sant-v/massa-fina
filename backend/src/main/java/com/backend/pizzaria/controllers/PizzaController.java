package com.backend.pizzaria.controllers;

import com.backend.pizzaria.dto.FileDTO;
import com.backend.pizzaria.dto.UserLoggedDTO;
import com.backend.pizzaria.models.FilesModel;
import com.backend.pizzaria.models.PizzasModel;
import com.backend.pizzaria.repository.FilesRepository;
import com.backend.pizzaria.repository.PizzaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/pizza")
public class PizzaController {
    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private FilesRepository filesRepository;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping("/all")
    public List<PizzasModel> getAllPizzas(){
        return pizzaRepository.findAll();
    }

    @PostMapping("/create")
    public PizzasModel createPizza(@RequestBody PizzasModel pizzasModel) {
        Optional<FilesModel> optionalFile = filesRepository.findById(pizzasModel.getFileId());
        if (optionalFile.isPresent()) {
            pizzasModel.setFile(optionalFile.get());
            return pizzaRepository.save(pizzasModel);
        } else {
            // Lógica para lidar com o caso em que o arquivo não foi encontrado
            throw new RuntimeException("Arquivo não encontrado com o ID: " + pizzasModel.getFileId());
        }
    }
}
