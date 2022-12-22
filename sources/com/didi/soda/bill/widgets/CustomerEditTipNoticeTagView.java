package com.didi.soda.bill.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.soda.customer.widget.CustomerSkinTagView;

public class CustomerEditTipNoticeTagView extends CustomerSkinTagView {
    /* access modifiers changed from: protected */
    public int getCornerRadius() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getStrokeWidth() {
        return 0;
    }

    public float getTagTextSize() {
        return 12.0f;
    }

    public CustomerEditTipNoticeTagView(Context context) {
        super(context);
    }

    public CustomerEditTipNoticeTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomerEditTipNoticeTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
