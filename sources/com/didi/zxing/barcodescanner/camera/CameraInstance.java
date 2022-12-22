package com.didi.zxing.barcodescanner.camera;

import android.content.Context;
import android.os.Handler;
import android.view.SurfaceHolder;
import com.didi.sdk.apm.SystemUtils;
import com.didi.zxing.barcodescanner.C14921Util;
import com.didi.zxing.barcodescanner.Size;
import com.didi.zxing.barcodescanner.camera.CameraManager;
import com.taxis99.R;

public class CameraInstance {

    /* renamed from: a */
    private static final String f45341a = "CameraInstance";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C14946a f45342b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CameraSurface f45343c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CameraManager f45344d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Handler f45345e;

    /* renamed from: f */
    private DisplayConfiguration f45346f;

    /* renamed from: g */
    private boolean f45347g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f45348h = true;

    /* renamed from: i */
    private CameraSettings f45349i = new CameraSettings();

    /* renamed from: j */
    private Runnable f45350j = new Runnable() {
        public void run() {
            try {
                SystemUtils.log(3, CameraInstance.f45341a, "Opening camera", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraInstance$4", 212);
                CameraInstance.this.f45344d.open();
            } catch (Exception e) {
                Exception exc = e;
                CameraInstance.this.m32565a(exc);
                SystemUtils.log(6, CameraInstance.f45341a, "Failed to open camera", exc, "com.didi.zxing.barcodescanner.camera.CameraInstance$4", 216);
            }
        }
    };

    /* renamed from: k */
    private Runnable f45351k = new Runnable() {
        public void run() {
            try {
                SystemUtils.log(3, CameraInstance.f45341a, "Configuring camera", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraInstance$5", 225);
                CameraInstance.this.f45344d.configure();
                if (CameraInstance.this.f45345e != null) {
                    CameraInstance.this.f45345e.obtainMessage(R.id.zxing_prewiew_size_ready, CameraInstance.this.m32562a()).sendToTarget();
                }
            } catch (Exception e) {
                Exception exc = e;
                CameraInstance.this.m32565a(exc);
                SystemUtils.log(6, CameraInstance.f45341a, "Failed to configure camera", exc, "com.didi.zxing.barcodescanner.camera.CameraInstance$5", 232);
            }
        }
    };

    /* renamed from: l */
    private Runnable f45352l = new Runnable() {
        public void run() {
            try {
                SystemUtils.log(3, CameraInstance.f45341a, "Starting preview", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraInstance$6", 241);
                CameraInstance.this.f45344d.setPreviewDisplay(CameraInstance.this.f45343c);
                CameraInstance.this.f45344d.startPreview();
            } catch (Exception e) {
                Exception exc = e;
                CameraInstance.this.m32565a(exc);
                exc.printStackTrace();
                SystemUtils.log(6, CameraInstance.f45341a, "Failed to start preview", exc, "com.didi.zxing.barcodescanner.camera.CameraInstance$6", 247);
            }
        }
    };

    /* renamed from: m */
    private Runnable f45353m = new Runnable() {
        public void run() {
            try {
                SystemUtils.log(3, CameraInstance.f45341a, "Closing camera", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraInstance$7", 256);
                CameraInstance.this.f45344d.stopPreview();
                CameraInstance.this.f45344d.close();
            } catch (Exception e) {
                SystemUtils.log(6, CameraInstance.f45341a, "Failed to close camera", e, "com.didi.zxing.barcodescanner.camera.CameraInstance$7", 260);
            }
            boolean unused = CameraInstance.this.f45348h = true;
            if (CameraInstance.this.f45345e != null) {
                CameraInstance.this.f45345e.sendEmptyMessage(R.id.zxing_camera_closed);
            }
            CameraInstance.this.f45342b.mo113754b();
        }
    };

    /* renamed from: n */
    private Runnable f45354n = new Runnable() {
        public void run() {
            try {
                SystemUtils.log(3, CameraInstance.f45341a, "Closing camera", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraInstance$8", 275);
                CameraInstance.this.f45344d.stopPreview();
            } catch (Exception e) {
                SystemUtils.log(6, CameraInstance.f45341a, "Failed to close camera", e, "com.didi.zxing.barcodescanner.camera.CameraInstance$8", 278);
            }
        }
    };

    public CameraInstance(Context context) {
        C14921Util.validateMainThread();
        this.f45342b = C14946a.m32580a();
        CameraManager cameraManager = new CameraManager(context);
        this.f45344d = cameraManager;
        cameraManager.setCameraSettings(this.f45349i);
    }

    public CameraInstance(CameraManager cameraManager) {
        C14921Util.validateMainThread();
        this.f45344d = cameraManager;
    }

    public void setDisplayConfiguration(DisplayConfiguration displayConfiguration) {
        this.f45346f = displayConfiguration;
        this.f45344d.setDisplayConfiguration(displayConfiguration);
    }

    public DisplayConfiguration getDisplayConfiguration() {
        return this.f45346f;
    }

    public void setReadyHandler(Handler handler) {
        this.f45345e = handler;
    }

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        setSurface(new CameraSurface(surfaceHolder));
    }

    public void setSurface(CameraSurface cameraSurface) {
        this.f45343c = cameraSurface;
    }

    public CameraSettings getCameraSettings() {
        return this.f45349i;
    }

    public void setCameraSettings(CameraSettings cameraSettings) {
        if (!this.f45347g) {
            this.f45349i = cameraSettings;
            this.f45344d.setCameraSettings(cameraSettings);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Size m32562a() {
        return this.f45344d.getPreviewSize();
    }

    public int getCameraRotation() {
        return this.f45344d.getCameraRotation();
    }

    public void open() {
        C14921Util.validateMainThread();
        this.f45347g = true;
        this.f45348h = false;
        this.f45342b.mo113755b(this.f45350j);
    }

    public void configureCamera() {
        C14921Util.validateMainThread();
        m32568b();
        this.f45342b.mo113752a(this.f45351k);
    }

    public void startPreview() {
        C14921Util.validateMainThread();
        m32568b();
        this.f45342b.mo113752a(this.f45352l);
    }

    public void setTorchListener(CameraManager.TorchListener torchListener) {
        this.f45344d.setTorchListener(torchListener);
    }

    public void setTorch(final boolean z) {
        C14921Util.validateMainThread();
        if (this.f45347g) {
            this.f45342b.mo113752a(new Runnable() {
                public void run() {
                    CameraInstance.this.f45344d.setTorch(z);
                }
            });
        }
    }

    public void close() {
        C14921Util.validateMainThread();
        if (this.f45347g) {
            this.f45342b.mo113752a(this.f45353m);
        } else {
            this.f45348h = true;
        }
        this.f45347g = false;
    }

    public void stopPreview() {
        C14921Util.validateMainThread();
        if (this.f45347g) {
            this.f45342b.mo113752a(this.f45354n);
        } else {
            this.f45348h = true;
        }
    }

    public boolean isOpen() {
        return this.f45347g;
    }

    public boolean isCameraClosed() {
        return this.f45348h;
    }

    public void requestPreview(final PreviewCallback previewCallback) {
        m32568b();
        this.f45342b.mo113752a(new Runnable() {
            public void run() {
                CameraInstance.this.f45344d.requestPreviewFrame(previewCallback);
            }
        });
    }

    public void removePreviewCallBack() {
        this.f45342b.mo113752a(new Runnable() {
            public void run() {
                CameraInstance.this.f45344d.removePreviewCallBack();
            }
        });
    }

    /* renamed from: b */
    private void m32568b() {
        if (!this.f45347g) {
            SystemUtils.log(6, f45341a, "camera not open", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraInstance", 203);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32565a(Exception exc) {
        Handler handler = this.f45345e;
        if (handler != null) {
            handler.obtainMessage(R.id.zxing_camera_error, exc).sendToTarget();
        }
    }

    public CameraManager getCameraManager() {
        return this.f45344d;
    }

    /* access modifiers changed from: protected */
    public C14946a getCameraThread() {
        return this.f45342b;
    }

    /* access modifiers changed from: protected */
    public CameraSurface getSurface() {
        return this.f45343c;
    }
}
