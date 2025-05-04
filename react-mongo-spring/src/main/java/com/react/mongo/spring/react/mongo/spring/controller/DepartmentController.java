package com.react.mongo.spring.react.mongo.spring.controller;

import com.react.mongo.spring.react.mongo.spring.model.Department;
import com.react.mongo.spring.react.mongo.spring.model.Employee;
import com.react.mongo.spring.react.mongo.spring.service.DepartmentService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/getAllDepartment")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String create(@RequestParam String departmentName,@RequestParam String location,
                         @RequestParam String managerName) {
        departmentService.saveDepartment(departmentName,location,managerName);
        return "Department added Successfully.";
    }
}
