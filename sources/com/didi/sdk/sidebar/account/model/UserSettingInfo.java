package com.didi.sdk.sidebar.account.model;

public class UserSettingInfo {
    public Age age;
    public String company;
    public String firstName;
    public String job;
    public String lang;
    public String lastName;
    public String loaclImageUrl;
    public String nick;
    public String sex = null;
    public String sign;
    public Trade trade;

    public String toString() {
        return "UserSettingInfo{loaclImageUrl='" + this.loaclImageUrl + '\'' + ", nick='" + this.nick + '\'' + ", sex='" + this.sex + '\'' + ", age=" + this.age + ", trade=" + this.trade + ", company='" + this.company + '\'' + ", job='" + this.job + '\'' + ", sign='" + this.sign + '\'' + '}';
    }
}
