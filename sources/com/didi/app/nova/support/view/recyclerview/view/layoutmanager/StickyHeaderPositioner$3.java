package com.didi.app.nova.support.view.recyclerview.view.layoutmanager;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;

class StickyHeaderPositioner$3 implements ViewTreeObserver.OnGlobalLayoutListener {
    int previous = this.this$0.m5776c();
    final /* synthetic */ C3795b this$0;
    final /* synthetic */ View val$view;

    StickyHeaderPositioner$3(C3795b bVar, View view) {
        this.this$0 = bVar;
        this.val$view = view;
    }

    public void onGlobalLayout() {
        int i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.val$view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } else {
            this.val$view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
        if (this.this$0.f8654g != null) {
            int c = this.this$0.m5776c();
            if (this.this$0.m5782d() && (i = this.previous) != c) {
                this.this$0.m5778c(i - c);
            }
        }
    }
}
