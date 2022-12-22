package com.didi.mapbizinterface.track;

import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;

public class TrackPointParams {

    /* renamed from: a */
    DIDILocation f29083a;

    public TrackPointParams(DIDILocation dIDILocation) {
        this.f29083a = dIDILocation;
    }

    public static class Builder {
        private DIDILocation location;

        public Builder location(DIDILocation dIDILocation) {
            this.location = dIDILocation;
            return this;
        }

        public TrackPointParams build() {
            return new TrackPointParams(this.location);
        }
    }
}
