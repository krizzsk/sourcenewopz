package com.didi.hawaii.mapsdk.gesture;

import android.content.Context;
import android.graphics.PointF;
import android.util.Pair;
import android.view.MotionEvent;
import java.util.Iterator;
import java.util.Set;

public abstract class BaseGesture<L> {

    /* renamed from: j */
    private static final int f23503j = 255;

    /* renamed from: k */
    private static final int f23504k = 6;

    /* renamed from: l */
    private static final int f23505l = 5;

    /* renamed from: a */
    private final AndroidGesturesManager f23506a;

    /* renamed from: b */
    private MotionEvent f23507b;

    /* renamed from: c */
    private MotionEvent f23508c;
    protected final Context context;

    /* renamed from: d */
    private PointF f23509d = new PointF();

    /* renamed from: e */
    private PointF f23510e = new PointF();

    /* renamed from: f */
    private PointF f23511f = new PointF();

    /* renamed from: g */
    private PointF f23512g = new PointF();

    /* renamed from: h */
    private long f23513h;

    /* renamed from: i */
    private boolean f23514i = true;
    protected L listener;
    protected boolean mIsMultiTouch;
    protected boolean mIsMultiTouchEnd;

    /* access modifiers changed from: protected */
    public abstract boolean analyzeEvent(MotionEvent motionEvent);

    public BaseGesture(Context context2, AndroidGesturesManager androidGesturesManager) {
        this.context = context2;
        this.f23506a = androidGesturesManager;
    }

    /* access modifiers changed from: protected */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return m16785a(motionEvent);
    }

    /* renamed from: a */
    private boolean m16785a(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        int pointerCount = motionEvent.getPointerCount();
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mIsMultiTouch = false;
        } else if (action != 2) {
            if (action == 5) {
                this.f23511f.set(motionEvent.getX(0), motionEvent.getY(0));
                if (pointerCount > 1) {
                    this.f23512g.set(motionEvent.getX(1), motionEvent.getY(1));
                }
                this.mIsMultiTouch = true;
                this.mIsMultiTouchEnd = false;
            } else if (action == 6 && !this.mIsMultiTouchEnd) {
                this.mIsMultiTouchEnd = true;
            }
        } else if (this.mIsMultiTouch && !this.mIsMultiTouchEnd) {
            this.f23509d.set(motionEvent.getX(0), motionEvent.getY(0));
            if (pointerCount > 1) {
                this.f23510e.set(motionEvent.getX(1), motionEvent.getY(1));
            }
        }
        MotionEvent motionEvent2 = this.f23508c;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.f23508c = null;
        }
        MotionEvent motionEvent3 = this.f23507b;
        if (motionEvent3 != null) {
            this.f23508c = MotionEvent.obtain(motionEvent3);
            this.f23507b.recycle();
            this.f23507b = null;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        this.f23507b = obtain;
        this.f23513h = obtain.getEventTime() - this.f23507b.getDownTime();
        return analyzeEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public boolean canExecute(int i) {
        if (this.listener == null || !this.f23514i) {
            return false;
        }
        if (i == 3) {
            return true;
        }
        for (Set<Integer> next : this.f23506a.getMutuallyExclusiveGestures()) {
            if (next.contains(Integer.valueOf(i))) {
                for (Integer intValue : next) {
                    int intValue2 = intValue.intValue();
                    Iterator<BaseGesture> it = this.f23506a.getDetectors().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            BaseGesture next2 = it.next();
                            if ((next2 instanceof ProgressiveGesture) && i != intValue2) {
                                ProgressiveGesture progressiveGesture = (ProgressiveGesture) next2;
                                if (progressiveGesture.mo68759c().contains(Integer.valueOf(intValue2)) && progressiveGesture.isInProgress()) {
                                    return false;
                                }
                            }
                        }
                    }
                }
                continue;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isInScaleOrRotate() {
        for (BaseGesture next : this.f23506a.getDetectors()) {
            if (next instanceof ProgressiveGesture) {
                ProgressiveGesture progressiveGesture = (ProgressiveGesture) next;
                Set<Integer> c = progressiveGesture.mo68759c();
                if ((c.contains(1) || c.contains(2)) && progressiveGesture.isInProgress()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void setListener(L l) {
        this.listener = l;
    }

    /* access modifiers changed from: protected */
    public void removeListener() {
        this.listener = null;
    }

    public long getGestureDuration() {
        return this.f23513h;
    }

    public MotionEvent getCurrentEvent() {
        return this.f23507b;
    }

    public PointF getPointDownXY(int i) {
        if (i == 0) {
            return this.f23511f;
        }
        return this.f23512g;
    }

    public PointF getPointMoveXY(int i) {
        if (i == 0) {
            return this.f23509d;
        }
        return this.f23510e;
    }

    public void copyMoveXY2DownXY() {
        this.f23511f.set(this.f23509d.x, this.f23509d.y);
        this.f23512g.set(this.f23510e.x, this.f23510e.y);
    }

    public MotionEvent getPreviousEvent() {
        return this.f23508c;
    }

    public boolean isEnabled() {
        return this.f23514i;
    }

    public void setEnabled(boolean z) {
        this.f23514i = z;
    }

    /* access modifiers changed from: protected */
    public boolean useNNClassfy() {
        return this.f23506a.useNNClassfy();
    }

    /* access modifiers changed from: protected */
    public Pair<String, Float> getClassFyResult() {
        return this.f23506a.getClassFyResult();
    }
}
