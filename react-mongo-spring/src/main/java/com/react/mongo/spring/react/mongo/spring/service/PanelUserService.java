package com.react.mongo.spring.react.mongo.spring.service;

import com.react.mongo.spring.react.mongo.spring.model.PanelUser;
import com.react.mongo.spring.react.mongo.spring.model.RequestPanelUser;
import com.react.mongo.spring.react.mongo.spring.repository.PanelUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PanelUserService{

    private final PanelUserRepository panelUserRepository;
    private  final PasswordEncoder passwordEncoder;

    public String createPanelUser(RequestPanelUser requestPanelUser){
        PanelUser panelUser=new PanelUser();
        panelUser.setUserName(requestPanelUser.getUserName());
       // panelUser.setLastName(requestPanelUser.getLastName());
        panelUser.setMailId(passwordEncoder.encode(requestPanelUser.getPassword()));
        panelUser.setRolesList(requestPanelUser.getRolesList());
        panelUserRepository.save(panelUser);
        return "User created successfully.";
    };

}
