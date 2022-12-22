package com.google.p217ar.core;

import android.hardware.camera2.CameraCaptureSession;
import android.os.Handler;
import com.google.p217ar.core.SharedCamera;

/* renamed from: com.google.ar.core.ar */
/* compiled from: SharedCamera */
final class C18654ar extends CameraCaptureSession.StateCallback {

    /* renamed from: a */
    private final /* synthetic */ Handler f53520a;

    /* renamed from: b */
    private final /* synthetic */ CameraCaptureSession.StateCallback f53521b;

    /* renamed from: c */
    private final /* synthetic */ SharedCamera f53522c;

    C18654ar(SharedCamera sharedCamera, Handler handler, CameraCaptureSession.StateCallback stateCallback) {
        this.f53522c = sharedCamera;
        this.f53520a = handler;
        this.f53521b = stateCallback;
    }

    public final void onClosed(CameraCaptureSession cameraCaptureSession) {
        this.f53520a.post(new C18653aq(this.f53521b, cameraCaptureSession));
        this.f53522c.onCaptureSessionClosed(cameraCaptureSession);
    }

    public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
        SharedCamera.C18635a unused = this.f53522c.sharedCameraInfo;
        this.f53520a.post(new C18656at(this.f53521b, cameraCaptureSession));
        this.f53522c.onCaptureSessionConfigured(cameraCaptureSession);
        if (this.f53522c.sharedCameraInfo.mo149603a() != null) {
            this.f53522c.setDummyListenerToAvoidImageBufferStarvation();
        }
    }

    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        this.f53520a.post(new C18655as(this.f53521b, cameraCaptureSession));
        this.f53522c.onCaptureSessionConfigureFailed(cameraCaptureSession);
    }

    public final void onReady(CameraCaptureSession cameraCaptureSession) {
        this.f53520a.post(new C18658av(this.f53521b, cameraCaptureSession));
        this.f53522c.onCaptureSessionReady(cameraCaptureSession);
    }

    public final void onActive(CameraCaptureSession cameraCaptureSession) {
        this.f53520a.post(new C18657au(this.f53521b, cameraCaptureSession));
        this.f53522c.onCaptureSessionActive(cameraCaptureSession);
    }
}
