package com.huato.lottery.utils;

import com.huato.lottery.enums.ResultEnum;
import com.huato.lottery.result.ResultBean;

import java.util.Date;

/**
 * 返回结果集的工具类
 */
public class ResultUtils {

    public static ResultBean success(Object object){
        ResultBean<Object> resultBean = new ResultBean<>();
        resultBean.setCode(1);
        resultBean.setMsg("请求成功");
        resultBean.setData(object);
        resultBean.setTimestamps(new Date());
        return resultBean;
    }

    public static ResultBean success(){
        return success(null);
    }

    public static ResultBean error(){
        ResultBean<Object> resultBean = new ResultBean<>();
        resultBean.setCode(0);
        resultBean.setMsg("请求失败");
        resultBean.setData(null);
        resultBean.setTimestamps(new Date());
        return resultBean;
    }


    public static ResultBean common(ResultEnum resultEnum){
        ResultBean<Object> resultBean = new ResultBean<>();
        resultBean.setCode(resultEnum.getCode());
        resultBean.setMsg(resultEnum.getMsg());
        resultBean.setTimestamps(new Date());
        resultBean.setData(null);
        return resultBean;
    }


}
