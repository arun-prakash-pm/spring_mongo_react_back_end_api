package com.react.mongo.spring.react.mongo.spring.securityConfig;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.react.mongo.spring.react.mongo.spring.model.PanelUser;
import com.react.mongo.spring.react.mongo.spring.model.Roles;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class PanelUserImpl implements UserDetails {

    private String id;
    private String userName;
    private String mailId;

    @JsonIgnore
    private String password;

    private List<GrantedAuthority> authorities;


    public PanelUserImpl(String id, String userName, String mailId, String password, List<GrantedAuthority> authorities) {
        this.id = id;
        this.userName = userName;
        this.mailId = mailId;
        this.password = password;
        this.authorities = authorities;
    }


    public static PanelUserImpl build(PanelUser user) {
        List<GrantedAuthority> authorities = user.getRolesList().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name().toUpperCase()))
                .collect(Collectors.toList());

        return new PanelUserImpl(
                user.getId(),
                user.getUserName(),
                user.getMailId(),
                user.getPassword(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return mailId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
