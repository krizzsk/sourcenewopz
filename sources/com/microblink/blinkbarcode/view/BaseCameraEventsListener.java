package com.microblink.blinkbarcode.view;

import com.microblink.blinkbarcode.hardware.camera.AutofocusListener;

/* compiled from: line */
public interface BaseCameraEventsListener extends AutofocusListener {
    void onCameraPreviewStarted();

    void onCameraPreviewStopped();

    void onError(Throwable th);
}
