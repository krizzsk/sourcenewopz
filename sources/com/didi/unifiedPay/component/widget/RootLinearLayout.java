package com.didi.unifiedPay.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.unifiedPay.util.UIUtils;

public class RootLinearLayout extends LinearLayout {

    /* renamed from: a */
    private boolean f44467a;
    protected int maxHeight;

    public RootLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setClickable(true);
        initMaxHeight();
    }

    public boolean isIntercept() {
        return this.f44467a;
    }

    public void setIntercept(boolean z) {
        this.f44467a = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f44467a;
    }

    /* access modifiers changed from: protected */
    public void initMaxHeight() {
        if (this.maxHeight <= 0) {
            this.maxHeight = UIUtils.getScreenHeight(getContext()) - UIUtils.getStatusBarHeight(getContext());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.maxHeight;
        if (size > i3) {
            size = i3;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }
}
