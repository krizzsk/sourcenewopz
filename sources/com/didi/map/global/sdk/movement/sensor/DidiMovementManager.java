package com.didi.map.global.sdk.movement.sensor;

import android.content.Context;
import com.didi.map.global.sdk.movement.sensor.SensorGetter;
import com.didi.map.global.sdk.movement.sensor.StepDetection;

public class DidiMovementManager {

    /* renamed from: a */
    private static volatile DidiMovementManager f27734a;

    /* renamed from: b */
    private static Context f27735b;

    /* renamed from: c */
    private boolean f27736c = false;

    /* renamed from: d */
    private SensorGetter f27737d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public StepDetection f27738e;

    /* renamed from: f */
    private final SensorGetter.onSensorChanged f27739f = new SensorGetter.onSensorChanged() {
        public void onAccelerationChanged(float f, float f2, float f3) {
            if (DidiMovementManager.this.f27738e != null) {
                DidiMovementManager.this.f27738e.onReceiveAcceleration(new StepDetection.Acceleration((float) Math.sqrt(Math.pow((double) f, 2.0d) + Math.pow((double) f2, 2.0d) + Math.pow((double) f3, 2.0d)), System.currentTimeMillis()));
            }
        }
    };

    public static DidiMovementManager getInstance(Context context) {
        if (context == null) {
            return null;
        }
        if (f27734a == null) {
            synchronized (DidiMovementManager.class) {
                if (f27734a == null) {
                    f27734a = new DidiMovementManager(context);
                }
            }
        }
        return f27734a;
    }

    private DidiMovementManager(Context context) {
        f27735b = context.getApplicationContext();
    }

    public void start(onDidiMovementListener ondidimovementlistener) {
        if (!this.f27736c) {
            this.f27736c = true;
            SensorGetter sensorGetter = new SensorGetter(f27735b);
            this.f27737d = sensorGetter;
            sensorGetter.setOnSensorChanged(this.f27739f);
            this.f27738e = new StepDetection(f27735b, 400, ondidimovementlistener);
        }
    }

    public void stop() {
        if (this.f27736c) {
            this.f27736c = false;
            SensorGetter sensorGetter = this.f27737d;
            if (sensorGetter != null) {
                sensorGetter.destroy();
                this.f27737d = null;
            }
            StepDetection stepDetection = this.f27738e;
            if (stepDetection != null) {
                stepDetection.destroy();
                this.f27738e = null;
            }
        }
        f27734a = null;
        f27735b = null;
    }
}
