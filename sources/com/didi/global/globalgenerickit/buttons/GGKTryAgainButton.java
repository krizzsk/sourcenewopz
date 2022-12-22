package com.didi.global.globalgenerickit.buttons;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.global.globalgenerickit.utils.UiUtils;
import com.taxis99.R;

public class GGKTryAgainButton extends AppCompatTextView {
    public GGKTryAgainButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public GGKTryAgainButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GGKTryAgainButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15986a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(UiUtils.dip2px(getContext(), 77.0f), UiUtils.dip2px(getContext(), 24.0f));
    }

    /* renamed from: a */
    private void m15986a() {
        setClickable(true);
        setTextSize(10.0f);
        setTextColor(getResources().getColor(R.color.ggk_color_333333));
        setGravity(17);
        setBackground(getResources().getDrawable(R.drawable.ggk_tryagain_btn_bg));
        Drawable drawable = getResources().getDrawable(R.drawable.ggk_tryagain_shape);
        drawable.setBounds(20, 5, 55, drawable.getMinimumHeight() + 5);
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
