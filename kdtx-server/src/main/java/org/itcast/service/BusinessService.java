package org.itcast.service;


import org.itcast.dto.BusinessDTO;
import org.itcast.entity.Business;
import org.itcast.entity.BusinessFollow;
import org.itcast.vo.BusinessFollowVO;
import org.itcast.vo.BusinessPageResultVO;
import org.itcast.common.Result;
import org.itcast.dto.BusinessPoolPageQueryDTO;
import org.itcast.dto.BusinessPageQueryDTO;

public interface BusinessService {

    // 查询商机列表
    BusinessPageResultVO listBusiness(BusinessPageQueryDTO dto);

    // 查询公海池列表
    BusinessPageResultVO listBusinessPool(BusinessPoolPageQueryDTO dto);

    // 查看商机详情
    Result getBusinessById(Long id);

    // 新增商机
    Result addBusiness(Business business);

    // 修改商机
    Result updateBusiness(BusinessDTO dto);

    // 商机沟通记录列表
    BusinessFollowVO listBusinessRecord(Long businessId);

    // 捞取商机
    Result gainBusiness(Long[] ids);

    // 新增跟进
    Result addBusinessRecord(BusinessDTO dto);

    // 分配商机
    Result assignmentBusiness(Long[] ids, Long userId);

    // 退回公海池
    Result backBusiness(Long id, String backReason);
}
