package com.didi.sdk.push.log;

import com.didi.sdk.push.log.LogEvent;
import java.util.HashMap;
import java.util.Map;

public class PushQualityLogEvent extends LogEvent {
    private long appLiveDuration;
    private long availableRate;
    private long conLiveDuration;

    /* renamed from: ip */
    private String f37085ip;
    private long reconnectDuration;
    private long reconnectTimes;
    private int type;

    public PushQualityLogEvent(Builder builder) {
        this.type = builder.type;
        this.f37085ip = builder.f37086ip;
        this.conLiveDuration = builder.conLiveDuration;
        this.appLiveDuration = builder.appLiveDuration;
        this.availableRate = builder.availableRate;
        this.reconnectTimes = builder.reconnectTimes;
        this.reconnectDuration = builder.reconnectDuration;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(this.type));
        hashMap.put("puship", this.f37085ip);
        hashMap.put("con_live_duration", Long.valueOf(this.conLiveDuration));
        hashMap.put("app_live_duration", Long.valueOf(this.appLiveDuration));
        hashMap.put("available_rate", Long.valueOf(this.availableRate));
        hashMap.put("reconnect_times", Long.valueOf(this.reconnectTimes));
        hashMap.put("reconnect_duration", Long.valueOf(this.reconnectDuration));
        return hashMap;
    }

    public static class Builder implements LogEvent.Builder<PushQualityLogEvent> {
        /* access modifiers changed from: private */
        public long appLiveDuration;
        /* access modifiers changed from: private */
        public long availableRate;
        /* access modifiers changed from: private */
        public long conLiveDuration;
        /* access modifiers changed from: private */

        /* renamed from: ip */
        public String f37086ip;
        /* access modifiers changed from: private */
        public long reconnectDuration;
        /* access modifiers changed from: private */
        public long reconnectTimes;
        /* access modifiers changed from: private */
        public int type;

        public Builder type(int i) {
            this.type = i;
            return this;
        }

        /* renamed from: ip */
        public Builder mo95692ip(String str) {
            this.f37086ip = str;
            return this;
        }

        public Builder conLiveDuration(long j) {
            this.conLiveDuration = j;
            return this;
        }

        public Builder appLiveDuration(long j) {
            this.appLiveDuration = j;
            return this;
        }

        public Builder availableRate(long j) {
            this.availableRate = j;
            return this;
        }

        public Builder reconnectTimes(long j) {
            this.reconnectTimes = j;
            return this;
        }

        public Builder reconnectDuration(long j) {
            this.reconnectDuration = j;
            return this;
        }

        public PushQualityLogEvent build() {
            return new PushQualityLogEvent(this);
        }
    }
}
