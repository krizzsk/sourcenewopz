package com.google.p217ar.core;

import android.hardware.camera2.CameraDevice;
import android.os.Handler;

/* renamed from: com.google.ar.core.ak */
/* compiled from: SharedCamera */
final class C18647ak extends CameraDevice.StateCallback {

    /* renamed from: a */
    private final /* synthetic */ Handler f53505a;

    /* renamed from: b */
    private final /* synthetic */ CameraDevice.StateCallback f53506b;

    /* renamed from: c */
    private final /* synthetic */ SharedCamera f53507c;

    C18647ak(SharedCamera sharedCamera, Handler handler, CameraDevice.StateCallback stateCallback) {
        this.f53507c = sharedCamera;
        this.f53505a = handler;
        this.f53506b = stateCallback;
    }

    public final void onClosed(CameraDevice cameraDevice) {
        this.f53505a.post(new C18650an(this.f53506b, cameraDevice));
        this.f53507c.onDeviceClosed(cameraDevice);
    }

    public final void onOpened(CameraDevice cameraDevice) {
        this.f53507c.sharedCameraInfo.mo149605a(cameraDevice);
        this.f53505a.post(new C18649am(this.f53506b, cameraDevice));
        this.f53507c.onDeviceOpened(cameraDevice);
        this.f53507c.sharedCameraInfo.mo149604a(this.f53507c.getGpuSurfaceTexture());
        this.f53507c.sharedCameraInfo.mo149606a(this.f53507c.getGpuSurface());
    }

    public final void onDisconnected(CameraDevice cameraDevice) {
        this.f53505a.post(new C18652ap(this.f53506b, cameraDevice));
        this.f53507c.onDeviceDisconnected(cameraDevice);
    }

    public final void onError(CameraDevice cameraDevice, int i) {
        this.f53505a.post(new C18651ao(this.f53506b, cameraDevice, i));
        this.f53507c.close();
    }
}
