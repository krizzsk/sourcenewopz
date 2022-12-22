package com.didichuxing.bigdata.p173dp.locsdk.once;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.once.util.ApolloProxy;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.DIDILocationUpdateOption */
public class DIDILocationUpdateOption {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final float f46070a = ApolloProxy.getInstance().getDirectNotifyIntervalRate();

    /* renamed from: b */
    private IntervalMode f46071b = IntervalMode.NORMAL;

    /* renamed from: c */
    private String f46072c;

    /* renamed from: d */
    private String f46073d;

    /* renamed from: e */
    private boolean f46074e = false;

    public boolean isDirectNotify() {
        return this.f46074e;
    }

    public void setDirectNotify(boolean z) {
        this.f46074e = z;
        DLog.m32737d("setDirectNotify=" + z + " IntervalMode=" + this.f46071b + " Key=" + this.f46072c + ":" + this.f46073d);
    }

    public String getModuleKey() {
        return this.f46072c;
    }

    public String getHexModuleKey() {
        return this.f46073d;
    }

    public void setModuleKey(String str) {
        this.f46072c = str;
        this.f46073d = str != null ? Integer.toHexString(str.hashCode()) : "null";
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.once.DIDILocationUpdateOption$IntervalMode */
    public enum IntervalMode {
        SUPER_HIGH_FREQUENCY(200, (long) (DIDILocationUpdateOption.f46070a * 200.0f)),
        HIGH_FREQUENCY(1000, (long) (DIDILocationUpdateOption.f46070a * 1000.0f)),
        NORMAL(3000, (long) (DIDILocationUpdateOption.f46070a * 3000.0f)),
        LOW_FREQUENCY(9000, 9000),
        BATTERY_SAVE(36000, 36000),
        MORE_BATTERY_SAVE(72000, 72000);
        
        private long mDirectNotifyInterval;
        private long mInterval;
        private String mName;

        private IntervalMode(long j, long j2) {
            this.mInterval = j;
            this.mDirectNotifyInterval = j2;
            this.mName = name() + Const.joLeft + this.mInterval + ", " + this.mDirectNotifyInterval + "}";
        }

        public long getValue() {
            return this.mInterval;
        }

        public long getDirectNotifyValue() {
            return this.mDirectNotifyInterval;
        }

        public String toString() {
            return this.mName;
        }
    }

    public void setInterval(IntervalMode intervalMode) {
        this.f46071b = intervalMode;
    }

    public IntervalMode getInterval() {
        return this.f46071b;
    }
}
