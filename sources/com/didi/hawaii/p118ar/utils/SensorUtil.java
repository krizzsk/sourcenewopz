package com.didi.hawaii.p118ar.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.didi.security.wireless.ISecurityConf;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.didi.hawaii.ar.utils.SensorUtil */
public class SensorUtil implements SensorEventListener {
    public static final float MAX_NAVIGATION_ANGLE = 115.0f;
    public static final float MIN_NAVIGATION_ANGLE = 65.0f;

    /* renamed from: b */
    private static SensorUtil f23336b = null;

    /* renamed from: h */
    private static ArrayList<Float> f23337h = null;

    /* renamed from: i */
    private static boolean f23338i = false;
    public static boolean isNavigationPitchAviable = true;

    /* renamed from: j */
    private static int f23339j = 15;

    /* renamed from: k */
    private static final int f23340k = 200;

    /* renamed from: a */
    private float[] f23341a = new float[9];

    /* renamed from: c */
    private SensorManager f23342c;

    /* renamed from: d */
    private Sensor f23343d;

    /* renamed from: e */
    private Sensor f23344e;

    /* renamed from: f */
    private Sensor f23345f;

    /* renamed from: g */
    private boolean f23346g = true;

    /* renamed from: l */
    private float f23347l = -1.0f;

    /* renamed from: m */
    private SensorUtilListener f23348m = null;

    /* renamed from: n */
    private long f23349n = 0;

    /* renamed from: o */
    private PostureChangeListener f23350o;

    /* renamed from: com.didi.hawaii.ar.utils.SensorUtil$PostureChangeListener */
    public interface PostureChangeListener {
        void onPitchAviableChange(boolean z);

        void onStableOrMoveHanppen(boolean z);
    }

    /* renamed from: com.didi.hawaii.ar.utils.SensorUtil$SensorUtilListener */
    public interface SensorUtilListener {
        void onOrientationChanged(float f, float f2, float f3, float[] fArr);
    }

    /* renamed from: a */
    private static float m16719a(float f) {
        return f < 0.0f ? f + 360.0f : f > 360.0f ? f % 360.0f : f;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public static synchronized SensorUtil getInstance() {
        SensorUtil sensorUtil;
        synchronized (SensorUtil.class) {
            if (f23336b == null) {
                f23336b = new SensorUtil();
            }
            sensorUtil = f23336b;
        }
        return sensorUtil;
    }

    public void init(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService(ISecurityConf.KEY_SENSOR);
        this.f23342c = sensorManager;
        this.f23343d = sensorManager.getDefaultSensor(11);
        this.f23344e = this.f23342c.getDefaultSensor(3);
        this.f23345f = this.f23342c.getDefaultSensor(6);
    }

    public void startListenRotationVector() {
        Sensor sensor = this.f23343d;
        if (sensor != null) {
            this.f23342c.registerListener(this, sensor, 3);
        }
        Sensor sensor2 = this.f23344e;
        if (sensor2 != null) {
            this.f23342c.registerListener(this, sensor2, 3);
        }
        Sensor sensor3 = this.f23345f;
        if (sensor3 != null) {
            this.f23342c.registerListener(this, sensor3, 200000);
        }
    }

    public void stopListenRotationVector() {
        this.f23342c.unregisterListener(this);
    }

    public void startZGSensor(SensorUtilListener sensorUtilListener) {
        this.f23348m = sensorUtilListener;
        Sensor sensor = this.f23343d;
        if (sensor != null) {
            this.f23342c.registerListener(this, sensor, 1);
        }
    }

    public void stopZGSensor() {
        Sensor sensor = this.f23343d;
        if (sensor != null) {
            this.f23342c.unregisterListener(this, sensor);
        }
        this.f23348m = null;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 11) {
            SensorManager.getRotationMatrixFromVector(this.f23341a, sensorEvent.values);
            if (this.f23348m != null) {
                float[] fArr = new float[4];
                SensorManager.getQuaternionFromVector(fArr, sensorEvent.values);
                float[] fArr2 = new float[3];
                SensorManager.getOrientation(this.f23341a, fArr2);
                float degrees = (float) Math.toDegrees((double) fArr2[0]);
                float[] fArr3 = {fArr[1], fArr[2], fArr[3], fArr[0]};
                this.f23348m.onOrientationChanged((float) Math.toDegrees((double) fArr2[1]), (float) Math.toDegrees((double) fArr2[2]), degrees, fArr3);
            }
        } else if (sensorEvent.sensor.getType() == 3) {
            if ((sensorEvent.values[1] < (-ARNavGlobal.locationParam.maxAngle) || sensorEvent.values[1] > (-ARNavGlobal.locationParam.minAngle)) && (sensorEvent.values[1] < ARNavGlobal.locationParam.maxAngle || sensorEvent.values[1] > ARNavGlobal.locationParam.minAngle)) {
                this.f23346g = false;
            } else {
                this.f23346g = true;
            }
            if ((sensorEvent.values[1] < -115.0f || sensorEvent.values[1] > -65.0f) && (sensorEvent.values[1] < 115.0f || sensorEvent.values[1] > 65.0f)) {
                isNavigationPitchAviable = false;
            } else {
                isNavigationPitchAviable = true;
            }
            PostureChangeListener postureChangeListener = this.f23350o;
            if (postureChangeListener != null) {
                postureChangeListener.onPitchAviableChange(this.f23346g);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f23349n >= 200) {
                if (f23338i) {
                    f23337h.add(Float.valueOf(sensorEvent.values[0]));
                    if (f23337h.size() > f23339j) {
                        f23337h.remove(0);
                        m16720a();
                    }
                }
                this.f23349n = currentTimeMillis;
            }
        } else if (sensorEvent.sensor.getType() == 6) {
            this.f23347l = sensorEvent.values[0];
        }
    }

    public float[] getRotationMatrix3D() {
        return this.f23341a;
    }

    public float GetPressureData() {
        return this.f23347l;
    }

    public void setPostureChangeListener(PostureChangeListener postureChangeListener) {
        this.f23350o = postureChangeListener;
    }

    public void startMoveStatusCheck() {
        ArrayList<Float> arrayList = f23337h;
        if (arrayList != null) {
            arrayList.clear();
        }
        f23339j = (ARNavGlobal.locationParam.maxMotionlessTime * 1000) / 200;
        f23337h = new ArrayList<>(f23339j + 1);
        f23338i = true;
    }

    /* renamed from: a */
    private void m16720a() {
        float f = ARNavGlobal.locationParam.maxMotionlessAngle;
        boolean z = false;
        float floatValue = f23337h.get(0).floatValue() - f;
        float floatValue2 = f23337h.get(0).floatValue() + f;
        Iterator<Float> it = f23337h.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (m16721a(it.next().floatValue(), floatValue, floatValue2)) {
                i++;
            }
        }
        if (i < f23337h.size()) {
            z = true;
        }
        PostureChangeListener postureChangeListener = this.f23350o;
        if (postureChangeListener != null) {
            postureChangeListener.onStableOrMoveHanppen(z);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m16721a(float r2, float r3, float r4) {
        /*
            float r2 = m16719a(r2)
            float r3 = m16719a(r3)
            float r4 = m16719a(r4)
            r0 = 1
            int r1 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x001a
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x002e
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x002e
            goto L_0x002f
        L_0x001a:
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0024
            r3 = 1135869952(0x43b40000, float:360.0)
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x002f
        L_0x0024:
            r3 = 0
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x002e
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p118ar.utils.SensorUtil.m16721a(float, float, float):boolean");
    }
}
