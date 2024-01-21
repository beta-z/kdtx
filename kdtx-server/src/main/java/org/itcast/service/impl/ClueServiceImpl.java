package org.itcast.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.sky.result.PageResult;

import org.itcast.common.CluePageResult;
import org.itcast.common.MyResult;
import org.itcast.common.Result;
import org.itcast.dto.*;
import org.itcast.entity.Activity;
import org.itcast.vo.*;
import org.springframework.util.StringUtils;
import org.itcast.entity.Clue;
import org.itcast.mapper.ClueMapper;
import org.itcast.service.ClueService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ClueServiceImpl implements ClueService {
    @Autowired
    private ClueMapper clueMapper;

    @Override
    public CluePageResult listClue(ClueDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());

        Page<ClueVO> page = clueMapper.clueList(dto.getId(), dto.getPhone(), dto.getOwner(),
                dto.getChannel(), dto.getStatus(), dto.getBeginCreateTime(), dto.getEndCreateTime());

        return new CluePageResult(200," ", page.getTotal(),page.getResult());

    }

    @Override
    public CluePageResult listCluePool(CluePoolDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());

        Page<CluePoolVO> page = clueMapper.cluePoolList(dto.getId(), dto.getPhone(),
                dto.getChannel(), dto.getBeginCreateTime(), dto.getEndCreateTime());

        return  new CluePageResult(200," ", page.getTotal(),page.getResult());

    }

    @Override
    public Result getClue(Long id) {
        Clue clue = clueMapper.getClue(id);
        clue.setNextTime(null);
        Long activityId = clue.getActivityId();
        Activity activity = clueMapper.activityById(activityId);
        clue.setActivityInfo(activity.getInfo());
        return Result.success(clue);
    }

    @Override
    public Result addClue(Clue clue) {
        clue.setLevel("0");
        clue.setCreateTime(LocalDateTime.now());
        clue.setCreateBy("demo");
        clue.setFalseCount(0);
        clue.setTransfer("0");
        clue.setOwner("demo");
        clue.setOwnerTime(LocalDateTime.now());
        clueMapper.addClue(clue);
        return Result.success();
    }

    @Override
    public Result gainClue(Long[] ids) {
        Integer status = 1;
        clueMapper.gainClue(status,ids);
        return Result.success();
    }

    @Override
    public Result turnBusiness(Long id) {
        //TODO 转客户
        clueMapper.deleteById(id);
        return Result.success();
    }

    @Override
    public Result reportClue(Long id, String reason, String remark) {

        Clue clue = clueMapper.getClue(id);
        Integer falseCount = clue.getFalseCount();
        if (falseCount >= 2) {
            clueMapper.deleteById(id);
        } else {
            clue.setFalseCount(falseCount + 1);
            clue.setStatus("4");
            clueMapper.updateClueStatus(clue);
        }
        return Result.success();
    }

    @Override
    public Result addClueRecord(FollowClueDTO dto) {
        if (dto == null) {
            return Result.error("参数异常！！");
        }
        clueMapper.addClueRecord(dto);
        clueMapper.addFollow(dto.getClueId(),dto.getRecord());
        return Result.success();
    }

    @Override
    public MyResult listClueRecord(Long id) {
        List<String> strings = clueMapper.listClueRecord(id);
        List<OperateRecordVO> list = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            OperateRecordVO vo = new OperateRecordVO();
            Clue clue = clueMapper.getClue(id);
            vo.setRecord(strings.get(i));
            vo.setId(id);
            vo.setLevel(clue.getLevel());
            vo.setSubject(clue.getSubject());
            vo.setCreateBy(clue.getCreateBy());
            vo.setNextTime(clue.getNextTime());
            vo.setFalseReason("自身原因！！！");
            vo.setCreateTime(LocalDateTime.now());
            list.add(vo);
        }
        return MyResult.success(list);
    }

    @Override
    public Result updateClue(FollowClueDTO dto) {
        clueMapper.addClueRecord(dto);
        return Result.success();
    }

    @Override
    public Result assignmentClue(GainDTO dto,Long userId) {
        Integer status = 2;
        String userName = clueMapper.userById(userId);
        clueMapper.assignmentClue(dto.getIds(),userName,status);
        return Result.success();
    }


}
