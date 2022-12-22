package com.didichuxing.diface.biz.bioassay.fpp.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.os.Build;
import android.widget.RelativeLayout;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ICamera {

    /* renamed from: a */
    private boolean f47231a = false;

    /* renamed from: b */
    private List<String> f47232b;
    public int cameraHeight;
    public int cameraId = 1;
    public int cameraWidth;
    public volatile Camera mCamera;

    public boolean isOpen() {
        return this.f47231a;
    }

    public void addAllFlipCameraType(List<String> list) {
        if (list != null) {
            if (this.f47232b == null) {
                this.f47232b = new ArrayList();
            }
            this.f47232b.clear();
            this.f47232b.addAll(list);
        }
    }

    public boolean isInFlipCameraTypeList(String str) {
        for (String equals : this.f47232b) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public int openCamera(Activity activity) {
        return openCamera(activity, false);
    }

    public int openCamera(Activity activity, boolean z) {
        try {
            this.cameraId = 1;
            if (!hasFrontFacingCamera()) {
                this.cameraId = 0;
            }
            this.mCamera = Camera.open(this.cameraId);
            Camera.getCameraInfo(this.cameraId, new Camera.CameraInfo());
            Camera.Parameters parameters = this.mCamera.getParameters();
            Camera.Size a = m33876a(this.mCamera.getParameters(), 640, 480);
            this.cameraWidth = a.width;
            int i = a.height;
            this.cameraHeight = i;
            parameters.setPreviewSize(this.cameraWidth, i);
            if (!z) {
                this.mCamera.setDisplayOrientation(getCameraAngle(activity));
            }
            this.mCamera.setParameters(parameters);
            return this.cameraId;
        } catch (Exception e) {
            LogUtils.m33563d("camera open failed: " + e.getMessage());
            return -1;
        }
    }

    public RelativeLayout.LayoutParams getLayoutParam() {
        Camera.Size previewSize = this.mCamera.getParameters().getPreviewSize();
        float min = Math.min((((float) Screen.mWidth) * 1.0f) / ((float) previewSize.height), (((float) Screen.mHeight) * 1.0f) / ((float) previewSize.width));
        return new RelativeLayout.LayoutParams((int) (((float) previewSize.height) * min), (int) (min * ((float) previewSize.width)));
    }

    public void actionDetect(Camera.PreviewCallback previewCallback) {
        try {
            if (this.mCamera != null) {
                this.mCamera.setPreviewCallback(previewCallback);
                this.f47231a = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startPreview(SurfaceTexture surfaceTexture) {
        try {
            if (this.mCamera != null) {
                try {
                    this.mCamera.setPreviewTexture(surfaceTexture);
                    this.mCamera.startPreview();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void closeCamera() {
        try {
            if (this.mCamera != null) {
                this.f47231a = false;
                this.mCamera.stopPreview();
                this.mCamera.setPreviewCallback((Camera.PreviewCallback) null);
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private Camera.Size m33876a(Camera.Parameters parameters, final int i, final int i2) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        for (Camera.Size next : supportedPreviewSizes) {
            if (next.width > next.height) {
                arrayList.add(next);
            }
        }
        Collections.sort(arrayList, new Comparator<Camera.Size>() {
            public int compare(Camera.Size size, Camera.Size size2) {
                return Math.abs((size.width * size.height) - (i * i2)) - Math.abs((size2.width * size2.height) - (i * i2));
            }
        });
        return (Camera.Size) arrayList.get(0);
    }

    public Camera getCameraSafely(int i) {
        try {
            return Camera.open(i);
        } catch (Exception unused) {
            return null;
        }
    }

    public RelativeLayout.LayoutParams getParams(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Camera.Size a = m33876a(parameters, Screen.mWidth, Screen.mHeight);
        this.cameraWidth = a.width;
        int i = a.height;
        this.cameraHeight = i;
        parameters.setPreviewSize(this.cameraWidth, i);
        camera.setParameters(parameters);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a.width, (int) (((float) a.width) / ((float) (a.width / a.height))));
        layoutParams.addRule(14);
        return layoutParams;
    }

    public Bitmap getBitmap(byte[] bArr, Camera camera, boolean z) {
        int i = camera.getParameters().getPreviewSize().width;
        int i2 = camera.getParameters().getPreviewSize().height;
        YuvImage yuvImage = new YuvImage(bArr, camera.getParameters().getPreviewFormat(), i, i2, (int[]) null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 80, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        Matrix matrix = new Matrix();
        matrix.reset();
        if (z) {
            matrix.setRotate(-90.0f);
        } else {
            matrix.setRotate(90.0f);
        }
        Bitmap copy = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true).copy(Bitmap.Config.ARGB_8888, true);
        float height = ((float) (copy.getHeight() > copy.getWidth() ? copy.getHeight() : copy.getWidth())) / 800.0f;
        return height > 1.0f ? Bitmap.createScaledBitmap(copy, (int) (((float) copy.getWidth()) / height), (int) (((float) copy.getHeight()) / height), false) : copy;
    }

    public int getCameraAngle(Activity activity) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.cameraId, cameraInfo);
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        int i = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i = 90;
            } else if (rotation == 2) {
                i = 180;
            } else if (rotation == 3) {
                i = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i) + 360) % 360;
    }

    public static boolean hasFrontFacingCamera() {
        return m33877a(1);
    }

    /* renamed from: a */
    private static boolean m33877a(int i) {
        if (getSdkVersion() < 9) {
            return false;
        }
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (i == cameraInfo.facing) {
                return true;
            }
        }
        return false;
    }

    public static int getSdkVersion() {
        return Build.VERSION.SDK_INT;
    }
}
