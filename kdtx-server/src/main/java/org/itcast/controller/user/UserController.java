package org.itcast.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.itcast.common.NewResult;
import org.itcast.common.PageResult;
import org.itcast.common.Result;
import org.itcast.dto.UserDTO;
import org.itcast.dto.UserPageDTO;
import org.itcast.dto.UserUpdatePasswordDTO;
import org.itcast.service.UserService;
import org.itcast.vo.UserListSelectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/list")
    public Result list(UserPageDTO dto){
        log.info("查询用户列表，参数为：{}",dto);
        PageResult pageResult = userService.list(dto);

        return  Result.success(pageResult);
    }

    @GetMapping("/listselect")
    public Result listselect(Long deptId){
        log.info("获取用户下拉列表，参数为：{}",deptId);
        return userService.listselect(deptId);

    }

    @GetMapping("{userId}")
    public NewResult getUserId(@PathVariable Long userId){
        log.info("查询用户详细，参数为：{}",userId);
        return userService.getUserId(userId);
    }


    @PostMapping
    public Result addUser(@RequestBody UserDTO dto){
        log.info("新增用户，参数为：{}",dto);
        return userService.addUser(dto);
    }

    @PutMapping
    public Result updateUser(@RequestBody UserDTO dto){
        log.info("修改用户，参数为：{}",dto);
        return userService.updateUser(dto);
    }

    @DeleteMapping("{userId}")
    public Result deleteUser(@PathVariable Long userId){
        log.info("删除用户，参数为：{}",userId);
      return userService.deleteUser(userId);
    }

    @PutMapping("/resetPwd")
    public Result updatePwd(@RequestBody UserUpdatePasswordDTO dto){
        log.info("修改用户密码，参数为：{}",dto);
        return userService.updatePwd(dto);
    }












}
