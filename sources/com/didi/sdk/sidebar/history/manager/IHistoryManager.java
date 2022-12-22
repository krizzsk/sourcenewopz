package com.didi.sdk.sidebar.history.manager;

import android.content.Context;
import android.view.View;
import com.didi.sdk.sidebar.history.model.AbsHistoryOrder;
import java.util.Map;

public interface IHistoryManager {
    void bindDateForHistoryItemView(AbsHistoryOrder absHistoryOrder, View view, boolean z);

    void clickHistoryItemView(Context context, AbsHistoryOrder absHistoryOrder);

    void deleteHistoryDate(Context context, AbsHistoryOrder absHistoryOrder, HistoryDeleteCallBack historyDeleteCallBack);

    void exitHistory();

    void getHistoryDate(Context context, Map<String, Object> map, HistoryRequestCallBack historyRequestCallBack);

    View getHistoryItemView(Context context);

    boolean isSupportInvoice();

    boolean isSupportLongClickDelete();
}
