package com.didichuxing.diface.biz.bioassay.fpp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.passenger.C10448R;

public class AutoRatioImageView extends AppCompatImageView {

    /* renamed from: a */
    private float f47251a = -1.0f;

    /* renamed from: b */
    private int f47252b = 0;

    public AutoRatioImageView(Context context) {
        super(context);
    }

    public AutoRatioImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.AutoRatioImageView);
        this.f47251a = obtainStyledAttributes.getFloat(1, -1.0f);
        this.f47252b = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        float f = this.f47251a;
        if (f < 0.0f) {
            if (getDrawable() == null) {
                super.onMeasure(i, i2);
                return;
            }
            int intrinsicWidth = getDrawable().getIntrinsicWidth();
            int intrinsicHeight = getDrawable().getIntrinsicHeight();
            if (this.f47252b == 0) {
                setMeasuredDimension(size, (intrinsicHeight * size) / intrinsicWidth);
            } else {
                setMeasuredDimension((intrinsicWidth * size2) / intrinsicHeight, size2);
            }
        } else if (this.f47252b == 0) {
            setMeasuredDimension(size, (int) (((float) size) * f));
        } else {
            setMeasuredDimension((int) (((float) size2) / f), size);
        }
    }
}
