package com.didi.map.global.component.streetview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.passenger.C10448R;

public class RoundImageView extends AppCompatImageView {

    /* renamed from: a */
    private int f26257a;

    /* renamed from: b */
    private int f26258b;

    /* renamed from: c */
    private int f26259c;

    /* renamed from: d */
    private int f26260d;

    /* renamed from: e */
    private int f26261e;

    /* renamed from: f */
    private int f26262f;

    /* renamed from: g */
    private int f26263g;

    /* renamed from: h */
    private Path f26264h;

    public RoundImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f26259c = 0;
        this.f26264h = new Path();
        m18586a(context, attributeSet);
    }

    /* renamed from: a */
    private void m18586a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.RoundImageView);
            this.f26259c = obtainStyledAttributes.getDimensionPixelOffset(3, 0);
            this.f26260d = obtainStyledAttributes.getDimensionPixelOffset(2, 0);
            this.f26261e = obtainStyledAttributes.getDimensionPixelOffset(5, 0);
            this.f26262f = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
            this.f26263g = obtainStyledAttributes.getDimensionPixelOffset(4, 0);
            obtainStyledAttributes.recycle();
            if (this.f26260d == 0) {
                this.f26260d = this.f26259c;
            }
            if (this.f26261e == 0) {
                this.f26261e = this.f26259c;
            }
            if (this.f26262f == 0) {
                this.f26262f = this.f26259c;
            }
            if (this.f26263g == 0) {
                this.f26263g = this.f26259c;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f26257a = getWidth();
        this.f26258b = getHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int max = Math.max(this.f26260d, this.f26262f) + Math.max(this.f26261e, this.f26263g);
        int max2 = Math.max(this.f26260d, this.f26261e) + Math.max(this.f26262f, this.f26263g);
        Path path = this.f26264h;
        if (path != null && this.f26257a >= max && this.f26258b > max2) {
            path.reset();
            this.f26264h.moveTo((float) this.f26260d, 0.0f);
            this.f26264h.lineTo((float) (this.f26257a - this.f26261e), 0.0f);
            Path path2 = this.f26264h;
            int i = this.f26257a;
            path2.quadTo((float) i, 0.0f, (float) i, (float) this.f26261e);
            this.f26264h.lineTo((float) this.f26257a, (float) (this.f26258b - this.f26263g));
            Path path3 = this.f26264h;
            int i2 = this.f26257a;
            int i3 = this.f26258b;
            path3.quadTo((float) i2, (float) i3, (float) (i2 - this.f26263g), (float) i3);
            this.f26264h.lineTo((float) this.f26262f, (float) this.f26258b);
            Path path4 = this.f26264h;
            int i4 = this.f26258b;
            path4.quadTo(0.0f, (float) i4, 0.0f, (float) (i4 - this.f26262f));
            this.f26264h.lineTo(0.0f, (float) this.f26260d);
            this.f26264h.quadTo(0.0f, 0.0f, (float) this.f26260d, 0.0f);
            canvas.clipPath(this.f26264h);
        }
        super.onDraw(canvas);
    }
}
