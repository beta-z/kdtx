package org.itcast.service;

import org.itcast.dto.ActivityDTO;
import org.itcast.dto.ClueStatisticsDTO;
import org.itcast.dto.StatisticsDTO;
import org.itcast.vo.LineChartVO;
import org.itcast.vo.StatisticsVO;
import org.itcast.vo.VulnerabilityMapVo;
import org.springframework.web.bind.annotation.PathVariable;

public interface StatisticsService {

    /**
     * 线索统计报表
     * @param dto
     * @return
     */
    StatisticsVO clueStatisticsList(ClueStatisticsDTO dto);

    /**
     * 活动统计报表
     * @param dto
     * @return
     */
    StatisticsVO activityStatisticsList(ActivityDTO dto);

    LineChartVO contractStatistics(String beginCreateTime, String endCreateTime);

    StatisticsVO leadStstistic(StatisticsDTO dto);

    LineChartVO cluesStatistics(String beginCreateTime, String endCreateTime);

    VulnerabilityMapVo getVulnerabilityMap(String beginCreateTime, String endCreateTime);

    StatisticsVO deptStatisticsList(@PathVariable String beginCreateTime, @PathVariable String endCreateTime,StatisticsDTO dto);
}
