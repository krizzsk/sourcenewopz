package com.didi.global.globalgenerickit.buttons;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.global.globalgenerickit.utils.UiUtils;
import com.taxis99.R;

public class GGKTextButton extends AppCompatTextView {
    public GGKTextButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public GGKTextButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GGKTextButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15985a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), UiUtils.dip2px(getContext(), 20.0f));
    }

    /* renamed from: a */
    private void m15985a() {
        setClickable(true);
        setTextSize(12.0f);
        setGravity(17);
        int[][] iArr = {new int[]{16842919}, new int[]{-16842910}, new int[0]};
        setTextColor(new ColorStateList(iArr, new int[]{getResources().getColor(R.color.ggk_color_666666), getResources().getColor(R.color.ggk_color_CCCCCC), getResources().getColor(R.color.ggk_color_FE7F3F)}));
    }
}
