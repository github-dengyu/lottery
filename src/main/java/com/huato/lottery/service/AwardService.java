package com.huato.lottery.service;

import com.huato.lottery.pojo.Award;

public interface AwardService {

    int insertAward(Award award);

    int deleteAward(Award award);

    void deleteAwards();

    Award queryAward(int level);

}
