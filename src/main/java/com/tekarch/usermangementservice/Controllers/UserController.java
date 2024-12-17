package com.tekarch.usermangementservice.Controllers;

import com.tekarch.usermangementservice.Models.User;
import com.tekarch.usermangementservice.Repositories.UserRepository;
import com.tekarch.usermangementservice.Services.Interfaces.UserService;
import com.tekarch.usermangementservice.Services.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class UserController {
private final UserServiceImpl userServiceImpl;
private static final Logger logger= LogManager.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    public UserController(UserServiceImpl userServiceImpl) {
            this.userServiceImpl = userServiceImpl;
        }
    @GetMapping("/user/get")
    public ResponseEntity<List<User>> getUser() {
        return new ResponseEntity<>(userServiceImpl.getAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user=userService.getUserByID(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @PostMapping("/user/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
    return new ResponseEntity<>(userServiceImpl.addUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
            try{
                userService.deleteUser(id);
                return ResponseEntity.noContent().build();
            } catch (RuntimeException e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
    }
    @Autowired
        private UserRepository userRepository;
    @PutMapping("/user/{id}")
        public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
            Optional<User> userOptional = userRepository.findById(id);
                if(userOptional.isPresent()) {
                    User existingUser = userOptional.get();
                    existingUser.setUsername(user.getUsername());
             User savedUser = userRepository.save(existingUser);
                 return ResponseEntity.ok(savedUser);
        } else {
    return ResponseEntity.notFound().build();
}
}
}
