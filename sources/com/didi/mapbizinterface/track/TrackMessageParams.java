package com.didi.mapbizinterface.track;

import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;

public class TrackMessageParams {

    /* renamed from: a */
    String f29079a;

    /* renamed from: b */
    String f29080b;

    /* renamed from: c */
    DIDILocation f29081c;

    /* renamed from: d */
    Integer f29082d;

    public TrackMessageParams(String str, String str2, DIDILocation dIDILocation) {
        this.f29079a = str;
        this.f29080b = str2;
        this.f29081c = dIDILocation;
    }

    private TrackMessageParams(String str, String str2, DIDILocation dIDILocation, Integer num) {
        this.f29079a = str;
        this.f29080b = str2;
        this.f29081c = dIDILocation;
        this.f29082d = num;
    }

    public static class Builder {
        private DIDILocation location;
        private String orderId;
        private String phone;
        private Integer trackSdkFlag;

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder location(DIDILocation dIDILocation) {
            this.location = dIDILocation;
            return this;
        }

        public Builder trackSdkFlag(Integer num) {
            this.trackSdkFlag = num;
            return this;
        }

        public TrackMessageParams build() {
            return new TrackMessageParams(this.phone, this.orderId, this.location, this.trackSdkFlag);
        }
    }
}
