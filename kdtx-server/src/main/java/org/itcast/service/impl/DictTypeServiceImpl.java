package org.itcast.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.itcast.context.BaseContext;
import org.itcast.dto.DictTypeListDTO;
import org.itcast.entity.DictData;
import org.itcast.entity.DictType;
import org.itcast.exception.ParamIllegalException;
import org.itcast.mapper.DictTypeMapper;
import org.itcast.mapper.UserMapper;
import org.itcast.service.DictTypeService;
import org.itcast.vo.DictDataResult;
import org.itcast.vo.DictTypeInfoResult;
import org.itcast.vo.DictTypeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;


@Service
public class DictTypeServiceImpl implements DictTypeService {
    @Autowired
    DictTypeMapper dictTypeMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public DictTypeResult list(DictTypeListDTO dto) {
        if (dto==null){
            throw new ParamIllegalException("参数不合法");
        }
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize());
        Page<DictType> page = dictTypeMapper.list(dto.getDictType());
        return new DictTypeResult(page.getTotal(),page.getResult());
    }

    @Override
    public DictTypeInfoResult getById(Long dictId) {
        if (dictId==null){
            throw new ParamIllegalException("参数不合法");
        }
        DictType dictType = dictTypeMapper.getById(dictId);
        return new DictTypeInfoResult("操作成功",200,dictType);
    }

    @Override
    public void addDict(DictType dictType) {
        if (dictType==null){
            throw new ParamIllegalException("参数不合法");
        }
        Long id = BaseContext.getCurrentId();
        String name = userMapper.getNameById(id);
        dictType.setCreateBy(name);
        dictType.setUpdateBy(name);
        dictType.setCreateTime(LocalDateTime.now());
        dictType.setUpdateTime(LocalDateTime.now());
        dictTypeMapper.insertDict(dictType);
    }

    @Override
    public void updateDict(DictType dictType) {
        if (dictType==null){
            throw new ParamIllegalException("参数不合法");
        }
        Long id = BaseContext.getCurrentId();
        String name = userMapper.getNameById(id);
        dictType.setUpdateBy(name);
        dictType.setUpdateTime(LocalDateTime.now());
        dictTypeMapper.updateDict(dictType);
    }

    @Override
    public void delType(Long dictId) {
        if (dictId==null){
            throw new ParamIllegalException("参数不合法");
        }
        dictTypeMapper.delete(dictId);
    }


}
