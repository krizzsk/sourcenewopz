package com.google.p217ar.core;

import com.google.p217ar.core.exceptions.FatalException;

/* renamed from: com.google.ar.core.TrackingFailureReason */
public enum TrackingFailureReason {
    NONE(0),
    BAD_STATE(1),
    INSUFFICIENT_LIGHT(2),
    EXCESSIVE_MOTION(3),
    INSUFFICIENT_FEATURES(4);
    
    final int nativeCode;

    private TrackingFailureReason(int i) {
        this.nativeCode = i;
    }

    static TrackingFailureReason forNumber(int i) {
        for (TrackingFailureReason trackingFailureReason : values()) {
            if (trackingFailureReason.nativeCode == i) {
                return trackingFailureReason;
            }
        }
        StringBuilder sb = new StringBuilder(68);
        sb.append("Unexpected value for native TrackingFailureReason, value=");
        sb.append(i);
        throw new FatalException(sb.toString());
    }
}
