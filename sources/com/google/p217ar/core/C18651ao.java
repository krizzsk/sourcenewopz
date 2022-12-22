package com.google.p217ar.core;

import android.hardware.camera2.CameraDevice;

/* renamed from: com.google.ar.core.ao */
final /* synthetic */ class C18651ao implements Runnable {

    /* renamed from: a */
    private final CameraDevice.StateCallback f53513a;

    /* renamed from: b */
    private final CameraDevice f53514b;

    /* renamed from: c */
    private final int f53515c;

    C18651ao(CameraDevice.StateCallback stateCallback, CameraDevice cameraDevice, int i) {
        this.f53513a = stateCallback;
        this.f53514b = cameraDevice;
        this.f53515c = i;
    }

    public final void run() {
        this.f53513a.onError(this.f53514b, this.f53515c);
    }
}
