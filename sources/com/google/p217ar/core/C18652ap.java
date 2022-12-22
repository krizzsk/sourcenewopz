package com.google.p217ar.core;

import android.hardware.camera2.CameraDevice;

/* renamed from: com.google.ar.core.ap */
final /* synthetic */ class C18652ap implements Runnable {

    /* renamed from: a */
    private final CameraDevice.StateCallback f53516a;

    /* renamed from: b */
    private final CameraDevice f53517b;

    C18652ap(CameraDevice.StateCallback stateCallback, CameraDevice cameraDevice) {
        this.f53516a = stateCallback;
        this.f53517b = cameraDevice;
    }

    public final void run() {
        this.f53516a.onDisconnected(this.f53517b);
    }
}
