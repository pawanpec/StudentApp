package com.lp.school.api.controller;

import com.lp.school.api.dao.SchoolRepository;
import com.lp.school.api.model.School;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/school"})
public class SchoolController {
    private final Logger logger = LoggerFactory.getLogger(SchoolController.class);
    @Autowired
    SchoolRepository schoolRepository;

    @PostMapping
    public School create(@RequestBody School school) {
        return schoolRepository.save(school);
    }
    @GetMapping(path = {"/"})
    public List<School> getAll() {
        return schoolRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public School findById(@PathVariable String id) {
        logger.info("fetching data for {}", id);
        return schoolRepository.findById(id).get();
    }
    @PutMapping
    public School update(@RequestBody School school) {

        return schoolRepository.save(school);
    }

}
