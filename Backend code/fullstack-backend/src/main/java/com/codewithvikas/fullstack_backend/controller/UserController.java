package com.codewithvikas.fullstack_backend.controller;

import com.codewithvikas.fullstack_backend.exception.UserNotFoundException;
import com.codewithvikas.fullstack_backend.model.User;
import com.codewithvikas.fullstack_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping()
        public User InsertData(@RequestBody User de){
            return userRepository.save(de);
    }
    @GetMapping()
        public List<User>getData(){
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    User getUserByID(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }
    @PutMapping("/{id}")
    User updateUser(@RequestBody User newUser ,@PathVariable Long id){
        return userRepository.findById(id).map(user ->{ user.setUsername(newUser.getUsername());user.setName(newUser.getName());return userRepository.save(user);}).orElseThrow(()->new UserNotFoundException(id));
    }
    @DeleteMapping("/{id}")
    String deleteaUSerByI(@PathVariable long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User data deleted succesfully";
    }

}
