package com.react.mongo.spring.react.mongo.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Document(collection="panel_user")
@NoArgsConstructor
@AllArgsConstructor
public class PanelUser{
    @Id
    private String id;
    private String userName;
    private String mailId;
    private String password;
    private List<Roles> rolesList;


}
