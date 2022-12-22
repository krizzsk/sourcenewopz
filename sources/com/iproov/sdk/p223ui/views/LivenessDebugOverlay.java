package com.iproov.sdk.p223ui.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: com.iproov.sdk.ui.views.LivenessDebugOverlay */
public class LivenessDebugOverlay extends View {

    /* renamed from: a */
    private Rect f54419a;

    /* renamed from: b */
    private Rect f54420b;

    /* renamed from: c */
    private Rect f54421c;

    /* renamed from: d */
    private Rect f54422d;

    /* renamed from: e */
    private Paint f54423e;

    /* renamed from: f */
    private Paint f54424f;

    /* renamed from: g */
    private Paint f54425g;

    /* renamed from: h */
    private Paint f54426h;

    public LivenessDebugOverlay(Context context) {
        super(context);
        m39361a();
    }

    /* renamed from: a */
    private void m39361a() {
        Paint b = m39362b();
        this.f54423e = b;
        b.setColor(-16711936);
        Paint b2 = m39362b();
        this.f54424f = b2;
        b2.setColor(-65536);
        Paint b3 = m39362b();
        this.f54426h = b3;
        b3.setColor(-65281);
        Paint b4 = m39362b();
        this.f54425g = b4;
        b4.setColor(-16776961);
    }

    /* renamed from: do */
    public void mo162192do(Rect rect) {
        this.f54421c = rect;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    /* renamed from: if */
    public void mo162195if(Rect rect) {
        this.f54419a = rect;
    }

    /* renamed from: new  reason: not valid java name */
    public void m47552new(Rect rect) {
        this.f54422d = rect;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Rect rect = this.f54419a;
        if (rect != null) {
            canvas.drawRect(rect, this.f54423e);
            canvas.drawCircle(this.f54419a.exactCenterX(), this.f54419a.exactCenterY(), 4.0f, this.f54423e);
        }
        Rect rect2 = this.f54420b;
        if (rect2 != null) {
            canvas.drawRect(rect2, this.f54424f);
            canvas.drawCircle(this.f54420b.exactCenterX(), this.f54420b.exactCenterY(), 4.0f, this.f54424f);
        }
        Rect rect3 = this.f54421c;
        if (rect3 != null) {
            canvas.drawRect(rect3, this.f54425g);
            canvas.drawCircle(this.f54421c.exactCenterX(), this.f54421c.exactCenterY(), 4.0f, this.f54425g);
        }
        Rect rect4 = this.f54422d;
        if (rect4 != null) {
            canvas.drawRect(rect4, this.f54426h);
        }
    }

    /* renamed from: b */
    private static Paint m39362b() {
        Paint paint = new Paint();
        paint.setStrokeWidth(8.0f);
        paint.setStyle(Paint.Style.STROKE);
        return paint;
    }

    /* renamed from: if */
    public void mo162194if() {
        invalidate();
    }

    public LivenessDebugOverlay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m39361a();
    }

    public LivenessDebugOverlay(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m39361a();
    }

    public LivenessDebugOverlay(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m39361a();
    }

    /* renamed from: for  reason: not valid java name */
    public void m47551for(Rect rect) {
        this.f54420b = rect;
    }
}
