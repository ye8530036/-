package com.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.PropertyInfoMapper;
import com.example.model.PropertyInfo;
import com.example.service.IPropertyInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kappy
 * @since 2020-11-08
 */
@Service
public class PropertyInfoServiceImpl extends ServiceImpl<PropertyInfoMapper, PropertyInfo> implements IPropertyInfoService {

    @Autowired
    private PropertyInfoMapper propertyInfoDao;

    @Override
    public PageInfo<PropertyInfo> findPropertyInfoAll(int page, int pagesise,
                                                      PropertyInfo propertyInfo) {
        PageHelper.startPage(page,pagesise);
        List<PropertyInfo> list=propertyInfoDao.queryListAll(propertyInfo);
        PageInfo<PropertyInfo> pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public void deleteInfoByHouIdAndTime(Integer houId, Date endTime) {

         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         String dateString = formatter.format(endTime);
         dateString=dateString.substring(0,9);
         propertyInfoDao.deleteByHouIdAndTime(houId,dateString);
    }

    @Override
    public IPage<PropertyInfo> findListByPage(Integer page, Integer pageCount){
        IPage<PropertyInfo> wherePage = new Page<>(page, pageCount);
        PropertyInfo where = new PropertyInfo();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(PropertyInfo propertyInfo){
        return baseMapper.insert(propertyInfo);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(PropertyInfo propertyInfo){
        return baseMapper.updateById(propertyInfo);
    }

    @Override
    public PropertyInfo findById(Long id){
        return  baseMapper.selectById(id);
    }
}
