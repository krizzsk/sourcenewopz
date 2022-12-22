package com.didi.soda.customer.widget.loading;

import android.content.Context;
import android.util.AttributeSet;
import com.taxis99.R;

public class CustomerBottomButtonLoadingView extends DotLoadingView {
    public CustomerBottomButtonLoadingView(Context context) {
        super(context);
        m29674a();
    }

    public CustomerBottomButtonLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29674a();
    }

    public CustomerBottomButtonLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29674a();
    }

    /* renamed from: a */
    private void m29674a() {
        setColor(getContext().getResources().getColor(R.color.rf_color_disable_1_100), getContext().getResources().getColor(R.color.rf_color_jianbian_2));
    }
}
