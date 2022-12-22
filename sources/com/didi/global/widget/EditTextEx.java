package com.didi.global.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.EditText;

public class EditTextEx extends EditText {
    public EditTextEx(Context context) {
        super(context);
    }

    public EditTextEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EditTextEx(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public EditTextEx(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void layout(int i, int i2, int i3, int i4) {
        super.layout(i, i2, i3, i4);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
    }

    public int getCompoundPaddingTop() {
        return super.getCompoundPaddingTop();
    }

    public int getExtendedPaddingTop() {
        return super.getExtendedPaddingTop();
    }

    public int getTotalPaddingTop() {
        return super.getTotalPaddingTop();
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return super.onApplyWindowInsets(windowInsets);
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
    }

    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        return super.dispatchApplyWindowInsets(windowInsets);
    }
}
