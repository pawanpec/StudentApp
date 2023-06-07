package com.lp.school.api.controller;

import com.lp.school.api.dao.SchoolRepository;
import com.lp.school.api.model.School;
import com.lp.school.api.model.User;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping({"/api/school"})
public class SchoolController {
    private final Logger logger = LoggerFactory.getLogger(SchoolController.class);
    @Autowired
    SchoolRepository schoolRepository;

    @PostMapping
    public School create(@RequestBody School school) {
        long createdTime=new Date().getTime();
        school.setId(createdTime);
        return schoolRepository.save(school);
    }
    @GetMapping(path = {"/"})
    public List<School> getAll() {
        List<School> schools= schoolRepository.findAll();
        return schools;
    }

    @GetMapping(path = {"/{id}"})
    public School findById(@PathVariable Long id) {
        logger.info("fetching data for {}", id);
        Optional<School> school=schoolRepository.findById(id);
        if(school.isPresent())
            return school.get();
        return null;
    }
    @PutMapping
    public School update(@RequestBody School school) {
        return schoolRepository.save(school);
    }

    @DeleteMapping(path = {"/{id}"})
    public void delete(@PathVariable Long id) {
        schoolRepository.deleteById(id);
    }

}
