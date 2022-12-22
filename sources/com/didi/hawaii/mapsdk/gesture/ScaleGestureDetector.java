package com.didi.hawaii.mapsdk.gesture;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;
import com.taxis99.R;

public class ScaleGestureDetector {

    /* renamed from: A */
    private static final int f23590A = 1;

    /* renamed from: B */
    private static final int f23591B = 2;

    /* renamed from: a */
    private static final String f23592a = "ScaleGestureDetector";

    /* renamed from: x */
    private static final long f23593x = 128;

    /* renamed from: y */
    private static final float f23594y = 0.5f;

    /* renamed from: z */
    private static final int f23595z = 0;

    /* renamed from: C */
    private GestureDetector f23596C;

    /* renamed from: D */
    private boolean f23597D;

    /* renamed from: b */
    private final Context f23598b;

    /* renamed from: c */
    private final OnScaleGestureListener f23599c;

    /* renamed from: d */
    private float f23600d;

    /* renamed from: e */
    private float f23601e;

    /* renamed from: f */
    private boolean f23602f;

    /* renamed from: g */
    private boolean f23603g;

    /* renamed from: h */
    private float f23604h;

    /* renamed from: i */
    private float f23605i;

    /* renamed from: j */
    private float f23606j;

    /* renamed from: k */
    private float f23607k;

    /* renamed from: l */
    private float f23608l;

    /* renamed from: m */
    private float f23609m;

    /* renamed from: n */
    private float f23610n;

    /* renamed from: o */
    private long f23611o;

    /* renamed from: p */
    private long f23612p;

    /* renamed from: q */
    private boolean f23613q;

    /* renamed from: r */
    private int f23614r;

    /* renamed from: s */
    private int f23615s;

    /* renamed from: t */
    private final Handler f23616t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public float f23617u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public float f23618v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f23619w;

    public interface OnScaleGestureListener {
        boolean onScale(ScaleGestureDetector scaleGestureDetector);

        boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector);

        void onScaleEnd(ScaleGestureDetector scaleGestureDetector);
    }

    public static class SimpleOnScaleGestureListener implements ScaleGestureDetector.OnScaleGestureListener {
        public boolean onScale(android.view.ScaleGestureDetector scaleGestureDetector) {
            return false;
        }

        public boolean onScaleBegin(android.view.ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        public void onScaleEnd(android.view.ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public ScaleGestureDetector(Context context, OnScaleGestureListener onScaleGestureListener) {
        this(context, onScaleGestureListener, (Handler) null);
    }

    public ScaleGestureDetector(Context context, OnScaleGestureListener onScaleGestureListener, Handler handler) {
        this.f23619w = 0;
        this.f23598b = context;
        this.f23599c = onScaleGestureListener;
        this.f23614r = ViewConfiguration.get(context).getScaledTouchSlop();
        Resources resources = context.getResources();
        if (Build.VERSION.SDK_INT >= 24) {
            this.f23615s = resources.getDimensionPixelSize(R.dimen.dmap_internalScaleMinSpan24);
        } else {
            this.f23615s = resources.getDimensionPixelSize(R.dimen.dmap_internalScaleMinSpan23);
        }
        this.f23616t = handler;
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
        this.f23611o = motionEvent.getEventTime();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f23602f) {
            this.f23596C.onTouchEvent(motionEvent2);
        }
        int pointerCount = motionEvent.getPointerCount();
        boolean z = (motionEvent.getButtonState() & 32) != 0;
        boolean z2 = this.f23619w == 2 && !z;
        boolean z3 = actionMasked == 1 || actionMasked == 3 || z2;
        float f4 = 0.0f;
        if (actionMasked == 0 || z3) {
            if (this.f23613q) {
                this.f23599c.onScaleEnd(this);
                this.f23613q = false;
                this.f23606j = 0.0f;
                this.f23619w = 0;
            } else if (m16803a() && z3) {
                this.f23613q = false;
                this.f23606j = 0.0f;
                this.f23619w = 0;
            }
            if (z3) {
                return true;
            }
        }
        if (!this.f23613q && this.f23603g && !m16803a() && !z3 && z) {
            this.f23617u = motionEvent.getX();
            this.f23618v = motionEvent.getY();
            this.f23619w = 2;
            this.f23606j = 0.0f;
        }
        boolean z4 = actionMasked == 0 || actionMasked == 6 || actionMasked == 5 || z2;
        boolean z5 = actionMasked == 6;
        int actionIndex = z5 ? motionEvent.getActionIndex() : -1;
        int i = z5 ? pointerCount - 1 : pointerCount;
        if (m16803a()) {
            f2 = this.f23617u;
            f = this.f23618v;
            if (motionEvent.getY() < f) {
                this.f23597D = true;
            } else {
                this.f23597D = false;
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
        if (m16803a()) {
            f3 = f12;
        } else {
            f3 = (float) Math.hypot((double) f11, (double) f12);
        }
        boolean z6 = this.f23613q;
        this.f23600d = f2;
        this.f23601e = f;
        if (!m16803a() && this.f23613q && (f3 < ((float) this.f23615s) || z4)) {
            this.f23599c.onScaleEnd(this);
            this.f23613q = false;
            this.f23606j = f3;
        }
        if (z4) {
            this.f23607k = f11;
            this.f23609m = f11;
            this.f23608l = f12;
            this.f23610n = f12;
            this.f23604h = f3;
            this.f23605i = f3;
            this.f23606j = f3;
        }
        int i4 = m16803a() ? this.f23614r : this.f23615s;
        if (!this.f23613q && f3 >= ((float) i4) && (z6 || Math.abs(f3 - this.f23606j) > ((float) this.f23614r))) {
            this.f23607k = f11;
            this.f23609m = f11;
            this.f23608l = f12;
            this.f23610n = f12;
            this.f23604h = f3;
            this.f23605i = f3;
            this.f23612p = this.f23611o;
            this.f23613q = this.f23599c.onScaleBegin(this);
        }
        if (actionMasked == 2) {
            this.f23607k = f11;
            this.f23608l = f12;
            this.f23604h = f3;
            if (this.f23613q ? this.f23599c.onScale(this) : true) {
                this.f23609m = this.f23607k;
                this.f23610n = this.f23608l;
                this.f23605i = this.f23604h;
                this.f23612p = this.f23611o;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m16803a() {
        return this.f23619w != 0;
    }

    public void setQuickScaleEnabled(boolean z) {
        this.f23602f = z;
        if (z && this.f23596C == null) {
            this.f23596C = new GestureDetector(this.f23598b, new GestureDetector.SimpleOnGestureListener() {
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    float unused = ScaleGestureDetector.this.f23617u = motionEvent.getX();
                    float unused2 = ScaleGestureDetector.this.f23618v = motionEvent.getY();
                    int unused3 = ScaleGestureDetector.this.f23619w = 1;
                    return true;
                }
            }, this.f23616t);
        }
    }

    public boolean isQuickScaleEnabled() {
        return this.f23602f;
    }

    public void setStylusScaleEnabled(boolean z) {
        this.f23603g = z;
    }

    public boolean isStylusScaleEnabled() {
        return this.f23603g;
    }

    public boolean isInProgress() {
        return this.f23613q;
    }

    public float getFocusX() {
        return this.f23600d;
    }

    public float getFocusY() {
        return this.f23601e;
    }

    public float getCurrentSpan() {
        return this.f23604h;
    }

    public float getCurrentSpanX() {
        return this.f23607k;
    }

    public float getCurrentSpanY() {
        return this.f23608l;
    }

    public float getPreviousSpan() {
        return this.f23605i;
    }

    public float getPreviousSpanX() {
        return this.f23609m;
    }

    public float getPreviousSpanY() {
        return this.f23610n;
    }

    public float getScaleFactor() {
        if (m16803a()) {
            boolean z = (this.f23597D && this.f23604h < this.f23605i) || (!this.f23597D && this.f23604h > this.f23605i);
            float abs = Math.abs(1.0f - (this.f23604h / this.f23605i)) * 0.5f;
            if (this.f23605i <= 0.0f) {
                return 1.0f;
            }
            return z ? 1.0f + abs : 1.0f - abs;
        }
        float f = this.f23605i;
        if (f > 0.0f) {
            return this.f23604h / f;
        }
        return 1.0f;
    }

    public long getTimeDelta() {
        return this.f23611o - this.f23612p;
    }

    public long getEventTime() {
        return this.f23611o;
    }
}
