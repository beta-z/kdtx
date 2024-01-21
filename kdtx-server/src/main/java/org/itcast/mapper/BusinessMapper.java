package org.itcast.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.itcast.dto.BusinessDTO;
import org.itcast.entity.Business;
import org.itcast.entity.BusinessFollow;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface BusinessMapper {

    // 查询商机列表
    Page<Business> listBusiness(Long id, String phone, String name, String owner, String status, LocalDateTime beginTime, LocalDateTime endTime);


    // 查询公海列表
    Page<Business> listBusinessPool(String name, String phone, Long businessId, String subject, LocalDateTime beginTime, LocalDateTime endTime);

    // 查看商机详情
    Business getBusinessById(Long id);

    /**
     * 新增商机
     *
     * @return
     */
    void addBusiness(Business business);

    // 修改商机
    void updateBusiness(BusinessDTO dto);

    // 捞取商机
    void gainBusiness(Long[] ids, String status, String owner);

    // 新增跟进
    void addBusinessRecord(BusinessFollow businessFollow);

    // 分配商机
    void assignmentBusiness(Long[] ids, String status, String userName);

    // 退回公海池
    void backBusiness(Long id, String owner, String status);

    List<Business> listBusinessRecord(Long businessId);
}
