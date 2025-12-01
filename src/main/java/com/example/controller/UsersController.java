package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.CurrentUsers;
import com.example.model.Users;
import com.example.service.UserService;

@RestController
@RequestMapping("/v1/api/users")
public class UsersController {

    @Autowired
    private UserService usersService;

    @GetMapping
    public List<Users> getAll() {
        return usersService.getAll();
    }

    @GetMapping("/{id}")
    public Users getById(@PathVariable Long id) {
        return usersService.getById(id);
    }

    @PutMapping("/{id}")
    public Users update(@PathVariable Long id, @RequestBody Users user) {
        return usersService.update(id, user);
    }

    
    @GetMapping("/current/users/{id}")
    public CurrentUsers currentUser(@PathVariable("id") Long userId) {
    	return usersService.current(userId);
    }
    
    @GetMapping("/switchMovieHall/{id}/users/{userId}")
    public String switchHall(@PathVariable("userId") Long userId,@PathVariable("id") Long hallId) {
    	return usersService.switchHall(userId,hallId);
    }
}
