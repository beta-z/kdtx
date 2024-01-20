package org.itcast.dto.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    //角色名称
    private String roleName;
    //权限字符
    private String roleKey;
    //角色顺序
    private String rolesort;
    //状态
    private String status;
    //菜单权限

    //备注
    private String remark;


}
