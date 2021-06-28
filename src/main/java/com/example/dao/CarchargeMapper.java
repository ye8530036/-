package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.model.Carcharge;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
@Component("carchargeDao")
public interface CarchargeMapper extends BaseMapper<Carcharge> {

    List<Carcharge> queryCarChargeAll(Carcharge carcharge);

}
