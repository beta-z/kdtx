package org.itcast.dto.role;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {



    //创建人
    private String createBy;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    //数据范围
    private String dataScope;
    //删除标志
    private String delFlag; //0存在，2删除
    //角色名称
    private String roleName;
    //权限字符
    private String roleKey;
    //角色顺序
    private String rolesort;
    //状态
    private String status;
    //菜单id
    private List<Long> menuIds;
    //部门id
    private List<Long> deptIds;
    //
    private Boolean menuCheckStrictly;
    //
    private Boolean deptCheckStrictly;
    //备注
    private String remark;

    private Boolean admin = true;


}
