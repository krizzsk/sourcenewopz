package com.didi.unifiedPay.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.unifiedPay.util.UIUtils;

public class PayRootLinearLayout extends RootLinearLayout {
    public PayRootLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void initMaxHeight() {
        if (this.maxHeight <= 0) {
            this.maxHeight = (UIUtils.getScreenHeight(getContext()) - UIUtils.getStatusBarHeight(getContext())) - UIUtils.dip2pxInt(getContext(), 60.0f);
        }
    }
}
