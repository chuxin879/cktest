package com.lemon.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

//import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author can
 * @since 2020-02-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Project对象", description="")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
     * 用户ID
     * 
     */
   
    @ApiModelProperty(value = "id主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    
    @NotNull(message="接口项目名不能为空")
    @ApiModelProperty(value = "接口项目名")
    private String name;
    
    @ApiModelProperty(value = "接口项目的主机地址")
    private String host;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建用户id")
    private Integer createUser;
    
    @TableField(fill=FieldFill.INSERT)	
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    



}
