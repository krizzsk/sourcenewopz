package com.github.mikephil.charting.listener;

import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;

public class PieRadarChartTouchListener extends ChartTouchListener<PieRadarChartBase<?>> {

    /* renamed from: a */
    private MPPointF f52447a = MPPointF.getInstance(0.0f, 0.0f);

    /* renamed from: b */
    private float f52448b = 0.0f;

    /* renamed from: c */
    private ArrayList<AngularVelocitySample> f52449c = new ArrayList<>();

    /* renamed from: d */
    private long f52450d = 0;

    /* renamed from: e */
    private float f52451e = 0.0f;

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    public PieRadarChartTouchListener(PieRadarChartBase<?> pieRadarChartBase) {
        super(pieRadarChartBase);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.mGestureDetector.onTouchEvent(motionEvent) && ((PieRadarChartBase) this.mChart).isRotationEnabled()) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                startAction(motionEvent);
                stopDeceleration();
                m37280a();
                if (((PieRadarChartBase) this.mChart).isDragDecelerationEnabled()) {
                    m37281a(x, y);
                }
                setGestureStartAngle(x, y);
                this.f52447a.f52498x = x;
                this.f52447a.f52499y = y;
            } else if (action == 1) {
                if (((PieRadarChartBase) this.mChart).isDragDecelerationEnabled()) {
                    stopDeceleration();
                    m37281a(x, y);
                    float b = m37282b();
                    this.f52451e = b;
                    if (b != 0.0f) {
                        this.f52450d = AnimationUtils.currentAnimationTimeMillis();
                        Utils.postInvalidateOnAnimation(this.mChart);
                    }
                }
                ((PieRadarChartBase) this.mChart).enableScroll();
                this.mTouchMode = 0;
                endAction(motionEvent);
            } else if (action == 2) {
                if (((PieRadarChartBase) this.mChart).isDragDecelerationEnabled()) {
                    m37281a(x, y);
                }
                if (this.mTouchMode == 0 && distance(x, this.f52447a.f52498x, y, this.f52447a.f52499y) > Utils.convertDpToPixel(8.0f)) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.ROTATE;
                    this.mTouchMode = 6;
                    ((PieRadarChartBase) this.mChart).disableScroll();
                } else if (this.mTouchMode == 6) {
                    updateGestureRotation(x, y);
                    ((PieRadarChartBase) this.mChart).invalidate();
                }
                endAction(motionEvent);
            }
        }
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.LONG_PRESS;
        OnChartGestureListener onChartGestureListener = ((PieRadarChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartLongPressed(motionEvent);
        }
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.SINGLE_TAP;
        OnChartGestureListener onChartGestureListener = ((PieRadarChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartSingleTapped(motionEvent);
        }
        if (!((PieRadarChartBase) this.mChart).isHighlightPerTapEnabled()) {
            return false;
        }
        performHighlight(((PieRadarChartBase) this.mChart).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return true;
    }

    /* renamed from: a */
    private void m37280a() {
        this.f52449c.clear();
    }

    /* renamed from: a */
    private void m37281a(float f, float f2) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f52449c.add(new AngularVelocitySample(currentAnimationTimeMillis, ((PieRadarChartBase) this.mChart).getAngleForPoint(f, f2)));
        for (int size = this.f52449c.size(); size - 2 > 0 && currentAnimationTimeMillis - this.f52449c.get(0).time > 1000; size--) {
            this.f52449c.remove(0);
        }
    }

    /* renamed from: b */
    private float m37282b() {
        if (this.f52449c.isEmpty()) {
            return 0.0f;
        }
        boolean z = false;
        AngularVelocitySample angularVelocitySample = this.f52449c.get(0);
        ArrayList<AngularVelocitySample> arrayList = this.f52449c;
        AngularVelocitySample angularVelocitySample2 = arrayList.get(arrayList.size() - 1);
        AngularVelocitySample angularVelocitySample3 = angularVelocitySample;
        for (int size = this.f52449c.size() - 1; size >= 0; size--) {
            angularVelocitySample3 = this.f52449c.get(size);
            if (angularVelocitySample3.angle != angularVelocitySample2.angle) {
                break;
            }
        }
        float f = ((float) (angularVelocitySample2.time - angularVelocitySample.time)) / 1000.0f;
        if (f == 0.0f) {
            f = 0.1f;
        }
        if (angularVelocitySample2.angle >= angularVelocitySample3.angle) {
            z = true;
        }
        if (((double) Math.abs(angularVelocitySample2.angle - angularVelocitySample3.angle)) > 270.0d) {
            z = !z;
        }
        if (((double) (angularVelocitySample2.angle - angularVelocitySample.angle)) > 180.0d) {
            angularVelocitySample.angle = (float) (((double) angularVelocitySample.angle) + 360.0d);
        } else if (((double) (angularVelocitySample.angle - angularVelocitySample2.angle)) > 180.0d) {
            angularVelocitySample2.angle = (float) (((double) angularVelocitySample2.angle) + 360.0d);
        }
        float abs = Math.abs((angularVelocitySample2.angle - angularVelocitySample.angle) / f);
        return !z ? -abs : abs;
    }

    public void setGestureStartAngle(float f, float f2) {
        this.f52448b = ((PieRadarChartBase) this.mChart).getAngleForPoint(f, f2) - ((PieRadarChartBase) this.mChart).getRawRotationAngle();
    }

    public void updateGestureRotation(float f, float f2) {
        ((PieRadarChartBase) this.mChart).setRotationAngle(((PieRadarChartBase) this.mChart).getAngleForPoint(f, f2) - this.f52448b);
    }

    public void stopDeceleration() {
        this.f52451e = 0.0f;
    }

    public void computeScroll() {
        if (this.f52451e != 0.0f) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f52451e *= ((PieRadarChartBase) this.mChart).getDragDecelerationFrictionCoef();
            ((PieRadarChartBase) this.mChart).setRotationAngle(((PieRadarChartBase) this.mChart).getRotationAngle() + (this.f52451e * (((float) (currentAnimationTimeMillis - this.f52450d)) / 1000.0f)));
            this.f52450d = currentAnimationTimeMillis;
            if (((double) Math.abs(this.f52451e)) >= 0.001d) {
                Utils.postInvalidateOnAnimation(this.mChart);
            } else {
                stopDeceleration();
            }
        }
    }

    private class AngularVelocitySample {
        public float angle;
        public long time;

        public AngularVelocitySample(long j, float f) {
            this.time = j;
            this.angle = f;
        }
    }
}
