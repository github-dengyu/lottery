package com.huato.lottery.dao;

import com.huato.lottery.pojo.Award;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
@Component(value = "awardDao")
public interface AwardDao {

    //插入一个奖品
    int insertAward(Award award);

    //删除一个奖品
    int deleteAward(Award award);

    void deleteAwards();

    Award queryAward(@Param("level") int level);
}
