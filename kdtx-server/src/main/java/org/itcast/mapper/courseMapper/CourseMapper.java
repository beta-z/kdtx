package org.itcast.mapper.courseMapper;

import com.github.pagehelper.Page;
import lombok.Data;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.itcast.dto.CourselistDTO;
import org.itcast.dto.NewClassDTO;
import org.itcast.vo.CourselistVO;
import org.itcast.vo.TransferlistVO;

import java.util.List;

@Mapper
public interface CourseMapper {

    Page<CourselistDTO> getCourselist(CourselistDTO dto);

    @Select("select * from tb_course")
    List<CourselistVO> getPushCourseList();

    @Select("select * from tb_course where id = #{id}")
    CourselistVO getCoursebyid(Long id);

    //查询学科名字
    @Select("select dict_label from sys_dict_data where dict_value = #{subject} ")
    String getclassname(String subject);

    //查询学科代号
    @Select("select subject from tb_course where id = #{id};")
    Character getdictLabel(Long id);

    @Insert("insert into tb_course (code, name, subject, price, applicable_person, info," +
            " create_time, is_delete)" +
            "VALUES   (#{code},#{name},#{subject},#{price},#{applicablePerson},#{info}," +
            "#{createTime},#{isDelete})")
    void newClass(NewClassDTO dto);

    @Delete("delete from tb_course where id = #{id};")
    void deleteClass(Long id);
}
