package com.huato.lottery.pojo;

import java.io.Serializable;


public class Award implements Serializable {

    private static final long serialVersionUID=1L;
    //奖品编号
    private int id;
    //奖品名称
    private String name;
    // 奖品数量
    private int account;
    // 奖品等级
    private int level;

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

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
