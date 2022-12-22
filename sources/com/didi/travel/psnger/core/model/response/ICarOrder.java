package com.didi.travel.psnger.core.model.response;

import com.didi.sdk.address.address.entity.Address;
import com.didi.travel.psnger.model.response.NextPayResult;
import com.didi.travel.psnger.model.response.OrderRealtimePriceCount;

public interface ICarOrder {
    long getCreateTime();

    String getOid();

    IOrderStatus getOrderStatus();

    int getProductId();

    OrderRealtimePriceCount getRealtimePriceCount();

    Address getStartAddress();

    int getStatus();

    int getSubStatus();

    String getXTag();

    boolean isDirty();

    void setOrderStatus(IOrderStatus iOrderStatus);

    void setPayResult(NextPayResult nextPayResult);

    void setRealtimePriceCount(OrderRealtimePriceCount orderRealtimePriceCount);
}
