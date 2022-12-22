package com.didichuxing.dfbasesdk.video_capture;

import android.content.Context;
import android.opengl.GLSurfaceView;
import com.didichuxing.dfbasesdk.camera.ICameraInterface;

public class FacePlusRecordVideo implements IRecordVideo {

    /* renamed from: a */
    private final DiFaceVideoCaptureManager f46795a;

    /* renamed from: b */
    private Context f46796b;

    /* renamed from: c */
    private ICameraInterface f46797c;

    public FacePlusRecordVideo(Context context, ICameraInterface iCameraInterface, boolean z, GLSurfaceView gLSurfaceView, float f, int i) {
        this.f46796b = context.getApplicationContext();
        this.f46797c = iCameraInterface;
        this.f46795a = new DiFaceVideoCaptureManager(iCameraInterface.getPreviewWidth(), iCameraInterface.getPreviewHeight(), z, gLSurfaceView, f, i);
    }

    public void start(int i) {
        stop();
        DiFaceVideoCaptureManager diFaceVideoCaptureManager = this.f46795a;
        if (diFaceVideoCaptureManager != null) {
            diFaceVideoCaptureManager.setCameraWidthAndHeight(this.f46797c.getPreviewWidth(), this.f46797c.getPreviewHeight());
            this.f46795a.startRecording(this.f46796b, i);
        }
    }

    public void start(int i, String str) {
        stop();
        DiFaceVideoCaptureManager diFaceVideoCaptureManager = this.f46795a;
        if (diFaceVideoCaptureManager != null) {
            diFaceVideoCaptureManager.setCameraWidthAndHeight(this.f46797c.getPreviewWidth(), this.f46797c.getPreviewHeight());
            this.f46795a.startRecording(this.f46796b, i, str);
        }
    }

    public void stop() {
        DiFaceVideoCaptureManager diFaceVideoCaptureManager = this.f46795a;
        if (diFaceVideoCaptureManager != null && diFaceVideoCaptureManager.isRecording()) {
            this.f46795a.stopRecording();
        }
    }

    public String getVideoPath() {
        DiFaceVideoCaptureManager diFaceVideoCaptureManager = this.f46795a;
        return diFaceVideoCaptureManager != null ? diFaceVideoCaptureManager.getVideoPath() : "";
    }

    public void setErrorListener(IErrorListener iErrorListener) {
        DiFaceVideoCaptureManager diFaceVideoCaptureManager = this.f46795a;
        if (diFaceVideoCaptureManager != null) {
            diFaceVideoCaptureManager.setListener(iErrorListener);
        }
    }

    public void frameAvailable(float[] fArr) {
        DiFaceVideoCaptureManager diFaceVideoCaptureManager = this.f46795a;
        if (diFaceVideoCaptureManager != null) {
            diFaceVideoCaptureManager.frameAvailable(fArr);
        }
    }

    public boolean recording() {
        DiFaceVideoCaptureManager diFaceVideoCaptureManager = this.f46795a;
        if (diFaceVideoCaptureManager != null) {
            return diFaceVideoCaptureManager.isRecording();
        }
        return false;
    }
}
