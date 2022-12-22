package com.didi.component.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.didi.component.common.widget.AutofitHelper;

public class AutofitTextView extends TextView implements AutofitHelper.OnTextSizeChangeListener {

    /* renamed from: a */
    private AutofitHelper f11938a;

    public void onTextSizeChange(float f, float f2) {
    }

    public AutofitTextView(Context context) {
        super(context);
        m8060a(context, (AttributeSet) null, 0);
    }

    public AutofitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8060a(context, attributeSet, 0);
    }

    public AutofitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8060a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m8060a(Context context, AttributeSet attributeSet, int i) {
        this.f11938a = AutofitHelper.create(this, attributeSet, i).addOnTextSizeChangeListener(this);
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        AutofitHelper autofitHelper = this.f11938a;
        if (autofitHelper != null) {
            autofitHelper.setTextSize(i, f);
        }
    }

    public void setLines(int i) {
        super.setLines(i);
        AutofitHelper autofitHelper = this.f11938a;
        if (autofitHelper != null) {
            autofitHelper.setMaxLines(i);
        }
    }

    public void setMaxLines(int i) {
        super.setMaxLines(i);
        AutofitHelper autofitHelper = this.f11938a;
        if (autofitHelper != null) {
            autofitHelper.setMaxLines(i);
        }
    }

    public AutofitHelper getAutofitHelper() {
        return this.f11938a;
    }

    public boolean isSizeToFit() {
        return this.f11938a.isEnabled();
    }

    public void setSizeToFit() {
        setSizeToFit(true);
    }

    public void setSizeToFit(boolean z) {
        this.f11938a.setEnabled(z);
    }

    public float getMaxTextSize() {
        return this.f11938a.getMaxTextSize();
    }

    public void setMaxTextSize(float f) {
        this.f11938a.setMaxTextSize(f);
    }

    public void setMaxTextSize(int i, float f) {
        this.f11938a.setMaxTextSize(i, f);
    }

    public float getMinTextSize() {
        return this.f11938a.getMinTextSize();
    }

    public void setMinTextSize(int i) {
        this.f11938a.setMinTextSize(2, (float) i);
    }

    public void setMinTextSize(int i, float f) {
        this.f11938a.setMinTextSize(i, f);
    }

    public float getPrecision() {
        return this.f11938a.getPrecision();
    }

    public void setPrecision(float f) {
        this.f11938a.setPrecision(f);
    }
}
