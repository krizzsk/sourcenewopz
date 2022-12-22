package com.didi.dimina.container.p106ui.refresh;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* renamed from: com.didi.dimina.container.ui.refresh.AbsOverView */
public abstract class AbsOverView extends FrameLayout {
    public int mPullRefreshHeight;
    protected HiRefreshState mState = HiRefreshState.STATE_INIT;
    public float maxDamp = 2.2f;
    public float minDamp = 1.6f;

    /* renamed from: com.didi.dimina.container.ui.refresh.AbsOverView$HiRefreshState */
    public enum HiRefreshState {
        STATE_INIT,
        STATE_VISIBLE,
        STATE_OVER,
        STATE_REFRESH,
        STATE_OVER_RELEASE
    }

    public abstract void init();

    public abstract void onFinish();

    public abstract void onOver();

    public abstract void onRefresh();

    /* access modifiers changed from: protected */
    public abstract void onScroll(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract void onVisible();

    public AbsOverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        preInit();
    }

    public AbsOverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        preInit();
    }

    public AbsOverView(Context context) {
        super(context);
        preInit();
    }

    /* access modifiers changed from: protected */
    public void preInit() {
        this.mPullRefreshHeight = (int) ((Resources.getSystem().getDisplayMetrics().density * 66.0f) + 0.5f);
        init();
    }

    public void setState(HiRefreshState hiRefreshState) {
        this.mState = hiRefreshState;
    }

    public HiRefreshState getState() {
        return this.mState;
    }
}
