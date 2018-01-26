package com.huato.lottery.service;

import com.huato.lottery.pojo.Winners;

import java.util.List;

public interface WinnersService {
    //产生一个中奖名单
    int insertWinner(Winners winners);

    //清空所有中奖名单记录
    int deleteWinners();

    int deleteWinner(Winners winner);

    //查询中奖名单信息
    List<Winners> queryAllWinners(int aid,int limit);

}
