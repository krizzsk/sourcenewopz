package com.didi.travel.psnger.core.listener;

import com.didi.travel.psnger.core.model.response.IOrderStatus;
import com.didi.travel.psnger.model.response.NextPayResult;
import com.didi.travel.psnger.model.response.NextTotalFeeDetail;
import com.didi.travel.psnger.model.response.OrderRealtimePriceCount;

public class DefaultDiDiCoreCallback implements IDiDiCoreCallback {
    public void onCarpoolInfoChange() {
    }

    public void onCommonMessageReceive(int i, String str) {
    }

    public void onOrderPollTimeChange(int i) {
    }

    public void onOrderStatusChange(IOrderStatus iOrderStatus) {
    }

    public void onOrderStatusTimeOut() {
    }

    public void onPayResultReceive(NextPayResult nextPayResult) {
    }

    public void onRealtimePriceRefresh(OrderRealtimePriceCount orderRealtimePriceCount) {
    }

    public void onTotalFeeDetailReceive(NextTotalFeeDetail nextTotalFeeDetail) {
    }
}
