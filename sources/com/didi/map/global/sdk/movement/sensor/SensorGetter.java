package com.didi.map.global.sdk.movement.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.didi.common.map.util.DLog;
import com.didi.security.wireless.ISecurityConf;

public class SensorGetter {

    /* renamed from: a */
    private SensorManager f27747a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public onSensorChanged f27748b;

    /* renamed from: c */
    private final SensorEventListener f27749c = new SensorEventListener() {
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1 && SensorGetter.this.f27748b != null) {
                SensorGetter.this.f27748b.onAccelerationChanged(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]);
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
            DLog.m7384d("ccc", "name:" + sensor.getName() + ",精度： " + i, new Object[0]);
        }
    };

    public interface onSensorChanged {
        void onAccelerationChanged(float f, float f2, float f3);
    }

    public SensorGetter(Context context) {
        if (context != null) {
            SensorManager sensorManager = (SensorManager) context.getSystemService(ISecurityConf.KEY_SENSOR);
            this.f27747a = sensorManager;
            if (sensorManager != null) {
                this.f27747a.registerListener(this.f27749c, sensorManager.getDefaultSensor(1), 1);
            }
        }
    }

    public void setOnSensorChanged(onSensorChanged onsensorchanged) {
        this.f27748b = onsensorchanged;
    }

    public void destroy() {
        SensorManager sensorManager = this.f27747a;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f27749c);
            this.f27747a = null;
        }
        this.f27748b = null;
    }
}
