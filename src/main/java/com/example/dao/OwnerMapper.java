package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.model.Owner;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
@Component("ownerDao")
public interface OwnerMapper extends BaseMapper<Owner> {

    //查询
    List<Owner> queryOwnerAll(Owner owner);

    Owner queryOwnerByName(@Param("username") String username);

}
