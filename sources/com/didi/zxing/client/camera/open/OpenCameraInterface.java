package com.didi.zxing.client.camera.open;

import android.hardware.Camera;
import com.didi.sdk.apm.SystemUtils;

public final class OpenCameraInterface {
    public static final int NO_REQUESTED_CAMERA = -1;

    /* renamed from: a */
    private static final String f45493a = "OpenCameraInterface";

    private OpenCameraInterface() {
    }

    public static int getCameraId(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            SystemUtils.log(5, f45493a, "No cameras!", (Throwable) null, "com.didi.zxing.client.camera.open.OpenCameraInterface", 37);
            return -1;
        }
        boolean z = i >= 0;
        if (!z) {
            i = 0;
            while (i < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i++;
            }
        }
        if (i < numberOfCameras) {
            return i;
        }
        if (z) {
            return -1;
        }
        return 0;
    }

    public static Camera open(int i) {
        int cameraId = getCameraId(i);
        if (cameraId == -1) {
            return null;
        }
        return Camera.open(cameraId);
    }
}
