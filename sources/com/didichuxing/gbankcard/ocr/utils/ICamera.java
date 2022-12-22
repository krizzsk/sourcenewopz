package com.didichuxing.gbankcard.ocr.utils;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.ResUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlinx.coroutines.DebugKt;

public class ICamera implements Camera.AutoFocusCallback, Camera.ErrorCallback {

    /* renamed from: i */
    private static final int f47714i = 3;

    /* renamed from: a */
    private volatile boolean f47715a = false;

    /* renamed from: b */
    private Handler f47716b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private WeakReference<ICamera> f47717c;
    public int cameraHeight;
    public int cameraId;
    public int cameraWidth;

    /* renamed from: d */
    private final int f47718d = ResUtils.getScreenWidth();

    /* renamed from: e */
    private final int f47719e = ResUtils.getScreenHeight();

    /* renamed from: f */
    private long f47720f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f47721g;

    /* renamed from: h */
    private int f47722h;
    public boolean hasFocus;

    /* renamed from: j */
    private final Runnable f47723j = new Runnable() {
        public void run() {
            LogUtils.m33563d("reset focusing runnable run...");
            boolean unused = ICamera.this.f47721g = false;
            ICamera.this.m34172c();
        }
    };
    public Camera mCamera;

    public ICamera() {
        LogUtils.m33563d("screen W===" + this.f47718d + ", H=" + this.f47719e);
    }

    public synchronized Camera openCamera(int i) {
        List<String> supportedFocusModes;
        if (this.f47715a) {
            return this.mCamera;
        }
        this.f47717c = new WeakReference<>(this);
        try {
            this.cameraId = i;
            this.mCamera = Camera.open(i);
            this.f47715a = true;
            this.mCamera.setErrorCallback(this);
            Camera.Parameters parameters = this.mCamera.getParameters();
            Camera.Size a = m34166a(parameters, this.f47718d, this.f47719e);
            this.cameraWidth = a.width;
            int i2 = a.height;
            this.cameraHeight = i2;
            parameters.setPreviewSize(this.cameraWidth, i2);
            if (!DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(parameters.getFocusMode()) && (supportedFocusModes = parameters.getSupportedFocusModes()) != null && supportedFocusModes.contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                parameters.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            }
            this.mCamera.setParameters(parameters);
            return this.mCamera;
        } catch (Exception unused) {
            return null;
        }
    }

    public void refocus() {
        if (this.mCamera != null) {
            this.hasFocus = false;
            autoFocus();
        }
    }

    public void autoFocus() {
        LogUtils.m33563d("request focus begin, focusIng===" + this.f47721g);
        if (!this.f47721g) {
            this.f47721g = true;
            this.f47716b.postDelayed(new Runnable() {
                public void run() {
                    if (ICamera.this.m34170b()) {
                        ICamera.this.m34167a();
                    }
                }
            }, 100);
            this.f47716b.postDelayed(this.f47723j, 5000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34167a() {
        if (this.f47722h >= 3) {
            this.f47721g = false;
            this.hasFocus = true;
            return;
        }
        if (this.f47720f == 0) {
            this.f47720f = System.currentTimeMillis();
        }
        LogUtils.m33563d("camera auto focus begin...");
        try {
            if (this.mCamera != null) {
                this.mCamera.autoFocus(this);
            }
        } catch (Exception e) {
            String message = e.getMessage();
            LogUtils.m33565e("auto focus failed, msg===" + message);
            this.f47721g = false;
            this.f47720f = 0;
            this.f47722h = this.f47722h + 1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m34170b() {
        if (((ICamera) this.f47717c.get()) != null) {
            return true;
        }
        LogUtils.m33565e("camera is closed or collect by gc!!!");
        return false;
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        try {
            if (this.mCamera != null) {
                this.mCamera.setPreviewCallback(previewCallback);
            }
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
    }

    public void startPreview(SurfaceTexture surfaceTexture) {
        try {
            if (this.mCamera != null) {
                this.mCamera.setPreviewTexture(surfaceTexture);
                this.mCamera.startPreview();
            }
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
    }

    public synchronized void closeCamera() {
        try {
            if (this.mCamera != null) {
                this.f47717c.clear();
                this.f47715a = false;
                this.hasFocus = false;
                this.mCamera.stopPreview();
                this.mCamera.setPreviewCallback((Camera.PreviewCallback) null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
        return;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.hardware.Camera$Size} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.hardware.Camera.Size m34166a(android.hardware.Camera.Parameters r7, final int r8, final int r9) {
        /*
            r6 = this;
            java.util.List r7 = r7.getSupportedPreviewSizes()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
            r1 = 0
            r2 = r1
        L_0x000f:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L_0x003f
            java.lang.Object r3 = r7.next()
            android.hardware.Camera$Size r3 = (android.hardware.Camera.Size) r3
            int r4 = r3.width
            int r5 = r3.height
            if (r4 <= r5) goto L_0x000f
            r0.add(r3)
            int r4 = r3.width
            r5 = 1280(0x500, float:1.794E-42)
            if (r4 != r5) goto L_0x0031
            int r4 = r3.height
            r5 = 720(0x2d0, float:1.009E-42)
            if (r4 != r5) goto L_0x0031
            r1 = r3
        L_0x0031:
            int r4 = r3.width
            r5 = 1920(0x780, float:2.69E-42)
            if (r4 != r5) goto L_0x000f
            int r4 = r3.height
            r5 = 1080(0x438, float:1.513E-42)
            if (r4 != r5) goto L_0x000f
            r2 = r3
            goto L_0x000f
        L_0x003f:
            if (r1 == 0) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r1 = r2
        L_0x0043:
            if (r1 != 0) goto L_0x0055
            com.didichuxing.gbankcard.ocr.utils.ICamera$3 r7 = new com.didichuxing.gbankcard.ocr.utils.ICamera$3
            r7.<init>(r8, r9)
            java.util.Collections.sort(r0, r7)
            r7 = 0
            java.lang.Object r7 = r0.get(r7)
            r1 = r7
            android.hardware.Camera$Size r1 = (android.hardware.Camera.Size) r1
        L_0x0055:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "use preview size, w===="
            r7.append(r8)
            int r8 = r1.width
            r7.append(r8)
            java.lang.String r8 = ", h="
            r7.append(r8)
            int r8 = r1.height
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.didichuxing.dfbasesdk.utils.LogUtils.m33563d(r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.gbankcard.ocr.utils.ICamera.m34166a(android.hardware.Camera$Parameters, int, int):android.hardware.Camera$Size");
    }

    public void onAutoFocus(boolean z, Camera camera) {
        LogUtils.m33563d("onAutoFocus callback, focus success = " + z);
        this.f47716b.removeCallbacks(this.f47723j);
        this.f47721g = false;
        if (!z) {
            this.f47722h++;
        }
        m34172c();
        this.f47720f = 0;
        this.hasFocus = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m34172c() {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.cancelAutoFocus();
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
            }
        }
    }

    public void onError(int i, Camera camera) {
        LogUtils.m33565e("camera error, error code===" + i);
    }
}
