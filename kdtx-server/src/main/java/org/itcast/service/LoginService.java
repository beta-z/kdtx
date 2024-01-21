package org.itcast.service;


import org.itcast.dto.LoginDTO;
import org.itcast.entity.Code;
import org.itcast.vo.InfoResult;
import org.itcast.vo.LoginVO;

public interface LoginService {

    LoginVO login(LoginDTO dto);

    Code getCode();

    InfoResult getInfo();
}
