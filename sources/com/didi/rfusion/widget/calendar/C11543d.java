package com.didi.rfusion.widget.calendar;

import java.util.Calendar;
import java.util.TimeZone;

/* renamed from: com.didi.rfusion.widget.calendar.d */
/* compiled from: TimeSource */
class C11543d {

    /* renamed from: a */
    private static final C11543d f33481a = new C11543d((Long) null, (TimeZone) null);

    /* renamed from: b */
    private final Long f33482b;

    /* renamed from: c */
    private final TimeZone f33483c;

    private C11543d(Long l, TimeZone timeZone) {
        this.f33482b = l;
        this.f33483c = timeZone;
    }

    /* renamed from: a */
    static C11543d m23547a() {
        return f33481a;
    }

    /* renamed from: a */
    static C11543d m23549a(long j, TimeZone timeZone) {
        return new C11543d(Long.valueOf(j), timeZone);
    }

    /* renamed from: a */
    static C11543d m23548a(long j) {
        return new C11543d(Long.valueOf(j), (TimeZone) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Calendar mo87688b() {
        return mo87687a(this.f33483c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Calendar mo87687a(TimeZone timeZone) {
        Calendar instance = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l = this.f33482b;
        if (l != null) {
            instance.setTimeInMillis(l.longValue());
        }
        return instance;
    }
}
