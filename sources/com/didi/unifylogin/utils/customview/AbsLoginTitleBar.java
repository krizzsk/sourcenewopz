package com.didi.unifylogin.utils.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public abstract class AbsLoginTitleBar extends RelativeLayout implements ILoginTitiltBar {
    public AbsLoginTitleBar(Context context) {
        super(context);
    }

    public AbsLoginTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbsLoginTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
