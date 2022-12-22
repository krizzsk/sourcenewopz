package com.didichuxing.security.cardverify.globalpay.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.didi.passenger.C10448R;

public class GlobalPayShadowLayout extends FrameLayout {

    /* renamed from: a */
    private int f48928a;

    /* renamed from: b */
    private float f48929b;

    /* renamed from: c */
    private float f48930c;

    /* renamed from: d */
    private float f48931d;

    /* renamed from: e */
    private float f48932e;

    public GlobalPayShadowLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public GlobalPayShadowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GlobalPayShadowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m35131a(context, attributeSet);
        m35129a();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0 && getBackground() == null) {
            m35130a(i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 > 0 && i6 > 0) {
            m35130a(i5, i6);
        }
    }

    /* renamed from: a */
    private void m35129a() {
        int shadowWidth = getShadowWidth();
        int shadowHeight = getShadowHeight();
        setPadding(shadowWidth, shadowHeight, shadowWidth, shadowHeight);
    }

    /* renamed from: a */
    private void m35130a(int i, int i2) {
        if (getShadowWidth() == 0 && getShadowHeight() == 0) {
            setBackground((Drawable) null);
            return;
        }
        setBackground(new BitmapDrawable(getResources(), m35128a(i, i2, this.f48930c, this.f48929b, this.f48931d, this.f48932e, this.f48928a, 0)));
    }

    /* renamed from: a */
    private void m35131a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.GlobalPayShadowLayout);
        this.f48930c = obtainStyledAttributes.getDimension(1, this.f48930c);
        this.f48929b = obtainStyledAttributes.getDimension(2, this.f48929b);
        this.f48931d = obtainStyledAttributes.getDimension(3, this.f48931d);
        this.f48932e = obtainStyledAttributes.getDimension(4, this.f48932e);
        this.f48928a = obtainStyledAttributes.getColor(0, this.f48928a);
    }

    private int getShadowWidth() {
        return (int) (this.f48929b + Math.abs(this.f48931d));
    }

    private int getShadowHeight() {
        return (int) (this.f48929b + Math.abs(this.f48932e));
    }

    /* renamed from: a */
    private Bitmap m35128a(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF(f2, f2, ((float) i) - f2, ((float) i2) - f2);
        if (f4 > 0.0f) {
            rectF.top += f4;
            rectF.bottom -= f4;
        } else if (f4 < 0.0f) {
            rectF.top += Math.abs(f4);
            rectF.bottom -= Math.abs(f4);
        }
        if (f3 > 0.0f) {
            rectF.left += f3;
            rectF.right -= f3;
        } else if (f3 < 0.0f) {
            rectF.left += Math.abs(f3);
            rectF.right -= Math.abs(f3);
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i4);
        paint.setStyle(Paint.Style.FILL);
        if (!isInEditMode()) {
            paint.setShadowLayer(f2, f3, f4, i3);
        }
        canvas.drawRoundRect(rectF, f, f, paint);
        return createBitmap;
    }

    public void setShadow(int i, int i2, int i3, int i4, int i5) {
        this.f48928a = i;
        this.f48929b = (float) i2;
        this.f48930c = (float) i3;
        this.f48931d = (float) i4;
        this.f48932e = (float) i5;
        m35129a();
    }
}
