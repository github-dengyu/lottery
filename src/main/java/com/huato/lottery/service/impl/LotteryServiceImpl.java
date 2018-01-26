package com.huato.lottery.service.impl;

import com.huato.lottery.dao.LotteryDao;
import com.huato.lottery.pojo.Lottery;
import com.huato.lottery.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryServiceImpl implements LotteryService {
    @Autowired
    LotteryDao lotteryDao;

    @Override
    public int insertLottery(Lottery lottery) {
        return lotteryDao.insertLottery(lottery);
    }

    @Override
    public int deleteLottery(Lottery lottery) {
        return lotteryDao.deleteLottery(lottery);
    }

    @Override
    public void deleteLotterys() {
        lotteryDao.deleteLotterys();
    }

    @Override
    public List<Lottery> queryLottery(int times) {
        return lotteryDao.queryLottery(times);
    }

    @Override
    public int updateLottery(Lottery lottery) {
        return lotteryDao.updateLottery(lottery);
    }
}
