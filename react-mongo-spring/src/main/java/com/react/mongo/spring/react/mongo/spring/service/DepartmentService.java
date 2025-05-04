package com.react.mongo.spring.react.mongo.spring.service;

import com.react.mongo.spring.react.mongo.spring.model.Department;
import com.react.mongo.spring.react.mongo.spring.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }

    public Department saveDepartment(String departmentName,String location, String managerName){
        Department department=new Department();
        department.setDepartmentName(departmentName);
        department.setLocation(location);
        department.setManagerName(managerName);
        return departmentRepository.save(department);
    }

//    public List<Department> updateDepartment(){
//        return departmentRepository.save()
//    }
//
//    public List<Department> deleteDepartment(){
//        return
//    }

}
