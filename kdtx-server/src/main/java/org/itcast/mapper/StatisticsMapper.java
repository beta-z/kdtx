package org.itcast.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.itcast.dto.ActivityDTO;
import org.itcast.dto.ClueStatisticsDTO;
import org.itcast.dto.StatisticsDTO;
import org.itcast.entity.SysDept;

import java.util.List;
import java.util.Map;

@Mapper
public interface StatisticsMapper {
    List<ClueStatisticsDTO> clueStatisticsList(ClueStatisticsDTO dto);

    List<ActivityDTO> activityStatisticsList(ActivityDTO dto);

    List<StatisticsDTO> leadStstistic(StatisticsDTO dto);

//    List<StatisticsDTO> deptStatisticsList(String beginCreateTime, String endCreateTime);

    List<Map<String, Object>> deptStatistics(String beginCreateTime, String endCreateTime);


    @Select("select * from sys_dept where dept_id = #{deptId}")
    SysDept selectDeptById(Long deptId);
}
