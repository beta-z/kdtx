package org.itcast.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.itcast.dto.FollowClueDTO;
import org.itcast.entity.Activity;
import org.itcast.entity.Clue;
import org.itcast.vo.CluePoolVO;
import org.itcast.vo.ClueVO;
import org.itcast.vo.OperateRecordVO;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ClueMapper {

    Page<ClueVO> clueList(Long id, String phone, String owner, String channel, String status, LocalDateTime beginCreateTime, LocalDateTime endCreateTime);


    Page<CluePoolVO> cluePoolList(Long id, String phone, String channel, LocalDateTime beginCreateTime, LocalDateTime endCreateTime);

    Clue getClue(Long id);

    void addClue(Clue clue);

    void gainClue(int status,Long[] ids);

    void deleteById(Long id);

    void updateClueStatus(Clue clue);

    void addClueRecord(FollowClueDTO dto);
    void addFollow(Long clueId ,String followRecord);


    List<String> listClueRecord(Long id);

    Activity activityById(Long activityId);


    void assignmentClue(Long[] ids, String userName, Integer status);

    String userById(Long userId);
}
