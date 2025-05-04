package com.react.mongo.spring.react.mongo.spring.repository;

import com.react.mongo.spring.react.mongo.spring.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department,String> {
}
