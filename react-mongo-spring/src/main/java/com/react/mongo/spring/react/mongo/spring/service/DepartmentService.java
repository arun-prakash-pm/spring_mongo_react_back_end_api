package com.react.mongo.spring.react.mongo.spring.service;

import com.react.mongo.spring.react.mongo.spring.model.Department;
import com.react.mongo.spring.react.mongo.spring.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }

//    public List<Department> saveDepartment(){
//        return departmentRepository.save();
//    }
//
//    public List<Department> updateDepartment(){
//        return departmentRepository.save()
//    }
//
//    public List<Department> deleteDepartment(){
//        return
//    }

}
