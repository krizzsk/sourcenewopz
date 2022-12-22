package com.didichuxing.dfbasesdk.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import com.didichuxing.dfbasesdk.utils.CameraUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlinx.coroutines.DebugKt;

public class DiFaceCameraManager {
    public static final int PIC_HEIGHT_DEFAULT = 480;
    public static final int PIC_WIDTH_DEFAULT = 640;

    /* renamed from: n */
    private static final int f46520n = 1;

    /* renamed from: o */
    private static final int f46521o = 2;

    /* renamed from: p */
    private static final int f46522p = 3;

    /* renamed from: a */
    private int f46523a;

    /* renamed from: b */
    private boolean f46524b;

    /* renamed from: c */
    private int f46525c;

    /* renamed from: d */
    private int f46526d;

    /* renamed from: e */
    private int f46527e;

    /* renamed from: f */
    private int f46528f;

    /* renamed from: g */
    private int f46529g;

    /* renamed from: h */
    private int f46530h;

    /* renamed from: i */
    private boolean f46531i;

    /* renamed from: j */
    private Camera f46532j;

    /* renamed from: k */
    private int f46533k;

    /* renamed from: l */
    private final int f46534l;

    /* renamed from: m */
    private int f46535m;

    public static class CropData {
        public float heightRatio;
        public float widthRatio;
        public float xRatio;
        public float yRatio;
    }

    public static boolean isFlashSupported(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    public DiFaceCameraManager(int i, boolean z, int i2, int i3) {
        this(i, z, i2, i3, -1, -1, -1, -1);
    }

    public DiFaceCameraManager(int i, boolean z, int i2, int i3, int i4, int i5) {
        this(i, z, i2, i3, i4, i5, -1, -1);
    }

    public DiFaceCameraManager(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f46527e = 1280;
        this.f46528f = 720;
        this.f46529g = 640;
        this.f46530h = 480;
        this.f46533k = 1;
        this.f46535m = -1;
        this.f46523a = i;
        this.f46524b = z;
        this.f46525c = i2;
        this.f46526d = i3;
        if (i4 != -1) {
            this.f46527e = i4;
        }
        if (i5 != -1) {
            this.f46528f = i5;
        }
        if (i6 != -1) {
            this.f46529g = i6;
        }
        if (i7 != -1) {
            this.f46530h = i7;
        }
        this.f46534l = Camera.getNumberOfCameras();
    }

    public Camera openCamera() {
        return openCamera(this.f46533k);
    }

    public Camera openCamera(int i) {
        Camera camera = this.f46532j;
        if (camera != null) {
            return camera;
        }
        try {
            this.f46532j = Camera.open(i);
            this.f46533k = i;
            m33382a(false);
            return this.f46532j;
        } catch (Exception e) {
            LogUtils.m33563d("open camera failed as: " + e.getMessage());
            return null;
        }
    }

    public Camera openCamera(int i, boolean z) {
        Camera camera = this.f46532j;
        if (camera != null) {
            return camera;
        }
        try {
            this.f46532j = Camera.open(i);
            this.f46533k = i;
            m33382a(z);
            return this.f46532j;
        } catch (Exception e) {
            LogUtils.m33563d("open camera failed as: " + e.getMessage());
            return null;
        }
    }

    public void updateRotation(int i) {
        Camera camera = this.f46532j;
        if (camera != null && i != this.f46535m) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setRotation(i);
            this.f46532j.setParameters(parameters);
            this.f46535m = i;
        }
    }

    /* renamed from: a */
    private void m33382a(boolean z) {
        Camera.Size size;
        try {
            Camera.Parameters parameters = this.f46532j.getParameters();
            CameraUtils.setCameraDisplayOrientation(this.f46523a, this.f46533k, this.f46532j);
            if (z) {
                size = m33379a(parameters, this.f46527e, this.f46528f);
            } else {
                size = m33380a(parameters, 1, this.f46527e, this.f46528f);
            }
            Camera.Size a = m33380a(parameters, 2, this.f46529g, this.f46530h);
            parameters.setPreviewSize(size.width, size.height);
            parameters.setPictureSize(a.width, a.height);
            LogUtils.m33563d("pre size, w====" + size.width + ", h=" + size.height);
            LogUtils.m33563d("pic size, w====" + a.width + ", h=" + a.height);
            LogUtils.m33563d("support focus modes====" + parameters.getSupportedFocusModes() + ", original focus mode=" + parameters.getFocusMode());
            if (this.f46533k == 0 && parameters.getSupportedFocusModes().contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                parameters.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            }
            this.f46532j.setParameters(parameters);
        } catch (Exception e) {
            LogUtils.m33563d("init camera params exception: " + e.getMessage());
        }
    }

    /* renamed from: a */
    private Camera.Size m33379a(Camera.Parameters parameters, int i, int i2) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList<Camera.Size> arrayList = new ArrayList<>();
        if (this.f46524b) {
            for (Camera.Size next : supportedPreviewSizes) {
                if (next.width == i) {
                    arrayList.add(next);
                }
            }
            if (arrayList.isEmpty()) {
                for (Camera.Size next2 : supportedPreviewSizes) {
                    if (next2.height == i2) {
                        arrayList.add(next2);
                    }
                }
            }
        } else {
            for (Camera.Size next3 : supportedPreviewSizes) {
                if (next3.height == i2) {
                    arrayList.add(next3);
                }
            }
            if (arrayList.isEmpty()) {
                for (Camera.Size next4 : supportedPreviewSizes) {
                    if (next4.width == i) {
                        arrayList.add(next4);
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return m33380a(parameters, 1, i, i2);
        }
        Camera.Size size = (Camera.Size) arrayList.get(0);
        int i3 = Integer.MAX_VALUE;
        for (Camera.Size size2 : arrayList) {
            int abs = Math.abs((i * i2) - (size2.width * size2.height));
            if (abs < i3) {
                size = size2;
                i3 = abs;
            }
        }
        return size;
    }

    /* renamed from: a */
    private Camera.Size m33380a(Camera.Parameters parameters, int i, final int i2, final int i3) {
        List<Camera.Size> list;
        if (i == 1) {
            list = parameters.getSupportedPreviewSizes();
        } else if (i == 2) {
            list = parameters.getSupportedPictureSizes();
        } else {
            list = i == 3 ? parameters.getSupportedVideoSizes() : null;
        }
        ArrayList arrayList = new ArrayList();
        for (Camera.Size next : list) {
            if (next.width > next.height) {
                arrayList.add(next);
            }
        }
        Collections.sort(arrayList, new Comparator<Camera.Size>() {
            public int compare(Camera.Size size, Camera.Size size2) {
                return Math.abs((size.width * size.height) - (i2 * i3)) - Math.abs((size2.width * size2.height) - (i2 * i3));
            }
        });
        return (Camera.Size) arrayList.get(0);
    }

    @Deprecated
    /* renamed from: a */
    private Camera.Size m33381a(List<Camera.Size> list, boolean z) {
        int i;
        float f;
        float f2 = ((float) this.f46525c) / ((float) this.f46526d);
        LogUtils.m33563d("ratio is: " + f2);
        Camera.Size size = null;
        for (Camera.Size next : list) {
            if (this.f46524b) {
                f = (float) next.height;
                i = next.width;
            } else {
                f = (float) next.width;
                i = next.height;
            }
            float f3 = f / ((float) i);
            LogUtils.m33563d("sizeRatio is: " + f3);
            if (((double) Math.abs(f3 - f2)) < 0.1d) {
                if (size != null) {
                    if (z) {
                        if (this.f46524b) {
                            if (next.height <= size.height) {
                            }
                        } else if (next.width <= size.width) {
                        }
                    } else if (this.f46524b) {
                        if (next.height >= size.height) {
                        }
                    } else if (next.width >= size.width) {
                    }
                }
                size = next;
            }
        }
        if (size == null) {
            LogUtils.m33563d("can't find best size, use default");
            size = list.get(0);
        }
        LogUtils.m33563d("best size is: " + size.width + " X " + size.height);
        return size;
    }

    public void closeCamera() {
        this.f46535m = -1;
        Camera camera = this.f46532j;
        if (camera != null) {
            try {
                camera.stopPreview();
                this.f46532j.setPreviewCallback((Camera.PreviewCallback) null);
            } catch (Exception e) {
                LogUtils.m33563d("close camera exception: " + e.getMessage());
            } catch (Throwable th) {
                this.f46532j.release();
                this.f46532j = null;
                throw th;
            }
            this.f46532j.release();
            this.f46532j = null;
        }
    }

    public void autoFocus() {
        Camera camera = this.f46532j;
        if (camera != null) {
            try {
                camera.autoFocus((Camera.AutoFocusCallback) null);
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
            }
        }
    }

    public boolean switchFlashLight() {
        Camera camera = this.f46532j;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.getFlashMode().equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                parameters.setFlashMode("torch");
                this.f46532j.setParameters(parameters);
                return true;
            }
            parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            this.f46532j.setParameters(parameters);
        }
        return false;
    }

    public boolean startPreview(SurfaceHolder surfaceHolder) {
        Camera camera = this.f46532j;
        if (camera != null) {
            try {
                camera.setPreviewDisplay(surfaceHolder);
                this.f46532j.startPreview();
                autoFocus();
                return true;
            } catch (IOException | RuntimeException unused) {
            }
        }
        return false;
    }

    public boolean startPreview(SurfaceTexture surfaceTexture) {
        Camera camera = this.f46532j;
        if (camera != null) {
            try {
                camera.setPreviewTexture(surfaceTexture);
                this.f46532j.startPreview();
                autoFocus();
                return true;
            } catch (IOException | RuntimeException unused) {
            }
        }
        return false;
    }

    public Camera getCamera() {
        return this.f46532j;
    }

    public int getCurrentCameraId() {
        return this.f46533k;
    }

    public void takePhoto(Camera.PictureCallback pictureCallback) {
        try {
            this.f46532j.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, pictureCallback);
        } catch (Exception e) {
            LogUtils.m33563d("take photo exception: " + e.getMessage());
        }
    }

    public int getMediaPlayerRotation() {
        return this.f46524b ? this.f46533k == 1 ? 270 : 90 : this.f46533k == 1 ? 180 : 0;
    }

    public void switchCamera(SurfaceHolder surfaceHolder) {
        if (this.f46534l != 1) {
            int i = this.f46533k;
            if (i == 1) {
                this.f46533k = 0;
                closeCamera();
            } else if (i == 0) {
                this.f46533k = 1;
                closeCamera();
            }
            openCamera(this.f46533k);
            startPreview(surfaceHolder);
        }
    }

    public void switchCamera(SurfaceTexture surfaceTexture) {
        if (this.f46534l != 1) {
            int i = this.f46533k;
            if (i == 1) {
                this.f46533k = 0;
                closeCamera();
            } else if (i == 0) {
                this.f46533k = 1;
                closeCamera();
            }
            openCamera(this.f46533k);
            startPreview(surfaceTexture);
        }
    }
}
