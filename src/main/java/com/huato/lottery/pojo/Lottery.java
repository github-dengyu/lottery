package com.huato.lottery.pojo;

import java.io.Serializable;

public class Lottery implements Serializable {

    private static final long serialVersionUID=1L;
    //抽奖人编号
    private int id;
    //人员姓名
    private String name;
    //抽奖次数
    private int times;
    //联系方式
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
