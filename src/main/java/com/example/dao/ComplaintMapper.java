package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.model.Complaint;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
@Component("complaintDao")
public interface ComplaintMapper extends BaseMapper<Complaint> {

     List<Complaint> queryComplaintAll(Complaint complaint);
}
