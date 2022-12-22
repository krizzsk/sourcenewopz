package com.didi.zxing.barcodescanner.camera;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.view.SurfaceHolder;
import com.didi.sdk.apm.SystemUtils;
import com.didi.zxing.barcodescanner.Size;
import com.didi.zxing.barcodescanner.SourceData;
import com.didi.zxing.client.AmbientLightManager;
import com.didi.zxing.client.camera.CameraConfigurationUtils;
import com.didi.zxing.client.camera.open.OpenCameraInterface;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class CameraManager {

    /* renamed from: a */
    private static final String f45355a = "CameraManager";

    /* renamed from: b */
    private Camera f45356b;

    /* renamed from: c */
    private Camera.CameraInfo f45357c;

    /* renamed from: d */
    private AutoFocusManager f45358d;

    /* renamed from: e */
    private AmbientLightManager f45359e;

    /* renamed from: f */
    private boolean f45360f;

    /* renamed from: g */
    private String f45361g;

    /* renamed from: h */
    private CameraSettings f45362h = new CameraSettings();

    /* renamed from: i */
    private DisplayConfiguration f45363i;

    /* renamed from: j */
    private Size f45364j;

    /* renamed from: k */
    private Size f45365k;

    /* renamed from: l */
    private int f45366l = -1;

    /* renamed from: m */
    private Context f45367m;

    /* renamed from: n */
    private TorchListener f45368n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Set<PreviewCallback> f45369o = new HashSet();

    /* renamed from: p */
    private final CameraPreviewCallback f45370p;

    public interface TorchListener {
        void onTorchOff();

        void onTorchOn();
    }

    private final class CameraPreviewCallback implements Camera.PreviewCallback {
        private PreviewCallback callback;
        private Size resolution;

        public CameraPreviewCallback() {
        }

        public void setResolution(Size size) {
            this.resolution = size;
        }

        public void setCallback(PreviewCallback previewCallback) {
            this.callback = previewCallback;
        }

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            Size size = this.resolution;
            PreviewCallback previewCallback = this.callback;
            if (size == null || previewCallback == null) {
                SystemUtils.log(3, CameraManager.f45355a, "Got preview callback, but no handler or resolution available", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraManager$CameraPreviewCallback", 131);
                if (previewCallback != null) {
                    previewCallback.onPreviewError(new Exception("No resolution available"));
                }
            } else if (bArr != null) {
                try {
                    byte[] bArr2 = bArr;
                    SourceData sourceData = new SourceData(bArr2, size.width, size.height, camera.getParameters().getPreviewFormat(), CameraManager.this.getCameraRotation());
                    previewCallback.onPreview(sourceData);
                    for (PreviewCallback onPreview : CameraManager.this.f45369o) {
                        onPreview.onPreview(sourceData);
                    }
                } catch (RuntimeException e) {
                    SystemUtils.log(6, CameraManager.f45355a, "Camera preview failed", e, "com.didi.zxing.barcodescanner.camera.CameraManager$CameraPreviewCallback", 127);
                    previewCallback.onPreviewError(e);
                }
            } else {
                throw new NullPointerException("No preview data received");
            }
        }
    }

    public CameraManager(Context context) {
        this.f45367m = context;
        this.f45370p = new CameraPreviewCallback();
    }

    public void open() {
        Camera open = OpenCameraInterface.open(this.f45362h.getRequestedCameraId());
        this.f45356b = open;
        if (open != null) {
            int cameraId = OpenCameraInterface.getCameraId(this.f45362h.getRequestedCameraId());
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            this.f45357c = cameraInfo;
            Camera.getCameraInfo(cameraId, cameraInfo);
            return;
        }
        throw new RuntimeException("Failed to open camera");
    }

    public void configure() {
        if (this.f45356b != null) {
            m32578c();
            return;
        }
        throw new RuntimeException("Camera not open");
    }

    public void setPreviewDisplay(SurfaceHolder surfaceHolder) throws IOException {
        setPreviewDisplay(new CameraSurface(surfaceHolder));
    }

    public void setPreviewDisplay(CameraSurface cameraSurface) throws IOException {
        cameraSurface.setPreview(this.f45356b);
    }

    public void startPreview() {
        Camera camera = this.f45356b;
        if (camera != null && !this.f45360f) {
            camera.startPreview();
            System.out.println("theCamera.startPreview();");
            this.f45360f = true;
            this.f45358d = new AutoFocusManager(this.f45356b, this.f45362h);
            AmbientLightManager ambientLightManager = new AmbientLightManager(this.f45367m, this, this.f45362h);
            this.f45359e = ambientLightManager;
            ambientLightManager.start();
        }
    }

    public void stopPreview() {
        AutoFocusManager autoFocusManager = this.f45358d;
        if (autoFocusManager != null) {
            autoFocusManager.stop();
            this.f45358d = null;
        }
        AmbientLightManager ambientLightManager = this.f45359e;
        if (ambientLightManager != null) {
            ambientLightManager.stop();
            this.f45359e = null;
        }
        Camera camera = this.f45356b;
        if (camera != null && this.f45360f) {
            camera.setPreviewCallback((Camera.PreviewCallback) null);
            this.f45356b.stopPreview();
            this.f45370p.setCallback((PreviewCallback) null);
            this.f45360f = false;
        }
    }

    public void close() {
        Camera camera = this.f45356b;
        if (camera != null) {
            camera.setPreviewCallback((Camera.PreviewCallback) null);
            this.f45356b.release();
            this.f45356b = null;
        }
    }

    public boolean isCameraRotated() {
        int i = this.f45366l;
        if (i != -1) {
            return i % 180 != 0;
        }
        throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
    }

    public int getCameraRotation() {
        return this.f45366l;
    }

    /* renamed from: a */
    private Camera.Parameters m32572a() {
        Camera.Parameters parameters = this.f45356b.getParameters();
        String str = this.f45361g;
        if (str == null) {
            this.f45361g = parameters.flatten();
        } else {
            parameters.unflatten(str);
        }
        return parameters;
    }

    /* renamed from: a */
    private void m32576a(boolean z) {
        boolean z2 = z;
        Camera.Parameters a = m32572a();
        if (a == null) {
            SystemUtils.log(5, f45355a, "Device error: no camera parameters are available. Proceeding without configuration.", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraManager", 275);
            return;
        }
        SystemUtils.log(4, f45355a, "Initial camera parameters: " + a.flatten(), (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraManager", 279);
        if (z2) {
            SystemUtils.log(5, f45355a, "In camera config safe mode -- most settings will not be honored", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraManager", 282);
        }
        CameraConfigurationUtils.setFocus(a, this.f45362h.getFocusMode(), z2);
        if (!z2) {
            CameraConfigurationUtils.setTorch(a, false);
            if (this.f45362h.isScanInverted()) {
                CameraConfigurationUtils.setInvertColor(a);
            }
            if (this.f45362h.isBarcodeSceneModeEnabled()) {
                CameraConfigurationUtils.setBarcodeSceneMode(a);
            }
            if (this.f45362h.isMeteringEnabled() && Build.VERSION.SDK_INT >= 15) {
                CameraConfigurationUtils.setVideoStabilization(a);
                CameraConfigurationUtils.setFocusArea(a);
                CameraConfigurationUtils.setMetering(a);
            }
        }
        List<Size> a2 = m32573a(a);
        if (a2.size() == 0) {
            this.f45364j = null;
        } else {
            Size bestPreviewSize = this.f45363i.getBestPreviewSize(a2, isCameraRotated());
            this.f45364j = bestPreviewSize;
            a.setPreviewSize(bestPreviewSize.width, this.f45364j.height);
        }
        if (Build.DEVICE.equals("glass-1")) {
            CameraConfigurationUtils.setBestPreviewFPS(a);
        }
        SystemUtils.log(4, f45355a, "Final camera parameters: " + a.flatten(), (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraManager", 332);
        this.f45356b.setParameters(a);
    }

    /* renamed from: a */
    private static List<Size> m32573a(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        if (supportedPreviewSizes == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                arrayList.add(new Size(previewSize.width, previewSize.height));
            }
            return arrayList;
        }
        for (Camera.Size next : supportedPreviewSizes) {
            arrayList.add(new Size(next.width, next.height));
        }
        return arrayList;
    }

    /* renamed from: b */
    private int m32577b() {
        int i;
        int rotation = this.f45363i.getRotation();
        int i2 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i2 = 90;
            } else if (rotation == 2) {
                i2 = 180;
            } else if (rotation == 3) {
                i2 = 270;
            }
        }
        if (this.f45357c.facing == 1) {
            i = (360 - ((this.f45357c.orientation + i2) % 360)) % 360;
        } else {
            i = ((this.f45357c.orientation - i2) + 360) % 360;
        }
        SystemUtils.log(4, f45355a, "Camera Display Orientation: " + i, (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraManager", 380);
        return i;
    }

    /* renamed from: a */
    private void m32575a(int i) {
        this.f45356b.setDisplayOrientation(i);
    }

    /* renamed from: c */
    private void m32578c() {
        try {
            int b = m32577b();
            this.f45366l = b;
            m32575a(b);
        } catch (Exception unused) {
            SystemUtils.log(5, f45355a, "Failed to set rotation.", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraManager", 393);
        }
        try {
            m32576a(false);
        } catch (Exception unused2) {
            try {
                m32576a(true);
            } catch (Exception unused3) {
                SystemUtils.log(5, f45355a, "Camera rejected even safe-mode parameters! No configuration", (Throwable) null, "com.didi.zxing.barcodescanner.camera.CameraManager", 403);
            }
        }
        Camera.Size previewSize = this.f45356b.getParameters().getPreviewSize();
        if (previewSize == null) {
            this.f45365k = this.f45364j;
        } else {
            this.f45365k = new Size(previewSize.width, previewSize.height);
        }
        this.f45370p.setResolution(this.f45365k);
    }

    public boolean isOpen() {
        return this.f45356b != null;
    }

    public Size getNaturalPreviewSize() {
        return this.f45365k;
    }

    public Size getPreviewSize() {
        if (this.f45365k == null) {
            return null;
        }
        if (isCameraRotated()) {
            return this.f45365k.rotate();
        }
        return this.f45365k;
    }

    public void requestPreviewFrame(PreviewCallback previewCallback) {
        Camera camera = this.f45356b;
        if (camera != null && this.f45360f) {
            try {
                this.f45370p.setCallback(previewCallback);
                if (previewCallback == null || !previewCallback.oneShot()) {
                    camera.setPreviewCallback(this.f45370p);
                } else {
                    camera.setOneShotPreviewCallback(this.f45370p);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public CameraSettings getCameraSettings() {
        return this.f45362h;
    }

    public void setCameraSettings(CameraSettings cameraSettings) {
        this.f45362h = cameraSettings;
    }

    public DisplayConfiguration getDisplayConfiguration() {
        return this.f45363i;
    }

    public void setDisplayConfiguration(DisplayConfiguration displayConfiguration) {
        this.f45363i = displayConfiguration;
    }

    public void setTorchListener(TorchListener torchListener) {
        this.f45368n = torchListener;
    }

    public void setTorch(boolean z) {
        if (this.f45356b != null) {
            try {
                if (z != isTorchOn()) {
                    if (this.f45368n != null) {
                        if (z) {
                            this.f45368n.onTorchOn();
                        } else {
                            this.f45368n.onTorchOff();
                        }
                    }
                    if (this.f45358d != null) {
                        this.f45358d.stop();
                    }
                    Camera.Parameters parameters = this.f45356b.getParameters();
                    CameraConfigurationUtils.setTorch(parameters, z);
                    if (this.f45362h.isExposureEnabled()) {
                        CameraConfigurationUtils.setBestExposure(parameters, z);
                    }
                    this.f45356b.setParameters(parameters);
                    if (this.f45358d != null) {
                        this.f45358d.start();
                    }
                }
            } catch (RuntimeException e) {
                SystemUtils.log(6, f45355a, "Failed to set torch", e, "com.didi.zxing.barcodescanner.camera.CameraManager", 519);
            }
        }
    }

    public boolean isTorchOn() {
        Camera.Parameters parameters = this.f45356b.getParameters();
        if (parameters == null) {
            return false;
        }
        String flashMode = parameters.getFlashMode();
        if ("on".equals(flashMode) || "torch".equals(flashMode)) {
            return true;
        }
        return false;
    }

    public Camera getCamera() {
        return this.f45356b;
    }

    public void removePreviewCallBack() {
        this.f45370p.setCallback((PreviewCallback) null);
    }

    public void addPreviewCallback(PreviewCallback previewCallback) {
        this.f45369o.add(previewCallback);
    }

    public void removePreviewCallback(PreviewCallback previewCallback) {
        this.f45369o.remove(previewCallback);
    }
}
