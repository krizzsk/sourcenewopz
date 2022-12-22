package com.didi.component.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.didi.passenger.C10448R;
import com.duolingo.open.rtlviewpager.RtlViewPager;

public class CustomeViewPager extends RtlViewPager {

    /* renamed from: a */
    private boolean f11815a = true;

    /* renamed from: b */
    private boolean f11816b = false;

    public CustomeViewPager(Context context) {
        super(context);
    }

    public CustomeViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.CustomeViewPager);
        this.f11815a = obtainStyledAttributes.getBoolean(0, true);
        this.f11816b = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f11816b) {
            int i3 = 0;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                childAt.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i3) {
                    i3 = measuredHeight;
                }
            }
            i2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public boolean canScrollHorizontally(int i) {
        return this.f11815a;
    }
}
