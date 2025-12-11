package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dtos.CurrentUsers;
import com.example.mapper.UserMapper;
import com.example.model.MovieHall;
import com.example.model.Users;
import com.example.repository.UsersRepository;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;
    
    @Autowired
    private MovieHallService movieHallService;

    public Users create(Users user) {
        return usersRepository.save(user);
    }

    public Users update(Long id, Users updatedUser) {
        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setEmail(updatedUser.getEmail());
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setPhoneNumber(updatedUser.getPhoneNumber());
        return usersRepository.save(user);
    }

    public void delete(Long id) {
        usersRepository.deleteById(id);
    }

    public Users getById(Long id) {
        return usersRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    public CurrentUsers current(Long id) {

        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return UserMapper.toCurrentUsers(user);
    }

	public String switchHall(Long userId,Long hallId) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
		MovieHall movieHall=movieHallService.findById(hallId);
		user.setCurrentMovieHall(movieHall);
		usersRepository.save(user);
		return "movie hall switch successfully";
	}
}
