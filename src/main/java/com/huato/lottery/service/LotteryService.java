package com.huato.lottery.service;

import com.huato.lottery.pojo.Lottery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LotteryService {
    //插入一个获奖名单
    int insertLottery(Lottery lottery);

    //删除一个获奖名单
    int deleteLottery(Lottery lottery);

    void deleteLotterys();

    List<Lottery> queryLottery(int times);

    int updateLottery(Lottery lottery);

}
