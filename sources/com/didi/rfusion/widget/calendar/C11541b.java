package com.didi.rfusion.widget.calendar;

import android.os.Build;
import android.widget.BaseAdapter;
import java.util.Calendar;

/* renamed from: com.didi.rfusion.widget.calendar.b */
/* compiled from: RFDaysOfWeekAdapter */
class C11541b extends BaseAdapter {

    /* renamed from: d */
    private static final int f33470d = 4;

    /* renamed from: e */
    private static final int f33471e = (Build.VERSION.SDK_INT >= 26 ? 4 : 1);

    /* renamed from: a */
    private final Calendar f33472a;

    /* renamed from: b */
    private final int f33473b;

    /* renamed from: c */
    private final int f33474c = this.f33472a.getFirstDayOfWeek();

    public long getItemId(int i) {
        return 0;
    }

    public C11541b() {
        Calendar c = C11544e.m23567c();
        this.f33472a = c;
        this.f33473b = c.getMaximum(7);
    }

    /* renamed from: a */
    public Integer getItem(int i) {
        if (i >= this.f33473b) {
            return null;
        }
        return Integer.valueOf(m23531b(i));
    }

    public int getCount() {
        return this.f33473b;
    }

    /* JADX WARNING: type inference failed for: r4v5, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r3, android.view.View r4, android.view.ViewGroup r5) {
        /*
            r2 = this;
            r0 = r4
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r4 != 0) goto L_0x0018
            android.content.Context r4 = r5.getContext()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0 = 2131626178(0x7f0e08c2, float:1.8879585E38)
            r1 = 0
            android.view.View r4 = r4.inflate(r0, r5, r1)
            r0 = r4
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0018:
            java.util.Calendar r4 = r2.f33472a
            int r3 = r2.m23531b(r3)
            r5 = 7
            r4.set(r5, r3)
            java.util.Locale r3 = com.didi.rfusion.RFusion.getLocale()
            java.util.Calendar r4 = r2.f33472a
            int r1 = f33471e
            java.lang.String r3 = r4.getDisplayName(r5, r1, r3)
            r0.setText(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.widget.calendar.C11541b.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    /* renamed from: b */
    private int m23531b(int i) {
        int i2 = i + this.f33474c;
        int i3 = this.f33473b;
        return i2 > i3 ? i2 - i3 : i2;
    }
}
