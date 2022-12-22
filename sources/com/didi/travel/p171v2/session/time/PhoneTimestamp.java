package com.didi.travel.p171v2.session.time;

/* renamed from: com.didi.travel.v2.session.time.PhoneTimestamp */
public class PhoneTimestamp extends AbsTimestamp {
    public PhoneTimestamp(long j, long j2) {
        super(j, j2);
    }

    /* access modifiers changed from: protected */
    public long getCurrentTimestampInner() {
        return System.currentTimeMillis();
    }
}
