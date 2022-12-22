package com.didi.beatles.p099im.views.widget.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* renamed from: com.didi.beatles.im.views.widget.photoview.b */
/* compiled from: CustomGestureDetector */
class C4408b {

    /* renamed from: a */
    private static final int f10652a = -1;

    /* renamed from: b */
    private int f10653b = -1;

    /* renamed from: c */
    private int f10654c = 0;

    /* renamed from: d */
    private final ScaleGestureDetector f10655d;

    /* renamed from: e */
    private VelocityTracker f10656e;

    /* renamed from: f */
    private boolean f10657f;

    /* renamed from: g */
    private float f10658g;

    /* renamed from: h */
    private float f10659h;

    /* renamed from: i */
    private final float f10660i;

    /* renamed from: j */
    private final float f10661j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C4409c f10662k;

    C4408b(Context context, C4409c cVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f10661j = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.f10660i = (float) viewConfiguration.getScaledTouchSlop();
        this.f10662k = cVar;
        this.f10655d = new ScaleGestureDetector(context, new CustomGestureDetector$1(this));
    }

    /* renamed from: b */
    private float m7264b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f10654c);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    /* renamed from: c */
    private float m7265c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f10654c);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    /* renamed from: a */
    public boolean mo44629a() {
        return this.f10655d.isInProgress();
    }

    /* renamed from: b */
    public boolean mo44631b() {
        return this.f10657f;
    }

    /* renamed from: a */
    public boolean mo44630a(MotionEvent motionEvent) {
        try {
            this.f10655d.onTouchEvent(motionEvent);
            return m7266d(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    /* renamed from: d */
    private boolean m7266d(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int i = 0;
        if (action == 0) {
            this.f10653b = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f10656e = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.f10658g = m7264b(motionEvent);
            this.f10659h = m7265c(motionEvent);
            this.f10657f = false;
        } else if (action == 1) {
            this.f10653b = -1;
            if (this.f10657f && this.f10656e != null) {
                this.f10658g = m7264b(motionEvent);
                this.f10659h = m7265c(motionEvent);
                this.f10656e.addMovement(motionEvent);
                this.f10656e.computeCurrentVelocity(1000);
                float xVelocity = this.f10656e.getXVelocity();
                float yVelocity = this.f10656e.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f10661j) {
                    this.f10662k.onFling(this.f10658g, this.f10659h, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker = this.f10656e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f10656e = null;
            }
        } else if (action == 2) {
            float b = m7264b(motionEvent);
            float c = m7265c(motionEvent);
            float f = b - this.f10658g;
            float f2 = c - this.f10659h;
            if (!this.f10657f) {
                this.f10657f = Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.f10660i);
            }
            if (this.f10657f) {
                this.f10662k.onDrag(f, f2);
                this.f10658g = b;
                this.f10659h = c;
                VelocityTracker velocityTracker2 = this.f10656e;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.f10653b = -1;
            VelocityTracker velocityTracker3 = this.f10656e;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f10656e = null;
            }
        } else if (action == 6) {
            int a = C4410d.m7270a(motionEvent.getAction());
            if (motionEvent.getPointerId(a) == this.f10653b) {
                int i2 = a == 0 ? 1 : 0;
                this.f10653b = motionEvent.getPointerId(i2);
                this.f10658g = motionEvent.getX(i2);
                this.f10659h = motionEvent.getY(i2);
            }
        }
        int i3 = this.f10653b;
        if (i3 != -1) {
            i = i3;
        }
        this.f10654c = motionEvent.findPointerIndex(i);
        return true;
    }
}
