package com.didi.map.sdk.passengerlocation;

import com.didi.common.map.model.LatLng;
import java.util.List;

public class PassengerLocationParam {
    public onPsgLocationListener listener;
    public int locationAccuracy;
    public List<PassengerInfo> passengerInfoList;
    public LatLng startPoint;
    public String travelId;

    public PassengerLocationParam(Builder builder) {
        this.startPoint = builder.startPoint;
        this.listener = builder.listener;
        this.passengerInfoList = builder.passengerInfoList;
        this.locationAccuracy = builder.locationAccuracy;
        this.travelId = builder.travelId;
    }

    public static class Builder {
        public onPsgLocationListener listener;
        public int locationAccuracy;
        public List<PassengerInfo> passengerInfoList;
        public LatLng startPoint;
        public String travelId;

        public Builder startPoint(LatLng latLng) {
            this.startPoint = latLng;
            return this;
        }

        public Builder listener(onPsgLocationListener onpsglocationlistener) {
            this.listener = onpsglocationlistener;
            return this;
        }

        public Builder passengerInfoList(List<PassengerInfo> list) {
            this.passengerInfoList = list;
            return this;
        }

        public Builder locationAccuracy(int i) {
            this.locationAccuracy = i;
            return this;
        }

        public Builder travelId(String str) {
            this.travelId = str;
            return this;
        }

        public PassengerLocationParam build() {
            return new PassengerLocationParam(this);
        }
    }
}
