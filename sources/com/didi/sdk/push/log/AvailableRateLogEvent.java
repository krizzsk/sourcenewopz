package com.didi.sdk.push.log;

import com.didi.sdk.push.log.LogEvent;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import java.util.HashMap;
import java.util.Map;

public class AvailableRateLogEvent extends LogEvent {
    private long availableRate;
    private long availableTime;
    private long connectSuccess;
    private long connectTotal;
    private long sleepTimes;
    private long totalSleepDuration;
    private long totalTime;

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("con_total", Long.valueOf(this.connectTotal));
        hashMap.put("con_suc", Long.valueOf(this.connectSuccess));
        hashMap.put("sleep_duration", Long.valueOf(this.totalSleepDuration));
        hashMap.put("sleep_times", Long.valueOf(this.sleepTimes));
        hashMap.put("avb_rate", Long.valueOf(this.availableRate));
        hashMap.put(ParamConst.PARAM_PERFORMANCE_TOTAL_TIME, Long.valueOf(this.totalTime));
        hashMap.put("avb_time", Long.valueOf(this.availableTime));
        return hashMap;
    }

    public AvailableRateLogEvent(Builder builder) {
        this.availableTime = builder.availableTime;
        this.totalTime = builder.totalTime;
        this.availableRate = builder.availableRate;
        this.sleepTimes = builder.sleepTimes;
        this.totalSleepDuration = builder.totalSleepDuration;
        this.connectSuccess = builder.connectSuccess;
        this.connectTotal = builder.connectTotal;
    }

    public static class Builder implements LogEvent.Builder<AvailableRateLogEvent> {
        /* access modifiers changed from: private */
        public long availableRate;
        /* access modifiers changed from: private */
        public long availableTime;
        /* access modifiers changed from: private */
        public long connectSuccess;
        /* access modifiers changed from: private */
        public long connectTotal;
        /* access modifiers changed from: private */
        public long sleepTimes;
        /* access modifiers changed from: private */
        public long totalSleepDuration;
        /* access modifiers changed from: private */
        public long totalTime;

        public Builder availableTime(long j) {
            this.availableTime = j;
            return this;
        }

        public Builder totalTime(long j) {
            this.totalTime = j;
            return this;
        }

        public Builder availableRate(long j) {
            this.availableRate = j;
            return this;
        }

        public Builder sleepTimes(long j) {
            this.sleepTimes = j;
            return this;
        }

        public Builder totalSleepDuration(long j) {
            this.totalSleepDuration = j;
            return this;
        }

        public Builder connectSuccess(long j) {
            this.connectSuccess = j;
            return this;
        }

        public Builder connectTotal(long j) {
            this.connectTotal = j;
            return this;
        }

        public AvailableRateLogEvent build() {
            return new AvailableRateLogEvent(this);
        }
    }
}
