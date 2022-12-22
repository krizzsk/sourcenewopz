package com.didi.sdk.sidebar.history.model;

import com.didi.sdk.push.http.BaseObject;
import com.didi.sdk.sidebar.history.model.AbsHistoryOrder;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class HistoryOrdersResponse<T extends AbsHistoryOrder> extends BaseObject {
    @SerializedName("order_done")
    private List<T> doneOrderList;
    @SerializedName("nexttext")
    public String footerText;
    private int havenext;
    private int monthPageHaveNext;
    @SerializedName("next_pagemonth")
    public String nextPageMouth;
    @SerializedName("next_pageindex")
    public int nextPageNum;
    private String pageTips;
    private String timeMode;
    @SerializedName("toast")
    public String toastText;
    private String toastTips;
    @SerializedName("order_waiting")
    private List<T> waitingOrderList;

    public int getHavenext() {
        return this.havenext;
    }

    public void setHavenext(int i) {
        this.havenext = i;
    }

    public String getTimeMode() {
        return this.timeMode;
    }

    public void setTimeMode(String str) {
        this.timeMode = str;
    }

    public List<T> getWaitingOrderList() {
        return this.waitingOrderList;
    }

    public void setWaitingOrderList(List<T> list) {
        this.waitingOrderList = list;
    }

    public List<T> getDoneOrderList() {
        return this.doneOrderList;
    }

    public void setDoneOrderList(List<T> list) {
        this.doneOrderList = list;
    }

    public String getToastTips() {
        return this.toastTips;
    }

    public void setToastTips(String str) {
        this.toastTips = str;
    }

    public String getPageTips() {
        return this.pageTips;
    }

    public void setPageTips(String str) {
        this.pageTips = str;
    }

    public int getMonthPageHaveNext() {
        return this.monthPageHaveNext;
    }

    public void setMonthPageHaveNext(int i) {
        this.monthPageHaveNext = i;
    }
}
