package com.tekarch.usermangementservice.Services;

import com.tekarch.usermangementservice.Models.User;
import com.tekarch.usermangementservice.Repositories.UserRepository;
import com.tekarch.usermangementservice.Services.Interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.lang.Long;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        System.out.println("New request to add user");
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

public void deleteUser(Long id) {
        userRepository.deleteById(id);
}

    @Override
    public Optional<User> getUserByID(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }


    public User updateUser(Long id,User userDetails)
    {
       User user = userRepository.findById(id).orElse(null);
        assert user != null;
        user.setUsername(userDetails.getUsername());
       user.setEmail(userDetails.getEmail());
       user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }
}
