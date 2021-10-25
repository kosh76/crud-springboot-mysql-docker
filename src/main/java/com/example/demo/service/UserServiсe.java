package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServiсe {
    public void save(User user);

    public List<User> findAll();

    public Optional<User> findById(Long id);

    public void deleteById(Long id);

}