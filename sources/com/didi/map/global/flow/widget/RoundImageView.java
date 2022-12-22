package com.didi.map.global.flow.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.passenger.C10448R;

public class RoundImageView extends AppCompatImageView {

    /* renamed from: a */
    private int f27305a;

    /* renamed from: b */
    private int f27306b;

    /* renamed from: c */
    private int f27307c;

    /* renamed from: d */
    private int f27308d;

    /* renamed from: e */
    private int f27309e;

    /* renamed from: f */
    private int f27310f;

    /* renamed from: g */
    private int f27311g;

    /* renamed from: h */
    private Path f27312h;

    public RoundImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27307c = 0;
        this.f27312h = new Path();
        m19293a(context, attributeSet);
    }

    /* renamed from: a */
    private void m19293a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.RoundImageView);
            this.f27307c = obtainStyledAttributes.getDimensionPixelOffset(3, 0);
            this.f27308d = obtainStyledAttributes.getDimensionPixelOffset(2, 0);
            this.f27309e = obtainStyledAttributes.getDimensionPixelOffset(5, 0);
            this.f27310f = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
            this.f27311g = obtainStyledAttributes.getDimensionPixelOffset(4, 0);
            obtainStyledAttributes.recycle();
            if (this.f27308d == 0) {
                this.f27308d = this.f27307c;
            }
            if (this.f27309e == 0) {
                this.f27309e = this.f27307c;
            }
            if (this.f27310f == 0) {
                this.f27310f = this.f27307c;
            }
            if (this.f27311g == 0) {
                this.f27311g = this.f27307c;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f27305a = getWidth();
        this.f27306b = getHeight();
    }

    public void setCornersRadius(int i, int i2, int i3, int i4) {
        this.f27308d = i;
        this.f27309e = i2;
        this.f27310f = i3;
        this.f27311g = i4;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int max = Math.max(this.f27308d, this.f27310f) + Math.max(this.f27309e, this.f27311g);
        int max2 = Math.max(this.f27308d, this.f27309e) + Math.max(this.f27310f, this.f27311g);
        if (this.f27305a >= max && this.f27306b > max2) {
            this.f27312h.reset();
            this.f27312h.moveTo((float) this.f27308d, 0.0f);
            this.f27312h.lineTo((float) (this.f27305a - this.f27309e), 0.0f);
            Path path = this.f27312h;
            int i = this.f27305a;
            path.quadTo((float) i, 0.0f, (float) i, (float) this.f27309e);
            this.f27312h.lineTo((float) this.f27305a, (float) (this.f27306b - this.f27311g));
            Path path2 = this.f27312h;
            int i2 = this.f27305a;
            int i3 = this.f27306b;
            path2.quadTo((float) i2, (float) i3, (float) (i2 - this.f27311g), (float) i3);
            this.f27312h.lineTo((float) this.f27310f, (float) this.f27306b);
            Path path3 = this.f27312h;
            int i4 = this.f27306b;
            path3.quadTo(0.0f, (float) i4, 0.0f, (float) (i4 - this.f27310f));
            this.f27312h.lineTo(0.0f, (float) this.f27308d);
            this.f27312h.quadTo(0.0f, 0.0f, (float) this.f27308d, 0.0f);
            canvas.clipPath(this.f27312h);
        }
        super.onDraw(canvas);
    }
}
