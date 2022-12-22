package com.didi.travel.p171v2.session.time;

import android.os.SystemClock;

/* renamed from: com.didi.travel.v2.session.time.DurationTimestamp */
public final class DurationTimestamp extends AbsTimestamp {

    /* renamed from: a */
    private long f44343a;

    /* renamed from: b */
    private volatile boolean f44344b = false;

    public DurationTimestamp(long j) {
        super(0, j);
    }

    public void startup() {
        this.f44344b = true;
        this.f44343a = SystemClock.elapsedRealtime();
    }

    public boolean isRunning() {
        return this.f44344b;
    }

    public long getBaseTimestamp() {
        if (!this.f44344b) {
            return -1;
        }
        return super.getBaseTimestamp();
    }

    public long getCurrentTimestamp() {
        if (!this.f44344b) {
            return -1;
        }
        return super.getCurrentTimestamp();
    }

    /* access modifiers changed from: protected */
    public long getCurrentTimestampInner() {
        if (!this.f44344b) {
            return -1;
        }
        return SystemClock.elapsedRealtime() - this.f44343a;
    }

    public long getMaxTimestamp() {
        if (!this.f44344b) {
            return -1;
        }
        return super.getMaxTimestamp();
    }

    public long getCurrentDuration() {
        if (!this.f44344b) {
            return -1;
        }
        return super.getCurrentDuration();
    }
}
