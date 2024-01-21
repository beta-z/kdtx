package org.itcast.controller;


import com.github.pagehelper.PageHelper;
import org.itcast.common.AjaxResult;
import org.itcast.common.Result;
import org.itcast.dto.ActivityDTO;
import org.itcast.dto.ClueStatisticsDTO;
import org.itcast.dto.StatisticsDTO;
import org.itcast.service.StatisticsService;
import org.itcast.vo.LineChartVO;
import org.itcast.vo.LineSeriesVO;
import org.itcast.vo.StatisticsVO;
import org.itcast.vo.VulnerabilityMapVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 线索统计
 */
@RestController
@RequestMapping("/report")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;


    /**
     * 客户统计图
     */

    @GetMapping("/contractStatistics/{beginCreateTime}/{endCreateTime}")
    public LineChartVO contractStatistics(@PathVariable String beginCreateTime, @PathVariable String endCreateTime){
        return statisticsService.contractStatistics(beginCreateTime,endCreateTime);
    }


    /**
     * 活动渠道统计
     * @param
     * @return
     */
    @GetMapping("/activityStatisticsList")
    public StatisticsVO activityStatisticsList(ActivityDTO dto){
        return statisticsService.activityStatisticsList(dto);
    }
    /**
     * 渠道统计图
     */
    @GetMapping("/activityStatistics/{beginCreateTime}/{endCreateTime}")
    public String bbb(){
        return "{\n" +
                "    \"xAxis\": [\n" +
                "        \"2024-01-13\",\n" +
                "        \"2024-01-14\",\n" +
                "        \"2024-01-15\",\n" +
                "        \"2024-01-16\",\n" +
                "        \"2024-01-17\",\n" +
                "        \"2024-01-18\",\n" +
                "        \"2024-01-19\",\n" +
                "        \"2024-01-20\"\n" +
                "    ],\n" +
                "    \"series\": [\n" +
                "        {\n" +
                "            \"name\": \"新增客户数\",\n" +
                "            \"data\": [\n" +
                "                0,\n" +
                "                0,\n" +
                "                0,\n" +
                "                0,\n" +
                "                0,\n" +
                "                0,\n" +
                "                0,\n" +
                "                0\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"客户总数\",\n" +
                "            \"data\": [\n" +
                "                0,\n" +
                "                0,\n" +
                "                0,\n" +
                "                0,\n" +
                "                0,\n" +
                "                0,\n" +
                "                0,\n" +
                "                0\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }




    /**
     * 客户列表查询
     *
     * @return
     */
    @GetMapping("/contractStatisticsList")
    public StatisticsVO leadStstistic(StatisticsDTO dto) {
        return statisticsService.leadStstistic(dto);

    }


    /**
     * 线索统计图
     */
    @GetMapping("/cluesStatistics/{beginCreateTime}/{endCreateTime}")
//    public LineChartVO cluesStatistics(@PathVariable String beginCreateTime, @PathVariable String endCreateTime){
//        return statisticsService.cluesStatistics(beginCreateTime,endCreateTime);
//    }
    public String aaaa(){
        return "{\n" +
                "    \"xAxis\": [\n" +
                "        \"2024-01-13\",\n" +
                "        \"2024-01-14\",\n" +
                "        \"2024-01-15\",\n" +
                "        \"2024-01-16\",\n" +
                "        \"2024-01-17\",\n" +
                "        \"2024-01-18\",\n" +
                "        \"2024-01-19\",\n" +
                "        \"2024-01-20\"\n" +
                "    ],\n" +
                "    \"series\": [\n" +
                "        {\n" +
                "            \"name\": \"新增客户数\",\n" +
                "            \"data\": [\n" +
                "                0,\n" +
                "                0,\n" +
                "                0,\n" +
                "                0,\n" +
                "                0,\n" +
                "                0,\n" +
                "                0,\n" +
                "                0\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"客户总数\",\n" +
                "            \"data\": [\n" +
                "                0,\n" +
                "                0,\n" +
                "                0,\n" +
                "                0,\n" +
                "                0,\n" +
                "                0,\n" +
                "                0,\n" +
                "                0\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }


    /**
     * 获得漏斗信息
     * @param beginCreateTime
     * @param endCreateTime
     * @return {@link AjaxResult}
     */
    @GetMapping("/getVulnerabilityMap/{beginCreateTime}/{endCreateTime}")
    public AjaxResult getVulnerabilityMap(@PathVariable String beginCreateTime, @PathVariable String endCreateTime){
        VulnerabilityMapVo vulnerabilityMapVo = statisticsService.getVulnerabilityMap(beginCreateTime,endCreateTime);
        return AjaxResult.success(vulnerabilityMapVo);
    }

    /**
     * 线索统计报表
     * @return
     */
    @GetMapping("/cluesStatisticsList")
    public StatisticsVO clueStatisticsList(ClueStatisticsDTO dto){
        return statisticsService.clueStatisticsList(dto);
    }


    /**
     * 销售统计部门报表

     */
    @GetMapping("/deptStatisticsList/{beginCreateTime}/{endCreateTime}")
    public StatisticsVO deptStatisticsList(@PathVariable String beginCreateTime, @PathVariable String endCreateTime,StatisticsDTO dto){
        return statisticsService.deptStatisticsList(beginCreateTime,endCreateTime,dto);
    }
}
