package com.didi.hawaii.mapsdk.gesture;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import java.util.Set;

public abstract class ProgressiveGesture<L> extends MultiFingerGesture<L> {

    /* renamed from: a */
    private final Set<Integer> f23575a = provideHandledTypes();

    /* renamed from: b */
    private boolean f23576b;

    /* renamed from: e */
    VelocityTracker f23577e;

    /* renamed from: f */
    float f23578f;

    /* renamed from: g */
    float f23579g;

    /* renamed from: h */
    float f23580h;

    /* renamed from: i */
    float f23581i;

    /* renamed from: j */
    float f23582j;

    /* renamed from: k */
    int f23583k;

    /* renamed from: l */
    private boolean f23584l;

    /* access modifiers changed from: protected */
    public abstract Set<Integer> provideHandledTypes();

    public ProgressiveGesture(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
    }

    /* access modifiers changed from: protected */
    public boolean analyzeEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (this.f23584l) {
            this.f23584l = false;
            gestureStopped();
        }
        VelocityTracker velocityTracker2 = this.f23577e;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(getCurrentEvent());
        }
        boolean analyzeEvent = super.analyzeEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 5) {
            VelocityTracker velocityTracker3 = this.f23577e;
            if (velocityTracker3 != null) {
                velocityTracker3.clear();
                this.f23582j = 0.0f;
                this.f23583k = 0;
            }
        } else if (actionMasked == 1 || actionMasked == 6) {
            if (this.f23543c.size() < getRequiredPointersCount() && this.f23576b) {
                gestureStopped();
                return true;
            }
        } else if (actionMasked == 3) {
            VelocityTracker velocityTracker4 = this.f23577e;
            if (velocityTracker4 != null) {
                velocityTracker4.clear();
                this.f23582j = 0.0f;
                this.f23583k = 0;
            }
            if (this.f23576b) {
                gestureStopped();
                return true;
            }
        } else if (actionMasked == 2 && (velocityTracker = this.f23577e) != null) {
            velocityTracker.computeCurrentVelocity(1000);
            this.f23580h = this.f23577e.getXVelocity();
            this.f23581i = this.f23577e.getYVelocity();
            this.f23582j += Math.abs(this.f23580h) + Math.abs(this.f23581i);
            this.f23583k++;
        }
        return analyzeEvent;
    }

    /* access modifiers changed from: protected */
    public void gestureStarted() {
        this.f23576b = true;
        if (this.f23577e == null) {
            this.f23577e = VelocityTracker.obtain();
        }
    }

    /* access modifiers changed from: protected */
    public void gestureStopped() {
        this.f23576b = false;
        VelocityTracker velocityTracker = this.f23577e;
        if (velocityTracker != null) {
            velocityTracker.computeCurrentVelocity(1000);
            this.f23578f = this.f23577e.getXVelocity();
            this.f23579g = this.f23577e.getYVelocity();
            this.f23582j = 0.0f;
            this.f23583k = 0;
            this.f23577e.recycle();
            this.f23577e = null;
        }
        reset();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Set<Integer> mo68759c() {
        return this.f23575a;
    }

    public boolean isInProgress() {
        return this.f23576b;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            interrupt();
        }
    }

    public void interrupt() {
        if (isInProgress()) {
            this.f23584l = true;
        }
    }
}
