package org.itcast.controller;



import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import org.itcast.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Api(tags = "统计分析")
public class StatisticsController {





    @ApiOperation("线索统计")
    @GetMapping("/report/getVulnerabilityMap")
    public Result leadStstistic(){
        return Result.success();

    }
}
