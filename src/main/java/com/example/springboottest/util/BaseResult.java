package com.example.springboottest.util;

import java.io.Serializable;

public class BaseResult implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Integer MESSAGE_ERROR = 1;
    public static final Integer MESSAGE_SUCCESS = 0;

    private String message;
    private Object data;
    private Integer state;


    public BaseResult() {
        super();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BaseResult{");
        sb.append("message='").append(message).append('\'');
        sb.append(", data=").append(data);
        sb.append(", state=").append(state);
        sb.append('}');
        return sb.toString();
    }

    public BaseResult(String message, Object data, Integer state) {
        this.message = message;
        this.data = data;
        this.state = state;
    }

    public static Integer getMessageError() {
        return MESSAGE_ERROR;
    }

    public static Integer getMessageSuccess() {
        return MESSAGE_SUCCESS;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
