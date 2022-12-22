package p095throw;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.didi.security.wireless.ISecurityConf;

/* renamed from: throw.do */
/* compiled from: LightSensor */
public class C3134do implements SensorEventListener {

    /* renamed from: a */
    private final SensorManager f6980a;

    /* renamed from: b */
    private final Sensor f6981b;

    /* renamed from: c */
    private float f6982c = -1.0f;

    public C3134do(Context context) throws C3135if {
        SensorManager sensorManager = (SensorManager) context.getSystemService(ISecurityConf.KEY_SENSOR);
        this.f6980a = sensorManager;
        if (sensorManager != null) {
            this.f6981b = sensorManager.getDefaultSensor(5);
            return;
        }
        throw new C3135if();
    }

    /* renamed from: do */
    public void mo38651do() {
        this.f6980a.unregisterListener(this, this.f6981b);
    }

    /* renamed from: for  reason: not valid java name */
    public void m46214for() {
        this.f6980a.registerListener(this, this.f6981b, 3);
    }

    /* renamed from: if */
    public synchronized float mo38653if() {
        return this.f6982c;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public synchronized void onSensorChanged(SensorEvent sensorEvent) {
        this.f6982c = sensorEvent.values[0];
    }
}
