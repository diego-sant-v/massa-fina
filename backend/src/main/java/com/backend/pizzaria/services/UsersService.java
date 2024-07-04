package com.backend.pizzaria.services;

import com.backend.pizzaria.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UsersService implements UserDetailsService {
    private Logger logger = Logger.getLogger(UsersService.class.getName());
    @Autowired
    private UsersRepository usersRepository;

    public UsersService(UsersRepository repository){
        this.usersRepository = repository;
        //quando é setado pelo construtor essa injeção se torna obrigatoria
        /*
         quando só uso assim:
         @Autowired
          private UsersRepository usersRepository;
           não é obrigatório
         */
    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        logger.info("Finding one user by name!" + userName + "!");
        var user = usersRepository.findByUsername(userName);
        if(user != null){
            return user;
        }else{
            throw new UsernameNotFoundException("Username" + userName + "Not found!");
        }
    }
}
