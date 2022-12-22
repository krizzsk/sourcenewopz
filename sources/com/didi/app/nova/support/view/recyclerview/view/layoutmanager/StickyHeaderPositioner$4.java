package com.didi.app.nova.support.view.recyclerview.view.layoutmanager;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Map;

class StickyHeaderPositioner$4 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ C3795b this$0;
    final /* synthetic */ View val$view;
    final /* synthetic */ Map val$visibleHeaders;

    StickyHeaderPositioner$4(C3795b bVar, View view, Map map) {
        this.this$0 = bVar;
        this.val$view = view;
        this.val$visibleHeaders = map;
    }

    public void onGlobalLayout() {
        if (Build.VERSION.SDK_INT >= 16) {
            this.val$view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } else {
            this.val$view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
        if (this.this$0.f8654g != null) {
            this.this$0.m5794k().requestLayout();
            this.this$0.mo41428a((Map<Integer, View>) this.val$visibleHeaders);
        }
    }
}
