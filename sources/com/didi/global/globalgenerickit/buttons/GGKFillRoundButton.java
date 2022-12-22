package com.didi.global.globalgenerickit.buttons;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.global.globalgenerickit.utils.UiUtils;
import com.taxis99.R;

public class GGKFillRoundButton extends AppCompatTextView {
    public GGKFillRoundButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public GGKFillRoundButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GGKFillRoundButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15980a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), UiUtils.dip2px(getContext(), 54.0f));
    }

    /* renamed from: a */
    private void m15980a() {
        setClickable(true);
        setTextSize(20.0f);
        setGravity(17);
        setBackground(DidiThemeManager.getIns().getResPicker(getContext()).getDrawable(R.attr.submit_btn_round_corner_bg_selector));
        setTextColor(DidiThemeManager.getIns().getResPicker(getContext()).getColor(R.attr.submit_btn_text_color_selector));
    }
}
