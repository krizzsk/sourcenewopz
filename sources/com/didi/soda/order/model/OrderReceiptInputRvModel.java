package com.didi.soda.order.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.OrderReceiptInfoEntity;

public class OrderReceiptInputRvModel implements RecyclerModel {
    public boolean mIsOrderFinished;
    public boolean mailVerified;
    public String receiptMail;
    public String receiptName;

    public static OrderReceiptInputRvModel newInstance(OrderReceiptInfoEntity orderReceiptInfoEntity, boolean z) {
        OrderReceiptInputRvModel orderReceiptInputRvModel = new OrderReceiptInputRvModel();
        orderReceiptInputRvModel.receiptName = orderReceiptInfoEntity.receiptUp;
        orderReceiptInputRvModel.receiptMail = orderReceiptInfoEntity.email;
        boolean z2 = true;
        if (orderReceiptInfoEntity.status != 1) {
            z2 = false;
        }
        orderReceiptInputRvModel.mailVerified = z2;
        orderReceiptInputRvModel.mIsOrderFinished = z;
        return orderReceiptInputRvModel;
    }
}
