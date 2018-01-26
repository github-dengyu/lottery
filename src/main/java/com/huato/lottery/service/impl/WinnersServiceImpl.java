package com.huato.lottery.service.impl;

import com.huato.lottery.dao.WinnersDao;
import com.huato.lottery.pojo.Winners;
import com.huato.lottery.service.WinnersService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WinnersServiceImpl implements WinnersService {

    @Autowired
   private WinnersDao winnersDao;

    @Override
    public int insertWinner(Winners winners) {
        return winnersDao.insertWinner(winners);
    }
    //全部删除
    @Override
    public int deleteWinners() {
        return winnersDao.deleteWinners();
    }

    @Override
    public int deleteWinner(Winners winner) {
        return winnersDao.deleteWinner(winner);
    }

    @Override
    public List<Winners> queryAllWinners(int aid,int limit) {
        return winnersDao.queryAllWinners(aid,limit);
    }


}

