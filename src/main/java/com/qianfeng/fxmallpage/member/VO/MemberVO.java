package com.qianfeng.fxmallpage.member.VO;

public class MemberVO {
    private String account;
    private String password;

    public MemberVO() {

    }

    public MemberVO(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "memberVO{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
