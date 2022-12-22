package com.didi.map.sdk.departure.param;

import com.didi.common.map.model.Padding;
import com.didi.map.sdk.departure.IDepartureCompContract;
import com.sdk.poibase.CallFrom;

public class DepartureCompParam {
    public ApiType apiType;
    public int bizId;
    public CallFrom callFrom;
    public long departureTime;
    public boolean isDriverRole;
    public boolean isFenceVisible;
    public boolean isNeedNLP;
    public boolean isPinVisible;
    public boolean isRecPointVisible;
    public IDepartureCompContract.IDepartueCompCallback listener;
    public DepartureLocationInfo locationInfo;
    public Padding padding;
    public String phoneNum;
    public PinStyle pinStyle;
    public RecPointStyle recStyle;
    public boolean requireByDrag = false;
    public int timeOut;
    public String token;
    public String userId;
    public float zoom = -1.0f;

    public DepartureCompParam(Builder builder) {
        this.bizId = builder.bizId;
        this.isDriverRole = builder.isDriverRole;
        this.phoneNum = builder.phoneNum;
        this.token = builder.token;
        this.userId = builder.userId;
        this.listener = builder.listener;
        this.departureTime = builder.departureTime;
        this.locationInfo = builder.locationInfo;
        this.callFrom = builder.callFrom;
        this.recStyle = builder.recStyle;
        this.pinStyle = builder.pinStyle;
        this.isPinVisible = builder.isPinVisible;
        this.isRecPointVisible = builder.isRecPointVisible;
        this.isFenceVisible = builder.isFenceVisible;
        this.zoom = builder.zoom;
        this.padding = builder.padding;
        this.requireByDrag = builder.requireByDrag;
        this.apiType = builder.apiType;
        this.timeOut = builder.timeOut;
        this.isNeedNLP = builder.isNeedNLP;
    }

    public static class Builder {
        public ApiType apiType = ApiType.DEPARTURE_POI_INFO;
        public int bizId;
        public CallFrom callFrom = CallFrom.UNKNOWN;
        public long departureTime;
        public boolean isDriverRole;
        public boolean isFenceVisible;
        public boolean isNeedNLP;
        public boolean isPinVisible;
        public boolean isRecPointVisible;
        public IDepartureCompContract.IDepartueCompCallback listener;
        public DepartureLocationInfo locationInfo;
        public Padding padding;
        public String phoneNum;
        public PinStyle pinStyle;
        public RecPointStyle recStyle;
        public boolean requireByDrag = false;
        public int timeOut;
        public String token;
        public String userId;
        public float zoom = -1.0f;

        public Builder listener(IDepartureCompContract.IDepartueCompCallback iDepartueCompCallback) {
            this.listener = iDepartueCompCallback;
            return this;
        }

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

        public Builder recStyle(RecPointStyle recPointStyle) {
            this.recStyle = recPointStyle;
            return this;
        }

        public Builder pinStyle(PinStyle pinStyle2) {
            this.pinStyle = pinStyle2;
            return this;
        }

        public Builder isPinVisible(boolean z) {
            this.isPinVisible = z;
            return this;
        }

        public Builder isRecPointVisible(boolean z) {
            this.isRecPointVisible = z;
            return this;
        }

        public Builder isFenceVisible(boolean z) {
            this.isFenceVisible = z;
            return this;
        }

        public Builder padding(Padding padding2) {
            this.padding = padding2;
            return this;
        }

        public Builder zoom(float f) {
            this.zoom = f;
            return this;
        }

        public Builder requireByDrag(boolean z) {
            this.requireByDrag = z;
            return this;
        }

        public Builder bizId(int i) {
            this.bizId = i;
            return this;
        }

        public Builder isDriverRole(boolean z) {
            this.isDriverRole = z;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder phoneNum(String str) {
            this.phoneNum = str;
            return this;
        }

        public Builder userId(String str) {
            this.userId = str;
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

        public DepartureCompParam build() {
            return new DepartureCompParam(this);
        }
    }

    public String toString() {
        return "DepartureCoreParam{departureTime=" + this.departureTime + ", locationInfo=" + this.locationInfo + ", callFrom=" + this.callFrom + ", listener=" + this.listener + ", recStyle=" + this.recStyle + ", pinStyle=" + this.pinStyle + ", isPinVisible=" + this.isPinVisible + ", isRecPointVisible=" + this.isRecPointVisible + ", isFenceVisible=" + this.isFenceVisible + ", padding=" + this.padding + ", zoom=" + this.zoom + ", requireByDrag=" + this.requireByDrag + ", timeOut=" + this.timeOut + ", isNeedNLP=" + this.isNeedNLP + '}';
    }
}
