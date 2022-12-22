package com.didi.soda.customer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.didi.passenger.C10448R;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.sofa.utils.UiUtils;
import com.taxis99.R;

public class NumBubbleTextView extends CustomerAppCompatTextView {
    public NumBubbleTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NumBubbleTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NumBubbleTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29378a(context, attributeSet);
    }

    public void setNum(int i) {
        if (i > 99) {
            setText("99+");
        } else {
            setText(String.valueOf(i));
        }
    }

    /* renamed from: a */
    private void m29378a(Context context, AttributeSet attributeSet) {
        int dip2px = UiUtils.dip2px(context, 15.0f);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.NumBubbleTextView);
            dip2px = obtainStyledAttributes.getDimensionPixelSize(0, dip2px);
            obtainStyledAttributes.recycle();
        }
        setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_num_bubble));
        setTextColor(getResources().getColor(R.color.rf_color_white_100_FFFFFF));
        int dip2px2 = UiUtils.dip2px(context, 4.0f);
        int dip2px3 = UiUtils.dip2px(context, 1.0f);
        setPadding(dip2px2, dip2px3, dip2px2, dip2px3);
        setGravity(17);
        setMinWidth(dip2px);
        setSingleLine();
    }
}
