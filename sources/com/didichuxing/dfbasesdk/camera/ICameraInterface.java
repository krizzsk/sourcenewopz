package com.didichuxing.dfbasesdk.camera;

import android.hardware.Camera;

public interface ICameraInterface {
    Camera getCamera();

    int getPreviewHeight();

    int getPreviewWidth();
}
