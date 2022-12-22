package com.didi.soda.customer.widget.goods;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.soda.customer.widget.CustomerSkinTagView;

public class AlcoholRemindTagView extends CustomerSkinTagView {
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

    public AlcoholRemindTagView(Context context) {
        super(context);
        m29502a();
    }

    public AlcoholRemindTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29502a();
    }

    public AlcoholRemindTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29502a();
    }

    /* renamed from: a */
    private void m29502a() {
        setMaxLines(Integer.MAX_VALUE);
    }
}
