package com.react.mongo.spring.react.mongo.spring.repository;

import com.react.mongo.spring.react.mongo.spring.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,String> {
}
