package com.zgl.springboot.swagger.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zgl.springboot.swagger.dao.UserDao;
import com.zgl.springboot.swagger.entity.User;
import com.zgl.springboot.swagger.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author zgl
 * @date 2019/4/22 下午3:46
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

}
