package com.backend.pizzaria.controllers;

import com.backend.pizzaria.user.UsersModel;
import com.backend.pizzaria.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/all")
    public List<UsersModel> getAllUsers(){
        return usersRepository.findAll();
    }


    /*@PostMapping("")
    public UsersModel createUser(@RequestBody UsersModel usersModel) {
        usersModel.setConfirmedUser(false);
        SecurityConfig securityConfig = new SecurityConfig();
        usersModel.setPassword(securityConfig.encryptData(usersModel.getPassword()));
        //colocar a parte de confirmação de e-mail
        return usersRepository.save(usersModel);
    }

    @GetMapping("/login")
    public ResponseEntity<UserDTO> loginUsers(@RequestParam("email") String email, @RequestParam("password") String password) {
        SecurityConfig securityConfig = new SecurityConfig();
        UsersModel userFound = usersRepository.userLogin(email, securityConfig.encryptData(password));
        if(userFound == null){
            return ResponseEntity.notFound().build();
        }
        UserDTO userDTO = toUserModelDTO(userFound);
        return ResponseEntity.ok(userDTO);
    }

    private UserDTO toUserModelDTO(UsersModel usersModel){
        return modelMapper.map(usersModel, UserDTO.class);//convertendo a model para dto
    }*/
}
