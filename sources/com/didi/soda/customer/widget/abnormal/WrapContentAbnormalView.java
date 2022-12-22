package com.didi.soda.customer.widget.abnormal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class WrapContentAbnormalView extends AbnormalView {
    public WrapContentAbnormalView(Context context) {
        super(context);
    }

    public WrapContentAbnormalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WrapContentAbnormalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.mContainer.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = -1;
            layoutParams.height = -2;
        }
        super.onMeasure(i, i2);
    }
}
