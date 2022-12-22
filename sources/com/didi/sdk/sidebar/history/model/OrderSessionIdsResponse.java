package com.didi.sdk.sidebar.history.model;

import com.didi.sdk.push.http.BaseObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class OrderSessionIdsResponse extends BaseObject {
    @SerializedName("sessioninfos")
    private List<OrderAndSessionId> orderAndSessionIdList;
    private String uid;

    public String getUid() {
        return this.uid;
    }

    public OrderSessionIdsResponse setUid(String str) {
        this.uid = str;
        return this;
    }

    public List<OrderAndSessionId> getOrderAndSessionIdList() {
        return this.orderAndSessionIdList;
    }

    public OrderSessionIdsResponse setOrderAndSessionIdList(List<OrderAndSessionId> list) {
        this.orderAndSessionIdList = list;
        return this;
    }
}
