package org.itcast.service;

import org.itcast.common.CluePageResult;
import org.itcast.common.MyResult;
import org.itcast.common.Result;
import org.itcast.dto.*;
import org.itcast.entity.Clue;
import org.springframework.stereotype.Service;


public interface ClueService {
    CluePageResult listClue(ClueDTO dto);

    CluePageResult listCluePool(CluePoolDTO dto);

    Result getClue(Long id);

    Result addClue(Clue clue);

    Result gainClue(Long[] ids);

    Result turnBusiness(Long id);

    Result reportClue(Long id,String reason,String remark);

    Result addClueRecord(FollowClueDTO dto);

    MyResult listClueRecord(Long id );

    Result updateClue(FollowClueDTO dto);

    Result assignmentClue(GainDTO dto,Long userId);
}
