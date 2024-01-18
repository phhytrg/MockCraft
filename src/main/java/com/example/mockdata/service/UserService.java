package com.example.mockdata.service;

import com.example.mockdata.domain.User;

public interface UserService {

    User findByUsername(String username);
    boolean existsByUsername(String username);
    void save(User user);
}
