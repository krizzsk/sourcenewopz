package com.google.p217ar.core;

import android.hardware.camera2.CameraDevice;

/* renamed from: com.google.ar.core.am */
final /* synthetic */ class C18649am implements Runnable {

    /* renamed from: a */
    private final CameraDevice.StateCallback f53509a;

    /* renamed from: b */
    private final CameraDevice f53510b;

    C18649am(CameraDevice.StateCallback stateCallback, CameraDevice cameraDevice) {
        this.f53509a = stateCallback;
        this.f53510b = cameraDevice;
    }

    public final void run() {
        this.f53509a.onOpened(this.f53510b);
    }
}
