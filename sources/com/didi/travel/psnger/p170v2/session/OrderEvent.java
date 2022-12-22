package com.didi.travel.psnger.p170v2.session;

import java.io.Serializable;

/* renamed from: com.didi.travel.psnger.v2.session.OrderEvent */
public class OrderEvent implements Serializable {
    private final String mOrderId;
    private final int mPageId;

    public OrderEvent(int i, String str) {
        this.mPageId = i;
        this.mOrderId = str;
    }

    public int getPageId() {
        return this.mPageId;
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    public String toString() {
        return "OrderEvent{mPageId=" + this.mPageId + ", mOrderId='" + this.mOrderId + '\'' + '}';
    }
}
