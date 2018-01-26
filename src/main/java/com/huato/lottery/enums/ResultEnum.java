package com.huato.lottery.enums;

/**
 *
 */
public enum ResultEnum {

    SUCCESS(1,"请求成功"),
    FAILURE(0,"请求失败"),
    INSERT_FAILURE(100,"插入失败"),
    NO_AWARD(101,"你输入的奖项等级不存在!"),
    IS_NULL(102,"你查询的信息不存在!"),
    HAS_AWARD(103,"你输入的抽奖等级已抽完!"),
    ;

    private Integer code;

    private String msg;

    private Long timestamp;

    ResultEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;

    }
    ResultEnum(Integer code, String msg, Long timestamp) {
        this.code = code;
        this.msg = msg;
        this.timestamp = timestamp;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
