package com.example.mapper;

import com.example.dtos.CurrentUsers;
import com.example.model.Users;

public class UserMapper {
    public static CurrentUsers toCurrentUsers(Users user) {
        if (user == null) return null;

        CurrentUsers dto = new CurrentUsers();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setImage(user.getImage());
        dto.setCurrentMovieHallId(user.getCurrentMovieHall().getId());
        return dto;
    }
}
