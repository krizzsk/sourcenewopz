package com.didi.map.global.component.departure.data;

import com.didi.map.global.component.departure.model.ApiType;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.sdk.address.address.entity.Address;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.sdk.poibase.CallFrom;

public class DepartureHttpTaskParam {
    public int IsAutoCall;

    /* renamed from: a */
    private int f25052a;
    public ApiType apiType;

    /* renamed from: b */
    private boolean f25053b;

    /* renamed from: c */
    private Address f25054c;
    public long departureTime;
    public boolean isNeedCache;
    public boolean isNeedFence;
    public OnDepartureHttpTaskListener listener;
    public DepartureLocationInfo locationInfo;
    public int operationType;
    public CallFrom reqCallerId;
    public int taskID;

    public Address getDestInfo() {
        return this.f25054c;
    }

    public int getTimeOut() {
        return this.f25052a;
    }

    public boolean isNeedNLP() {
        return this.f25053b;
    }

    private DepartureHttpTaskParam(Builder builder) {
        this.departureTime = builder.departureTime;
        this.locationInfo = builder.locationInfo;
        this.reqCallerId = builder.reqCallerId;
        this.isNeedFence = builder.isNeedFence;
        this.listener = builder.listener;
        this.IsAutoCall = builder.IsAutoCall;
        this.taskID = builder.taskID;
        this.operationType = builder.operationType;
        this.apiType = builder.apiType;
        this.isNeedCache = builder.isNeedCache;
        this.f25053b = builder.isNeedNLP;
        this.f25052a = builder.timeOut;
        this.f25054c = builder.destInfo;
    }

    public static class Builder {
        int IsAutoCall;
        ApiType apiType;
        DIDILocation currentLocation;
        long departureTime;
        Address destInfo;
        boolean isNeedCache;
        boolean isNeedFence;
        boolean isNeedNLP;
        OnDepartureHttpTaskListener listener;
        DepartureLocationInfo locationInfo;
        public int locationType;
        int operationType;
        CallFrom reqCallerId;
        int taskID;
        int timeOut;

        public Builder departureTime(long j) {
            this.departureTime = j;
            return this;
        }

        public Builder setTimeOut(int i) {
            this.timeOut = i;
            return this;
        }

        public Builder setIsNeedNLP(boolean z) {
            this.isNeedNLP = z;
            return this;
        }

        public Builder locationInfo(DepartureLocationInfo departureLocationInfo) {
            this.locationInfo = departureLocationInfo;
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

        public Builder isAutoCall(int i) {
            this.IsAutoCall = i;
            return this;
        }

        public Builder reqCallerId(CallFrom callFrom) {
            this.reqCallerId = callFrom;
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

        public Builder cacheEnable(boolean z) {
            this.isNeedCache = z;
            return this;
        }

        public Builder destInfo(Address address) {
            this.destInfo = address;
            return this;
        }

        public DepartureHttpTaskParam build() {
            return new DepartureHttpTaskParam(this);
        }
    }
}
