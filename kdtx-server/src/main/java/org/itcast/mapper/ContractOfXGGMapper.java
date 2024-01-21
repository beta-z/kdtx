package org.itcast.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ContractOfXGGMapper {
    @MapKey("id")
    public List<Map<String, Object>> contractStatistics(@Param("beginCreateTime") String beginCreateTime, @Param("endCreateTime") String endCreateTime);
}
