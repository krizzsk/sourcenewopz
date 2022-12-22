package com.didi.global.globalgenerickit.buttons;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.global.globalgenerickit.utils.UiUtils;
import com.taxis99.R;

public class GGKGrayStrokeButton extends AppCompatTextView {
    public GGKGrayStrokeButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public GGKGrayStrokeButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GGKGrayStrokeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15982a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), UiUtils.dip2px(getContext(), 46.0f));
    }

    /* renamed from: a */
    private void m15982a() {
        setClickable(true);
        setTextSize(16.0f);
        setGravity(17);
        setBackground(getResources().getDrawable(R.drawable.ggk_gray_stroke_btn_bg));
        int[][] iArr = {new int[]{16842919}, new int[]{-16842910}, new int[0]};
        setTextColor(new ColorStateList(iArr, new int[]{getResources().getColor(R.color.ggk_color_999999), getResources().getColor(R.color.ggk_color_CCCCCC), getResources().getColor(R.color.ggk_color_666666)}));
    }
}
