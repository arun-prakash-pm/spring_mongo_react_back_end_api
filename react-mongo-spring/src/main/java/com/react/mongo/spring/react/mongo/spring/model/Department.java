package com.react.mongo.spring.react.mongo.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "department")
public class Department {
    @Id
    private String Id;
    private String departmentName;
    private String location;
    private String managerName;
}
