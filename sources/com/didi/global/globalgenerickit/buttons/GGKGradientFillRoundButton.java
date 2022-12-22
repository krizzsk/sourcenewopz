package com.didi.global.globalgenerickit.buttons;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.global.globalgenerickit.utils.UiUtils;
import com.taxis99.R;

public class GGKGradientFillRoundButton extends AppCompatTextView {
    public GGKGradientFillRoundButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public GGKGradientFillRoundButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GGKGradientFillRoundButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15981a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(UiUtils.dip2px(getContext(), 68.0f), UiUtils.dip2px(getContext(), 29.0f));
    }

    /* renamed from: a */
    private void m15981a() {
        setClickable(true);
        setTextSize(14.0f);
        setGravity(17);
        setBackground(DidiThemeManager.getIns().getResPicker(getContext()).getDrawable(R.attr.submit_btn_round_corner_bg_selector));
        setTextColor(DidiThemeManager.getIns().getResPicker(getContext()).getColor(R.attr.submit_btn_text_color_selector));
    }
}
