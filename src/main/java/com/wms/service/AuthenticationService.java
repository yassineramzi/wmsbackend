package com.wms.service;

import com.wms.service.dto.JwtDTO;

public interface AuthenticationService {
    JwtDTO login(String login, String password);
}
