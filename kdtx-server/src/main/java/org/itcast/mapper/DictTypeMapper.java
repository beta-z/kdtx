package org.itcast.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.itcast.dto.DictTypeListDTO;
import org.itcast.entity.DictType;

@Mapper
public interface DictTypeMapper {

    Page<DictType> list(DictTypeListDTO dto);

    @Select("select dict_id,dict_name,dict_type,status,create_by,create_time,remark from sys_dict_type where dict_id = #{dictId} ")
    DictType getById(Long dictId);

    @Insert("insert into sys_dict_type (dict_name,dict_type,status,create_by,create_time,update_by,update_time,remark) " +
            "values (#{dictName},#{dictType},#{status},#{createBy},#{createTime},#{updateBy},#{updateTime},#{remark})")
    void insertDict(DictType dictType);


    void updateDict(DictType dictType);

    @Delete("delete from sys_dict_type where dict_id = #{dictId}")
    void delete(Long dictId);


}
