package com.didi.global.map.animation.transition;

import com.didi.common.map.model.LatLng;

public class SodaAnimLatLng {
    public float angle;
    public LatLng latLng;
    public long timestamp;

    public SodaAnimLatLng(LatLng latLng2, long j, float f) {
        this.latLng = latLng2;
        this.timestamp = j;
        this.angle = f;
    }

    public String toString() {
        return "SodaLatLng{latLng=" + this.latLng + ", timestamp=" + this.timestamp + ", angle=" + this.angle + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SodaAnimLatLng sodaAnimLatLng = (SodaAnimLatLng) obj;
        if (this.timestamp != sodaAnimLatLng.timestamp) {
            return false;
        }
        LatLng latLng2 = this.latLng;
        LatLng latLng3 = sodaAnimLatLng.latLng;
        if (latLng2 != null) {
            return latLng2.equals(latLng3);
        }
        if (latLng3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        LatLng latLng2 = this.latLng;
        int hashCode = latLng2 != null ? latLng2.hashCode() : 0;
        long j = this.timestamp;
        return (hashCode * 31) + ((int) (j ^ (j >>> 32)));
    }
}
