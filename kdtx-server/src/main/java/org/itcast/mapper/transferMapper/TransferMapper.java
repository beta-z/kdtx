package org.itcast.mapper.transferMapper;


import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.itcast.dto.TransferlistDTO;
import org.itcast.vo.TransferlistVO;

@Mapper
public interface TransferMapper {

    Page<TransferlistVO> getTransferlist(TransferlistDTO params);

    @Select("select count(*) from tb_assign_record where user_id = #{userId} and type = 0")
    Long getclue(Long userId);

    @Select("select count(*) from tb_assign_record where user_id = #{userId} and type = 1 ")
    Long getbusiness(Long userId);

    @Select("select name from sys_user where user_id = #{userId}")
    String getname(Long userId);

    @Update("update tb_clue set owner = #{receptionName} where owner = #{name} ")
    void upClue( String name, String receptionName );

    @Update("update tb_business set owner = #{receptionName} where owner = #{name} ")
    void upBusiness(String name, String receptionName);
}
