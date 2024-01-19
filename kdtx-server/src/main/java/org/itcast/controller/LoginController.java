package org.itcast.controller;

import org.itcast.context.BaseContext;
import org.itcast.dto.LoginDTO;
import org.itcast.entity.Code;
import org.itcast.vo.LoginVO;
import org.itcast.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping("/login")
    public LoginVO login(@RequestBody LoginDTO dto){
        return loginService.login(dto);
    }
    @GetMapping("/captchaImage")
    public Code getCode(){
       return loginService.getCode();
    }
    @GetMapping("getInfo")
    public String getInfo(){
        Long id = BaseContext.getCurrentId();

        return "{\n" +
                "    \"msg\": \"操作成功\",\n" +
                "    \"code\": 200,\n" +
                "    \"permissions\": [\n" +
                "        \"*:*:*\"\n" +
                "    ],\n" +
                "    \"roles\": [\n" +
                "        \"admin\"\n" +
                "    ],\n" +
                "    \"user\": {\n" +
                "        \"createBy\": \"admin\",\n" +
                "        \"createTime\": \"2021-03-31 03:12:10\",\n" +
                "        \"userId\": 1,\n" +
                "        \"deptId\": 103,\n" +
                "        \"userName\": \"demo\",\n" +
                "        \"nickName\": \"admin\",\n" +
                "        \"email\": \"admin@163.com\",\n" +
                "        \"phonenumber\": \"12000008042\",\n" +
                "        \"sex\": \"1\",\n" +
                "        \"avatar\": \"\",\n" +
                "        \"status\": \"0\",\n" +
                "        \"delFlag\": \"0\",\n" +
                "        \"loginIp\": \"127.0.0.1\",\n" +
                "        \"loginDate\": \"2021-03-31T03:12:10.000+0800\",\n" +
                "        \"dept\": {\n" +
                "            \"deptId\": 103,\n" +
                "            \"parentId\": 101,\n" +
                "            \"deptName\": \"研发部门\",\n" +
                "            \"orderNum\": \"1\",\n" +
                "            \"leader\": \"若依\",\n" +
                "            \"status\": \"0\",\n" +
                "            \"users\": [],\n" +
                "            \"children\": []\n" +
                "        },\n" +
                "        \"roles\": [\n" +
                "            {\n" +
                "                \"roleId\": 1,\n" +
                "                \"roleName\": \"超级管理员\",\n" +
                "                \"roleKey\": \"admin\",\n" +
                "                \"roleSort\": \"1\",\n" +
                "                \"dataScope\": \"1\",\n" +
                "                \"menuCheckStrictly\": false,\n" +
                "                \"deptCheckStrictly\": false,\n" +
                "                \"status\": \"0\",\n" +
                "                \"flag\": false,\n" +
                "                \"admin\": true\n" +
                "            }\n" +
                "        ],\n" +
                "        \"admin\": true\n" +
                "    }\n" +
                "}";
    }


    /**
     * 获取路由信息
     *
     * @return 路由信息
     */

    @GetMapping("getRouters")
    public String getRouters() {
        return "{\"msg\":\"操作成功\",\"code\":200,\"data\":[{\"path\":\"/\",\"hidden\":false,\"component\":\"Layout\",\"meta\":{\"title\":\"线索管理\",\"icon\":\"icon_menu_xsgl\",\"noCache\":false},\"children\":[{\"name\":\"Clue\",\"path\":\"clue\",\"hidden\":false,\"component\":\"clues/clue/index\",\"meta\":{\"title\":\"线索管理\",\"icon\":\"icon_menu_xsgl\",\"noCache\":false}}]},{\"path\":\"/\",\"hidden\":false,\"component\":\"Layout\",\"meta\":{\"title\":\"商机管理\",\"icon\":\"icon_menu_sjgl\",\"noCache\":false},\"children\":[{\"name\":\"Business\",\"path\":\"business\",\"hidden\":false,\"component\":\"clues/business/index\",\"meta\":{\"title\":\"商机管理\",\"icon\":\"icon_menu_sjgl\",\"noCache\":false}}]},{\"path\":\"/\",\"hidden\":false,\"component\":\"Layout\",\"meta\":{\"title\":\"合同管理\",\"icon\":\"icon_menu_htgl\",\"noCache\":false},\"children\":[{\"name\":\"Contract\",\"path\":\"contract\",\"hidden\":false,\"component\":\"clues/contract/index\",\"meta\":{\"title\":\"合同管理\",\"icon\":\"icon_menu_htgl\",\"noCache\":false}}]},{\"path\":\"/\",\"hidden\":false,\"component\":\"Layout\",\"meta\":{\"title\":\"活动管理\",\"icon\":\"icon_menu_hdgl\",\"noCache\":false},\"children\":[{\"name\":\"Activity\",\"path\":\"activity\",\"hidden\":false,\"component\":\"clues/activity/index\",\"meta\":{\"title\":\"活动管理\",\"icon\":\"icon_menu_hdgl\",\"noCache\":false}}]},{\"path\":\"/\",\"hidden\":false,\"component\":\"Layout\",\"meta\":{\"title\":\"课程管理\",\"icon\":\"icon_menu_kcgl\",\"noCache\":false},\"children\":[{\"name\":\"Course\",\"path\":\"course\",\"hidden\":false,\"component\":\"clues/course/index\",\"meta\":{\"title\":\"课程管理\",\"icon\":\"icon_menu_kcgl\",\"noCache\":false}}]},{\"path\":\"/\",\"hidden\":false,\"component\":\"Layout\",\"meta\":{\"title\":\"统计分析\",\"icon\":\"icon_menu_tjfx\",\"noCache\":false},\"children\":[{\"name\":\"/countAnalysis\",\"path\":\"/countAnalysis\",\"hidden\":false,\"component\":\"clues/countAnalysis/index\",\"meta\":{\"title\":\"统计分析\",\"icon\":\"icon_menu_tjfx\",\"noCache\":false}}]},{\"path\":\"/\",\"hidden\":false,\"component\":\"Layout\",\"meta\":{\"title\":\"转派管理\",\"icon\":\"example\",\"noCache\":false},\"children\":[{\"name\":\"/transferManage\",\"path\":\"/transferManage\",\"hidden\":false,\"component\":\"clues/transferManage/index\",\"meta\":{\"title\":\"转派管理\",\"icon\":\"example\",\"noCache\":false}}]},{\"name\":\"System\",\"path\":\"/system\",\"hidden\":false,\"redirect\":\"noRedirect\",\"component\":\"Layout\",\"alwaysShow\":true,\"meta\":{\"title\":\"系统管理\",\"icon\":\"icon_menu_xtgl\",\"noCache\":false},\"children\":[{\"name\":\"Notice\",\"path\":\"notice\",\"hidden\":false,\"component\":\"system/notice/index\",\"meta\":{\"title\":\"通知公告\",\"icon\":\"icon_menu_tzzx\",\"noCache\":false}},{\"name\":\"Permission\",\"path\":\"permission\",\"hidden\":false,\"redirect\":\"noRedirect\",\"component\":\"ParentView\",\"alwaysShow\":true,\"meta\":{\"title\":\"权限管理\",\"icon\":\"icon_menu_qxgl\",\"noCache\":false},\"children\":[{\"name\":\"User\",\"path\":\"user\",\"hidden\":false,\"component\":\"system/user/index\",\"meta\":{\"title\":\"用户管理\",\"icon\":\"user\",\"noCache\":false}},{\"name\":\"Role\",\"path\":\"role\",\"hidden\":false,\"component\":\"system/role/index\",\"meta\":{\"title\":\"角色管理\",\"icon\":\"peoples\",\"noCache\":false}},{\"name\":\"Menu\",\"path\":\"menu\",\"hidden\":false,\"component\":\"system/menu/index\",\"meta\":{\"title\":\"菜单管理\",\"icon\":\"tree-table\",\"noCache\":false}},{\"name\":\"Dept\",\"path\":\"dept\",\"hidden\":false,\"component\":\"system/dept/index\",\"meta\":{\"title\":\"部门管理\",\"icon\":\"tree\",\"noCache\":false}},{\"name\":\"Post\",\"path\":\"post\",\"hidden\":false,\"component\":\"system/post/index\",\"meta\":{\"title\":\"岗位管理\",\"icon\":\"post\",\"noCache\":false}}]},{\"name\":\"Dict\",\"path\":\"dict\",\"hidden\":false,\"component\":\"system/dict/index\",\"meta\":{\"title\":\"字典管理\",\"icon\":\"icon_menu_zdgl\",\"noCache\":false}},{\"name\":\"Clew\",\"path\":\"clew\",\"hidden\":false,\"component\":\"system/clew/index\",\"meta\":{\"title\":\"线索配置\",\"icon\":\"icon_menu_xspz\",\"noCache\":false}},{\"name\":\"Opportunity\",\"path\":\"opportunity\",\"hidden\":false,\"component\":\"system/opportunity/index\",\"meta\":{\"title\":\"商机配置\",\"icon\":\"icon_menu_sjpz\",\"noCache\":false}},{\"name\":\"NoticeCenter\",\"path\":\"noticeCenter\",\"hidden\":false,\"component\":\"system/noticeCenter/index\",\"meta\":{\"title\":\"通知中心\",\"icon\":\"icon_menu_tzzx\",\"noCache\":false}},{\"name\":\"Log\",\"path\":\"log\",\"hidden\":true,\"redirect\":\"noRedirect\",\"component\":\"ParentView\",\"alwaysShow\":true,\"meta\":{\"title\":\"日志管理\",\"icon\":\"log\",\"noCache\":false},\"children\":[{\"name\":\"Operlog\",\"path\":\"operlog\",\"hidden\":false,\"component\":\"monitor/operlog/index\",\"meta\":{\"title\":\"操作日志\",\"icon\":\"form\",\"noCache\":false}},{\"name\":\"Logininfor\",\"path\":\"logininfor\",\"hidden\":false,\"component\":\"monitor/logininfor/index\",\"meta\":{\"title\":\"登录日志\",\"icon\":\"logininfor\",\"noCache\":false}}]},{\"name\":\"SystemLog\",\"path\":\"systemLog\",\"hidden\":false,\"component\":\"system/systemLog/index\",\"meta\":{\"title\":\"系统日志\",\"icon\":\"icon_menu_xtrz\",\"noCache\":false}}]}]}";
    }
}
