package org.itcast.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.itcast.context.BaseContext;
import org.itcast.dto.DictDataListDTO;
import org.itcast.entity.DictData;
import org.itcast.exception.ParamIllegalException;
import org.itcast.mapper.DictDataMapper;
import org.itcast.mapper.UserMapper;
import org.itcast.service.DictDataService;
import org.itcast.vo.DictDataInfoResult;
import org.itcast.vo.DictDataResult;
import org.itcast.vo.DictResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DictDataServiceImpl implements DictDataService {
    @Autowired
    DictDataMapper dictDataMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public DictDataResult list(DictDataListDTO dto) {
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize());
        Page<DictData> page = dictDataMapper.list(dto.getDictType());
        return new DictDataResult(page.getTotal(),page.getResult());
    }

    @Override
    public DictDataInfoResult getByDictCode(Long dictCode) {
        if (dictCode==null){
            throw new ParamIllegalException("参数不合法");
        }
        DictData dictData = dictDataMapper.getByDictCode(dictCode);
        return new DictDataInfoResult("操作成功",200,dictData);
    }

    @Override
    public DictResult getByDictType(String dictType) {
        if (dictType==null){
            throw new ParamIllegalException("参数不合法");
        }
        List<DictData> datas = dictDataMapper.getByDictType(dictType);
        return new DictResult("操作成功",200,datas);
    }

    @Override
    public void addData(DictData data) {
        Long id = BaseContext.getCurrentId();
        String name = userMapper.getNameById(id);
        data.setCreateBy(name);
        data.setUpdateBy(name);
        data.setCreateTime(LocalDateTime.now());
        data.setUpdateTime(LocalDateTime.now());
        dictDataMapper.insert(data);
    }

    @Override
    public void updateData(DictData data) {
        Long id = BaseContext.getCurrentId();
        String name = userMapper.getNameById(id);
        data.setUpdateBy(name);
        data.setUpdateTime(LocalDateTime.now());
        dictDataMapper.update(data);
    }

    @Override
    public void delData(Long dictCode) {
        if (dictCode==null){
            throw new ParamIllegalException("参数不合法");
        }
        dictDataMapper.delete(dictCode);
    }
}
