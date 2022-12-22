package com.didi.sdk.sidebar.history.manager;

import com.didi.sdk.sidebar.history.model.AbsHistoryOrder;
import com.didi.sdk.sidebar.history.model.HistoryOrdersResponse;

public interface HistoryRequestCallBack<T extends AbsHistoryOrder> {
    void onFailure(int i);

    void onSuccess(HistoryOrdersResponse<T> historyOrdersResponse);
}
