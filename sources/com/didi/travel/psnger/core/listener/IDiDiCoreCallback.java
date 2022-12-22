package com.didi.travel.psnger.core.listener;

import com.didi.travel.psnger.core.model.response.IOrderStatus;
import com.didi.travel.psnger.model.response.NextPayResult;
import com.didi.travel.psnger.model.response.NextTotalFeeDetail;
import com.didi.travel.psnger.model.response.OrderRealtimePriceCount;

public interface IDiDiCoreCallback {
    void onCarpoolInfoChange();

    void onCommonMessageReceive(int i, String str);

    void onOrderPollTimeChange(int i);

    void onOrderStatusChange(IOrderStatus iOrderStatus);

    void onOrderStatusTimeOut();

    void onPayResultReceive(NextPayResult nextPayResult);

    void onRealtimePriceRefresh(OrderRealtimePriceCount orderRealtimePriceCount);

    void onTotalFeeDetailReceive(NextTotalFeeDetail nextTotalFeeDetail);
}
