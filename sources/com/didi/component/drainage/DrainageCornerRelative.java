package com.didi.component.drainage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.didi.global.globalgenerickit.utils.UiUtils;
import com.didi.global.globaluikit.widget.RoundCornerRelativeLayout;
import com.taxis99.R;

public class DrainageCornerRelative extends RoundCornerRelativeLayout {

    /* renamed from: b */
    private View f12810b;

    /* renamed from: c */
    private View f12811c;

    public DrainageCornerRelative(Context context) {
        super(context);
    }

    public DrainageCornerRelative(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DrainageCornerRelative(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f12810b == null) {
            this.f12810b = findViewById(R.id.drainage_tips);
        }
        if (this.f12811c == null) {
            this.f12811c = findViewById(R.id.img);
        }
        if (this.f12810b != null && this.f12811c != null) {
            setMeasuredDimension(getMeasuredWidth(), this.f12810b.getMeasuredHeight() + this.f12811c.getMeasuredHeight() + (UiUtils.dip2px(getContext(), 24.0f) * 2));
        }
    }
}
