package com.didichuxing.dfbasesdk.utils;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Build;

public class CameraUtils {
    private CameraUtils() {
    }

    public static void setCameraDisplayOrientation(Activity activity, int i, Camera camera) {
        if (activity != null) {
            setCameraDisplayOrientation(activity.getWindowManager().getDefaultDisplay().getRotation(), i, camera);
        }
    }

    public static void setCameraDisplayOrientation(int i, int i2, Camera camera) {
        int i3;
        if (camera != null) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            int i4 = 0;
            if (i != 0) {
                if (i == 1) {
                    i4 = 90;
                } else if (i == 2) {
                    i4 = 180;
                } else if (i == 3) {
                    i4 = 270;
                }
            }
            if (cameraInfo.facing == 1) {
                i3 = (360 - ((cameraInfo.orientation + i4) % 360)) % 360;
            } else {
                i3 = ((cameraInfo.orientation - i4) + 360) % 360;
            }
            camera.setDisplayOrientation(i3);
        }
    }

    public static boolean hasFacingFrontCamera() {
        return m33544a(1);
    }

    public static boolean hasFacingBackCamera() {
        return m33544a(0);
    }

    /* renamed from: a */
    private static boolean m33544a(int i) {
        if (Build.VERSION.SDK_INT < 9) {
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
}
