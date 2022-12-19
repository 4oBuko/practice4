package com.chornobuk.practice4.services;

import org.springframework.stereotype.Service;

import com.chornobuk.practice4.entities.User;
import com.chornobuk.practice4.repositories.UsersRepository;

@Service
public class UsersService {

    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User authorizeUser(String email, String password) {
        User user = usersRepository.getByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}