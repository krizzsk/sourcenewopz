package com.didi.rfusion.widget.button;

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

public class RFShadowLayout extends FrameLayout {

    /* renamed from: a */
    private static final String f33355a = "RFShadowLayout";

    /* renamed from: b */
    private int f33356b;

    /* renamed from: c */
    private float f33357c;

    /* renamed from: d */
    private float f33358d;

    /* renamed from: e */
    private float f33359e;

    /* renamed from: f */
    private float f33360f;

    public RFShadowLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFShadowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFShadowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m23452a(context, attributeSet);
        m23450a();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0 && getBackground() == null) {
            m23451a(i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 > 0 && i6 > 0) {
            m23451a(i5, i6);
        }
    }

    /* renamed from: a */
    private void m23450a() {
        int shadowWidth = getShadowWidth();
        int shadowHeight = getShadowHeight();
        setPadding(shadowWidth, shadowHeight, shadowWidth, shadowHeight);
    }

    /* renamed from: a */
    private void m23451a(int i, int i2) {
        if (getShadowWidth() == 0 && getShadowHeight() == 0) {
            setBackground((Drawable) null);
            return;
        }
        setBackground(new BitmapDrawable(getResources(), m23449a(i, i2, this.f33358d, this.f33357c, this.f33359e, this.f33360f, this.f33356b, 0)));
    }

    /* renamed from: a */
    private void m23452a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.RFShadowLayout);
        this.f33358d = obtainStyledAttributes.getDimension(1, this.f33358d);
        this.f33357c = obtainStyledAttributes.getDimension(2, this.f33357c);
        this.f33359e = obtainStyledAttributes.getDimension(3, this.f33359e);
        this.f33360f = obtainStyledAttributes.getDimension(4, this.f33360f);
        this.f33356b = obtainStyledAttributes.getColor(0, this.f33356b);
    }

    private int getShadowWidth() {
        return (int) (this.f33357c + Math.abs(this.f33359e));
    }

    private int getShadowHeight() {
        return (int) (this.f33357c + Math.abs(this.f33360f));
    }

    /* renamed from: a */
    private Bitmap m23449a(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4) {
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
        this.f33356b = i;
        this.f33357c = (float) i2;
        this.f33358d = (float) i3;
        this.f33359e = (float) i4;
        this.f33360f = (float) i5;
        m23450a();
    }
}
