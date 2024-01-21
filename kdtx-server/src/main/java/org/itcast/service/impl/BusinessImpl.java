package org.itcast.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.itcast.common.Result;
import org.itcast.context.BaseContext;
import org.itcast.dto.BusinessDTO;
import org.itcast.entity.Business;
import org.itcast.entity.BusinessFollow;
import org.itcast.exception.ParamIllegalException;
import org.itcast.vo.BusinessFollowVO;
import org.itcast.vo.BusinessPageResultVO;
import org.itcast.dto.BusinessPoolPageQueryDTO;
import org.itcast.dto.BusinessPageQueryDTO;
import org.itcast.mapper.BusinessMapper;
import org.itcast.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BusinessImpl implements BusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    // 查询商机列表
    @Override
    public BusinessPageResultVO listBusiness(BusinessPageQueryDTO dto) {

        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());

        Page<Business> page = businessMapper.listBusiness(dto.getId(), dto.getPhone(), dto.getName(),
                dto.getOwner(), dto.getStatus(), dto.getBeginTime(), dto.getEndTime());

        return new BusinessPageResultVO(page.getTotal(), page.getResult(), 200, "success");
    }

    // 查询公海池列表
    @Override
    public BusinessPageResultVO listBusinessPool(BusinessPoolPageQueryDTO dto) {

        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        Page<Business> page = businessMapper.listBusinessPool(dto.getName(), dto.getPhone(),
                dto.getBusinessId(), dto.getSubject(), dto.getBeginTime(), dto.getEndTime());
        return new BusinessPageResultVO(page.getTotal(), page.getResult(), 200, "success");
    }

    // 查看商机详情
    @Override
    public Result getBusinessById(Long id) {

        if (id == null) {
            throw new ParamIllegalException("id不正确！");
        }
        Business business = businessMapper.getBusinessById(id);
        return Result.success(business);
    }

    // 新增商机
    @Override
    public Result addBusiness(Business business) {

        Long currentId = BaseContext.getCurrentId();
        business.setCreateBy("demo");
        business.setOwner("demo");
        business.setCreateTime(LocalDateTime.now());
        business.setOwnerTime(LocalDateTime.now());
        businessMapper.addBusiness(business);
        return Result.success();
    }

    // 修改商机
    @Override
    public Result updateBusiness(BusinessDTO dto) {

        dto.setOwner("demo");
        dto.setStatus("1");
        dto.setOwnerTime(LocalDateTime.now());
        addBusinessRecord(dto);
        return Result.success();
    }

    // 商机沟通记录列表
    @Override
    public BusinessFollowVO listBusinessRecord(Long businessId) {

        if (businessId == null) {
            throw new ParamIllegalException("id不正确！");
        }
        List<Business> businessFollows = businessMapper.listBusinessRecord(businessId);
        return new BusinessFollowVO(200, "null", businessFollows);
    }

    // 捞取商机
    @Override
    public Result gainBusiness(Long[] ids) {
        if (ids.length == 0) {
            throw new ParamIllegalException("参数异常");
        }
        String status = "1";
        String owner = "demo";
        businessMapper.gainBusiness(ids, status, owner);
        return Result.success();
    }

    // 新增跟进
    @Override
    public Result addBusinessRecord(BusinessDTO dto) {
        businessMapper.updateBusiness(dto);
        BusinessFollow businessFollow = BusinessFollow.builder()
                .businessId(dto.getBusinessId())
                .trackStatus(dto.getTrackStatus())
                .record(dto.getRecord())
                .nextTime(dto.getNextTime())
                .keyItems(dto.getKeyItems())
                .owner(dto.getOwner())
                .build();
        businessMapper.addBusinessRecord(businessFollow);
        return Result.success();
    }

    // 分配商机
    @Override
    public Result assignmentBusiness(Long[] ids, Long userId) {

        if (ids.length == 0 || userId == null) {
            throw new ParamIllegalException("参数异常");
        }
        String userName = "demo";
        String status = "2";
        businessMapper.assignmentBusiness(ids, status, userName);
        return Result.success();
    }

    // 退回公海池
    @Override
    public Result backBusiness(Long id, String backReason) {

        if (id == null) {
            throw new ParamIllegalException("参数异常");
        }
        String status = "3";
        String owner = null;
        Business business = businessMapper.getBusinessById(id);
        businessMapper.backBusiness(id, owner, status);
        return Result.success();
    }


}
