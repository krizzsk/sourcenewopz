package com.google.p217ar.core;

import android.hardware.camera2.CameraCaptureSession;

/* renamed from: com.google.ar.core.av */
final /* synthetic */ class C18658av implements Runnable {

    /* renamed from: a */
    private final CameraCaptureSession.StateCallback f53529a;

    /* renamed from: b */
    private final CameraCaptureSession f53530b;

    C18658av(CameraCaptureSession.StateCallback stateCallback, CameraCaptureSession cameraCaptureSession) {
        this.f53529a = stateCallback;
        this.f53530b = cameraCaptureSession;
    }

    public final void run() {
        this.f53529a.onReady(this.f53530b);
    }
}
