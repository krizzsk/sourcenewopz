package com.didi.global.qrscan;

import android.content.Context;
import android.view.TextureView;
import com.didi.zxing.barcodescanner.camera.CameraInstance;
import com.didi.zxing.barcodescanner.camera.CameraSettings;
import com.didi.zxing.barcodescanner.camera.CameraSurface;

public class OpenLightManager {

    /* renamed from: a */
    private CameraInstance f22904a;

    public void start(Context context, TextureView textureView) {
        if (this.f22904a == null) {
            try {
                this.f22904a = new CameraInstance(context);
                CameraSettings cameraSettings = new CameraSettings();
                cameraSettings.setAutoTorchEnabled(true);
                this.f22904a.setCameraSettings(cameraSettings);
                this.f22904a.setSurface(new CameraSurface(textureView.getSurfaceTexture()));
                this.f22904a.open();
                this.f22904a.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        try {
            this.f22904a.stopPreview();
            this.f22904a.close();
            this.f22904a = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
