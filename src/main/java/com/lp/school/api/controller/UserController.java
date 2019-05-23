package com.lp.school.api.controller;

import com.lp.school.api.dao.UserRepository;
import com.lp.school.api.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        List<User> users= userRepository.findByFatherMobileNumber(user.getFatherMobileNumber());
        if(!users.isEmpty()){
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
        Optional<User> user=userRepository.findById(id);
        if(user.isPresent())
         return user.get();
        return null;
    }
    @PutMapping
    public User update(@RequestBody User user) {
        return userRepository.save(user);
    }

}
