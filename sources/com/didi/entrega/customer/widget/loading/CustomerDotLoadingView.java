package com.didi.entrega.customer.widget.loading;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.entrega.customer.foundation.skin.SkinUtil;

public class CustomerDotLoadingView extends DotLoadingView {
    public CustomerDotLoadingView(Context context) {
        super(context);
        m15029a();
    }

    public CustomerDotLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15029a();
    }

    public CustomerDotLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15029a();
    }

    /* renamed from: a */
    private void m15029a() {
        setColor(SkinUtil.getDotLoadingNormalColor(), SkinUtil.getDotLoadingHighlightColor());
    }
}
