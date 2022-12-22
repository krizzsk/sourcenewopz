package com.didichuxing.diface.biz.bioassay.fpp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.megvii.livenessdetection.DetectionFrame;

public class FaceMask extends View {
    public static final int Threshold = 30;

    /* renamed from: a */
    Paint f47264a;

    /* renamed from: b */
    RectF f47265b;

    /* renamed from: c */
    RectF f47266c;

    /* renamed from: d */
    private int f47267d;

    /* renamed from: e */
    private int f47268e;

    /* renamed from: f */
    private boolean f47269f;

    public FaceMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47264a = null;
        this.f47265b = new RectF();
        this.f47266c = null;
        this.f47267d = -16730881;
        this.f47268e = -65536;
        this.f47269f = true;
        this.f47266c = new RectF();
        Paint paint = new Paint();
        this.f47264a = paint;
        paint.setColor(this.f47267d);
        this.f47264a.setStrokeWidth(5.0f);
        this.f47264a.setStyle(Paint.Style.STROKE);
    }

    public void setFaceInfo(DetectionFrame detectionFrame) {
        if (detectionFrame != null) {
            this.f47265b = detectionFrame.getFacePos();
        } else {
            this.f47265b = null;
        }
        postInvalidate();
    }

    public void setFrontal(boolean z) {
        this.f47269f = z;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f47265b != null) {
            if (this.f47269f) {
                this.f47266c.set(((float) getWidth()) * (1.0f - this.f47265b.right), ((float) getHeight()) * this.f47265b.top, ((float) getWidth()) * (1.0f - this.f47265b.left), ((float) getHeight()) * this.f47265b.bottom);
            } else {
                this.f47266c.set(((float) getWidth()) * this.f47265b.left, ((float) getHeight()) * this.f47265b.top, ((float) getWidth()) * this.f47265b.right, ((float) getHeight()) * this.f47265b.bottom);
            }
            canvas.drawRect(this.f47266c, this.f47264a);
        }
    }
}
