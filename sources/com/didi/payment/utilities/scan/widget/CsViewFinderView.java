package com.didi.payment.utilities.scan.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import p065me.dm7.barcodescanner.core.ViewFinderView;

public class CsViewFinderView extends ViewFinderView {

    /* renamed from: b */
    private static final int[] f31719b = {0, 64, 128, 192, 255, 192, 128, 64};

    /* renamed from: c */
    private static final int f31720c = 10;

    /* renamed from: d */
    private static final long f31721d = 80;

    /* renamed from: a */
    private int f31722a;

    /* renamed from: e */
    private int f31723e;

    /* renamed from: f */
    private int f31724f;

    /* renamed from: g */
    private OnFrameRectUpdatedListener f31725g;

    public interface OnFrameRectUpdatedListener {
        void onFrameRectUpdated(Rect rect);
    }

    public CsViewFinderView(Context context) {
        super(context);
    }

    public CsViewFinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFrameRectUpdatedListener(OnFrameRectUpdatedListener onFrameRectUpdatedListener) {
        this.f31725g = onFrameRectUpdatedListener;
    }

    public synchronized void updateFramingRect() {
        super.updateFramingRect();
        this.f31723e = getWidth() / 2;
        this.f31724f = getHeight() / 2;
        int height = getHeight() / 4;
        Rect framingRect = getFramingRect();
        framingRect.left = 0;
        framingRect.right = getWidth();
        framingRect.top = this.f31724f - (height / 2);
        framingRect.bottom = this.f31724f + (height / 2);
        if (this.f31725g != null) {
            this.f31725g.onFrameRectUpdated(framingRect);
        }
    }

    public void drawViewFinderMask(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Rect framingRect = getFramingRect();
        Canvas canvas2 = canvas;
        float f = (float) width;
        canvas2.drawRect(0.0f, 0.0f, f, (float) framingRect.top, this.mFinderMaskPaint);
        canvas2.drawRect(0.0f, (float) (framingRect.bottom + 1), f, (float) height, this.mFinderMaskPaint);
    }

    public void drawLaser(Canvas canvas) {
        Rect framingRect = getFramingRect();
        this.mLaserPaint.setAlpha(f31719b[this.f31722a]);
        this.f31722a = (this.f31722a + 1) % f31719b.length;
        canvas.drawRect((float) (framingRect.left + 2), (float) (this.f31724f - 5), (float) (framingRect.right - 1), (float) (this.f31724f + 5), this.mLaserPaint);
        postInvalidateDelayed(f31721d, framingRect.left - 10, framingRect.top - 10, framingRect.right + 10, framingRect.bottom + 10);
    }
}
