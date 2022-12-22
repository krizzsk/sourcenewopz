package com.didichuxing.diface.biz.bioassay.fpp.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.didi.security.wireless.ISecurityConf;

public class SensorUtil implements SensorEventListener {

    /* renamed from: Y */
    public float f47243Y;

    /* renamed from: a */
    private SensorManager f47244a;

    /* renamed from: b */
    private Sensor f47245b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f47246c;

    /* renamed from: d */
    private Handler f47247d;

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public SensorUtil(Context context) {
        m33881a(context);
    }

    /* renamed from: a */
    private void m33881a(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService(ISecurityConf.KEY_SENSOR);
        this.f47244a = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        this.f47245b = defaultSensor;
        if (defaultSensor != null) {
            this.f47244a.registerListener(this, defaultSensor, 3);
        } else {
            this.f47246c = true;
        }
        Handler handler = new Handler();
        this.f47247d = handler;
        handler.postDelayed(new Runnable() {
            public void run() {
                boolean unused = SensorUtil.this.f47246c = true;
            }
        }, 3000);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        this.f47243Y = sensorEvent.values[1];
    }

    public void release() {
        SensorManager sensorManager;
        if (!(this.f47245b == null || (sensorManager = this.f47244a) == null)) {
            sensorManager.unregisterListener(this);
        }
        Handler handler = this.f47247d;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public boolean isVertical() {
        return this.f47243Y >= 8.0f;
    }

    public boolean isSensorFault() {
        return this.f47246c;
    }
}
