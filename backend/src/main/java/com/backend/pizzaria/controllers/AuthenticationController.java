package com.backend.pizzaria.controllers;

import com.backend.pizzaria.dto.AuthenticationDTO;
import com.backend.pizzaria.dto.LoginResponseDTO;
import com.backend.pizzaria.dto.RegisterDTO;
import com.backend.pizzaria.dto.UserLoggedDTO;
import com.backend.pizzaria.repository.UsersRepository;
import com.backend.pizzaria.security.TokenService;
import com.backend.pizzaria.services.UserAccount;
import com.backend.pizzaria.user.UserRole;
import com.backend.pizzaria.user.UsersModel;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = "http://localhost:4200/")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserAccount userAccount;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        var userDetails = (UsersModel) auth.getPrincipal();
        var token = tokenService.generateToken(userDetails);
        if(token != null){
            UserLoggedDTO userLoggedDTO = modelMapper.map(userDetails, UserLoggedDTO.class);
            userLoggedDTO.setToken(token);
            // Armazene o último usuário logado no serviço
            userAccount.setLastLoggedInUser(userDetails);
            return ResponseEntity.ok(userLoggedDTO);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/userAccount/userLogged")
    public ResponseEntity userLogged(){
        return ResponseEntity.ok(userAccount.getLastLoggedInUser());
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UsersModel data){
        if(usersRepository.findByLogin(data.getLogin()) != null) {
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        data.setPassword(encryptedPassword);
        usersRepository.save(data);
        return ResponseEntity.ok().build();
    }
}
