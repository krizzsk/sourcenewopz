package com.tunasashimi.tuna;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.InputDeviceCompat;

public class TunaColorPicker extends Dialog {
    private int mInitialColor;
    /* access modifiers changed from: private */
    public OnColorChangedListener mListener;

    public interface OnColorChangedListener {
        void colorChanged(int i);
    }

    private static class ColorPickerView extends View {
        private static final int CENTER_RADIUS = 32;
        private static final int CENTER_X = 100;
        private static final int CENTER_Y = 100;

        /* renamed from: PI */
        private static final float f56035PI = 3.1415925f;
        private Paint mCenterPaint;
        private final int[] mColors = {-65536, -65281, -16776961, -16711681, -16711936, InputDeviceCompat.SOURCE_ANY, -65536};
        private boolean mHighlightCenter;
        private OnColorChangedListener mListener;
        private Paint mPaint;
        private boolean mTrackingCenter;

        ColorPickerView(Context context, OnColorChangedListener onColorChangedListener, int i) {
            super(context);
            this.mListener = onColorChangedListener;
            SweepGradient sweepGradient = new SweepGradient(0.0f, 0.0f, this.mColors, (float[]) null);
            Paint paint = new Paint(1);
            this.mPaint = paint;
            paint.setShader(sweepGradient);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(32.0f);
            Paint paint2 = new Paint(1);
            this.mCenterPaint = paint2;
            paint2.setColor(i);
            this.mCenterPaint.setStrokeWidth(5.0f);
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            float strokeWidth = 100.0f - (this.mPaint.getStrokeWidth() * 0.5f);
            canvas.translate(100.0f, 100.0f);
            float f = -strokeWidth;
            canvas.drawOval(new RectF(f, f, strokeWidth, strokeWidth), this.mPaint);
            canvas.drawCircle(0.0f, 0.0f, 32.0f, this.mCenterPaint);
            if (this.mTrackingCenter) {
                int color = this.mCenterPaint.getColor();
                this.mCenterPaint.setStyle(Paint.Style.STROKE);
                if (this.mHighlightCenter) {
                    this.mCenterPaint.setAlpha(255);
                } else {
                    this.mCenterPaint.setAlpha(128);
                }
                canvas.drawCircle(0.0f, 0.0f, this.mCenterPaint.getStrokeWidth() + 32.0f, this.mCenterPaint);
                this.mCenterPaint.setStyle(Paint.Style.FILL);
                this.mCenterPaint.setColor(color);
            }
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i, int i2) {
            setMeasuredDimension(200, 200);
        }

        private int ave(int i, int i2, float f) {
            return i + Math.round(f * ((float) (i2 - i)));
        }

        private int interpColor(int[] iArr, float f) {
            if (f <= 0.0f) {
                return iArr[0];
            }
            if (f >= 1.0f) {
                return iArr[iArr.length - 1];
            }
            float length = f * ((float) (iArr.length - 1));
            int i = (int) length;
            float f2 = length - ((float) i);
            int i2 = iArr[i];
            int i3 = iArr[i + 1];
            return Color.argb(ave(Color.alpha(i2), Color.alpha(i3), f2), ave(Color.red(i2), Color.red(i3), f2), ave(Color.green(i2), Color.green(i3), f2), ave(Color.blue(i2), Color.blue(i3), f2));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x002a, code lost:
            if (r10 != 2) goto L_0x007d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r10) {
            /*
                r9 = this;
                float r0 = r10.getX()
                r1 = 1120403456(0x42c80000, float:100.0)
                float r0 = r0 - r1
                float r2 = r10.getY()
                float r2 = r2 - r1
                float r1 = r0 * r0
                float r3 = r2 * r2
                float r1 = r1 + r3
                double r3 = (double) r1
                double r3 = java.lang.Math.sqrt(r3)
                r1 = 0
                r5 = 1
                r6 = 4629700416936869888(0x4040000000000000, double:32.0)
                int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
                if (r8 > 0) goto L_0x0020
                r3 = 1
                goto L_0x0021
            L_0x0020:
                r3 = 0
            L_0x0021:
                int r10 = r10.getAction()
                if (r10 == 0) goto L_0x0044
                if (r10 == r5) goto L_0x002d
                r1 = 2
                if (r10 == r1) goto L_0x004e
                goto L_0x007d
            L_0x002d:
                boolean r10 = r9.mTrackingCenter
                if (r10 == 0) goto L_0x007d
                if (r3 == 0) goto L_0x003e
                com.tunasashimi.tuna.TunaColorPicker$OnColorChangedListener r10 = r9.mListener
                android.graphics.Paint r0 = r9.mCenterPaint
                int r0 = r0.getColor()
                r10.colorChanged(r0)
            L_0x003e:
                r9.mTrackingCenter = r1
                r9.invalidate()
                goto L_0x007d
            L_0x0044:
                r9.mTrackingCenter = r3
                if (r3 == 0) goto L_0x004e
                r9.mHighlightCenter = r5
                r9.invalidate()
                goto L_0x007d
            L_0x004e:
                boolean r10 = r9.mTrackingCenter
                if (r10 == 0) goto L_0x005c
                boolean r10 = r9.mHighlightCenter
                if (r10 == r3) goto L_0x007d
                r9.mHighlightCenter = r3
                r9.invalidate()
                goto L_0x007d
            L_0x005c:
                double r1 = (double) r2
                double r3 = (double) r0
                double r0 = java.lang.Math.atan2(r1, r3)
                float r10 = (float) r0
                r0 = 1086918618(0x40c90fda, float:6.283185)
                float r10 = r10 / r0
                r0 = 0
                int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r0 >= 0) goto L_0x006f
                r0 = 1065353216(0x3f800000, float:1.0)
                float r10 = r10 + r0
            L_0x006f:
                android.graphics.Paint r0 = r9.mCenterPaint
                int[] r1 = r9.mColors
                int r10 = r9.interpColor(r1, r10)
                r0.setColor(r10)
                r9.invalidate()
            L_0x007d:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tunasashimi.tuna.TunaColorPicker.ColorPickerView.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    public TunaColorPicker(Context context, OnColorChangedListener onColorChangedListener, int i) {
        super(context);
        this.mListener = onColorChangedListener;
        this.mInitialColor = i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(new ColorPickerView(getContext(), new OnColorChangedListener() {
            public void colorChanged(int i) {
                TunaColorPicker.this.mListener.colorChanged(i);
                TunaColorPicker.this.dismiss();
            }
        }, this.mInitialColor));
        setTitle("Select Color");
    }
}
