package com.didi.zxing.client;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.didi.sdk.apm.SystemUtils;
import com.didi.security.wireless.ISecurityConf;
import com.didi.util.DecodeConfigUtil;
import com.didi.zxing.barcodescanner.DecodeConfig;
import com.didi.zxing.barcodescanner.camera.CameraManager;
import com.didi.zxing.barcodescanner.camera.CameraSettings;

public final class AmbientLightManager implements SensorEventListener {

    /* renamed from: a */
    private static final float f45452a = 1.0f;

    /* renamed from: b */
    private static final float f45453b = 600.0f;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CameraManager f45454c;

    /* renamed from: d */
    private CameraSettings f45455d;

    /* renamed from: e */
    private Sensor f45456e;

    /* renamed from: f */
    private Context f45457f;

    /* renamed from: g */
    private Handler f45458g = new Handler();

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public AmbientLightManager(Context context, CameraManager cameraManager, CameraSettings cameraSettings) {
        this.f45457f = context;
        this.f45454c = cameraManager;
        this.f45455d = cameraSettings;
    }

    public void start() {
        DecodeConfig config = DecodeConfigUtil.getConfig();
        if ((config == null || !config.autoTorch()) && this.f45455d.isAutoTorchEnabled()) {
            SensorManager sensorManager = (SensorManager) this.f45457f.getSystemService(ISecurityConf.KEY_SENSOR);
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f45456e = defaultSensor;
            if (defaultSensor != null) {
                sensorManager.registerListener(this, defaultSensor, 3);
            }
        }
    }

    public void stop() {
        if (this.f45456e != null) {
            ((SensorManager) this.f45457f.getSystemService(ISecurityConf.KEY_SENSOR)).unregisterListener(this);
            this.f45456e = null;
        }
    }

    /* renamed from: a */
    private void m32610a(final boolean z) {
        this.f45458g.post(new Runnable() {
            public void run() {
                AmbientLightManager.this.f45454c.setTorch(z);
            }
        });
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        if (this.f45454c != null) {
            SystemUtils.log(6, "panlei", "ambientLightLux = " + f, (Throwable) null, "com.didi.zxing.client.AmbientLightManager", 94);
            if (f <= 1.0f) {
                m32610a(true);
            } else if (f >= f45453b) {
                m32610a(false);
            }
        }
    }
}
