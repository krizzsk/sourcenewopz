package com.didi.nova.assembly.components.bigimage.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* renamed from: com.didi.nova.assembly.components.bigimage.photoview.b */
/* compiled from: CustomGestureDetector */
class C10261b {

    /* renamed from: a */
    private static final int f29139a = -1;

    /* renamed from: b */
    private int f29140b = -1;

    /* renamed from: c */
    private int f29141c = 0;

    /* renamed from: d */
    private final ScaleGestureDetector f29142d;

    /* renamed from: e */
    private VelocityTracker f29143e;

    /* renamed from: f */
    private boolean f29144f;

    /* renamed from: g */
    private float f29145g;

    /* renamed from: h */
    private float f29146h;

    /* renamed from: i */
    private final float f29147i;

    /* renamed from: j */
    private final float f29148j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C10262c f29149k;

    C10261b(Context context, C10262c cVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f29148j = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.f29147i = (float) viewConfiguration.getScaledTouchSlop();
        this.f29149k = cVar;
        this.f29142d = new ScaleGestureDetector(context, new CustomGestureDetector$1(this));
    }

    /* renamed from: b */
    private float m20554b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f29141c);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    /* renamed from: c */
    private float m20555c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f29141c);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    /* renamed from: a */
    public boolean mo80110a() {
        return this.f29142d.isInProgress();
    }

    /* renamed from: b */
    public boolean mo80112b() {
        return this.f29144f;
    }

    /* renamed from: a */
    public boolean mo80111a(MotionEvent motionEvent) {
        try {
            this.f29142d.onTouchEvent(motionEvent);
            return m20556d(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    /* renamed from: d */
    private boolean m20556d(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int i = 0;
        if (action == 0) {
            this.f29140b = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f29143e = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.f29145g = m20554b(motionEvent);
            this.f29146h = m20555c(motionEvent);
            this.f29144f = false;
        } else if (action == 1) {
            this.f29140b = -1;
            if (this.f29144f && this.f29143e != null) {
                this.f29145g = m20554b(motionEvent);
                this.f29146h = m20555c(motionEvent);
                this.f29143e.addMovement(motionEvent);
                this.f29143e.computeCurrentVelocity(1000);
                float xVelocity = this.f29143e.getXVelocity();
                float yVelocity = this.f29143e.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f29148j) {
                    this.f29149k.onFling(this.f29145g, this.f29146h, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker = this.f29143e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f29143e = null;
            }
        } else if (action == 2) {
            float b = m20554b(motionEvent);
            float c = m20555c(motionEvent);
            float f = b - this.f29145g;
            float f2 = c - this.f29146h;
            if (!this.f29144f) {
                this.f29144f = Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.f29147i);
            }
            if (this.f29144f) {
                this.f29149k.onDrag(f, f2);
                this.f29145g = b;
                this.f29146h = c;
                VelocityTracker velocityTracker2 = this.f29143e;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.f29140b = -1;
            VelocityTracker velocityTracker3 = this.f29143e;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f29143e = null;
            }
        } else if (action == 6) {
            int a = C10263d.m20560a(motionEvent.getAction());
            if (motionEvent.getPointerId(a) == this.f29140b) {
                int i2 = a == 0 ? 1 : 0;
                this.f29140b = motionEvent.getPointerId(i2);
                this.f29145g = motionEvent.getX(i2);
                this.f29146h = motionEvent.getY(i2);
            }
        }
        int i3 = this.f29140b;
        if (i3 != -1) {
            i = i3;
        }
        this.f29141c = motionEvent.findPointerIndex(i);
        return true;
    }
}
