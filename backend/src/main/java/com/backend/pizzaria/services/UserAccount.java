package com.backend.pizzaria.services;

import com.backend.pizzaria.dto.UserLoggedDTO;
import com.backend.pizzaria.user.UsersModel;
import org.springframework.stereotype.Service;

@Service
public class UserAccount {
    private UsersModel lastLoggedInUser;

    public void setLastLoggedInUser(UsersModel user) {
        this.lastLoggedInUser = user;
    }

    public UsersModel getLastLoggedInUser() {
        return lastLoggedInUser;
    }
}
