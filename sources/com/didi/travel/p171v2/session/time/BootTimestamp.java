package com.didi.travel.p171v2.session.time;

import android.os.SystemClock;

/* renamed from: com.didi.travel.v2.session.time.BootTimestamp */
public class BootTimestamp extends AbsTimestamp {
    public BootTimestamp(long j, long j2) {
        super(j, j2);
    }

    /* access modifiers changed from: protected */
    public long getCurrentTimestampInner() {
        return SystemClock.elapsedRealtime();
    }
}
