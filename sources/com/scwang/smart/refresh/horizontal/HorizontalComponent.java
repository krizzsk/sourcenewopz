package com.scwang.smart.refresh.horizontal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.scwang.smart.refresh.layout.api.RefreshComponent;
import com.scwang.smart.refresh.layout.simple.SimpleComponent;
import java.util.ArrayList;
import java.util.List;

public abstract class HorizontalComponent extends SimpleComponent {

    /* renamed from: a */
    private List<View> f55981a = new ArrayList();

    protected HorizontalComponent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWrappedView = this;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof RefreshComponent) {
                this.mWrappedInternal = (RefreshComponent) childAt;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mWrappedInternal == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof RefreshComponent) {
                    this.mWrappedInternal = (RefreshComponent) childAt;
                }
            }
        }
    }

    public boolean isLayoutRequested() {
        return this.f55981a.size() > 0 || super.isLayoutRequested();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f55981a.clear();
        super.onMeasure(i2, i);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0) {
                this.f55981a.add(childAt);
                childAt.setVisibility(8);
            }
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824));
        for (View visibility : this.f55981a) {
            visibility.setVisibility(0);
        }
        this.f55981a.clear();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        super.onLayout(z, i, i2, i3, i4);
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 0) {
                int left = childAt.getLeft();
                int top = childAt.getTop();
                int right = childAt.getRight();
                int bottom = childAt.getBottom();
                int i7 = right - left;
                int i8 = bottom - top;
                int i9 = i5 - bottom;
                int i10 = (((i9 + i8) + i9) / 2) - (i7 / 2);
                int i11 = (((left + i7) + left) / 2) - (i8 / 2);
                childAt.setRotation(90.0f);
                childAt.layout(i10, i11, i7 + i10, i8 + i11);
            }
        }
    }
}
