package org.itcast.mapper;



import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.itcast.dto.ActivityDTO;
import org.itcast.dto.PageQueryDTO;
import org.itcast.entity.Activity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActivityMapper {


    @Delete("delete from tb_activity where id=#{id}")
    void deleteById(Long id);

    //新增活动
    @Insert("insert into tb_activity(id,channel,name,info,type,discount,vouchers,begin_time,status,end_time)"
            + "VALUES " +
            "(#{id},#{channel},#{name},#{info},#{type},#{discount},#{vouchers},#{beginTime},#{status},#{endTime})")
    void s(Activity activity);

    //分页
    Page<Activity> pageQuery(PageQueryDTO pageQueryDTO);

    //修改活动
    void update(ActivityDTO activityDTO);
}
