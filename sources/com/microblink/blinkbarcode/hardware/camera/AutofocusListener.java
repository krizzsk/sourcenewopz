package com.microblink.blinkbarcode.hardware.camera;

import android.graphics.Rect;

/* compiled from: line */
public interface AutofocusListener {
    void onAutofocusFailed();

    void onAutofocusStarted(Rect[] rectArr);

    void onAutofocusStopped(Rect[] rectArr);
}
