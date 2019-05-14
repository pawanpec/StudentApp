package com.lp.school.api.controller;

import com.lp.school.api.dao.SchoolRepository;
import com.lp.school.api.dao.UserRepository;
import com.lp.school.api.model.School;
import com.lp.school.api.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping({"/api/user"})
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserRepository userRepository;

    @PostMapping
    public User create(@RequestBody User user) {
        long createdTime=new Date().getTime();
        user.setId(createdTime);
        user.setCreatedTime(createdTime);
        user.setUpdatedTime(createdTime);
        List<User> users= userRepository.findByFatherMobileNumber(user.getFatherMobileNumber());
        if(user!=null && users.size()>0){
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "User Already Exist",null);
        }
        return userRepository.save(user);
    }
    @GetMapping(path = {"/"})
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public User findById(@PathVariable String id) {
        logger.info("fetching data for {}", id);
        return userRepository.findById(id).get();
    }
    @PutMapping
    public User update(@RequestBody User user) {
        long updatedTime=new Date().getTime();
        user.setUpdatedTime(updatedTime);
        return userRepository.save(user);
    }

}
