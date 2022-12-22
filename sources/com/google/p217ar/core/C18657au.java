package com.google.p217ar.core;

import android.hardware.camera2.CameraCaptureSession;

/* renamed from: com.google.ar.core.au */
final /* synthetic */ class C18657au implements Runnable {

    /* renamed from: a */
    private final CameraCaptureSession.StateCallback f53527a;

    /* renamed from: b */
    private final CameraCaptureSession f53528b;

    C18657au(CameraCaptureSession.StateCallback stateCallback, CameraCaptureSession cameraCaptureSession) {
        this.f53527a = stateCallback;
        this.f53528b = cameraCaptureSession;
    }

    public final void run() {
        this.f53527a.onActive(this.f53528b);
    }
}
