package com.didi.rfusion.widget.picker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.rfusion.utils.RFResUtils;
import com.taxis99.R;

public class RFPickerViewGroup extends LinearLayout {
    public RFPickerViewGroup(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFPickerViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFPickerViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
    }

    public final void setOrientation(int i) {
        if (i == 0) {
            super.setOrientation(i);
            return;
        }
        throw new RuntimeException("RFPickerViewGroup's orientation must be HORIZONTAL");
    }

    /* access modifiers changed from: protected */
    public void addPickerView(RFPickerView rFPickerView) {
        addPickerView(getChildCount(), rFPickerView);
    }

    /* access modifiers changed from: protected */
    public void addPickerView(int i, RFPickerView rFPickerView) {
        if (rFPickerView != null) {
            addView(rFPickerView, i, new LinearLayout.LayoutParams(0, -2, 1.0f));
            m23707a();
        }
    }

    /* access modifiers changed from: protected */
    public void removePickerView(RFPickerView rFPickerView) {
        removeView(rFPickerView);
        m23707a();
    }

    /* access modifiers changed from: protected */
    public void removeAllPickerViews() {
        removeAllViews();
        m23707a();
    }

    /* renamed from: a */
    private void m23707a() {
        float f;
        int childCount = getChildCount();
        if (childCount == 1) {
            f = RFResUtils.getDimens(getContext(), R.dimen.rf_dimen_24);
        } else if (childCount != 2) {
            f = RFResUtils.getDimens(getContext(), R.dimen.rf_dimen_24);
        } else {
            f = RFResUtils.getDimens(getContext(), R.dimen.rf_dimen_144);
        }
        int i = (int) f;
        setPadding(i, 0, i, 0);
        m23708b();
    }

    /* renamed from: b */
    private void m23708b() {
        int childCount = getChildCount();
        int dimens = (int) RFResUtils.getDimens(R.dimen.rf_dimen_18);
        for (int i = 0; i < childCount; i++) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getChildAt(i).getLayoutParams();
            if (i == childCount - 1) {
                marginLayoutParams.rightMargin = 0;
            } else {
                marginLayoutParams.rightMargin = dimens;
            }
        }
    }
}
