package com.didi.hawaii.p118ar.core.p119zg;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.appcompat.app.AppCompatActivity;
import com.didi.common.map.util.DLog;
import com.didi.hawaii.p118ar.utils.PermissionHelper;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.didi.hawaii.ar.core.zg.CameraSurfaceView */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: b */
    private static int f23095b = 90;

    /* renamed from: a */
    private Camera f23096a = null;

    /* renamed from: c */
    private int f23097c = -1;

    /* renamed from: d */
    private int f23098d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AtomicBoolean f23099e = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public AtomicBoolean f23100f = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f23101g = "CameraSurfaceView";

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public CameraSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
        getHolder().setType(3);
        m16591a();
    }

    /* renamed from: a */
    private void m16591a() {
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            Camera.CameraInfo[] cameraInfoArr = new Camera.CameraInfo[numberOfCameras];
            for (int i = 0; i < numberOfCameras; i++) {
                cameraInfoArr[i] = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfoArr[i]);
            }
            for (int i2 = 0; i2 < numberOfCameras; i2++) {
                if (this.f23098d == -1 && cameraInfoArr[i2].facing == 0) {
                    this.f23098d = i2;
                } else if (this.f23097c == -1 && cameraInfoArr[i2].facing == 1) {
                    this.f23097c = i2;
                }
            }
        } catch (Throwable th) {
            String str = this.f23101g;
            DLog.m7384d(str, "initCameraInfo" + th.toString(), new Object[0]);
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private Camera.Size m16589a(int i, List<Camera.Size> list) {
        int width = getWidth();
        int height = getHeight();
        if (i == 90 || i == 270) {
            int i2 = height;
            height = width;
            width = i2;
        }
        for (Camera.Size next : list) {
            if (next.width == width && next.height == height) {
                return next;
            }
        }
        float f = ((float) width) / ((float) height);
        float f2 = Float.MAX_VALUE;
        Camera.Size size = null;
        for (Camera.Size next2 : list) {
            float abs = Math.abs(f - (((float) next2.width) / ((float) next2.height)));
            if (abs < f2) {
                size = next2;
                f2 = abs;
            }
        }
        return size;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m16593b() {
        Camera.Size a;
        AtomicBoolean atomicBoolean = this.f23100f;
        if (atomicBoolean == null || !atomicBoolean.get()) {
            try {
                if (this.f23096a == null && this.f23098d != -1 && getHolder().getSurface() != null) {
                    Camera open = Camera.open(this.f23098d);
                    this.f23096a = open;
                    open.setDisplayOrientation(f23095b);
                    Camera.Parameters parameters = this.f23096a.getParameters();
                    List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                    if (!(supportedPreviewSizes == null || (a = m16589a(f23095b, supportedPreviewSizes)) == null)) {
                        parameters.setPreviewSize(a.width, a.height);
                    }
                    List<String> supportedFocusModes = parameters.getSupportedFocusModes();
                    if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                        parameters.setFocusMode("continuous-video");
                    }
                    this.f23096a.setParameters(parameters);
                    this.f23096a.setPreviewDisplay(getHolder());
                    this.f23096a.startPreview();
                }
            } catch (Throwable th) {
                this.f23099e.set(false);
                String str = this.f23101g;
                DLog.m7384d(str, "openCamera2" + th.toString(), new Object[0]);
                th.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    private void m16595c() {
        try {
            if (this.f23096a != null) {
                this.f23099e.set(false);
                this.f23096a.setPreviewCallback((Camera.PreviewCallback) null);
                this.f23096a.stopPreview();
                this.f23096a.release();
                this.f23096a = null;
            }
        } catch (Throwable th) {
            String str = this.f23101g;
            DLog.m7384d(str, "closeCamera" + th.toString(), new Object[0]);
            th.printStackTrace();
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if ((getContext() instanceof AppCompatActivity) && PermissionHelper.hasCameraPermission((AppCompatActivity) getContext())) {
            openCamera();
        }
    }

    public void openCamera() {
        try {
            if (this.f23096a == null && this.f23099e != null && !this.f23099e.get()) {
                this.f23099e.set(true);
                postDelayed(new Runnable() {
                    public void run() {
                        String a = CameraSurfaceView.this.f23101g;
                        DLog.m7384d(a, "openCameraThread  -->2 + isViewDestroy" + CameraSurfaceView.this.f23100f + "isCameraOpen" + CameraSurfaceView.this.f23099e, new Object[0]);
                        if (CameraSurfaceView.this.f23100f == null || !CameraSurfaceView.this.f23100f.get()) {
                            new Thread(new Runnable() {
                                public void run() {
                                    synchronized (CameraSurfaceView.class) {
                                        CameraSurfaceView.this.m16593b();
                                    }
                                }
                            }).start();
                        }
                    }
                }, 200);
            }
        } catch (Exception unused) {
            this.f23099e.set(false);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        m16595c();
    }

    public void onDestroy() {
        DLog.m7384d(this.f23101g, "onDestroy  -->5", new Object[0]);
        this.f23100f.set(false);
        this.f23099e.set(false);
    }
}
