package org.itcast.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.itcast.common.NewResult;
import org.itcast.common.PageResult;
import org.itcast.common.Result;
import org.itcast.dto.user.*;
import org.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/list")
    public PageResult list(UserPageDTO dto){
        log.info("查询用户列表，参数为：{}",dto);
        return userService.list(dto);

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
//    public String get(@PathVariable Long userId){
//        return "{\n" +
//                "    \"msg\": \"操作成功\",\n" +
//                "    \"code\": 200,\n" +
//                "    \"roleIds\": [\n" +
//                "        1\n" +
//                "    ],\n" +
//                "    \"data\": {\n" +
//                "        \"createBy\": \"admin\",\n" +
//                "        \"createTime\": \"2021-03-31 03:12:10\",\n" +
//                "        \"userId\": 1,\n" +
//                "        \"deptId\": 103,\n" +
//                "        \"userName\": \"demo\",\n" +
//                "        \"nickName\": \"admin\",\n" +
//                "        \"email\": \"admin@163.com\",\n" +
//                "        \"phonenumber\": \"12000008042\",\n" +
//                "        \"sex\": \"1\",\n" +
//                "        \"avatar\": \"\",\n" +
//                "        \"status\": \"0\",\n" +
//                "        \"delFlag\": \"0\",\n" +
//                "        \"loginIp\": \"127.0.0.1\",\n" +
//                "        \"loginDate\": \"2021-03-31T03:12:10.000+0800\",\n" +
//                "        \"dept\": {\n" +
//                "            \"deptId\": 103,\n" +
//                "            \"parentId\": 101,\n" +
//                "            \"deptName\": \"研发部门\",\n" +
//                "            \"orderNum\": \"1\",\n" +
//                "            \"leader\": \"若依\",\n" +
//                "            \"status\": \"0\",\n" +
//                "            \"users\": [],\n" +
//                "            \"children\": []\n" +
//                "        },\n" +
//                "        \"roles\": [\n" +
//                "            {\n" +
//                "                \"roleId\": 1,\n" +
//                "                \"roleName\": \"超级管理员\",\n" +
//                "                \"roleKey\": \"admin\",\n" +
//                "                \"roleSort\": \"1\",\n" +
//                "                \"dataScope\": \"1\",\n" +
//                "                \"menuCheckStrictly\": false,\n" +
//                "                \"deptCheckStrictly\": false,\n" +
//                "                \"status\": \"0\",\n" +
//                "                \"flag\": false,\n" +
//                "                \"admin\": true\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"admin\": true\n" +
//                "    },\n" +
//                "    \"postIds\": [\n" +
//                "        1\n" +
//                "    ],\n" +
//                "    \"roles\": [\n" +
//                "        {\n" +
//                "            \"createTime\": \"2021-03-31 03:12:10\",\n" +
//                "            \"roleId\": 1,\n" +
//                "            \"roleName\": \"超级管理员\",\n" +
//                "            \"roleKey\": \"admin\",\n" +
//                "            \"roleSort\": \"1\",\n" +
//                "            \"dataScope\": \"1\",\n" +
//                "            \"menuCheckStrictly\": true,\n" +
//                "            \"deptCheckStrictly\": true,\n" +
//                "            \"status\": \"0\",\n" +
//                "            \"delFlag\": \"0\",\n" +
//                "            \"flag\": false,\n" +
//                "            \"admin\": true\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"createTime\": \"2021-04-15 09:23:12\",\n" +
//                "            \"roleId\": 101,\n" +
//                "            \"roleName\": \"市场专员\",\n" +
//                "            \"roleKey\": \"marketing_specialist\",\n" +
//                "            \"roleSort\": \"2\",\n" +
//                "            \"dataScope\": \"5\",\n" +
//                "            \"menuCheckStrictly\": true,\n" +
//                "            \"deptCheckStrictly\": true,\n" +
//                "            \"status\": \"0\",\n" +
//                "            \"delFlag\": \"0\",\n" +
//                "            \"flag\": false,\n" +
//                "            \"admin\": false\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"createTime\": \"2021-04-15 09:23:54\",\n" +
//                "            \"roleId\": 102,\n" +
//                "            \"roleName\": \"销售专员-商机\",\n" +
//                "            \"roleKey\": \"sales_specialist\",\n" +
//                "            \"roleSort\": \"3\",\n" +
//                "            \"dataScope\": \"5\",\n" +
//                "            \"menuCheckStrictly\": true,\n" +
//                "            \"deptCheckStrictly\": true,\n" +
//                "            \"status\": \"0\",\n" +
//                "            \"delFlag\": \"0\",\n" +
//                "            \"flag\": false,\n" +
//                "            \"admin\": false\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"createTime\": \"2021-05-24 02:44:39\",\n" +
//                "            \"roleId\": 106,\n" +
//                "            \"roleName\": \"销售主管\",\n" +
//                "            \"roleKey\": \"sales_executive\",\n" +
//                "            \"roleSort\": \"4\",\n" +
//                "            \"dataScope\": \"4\",\n" +
//                "            \"menuCheckStrictly\": true,\n" +
//                "            \"deptCheckStrictly\": true,\n" +
//                "            \"status\": \"0\",\n" +
//                "            \"delFlag\": \"0\",\n" +
//                "            \"flag\": false,\n" +
//                "            \"admin\": false\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"createTime\": \"2021-05-24 02:46:14\",\n" +
//                "            \"roleId\": 107,\n" +
//                "            \"roleName\": \"财务主管\",\n" +
//                "            \"roleKey\": \"treasurer\",\n" +
//                "            \"roleSort\": \"5\",\n" +
//                "            \"dataScope\": \"5\",\n" +
//                "            \"menuCheckStrictly\": true,\n" +
//                "            \"deptCheckStrictly\": true,\n" +
//                "            \"status\": \"0\",\n" +
//                "            \"delFlag\": \"0\",\n" +
//                "            \"flag\": false,\n" +
//                "            \"admin\": false\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"createTime\": \"2021-05-19 01:32:30\",\n" +
//                "            \"roleId\": 104,\n" +
//                "            \"roleName\": \"总经理\",\n" +
//                "            \"roleKey\": \"general_manager\",\n" +
//                "            \"roleSort\": \"6\",\n" +
//                "            \"dataScope\": \"4\",\n" +
//                "            \"menuCheckStrictly\": true,\n" +
//                "            \"deptCheckStrictly\": true,\n" +
//                "            \"status\": \"0\",\n" +
//                "            \"delFlag\": \"0\",\n" +
//                "            \"flag\": false,\n" +
//                "            \"admin\": false\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"posts\": [\n" +
//                "        {\n" +
//                "            \"createBy\": \"admin\",\n" +
//                "            \"createTime\": \"2021-03-31 03:12:10\",\n" +
//                "            \"postId\": 1,\n" +
//                "            \"postCode\": \"ceo\",\n" +
//                "            \"postName\": \"董事长\",\n" +
//                "            \"postSort\": \"1\",\n" +
//                "            \"status\": \"0\",\n" +
//                "            \"flag\": false\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"createBy\": \"admin\",\n" +
//                "            \"createTime\": \"2021-03-31 03:12:10\",\n" +
//                "            \"postId\": 2,\n" +
//                "            \"postCode\": \"se\",\n" +
//                "            \"postName\": \"项目经理\",\n" +
//                "            \"postSort\": \"2\",\n" +
//                "            \"status\": \"0\",\n" +
//                "            \"flag\": false\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"createBy\": \"admin\",\n" +
//                "            \"createTime\": \"2021-03-31 03:12:10\",\n" +
//                "            \"postId\": 3,\n" +
//                "            \"postCode\": \"hr\",\n" +
//                "            \"postName\": \"人力资源\",\n" +
//                "            \"postSort\": \"3\",\n" +
//                "            \"status\": \"0\",\n" +
//                "            \"flag\": false\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"createBy\": \"admin\",\n" +
//                "            \"createTime\": \"2021-03-31 03:12:10\",\n" +
//                "            \"postId\": 4,\n" +
//                "            \"postCode\": \"user\",\n" +
//                "            \"postName\": \"普通员工\",\n" +
//                "            \"postSort\": \"4\",\n" +
//                "            \"status\": \"0\",\n" +
//                "            \"flag\": false\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}";
//    }


    //todo 需要用到其他接口，新增用户暂时无法测试
//    @GetMapping
//    public NewResult add(){
//        log.info("新增用户所需前景");
//        return
//    }

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
    public Result updatePwd(@RequestBody UserUpdatePwdDTO dto){
        log.info("修改用户密码，参数为：{}",dto);
        return userService.updatePwd(dto);
    }

    @PutMapping("/changeStatus")
    public Result updateStatus(@RequestBody UserUpdateStatusDTO dto){
        log.info("修改用户状态，参数为：{}",dto);
        return userService.updateStatus(dto);
    }


    @PutMapping("/profile/updatePwd")
    public Result prUpdatePwd(@RequestBody PrUserUpdatePwdDTO dto){
        log.info("用户密码修改（个人），参数为：{}",dto);
        return userService.prUpdatePwd(dto);
    }

    @GetMapping("/profile")
    public Result selectProfile(){
        log.info("查询用户个人信息");
        return userService.selectProfile();
    }


    @PutMapping("/profile")
    public Result updateUserProfile(@RequestBody UserDTO dto){
        log.info("修改用户个人信息，参数为：{}",dto);
        //todo 获取当前用户id
        Long userId = null;
        dto.setUserId(userId);
        userService.updateUser(dto);
        return Result.success();
    }












}
