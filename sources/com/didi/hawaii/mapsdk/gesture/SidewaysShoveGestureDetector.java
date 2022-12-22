package com.didi.hawaii.mapsdk.gesture;

import android.content.Context;
import java.util.HashSet;
import java.util.Set;

public class SidewaysShoveGestureDetector extends ProgressiveGesture<OnSidewaysShoveGestureListener> {

    /* renamed from: l */
    private static final Set<Integer> f23626l;

    /* renamed from: a */
    float f23627a;

    /* renamed from: b */
    float f23628b;

    /* renamed from: m */
    private float f23629m;

    /* renamed from: n */
    private float f23630n;

    public interface OnSidewaysShoveGestureListener {
        boolean onSidewaysShove(SidewaysShoveGestureDetector sidewaysShoveGestureDetector, float f, float f2);

        boolean onSidewaysShoveBegin(SidewaysShoveGestureDetector sidewaysShoveGestureDetector);

        void onSidewaysShoveEnd(SidewaysShoveGestureDetector sidewaysShoveGestureDetector, float f, float f2);
    }

    public static class SimpleOnSidewaysShoveGestureListener implements OnSidewaysShoveGestureListener {
        public boolean onSidewaysShove(SidewaysShoveGestureDetector sidewaysShoveGestureDetector, float f, float f2) {
            return false;
        }

        public boolean onSidewaysShoveBegin(SidewaysShoveGestureDetector sidewaysShoveGestureDetector) {
            return true;
        }

        public void onSidewaysShoveEnd(SidewaysShoveGestureDetector sidewaysShoveGestureDetector, float f, float f2) {
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f23626l = hashSet;
        hashSet.add(14);
    }

    public SidewaysShoveGestureDetector(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
    }

    /* access modifiers changed from: protected */
    public Set<Integer> provideHandledTypes() {
        return f23626l;
    }

    /* access modifiers changed from: protected */
    public boolean analyzeMovement() {
        super.analyzeMovement();
        float d = mo68809d();
        this.f23628b = d;
        this.f23627a += d;
        if (isInProgress() && this.f23628b != 0.0f) {
            return ((OnSidewaysShoveGestureListener) this.listener).onSidewaysShove(this, this.f23628b, this.f23627a);
        }
        if (!canExecute(14) || !((OnSidewaysShoveGestureListener) this.listener).onSidewaysShoveBegin(this)) {
            return false;
        }
        gestureStarted();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean canExecute(int i) {
        return Math.abs(this.f23627a) >= this.f23630n && super.canExecute(i);
    }

    /* access modifiers changed from: protected */
    public boolean isSloppyGesture() {
        return super.isSloppyGesture() || !mo68712a();
    }

    /* access modifiers changed from: protected */
    public void gestureStopped() {
        super.gestureStopped();
        ((OnSidewaysShoveGestureListener) this.listener).onSidewaysShoveEnd(this, this.f23578f, this.f23579g);
    }

    /* access modifiers changed from: protected */
    public void reset() {
        super.reset();
        this.f23627a = 0.0f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo68712a() {
        MultiFingerDistancesObject multiFingerDistancesObject = (MultiFingerDistancesObject) this.f23544d.get(new PointerDistancePair((Integer) this.f23543c.get(0), (Integer) this.f23543c.get(1)));
        if (Math.abs(Math.toDegrees(Math.abs(Math.atan2((double) multiFingerDistancesObject.getCurrFingersDiffY(), (double) multiFingerDistancesObject.getCurrFingersDiffX()))) - 90.0d) <= ((double) this.f23629m)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public float mo68809d() {
        return ((getCurrentEvent().getX(getCurrentEvent().findPointerIndex(((Integer) this.f23543c.get(0)).intValue())) + getCurrentEvent().getX(getCurrentEvent().findPointerIndex(((Integer) this.f23543c.get(1)).intValue()))) / 2.0f) - ((getPreviousEvent().getX(getPreviousEvent().findPointerIndex(((Integer) this.f23543c.get(0)).intValue())) + getPreviousEvent().getX(getPreviousEvent().findPointerIndex(((Integer) this.f23543c.get(1)).intValue()))) / 2.0f);
    }

    public float getDeltaPixelsSinceStart() {
        return this.f23627a;
    }

    public float getDeltaPixelSinceLast() {
        return this.f23628b;
    }

    public float getPixelDeltaThreshold() {
        return this.f23630n;
    }

    public void setPixelDeltaThreshold(float f) {
        this.f23630n = f;
    }

    public void setPixelDeltaThresholdResource(int i) {
        setPixelDeltaThreshold(this.context.getResources().getDimension(i));
    }

    public float getMaxShoveAngle() {
        return this.f23629m;
    }

    public void setMaxShoveAngle(float f) {
        this.f23629m = f;
    }
}
