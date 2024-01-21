package org.itcast.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itcast.entity.User;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoResult {
    String msg;
    Integer code;
    List<String> roles;
    User user;
}
