package com.didi.soda.customer.widget.cart;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.widget.CustomerSkinTagView;

public class CustomerMaxCartAddressTagView extends CustomerSkinTagView {
    /* access modifiers changed from: protected */
    public int getStrokeWidth() {
        return 0;
    }

    public float getTagTextSize() {
        return 11.0f;
    }

    public CustomerMaxCartAddressTagView(Context context) {
        super(context);
    }

    public CustomerMaxCartAddressTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomerMaxCartAddressTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public Drawable getBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(SkinUtil.getBrandPrimaryColor());
        gradientDrawable.setAlpha(36);
        if (getStrokeWidth() > 0) {
            gradientDrawable.setStroke(getStrokeWidth(), SkinUtil.getTagStrokeColor());
        }
        if (getCornerRadius() > 0) {
            gradientDrawable.setCornerRadius((float) getCornerRadius());
        }
        return gradientDrawable;
    }

    /* access modifiers changed from: protected */
    public int getCornerRadius() {
        return DisplayUtils.dip2px(getContext(), 2.0f);
    }
}
