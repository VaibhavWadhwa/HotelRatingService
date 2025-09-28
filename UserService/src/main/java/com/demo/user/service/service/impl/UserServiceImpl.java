package com.demo.user.service.service.impl;

import com.demo.user.service.entity.Rating;
import com.demo.user.service.entity.User;
import com.demo.user.service.exception.ResourceNotFoundException;
import com.demo.user.service.repository.UserRepo;
import com.demo.user.service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public User saveUser(User user) {
       String userId =  UUID.randomUUID().toString();
       user.setUserId(userId);
       return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepo.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User with id "+ userId +" is not found on server"));
       ArrayList<Rating> ratingsOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/"+ userId, ArrayList.class);
       logger.info("{}",ratingsOfUser);
       user.setRatings(ratingsOfUser);
        return user;
    }
}
