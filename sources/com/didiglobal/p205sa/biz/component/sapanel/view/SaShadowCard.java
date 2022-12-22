package com.didiglobal.p205sa.biz.component.sapanel.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.widget.RelativeLayout;
import com.didi.global.globaluikit.utils.UiUtils;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.view.SaShadowCard */
public class SaShadowCard extends RelativeLayout {

    /* renamed from: a */
    private Paint f51175a;

    /* renamed from: b */
    private boolean f51176b = true;

    /* renamed from: c */
    private int f51177c;

    /* renamed from: d */
    private int f51178d;

    /* renamed from: e */
    private int f51179e;

    /* renamed from: f */
    private int f51180f;

    public SaShadowCard(Context context) {
        super(context);
        m36663a(context);
    }

    /* renamed from: a */
    private void m36663a(Context context) {
        Paint paint = new Paint();
        this.f51175a = paint;
        paint.setAntiAlias(true);
        this.f51175a.setStyle(Paint.Style.FILL);
        this.f51178d = Color.parseColor("#E589A2AE");
    }

    public void setmShadowColor(int i) {
        this.f51178d = i;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m36662a(getWidth(), getHeight());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* renamed from: a */
    private void m36662a(int i, int i2) {
        if (this.f51176b) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(m36661a(i, i2, 0.0f, (float) this.f51177c, (float) this.f51179e, (float) this.f51180f, this.f51178d, 0));
            if (Build.VERSION.SDK_INT <= 16) {
                setBackgroundDrawable(bitmapDrawable);
            } else {
                setBackground(bitmapDrawable);
            }
        }
    }

    /* renamed from: a */
    private Bitmap m36661a(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF((float) getPaddingLeft(), (float) ((i2 - getPaddingBottom()) - (((i2 - getPaddingTop()) - getPaddingBottom()) / 5)), (float) (i - getPaddingRight()), (float) (i2 - getPaddingBottom()));
        this.f51175a.setColor(i4);
        if (!isInEditMode()) {
            this.f51175a.setShadowLayer(f2, f3, f4, i3);
        }
        float dip2px = (float) UiUtils.dip2px(getContext(), 20.0f);
        canvas.drawRoundRect(rectF, dip2px, dip2px, this.f51175a);
        return createBitmap;
    }

    public void setShadowLimit(int i) {
        if (this.f51176b) {
            this.f51177c = i;
        }
    }

    public void setShowShadow(boolean z) {
        this.f51176b = z;
    }

    public int getDx() {
        return this.f51179e;
    }

    public void setDx(int i) {
        this.f51179e = i;
    }

    public int getDy() {
        return this.f51180f;
    }

    public void setDy(int i) {
        this.f51180f = i;
    }
}
