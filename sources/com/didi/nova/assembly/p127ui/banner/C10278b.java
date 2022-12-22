package com.didi.nova.assembly.p127ui.banner;

import android.content.Context;
import android.widget.Scroller;

/* renamed from: com.didi.nova.assembly.ui.banner.b */
/* compiled from: BannerScroller */
class C10278b extends Scroller {

    /* renamed from: a */
    private int f29253a;

    public C10278b(Context context, int i) {
        super(context);
        this.f29253a = i;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.f29253a);
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.f29253a);
    }
}
