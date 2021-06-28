package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.model.Parking;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
@Component("parkingDao")
public interface ParkingMapper extends BaseMapper<Parking> {

     //分页查询车位信息
     List<Parking> queryParkAll(@Param("numbers") String numbers);

     //查询使用的车位信息
     List<Parking> queryParkAllByStatus();


}
