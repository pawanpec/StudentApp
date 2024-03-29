package com.lp.school.api.dao;


import com.lp.school.api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    List<User> findByFatherMobileNumber(String fatherMobileNumber);

}