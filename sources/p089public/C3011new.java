package p089public;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.didi.security.wireless.ISecurityConf;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* renamed from: public.new */
/* compiled from: SensorDataManager */
public class C3011new implements SensorEventListener {

    /* renamed from: a */
    private static final String f6730a = C3011new.class.getSimpleName();

    /* renamed from: b */
    private static final int[] f6731b = {1, 10, 4, 9, 11};

    /* renamed from: c */
    private final Map<Integer, Boolean> f6732c = new HashMap();

    /* renamed from: d */
    private final HandlerThread f6733d;

    /* renamed from: e */
    private final Handler f6734e;

    /* renamed from: f */
    private volatile boolean f6735f;

    /* renamed from: g */
    private final SensorManager f6736g;

    /* renamed from: h */
    private C3012do f6737h;

    /* renamed from: public.new$do */
    /* compiled from: SensorDataManager */
    public interface C3012do {
        void onAccuracyChanged(Sensor sensor, int i);

        void onSensorChanged(SensorEvent sensorEvent);
    }

    public C3011new(Context context) throws C3010if {
        HandlerThread handlerThread = new HandlerThread("Sensor Data Manager");
        this.f6733d = handlerThread;
        this.f6735f = false;
        this.f6737h = null;
        SensorManager sensorManager = (SensorManager) context.getApplicationContext().getSystemService(ISecurityConf.KEY_SENSOR);
        this.f6736g = sensorManager;
        if (sensorManager != null) {
            handlerThread.start();
            this.f6734e = new Handler(handlerThread.getLooper());
            m3823a();
            return;
        }
        throw new C3010if();
    }

    /* renamed from: a */
    private void m3823a() {
        for (int i : f6731b) {
            Sensor defaultSensor = this.f6736g.getDefaultSensor(i);
            if (defaultSensor != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Sensors ");
                sb.append(i);
                sb.append(" ");
                sb.append(defaultSensor.getName());
                this.f6732c.put(Integer.valueOf(i), Boolean.valueOf(this.f6736g.registerListener(this, defaultSensor, 100000, this.f6734e)));
            }
        }
    }

    /* renamed from: do */
    public static JSONArray m3824do(List<C3009for> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (C3009for b : list) {
                jSONArray.put(b.mo38421b());
            }
        }
        return jSONArray;
    }

    /* renamed from: case  reason: not valid java name */
    public synchronized void m46179case() {
        this.f6736g.unregisterListener(this);
        this.f6733d.quit();
    }

    /* renamed from: for  reason: not valid java name */
    public void m46180for() {
        for (Sensor next : this.f6736g.getSensorList(-1)) {
            String.format("Available Sensors [%s] Type = %s ON = %s", new Object[]{next.getName(), Integer.valueOf(next.getType()), this.f6732c.get(Integer.valueOf(next.getType()))});
        }
    }

    /* renamed from: if */
    public boolean mo38428if() {
        Boolean bool = this.f6732c.get(1);
        Boolean bool2 = Boolean.TRUE;
        if (bool == bool2 || this.f6732c.get(10) == bool2) {
            return true;
        }
        return false;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        C3012do doVar = this.f6737h;
        if (doVar != null) {
            doVar.onAccuracyChanged(sensor, i);
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        C3012do doVar;
        if (this.f6735f && (doVar = this.f6737h) != null) {
            doVar.onSensorChanged(sensorEvent);
        }
    }

    /* renamed from: try  reason: not valid java name */
    public synchronized void m46181try() {
        this.f6735f = true;
    }

    /* renamed from: do */
    public Map<Integer, Boolean> mo38425do() {
        return this.f6732c;
    }

    /* renamed from: do */
    public void mo38426do(C3012do doVar) {
        this.f6737h = doVar;
    }
}
