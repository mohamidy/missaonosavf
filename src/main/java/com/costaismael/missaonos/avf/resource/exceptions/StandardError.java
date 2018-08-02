package com.costaismael.missaonos.avf.resource.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String msg;
	private Long timeStramp;
	
	public StandardError(Integer status, String msg, Long timeStramp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStramp = timeStramp;
	}

	public StandardError() {
		
	};
	
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Long getTimeStramp() {
		return timeStramp;
	}
	public void setTimeStramp(Long timeStramp) {
		this.timeStramp = timeStramp;
	}
}
