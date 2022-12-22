package com.didi.soda.customer.foundation.rpc.entity;

import android.text.TextUtils;

public class OrderReceiptEntity implements IEntity {
    private static final long serialVersionUID = 1695127337216698172L;
    public String lastMailAddress;
    public int receiptStatus;

    public boolean equals(Object obj) {
        if (!(obj instanceof OrderReceiptEntity)) {
            return false;
        }
        OrderReceiptEntity orderReceiptEntity = (OrderReceiptEntity) obj;
        if (this.receiptStatus != orderReceiptEntity.receiptStatus || !TextUtils.isEmpty(this.lastMailAddress)) {
            return false;
        }
        return this.lastMailAddress.equals(orderReceiptEntity.lastMailAddress);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
