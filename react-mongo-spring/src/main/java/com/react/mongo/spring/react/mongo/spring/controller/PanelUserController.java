package com.react.mongo.spring.react.mongo.spring.controller;

import com.react.mongo.spring.react.mongo.spring.model.PanelUser;
import com.react.mongo.spring.react.mongo.spring.repository.PanelUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/panel_user")
@RequiredArgsConstructor
public class PanelUserController {
    private final PanelUserRepository panelUserRepository;
    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<PanelUser> getPanelUserList(){
       return panelUserRepository.findAll();
    }
}
