package com.zgl.springboot.swagger.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zgl
 * @date 2019/4/22 下午3:57
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResp {
	private String id;

	private String code;

	private String name;

	private StatusEnum status;

}