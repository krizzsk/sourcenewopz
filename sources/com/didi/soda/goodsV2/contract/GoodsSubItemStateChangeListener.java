package com.didi.soda.goodsV2.contract;

public interface GoodsSubItemStateChangeListener {

    /* renamed from: com.didi.soda.goodsV2.contract.GoodsSubItemStateChangeListener$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$showRemindAnimation(GoodsSubItemStateChangeListener goodsSubItemStateChangeListener, String str) {
        }
    }

    boolean canSubItemSelected(String str);

    void onSelectionStateChanged(String str, String str2, boolean z);

    void resetSelectionState(String str, boolean z);

    void showRemindAnimation(String str);
}
