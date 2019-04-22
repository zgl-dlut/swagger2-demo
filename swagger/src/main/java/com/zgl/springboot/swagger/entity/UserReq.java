package com.zgl.springboot.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author zgl
 * @date 2019/4/22 下午3:56
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class UserReq {
	@ApiModelProperty(value="ID",dataType="String",name="ID",example="1020332806740959233")
	private String id;

	@ApiModelProperty(value="编码",dataType="String",name="code",example="001")
	private String code;

	@ApiModelProperty(value="名称",dataType="String",name="name",example="oKong")
	private String name;
}