package com.didichuxing.gbankcard.ocr.utils;

import android.content.Context;
import android.hardware.Camera;
import android.view.OrientationEventListener;
import com.didichuxing.dfbasesdk.utils.LogUtils;

public class OrientationListenerImpl extends OrientationEventListener {

    /* renamed from: a */
    private int f47724a;

    public OrientationListenerImpl(Context context) {
        super(context);
    }

    public void onOrientationChanged(int i) {
        int i2;
        LogUtils.m33563d("orientation changed========" + i);
        if (i != -1) {
            try {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(0, cameraInfo);
                int i3 = ((i + 45) / 90) * 90;
                if (cameraInfo.facing == 1) {
                    i2 = ((cameraInfo.orientation - i3) + 360) % 360;
                } else {
                    i2 = (cameraInfo.orientation + i3) % 360;
                }
                LogUtils.m33563d("rotation=====" + i2);
                this.f47724a = i2;
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo117774a() {
        return this.f47724a;
    }
}
