package com.zgl.springboot.swagger.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.zgl.springboot.swagger.entity.User;
import com.zgl.springboot.swagger.entity.UserReq;
import com.zgl.springboot.swagger.entity.UserResp;
import com.zgl.springboot.swagger.exception.CommonException;
import com.zgl.springboot.swagger.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zgl
 * @date 2019/4/22 下午4:00
 */
@RestController
@RequestMapping("/user")
@Api(tags="用户API")
public class UserController {

	@Autowired
	IUserService userService;

	@PostMapping("add")
	@ApiOperation(value="用户新增")
	//正常业务时， 需要在user类里面进行事务控制，控制层一般不进行业务控制的。
	//@Transactional(rollbackFor = Exception.class)
	public Map<String,String> addUser(@Valid @RequestBody UserReq userReq){

		User user = new User();
		user.setCode(userReq.getCode());
		user.setName(userReq.getName());
		//由于设置了主键策略 id可不用赋值 会自动生成
		//user.setId(0L);
		userService.insert(user);
		Map<String,String> result = new HashMap<String,String>();
		result.put("respCode", "01");
		result.put("respMsg", "新增成功");
		//事务测试
		//System.out.println(1/0);
		return result;
	}

	@PostMapping("update")
	@ApiOperation(value="用户修改")
	public Map<String,String> updateUser(@Valid @RequestBody UserReq userReq){

		if(userReq.getId() == null || "".equals(userReq.getId())) {
			throw new CommonException("0000", "更新时ID不能为空");
		}
		User user = new User();
		user.setCode(userReq.getCode());
		user.setName(userReq.getName());
		user.setId(Long.parseLong(userReq.getId()));
		userService.updateById(user);
		Map<String,String> result = new HashMap<String,String>();
		result.put("respCode", "01");
		result.put("respMsg", "更新成功");
		return result;
	}

	@GetMapping("/get/{id}")
	@ApiOperation(value="用户查询(ID)")
	@ApiImplicitParam(name="id",value="查询ID",required=true)
	public Map<String,Object> getUser(@PathVariable("id") String id){
		//查询
		User user = userService.selectById(id);
		if(user == null) {
			throw new CommonException("0001", "用户ID：" + id + "，未找到");
		}
		UserResp resp = UserResp.builder()
				.id(user.getId().toString())
				.code(user.getCode())
				.name(user.getName())
				.status(user.getStatus())
				.build();
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("respCode", "01");
		result.put("respMsg", "成功");
		result.put("data", resp);
		return result;
	}

	@GetMapping("/page")
	@ApiOperation(value="用户查询(分页)")
	public Map<String,Object> pageUser(int current, int size){
		//分页
		Page<User> page = new Page<>(current, size);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("respCode", "01");
		result.put("respMsg", "成功");
		result.put("data", userService.selectPage(page));
		return result;
	}
}