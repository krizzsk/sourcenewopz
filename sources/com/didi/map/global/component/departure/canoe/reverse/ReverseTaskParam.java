package com.didi.map.global.component.departure.canoe.reverse;

import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.sdk.poibase.CallFrom;

public class ReverseTaskParam {

    /* renamed from: a */
    private int f24980a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CallFrom f24981b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DepartureLocationInfo f24982c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f24983d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f24984e;

    /* renamed from: f */
    private ReverseTaskCallback f24985f;

    private ReverseTaskParam(int i, ReverseTaskCallback reverseTaskCallback) {
        this.f24980a = i;
        this.f24985f = reverseTaskCallback;
    }

    public int getId() {
        return this.f24980a;
    }

    public CallFrom getReqCallerId() {
        return this.f24981b;
    }

    public DepartureLocationInfo getLocationInfo() {
        return this.f24982c;
    }

    public String getMapType() {
        return this.f24983d;
    }

    public String getUserOperationType() {
        return this.f24984e;
    }

    public ReverseTaskCallback getTaskCallback() {
        return this.f24985f;
    }

    public static class Builder {
        private ReverseTaskParam dataTaskParam;

        public Builder(int i, ReverseTaskCallback reverseTaskCallback) {
            this.dataTaskParam = new ReverseTaskParam(i, reverseTaskCallback);
        }

        public Builder reqCallerId(CallFrom callFrom) {
            CallFrom unused = this.dataTaskParam.f24981b = callFrom;
            return this;
        }

        public Builder locationInfo(DepartureLocationInfo departureLocationInfo) {
            DepartureLocationInfo unused = this.dataTaskParam.f24982c = departureLocationInfo;
            return this;
        }

        public Builder mapType(String str) {
            String unused = this.dataTaskParam.f24983d = str;
            return this;
        }

        public Builder userOperationType(String str) {
            String unused = this.dataTaskParam.f24984e = str;
            return this;
        }

        public ReverseTaskParam build() {
            return this.dataTaskParam;
        }
    }
}
