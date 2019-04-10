package com.qianfeng.fxmallpage.member.VO;

public class JsonVO {
    private int code;
    private String msg;

    public JsonVO() {
    }

    public JsonVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
