package com.didichuxing.diface.appeal;

import android.content.Context;
import android.hardware.Camera;
import android.view.OrientationEventListener;
import com.didichuxing.dfbasesdk.camera.DiFaceCameraManager;
import com.didichuxing.dfbasesdk.utils.LogUtils;

public class OrientationListenerImpl extends OrientationEventListener {

    /* renamed from: a */
    private final DiFaceCameraManager f46978a;

    /* renamed from: b */
    private int f46979b;

    public OrientationListenerImpl(Context context, DiFaceCameraManager diFaceCameraManager) {
        super(context);
        this.f46978a = diFaceCameraManager;
    }

    public void onOrientationChanged(int i) {
        int i2;
        if (i != -1) {
            try {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(this.f46978a.getCurrentCameraId(), cameraInfo);
                int i3 = ((i + 45) / 90) * 90;
                if (cameraInfo.facing == 1) {
                    i2 = ((cameraInfo.orientation - i3) + 360) % 360;
                } else {
                    i2 = (cameraInfo.orientation + i3) % 360;
                }
                this.f46979b = i2;
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
            }
        }
    }

    public int getRotation() {
        return this.f46979b;
    }
}
