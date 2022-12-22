package com.didi.sdk.push.log;

import com.didi.sdk.push.log.ConnEvent;
import com.facebook.appevents.UserDataStore;
import java.util.HashMap;
import java.util.Map;

public class ExtendConnEvent extends ConnEvent {
    private long appStartDuration;
    private long connectDuration;
    private long failedTimes;
    private long lastFailDuration;
    private long maintainDuration;
    private int tls;
    private int type;

    public ExtendConnEvent(Builder builder) {
        this.errorCode = builder.errorCode;
        this.subCode = builder.subCode;
        this.type = builder.type;
        this.tls = builder.tls;
        this.connectDuration = builder.connectDuration;
        this.appStartDuration = builder.appStartDuration;
        this.failedTimes = builder.failedTimes;
        this.maintainDuration = builder.maintainDuration;
        this.lastFailDuration = builder.lastFailDuration;
    }

    public int getType() {
        return this.type;
    }

    public int getTls() {
        return this.tls;
    }

    public long getConnectDuration() {
        return this.connectDuration;
    }

    public long getAppStartDuration() {
        return this.appStartDuration;
    }

    public long getFailedTimes() {
        return this.failedTimes;
    }

    public long getMaintainDuration() {
        return this.maintainDuration;
    }

    public long getLastFailDuration() {
        return this.lastFailDuration;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(this.type));
        hashMap.put("tls", Integer.valueOf(this.tls));
        hashMap.put("ec", Integer.valueOf(this.errorCode));
        hashMap.put("sub_code", Integer.valueOf(this.subCode));
        hashMap.put(UserDataStore.CITY, Long.valueOf(this.connectDuration));
        hashMap.put("fct", Long.valueOf(this.appStartDuration));
        hashMap.put("cfc", Long.valueOf(this.failedTimes));
        hashMap.put("mt", Long.valueOf(this.maintainDuration));
        hashMap.put("lfd", Long.valueOf(this.lastFailDuration));
        return hashMap;
    }

    public static final class Builder extends ConnEvent.Builder {
        /* access modifiers changed from: private */
        public long appStartDuration;
        /* access modifiers changed from: private */
        public long connectDuration;
        /* access modifiers changed from: private */
        public long failedTimes;
        /* access modifiers changed from: private */
        public long lastFailDuration;
        /* access modifiers changed from: private */
        public long maintainDuration;
        /* access modifiers changed from: private */
        public int tls;
        /* access modifiers changed from: private */
        public int type;

        public Builder errorCode(int i) {
            this.errorCode = i;
            return this;
        }

        public Builder subCode(int i) {
            this.subCode = i;
            return this;
        }

        public Builder type(int i) {
            this.type = i;
            return this;
        }

        public Builder tls(int i) {
            this.tls = i;
            return this;
        }

        public Builder connectDuration(long j) {
            this.connectDuration = j;
            return this;
        }

        public Builder appStartDuration(long j) {
            this.appStartDuration = j;
            return this;
        }

        public Builder failedTimes(long j) {
            this.failedTimes = j;
            return this;
        }

        public Builder maintainDuration(long j) {
            this.maintainDuration = j;
            return this;
        }

        public Builder lastFailDuration(long j) {
            this.lastFailDuration = j;
            return this;
        }

        public ExtendConnEvent build() {
            return new ExtendConnEvent(this);
        }
    }
}
