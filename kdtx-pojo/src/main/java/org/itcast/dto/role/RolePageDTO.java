package org.itcast.dto.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePageDTO {

    private Integer pageNum;
    private Integer pageSize;

    //角色名称
    private String roleName;
    //权限字符
    private String roleKey;
    //状态
    private String status; //0正常，1停用
    //创建时间-起始
    private LocalDateTime begin;
    //创建时间-截止
    private LocalDateTime end;



}
