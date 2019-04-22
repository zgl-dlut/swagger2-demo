package com.zgl.springboot.swagger.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zgl
 * @date 2019/4/22 下午3:49
 */
@Configuration
//@MapperScan("com.zgl.springboot.swagger.dao")
@ImportResource(locations = {"classpath:/mybatis/spring-mybatis.xml"})
public class MybatisPlusConfiguration {
}