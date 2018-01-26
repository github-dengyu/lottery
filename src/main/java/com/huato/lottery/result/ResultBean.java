package com.huato.lottery.result;

import java.io.Serializable;
import java.util.Date;

public class ResultBean <T> implements Serializable{
    private final static long serialVersionUID = 1L;

    //错误码
    private int code;
    //错误信息
    private String msg;
    //时间戳
    private Date timestamps;
    //返回的数据
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(Date timestamps) {
        this.timestamps = timestamps;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
