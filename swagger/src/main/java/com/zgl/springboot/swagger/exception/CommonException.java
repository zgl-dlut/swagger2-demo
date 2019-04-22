package com.zgl.springboot.swagger.exception;

/**
 * @author zgl
 * @date 2019/4/22 下午4:06
 */
public class CommonException extends RuntimeException{
	private String code;

	private String msg;

	public CommonException(String code,String msg) {
		super(code + msg);
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}