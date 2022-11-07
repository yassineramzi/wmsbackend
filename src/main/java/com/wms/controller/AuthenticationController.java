package com.wms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wms.service.AuthenticationService;
import com.wms.dto.JwtDTO;
import com.wms.dto.LoginRequestDTO;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        JwtDTO jwtDTO = this.authenticationService.login(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());
        return ResponseEntity.ok(jwtDTO);
    }
}
