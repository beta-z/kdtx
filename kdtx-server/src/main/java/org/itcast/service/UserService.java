package org.itcast.service;

import org.itcast.common.NewResult;
import org.itcast.common.PageResult;
import org.itcast.common.Result;
import org.itcast.dto.UserDTO;
import org.itcast.dto.UserPageDTO;
import org.itcast.dto.UserUpdatePasswordDTO;
import org.itcast.vo.UserListSelectVO;

public interface UserService {

    /**
     * 查询用户列表
     *
     * @param dto 请求参数
     * @return 用户信息
     */
    PageResult list(UserPageDTO dto);

    /**
     * 获取用户下拉列表
     *
     * @param deptId 部门id
     * @return
     */
    Result listselect(Long deptId);

    /**
     * 查询用户详细
     *
     * @param userId 用户id
     * @return
     */
    NewResult getUserId(Long userId);

    /**
     * 新增用户
     *
     * @param dto 用户数据
     * @return
     */
    Result addUser(UserDTO dto);

    /**
     * 修改用户
     *
     * @param dto 用户新数据
     * @return
     */
    Result updateUser(UserDTO dto);

    /**
     * 删除用户
     *
     * @param userId
     */
    Result deleteUser(Long userId);

    /**
     * 修改用户密码
     *
     * @param dto 用户id和新密码
     * @return
     */
    Result updatePwd(UserUpdatePasswordDTO dto);
}
