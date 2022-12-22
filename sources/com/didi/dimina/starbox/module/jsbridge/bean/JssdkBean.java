package com.didi.dimina.starbox.module.jsbridge.bean;

import java.util.ArrayList;

public class JssdkBean {

    /* renamed from: a */
    private int f18030a;

    /* renamed from: b */
    private ArrayList<JssdkModuleBean> f18031b;

    /* renamed from: c */
    private String f18032c;

    /* renamed from: d */
    private String f18033d;

    /* renamed from: e */
    private String f18034e;

    /* renamed from: f */
    private int f18035f;

    /* renamed from: g */
    private String f18036g;

    /* renamed from: h */
    private String f18037h;

    public int getGray() {
        return this.f18030a;
    }

    public void setGray(int i) {
        this.f18030a = i;
    }

    public ArrayList<JssdkModuleBean> getModules() {
        return this.f18031b;
    }

    public void setModules(ArrayList<JssdkModuleBean> arrayList) {
        this.f18031b = arrayList;
    }

    public String getAppId() {
        return this.f18032c;
    }

    public void setAppId(String str) {
        this.f18032c = str;
    }

    public String getChannel() {
        return this.f18033d;
    }

    public void setChannel(String str) {
        this.f18033d = str;
    }

    public String getVersion() {
        return this.f18034e;
    }

    public void setVersion(String str) {
        this.f18034e = str;
    }

    public int getPlatform() {
        return this.f18035f;
    }

    public void setPlatform(int i) {
        this.f18035f = i;
    }

    public String getOperator() {
        return this.f18036g;
    }

    public void setOperator(String str) {
        this.f18036g = str;
    }

    public String getOperatorId() {
        return this.f18037h;
    }

    public void setOperatorId(String str) {
        this.f18037h = str;
    }

    public String toString() {
        return "JssdkBean{gray=" + this.f18030a + ", modules=" + this.f18031b + ", appId='" + this.f18032c + '\'' + ", channel='" + this.f18033d + '\'' + ", version='" + this.f18034e + '\'' + ", platform=" + this.f18035f + ", operator='" + this.f18036g + '\'' + ", operatorId='" + this.f18037h + '\'' + '}';
    }
}
