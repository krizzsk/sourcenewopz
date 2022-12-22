package com.didi.sdk.sidebar.history.manager.soda;

import android.content.Context;
import android.view.View;
import com.didi.sdk.sidebar.history.model.AbsHistoryOrder;

public interface HistoryViewProvider {
    void bindItem(AbsHistoryOrder absHistoryOrder, View view);

    void clickHistoryItemView(Context context, AbsHistoryOrder absHistoryOrder);

    View getItemView(Context context);
}
