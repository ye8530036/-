package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.model.Building;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
@Component("buildingDao")
public interface BuildingMapper extends BaseMapper<Building> {

    List<Building> queryBuildAll(@Param("numbers") String numbers);

}
