package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.RecordsMapper;
import com.example.model.RecordVo;
import com.example.model.Records;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.example.service.IRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class RecordsServiceImpl extends ServiceImpl<RecordsMapper, Records> implements IRecordsService {
    @Autowired
    private RecordsMapper recordsDao;

    @Override
    public PageInfo<RecordVo> findRecordsAll(int page, int limit, RecordVo recordVo) {
        PageHelper.startPage(page,limit);
        List<RecordVo> list=recordsDao.queryRecordsAll(recordVo);
        PageInfo<RecordVo> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Records queryByHouIdAndTypeId(Integer houId, Integer typeId) {
        return recordsDao.queryByHouIdAndTypeId(houId,typeId);
    }

    @Override
    public int add(Records building){
        return baseMapper.insert(building);
    }



    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Records building){
        return baseMapper.updateById(building);
    }

    @Override
    public Records findById(Long id){
        return  baseMapper.selectById(id);
    }



}
