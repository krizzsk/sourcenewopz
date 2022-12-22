package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalRecyclerView extends RecyclerView {

    /* renamed from: a */
    int f43183a = 0;

    /* renamed from: b */
    int f43184b = 0;

    public HorizontalRecyclerView(Context context) {
        super(context);
    }

    public HorizontalRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HorizontalRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (r2 != 3) goto L_0x00a3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            float r0 = r7.getRawX()
            int r0 = (int) r0
            float r1 = r7.getRawY()
            int r1 = (int) r1
            int r2 = r7.getAction()
            r3 = 1
            if (r2 == 0) goto L_0x0088
            r4 = 0
            if (r2 == r3) goto L_0x006c
            r5 = 2
            if (r2 == r5) goto L_0x001c
            r0 = 3
            if (r2 == r0) goto L_0x006c
            goto L_0x00a3
        L_0x001c:
            int r2 = r6.f43183a
            int r2 = r0 - r2
            int r2 = java.lang.Math.abs(r2)
            int r2 = r2 + r4
            int r5 = r6.f43184b
            int r5 = r1 - r5
            int r5 = java.lang.Math.abs(r5)
            int r5 = r5 + r4
            if (r2 < r5) goto L_0x004c
            android.view.ViewParent r2 = r6.getParent()
            if (r2 == 0) goto L_0x0067
            android.view.ViewParent r2 = r6.getParent()
            android.view.ViewParent r2 = r2.getParent()
            if (r2 == 0) goto L_0x0067
            android.view.ViewParent r2 = r6.getParent()
            android.view.ViewParent r2 = r2.getParent()
            r2.requestDisallowInterceptTouchEvent(r3)
            goto L_0x0067
        L_0x004c:
            android.view.ViewParent r2 = r6.getParent()
            if (r2 == 0) goto L_0x0067
            android.view.ViewParent r2 = r6.getParent()
            android.view.ViewParent r2 = r2.getParent()
            if (r2 == 0) goto L_0x0067
            android.view.ViewParent r2 = r6.getParent()
            android.view.ViewParent r2 = r2.getParent()
            r2.requestDisallowInterceptTouchEvent(r4)
        L_0x0067:
            r6.f43183a = r0
            r6.f43184b = r1
            goto L_0x00a3
        L_0x006c:
            android.view.ViewParent r0 = r6.getParent()
            if (r0 == 0) goto L_0x00a3
            android.view.ViewParent r0 = r6.getParent()
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x00a3
            android.view.ViewParent r0 = r6.getParent()
            android.view.ViewParent r0 = r0.getParent()
            r0.requestDisallowInterceptTouchEvent(r4)
            goto L_0x00a3
        L_0x0088:
            android.view.ViewParent r0 = r6.getParent()
            if (r0 == 0) goto L_0x00a3
            android.view.ViewParent r0 = r6.getParent()
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x00a3
            android.view.ViewParent r0 = r6.getParent()
            android.view.ViewParent r0 = r0.getParent()
            r0.requestDisallowInterceptTouchEvent(r3)
        L_0x00a3:
            boolean r7 = super.dispatchTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.widget.HorizontalRecyclerView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }
}
