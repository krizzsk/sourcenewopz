package com.didi.component.payentrance.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class FlowLinearLayout extends LinearLayout {
    /* renamed from: a */
    private int m10768a(int i, int i2, int i3, int i4) {
        return i2 == 1 ? i4 : (i4 - i3) + i;
    }

    public FlowLinearLayout(Context context) {
        super(context);
    }

    public FlowLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int childCount = getChildCount();
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                childAt.measure(0, 0);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i6) {
                    i5 = m10768a(i5, i3, i6, measuredHeight);
                    i6 = measuredHeight;
                }
                i7 += measuredWidth;
                if (i7 > size) {
                    i3++;
                    i5 += measuredHeight;
                    i7 = measuredWidth;
                    i6 = 0;
                }
                i4++;
            } else {
                return;
            }
        }
        setMeasuredDimension(size, i5 + getPaddingTop() + getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int i5 = 0;
        int i6 = 0;
        int i7 = 1;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i6) {
                    i6 = measuredHeight;
                }
                paddingLeft += measuredWidth;
                if (paddingLeft > i3) {
                    paddingLeft = getPaddingLeft() + measuredWidth;
                    i7++;
                }
                int paddingTop = getPaddingTop() + (i7 * i6);
                childAt.layout(paddingLeft - measuredWidth, paddingTop - i6, paddingLeft, paddingTop);
                i5++;
            } else {
                return;
            }
        }
    }
}
