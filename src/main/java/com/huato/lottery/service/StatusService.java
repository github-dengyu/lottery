package com.huato.lottery.service;

import com.huato.lottery.pojo.Award;
import com.huato.lottery.pojo.Status;


public interface StatusService {

    int insertStatus(Status status);

    int deleteStatus(Status Status);

    void deleteAllStatus();

    Status queryStatus(int aid);
}
