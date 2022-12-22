package com.didi.soda.customer.widget.home;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.widget.CustomerSkinTagView;

public class HomeBusinessAttributeTagView extends CustomerSkinTagView {
    /* access modifiers changed from: protected */
    public int getStrokeWidth() {
        return 0;
    }

    public float getTagTextSize() {
        return 11.0f;
    }

    public HomeBusinessAttributeTagView(Context context) {
        super(context);
    }

    public HomeBusinessAttributeTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HomeBusinessAttributeTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public int getCornerRadius() {
        return DisplayUtils.dip2px(getContext(), 2.0f);
    }
}
