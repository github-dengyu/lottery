package com.huato.lottery.pojo;

import java.io.Serializable;

public class Winners implements Serializable{
    private static final long serialVersionUID=1L;
    //名单编号
    private int id;
    //抽奖人编号
    private int lid;
    //奖品编号
    private int aid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }
}
