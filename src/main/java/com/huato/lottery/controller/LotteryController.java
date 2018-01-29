package com.huato.lottery.controller;

import com.huato.lottery.enums.ResultEnum;
import com.huato.lottery.json.LotteryVO;
import com.huato.lottery.pojo.Award;
import com.huato.lottery.pojo.Lottery;
import com.huato.lottery.pojo.Status;
import com.huato.lottery.pojo.Winners;
import com.huato.lottery.result.ResultBean;
import com.huato.lottery.service.AwardService;
import com.huato.lottery.service.LotteryService;
import com.huato.lottery.service.StatusService;
import com.huato.lottery.service.WinnersService;
import com.huato.lottery.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RestController
public class LotteryController {

    @Autowired
    WinnersService winnersService;
    @Autowired
    LotteryService lotteryService;
    @Autowired
    AwardService awardService;
    @Autowired
    StatusService statusService;

    //配置抽奖设置信息(抽奖人个数  奖品等级  每个等级奖品个数)
    @RequestMapping(value = "/queryAllWinners/{aid}/{limit}",method =RequestMethod.GET)
    public ResultBean queryAllWinners(@PathVariable("aid") int aid,@PathVariable("limit") int limit){
        List<Winners> result =  winnersService.queryAllWinners(aid,limit);
        if(result!=null&&result.size()>0){
            return ResultUtils.success(result);
        }
        return ResultUtils.common(ResultEnum.IS_NULL);
    }


    //设置参数 随机插入对应的抽奖人员信息
    @RequestMapping(value = "/gameSettings",method =RequestMethod.POST,produces="application/json;charset=UTF-8")
    public ResultBean gameSettings(@RequestBody LotteryVO lotteryVO){
        //得到一共有多少人参与抽奖
        //非公平锁
        Lock lock = new ReentrantLock();
        if(lotteryVO!=null){
            lock.lock();
            try{
                int number = lotteryVO.getPeople();
                for (int i = 0; i <number ; i++) {
                    Lottery lottery = new Lottery();
                    lottery.setName("lottery"+(i+1));
                    //抽奖次数1
                    lottery.setTimes(1);
                    lottery.setId(i+1);
                    lotteryService.insertLottery(lottery);
                }
                //插入数据 抽奖人编号
                List<Award> list = lotteryVO.getLists();
                for (int i = 0; i < list.size(); i++) {
                    Award award = new Award();
                    award.setId(i+1);
                    award.setName(list.get(i).getName());
                    award.setAccount(list.get(i).getAccount());
                    award.setLevel(list.get(i).getLevel());
                    awardService.insertAward(award);
                }
            }catch (Exception e){
                e.printStackTrace();
                lock.unlock();
                return ResultUtils.common(ResultEnum.INSERT_FAILURE);
            }
            finally {
                lock.unlock();
                return ResultUtils.success();
            }
        }
        return ResultUtils.error();
    }

    //清空所有数据
    @RequestMapping(value = "/clearAll",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultBean clearAll(@RequestHeader HttpHeaders headers ) {
        List<String> list = headers.get("code");
        for (int i = 0; i <list.size() ; i++) {
            System.out.print(list.get(i)+" ");
        }
        Lock lock = new ReentrantLock();
        lock.lock();
        try{
            winnersService.deleteWinners();
            lotteryService.deleteLotterys();
            awardService.deleteAwards();
            statusService.deleteAllStatus();
        }catch (Exception e){
            lock.unlock();
            return ResultUtils.common(ResultEnum.FAILURE);
        }
        finally {
            lock.unlock();
            return ResultUtils.success();
        }

    }

    //产生抽奖名单算法   抽取几等奖
    @RequestMapping(value = "/produceLotteryTickets/{level}",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultBean produceLotteryTickets(@PathVariable("level") int level) {
        //首先根据抽取的level等级查询对应的Award和Lottery信息
        Award award = awardService.queryAward(level);
        if (award != null) {
            //查询当前aid是否已抽
            Status status = statusService.queryStatus(award.getId());
            if (status!=null) {
                //已抽奖
                return ResultUtils.common(ResultEnum.HAS_AWARD);
            } else {
                //未抽奖   则可以进行返回
                //account就是一共有多少个level等奖
                int account = award.getAccount();
                List<Lottery> result = lotteryService.queryLottery(1);
                //产生account个随机数
                Set<Integer> set = new HashSet<Integer>();
                while (true) {
                    int rand = (int) (Math.random() * result.size() + 1);
                    for (int i = 0; i < result.size(); i++) {
                        if (rand == result.get(i).getId()) {
                            set.add(rand);
                            break;
                        }
                    }
                    if (set.size() == account)
                        break;
                }
                for (int i = 0; i < result.size(); i++) {
                    if (set.contains(result.get(i).getId())) {
                        Winners winners = new Winners();
                        winners.setAid(award.getId());
                        winners.setLid(result.get(i).getId());
                        winnersService.insertWinner(winners);
                        Lottery lottery = result.get(i);
                        lottery.setTimes(0);
                        lotteryService.updateLottery(lottery);
                    }
                }
                List<Winners> winners = winnersService.queryAllWinners(award.getId(), account);
                Status status1 = new Status();
                status1.setStatus(1);
                status1.setAid(award.getId());
                statusService.insertStatus(status1);
                return ResultUtils.success(winners);
            }
        } else {
            return ResultUtils.common(ResultEnum.NO_AWARD);
        }
    }





}
