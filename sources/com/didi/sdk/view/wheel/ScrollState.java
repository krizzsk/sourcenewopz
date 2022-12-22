package com.didi.sdk.view.wheel;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class ScrollState {

    /* renamed from: a */
    private Scroller f38315a;

    public ScrollState(Context context) {
        this.f38315a = new Scroller(context);
    }

    public ScrollState(Context context, Interpolator interpolator) {
        this.f38315a = new Scroller(context, interpolator);
    }

    public int getCurrX() {
        return -this.f38315a.getCurrX();
    }

    public int getCurrY() {
        return -this.f38315a.getCurrY();
    }

    public int getFinalX() {
        return -this.f38315a.getFinalX();
    }

    public int getFinalY() {
        return -this.f38315a.getFinalY();
    }

    public boolean shouldScroll() {
        return this.f38315a.computeScrollOffset();
    }

    public void startScroll(int i, int i2, int i3) {
        Scroller scroller = this.f38315a;
        scroller.startScroll(scroller.getCurrX(), this.f38315a.getCurrY(), -i, -i2, i3);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.f38315a.startScroll(i, i2, -i3, -i4, i5);
    }

    public void setStoped() {
        this.f38315a.forceFinished(true);
    }
}
