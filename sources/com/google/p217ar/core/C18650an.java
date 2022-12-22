package com.google.p217ar.core;

import android.hardware.camera2.CameraDevice;

/* renamed from: com.google.ar.core.an */
final /* synthetic */ class C18650an implements Runnable {

    /* renamed from: a */
    private final CameraDevice.StateCallback f53511a;

    /* renamed from: b */
    private final CameraDevice f53512b;

    C18650an(CameraDevice.StateCallback stateCallback, CameraDevice cameraDevice) {
        this.f53511a = stateCallback;
        this.f53512b = cameraDevice;
    }

    public final void run() {
        this.f53511a.onClosed(this.f53512b);
    }
}
