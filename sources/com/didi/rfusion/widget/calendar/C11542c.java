package com.didi.rfusion.widget.calendar;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Collection;

/* renamed from: com.didi.rfusion.widget.calendar.c */
/* compiled from: RFMonthAdapter */
class C11542c extends BaseAdapter {

    /* renamed from: a */
    static final int f33475a = C11544e.m23567c().getMaximum(4);

    /* renamed from: b */
    final Month f33476b;

    /* renamed from: c */
    final RFDateSelector<?> f33477c;

    /* renamed from: d */
    RFCalendarStyle f33478d;

    /* renamed from: e */
    final RFCalendarConstraints f33479e;

    /* renamed from: f */
    private Collection<Long> f33480f;

    public boolean hasStableIds() {
        return true;
    }

    C11542c(Month month, RFDateSelector<?> rFDateSelector, RFCalendarConstraints rFCalendarConstraints) {
        this.f33476b = month;
        this.f33477c = rFDateSelector;
        this.f33479e = rFCalendarConstraints;
        this.f33480f = rFDateSelector.getSelectedDays();
    }

    /* renamed from: a */
    public Long getItem(int i) {
        if (i < this.f33476b.mo87538b() || i > mo87676b()) {
            return null;
        }
        return Long.valueOf(this.f33476b.mo87536a(mo87677b(i)));
    }

    public long getItemId(int i) {
        return (long) (i / this.f33476b.f33401c);
    }

    public int getCount() {
        return this.f33476b.f33402d + mo87672a();
    }

    /* JADX WARNING: type inference failed for: r7v11, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.TextView getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.m23533a((android.content.Context) r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L_0x001f
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            r0 = 2131626177(0x7f0e08c1, float:1.8879583E38)
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x001f:
            int r7 = r5.mo87672a()
            int r7 = r6 - r7
            if (r7 < 0) goto L_0x0078
            com.didi.rfusion.widget.calendar.Month r8 = r5.f33476b
            int r8 = r8.f33402d
            if (r7 < r8) goto L_0x002e
            goto L_0x0078
        L_0x002e:
            r8 = 1
            int r7 = r7 + r8
            com.didi.rfusion.widget.calendar.Month r2 = r5.f33476b
            r0.setTag(r2)
            android.content.res.Resources r2 = r0.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            java.util.Locale r2 = r2.locale
            java.lang.Object[] r3 = new java.lang.Object[r8]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r3[r1] = r4
            java.lang.String r4 = "%d"
            java.lang.String r2 = java.lang.String.format(r2, r4, r3)
            r0.setText(r2)
            com.didi.rfusion.widget.calendar.Month r2 = r5.f33476b
            long r2 = r2.mo87536a((int) r7)
            com.didi.rfusion.widget.calendar.Month r7 = r5.f33476b
            int r7 = r7.f33400b
            com.didi.rfusion.widget.calendar.Month r4 = com.didi.rfusion.widget.calendar.Month.m23471a()
            int r4 = r4.f33400b
            if (r7 != r4) goto L_0x006a
            java.lang.String r7 = com.didi.rfusion.widget.calendar.C11540a.m23526c(r2)
            r0.setContentDescription(r7)
            goto L_0x0071
        L_0x006a:
            java.lang.String r7 = com.didi.rfusion.widget.calendar.C11540a.m23528d(r2)
            r0.setContentDescription(r7)
        L_0x0071:
            r0.setVisibility(r1)
            r0.setEnabled(r8)
            goto L_0x0080
        L_0x0078:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
        L_0x0080:
            java.lang.Long r6 = r5.getItem((int) r6)
            if (r6 != 0) goto L_0x0087
            return r0
        L_0x0087:
            long r6 = r6.longValue()
            r5.m23534a((android.widget.TextView) r0, (long) r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.widget.calendar.C11542c.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    /* renamed from: a */
    public void mo87675a(RFCalendarGridView rFCalendarGridView) {
        for (Long longValue : this.f33480f) {
            m23535a(rFCalendarGridView, longValue.longValue());
        }
        RFDateSelector<?> rFDateSelector = this.f33477c;
        if (rFDateSelector != null) {
            for (Long longValue2 : rFDateSelector.getSelectedDays()) {
                m23535a(rFCalendarGridView, longValue2.longValue());
            }
            this.f33480f = this.f33477c.getSelectedDays();
        }
    }

    /* renamed from: a */
    private void m23535a(RFCalendarGridView rFCalendarGridView, long j) {
        if (Month.m23473a(j).equals(this.f33476b)) {
            m23534a((TextView) rFCalendarGridView.getChildAt(rFCalendarGridView.getAdapter().mo87678c(this.f33476b.mo87539b(j)) - rFCalendarGridView.getFirstVisiblePosition()), j);
        }
    }

    /* renamed from: a */
    private void m23534a(TextView textView, long j) {
        RFCalendarItemStyle rFCalendarItemStyle;
        if (textView != null) {
            if (this.f33479e.getDateValidator().isValid(j)) {
                textView.setEnabled(true);
                if (m23536a(j)) {
                    rFCalendarItemStyle = this.f33478d.getSelectedDay();
                } else if (C11544e.m23564b().getTimeInMillis() == j) {
                    rFCalendarItemStyle = this.f33478d.getTodayDay();
                } else {
                    rFCalendarItemStyle = this.f33478d.getDay();
                }
            } else {
                textView.setEnabled(false);
                rFCalendarItemStyle = this.f33478d.getInvalidDay();
            }
            rFCalendarItemStyle.styleItem(textView);
        }
    }

    /* renamed from: a */
    private boolean m23536a(long j) {
        for (Long longValue : this.f33477c.getSelectedDays()) {
            if (C11544e.m23553a(j) == C11544e.m23553a(longValue.longValue())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m23533a(Context context) {
        if (this.f33478d == null) {
            this.f33478d = new RFCalendarStyle(context);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo87672a() {
        return this.f33476b.mo87538b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo87676b() {
        return (this.f33476b.mo87538b() + this.f33476b.f33402d) - 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo87677b(int i) {
        return (i - this.f33476b.mo87538b()) + 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo87678c(int i) {
        return mo87672a() + (i - 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo87679d(int i) {
        return i >= mo87672a() && i <= mo87676b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo87680e(int i) {
        return i % this.f33476b.f33401c == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo87681f(int i) {
        return (i + 1) % this.f33476b.f33401c == 0;
    }
}
