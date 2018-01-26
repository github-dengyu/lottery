package com.huato.lottery.dao;

import com.huato.lottery.pojo.Lottery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Component(value = "lotteryDao")
public interface LotteryDao {

    //插入一个获奖名单
    int insertLottery(Lottery lottery);

    //删除一个获奖名单
    int deleteLottery(Lottery lottery);

    void deleteLotterys();

    List<Lottery> queryLottery(@Param("times") int times);

    int updateLottery(Lottery lottery);

}
