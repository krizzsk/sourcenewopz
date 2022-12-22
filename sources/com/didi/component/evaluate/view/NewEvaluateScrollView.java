package com.didi.component.evaluate.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

public class NewEvaluateScrollView extends ScrollView {

    /* renamed from: a */
    private int f13346a;

    public NewEvaluateScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NewEvaluateScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setMaxHeight(int i) {
        this.f13346a = i;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = this.f13346a;
        if (i3 > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }
}
