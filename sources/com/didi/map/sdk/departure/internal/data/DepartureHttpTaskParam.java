package com.didi.map.sdk.departure.internal.data;

import com.didi.map.sdk.departure.param.ApiType;
import com.didi.map.sdk.departure.param.DepartureLocationInfo;
import com.sdk.poibase.CallFrom;

public class DepartureHttpTaskParam {
    public int IsAutoCall;
    public ApiType apiType;
    public CallFrom callFrom;
    public long departureTime;
    public boolean isNeedFence;
    public boolean isNeedNLP;
    public OnDepartureHttpTaskListener listener;
    public DepartureLocationInfo locationInfo;
    public int operationType;
    public int taskID;
    public int timeOut;

    private DepartureHttpTaskParam(Builder builder) {
        this.callFrom = CallFrom.UNKNOWN;
        this.departureTime = builder.departureTime;
        this.locationInfo = builder.locationInfo;
        this.callFrom = builder.callFrom;
        this.isNeedFence = builder.isNeedFence;
        this.listener = builder.listener;
        this.IsAutoCall = builder.IsAutoCall;
        this.taskID = builder.taskID;
        this.operationType = builder.operationType;
        this.apiType = builder.apiType;
        this.timeOut = builder.timeOut;
        this.isNeedNLP = builder.isNeedNLP;
    }

    public static class Builder {
        public int IsAutoCall;
        public ApiType apiType;
        public CallFrom callFrom = CallFrom.UNKNOWN;
        public long departureTime;
        public boolean isFirstLaunch;
        public boolean isNeedFence;
        public boolean isNeedNLP;
        public OnDepartureHttpTaskListener listener;
        public DepartureLocationInfo locationInfo;
        public int operationType;
        public int taskID;
        public int timeOut;

        public Builder departureTime(long j) {
            this.departureTime = j;
            return this;
        }

        public Builder locationInfo(DepartureLocationInfo departureLocationInfo) {
            this.locationInfo = departureLocationInfo;
            return this;
        }

        public Builder callFrom(CallFrom callFrom2) {
            this.callFrom = callFrom2;
            return this;
        }

        public Builder isNeedFence(boolean z) {
            this.isNeedFence = z;
            return this;
        }

        public Builder listener(OnDepartureHttpTaskListener onDepartureHttpTaskListener) {
            this.listener = onDepartureHttpTaskListener;
            return this;
        }

        public Builder IsAutoCall(int i) {
            this.IsAutoCall = i;
            return this;
        }

        public Builder taskID(int i) {
            this.taskID = i;
            return this;
        }

        public Builder operationType(int i) {
            this.operationType = i;
            return this;
        }

        public Builder apiType(ApiType apiType2) {
            this.apiType = apiType2;
            return this;
        }

        public Builder timeOut(int i) {
            this.timeOut = i;
            return this;
        }

        public Builder isNeedNLP(boolean z) {
            this.isNeedNLP = z;
            return this;
        }

        public DepartureHttpTaskParam build() {
            return new DepartureHttpTaskParam(this);
        }
    }
}
