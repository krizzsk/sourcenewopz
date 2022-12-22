package com.microblink.blinkbarcode.view.recognition;

import com.microblink.blinkbarcode.util.Log;

/* compiled from: line */
public enum DetectionStatus {
    FAIL,
    SUCCESS,
    CAMERA_TOO_HIGH,
    FALLBACK_SUCCESS,
    PARTIAL_OBJECT,
    CAMERA_AT_ANGLE,
    CAMERA_TOO_NEAR,
    DOCUMENT_TOO_CLOSE_TO_EDGE;

    public static DetectionStatus fromNativeDetectionStatus(int i) {
        if (i == 1) {
            return SUCCESS;
        }
        if (i == 2) {
            return FAIL;
        }
        if (i == 4) {
            return CAMERA_TOO_HIGH;
        }
        if (i == 8) {
            return FALLBACK_SUCCESS;
        }
        if (i == 16) {
            return PARTIAL_OBJECT;
        }
        if (i == 32) {
            return CAMERA_AT_ANGLE;
        }
        if (i == 64) {
            return CAMERA_TOO_NEAR;
        }
        Log.m40229e(DetectionStatus.class, "Unknown native detection status {}", Integer.valueOf(i));
        return FAIL;
    }
}
