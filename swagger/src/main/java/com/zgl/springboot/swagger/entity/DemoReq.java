package com.zgl.springboot.swagger.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zgl
 * @date 2019/4/22 下午3:56
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemoReq {
	String code;

	String name;

	String remark;

}