package com.didi.sdk.sidebar.history.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OrderAndSessionId implements Serializable {
    @SerializedName("oid")
    private String orderId;
    @SerializedName("protype")
    private int proType;
    @SerializedName("sessionid")
    private String sessionId;

    public String getOrderId() {
        return this.orderId;
    }

    public OrderAndSessionId setOrderId(String str) {
        this.orderId = str;
        return this;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public OrderAndSessionId setSessionId(String str) {
        this.sessionId = str;
        return this;
    }

    public int getProType() {
        return this.proType;
    }

    public OrderAndSessionId setProType(int i) {
        this.proType = i;
        return this;
    }
}
