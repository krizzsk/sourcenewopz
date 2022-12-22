package com.didi.sdk.sidebar.history.manager.soda;

import android.content.Context;
import android.view.View;
import com.didi.sdk.sidebar.history.manager.HistoryDeleteCallBack;
import com.didi.sdk.sidebar.history.manager.HistoryRequestCallBack;
import com.didi.sdk.sidebar.history.manager.IFoodHistoryManager;
import com.didi.sdk.sidebar.history.model.AbsHistoryOrder;
import com.didi.sdk.sidebar.history.store.HistoryRecordStore;
import java.util.Map;

public class FoodHistoryManagerImpl implements IFoodHistoryManager {

    /* renamed from: a */
    private HistoryViewProvider f37387a;

    public void deleteHistoryDate(Context context, AbsHistoryOrder absHistoryOrder, HistoryDeleteCallBack historyDeleteCallBack) {
    }

    public void exitHistory() {
    }

    public boolean isSupportInvoice() {
        return false;
    }

    public boolean isSupportLongClickDelete() {
        return false;
    }

    private FoodHistoryManagerImpl() {
        this.f37387a = new HistoryViewProviderImpl();
    }

    public static FoodHistoryManagerImpl getFoodHistoryManager() {
        return FoodHistoryManagerImplContainer.instance;
    }

    private static class FoodHistoryManagerImplContainer {
        /* access modifiers changed from: private */
        public static FoodHistoryManagerImpl instance = new FoodHistoryManagerImpl();

        private FoodHistoryManagerImplContainer() {
        }
    }

    public void getHistoryDate(Context context, Map<String, Object> map, HistoryRequestCallBack historyRequestCallBack) {
        HistoryRecordStore.getInstance().getSodaHistoryRecords(context, map, historyRequestCallBack);
    }

    public View getHistoryItemView(Context context) {
        return this.f37387a.getItemView(context);
    }

    public void bindDateForHistoryItemView(AbsHistoryOrder absHistoryOrder, View view, boolean z) {
        this.f37387a.bindItem(absHistoryOrder, view);
    }

    public void clickHistoryItemView(Context context, AbsHistoryOrder absHistoryOrder) {
        this.f37387a.clickHistoryItemView(context, absHistoryOrder);
    }
}
