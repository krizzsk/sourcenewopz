package com.didi.app.nova.support.view.pullToRefresh;

/* renamed from: com.didi.app.nova.support.view.pullToRefresh.a */
/* compiled from: DefaultRefreshOffsetCalculator */
class C3786a implements IRefreshOffsetCalculator {
    public int calculateRefreshOffset(int i, int i2, int i3) {
        return i2 >= i3 ? i2 - i3 : i2 <= 0 ? -i : (int) (((float) i) * (((((float) i2) * 1.0f) / ((float) i3)) - 1.0f));
    }

    C3786a() {
    }
}
