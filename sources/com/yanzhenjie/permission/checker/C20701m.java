package com.yanzhenjie.permission.checker;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.didi.security.wireless.ISecurityConf;

/* renamed from: com.yanzhenjie.permission.checker.m */
/* compiled from: SensorsTest */
class C20701m implements PermissionTest {

    /* renamed from: b */
    private static final SensorEventListener f56192b = new SensorsTest$1();

    /* renamed from: a */
    private Context f56193a;

    C20701m(Context context) {
        this.f56193a = context;
    }

    /* renamed from: a */
    public boolean mo169065a() throws Throwable {
        SensorManager sensorManager = (SensorManager) this.f56193a.getSystemService(ISecurityConf.KEY_SENSOR);
        try {
            Sensor defaultSensor = sensorManager.getDefaultSensor(21);
            sensorManager.registerListener(f56192b, defaultSensor, 3);
            sensorManager.unregisterListener(f56192b, defaultSensor);
            return true;
        } catch (Throwable unused) {
            return !this.f56193a.getPackageManager().hasSystemFeature("android.hardware.sensor.heartrate");
        }
    }
}
