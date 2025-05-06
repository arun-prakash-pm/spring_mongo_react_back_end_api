package com.react.mongo.spring.react.mongo.spring.securityConfig;

import com.react.mongo.spring.react.mongo.spring.model.PanelUser;
import com.react.mongo.spring.react.mongo.spring.repository.PanelUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PanelUserRepository panelUserRepository;

    public CustomUserDetailsService(PanelUserRepository panelUserRepository) {
        this.panelUserRepository = panelUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PanelUser user = panelUserRepository.findByMailId(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));

        return PanelUserImpl.build(user);
    }
}
