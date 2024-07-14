package com.backend.pizzaria.controllers;

import com.backend.pizzaria.dto.user.UserDTO;
import com.backend.pizzaria.models.UsersModel;
import com.backend.pizzaria.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/all")
    public List<UsersModel> getAllUsers() {
        return usersRepository.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<Object> createUser(@RequestBody UsersModel usersModel) {
        try {
            // Configura os campos do usuário
            usersModel.setConfirmedUser(false);
            usersModel.setAccountNonExpired(true);
            usersModel.setAccountNonLocked(true);
            usersModel.setCredentialsNonExpired(true);

            // Criptografa a senha antes de salvar
            usersModel.setPassword(passwordEncoder.encode(usersModel.getPassword()));

            // Salva o usuário no banco de dados
            UsersModel savedUser = usersRepository.save(usersModel);

            // Retorna a resposta com status 201 Created
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            // Loga o erro (opcional)
            e.printStackTrace();

            // Retorna a resposta com status de erro apropriado
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private UserDTO toUserModelDTO(UsersModel usersModel) {
        return modelMapper.map(usersModel, UserDTO.class); // Convertendo a model para DTO
    }
}
