package com.didi.soda.customer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;

public class StatusBarView extends RelativeLayout {
    public StatusBarView(Context context) {
        super(context);
    }

    public StatusBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StatusBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public StatusBarView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(CustomerSystemUtil.getImmersiveStatusBarHeight(getContext()), 1073741824));
    }
}
