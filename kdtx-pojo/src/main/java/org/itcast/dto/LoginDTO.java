package org.itcast.dto;

import lombok.Data;

@Data
public class LoginDTO {
    String username;
    String password;
    String uuid;
    String code;
}
