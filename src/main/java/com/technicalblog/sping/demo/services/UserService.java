package com.technicalblog.sping.demo.services;

import org.springframework.stereotype.Service;

import com.technicalblog.sping.demo.model.User;

@Service
public class UserService {

    public boolean login(User user) {
        if(user.getUsername().equals("validuser")) {
            return true;
        }
        else {
            return false;
        }
    }

}
