package com.react.mongo.spring.react.mongo.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestPanelUser {
    private String userName;
    //private String lastName;
    private String mailId;
    private String password;
    private List<Roles> rolesList;
}
