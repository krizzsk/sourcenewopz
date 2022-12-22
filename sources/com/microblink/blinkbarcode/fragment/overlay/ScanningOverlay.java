package com.microblink.blinkbarcode.fragment.overlay;

import android.app.Activity;
import com.microblink.blinkbarcode.fragment.RecognizerRunnerFragment;
import com.microblink.blinkbarcode.recognition.RecognitionSuccessType;
import com.microblink.blinkbarcode.view.recognition.ScanResultListener;

/* compiled from: line */
public interface ScanningOverlay extends ScanResultListener {
    void onFrameRecognitionDone(RecognitionSuccessType recognitionSuccessType);

    void onRecognizerRunnerFragmentAttached(RecognizerRunnerFragment recognizerRunnerFragment, Activity activity);

    void onRecognizerRunnerViewCreated(RecognizerRunnerFragment recognizerRunnerFragment);

    void pauseScanning();

    void resumeScanning();
}
