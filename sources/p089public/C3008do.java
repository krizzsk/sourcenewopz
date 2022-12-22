package p089public;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import java.util.List;
import p089public.C3011new;

/* renamed from: public.do */
/* compiled from: LivenessSensorDataBuffer */
public class C3008do implements C3011new.C3012do {

    /* renamed from: a */
    private C3009for f6717a = new C3009for();

    /* renamed from: b */
    private Long f6718b;

    /* renamed from: c */
    private final int f6719c;

    /* renamed from: d */
    private final C3013try f6720d;

    /* renamed from: e */
    private final Object f6721e = new Object();

    public C3008do(int i, int i2) {
        this.f6719c = i;
        this.f6720d = new C3013try(i2);
    }

    /* renamed from: a */
    private boolean m3816a() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (this.f6718b == null) {
            this.f6718b = valueOf;
            return true;
        } else if (valueOf.longValue() - this.f6718b.longValue() >= ((long) this.f6719c)) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: b */
    private C3009for m3817b() {
        C3009for forR = this.f6717a;
        this.f6717a = new C3009for();
        return forR;
    }

    /* renamed from: do */
    public List<C3009for> mo38417do() {
        List<C3009for> list;
        synchronized (this.f6721e) {
            list = this.f6720d.mo38432do();
        }
        return list;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        this.f6717a.onAccuracyChanged(sensor, i);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        this.f6717a.onSensorChanged(sensorEvent);
        StringBuilder sb = new StringBuilder();
        sb.append("Sensors ");
        sb.append(sensorEvent.sensor.getName());
        sb.append(" ");
        sb.append(sensorEvent.values.length);
        if (m3816a()) {
            synchronized (this.f6721e) {
                C3009for b = m3817b();
                if (!b.mo38420a()) {
                    this.f6720d.mo38433do(b);
                }
            }
            this.f6718b = Long.valueOf(System.currentTimeMillis());
        }
    }
}
