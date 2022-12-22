package com.didi.soda.customer.blocks.card.suapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;

public class SaShadowHelper {

    /* renamed from: a */
    private View f40625a;

    /* renamed from: b */
    private Paint f40626b;

    /* renamed from: c */
    private boolean f40627c = true;

    /* renamed from: d */
    private int f40628d;

    /* renamed from: e */
    private int f40629e;

    /* renamed from: f */
    private int f40630f;

    /* renamed from: g */
    private int f40631g;

    public static int fixItemMargin(int i, int i2, int i3) {
        return i - (i2 + i3);
    }

    public SaShadowHelper(View view) {
        this.f40625a = view;
        m28876a(view.getContext());
    }

    /* renamed from: a */
    private void m28876a(Context context) {
        Paint paint = new Paint();
        this.f40626b = paint;
        paint.setAntiAlias(true);
        this.f40626b.setStyle(Paint.Style.FILL);
        this.f40629e = Color.parseColor("#1989A2AE");
    }

    public void setmShadowColor(int i) {
        this.f40629e = i;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        m28875a(this.f40625a.getWidth(), this.f40625a.getHeight());
    }

    /* renamed from: a */
    private void m28875a(int i, int i2) {
        if (this.f40627c) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(m28874a(i, i2, 0.0f, (float) this.f40625a.getPaddingBottom(), (float) this.f40630f, (float) this.f40631g, this.f40629e, 0));
            if (Build.VERSION.SDK_INT <= 16) {
                this.f40625a.setBackgroundDrawable(bitmapDrawable);
            } else {
                this.f40625a.setBackground(bitmapDrawable);
            }
        }
    }

    /* renamed from: a */
    private Bitmap m28874a(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF((float) this.f40625a.getPaddingLeft(), (float) ((i2 - this.f40625a.getPaddingBottom()) - (((i2 - this.f40625a.getPaddingTop()) - this.f40625a.getPaddingBottom()) / 5)), (float) (i - this.f40625a.getPaddingRight()), (float) (i2 - this.f40625a.getPaddingBottom()));
        this.f40626b.setColor(i4);
        if (!this.f40625a.isInEditMode()) {
            this.f40626b.setShadowLayer(f2, f3, f4, i3);
        }
        float dip2px = (float) dip2px(this.f40625a.getContext(), 20.0f);
        canvas.drawRoundRect(rectF, dip2px, dip2px, this.f40626b);
        return createBitmap;
    }

    public void setShadowLimit(int i) {
        if (this.f40627c) {
            this.f40628d = i;
        }
    }

    public void setShowShadow(boolean z) {
        this.f40627c = z;
    }

    public int getDx() {
        return this.f40630f;
    }

    public void setDx(int i) {
        this.f40630f = i;
    }

    public int getDy() {
        return this.f40631g;
    }

    public void setDy(int i) {
        this.f40631g = i;
    }

    public static int dip2px(Context context, float f) {
        return context == null ? (int) f : (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
