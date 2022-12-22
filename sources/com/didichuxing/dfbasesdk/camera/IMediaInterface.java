package com.didichuxing.dfbasesdk.camera;

import android.hardware.Camera;
import com.didichuxing.dfbasesdk.video_capture.IMediaControl;

public interface IMediaInterface extends IMediaControl {
    void autoFocus();

    CameraWrapper getCamera();

    int getPreviewHeight();

    int getPreviewWidth();

    void setCallback(Camera.PreviewCallback previewCallback);

    void switchCamera();

    boolean switchFlashLight();

    void takePhoto(Camera.PictureCallback pictureCallback);
}
