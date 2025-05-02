package com.react.mongo.spring.react.mongo.spring.repository;

import com.react.mongo.spring.react.mongo.spring.model.PanelUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PanelUserRepository extends MongoRepository<PanelUser,String> {

    //PanelUser findByFirstName(String username);
    Optional<PanelUser> findByMailId(String mailId);

    Optional<PanelUser> findByUserName(String userName);
}
