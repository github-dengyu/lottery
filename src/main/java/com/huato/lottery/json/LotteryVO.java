package com.huato.lottery.json;

import com.huato.lottery.pojo.Award;

import java.io.Serializable;
import java.util.List;

public class LotteryVO implements Serializable {

    private static final long serialVersionUID=1L;

    private int people;

    private List<Award> lists;

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public List<Award> getLists() {
        return lists;
    }

    public void setLists(List<Award> lists) {
        this.lists = lists;
    }
}
