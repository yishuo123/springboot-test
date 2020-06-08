package com.example.springboottest.core;

import java.util.Map;

public class ResultValue {

	public final static int _SUCCESS = 1;
	public final static int _ERROR = -1;        //操作失败，系统错误
	public final static int _ERROR2 = -2;       //添加失败，非法添加
	
	public final static String ERROR_MSG_1 = "删除失败，系统错误";
	public final static String ERROR_MSG_2 = "操作失败，非法操作";
	public final static String ERROR_MSG_3 = "操作失败，系统错误";
	public final static String ERROR_MSG_ADD = "添加失败，非法添加";
	
	private int state = _ERROR;


	private String message;
	private Map<String, Object> data;
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return state + " | " + message;
	}
}
