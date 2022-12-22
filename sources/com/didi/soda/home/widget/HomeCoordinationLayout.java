package com.didi.soda.home.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.passenger.C10448R;

public class HomeCoordinationLayout extends FrameLayout {

    /* renamed from: a */
    private static final int f43293a = -1;

    /* renamed from: b */
    private SparseArray<View> f43294b = new SparseArray<>();

    /* renamed from: c */
    private SparseArray<View> f43295c = new SparseArray<>();

    public HomeCoordinationLayout(Context context) {
        super(context);
    }

    public HomeCoordinationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HomeCoordinationLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void onViewAdded(View view) {
        int i;
        super.onViewAdded(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if ((layoutParams instanceof LayoutParams) && (i = ((LayoutParams) layoutParams).mDependOnViewId) != -1) {
            this.f43294b.put(i, (Object) null);
            this.f43295c.put(i, view);
        }
    }

    public void onViewRemoved(View view) {
        int i;
        super.onViewRemoved(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if ((layoutParams instanceof LayoutParams) && (i = ((LayoutParams) layoutParams).mDependOnViewId) != -1) {
            this.f43294b.remove(i);
            this.f43295c.remove(i);
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) (LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        m30611a();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof LayoutParams) && (i5 = ((LayoutParams) layoutParams).mDependOnViewId) != -1) {
                m30612a(childAt, i5);
            }
        }
    }

    /* renamed from: a */
    private void m30612a(View view, int i) {
        View view2 = this.f43294b.get(i);
        if (view2 == null) {
            view.layout(0, 0, 0, 0);
        } else {
            view.layout(0, (m30609a(view2) - m30609a(this)) + view2.getHeight(), view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* renamed from: a */
    private void m30611a() {
        View a;
        if (this.f43294b.size() != 0) {
            int size = this.f43294b.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.f43294b.keyAt(i);
                View view = this.f43294b.get(keyAt);
                if (this.f43295c.get(keyAt).getVisibility() == 0 && view == null && (a = m30610a((ViewGroup) this, keyAt)) != null) {
                    this.f43294b.put(keyAt, a);
                }
            }
        }
    }

    /* renamed from: a */
    private View m30610a(ViewGroup viewGroup, int i) {
        View a;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getId() == i) {
                return childAt;
            }
            if ((childAt instanceof ViewGroup) && (a = m30610a((ViewGroup) childAt, i)) != null) {
                return a;
            }
        }
        return null;
    }

    /* renamed from: a */
    private int m30609a(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    class LayoutParams extends FrameLayout.LayoutParams {
        int mDependOnViewId;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.HomeCoordinationLayout);
            this.mDependOnViewId = obtainStyledAttributes.getResourceId(0, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }
}
