package com.huato.lottery.service.impl;

import com.huato.lottery.dao.AwardDao;
import com.huato.lottery.pojo.Award;
import com.huato.lottery.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AwardServiceImpl implements AwardService {
    @Autowired
    AwardDao awardDao;

    @Override
    public int insertAward(Award award) {
        return awardDao.insertAward(award);
    }

    @Override
    public int deleteAward(Award award) {
        return awardDao.deleteAward(award);
    }

    @Override
    public void deleteAwards() {
        awardDao.deleteAwards();
    }

    @Override
    public Award queryAward(int level) {
        return awardDao.queryAward(level);
    }
}
