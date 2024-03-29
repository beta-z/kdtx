package org.itcast.controller;

import org.itcast.common.Result;
import org.itcast.context.BaseContext;
import org.itcast.dto.LoginDTO;
import org.itcast.entity.Code;
import org.itcast.vo.InfoResult;
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
    @GetMapping("/getInfo")
    public InfoResult getInfo(){

        return loginService.getInfo();

    }


    /**
     * 获取路由信息
     *
     * @return 路由信息
     */

    @GetMapping("/getRouters")
    public String getRouters() {
        return "{\n" +
                "    \"msg\": \"操作成功\",\n" +
                "    \"code\": 200,\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"path\": \"/\",\n" +
                "            \"hidden\": false,\n" +
                "            \"component\": \"Layout\",\n" +
                "            \"meta\": {\n" +
                "                \"title\": \"线索管理\",\n" +
                "                \"icon\": \"icon_menu_xsgl\",\n" +
                "                \"noCache\": false\n" +
                "            },\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"name\": \"Clue\",\n" +
                "                    \"path\": \"clue\",\n" +
                "                    \"hidden\": false,\n" +
                "                    \"component\": \"clues/clue/index\",\n" +
                "                    \"meta\": {\n" +
                "                        \"title\": \"线索管理\",\n" +
                "                        \"icon\": \"icon_menu_xsgl\",\n" +
                "                        \"noCache\": false\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"path\": \"/\",\n" +
                "            \"hidden\": false,\n" +
                "            \"component\": \"Layout\",\n" +
                "            \"meta\": {\n" +
                "                \"title\": \"商机管理\",\n" +
                "                \"icon\": \"icon_menu_sjgl\",\n" +
                "                \"noCache\": false\n" +
                "            },\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"name\": \"Business\",\n" +
                "                    \"path\": \"business\",\n" +
                "                    \"hidden\": false,\n" +
                "                    \"component\": \"clues/business/index\",\n" +
                "                    \"meta\": {\n" +
                "                        \"title\": \"商机管理\",\n" +
                "                        \"icon\": \"icon_menu_sjgl\",\n" +
                "                        \"noCache\": false\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"path\": \"/\",\n" +
                "            \"hidden\": false,\n" +
                "            \"component\": \"Layout\",\n" +
                "            \"meta\": {\n" +
                "                \"title\": \"合同管理\",\n" +
                "                \"icon\": \"icon_menu_htgl\",\n" +
                "                \"noCache\": false\n" +
                "            },\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"name\": \"Contract\",\n" +
                "                    \"path\": \"contract\",\n" +
                "                    \"hidden\": false,\n" +
                "                    \"component\": \"clues/contract/index\",\n" +
                "                    \"meta\": {\n" +
                "                        \"title\": \"合同管理\",\n" +
                "                        \"icon\": \"icon_menu_htgl\",\n" +
                "                        \"noCache\": false\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"path\": \"/\",\n" +
                "            \"hidden\": false,\n" +
                "            \"component\": \"Layout\",\n" +
                "            \"meta\": {\n" +
                "                \"title\": \"活动管理\",\n" +
                "                \"icon\": \"icon_menu_hdgl\",\n" +
                "                \"noCache\": false\n" +
                "            },\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"name\": \"TbActivity\",\n" +
                "                    \"path\": \"activity\",\n" +
                "                    \"hidden\": false,\n" +
                "                    \"component\": \"clues/activity/index\",\n" +
                "                    \"meta\": {\n" +
                "                        \"title\": \"活动管理\",\n" +
                "                        \"icon\": \"icon_menu_hdgl\",\n" +
                "                        \"noCache\": false\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"path\": \"/\",\n" +
                "            \"hidden\": false,\n" +
                "            \"component\": \"Layout\",\n" +
                "            \"meta\": {\n" +
                "                \"title\": \"课程管理\",\n" +
                "                \"icon\": \"icon_menu_kcgl\",\n" +
                "                \"noCache\": false\n" +
                "            },\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"name\": \"Course\",\n" +
                "                    \"path\": \"course\",\n" +
                "                    \"hidden\": false,\n" +
                "                    \"component\": \"clues/course/index\",\n" +
                "                    \"meta\": {\n" +
                "                        \"title\": \"课程管理\",\n" +
                "                        \"icon\": \"icon_menu_kcgl\",\n" +
                "                        \"noCache\": false\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"path\": \"/\",\n" +
                "            \"hidden\": false,\n" +
                "            \"component\": \"Layout\",\n" +
                "            \"meta\": {\n" +
                "                \"title\": \"统计分析\",\n" +
                "                \"icon\": \"icon_menu_tjfx\",\n" +
                "                \"noCache\": false\n" +
                "            },\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"name\": \"/countAnalysis\",\n" +
                "                    \"path\": \"/countAnalysis\",\n" +
                "                    \"hidden\": false,\n" +
                "                    \"component\": \"clues/countAnalysis/index\",\n" +
                "                    \"meta\": {\n" +
                "                        \"title\": \"统计分析\",\n" +
                "                        \"icon\": \"icon_menu_tjfx\",\n" +
                "                        \"noCache\": false\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"path\": \"/\",\n" +
                "            \"hidden\": false,\n" +
                "            \"component\": \"Layout\",\n" +
                "            \"meta\": {\n" +
                "                \"title\": \"转派管理\",\n" +
                "                \"icon\": \"example\",\n" +
                "                \"noCache\": false\n" +
                "            },\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"name\": \"/transferManage\",\n" +
                "                    \"path\": \"/transferManage\",\n" +
                "                    \"hidden\": false,\n" +
                "                    \"component\": \"clues/transferManage/index\",\n" +
                "                    \"meta\": {\n" +
                "                        \"title\": \"转派管理\",\n" +
                "                        \"icon\": \"example\",\n" +
                "                        \"noCache\": false\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"System\",\n" +
                "            \"path\": \"/system\",\n" +
                "            \"hidden\": false,\n" +
                "            \"redirect\": \"noRedirect\",\n" +
                "            \"component\": \"Layout\",\n" +
                "            \"alwaysShow\": true,\n" +
                "            \"meta\": {\n" +
                "                \"title\": \"系统管理\",\n" +
                "                \"icon\": \"icon_menu_xtgl\",\n" +
                "                \"noCache\": false\n" +
                "            },\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"name\": \"Notice\",\n" +
                "                    \"path\": \"notice\",\n" +
                "                    \"hidden\": false,\n" +
                "                    \"component\": \"system/notice/index\",\n" +
                "                    \"meta\": {\n" +
                "                        \"title\": \"通知公告\",\n" +
                "                        \"icon\": \"icon_menu_tzzx\",\n" +
                "                        \"noCache\": false\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"Permission\",\n" +
                "                    \"path\": \"permission\",\n" +
                "                    \"hidden\": false,\n" +
                "                    \"redirect\": \"noRedirect\",\n" +
                "                    \"component\": \"ParentView\",\n" +
                "                    \"alwaysShow\": true,\n" +
                "                    \"meta\": {\n" +
                "                        \"title\": \"权限管理\",\n" +
                "                        \"icon\": \"icon_menu_qxgl\",\n" +
                "                        \"noCache\": false\n" +
                "                    },\n" +
                "                    \"children\": [\n" +
                "                        {\n" +
                "                            \"name\": \"User\",\n" +
                "                            \"path\": \"user\",\n" +
                "                            \"hidden\": false,\n" +
                "                            \"component\": \"system/user/index\",\n" +
                "                            \"meta\": {\n" +
                "                                \"title\": \"用户管理\",\n" +
                "                                \"icon\": \"user\",\n" +
                "                                \"noCache\": false\n" +
                "                            }\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"name\": \"Role\",\n" +
                "                            \"path\": \"role\",\n" +
                "                            \"hidden\": false,\n" +
                "                            \"component\": \"system/role/index\",\n" +
                "                            \"meta\": {\n" +
                "                                \"title\": \"角色管理\",\n" +
                "                                \"icon\": \"peoples\",\n" +
                "                                \"noCache\": false\n" +
                "                            }\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"name\": \"Menu\",\n" +
                "                            \"path\": \"menu\",\n" +
                "                            \"hidden\": false,\n" +
                "                            \"component\": \"system/menu/index\",\n" +
                "                            \"meta\": {\n" +
                "                                \"title\": \"菜单管理\",\n" +
                "                                \"icon\": \"tree-table\",\n" +
                "                                \"noCache\": false\n" +
                "                            }\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"name\": \"Dept\",\n" +
                "                            \"path\": \"dept\",\n" +
                "                            \"hidden\": false,\n" +
                "                            \"component\": \"system/dept/index\",\n" +
                "                            \"meta\": {\n" +
                "                                \"title\": \"部门管理\",\n" +
                "                                \"icon\": \"tree\",\n" +
                "                                \"noCache\": false\n" +
                "                            }\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"name\": \"Post\",\n" +
                "                            \"path\": \"post\",\n" +
                "                            \"hidden\": false,\n" +
                "                            \"component\": \"system/post/index\",\n" +
                "                            \"meta\": {\n" +
                "                                \"title\": \"岗位管理\",\n" +
                "                                \"icon\": \"post\",\n" +
                "                                \"noCache\": false\n" +
                "                            }\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"Dict\",\n" +
                "                    \"path\": \"dict\",\n" +
                "                    \"hidden\": false,\n" +
                "                    \"component\": \"system/dict/index\",\n" +
                "                    \"meta\": {\n" +
                "                        \"title\": \"字典管理\",\n" +
                "                        \"icon\": \"icon_menu_zdgl\",\n" +
                "                        \"noCache\": false\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"Clew\",\n" +
                "                    \"path\": \"clew\",\n" +
                "                    \"hidden\": false,\n" +
                "                    \"component\": \"system/clew/index\",\n" +
                "                    \"meta\": {\n" +
                "                        \"title\": \"线索配置\",\n" +
                "                        \"icon\": \"icon_menu_xspz\",\n" +
                "                        \"noCache\": false\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"Opportunity\",\n" +
                "                    \"path\": \"opportunity\",\n" +
                "                    \"hidden\": false,\n" +
                "                    \"component\": \"system/opportunity/index\",\n" +
                "                    \"meta\": {\n" +
                "                        \"title\": \"商机配置\",\n" +
                "                        \"icon\": \"icon_menu_sjpz\",\n" +
                "                        \"noCache\": false\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"NoticeCenter\",\n" +
                "                    \"path\": \"noticeCenter\",\n" +
                "                    \"hidden\": false,\n" +
                "                    \"component\": \"system/noticeCenter/index\",\n" +
                "                    \"meta\": {\n" +
                "                        \"title\": \"通知中心\",\n" +
                "                        \"icon\": \"icon_menu_tzzx\",\n" +
                "                        \"noCache\": false\n" +
                "                    }\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"Log\",\n" +
                "                    \"path\": \"log\",\n" +
                "                    \"hidden\": true,\n" +
                "                    \"redirect\": \"noRedirect\",\n" +
                "                    \"component\": \"ParentView\",\n" +
                "                    \"alwaysShow\": true,\n" +
                "                    \"meta\": {\n" +
                "                        \"title\": \"日志管理\",\n" +
                "                        \"icon\": \"log\",\n" +
                "                        \"noCache\": false\n" +
                "                    },\n" +
                "                    \"children\": [\n" +
                "                        {\n" +
                "                            \"name\": \"Operlog\",\n" +
                "                            \"path\": \"operlog\",\n" +
                "                            \"hidden\": false,\n" +
                "                            \"component\": \"monitor/operlog/index\",\n" +
                "                            \"meta\": {\n" +
                "                                \"title\": \"操作日志\",\n" +
                "                                \"icon\": \"form\",\n" +
                "                                \"noCache\": false\n" +
                "                            }\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"name\": \"Logininfor\",\n" +
                "                            \"path\": \"logininfor\",\n" +
                "                            \"hidden\": false,\n" +
                "                            \"component\": \"monitor/logininfor/index\",\n" +
                "                            \"meta\": {\n" +
                "                                \"title\": \"登录日志\",\n" +
                "                                \"icon\": \"logininfor\",\n" +
                "                                \"noCache\": false\n" +
                "                            }\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"SystemLog\",\n" +
                "                    \"path\": \"systemLog\",\n" +
                "                    \"hidden\": false,\n" +
                "                    \"component\": \"system/systemLog/index\",\n" +
                "                    \"meta\": {\n" +
                "                        \"title\": \"系统日志\",\n" +
                "                        \"icon\": \"icon_menu_xtrz\",\n" +
                "                        \"noCache\": false\n" +
                "                    }\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }
}
