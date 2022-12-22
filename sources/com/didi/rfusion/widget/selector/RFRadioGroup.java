package com.didi.rfusion.widget.selector;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import com.didi.passenger.C10448R;
import com.didi.rfusion.widget.selector.RFSelectorButton;

public class RFRadioGroup extends LinearLayout {

    /* renamed from: a */
    private static final String f33702a = RadioGroup.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f33703b = -1;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RFSelectorButton.OnCheckedChangeListener f33704c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f33705d = false;

    /* renamed from: e */
    private OnCheckedChangeListener f33706e;

    /* renamed from: f */
    private PassThroughHierarchyChangeListener f33707f;

    /* renamed from: g */
    private int f33708g = -1;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(RFRadioGroup rFRadioGroup, int i);
    }

    public RFRadioGroup(Context context) {
        super(context);
        setOrientation(1);
        m23730a();
    }

    public RFRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.RFRadioGroup);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (resourceId != -1) {
            this.f33703b = resourceId;
            this.f33708g = resourceId;
        }
        setOrientation(obtainStyledAttributes.getInt(1, 1));
        obtainStyledAttributes.recycle();
        m23730a();
    }

    /* renamed from: a */
    private void m23730a() {
        this.f33704c = new CheckedStateTracker();
        PassThroughHierarchyChangeListener passThroughHierarchyChangeListener = new PassThroughHierarchyChangeListener();
        this.f33707f = passThroughHierarchyChangeListener;
        super.setOnHierarchyChangeListener(passThroughHierarchyChangeListener);
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        ViewGroup.OnHierarchyChangeListener unused = this.f33707f.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.f33703b;
        if (i != -1) {
            this.f33705d = true;
            m23731a(i, true);
            this.f33705d = false;
            setCheckedId(this.f33703b);
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof RFRadio) {
            RFRadio rFRadio = (RFRadio) view;
            if (rFRadio.isChecked()) {
                this.f33705d = true;
                int i2 = this.f33703b;
                if (i2 != -1) {
                    m23731a(i2, false);
                }
                this.f33705d = false;
                setCheckedId(rFRadio.getId());
            }
        }
        super.addView(view, i, layoutParams);
    }

    public void check(int i) {
        if (i == -1 || i != this.f33703b) {
            int i2 = this.f33703b;
            if (i2 != -1) {
                m23731a(i2, false);
            }
            if (i != -1) {
                m23731a(i, true);
            }
            setCheckedId(i);
        }
    }

    /* access modifiers changed from: private */
    public void setCheckedId(int i) {
        int i2 = this.f33703b;
        this.f33703b = i;
        OnCheckedChangeListener onCheckedChangeListener = this.f33706e;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(this, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23731a(int i, boolean z) {
        View findViewById = findViewById(i);
        if (findViewById != null && (findViewById instanceof RFRadio)) {
            ((RFRadio) findViewById).setChecked(z);
        }
    }

    public int getCheckedRadioId() {
        return this.f33703b;
    }

    public void clearCheck() {
        check(-1);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f33706e = onCheckedChangeListener;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof RadioGroup.LayoutParams;
    }

    /* access modifiers changed from: protected */
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new RadioGroup.LayoutParams(-2, -2);
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        /* access modifiers changed from: protected */
        public void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            if (typedArray.hasValue(i)) {
                this.width = typedArray.getLayoutDimension(i, "layout_width");
            } else {
                this.width = -2;
            }
            if (typedArray.hasValue(i2)) {
                this.height = typedArray.getLayoutDimension(i2, "layout_height");
            } else {
                this.height = -2;
            }
        }
    }

    private class CheckedStateTracker implements RFSelectorButton.OnCheckedChangeListener {
        private CheckedStateTracker() {
        }

        public void onCheckedChanged(RFSelectorButton rFSelectorButton, boolean z) {
            if (!RFRadioGroup.this.f33705d) {
                boolean unused = RFRadioGroup.this.f33705d = true;
                if (RFRadioGroup.this.f33703b != -1) {
                    RFRadioGroup rFRadioGroup = RFRadioGroup.this;
                    rFRadioGroup.m23731a(rFRadioGroup.f33703b, false);
                }
                boolean unused2 = RFRadioGroup.this.f33705d = false;
                RFRadioGroup.this.setCheckedId(rFSelectorButton.getId());
            }
        }
    }

    private class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        /* access modifiers changed from: private */
        public ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;

        private PassThroughHierarchyChangeListener() {
        }

        public void onChildViewAdded(View view, View view2) {
            if (view == RFRadioGroup.this && (view2 instanceof RFRadio)) {
                if (view2.getId() == -1) {
                    view2.setId(View.generateViewId());
                }
                ((RFRadio) view2).setOnCheckedChangeWidgetListener(RFRadioGroup.this.f33704c);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            if (view == RFRadioGroup.this && (view2 instanceof RFRadio)) {
                ((RFRadio) view2).setOnCheckedChangeWidgetListener((RFSelectorButton.OnCheckedChangeListener) null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }
}
