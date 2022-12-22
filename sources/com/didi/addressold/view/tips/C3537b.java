package com.didi.addressold.view.tips;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* renamed from: com.didi.addressold.view.tips.b */
/* compiled from: TipsStrategy */
class C3537b {

    /* renamed from: a */
    private View f8015a;

    /* renamed from: b */
    private int f8016b = 0;

    public C3537b(View view, int i) {
        this.f8015a = view;
        this.f8016b = i;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Point mo39982a(int r4, int r5, int r6, int r7, int r8, int r9, int r10) {
        /*
            r3 = this;
            float r4 = (float) r4
            android.view.View r0 = r3.f8015a
            float r0 = r3.m5185a((android.view.View) r0)
            float r4 = r4 + r0
            int r4 = (int) r4
            float r5 = (float) r5
            android.view.View r0 = r3.f8015a
            float r0 = r3.m5187b((android.view.View) r0)
            float r5 = r5 + r0
            int r5 = (int) r5
            r0 = 4
            r1 = 1
            r2 = 2
            if (r9 == 0) goto L_0x002f
            if (r9 == r1) goto L_0x002d
            if (r9 == r2) goto L_0x0025
            if (r9 == r0) goto L_0x001e
            goto L_0x0039
        L_0x001e:
            android.view.View r9 = r3.f8015a
            int r9 = r9.getHeight()
            goto L_0x0037
        L_0x0025:
            android.view.View r7 = r3.f8015a
            int r7 = r7.getHeight()
            int r5 = r5 + r7
            goto L_0x0039
        L_0x002d:
            int r5 = r5 - r7
            goto L_0x0039
        L_0x002f:
            android.view.View r9 = r3.f8015a
            int r9 = r9.getHeight()
            int r9 = r9 / r2
            int r7 = r7 / r2
        L_0x0037:
            int r9 = r9 - r7
            int r5 = r5 + r9
        L_0x0039:
            android.view.View r7 = r3.f8015a
            int r7 = r7.getWidth()
            if (r8 <= r7) goto L_0x0047
            android.view.View r7 = r3.f8015a
            int r8 = r7.getWidth()
        L_0x0047:
            if (r10 == 0) goto L_0x0068
            if (r10 == r1) goto L_0x0066
            if (r10 == r2) goto L_0x005e
            r7 = 3
            if (r10 == r7) goto L_0x005c
            if (r10 == r0) goto L_0x0053
            goto L_0x0072
        L_0x0053:
            android.view.View r7 = r3.f8015a
            int r7 = r7.getWidth()
            int r6 = r6 - r7
            int r6 = r6 + r8
            goto L_0x0066
        L_0x005c:
            int r4 = r4 + r8
            goto L_0x0072
        L_0x005e:
            android.view.View r6 = r3.f8015a
            int r6 = r6.getWidth()
            int r4 = r4 + r6
            goto L_0x0072
        L_0x0066:
            int r4 = r4 - r6
            goto L_0x0072
        L_0x0068:
            android.view.View r7 = r3.f8015a
            int r7 = r7.getWidth()
            int r7 = r7 / r2
            int r6 = r6 / r2
            int r7 = r7 - r6
            int r4 = r4 + r7
        L_0x0072:
            android.graphics.Point r6 = new android.graphics.Point
            r6.<init>(r4, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.addressold.view.tips.C3537b.mo39982a(int, int, int, int, int, int, int):android.graphics.Point");
    }

    /* renamed from: a */
    private float m5185a(View view) {
        if (view != null) {
            return ((float) view.getLeft()) + m5186a(view.getParent());
        }
        return 0.0f;
    }

    /* renamed from: a */
    private float m5186a(ViewParent viewParent) {
        if (viewParent == null || !(viewParent instanceof ViewGroup)) {
            return 0.0f;
        }
        return ((float) ((ViewGroup) viewParent).getLeft()) + m5186a(viewParent.getParent());
    }

    /* renamed from: b */
    private float m5187b(View view) {
        if (view != null) {
            return (((float) view.getTop()) + m5188b(view.getParent())) - ((float) this.f8016b);
        }
        return 0.0f;
    }

    /* renamed from: b */
    private float m5188b(ViewParent viewParent) {
        if (viewParent == null || !(viewParent instanceof ViewGroup)) {
            return 0.0f;
        }
        return ((float) ((ViewGroup) viewParent).getTop()) + m5188b(viewParent.getParent());
    }
}
