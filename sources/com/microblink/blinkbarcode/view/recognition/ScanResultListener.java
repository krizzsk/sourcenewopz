package com.microblink.blinkbarcode.view.recognition;

import com.microblink.blinkbarcode.recognition.RecognitionSuccessType;

/* compiled from: line */
public interface ScanResultListener {
    void onScanningDone(RecognitionSuccessType recognitionSuccessType);

    void onUnrecoverableError(Throwable th);
}
