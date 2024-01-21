package org.itcast.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.itcast.entity.DictData;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Mapper
public interface DictDataMapper {
    @Select("select create_time,dict_code,dict_sort,dict_label,dict_value,status,remark " +
            "from sys_dict_data where dict_type = #{dictType}")
    Page<DictData> list(String dictType);

    @Select("select create_time,dict_code,dict_sort,dict_label,dict_value,status,remark from sys_dict_data where dict_code = #{dictCode}")
    DictData getByDictCode(Long dictCode);

    @Select("select create_time,dict_code,dict_sort,dict_label,dict_value,status,remark from sys_dict_data where dict_type = #{dictType}")
    List<DictData> getByDictType(String dictType);

    @Insert("insert into sys_dict_data (create_time,create_by,dict_code,dict_type,dict_sort,dict_label,dict_value,status,remark,update_time,update_by) " +
            "values (#{createTime},#{createBy},#{dictCode},#{dictType},#{dictSort},#{dictLabel},#{dictValue},#{status},#{remark},#{updateTime},#{updateBy})")
    void insert(DictData data);


    void update(DictData data);

    @Delete("delete from sys_dict_data where dict_code = #{dictCode}")
    void delete(Long dictCode);
}
