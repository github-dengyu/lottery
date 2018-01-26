package com.huato.lottery.dao;

import com.huato.lottery.pojo.Winners;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Component(value = "winnersDao")
public interface WinnersDao {

    //产生一个中奖名单
    int insertWinner(Winners winners);

    //清空所有中奖名单记录
    int deleteWinners();

    int deleteWinner(Winners winners);

    //查询中奖名单信息
    List<Winners> queryAllWinners(@Param("aid") int aid,@Param("limit") int limit);


}
