package org.itcast.service;


import org.itcast.dto.LoginDTO;
import org.itcast.entity.Code;
import org.itcast.result.Result;

import java.util.Map;

public interface LoginService {

    Result login(LoginDTO dto);

    Code getCode();
}
