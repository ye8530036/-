package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.model.RecordVo;
import com.example.model.Records;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IRecordsService extends IService<Records>{

    /**
     * 分页查询的记录信息
     * @param
     * @return
     */
    PageInfo<RecordVo> findRecordsAll(int page, int limit, RecordVo recordVo);

    /**
     * 根据房子id和类型id查询记录信息最后一条
     */
    Records queryByHouIdAndTypeId(Integer houId, Integer typeId);

    int add(Records records);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param userinfo 
     * @return int
     */
    int updateData(Records userinfo);

    /**
     * id查询数据
     *
     * @param id id
     * @return Userinfo
     */
    Records findById(Long id);
}
