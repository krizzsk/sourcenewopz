package com.didi.dimina.starbox.module.jsbridge.bean;

import java.util.ArrayList;

public class JssdkData {

    /* renamed from: a */
    private ArrayList<JssdkBean> f18038a;

    /* renamed from: b */
    private int f18039b;

    public ArrayList<JssdkBean> getData() {
        return this.f18038a;
    }

    public void setData(ArrayList<JssdkBean> arrayList) {
        this.f18038a = arrayList;
    }

    public int getErrorCode() {
        return this.f18039b;
    }

    public void setErrorCode(int i) {
        this.f18039b = i;
    }

    public String toString() {
        return "JssdkData{data=" + this.f18038a + ", errorCode=" + this.f18039b + '}';
    }
}
