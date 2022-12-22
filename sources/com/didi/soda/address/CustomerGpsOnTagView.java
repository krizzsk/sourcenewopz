package com.didi.soda.address;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.widget.CustomerSkinTagView;

public class CustomerGpsOnTagView extends CustomerSkinTagView {
    public float getTagTextSize() {
        return 14.0f;
    }

    public CustomerGpsOnTagView(Context context) {
        super(context);
    }

    public CustomerGpsOnTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomerGpsOnTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public int getStrokeWidth() {
        return DisplayUtils.dip2px(getContext(), 0.5f);
    }

    /* access modifiers changed from: protected */
    public int getCornerRadius() {
        return DisplayUtils.dip2px(getContext(), 2.5f);
    }
}
