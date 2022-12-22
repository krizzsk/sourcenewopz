package com.didi.global.globalgenerickit.buttons;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.global.globalgenerickit.utils.UiUtils;
import com.taxis99.R;

public class GGKIconButton extends AppCompatTextView {
    public GGKIconButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public GGKIconButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GGKIconButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15983a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(UiUtils.dip2px(getContext(), 123.0f), UiUtils.dip2px(getContext(), 34.0f));
    }

    /* renamed from: a */
    private void m15983a() {
        setClickable(true);
        setTextSize(15.0f);
        setGravity(17);
        setBackground(DidiThemeManager.getIns().getResPicker(getContext()).getDrawable(R.attr.submit_btn_round_corner_bg_selector));
        setTextColor(DidiThemeManager.getIns().getResPicker(getContext()).getColor(R.attr.submit_btn_text_color_selector));
        Drawable drawable = getResources().getDrawable(R.drawable.ggk_combined_shape);
        drawable.setBounds(30, 6, drawable.getMinimumWidth() + 30, drawable.getMinimumHeight() + 8);
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
