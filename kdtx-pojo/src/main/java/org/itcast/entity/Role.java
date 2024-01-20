package org.itcast.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    //创建时间
    private String createTime;
    //角色id
    private Integer roleId;
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
    private Boolean flag;
    //是否是超级管理员
    private Boolean admin = true;



}
