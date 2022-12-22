package com.microblink.blinkbarcode.view.surface;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.microblink.blinkbarcode.hardware.camera.IllIIIllII;
import com.microblink.blinkbarcode.view.CameraAspectMode;

/* compiled from: line */
public interface ICameraView {

    /* compiled from: line */
    public interface CameraViewEventListener {
        void onCameraPinchEvent(float f);

        void onCameraTapEvent(float f, float f2);
    }

    Rect convertRectangleToActualRect(RectF rectF);

    void dispose();

    View getView();

    int getVisibleHeight();

    int getVisibleWidth();

    void installCallback(IllIIIllII illIIIllII);

    void removeCallback();

    void setAspectMode(CameraAspectMode cameraAspectMode);

    void setCameraViewEventListener(CameraViewEventListener cameraViewEventListener);

    void setDeviceNaturalOrientationLandscape(boolean z);

    void setHostActivityOrientation(int i);

    void setPreviewSize(int i, int i2);

    void setRotation(int i);
}
