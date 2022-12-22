package p089public;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.didi.raven.config.RavenConfigKey;
import com.didi.raven.config.RavenKey;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didiglobal.domainservice.utils.DomainConstants;
import org.json.JSONObject;
import p093switch.C3106case;
import p093switch.C3128try;

/* renamed from: public.for */
/* compiled from: SensorData */
public class C3009for implements SensorEventListener {

    /* renamed from: a */
    private float[] f6722a = m3820c();

    /* renamed from: b */
    private float[] f6723b = m3820c();

    /* renamed from: c */
    private float[] f6724c = m3820c();

    /* renamed from: d */
    private float[] f6725d = m3820c();

    /* renamed from: e */
    private float[] f6726e = m3820c();

    /* renamed from: f */
    private Long f6727f;

    /* renamed from: g */
    private Long f6728g;

    /* renamed from: h */
    private boolean f6729h = true;

    /* renamed from: c */
    private static float[] m3820c() {
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo38420a() {
        return this.f6729h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public JSONObject mo38421b() {
        JSONObject jSONObject = new JSONObject();
        C3128try.m4080do(jSONObject, "r", (Object) C3128try.m4077do(this.f6726e));
        C3128try.m4080do(jSONObject, Constants.FILE_ANR_KEY, (Object) C3128try.m4077do(this.f6724c));
        C3128try.m4080do(jSONObject, "ag", (Object) C3128try.m4077do(this.f6725d));
        C3128try.m4080do(jSONObject, DomainConstants.DOMAIN_SUFFIX_G, (Object) C3128try.m4077do(this.f6722a));
        C3128try.m4080do(jSONObject, RavenConfigKey.PHONE, (Object) C3128try.m4077do(this.f6723b));
        C3128try.m4080do(jSONObject, "t0", (Object) this.f6727f);
        C3128try.m4080do(jSONObject, RavenKey.TYPE, (Object) this.f6728g);
        return jSONObject;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        Long valueOf = Long.valueOf(sensorEvent.timestamp);
        this.f6728g = valueOf;
        if (this.f6727f == null) {
            this.f6727f = valueOf;
        }
        int type = sensorEvent.sensor.getType();
        this.f6729h = false;
        if (type == 1) {
            this.f6725d = m3819a(sensorEvent.values);
        } else if (type != 4) {
            switch (type) {
                case 9:
                    this.f6722a = m3819a(sensorEvent.values);
                    return;
                case 10:
                    this.f6724c = m3819a(sensorEvent.values);
                    return;
                case 11:
                    this.f6723b = C3106case.m4011do(sensorEvent.values);
                    return;
                default:
                    return;
            }
        } else {
            float[] fArr = sensorEvent.values;
            float[] fArr2 = new float[fArr.length];
            this.f6726e = fArr2;
            System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
        }
    }

    /* renamed from: a */
    private float[] m3819a(float[] fArr) {
        float[] fArr2 = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = fArr[i] / 9.81f;
        }
        return fArr2;
    }
}
