package com.didi.soda.customer.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import com.didi.soda.customer.foundation.skin.SkinUtil;

public abstract class CustomerSkinTagView extends CustomerTagView {
    /* access modifiers changed from: protected */
    public abstract int getCornerRadius();

    /* access modifiers changed from: protected */
    public abstract int getStrokeWidth();

    public CustomerSkinTagView(Context context) {
        super(context);
    }

    public CustomerSkinTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomerSkinTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public Drawable getBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(SkinUtil.getTagBackgroundColor());
        if (getStrokeWidth() > 0) {
            gradientDrawable.setStroke(getStrokeWidth(), SkinUtil.getTagStrokeColor());
        }
        if (getCornerRadius() > 0) {
            gradientDrawable.setCornerRadius((float) getCornerRadius());
        }
        return gradientDrawable;
    }

    public int getTagTextColor() {
        return SkinUtil.getTagTextColor();
    }
}
