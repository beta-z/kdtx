package org.itcast.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    //更新人
    private String updateBy;
    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    //创建人
    private String createBy;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    //角色id
    private Long roleId;
    //角色名称
    private String roleName;
    //角色权限字符串
    private String roleKey;
    //显示顺序
    private String roleSort;
    //数据范围
    private String dataScope; //数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
    //菜单树选择项是否关联显示
    private Boolean menuCheckStrictly;
    //部门树选择项是否关联显示
    private Boolean deptCheckStrictly;
    //状态
    private String status; //0正常，1停用
    //删除标志
    private String delFlag; //0存在，2删除
    //标志
    private Boolean flag = false;
    //是否是超级管理员
    private Boolean admin = true;
    //备注
    private String remark;



}
