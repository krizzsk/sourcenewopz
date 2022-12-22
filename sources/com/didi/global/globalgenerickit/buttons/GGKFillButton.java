package com.didi.global.globalgenerickit.buttons;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.global.globalgenerickit.utils.UiUtils;
import com.taxis99.R;

public class GGKFillButton extends AppCompatTextView {
    public GGKFillButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public GGKFillButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GGKFillButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15979a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), UiUtils.dip2px(getContext(), 46.0f));
    }

    /* renamed from: a */
    private void m15979a() {
        setClickable(true);
        setTextSize(16.0f);
        setGravity(17);
        setBackground(DidiThemeManager.getIns().getResPicker(getContext()).getDrawable(R.attr.submit_btn_bg_final_selector));
        setTextColor(DidiThemeManager.getIns().getResPicker(getContext()).getColor(R.attr.submit_btn_text_color_selector));
    }
}
