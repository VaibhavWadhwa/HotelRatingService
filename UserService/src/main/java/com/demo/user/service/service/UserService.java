package com.demo.user.service.service;

import com.demo.user.service.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUser();
    User getUser(String userId);

}
