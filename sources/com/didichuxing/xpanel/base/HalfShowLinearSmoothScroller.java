package com.didichuxing.xpanel.base;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;
import com.didichuxing.xpanel.agent.net.LayoutInfo;
import com.didichuxing.xpanel.util.LogcatUtil;

public class HalfShowLinearSmoothScroller extends LinearSmoothScroller {

    /* renamed from: d */
    private static final String f49318d = "HalfShowLinearSmoothScr";

    /* renamed from: a */
    int f49319a;

    /* renamed from: b */
    LayoutInfo.AutoScrollCard f49320b;

    /* renamed from: c */
    Context f49321c;

    public HalfShowLinearSmoothScroller(Context context) {
        super(context);
        this.f49321c = context;
    }

    public void setAutoScrollCard(LayoutInfo.AutoScrollCard autoScrollCard) {
        this.f49320b = autoScrollCard;
    }

    public void setmBottomSpace(int i) {
        this.f49319a = i;
    }

    public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
        LogcatUtil.m35795e(f49318d, "viewStart = " + i + ", viewEnd = " + i2 + ", boxStart = " + i3 + ", boxEnd = " + i4 + ", snapPreference = " + i5 + ", mBottomSpace = " + this.f49319a);
        return (i4 - i2) - this.f49319a;
    }

    /* access modifiers changed from: protected */
    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return super.calculateSpeedPerPixel(displayMetrics) * 2.0f;
    }
}
