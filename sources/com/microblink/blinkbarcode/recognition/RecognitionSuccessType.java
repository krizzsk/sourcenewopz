package com.microblink.blinkbarcode.recognition;

/* compiled from: line */
public enum RecognitionSuccessType {
    UNSUCCESSFUL,
    PARTIAL,
    SUCCESSFUL,
    STAGE_SUCCESSFUL;

    public static RecognitionSuccessType fromNativeRecognitionState(int i) {
        return values()[i];
    }
}
