package com.didi.global.globalgenerickit.buttons;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.global.globalgenerickit.utils.UiUtils;
import com.taxis99.R;

public class GGKStrokeRoundButton extends AppCompatTextView {
    public GGKStrokeRoundButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public GGKStrokeRoundButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GGKStrokeRoundButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15984a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(UiUtils.dip2px(getContext(), 68.0f), UiUtils.dip2px(getContext(), 29.0f));
    }

    /* renamed from: a */
    private void m15984a() {
        setClickable(true);
        setTextSize(14.0f);
        setGravity(17);
        setBackground(getResources().getDrawable(R.drawable.ggk_stroke_round_btn_bg));
        int[][] iArr = {new int[]{-16842910}, new int[0]};
        setTextColor(new ColorStateList(iArr, new int[]{getResources().getColor(R.color.ggk_color_CCCCCC), getResources().getColor(R.color.ggk_color_FE7F3F)}));
    }
}
