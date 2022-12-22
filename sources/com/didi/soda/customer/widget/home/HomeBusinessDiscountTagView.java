package com.didi.soda.customer.widget.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.didi.soda.customer.widget.CustomerTagView;
import com.taxis99.R;

public class HomeBusinessDiscountTagView extends CustomerTagView {
    public float getTagTextSize() {
        return 11.0f;
    }

    public HomeBusinessDiscountTagView(Context context) {
        super(context);
    }

    public HomeBusinessDiscountTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HomeBusinessDiscountTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public Drawable getBackgroundDrawable() {
        return getContext().getResources().getDrawable(R.drawable.customer_shape_home_business_discount_tag);
    }

    public int getTagTextColor() {
        return getContext().getResources().getColor(R.color.rf_color_alert_green_69_1BB17C);
    }
}
