package com.cloud.study.enums;


/**
 * @Author dqq
 */
public enum ErrorCodeEnum {

    USER_PASSWORD_ERROR(10001, "密码错误!"),
    USER_ACCOUNT_ERROR(10002, "账号错误!"),
    NOT_EXIST_USER(10003,"用户不存在!"),
    NO_LOGIN(10004,"未登录!"),
    NOT_PERMISSION(10005,"权限不足!"),
    MISS_REQUEST_HEADER(10006,"请求头缺失Authorization!"),
    EXCHANGE_JSON_ERROR(10007,"json转换异常!");

    private int code = 0;
    private String msg = "";

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

}
