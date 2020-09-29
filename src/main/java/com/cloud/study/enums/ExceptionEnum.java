package com.cloud.study.enums;

public enum ExceptionEnum {

    RUNTIME_EXCEPTION(400, "运行错误"),
    UNAUTHORIZED_EXCEPTION(401, "未认证"),
    TOKEN_INVALID_EXCEPTION(402, "token失效"),
    NOT_FOUND_EXCEPTION(404, "接口不存在"),
    REQUEST_TIMEOUT_EXCEPTION(408, "请求超时"),
    PARAM_EXCEPTION(1000, "参数错误"),
    CONNECTION_TIMEOUT_EXCEPTION(4000, "网络原因"),
    FAILED_CAPTCHA_SMS(529, "验证码短信发送失败");

    private int code;
    private String msg;

    private ExceptionEnum(int rCode, String rMsg) {
        this.code = rCode;
        this.msg = rMsg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
