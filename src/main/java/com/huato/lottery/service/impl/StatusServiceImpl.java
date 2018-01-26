package com.huato.lottery.service.impl;

import com.huato.lottery.dao.StatusDao;
import com.huato.lottery.pojo.Award;
import com.huato.lottery.pojo.Status;
import com.huato.lottery.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    StatusDao statusDao;

    @Override
    public int insertStatus(Status status) {
        return statusDao.insertStatus(status);
    }

    @Override
    public int deleteStatus(Status status) {
        return statusDao.deleteStatus(status);
    }

    @Override
    public void deleteAllStatus() {
        statusDao.deleteAllStatus();
    }

    @Override
    public Status queryStatus(int aid) {
        return statusDao.queryStatus(aid);
    }
}
