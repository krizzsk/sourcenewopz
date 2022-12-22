package com.didi.hawaii.mapsdk.gesture;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.didi.hawaii.mapsdk.gesture.ScaleGestureDetector;
import java.util.HashSet;
import java.util.Set;

public class StandardScaleGestureDetector extends ProgressiveGesture<StandardOnScaleGestureListener> {

    /* renamed from: m */
    private static final Set<Integer> f23633m;

    /* renamed from: a */
    ScaleGestureDetector.OnScaleGestureListener f23634a;

    /* renamed from: b */
    float f23635b;

    /* renamed from: l */
    float f23636l;

    /* renamed from: n */
    private ScaleGestureDetector f23637n;

    /* renamed from: o */
    private boolean f23638o;

    /* renamed from: p */
    private boolean f23639p;

    /* renamed from: q */
    private float f23640q;

    /* renamed from: r */
    private float f23641r;

    /* renamed from: s */
    private float f23642s;

    /* renamed from: t */
    private long f23643t;

    /* renamed from: u */
    private long f23644u;

    public static class SimpleStandardOnScaleGestureListener implements StandardOnScaleGestureListener {
        public boolean onScale(StandardScaleGestureDetector standardScaleGestureDetector) {
            return false;
        }

        public boolean onScaleBegin(StandardScaleGestureDetector standardScaleGestureDetector) {
            return true;
        }

        public void onScaleEnd(StandardScaleGestureDetector standardScaleGestureDetector, float f, float f2) {
        }
    }

    public interface StandardOnScaleGestureListener {
        boolean onScale(StandardScaleGestureDetector standardScaleGestureDetector);

        boolean onScaleBegin(StandardScaleGestureDetector standardScaleGestureDetector);

        void onScaleEnd(StandardScaleGestureDetector standardScaleGestureDetector, float f, float f2);
    }

    static {
        HashSet hashSet = new HashSet();
        f23633m = hashSet;
        hashSet.add(1);
    }

    public StandardScaleGestureDetector(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
        C89471 r3 = new ScaleGestureDetector.OnScaleGestureListener() {
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                return StandardScaleGestureDetector.this.mo68840a(scaleGestureDetector);
            }

            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return StandardScaleGestureDetector.this.mo68841b(scaleGestureDetector);
            }

            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                StandardScaleGestureDetector.this.mo68842c(scaleGestureDetector);
            }
        };
        this.f23634a = r3;
        this.f23637n = new ScaleGestureDetector(context, r3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo68840a(ScaleGestureDetector scaleGestureDetector) {
        if (this.f23635b == 0.0f) {
            this.f23635b = scaleGestureDetector.getCurrentSpan();
        }
        this.f23636l = Math.abs(this.f23635b - scaleGestureDetector.getCurrentSpan());
        boolean z = false;
        if (!isInProgress() && canExecute(1) && this.f23636l >= this.f23640q) {
            if (!((StandardOnScaleGestureListener) this.listener).onScaleBegin(this)) {
                return false;
            }
            gestureStarted();
            this.f23643t = SystemClock.uptimeMillis();
        }
        if (!isInProgress()) {
            return true;
        }
        if (!canExecute(1)) {
            super.gestureStopped();
            ((StandardOnScaleGestureListener) this.listener).onScaleEnd(this, 0.0f, 0.0f);
            return false;
        }
        if (scaleGestureDetector.getScaleFactor() < 1.0f) {
            z = true;
        }
        this.f23639p = z;
        return ((StandardOnScaleGestureListener) this.listener).onScale(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo68841b(ScaleGestureDetector scaleGestureDetector) {
        this.f23635b = scaleGestureDetector.getCurrentSpan();
        if (canExecute(1)) {
            this.f23577e = VelocityTracker.obtain();
            if (this.f23640q == 0.0f && ((StandardOnScaleGestureListener) this.listener).onScaleBegin(this)) {
                gestureStarted();
                this.f23643t = SystemClock.uptimeMillis();
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo68842c(ScaleGestureDetector scaleGestureDetector) {
        this.f23638o = true;
        gestureStopped();
    }

    /* access modifiers changed from: protected */
    public boolean analyzeEvent(MotionEvent motionEvent) {
        super.analyzeEvent(motionEvent);
        return this.f23637n.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void gestureStopped() {
        if (!isInProgress()) {
            super.gestureStopped();
            return;
        }
        this.f23644u = SystemClock.uptimeMillis();
        if (this.f23638o) {
            this.f23641r = this.f23582j / ((float) this.f23583k);
            super.gestureStopped();
            float f = getPointDownXY(0).y;
            float f2 = getPointDownXY(1).y;
            float f3 = getPointMoveXY(0).y;
            float f4 = getPointMoveXY(1).y;
            float f5 = getPointDownXY(0).x;
            float f6 = getPointDownXY(1).x;
            float f7 = f6 - f5;
            float f8 = f2 - f;
            float f9 = getPointMoveXY(1).x - getPointMoveXY(0).x;
            float f10 = f4 - f3;
            this.f23642s = (float) Math.abs((Math.sqrt((double) ((f9 * f9) + (f10 * f10))) - Math.sqrt((double) ((f7 * f7) + (f8 * f8)))) / ((double) (this.f23644u - this.f23643t)));
            Pair<String, Float> classFyResult = getClassFyResult();
            if (!useNNClassfy() || classFyResult == null) {
                ((StandardOnScaleGestureListener) this.listener).onScaleEnd(this, this.f23578f, this.f23579g);
            } else if (this.f23636l >= this.f23640q && ((String) classFyResult.first).equals(NNGestureClassfy.SCALE_LABLE)) {
                ((StandardOnScaleGestureListener) this.listener).onScaleEnd(this, this.f23578f, this.f23579g);
            }
            this.f23638o = false;
        }
    }

    public void interrupt() {
        super.interrupt();
        this.f23635b = 0.0f;
    }

    /* access modifiers changed from: protected */
    public Set<Integer> provideHandledTypes() {
        return f23633m;
    }

    public boolean isScalingOut() {
        return this.f23639p;
    }

    public ScaleGestureDetector getUnderlyingScaleGestureDetector() {
        return this.f23637n;
    }

    public float getSpanSinceStartThreshold() {
        return this.f23640q;
    }

    public void setSpanSinceStartThreshold(float f) {
        this.f23640q = f;
    }

    public void setSpanSinceStartThresholdResource(int i) {
        setSpanSinceStartThreshold(this.context.getResources().getDimension(i));
    }

    public float getScaleFactor() {
        return this.f23637n.getScaleFactor();
    }

    public float getMoveVelocityAverage() {
        return this.f23641r;
    }

    public float getCustomComputeVelocity() {
        return this.f23642s;
    }
}
