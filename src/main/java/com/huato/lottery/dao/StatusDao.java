package com.huato.lottery.dao;

import com.huato.lottery.pojo.Award;
import com.huato.lottery.pojo.Status;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "statusDao")
public interface StatusDao {


    int insertStatus(Status status);

    int deleteStatus(Status Status);

    void deleteAllStatus();

    Status queryStatus(@Param("aid") int aid);


}
