package com.didi.beatles.p099im.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.LinearLayout;

/* renamed from: com.didi.beatles.im.views.IMCheckableLinearLayout */
public class IMCheckableLinearLayout extends LinearLayout implements Checkable {

    /* renamed from: a */
    private static final int[] f9862a = {16842912};

    /* renamed from: b */
    private boolean f9863b = false;

    public IMCheckableLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean isChecked() {
        return this.f9863b;
    }

    public void setChecked(boolean z) {
        if (z != this.f9863b) {
            this.f9863b = z;
            refreshDrawableState();
        }
    }

    public void toggle() {
        setChecked(!this.f9863b);
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f9862a);
        }
        return onCreateDrawableState;
    }
}
