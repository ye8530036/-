package com.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Repair对象", description="")
public class Repair implements Serializable {

    private static final long serialVersionUID = 1L;

    private Owner owner;
    private Repairtype type;

    private Integer id;

    private String comId;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date comDate;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date handleDate;

    private Integer ownerId;

    private Integer status;

    private Integer clr;

    private String remarks;


}
