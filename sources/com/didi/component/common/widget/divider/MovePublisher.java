package com.didi.component.common.widget.divider;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.didi.component.common.widget.divider.IMovePublisher;

public class MovePublisher implements IMovePublisher {

    /* renamed from: a */
    private VelocityTracker f12050a;

    /* renamed from: b */
    private IMovePublisher.OnMoveListener f12051b;

    /* renamed from: c */
    private int f12052c;

    /* renamed from: d */
    private int f12053d;

    /* renamed from: e */
    private float f12054e;

    /* renamed from: f */
    private float f12055f;

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public MovePublisher(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f12052c = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f12053d = viewConfiguration.getScaledTouchSlop();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        if (r0 != 4) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            com.didi.component.common.widget.divider.IMovePublisher$OnMoveListener r0 = r3.f12051b
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r4.getAction()
            if (r0 == 0) goto L_0x0022
            r2 = 1
            if (r0 == r2) goto L_0x001d
            r2 = 2
            if (r0 == r2) goto L_0x0019
            r2 = 3
            if (r0 == r2) goto L_0x001d
            r2 = 4
            if (r0 == r2) goto L_0x001d
            goto L_0x0025
        L_0x0019:
            r3.m8123b(r4)
            goto L_0x0025
        L_0x001d:
            boolean r4 = r3.m8124c(r4)
            return r4
        L_0x0022:
            r3.m8122a(r4)
        L_0x0025:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.common.widget.divider.MovePublisher.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: a */
    private void m8122a(MotionEvent motionEvent) {
        VelocityTracker obtain = VelocityTracker.obtain();
        this.f12050a = obtain;
        obtain.addMovement(motionEvent);
        this.f12054e = motionEvent.getX();
        this.f12055f = motionEvent.getY();
    }

    /* renamed from: b */
    private void m8123b(MotionEvent motionEvent) {
        this.f12051b.onMove(motionEvent.getX() - this.f12055f, motionEvent.getY() - this.f12055f);
        this.f12050a.addMovement(motionEvent);
    }

    /* renamed from: c */
    private boolean m8124c(MotionEvent motionEvent) {
        float x = motionEvent.getX() - this.f12054e;
        float y = motionEvent.getY() - this.f12055f;
        this.f12051b.onMove(x, y);
        this.f12050a.addMovement(motionEvent);
        this.f12050a.computeCurrentVelocity(1000);
        float yVelocity = this.f12050a.getYVelocity();
        boolean z = Math.abs(yVelocity) >= ((float) this.f12052c);
        boolean z2 = Math.abs(y) > ((float) this.f12053d);
        this.f12051b.onEnd(z && z2, yVelocity < 0.0f);
        this.f12050a.recycle();
        this.f12050a = null;
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    public void setOnMoveListener(IMovePublisher.OnMoveListener onMoveListener) {
        this.f12051b = onMoveListener;
    }
}
