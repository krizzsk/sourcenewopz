package com.didichuxing.bigdata.p173dp.locsdk;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.DIDILocationUpdateOption */
public class DIDILocationUpdateOption {
    /* access modifiers changed from: private */
    public static final float DIRECT_NOTIFY_INTERVAL_RATE = ApolloProxy.getInstance().getDirectNotifyIntervalRate();
    private boolean mDirectNotify = false;
    private String mHexModuleKey;
    private IntervalMode mIntervalMode = IntervalMode.NORMAL;
    private String mModuleKey;

    public boolean isDirectNotify() {
        return this.mDirectNotify;
    }

    public void setDirectNotify(boolean z) {
        this.mDirectNotify = z;
        DLog.m32737d("setDirectNotify=" + z + " IntervalMode=" + this.mIntervalMode + " Key=" + this.mModuleKey + ":" + this.mHexModuleKey);
    }

    public String getModuleKey() {
        return this.mModuleKey;
    }

    public String getHexModuleKey() {
        return this.mHexModuleKey;
    }

    public void setModuleKey(String str) {
        this.mModuleKey = str;
        this.mHexModuleKey = str != null ? Integer.toHexString(str.hashCode()) : "null";
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.DIDILocationUpdateOption$IntervalMode */
    public enum IntervalMode {
        SUPER_HIGH_FREQUENCY(200, (long) (DIDILocationUpdateOption.DIRECT_NOTIFY_INTERVAL_RATE * 200.0f)),
        HIGH_FREQUENCY(1000, (long) (DIDILocationUpdateOption.DIRECT_NOTIFY_INTERVAL_RATE * 1000.0f)),
        NORMAL(3000, (long) (DIDILocationUpdateOption.DIRECT_NOTIFY_INTERVAL_RATE * 3000.0f)),
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
        this.mIntervalMode = intervalMode;
    }

    public IntervalMode getInterval() {
        return this.mIntervalMode;
    }
}
