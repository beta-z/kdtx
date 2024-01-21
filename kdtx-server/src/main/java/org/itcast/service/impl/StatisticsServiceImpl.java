package org.itcast.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.itcast.common.HttpStatus;
import org.itcast.common.PageDomain;
import org.itcast.dto.ActivityDTO;
import org.itcast.dto.ClueStatisticsDTO;
import org.itcast.dto.StatisticsDTO;
import org.itcast.entity.SysDept;
import org.itcast.mapper.ContractOfXGGMapper;
import org.itcast.mapper.StatisticsMapper;
import org.itcast.service.StatisticsService;
import org.itcast.vo.LineChartVO;
import org.itcast.vo.LineSeriesVO;
import org.itcast.vo.StatisticsVO;
import org.itcast.vo.VulnerabilityMapVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsMapper statisticsMapper;
    @Autowired
    private ContractOfXGGMapper contractMapper;

    /**
     * 线索统计报表
     * @param dto
     * @return
     */
    @Override
    public StatisticsVO clueStatisticsList(ClueStatisticsDTO dto) {
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize());
        List<ClueStatisticsDTO> list=statisticsMapper.clueStatisticsList(dto);
        Page<ClueStatisticsDTO> page= (Page<ClueStatisticsDTO>) list;
        StatisticsVO vo = new StatisticsVO();
        vo.setCode(HttpStatus.SUCCESS);
        vo.setMsg("查询成功");
        vo.setRows(list);
        vo.setTotal(page.getTotal());


        return vo;
    }

    @Override
    public StatisticsVO activityStatisticsList(ActivityDTO dto) {
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize());
        List<ActivityDTO> list=statisticsMapper.activityStatisticsList(dto);
        Page<ActivityDTO> page= (Page<ActivityDTO>) list;
        Map<String, Object> timeMap = dto.getParams();
//        List<ActivityStatisticsVo> list1=new ArrayList<>();
//        for (ActivityDTO activity : list) {
//            ActivityStatisticsVo Ase = new ActivityStatisticsVo();
//            BeanUtils.copyProperties(activity, Ase);
//            ClueStatisticsDTO tbClue = new ClueStatisticsDTO();
//            tbClue.setActivityId(activity.getId());
//            tbClue.setChannel(activity.getChannel());
//            tbClue.setParams(timeMap);
//            Map<String, Object> clueCount = clueMapper.countByActivity(tbClue);
//            if (clueCount != null) {
//                dto.setCluesNum(Integer.parseInt(clueCount.get("total").toString()));
//                if(clueCount.get("falseClues")!=null){
//                    dto.setFalseCluesNum(Integer.parseInt(clueCount.get("falseClues").toString()));
//                }
//                if (clueCount.get("toBusiness") != null) {
//                    dto.setBusinessNum(Integer.parseInt(clueCount.get("toBusiness").toString()));
//                }
//            }







        StatisticsVO vo = new StatisticsVO();
        vo.setCode(HttpStatus.SUCCESS);
        vo.setMsg("查询成功");
        vo.setRows(list);
        vo.setTotal(page.getTotal());
        return vo;
    }

    /**
     * 客户图
     * @param beginCreateTime
     * @param endCreateTime
     * @return
     */
    @Override
    public LineChartVO contractStatistics(String beginCreateTime, String endCreateTime) {
        LineChartVO lineChartVo =new LineChartVO();
        try {
            List<String> timeList= findDates(beginCreateTime,endCreateTime);
            lineChartVo.setXAxis(timeList);
            List<LineSeriesVO> series = new ArrayList<>();
            List<Map<String,Object>>  statistics = contractMapper.contractStatistics(beginCreateTime,endCreateTime);
            LineSeriesVO lineSeriesDTO1=new LineSeriesVO();
            lineSeriesDTO1.setName("新增客户数");
            LineSeriesVO lineSeriesDTO2=new LineSeriesVO();
            lineSeriesDTO2.setName("客户总数");
            int sum = 0;
            for (String s : timeList) {
                Optional optional=  statistics.stream().filter(d->d.get("dd").equals(s)).findFirst();
                if(optional.isPresent()){
                    Map<String,Object> cuurentData=  (Map<String,Object>)optional.get();
//                    lineSeriesDTO1.getData().add((Map<String, Object>) cuurentData.get("num"));
                    sum += Integer.parseInt(cuurentData.get("num").toString());
                }else{
//                    lineSeriesDTO1.getData().add(0);
                }
//                lineSeriesDTO2.getData().add(sum);
            }
            series.add(lineSeriesDTO1);
            series.add(lineSeriesDTO2);
            lineChartVo.setSeries(series);
        } catch (ParseException e) {
            // e.printStackTrace();
        }
        return  lineChartVo;
    }


    /**
     * 客户搜索列表
     * @param dto
     * @return
     */
    @Override
    public StatisticsVO leadStstistic(StatisticsDTO dto) {
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize());
        List<StatisticsDTO> list=statisticsMapper.leadStstistic(dto);
        Page<StatisticsDTO> page= (Page<StatisticsDTO>) list;
        StatisticsVO vo = new StatisticsVO();
        vo.setCode(HttpStatus.SUCCESS);
        vo.setMsg("查询成功");
        vo.setRows(list);
        vo.setTotal(page.getTotal());


        return vo;
    }

    /**
     * 线索统计图
     * @param beginCreateTime
     * @param endCreateTime
     * @return
     */

    @Override
    public LineChartVO cluesStatistics(String beginCreateTime, String endCreateTime) {
        LineChartVO lineChartVo = new LineChartVO();
        try {
            // 获取时间范围内的日期列表
            List<String> timeList = findDates(beginCreateTime, endCreateTime);
            lineChartVo.setXAxis(timeList);

            List<LineSeriesVO> series = new ArrayList<>();
            // 查询线索的统计数据
//            List<Map<String, Object>> statistics = clueMapper.cluesStatistics(beginCreateTime, endCreateTime);

            // 创建线索新增数量和线索总数量的数据序列
            LineSeriesVO lineSeriesVO1 = new LineSeriesVO();
            lineSeriesVO1.setName("新增线索数量");
            LineSeriesVO lineSeriesVO2 = new LineSeriesVO();
            lineSeriesVO2.setName("线索总数量");

            int sum = 0; // 线索总数量

            // 遍历日期列表
            for (String s : timeList) {
                // 在统计数据中查找当前日期对应的数据
//                Optional optional = statistics.stream().filter(d -> d.get("dd").equals(s)).findFirst();

//                if (optional.isPresent()) {
//                    // 存在数据，则将新增线索数量添加到对应的数据序列中
//                    Map<String, Object> currentData = (Map<String, Object>) optional.get();
//                    lineSeriesVO1.getData().add((Map<String, Object>) currentData.get("num"));
//
//                    // 更新线索总数量
//                    sum += Integer.parseInt(currentData.get("num").toString());
//                } else {
                // 不存在数据，则将新增线索数量设置为0
//                    lineSeriesVO1.getData().add(0);
//                }

                // 将线索总数量添加到对应的数据序列中
//                lineSeriesVO2.getData().add(sum);
            }

            series.add(lineSeriesVO1);
            series.add(lineSeriesVO2);
            lineChartVo.setSeries(series);
        } catch (ParseException e) {
            // 处理异常
            // e.printStackTrace();
        }

        return lineChartVo;
    }

    @Override
    public VulnerabilityMapVo getVulnerabilityMap(String beginCreateTime, String endCreateTime) {
        VulnerabilityMapVo vulnerabilityMapDTO =new VulnerabilityMapVo();
//        //线索数
//        vulnerabilityMapDTO.setCluesNums(clueMapper.countAllClues(beginCreateTime,endCreateTime));
//        //有效线索数
//        vulnerabilityMapDTO.setEffectiveCluesNums(clueMapper.effectiveCluesNums(beginCreateTime,endCreateTime));
//        //商机数
//        vulnerabilityMapDTO.setBusinessNums(businessMapper.businessNumsFromClue(beginCreateTime,endCreateTime));
//        //合同数
//        vulnerabilityMapDTO.setContractNums(contractMapper.contractNumsFromBusiness(beginCreateTime,endCreateTime));
        return vulnerabilityMapDTO;
    }

    @Override
    public StatisticsVO deptStatisticsList(@PathVariable String beginCreateTime, @PathVariable String endCreateTime,StatisticsDTO dto) {
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize());
        List<Map<String, Object>> data= statisticsMapper.deptStatistics(beginCreateTime,endCreateTime);
        for (Map<String, Object> datum : data) {
            Long deptId= (Long) datum.get("dept_id");
            if(deptId!=null){
                SysDept dept= statisticsMapper.selectDeptById(deptId);
                datum.put("deptName", dept.getDeptName());
            }
        }
        Integer pageNum = dto.getPageNum();
        Integer pageSize = dto.getPageSize();

        StatisticsVO rspData = new StatisticsVO();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("查询成功");
        int total = data.size();
        if (total > pageSize) {
            int toIndex = pageSize * pageNum;
            if (toIndex > total) {
                toIndex = total;
            }
            data = data.subList(pageSize * (pageNum - 1), toIndex);
        }
        rspData.setRows(data);
        rspData.setTotal(total);
        return rspData;
    }


    /**
     * *************方法**************
     * 传入两个时间范围，返回这两个时间范围内的所有时间，并保存在一个集合中
     * @param beginTime
     * @param endTime
     * @return
     * @throws ParseException
     */
    public static List<String> findDates(String beginTime, String endTime)
            throws ParseException {
        List<String> allDate = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date dBegin = sdf.parse(beginTime);
        Date dEnd = sdf.parse(endTime);
        allDate.add(sdf.format(dBegin));
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            allDate.add(sdf.format(calBegin.getTime()));
        }
        System.out.println("时间==" + allDate);
        return allDate;
    }
}
