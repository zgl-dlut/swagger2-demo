package com.zgl.springboot.swagger.controller;

import com.zgl.springboot.swagger.entity.DemoReq;
import com.zgl.springboot.swagger.entity.DemoResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author zgl
 * @date 2019/4/22 下午3:56
 */
@RestController
@Api(tags="Swagger2示例API")
public class DemoController {
	@GetMapping("/demo")
	@ApiOperation(value="demo示例")
	public DemoResp demo(@Valid DemoReq req){

		DemoResp resp = DemoResp.builder()
				.code(req.getCode())
				.name(req.getName())
				.remark(req.getRemark())
				.build();
		return resp;
	}
}