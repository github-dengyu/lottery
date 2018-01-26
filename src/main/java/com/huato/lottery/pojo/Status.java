package com.huato.lottery.pojo;

import java.io.Serializable;

public class Status implements Serializable {

    private static final long serialVersionUID=1L;


    private int id;

    private int status;

    private int aid;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }
}
