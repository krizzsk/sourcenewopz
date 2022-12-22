package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class WalletScrollView extends ScrollView {

    /* renamed from: a */
    private boolean f32482a = true;

    public WalletScrollView(Context context) {
        super(context);
    }

    public WalletScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f32482a) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public void setScrollable(boolean z) {
        this.f32482a = z;
    }

    public boolean canScrollVertically(int i) {
        if (this.f32482a) {
            return super.canScrollVertically(i);
        }
        return false;
    }

    public boolean canScrollHorizontally(int i) {
        if (this.f32482a) {
            return super.canScrollHorizontally(i);
        }
        return false;
    }
}
