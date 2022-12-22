package com.didi.soda.customer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.passenger.C10448R;
import com.didi.soda.customer.app.GlobalContext;

public class RoundImageView extends AppCompatImageView {

    /* renamed from: g */
    private static final int f41548g = DisplayUtils.dip2px(GlobalContext.getContext(), 8.0f);

    /* renamed from: a */
    float f41549a;

    /* renamed from: b */
    float f41550b;

    /* renamed from: c */
    int f41551c;

    /* renamed from: d */
    int f41552d;

    /* renamed from: e */
    int f41553e;

    /* renamed from: f */
    int f41554f;

    public RoundImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29379a(context, attributeSet, i);
    }

    public void setCorner(int i, int i2, int i3, int i4) {
        this.f41551c = i;
        this.f41552d = i2;
        this.f41553e = i3;
        this.f41554f = i4;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f41549a = (float) getWidth();
        this.f41550b = (float) getHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int max = Math.max(0, this.f41551c);
        int max2 = Math.max(0, this.f41553e);
        int max3 = Math.max(0, this.f41552d);
        int max4 = Math.max(0, this.f41554f);
        Path path = new Path();
        float f = this.f41549a;
        if (f > ((float) (max + max3)) && f > ((float) (max2 + max4))) {
            float f2 = this.f41550b;
            if (f2 > ((float) (max3 + max4)) && f2 > ((float) (max + max2))) {
                float f3 = (float) max;
                path.moveTo(0.0f, f3);
                if (max > 0) {
                    path.quadTo(0.0f, 0.0f, f3, 0.0f);
                }
                float f4 = (float) max3;
                path.lineTo(this.f41549a - f4, 0.0f);
                if (max3 > 0) {
                    float f5 = this.f41549a;
                    path.quadTo(f5, 0.0f, f5, f4);
                }
                float f6 = (float) max4;
                path.lineTo(this.f41549a, this.f41550b - f6);
                if (max4 > 0) {
                    float f7 = this.f41549a;
                    float f8 = this.f41550b;
                    path.quadTo(f7, f8, f7 - f6, f8);
                }
                float f9 = (float) max2;
                path.lineTo(f9, this.f41550b);
                if (max2 > 0) {
                    float f10 = this.f41550b;
                    path.quadTo(0.0f, f10, 0.0f, f10 - f9);
                }
                path.lineTo(0.0f, (float) this.f41551c);
            }
        }
        canvas.clipPath(path);
        super.onDraw(canvas);
    }

    /* renamed from: a */
    private void m29379a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.RoundImageView, i, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, f41548g);
        this.f41551c = obtainStyledAttributes.getDimensionPixelSize(2, dimensionPixelSize);
        this.f41553e = obtainStyledAttributes.getDimensionPixelSize(1, dimensionPixelSize);
        this.f41552d = obtainStyledAttributes.getDimensionPixelSize(5, dimensionPixelSize);
        this.f41554f = obtainStyledAttributes.getDimensionPixelSize(4, dimensionPixelSize);
        obtainStyledAttributes.recycle();
    }
}
