package p065me.dm7.barcodescanner.core;

import android.hardware.Camera;

/* renamed from: me.dm7.barcodescanner.core.CameraWrapper */
public class CameraWrapper {
    public final Camera mCamera;
    public final int mCameraId;

    private CameraWrapper(Camera camera, int i) {
        if (camera != null) {
            this.mCamera = camera;
            this.mCameraId = i;
            return;
        }
        throw new NullPointerException("Camera cannot be null");
    }

    public static CameraWrapper getWrapper(Camera camera, int i) {
        if (camera == null) {
            return null;
        }
        return new CameraWrapper(camera, i);
    }
}
