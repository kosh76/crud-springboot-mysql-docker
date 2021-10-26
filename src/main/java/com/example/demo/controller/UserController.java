package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserServiseImpl;
import com.example.demo.service.UserServiсe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserServiсe userServiсe;


    @PostMapping("/addUser")
    public String saveUser (@RequestBody User user){
        userServiсe.save(user);
        return "User added successfully: "+user.getId();
    }
    @GetMapping ("/users")
    public List<User>getUsers(){
        return userServiсe.findAll();
    }
    @GetMapping ("/findUser/{id}")
    public Optional<User> getUser(@PathVariable Long id){
        return userServiсe.findById(id);
    }
    @DeleteMapping ("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id){
        userServiсe.deleteById(id);
        return "User deleted succefully: "+id;
    }

}
