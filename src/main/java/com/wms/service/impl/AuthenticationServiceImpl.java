package com.wms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.wms.service.AuthenticationService;
import com.wms.service.dto.JwtDTO;
import com.wms.service.dto.security.UserDetailsImpl;
import com.wms.utils.JwtUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private AuthenticationManager authenticationManager;

    private JwtUtils jwtUtils;

    @Autowired
    public AuthenticationServiceImpl(
            AuthenticationManager authenticationManager,
            JwtUtils jwtUtils
    ){
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public JwtDTO login(String login, String password) {
        Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = this.jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return new JwtDTO(
                jwt,
                "Bearer",
                userDetails.getId(),
                userDetails.getUsername(),
                roles
                );
    }
}
