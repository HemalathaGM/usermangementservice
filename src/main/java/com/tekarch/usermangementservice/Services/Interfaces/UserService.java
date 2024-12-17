package com.tekarch.usermangementservice.Services.Interfaces;

import com.tekarch.usermangementservice.Models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(User user);
    List<User> getAllUsers();

    void deleteUser(Long id);

    Optional<User> getUserByID(Long id);
    User updateUser(User user);
}
