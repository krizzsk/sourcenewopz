package com.didi.zxing.barcodescanner.scale;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class ScaleGestureDetector {

    /* renamed from: A */
    private static final int f45419A = 1;

    /* renamed from: B */
    private static final int f45420B = 2;

    /* renamed from: a */
    private static final String f45421a = "ScaleGestureDetector";

    /* renamed from: x */
    private static final long f45422x = 128;

    /* renamed from: y */
    private static final float f45423y = 0.5f;

    /* renamed from: z */
    private static final int f45424z = 0;

    /* renamed from: C */
    private GestureDetector f45425C;

    /* renamed from: D */
    private boolean f45426D;

    /* renamed from: b */
    private final Context f45427b;

    /* renamed from: c */
    private final OnScaleGestureListener f45428c;

    /* renamed from: d */
    private float f45429d;

    /* renamed from: e */
    private float f45430e;

    /* renamed from: f */
    private boolean f45431f;

    /* renamed from: g */
    private boolean f45432g;

    /* renamed from: h */
    private float f45433h;

    /* renamed from: i */
    private float f45434i;

    /* renamed from: j */
    private float f45435j;

    /* renamed from: k */
    private float f45436k;

    /* renamed from: l */
    private float f45437l;

    /* renamed from: m */
    private float f45438m;

    /* renamed from: n */
    private float f45439n;

    /* renamed from: o */
    private long f45440o;

    /* renamed from: p */
    private long f45441p;

    /* renamed from: q */
    private boolean f45442q;

    /* renamed from: r */
    private int f45443r;

    /* renamed from: s */
    private int f45444s;

    /* renamed from: t */
    private final Handler f45445t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public float f45446u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public float f45447v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f45448w;

    public interface OnScaleGestureListener {
        boolean onScale(ScaleGestureDetector scaleGestureDetector);

        boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector);

        void onScaleEnd(ScaleGestureDetector scaleGestureDetector);
    }

    public static class SimpleOnScaleGestureListener implements OnScaleGestureListener {
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            return false;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public ScaleGestureDetector(Context context, OnScaleGestureListener onScaleGestureListener) {
        this(context, onScaleGestureListener, (Handler) null);
    }

    public ScaleGestureDetector(Context context, OnScaleGestureListener onScaleGestureListener, Handler handler) {
        this.f45448w = 0;
        this.f45427b = context;
        this.f45428c = onScaleGestureListener;
        this.f45443r = 0;
        context.getResources();
        this.f45444s = 10;
        this.f45445t = handler;
        int i = context.getApplicationInfo().targetSdkVersion;
        if (i > 18) {
            setQuickScaleEnabled(true);
        }
        if (i > 22) {
            setStylusScaleEnabled(true);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        float f3;
        MotionEvent motionEvent2 = motionEvent;
        this.f45440o = motionEvent.getEventTime();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f45431f) {
            this.f45425C.onTouchEvent(motionEvent2);
        }
        int pointerCount = motionEvent.getPointerCount();
        boolean z = (motionEvent.getButtonState() & 32) != 0;
        boolean z2 = this.f45448w == 2 && !z;
        boolean z3 = actionMasked == 1 || actionMasked == 3 || z2;
        float f4 = 0.0f;
        if (actionMasked == 0 || z3) {
            if (this.f45442q) {
                this.f45428c.onScaleEnd(this);
                this.f45442q = false;
                this.f45435j = 0.0f;
                this.f45448w = 0;
            } else if (m32607a() && z3) {
                this.f45442q = false;
                this.f45435j = 0.0f;
                this.f45448w = 0;
            }
            if (z3) {
                return true;
            }
        }
        if (!this.f45442q && this.f45432g && !m32607a() && !z3 && z) {
            this.f45446u = motionEvent.getX();
            this.f45447v = motionEvent.getY();
            this.f45448w = 2;
            this.f45435j = 0.0f;
        }
        boolean z4 = actionMasked == 0 || actionMasked == 6 || actionMasked == 5 || z2;
        boolean z5 = actionMasked == 6;
        int actionIndex = z5 ? motionEvent.getActionIndex() : -1;
        int i = z5 ? pointerCount - 1 : pointerCount;
        if (m32607a()) {
            f2 = this.f45446u;
            f = this.f45447v;
            if (motionEvent.getY() < f) {
                this.f45426D = true;
            } else {
                this.f45426D = false;
            }
        } else {
            float f5 = 0.0f;
            float f6 = 0.0f;
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (actionIndex != i2) {
                    f5 += motionEvent2.getX(i2);
                    f6 += motionEvent2.getY(i2);
                }
            }
            float f7 = (float) i;
            float f8 = f5 / f7;
            f = f6 / f7;
            f2 = f8;
        }
        float f9 = 0.0f;
        for (int i3 = 0; i3 < pointerCount; i3++) {
            if (actionIndex != i3) {
                f4 += Math.abs(motionEvent2.getX(i3) - f2);
                f9 += Math.abs(motionEvent2.getY(i3) - f);
            }
        }
        float f10 = (float) i;
        float f11 = (f4 / f10) * 2.0f;
        float f12 = (f9 / f10) * 2.0f;
        if (m32607a()) {
            f3 = f12;
        } else {
            f3 = (float) Math.hypot((double) f11, (double) f12);
        }
        boolean z6 = this.f45442q;
        this.f45429d = f2;
        this.f45430e = f;
        if (!m32607a() && this.f45442q && (f3 < ((float) this.f45444s) || z4)) {
            this.f45428c.onScaleEnd(this);
            this.f45442q = false;
            this.f45435j = f3;
        }
        if (z4) {
            this.f45436k = f11;
            this.f45438m = f11;
            this.f45437l = f12;
            this.f45439n = f12;
            this.f45433h = f3;
            this.f45434i = f3;
            this.f45435j = f3;
        }
        int i4 = m32607a() ? this.f45443r : this.f45444s;
        if (!this.f45442q && f3 >= ((float) i4) && (z6 || Math.abs(f3 - this.f45435j) > ((float) this.f45443r))) {
            this.f45436k = f11;
            this.f45438m = f11;
            this.f45437l = f12;
            this.f45439n = f12;
            this.f45433h = f3;
            this.f45434i = f3;
            this.f45441p = this.f45440o;
            this.f45442q = this.f45428c.onScaleBegin(this);
        }
        if (actionMasked == 2) {
            this.f45436k = f11;
            this.f45437l = f12;
            this.f45433h = f3;
            if (this.f45442q ? this.f45428c.onScale(this) : true) {
                this.f45438m = this.f45436k;
                this.f45439n = this.f45437l;
                this.f45434i = this.f45433h;
                this.f45441p = this.f45440o;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m32607a() {
        return this.f45448w != 0;
    }

    public void setQuickScaleEnabled(boolean z) {
        this.f45431f = z;
        if (z && this.f45425C == null) {
            this.f45425C = new GestureDetector(this.f45427b, new GestureDetector.SimpleOnGestureListener() {
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    float unused = ScaleGestureDetector.this.f45446u = motionEvent.getX();
                    float unused2 = ScaleGestureDetector.this.f45447v = motionEvent.getY();
                    int unused3 = ScaleGestureDetector.this.f45448w = 1;
                    return true;
                }
            }, this.f45445t);
        }
    }

    public boolean isQuickScaleEnabled() {
        return this.f45431f;
    }

    public void setStylusScaleEnabled(boolean z) {
        this.f45432g = z;
    }

    public boolean isStylusScaleEnabled() {
        return this.f45432g;
    }

    public boolean isInProgress() {
        return this.f45442q;
    }

    public float getFocusX() {
        return this.f45429d;
    }

    public float getFocusY() {
        return this.f45430e;
    }

    public float getCurrentSpan() {
        return this.f45433h;
    }

    public float getCurrentSpanX() {
        return this.f45436k;
    }

    public float getCurrentSpanY() {
        return this.f45437l;
    }

    public float getPreviousSpan() {
        return this.f45434i;
    }

    public float getPreviousSpanX() {
        return this.f45438m;
    }

    public float getPreviousSpanY() {
        return this.f45439n;
    }

    public float getScaleFactor() {
        if (m32607a()) {
            boolean z = (this.f45426D && this.f45433h < this.f45434i) || (!this.f45426D && this.f45433h > this.f45434i);
            float abs = Math.abs(1.0f - (this.f45433h / this.f45434i)) * 0.5f;
            if (this.f45434i <= 0.0f) {
                return 1.0f;
            }
            return z ? 1.0f + abs : 1.0f - abs;
        }
        float f = this.f45434i;
        if (f > 0.0f) {
            return this.f45433h / f;
        }
        return 1.0f;
    }

    public long getTimeDelta() {
        return this.f45440o - this.f45441p;
    }

    public long getEventTime() {
        return this.f45440o;
    }
}
