package com.didi.component.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.didi.passenger.C10448R;

public class RoundFrameLayout extends FrameLayout {

    /* renamed from: a */
    float f11872a;

    /* renamed from: b */
    float f11873b;

    /* renamed from: c */
    private int f11874c;

    /* renamed from: d */
    private int f11875d;

    /* renamed from: e */
    private int f11876e;

    /* renamed from: f */
    private int f11877f;

    /* renamed from: g */
    private int f11878g;

    /* renamed from: h */
    private int f11879h;

    /* renamed from: i */
    private int f11880i;

    /* renamed from: j */
    private int f11881j;

    /* renamed from: k */
    private int f11882k;

    /* renamed from: l */
    private int f11883l;

    /* renamed from: m */
    private int f11884m;

    /* renamed from: n */
    private int f11885n;

    /* renamed from: o */
    private Path f11886o;

    public RoundFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11874c = 0;
        m8035a(context, attributeSet);
    }

    /* renamed from: a */
    private void m8035a(Context context, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, (Paint) null);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.RoundFrameLayout);
        this.f11875d = obtainStyledAttributes.getDimensionPixelOffset(2, this.f11874c);
        this.f11876e = obtainStyledAttributes.getDimensionPixelOffset(1, this.f11874c);
        this.f11877f = obtainStyledAttributes.getDimensionPixelOffset(4, this.f11874c);
        this.f11878g = obtainStyledAttributes.getDimensionPixelOffset(3, this.f11874c);
        this.f11879h = obtainStyledAttributes.getDimensionPixelOffset(0, this.f11874c);
        if (this.f11874c == this.f11876e) {
            this.f11876e = this.f11875d;
        }
        if (this.f11874c == this.f11877f) {
            this.f11877f = this.f11875d;
        }
        if (this.f11874c == this.f11878g) {
            this.f11878g = this.f11875d;
        }
        if (this.f11874c == this.f11879h) {
            this.f11879h = this.f11875d;
        }
        obtainStyledAttributes.recycle();
        this.f11880i = Math.max(this.f11876e, this.f11879h);
        int max = Math.max(this.f11877f, this.f11878g);
        this.f11881j = max;
        this.f11882k = this.f11880i + max;
        this.f11883l = Math.max(this.f11876e, this.f11877f);
        int max2 = Math.max(this.f11879h, this.f11878g);
        this.f11884m = max2;
        this.f11885n = this.f11883l + max2;
        this.f11886o = new Path();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f11872a = (float) getWidth();
        this.f11873b = (float) getHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f11872a >= ((float) this.f11882k) && this.f11873b > ((float) this.f11885n)) {
            this.f11886o.reset();
            this.f11886o.moveTo((float) this.f11876e, 0.0f);
            this.f11886o.lineTo(this.f11872a - ((float) this.f11877f), 0.0f);
            Path path = this.f11886o;
            float f = this.f11872a;
            path.quadTo(f, 0.0f, f, (float) this.f11877f);
            this.f11886o.lineTo(this.f11872a, this.f11873b - ((float) this.f11878g));
            Path path2 = this.f11886o;
            float f2 = this.f11872a;
            float f3 = this.f11873b;
            path2.quadTo(f2, f3, f2 - ((float) this.f11878g), f3);
            this.f11886o.lineTo((float) this.f11879h, this.f11873b);
            Path path3 = this.f11886o;
            float f4 = this.f11873b;
            path3.quadTo(0.0f, f4, 0.0f, f4 - ((float) this.f11879h));
            this.f11886o.lineTo(0.0f, (float) this.f11876e);
            this.f11886o.quadTo(0.0f, 0.0f, (float) this.f11876e, 0.0f);
            canvas.clipPath(this.f11886o);
        }
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.f11872a >= ((float) this.f11882k) && this.f11873b > ((float) this.f11885n)) {
            this.f11886o.reset();
            this.f11886o.moveTo((float) this.f11876e, 0.0f);
            this.f11886o.lineTo(this.f11872a - ((float) this.f11877f), 0.0f);
            Path path = this.f11886o;
            float f = this.f11872a;
            path.quadTo(f, 0.0f, f, (float) this.f11877f);
            this.f11886o.lineTo(this.f11872a, this.f11873b - ((float) this.f11878g));
            Path path2 = this.f11886o;
            float f2 = this.f11872a;
            float f3 = this.f11873b;
            path2.quadTo(f2, f3, f2 - ((float) this.f11878g), f3);
            this.f11886o.lineTo((float) this.f11879h, this.f11873b);
            Path path3 = this.f11886o;
            float f4 = this.f11873b;
            path3.quadTo(0.0f, f4, 0.0f, f4 - ((float) this.f11879h));
            this.f11886o.lineTo(0.0f, (float) this.f11876e);
            this.f11886o.quadTo(0.0f, 0.0f, (float) this.f11876e, 0.0f);
            canvas.clipPath(this.f11886o);
        }
        super.dispatchDraw(canvas);
    }
}
