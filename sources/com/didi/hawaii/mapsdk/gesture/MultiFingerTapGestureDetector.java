package com.didi.hawaii.mapsdk.gesture;

import android.content.Context;
import android.view.MotionEvent;
import java.util.HashMap;
import java.util.Iterator;

public class MultiFingerTapGestureDetector extends MultiFingerGesture<OnMultiFingerTapGestureListener> {

    /* renamed from: a */
    private long f23549a;

    /* renamed from: b */
    private float f23550b;

    /* renamed from: e */
    private boolean f23551e;

    /* renamed from: f */
    private boolean f23552f;

    /* renamed from: g */
    private int f23553g;

    public interface OnMultiFingerTapGestureListener {
        boolean onMultiFingerDown(MotionEvent motionEvent);

        boolean onMultiFingerTap(MultiFingerTapGestureDetector multiFingerTapGestureDetector, int i);

        boolean onMultiFingerUp(MotionEvent motionEvent);
    }

    public MultiFingerTapGestureDetector(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
    }

    /* access modifiers changed from: protected */
    public boolean analyzeEvent(MotionEvent motionEvent) {
        super.analyzeEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        boolean z = false;
        if (actionMasked != 1) {
            if (actionMasked != 2) {
                if (actionMasked == 5) {
                    if (this.f23552f) {
                        this.f23551e = true;
                    }
                    this.f23553g = this.f23543c.size();
                    if (canExecute(4)) {
                        return ((OnMultiFingerTapGestureListener) this.listener).onMultiFingerDown(motionEvent);
                    }
                } else if (actionMasked == 6) {
                    this.f23552f = true;
                    if (canExecute(4)) {
                        return ((OnMultiFingerTapGestureListener) this.listener).onMultiFingerUp(motionEvent);
                    }
                }
            } else if (!this.f23551e) {
                this.f23551e = mo68746a(this.f23544d);
            }
            return false;
        }
        if (canExecute(4)) {
            z = ((OnMultiFingerTapGestureListener) this.listener).onMultiFingerTap(this, this.f23553g);
        }
        reset();
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo68746a(HashMap<PointerDistancePair, MultiFingerDistancesObject> hashMap) {
        boolean z;
        Iterator<MultiFingerDistancesObject> it = hashMap.values().iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                return false;
            }
            MultiFingerDistancesObject next = it.next();
            float abs = Math.abs(next.getCurrFingersDiffX() - next.getPrevFingersDiffX());
            float abs2 = Math.abs(next.getCurrFingersDiffY() - next.getPrevFingersDiffY());
            float f = this.f23550b;
            if (abs > f || abs2 > f) {
                z = true;
            }
            this.f23551e = z;
        } while (!z);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean canExecute(int i) {
        if (this.f23553g <= 1 || this.f23551e || getGestureDuration() >= this.f23549a || !super.canExecute(i)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void reset() {
        super.reset();
        this.f23553g = 0;
        this.f23551e = false;
        this.f23552f = false;
    }

    public long getMultiFingerTapTimeThreshold() {
        return this.f23549a;
    }

    public void setMultiFingerTapTimeThreshold(long j) {
        this.f23549a = j;
    }

    public float getMultiFingerTapMovementThreshold() {
        return this.f23550b;
    }

    public void setMultiFingerTapMovementThreshold(float f) {
        this.f23550b = f;
    }

    public void setMultiFingerTapMovementThresholdResource(int i) {
        setMultiFingerTapMovementThreshold(this.context.getResources().getDimension(i));
    }
}
