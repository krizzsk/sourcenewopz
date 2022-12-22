package com.didi.sdk.sidebar.history.adapter;

import android.content.Context;
import android.widget.BaseAdapter;
import com.didi.sdk.sidebar.history.model.AbsHistoryOrder;
import com.didi.sdk.sidebar.history.view.DropPinnedHeaderList;
import java.util.List;

public abstract class HistoryRecordAdapter extends BaseAdapter implements DropPinnedHeaderList.PinnedHeaderAdapter {
    public abstract List<AbsHistoryOrder> getFinishedOrderList();

    public abstract AbsHistoryOrder getItem(int i);

    public abstract int getOrderCount();

    public abstract void init(Context context, List<AbsHistoryOrder> list, List<AbsHistoryOrder> list2, String str);

    public abstract boolean isEditMode();

    public abstract boolean isFinishOrderByPosition(int i);

    public abstract void removeItem(int i);

    public abstract void setEditMode(boolean z);

    public abstract void setInvoiceMode(boolean z);

    public abstract void updateData(List<AbsHistoryOrder> list, List<AbsHistoryOrder> list2);
}
