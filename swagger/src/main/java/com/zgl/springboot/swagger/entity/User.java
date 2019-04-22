package com.zgl.springboot.swagger.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zgl
 * @date 2019/4/22 下午3:44
 */
@Data
@Accessors(chain = true)
public class User extends Model<User> {
	private static final long serialVersionUID = 1L;

	/**
	 * 唯一标示
	 */
	@TableId
	private Long id;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 名称
	 */
	private String name;

	/**
	 * 状态1 启用 0 停用
	 */
	private StatusEnum status;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;


	public static final String ID = "id";

	public static final String CODE = "code";

	public static final String NAME = "name";

	public static final String GMT_CREATE = "gmt_create";

	public static final String GMT_MODIFIED = "gmt_modified";


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}