package org.itcast.mapper;




import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Select;
import org.itcast.dto.ActivtyAddDto;
import org.itcast.entity.TbActivity;
import org.apache.ibatis.annotations.Mapper;
import org.itcast.vo.ActivityVo;

import java.util.Date;

@Mapper
public interface ActivityMapper extends BaseMapper<TbActivity> {

    void insertActivity(ActivtyAddDto activity);

    Page<ActivityVo> selectListActivityList(String code, String channel, Date beginCreateTime, Date endCreateTime, Date beginTime, Date endTime);

    @Select("select * from tb_activity where id =#{id};")
    ActivityVo getById(Long id);

    void setActivity(ActivtyAddDto dto);
}
