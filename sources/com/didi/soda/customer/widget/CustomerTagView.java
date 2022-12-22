package com.didi.soda.customer.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;

public abstract class CustomerTagView extends CustomerAppCompatTextView {
    public abstract Drawable getBackgroundDrawable();

    /* access modifiers changed from: protected */
    public int getTagMaxWidth() {
        return Integer.MAX_VALUE;
    }

    public abstract int getTagTextColor();

    /* access modifiers changed from: protected */
    public ColorStateList getTagTextColorStateList() {
        return null;
    }

    public abstract float getTagTextSize();

    /* access modifiers changed from: protected */
    public boolean isPureTextColor() {
        return true;
    }

    public CustomerTagView(Context context) {
        super(context);
        m29367a();
    }

    public CustomerTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29367a();
    }

    public CustomerTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29367a();
    }

    /* access modifiers changed from: protected */
    public IToolsService.FontType getFontType() {
        return IToolsService.FontType.MEDIUM;
    }

    /* renamed from: a */
    private void m29367a() {
        setBackground(getBackgroundDrawable());
        if (isPureTextColor()) {
            setTextColor(getTagTextColor());
        } else {
            setTextColor(getTagTextColorStateList());
        }
        setTextSize(1, getTagTextSize());
        setMaxWidth(getTagMaxWidth());
        setMaxLines(1);
        setEllipsize(TextUtils.TruncateAt.END);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this, getFontType());
    }
}
