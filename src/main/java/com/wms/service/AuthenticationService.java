package com.wms.service;

import com.wms.dto.JwtDTO;

public interface AuthenticationService {
    JwtDTO login(String login, String password);
}
