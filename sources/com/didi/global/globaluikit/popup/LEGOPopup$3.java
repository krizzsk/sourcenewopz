package com.didi.global.globaluikit.popup;

import android.view.View;

class LEGOPopup$3 implements Runnable {
    final /* synthetic */ C8665a this$0;
    final /* synthetic */ View val$v;
    final /* synthetic */ int val$x;
    final /* synthetic */ int val$y;

    LEGOPopup$3(C8665a aVar, View view, int i, int i2) {
        this.this$0 = aVar;
        this.val$v = view;
        this.val$x = i;
        this.val$y = i2;
    }

    public void run() {
        try {
            this.this$0.showAsDropDown(this.val$v, this.val$x, this.val$y);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
