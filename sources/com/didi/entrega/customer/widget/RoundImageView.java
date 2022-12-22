package com.didi.entrega.customer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.passenger.C10448R;

public class RoundImageView extends AppCompatImageView {

    /* renamed from: g */
    private static final int f20321g = DisplayUtils.dip2px(GlobalContext.getContext(), 8.0f);

    /* renamed from: a */
    float f20322a;

    /* renamed from: b */
    float f20323b;

    /* renamed from: c */
    int f20324c;

    /* renamed from: d */
    int f20325d;

    /* renamed from: e */
    int f20326e;

    /* renamed from: f */
    int f20327f;

    public RoundImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14907a(context, attributeSet, i);
    }

    public void setCorner(int i, int i2, int i3, int i4) {
        this.f20324c = i;
        this.f20325d = i2;
        this.f20326e = i3;
        this.f20327f = i4;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f20322a = (float) getWidth();
        this.f20323b = (float) getHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int max = Math.max(0, this.f20324c);
        int max2 = Math.max(0, this.f20326e);
        int max3 = Math.max(0, this.f20325d);
        int max4 = Math.max(0, this.f20327f);
        Path path = new Path();
        float f = this.f20322a;
        if (f > ((float) (max + max3)) && f > ((float) (max2 + max4))) {
            float f2 = this.f20323b;
            if (f2 > ((float) (max3 + max4)) && f2 > ((float) (max + max2))) {
                float f3 = (float) max;
                path.moveTo(0.0f, f3);
                if (max > 0) {
                    path.quadTo(0.0f, 0.0f, f3, 0.0f);
                }
                float f4 = (float) max3;
                path.lineTo(this.f20322a - f4, 0.0f);
                if (max3 > 0) {
                    float f5 = this.f20322a;
                    path.quadTo(f5, 0.0f, f5, f4);
                }
                float f6 = (float) max4;
                path.lineTo(this.f20322a, this.f20323b - f6);
                if (max4 > 0) {
                    float f7 = this.f20322a;
                    float f8 = this.f20323b;
                    path.quadTo(f7, f8, f7 - f6, f8);
                }
                float f9 = (float) max2;
                path.lineTo(f9, this.f20323b);
                if (max2 > 0) {
                    float f10 = this.f20323b;
                    path.quadTo(0.0f, f10, 0.0f, f10 - f9);
                }
                path.lineTo(0.0f, (float) this.f20324c);
            }
        }
        canvas.clipPath(path);
        super.onDraw(canvas);
    }

    /* renamed from: a */
    private void m14907a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.EntregaRoundImageView, i, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, f20321g);
        this.f20324c = obtainStyledAttributes.getDimensionPixelSize(2, dimensionPixelSize);
        this.f20326e = obtainStyledAttributes.getDimensionPixelSize(1, dimensionPixelSize);
        this.f20325d = obtainStyledAttributes.getDimensionPixelSize(4, dimensionPixelSize);
        this.f20327f = obtainStyledAttributes.getDimensionPixelSize(3, dimensionPixelSize);
        obtainStyledAttributes.recycle();
    }
}
