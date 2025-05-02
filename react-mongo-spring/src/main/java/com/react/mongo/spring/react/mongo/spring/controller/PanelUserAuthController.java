package com.react.mongo.spring.react.mongo.spring.controller;

import com.react.mongo.spring.react.mongo.spring.model.PanelUser;
import com.react.mongo.spring.react.mongo.spring.model.RequestPanelUser;
import com.react.mongo.spring.react.mongo.spring.model.Roles;
import com.react.mongo.spring.react.mongo.spring.repository.PanelUserRepository;
import com.react.mongo.spring.react.mongo.spring.securityConfig.CustomUserDetailsService;
import com.react.mongo.spring.react.mongo.spring.securityConfig.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/panel_user/auth")
@RequiredArgsConstructor
@CrossOrigin
public class PanelUserAuthController {


    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;
    private final PanelUserRepository panelUserRepository;
    private final PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RequestPanelUser request) {
        if (panelUserRepository.findByUserName(request.getUserName()).isPresent()) {
            return ResponseEntity.status(400).body("Username already exists");
        }

        // Encode the password
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        PanelUser newUser = new PanelUser();
        newUser.setUserName(request.getUserName());
        newUser.setMailId(request.getMailId());
        newUser.setPassword(encodedPassword);
        newUser.setRolesList(List.of(request.getRolesList().toArray(new Roles[0]))); // default role

        panelUserRepository.save(newUser);

        return ResponseEntity.ok("User registered successfully");
    }



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RequestPanelUser request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getMailId(), request.getPassword())
            );
            UserDetails user = customUserDetailsService.loadUserByUsername(request.getMailId());
            String jwtToken = jwtService.generateToken(user);
            Map<String, Object> data = new HashMap<>();
            data.put("token", jwtToken);
            return ResponseEntity.ok(data);
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
}
