package com.google.p217ar.core;

import android.hardware.camera2.CameraCaptureSession;

/* renamed from: com.google.ar.core.at */
final /* synthetic */ class C18656at implements Runnable {

    /* renamed from: a */
    private final CameraCaptureSession.StateCallback f53525a;

    /* renamed from: b */
    private final CameraCaptureSession f53526b;

    C18656at(CameraCaptureSession.StateCallback stateCallback, CameraCaptureSession cameraCaptureSession) {
        this.f53525a = stateCallback;
        this.f53526b = cameraCaptureSession;
    }

    public final void run() {
        this.f53525a.onConfigured(this.f53526b);
    }
}
