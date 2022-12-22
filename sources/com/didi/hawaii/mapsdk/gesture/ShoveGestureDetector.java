package com.didi.hawaii.mapsdk.gesture;

import android.content.Context;
import java.util.HashSet;
import java.util.Set;

public class ShoveGestureDetector extends ProgressiveGesture<OnShoveGestureListener> {

    /* renamed from: m */
    private static final Set<Integer> f23620m;

    /* renamed from: a */
    float f23621a;

    /* renamed from: b */
    float f23622b;

    /* renamed from: l */
    float f23623l = 0.0f;

    /* renamed from: n */
    private float f23624n;

    /* renamed from: o */
    private float f23625o;

    public interface OnShoveGestureListener {
        boolean onShove(ShoveGestureDetector shoveGestureDetector, float f, float f2);

        boolean onShoveBegin(ShoveGestureDetector shoveGestureDetector);

        void onShoveEnd(ShoveGestureDetector shoveGestureDetector, float f, float f2);
    }

    public static class SimpleOnShoveGestureListener implements OnShoveGestureListener {
        public boolean onShove(ShoveGestureDetector shoveGestureDetector, float f, float f2) {
            return false;
        }

        public boolean onShoveBegin(ShoveGestureDetector shoveGestureDetector) {
            return true;
        }

        public void onShoveEnd(ShoveGestureDetector shoveGestureDetector, float f, float f2) {
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f23620m = hashSet;
        hashSet.add(3);
    }

    public ShoveGestureDetector(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
    }

    /* access modifiers changed from: protected */
    public Set<Integer> provideHandledTypes() {
        return f23620m;
    }

    /* access modifiers changed from: protected */
    public boolean analyzeMovement() {
        super.analyzeMovement();
        float d = mo68796d();
        this.f23622b = d;
        this.f23621a += d;
        if (isInProgress() && this.f23622b != 0.0f) {
            return ((OnShoveGestureListener) this.listener).onShove(this, this.f23622b, this.f23621a);
        }
        if (!canExecute(3) || !((OnShoveGestureListener) this.listener).onShoveBegin(this)) {
            return false;
        }
        gestureStarted();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean canExecute(int i) {
        return super.canExecute(i) && Math.abs(this.f23621a) >= this.f23625o;
    }

    /* access modifiers changed from: protected */
    public boolean isSloppyGesture() {
        return super.isSloppyGesture() || !mo68712a();
    }

    /* access modifiers changed from: protected */
    public void gestureStopped() {
        super.gestureStopped();
        ((OnShoveGestureListener) this.listener).onShoveEnd(this, this.f23578f, this.f23579g);
    }

    /* access modifiers changed from: protected */
    public void reset() {
        super.reset();
        this.f23621a = 0.0f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo68712a() {
        float f = getPointDownXY(0).y;
        float f2 = getPointDownXY(1).y;
        float f3 = getPointMoveXY(0).y;
        float f4 = getPointMoveXY(1).y;
        float f5 = getPointDownXY(0).x;
        float f6 = getPointDownXY(1).x;
        float f7 = getPointMoveXY(0).x - f5;
        float f8 = f3 - f;
        float f9 = getPointMoveXY(1).x - f6;
        float f10 = f4 - f2;
        if (Math.abs(f - f2) <= this.f23623l && Math.abs(f5 - f6) >= this.f23623l / 3.0f) {
            return (Math.abs(f7) > 10.0f || Math.abs(f8) > 10.0f || Math.abs(f9) > 10.0f || Math.abs(f10) > 10.0f) && f8 * f10 > 0.0f && ((double) Math.abs(f8)) > ((double) Math.abs(f7)) * 1.16d && ((double) Math.abs(f10)) > ((double) Math.abs(f9)) * 1.16d;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public float mo68796d() {
        return ((getCurrentEvent().getY(getCurrentEvent().findPointerIndex(((Integer) this.f23543c.get(0)).intValue())) + getCurrentEvent().getY(getCurrentEvent().findPointerIndex(((Integer) this.f23543c.get(1)).intValue()))) / 2.0f) - ((getPreviousEvent().getY(getPreviousEvent().findPointerIndex(((Integer) this.f23543c.get(0)).intValue())) + getPreviousEvent().getY(getPreviousEvent().findPointerIndex(((Integer) this.f23543c.get(1)).intValue()))) / 2.0f);
    }

    public float getDeltaPixelsSinceStart() {
        return this.f23621a;
    }

    public float getDeltaPixelSinceLast() {
        return this.f23622b;
    }

    public float getPixelDeltaThreshold() {
        return this.f23625o;
    }

    public void setPixelDeltaThreshold(float f) {
        this.f23625o = f;
    }

    public void setPixelDeltaThresholdResource(int i) {
        setPixelDeltaThreshold(this.context.getResources().getDimension(i));
    }

    public float getMaxShoveAngle() {
        return this.f23624n;
    }

    public void setMaxShoveAngle(float f) {
        this.f23624n = f;
    }

    public void setDeltYdistanceThreshold(float f) {
        this.f23623l = f;
    }

    public void setDeltTwoFingerCloser(int i) {
        setDeltYdistanceThreshold(this.context.getResources().getDimension(i));
    }
}
