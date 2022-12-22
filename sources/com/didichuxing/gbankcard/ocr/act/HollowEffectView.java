package com.didichuxing.gbankcard.ocr.act;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.ResUtils;

public class HollowEffectView extends View {

    /* renamed from: d */
    private static final int f47684d = Integer.MIN_VALUE;

    /* renamed from: a */
    private Paint f47685a;

    /* renamed from: b */
    private PorterDuffXfermode f47686b;

    /* renamed from: c */
    private PorterDuffXfermode f47687c;

    /* renamed from: e */
    private Rect f47688e;

    /* renamed from: f */
    private Rect f47689f;

    /* renamed from: g */
    private Bitmap f47690g;

    /* renamed from: h */
    private Bitmap f47691h;

    /* renamed from: i */
    private Path f47692i;

    /* renamed from: j */
    private int f47693j;

    public HollowEffectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m34153a();
    }

    /* renamed from: a */
    private void m34153a() {
        setWillNotDraw(false);
        setLayerType(1, (Paint) null);
        Paint paint = new Paint(1);
        this.f47685a = paint;
        paint.setColor(Integer.MIN_VALUE);
        this.f47686b = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        this.f47687c = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.f47693j = ResUtils.dp2px(5.0f);
    }

    public void setHollowArea(View view) {
        this.f47688e = new Rect(view.getLeft() + this.f47693j, view.getTop() + this.f47693j, view.getRight() - this.f47693j, view.getBottom() - this.f47693j);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Bitmap mo117732a(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-65536);
        canvas.drawRect(this.f47688e, paint);
        return createBitmap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Bitmap mo117733b(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(Integer.MIN_VALUE);
        canvas.drawRect(this.f47689f, paint);
        return createBitmap;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f47688e != null) {
            int width = getWidth();
            int height = getHeight();
            if (width == 0 || height == 0) {
                LogUtils.m33563d("onDraw invalid w or h!!!");
                return;
            }
            LogUtils.m33563d("onDraw w===" + width + ", h=" + height);
            if (this.f47689f == null) {
                this.f47689f = new Rect(0, 0, width, height);
            }
            canvas.drawPaint(this.f47685a);
            this.f47685a.setXfermode(this.f47687c);
            canvas.drawRect(this.f47688e, this.f47685a);
            this.f47685a.setXfermode((Xfermode) null);
        }
    }
}
