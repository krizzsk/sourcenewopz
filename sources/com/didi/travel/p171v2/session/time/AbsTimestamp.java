package com.didi.travel.p171v2.session.time;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.didi.travel.v2.session.time.AbsTimestamp */
public abstract class AbsTimestamp {
    protected final String TAG = getClass().getSimpleName();
    protected final long mBaseTimestamp;
    protected final long mDuration;
    protected Handler mHandler = new Handler(Looper.getMainLooper());
    protected final long mMaxTimestamp;

    /* access modifiers changed from: protected */
    public abstract long getCurrentTimestampInner();

    public AbsTimestamp(long j, long j2) {
        if (j < 0) {
            throw new IllegalArgumentException(this.TAG + ":baseTimestamp = " + j);
        } else if (j2 >= 0) {
            this.mBaseTimestamp = j;
            this.mDuration = j2;
            if (j2 >= Long.MAX_VALUE - j) {
                this.mMaxTimestamp = Long.MAX_VALUE;
            } else {
                this.mMaxTimestamp = j + j2;
            }
        } else {
            throw new IllegalArgumentException(this.TAG + ":duration = " + j2);
        }
    }

    public long getBaseTimestamp() {
        return this.mBaseTimestamp;
    }

    public final long getDuration() {
        return this.mDuration;
    }

    public long getMaxTimestamp() {
        return this.mMaxTimestamp;
    }

    public long getCurrentTimestamp() {
        long currentTimestampInner = getCurrentTimestampInner();
        if (currentTimestampInner < this.mBaseTimestamp || currentTimestampInner > this.mMaxTimestamp) {
            return -1;
        }
        return currentTimestampInner;
    }

    public long getCurrentDuration() {
        long currentTimestamp = getCurrentTimestamp();
        if (currentTimestamp < 0) {
            return -1;
        }
        return currentTimestamp - this.mBaseTimestamp;
    }

    public long getCurrentRestDuration() {
        long currentTimestamp = getCurrentTimestamp();
        if (currentTimestamp < 0) {
            return -1;
        }
        return this.mMaxTimestamp - currentTimestamp;
    }
}
