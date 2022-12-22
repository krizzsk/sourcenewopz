package com.didi.soda.order.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;

public class AddressCardRecyclerView extends NovaRecyclerView {

    /* renamed from: a */
    private float f43538a;

    /* renamed from: b */
    private float f43539b;

    /* renamed from: c */
    private int f43540c = 100;

    /* renamed from: d */
    private int f43541d = 7;

    /* renamed from: e */
    private ExpendListener f43542e;

    /* renamed from: f */
    private boolean f43543f = false;

    public interface ExpendListener {
        void expendOrPickUp(float f);
    }

    /* renamed from: a */
    private boolean m30863a(int i, int i2, int i3, int i4, int i5, int i6) {
        return i2 >= i4 && i2 <= i6 && i >= i3 && i <= i5;
    }

    public void setmIsMapExpend(boolean z) {
        this.f43543f = z;
    }

    public void setmExpendListener(ExpendListener expendListener) {
        this.f43542e = expendListener;
    }

    public AddressCardRecyclerView(Context context) {
        super(context);
        this.f43541d = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public AddressCardRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f43541d = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public AddressCardRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f43541d = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return m30864a(motionEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f43538a = motionEvent.getX();
            this.f43539b = motionEvent.getY();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        if (r0 != 3) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        if (r4.f43543f != false) goto L_0x0036;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m30864a(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getAction()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L_0x0014
            r3 = 2
            if (r0 == r3) goto L_0x000f
            r1 = 3
            if (r0 == r1) goto L_0x0014
            goto L_0x0035
        L_0x000f:
            boolean r0 = r4.f43543f
            if (r0 == 0) goto L_0x0035
            goto L_0x0036
        L_0x0014:
            r5.getX()
            float r0 = r5.getY()
            float r1 = r4.f43539b
            float r0 = r0 - r1
            float r1 = java.lang.Math.abs(r0)
            int r3 = r4.f43540c
            float r3 = (float) r3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0030
            com.didi.soda.order.view.AddressCardRecyclerView$ExpendListener r1 = r4.f43542e
            if (r1 == 0) goto L_0x0030
            r1.expendOrPickUp(r0)
        L_0x0030:
            r0 = 0
            r4.f43538a = r0
            r4.f43539b = r0
        L_0x0035:
            r1 = 0
        L_0x0036:
            if (r1 == 0) goto L_0x0039
            goto L_0x003d
        L_0x0039:
            boolean r1 = super.onTouchEvent(r5)
        L_0x003d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.order.view.AddressCardRecyclerView.m30864a(android.view.MotionEvent):boolean");
    }
}
