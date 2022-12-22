package com.didi.hawaii.mapsdk.gesture;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class MultiFingerGesture<L> extends BaseGesture<L> {

    /* renamed from: a */
    private static final float f23541a = 0.67f;

    /* renamed from: b */
    private static final int f23542b = 2;

    /* renamed from: c */
    final List<Integer> f23543c = new ArrayList();

    /* renamed from: d */
    final HashMap<PointerDistancePair, MultiFingerDistancesObject> f23544d = new HashMap<>();

    /* renamed from: e */
    private final float f23545e;

    /* renamed from: f */
    private float f23546f;

    /* renamed from: g */
    private final C8948a f23547g = new C8948a();

    /* renamed from: h */
    private PointF f23548h = new PointF();

    /* access modifiers changed from: protected */
    public boolean analyzeMovement() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int getRequiredPointersCount() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public void reset() {
    }

    public MultiFingerGesture(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
        this.f23545e = (float) ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    /* access modifiers changed from: protected */
    public boolean analyzeEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        boolean a = this.f23547g.mo68854a(actionMasked, motionEvent.getPointerCount(), this.f23543c.size());
        if (a) {
            if (this instanceof ProgressiveGesture) {
                ProgressiveGesture progressiveGesture = (ProgressiveGesture) this;
                if (progressiveGesture.isInProgress()) {
                    progressiveGesture.gestureStopped();
                }
            }
            this.f23543c.clear();
            this.f23544d.clear();
        }
        if (!a || actionMasked == 0) {
            m16789a(motionEvent);
        }
        if (!a && actionMasked == 2 && this.f23543c.size() >= getRequiredPointersCount() && mo68733b()) {
            mo68759c();
            if (!isSloppyGesture()) {
                this.f23548h = Utils.determineFocalPoint(motionEvent);
                return analyzeMovement();
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m16789a(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 5) {
            this.f23543c.add(Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())));
        } else if (actionMasked == 1 || actionMasked == 6) {
            this.f23543c.remove(Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo68733b() {
        return getCurrentEvent().getPressure() / getPreviousEvent().getPressure() > f23541a;
    }

    /* renamed from: a */
    private boolean mo68712a() {
        for (MultiFingerDistancesObject currFingersDiffXY : this.f23544d.values()) {
            if (currFingersDiffXY.getCurrFingersDiffXY() < this.f23546f) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isSloppyGesture() {
        boolean z;
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        float f = ((float) displayMetrics.widthPixels) - this.f23545e;
        float f2 = this.f23545e;
        float f3 = ((float) displayMetrics.heightPixels) - f2;
        for (Integer intValue : this.f23543c) {
            int findPointerIndex = getCurrentEvent().findPointerIndex(intValue.intValue());
            float rawX = Utils.getRawX(getCurrentEvent(), findPointerIndex);
            float rawY = Utils.getRawY(getCurrentEvent(), findPointerIndex);
            if (rawX < f2 || rawY < f2 || rawX > f || rawY > f3) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                return true;
            }
        }
        return mo68712a();
    }

    /* access modifiers changed from: protected */
    public boolean canExecute(int i) {
        return super.canExecute(i) && !isSloppyGesture();
    }

    /* renamed from: c */
    private void mo68759c() {
        this.f23544d.clear();
        int i = 0;
        while (i < this.f23543c.size() - 1) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.f23543c.size(); i3++) {
                int intValue = this.f23543c.get(i).intValue();
                int intValue2 = this.f23543c.get(i3).intValue();
                float x = getPreviousEvent().getX(getPreviousEvent().findPointerIndex(intValue));
                float y = getPreviousEvent().getY(getPreviousEvent().findPointerIndex(intValue));
                float x2 = getPreviousEvent().getX(getPreviousEvent().findPointerIndex(intValue2)) - x;
                float y2 = getPreviousEvent().getY(getPreviousEvent().findPointerIndex(intValue2)) - y;
                float x3 = getCurrentEvent().getX(getCurrentEvent().findPointerIndex(intValue));
                float y3 = getCurrentEvent().getY(getCurrentEvent().findPointerIndex(intValue));
                this.f23544d.put(new PointerDistancePair(Integer.valueOf(intValue), Integer.valueOf(intValue2)), new MultiFingerDistancesObject(x2, y2, getCurrentEvent().getX(getCurrentEvent().findPointerIndex(intValue2)) - x3, getCurrentEvent().getY(getCurrentEvent().findPointerIndex(intValue2)) - y3));
            }
            i = i2;
        }
    }

    public float getCurrentSpan(int i, int i2) {
        if (m16791a(i, i2)) {
            return this.f23544d.get(new PointerDistancePair(this.f23543c.get(i), this.f23543c.get(i2))).getCurrFingersDiffXY();
        }
        throw new NoSuchElementException("There is no such pair of pointers!");
    }

    public float getPreviousSpan(int i, int i2) {
        if (m16791a(i, i2)) {
            return this.f23544d.get(new PointerDistancePair(this.f23543c.get(i), this.f23543c.get(i2))).getPrevFingersDiffXY();
        }
        throw new NoSuchElementException("There is no such pair of pointers!");
    }

    public float getCurrentSpanX(int i, int i2) {
        if (m16791a(i, i2)) {
            return Math.abs(this.f23544d.get(new PointerDistancePair(this.f23543c.get(i), this.f23543c.get(i2))).getCurrFingersDiffX());
        }
        throw new NoSuchElementException("There is no such pair of pointers!");
    }

    public float getCurrentSpanY(int i, int i2) {
        if (m16791a(i, i2)) {
            return Math.abs(this.f23544d.get(new PointerDistancePair(this.f23543c.get(i), this.f23543c.get(i2))).getCurrFingersDiffY());
        }
        throw new NoSuchElementException("There is no such pair of pointers!");
    }

    public float getPreviousSpanX(int i, int i2) {
        if (m16791a(i, i2)) {
            return Math.abs(this.f23544d.get(new PointerDistancePair(this.f23543c.get(i), this.f23543c.get(i2))).getPrevFingersDiffX());
        }
        throw new NoSuchElementException("There is no such pair of pointers!");
    }

    public float getPreviousSpanY(int i, int i2) {
        if (m16791a(i, i2)) {
            return Math.abs(this.f23544d.get(new PointerDistancePair(this.f23543c.get(i), this.f23543c.get(i2))).getPrevFingersDiffY());
        }
        throw new NoSuchElementException("There is no such pair of pointers!");
    }

    /* renamed from: a */
    private boolean m16791a(int i, int i2) {
        return i != i2 && i >= 0 && i2 >= 0 && i < getPointersCount() && i2 < getPointersCount();
    }

    public int getPointersCount() {
        return this.f23543c.size();
    }

    public PointF getFocalPoint() {
        return this.f23548h;
    }

    public float getSpanThreshold() {
        return this.f23546f;
    }

    public void setSpanThreshold(float f) {
        this.f23546f = f;
    }

    public void setSpanThresholdResource(int i) {
        setSpanThreshold(this.context.getResources().getDimension(i));
    }
}
