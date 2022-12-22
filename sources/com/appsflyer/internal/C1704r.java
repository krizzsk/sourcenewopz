package com.appsflyer.internal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.appsflyer.internal.r */
public final class C1704r implements SensorEventListener {

    /* renamed from: ı */
    private final String f2008;

    /* renamed from: Ɩ */
    private long f2009;

    /* renamed from: ǃ */
    private final int f2010;

    /* renamed from: ɩ */
    private final float[][] f2011 = new float[2][];

    /* renamed from: Ι */
    private final long[] f2012 = new long[2];

    /* renamed from: ι */
    private final String f2013;

    /* renamed from: І */
    private final int f2014;

    /* renamed from: і */
    private double f2015;

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public C1704r(int i, String str, String str2) {
        this.f2010 = i;
        this.f2008 = str == null ? "" : str;
        str2 = str2 == null ? "" : str2;
        this.f2013 = str2;
        this.f2014 = ((((i + 31) * 31) + this.f2008.hashCode()) * 31) + str2.hashCode();
    }

    /* renamed from: ı */
    private static double m1680(float[] fArr, float[] fArr2) {
        int min = Math.min(fArr.length, fArr2.length);
        double d = 0.0d;
        for (int i = 0; i < min; i++) {
            d += StrictMath.pow((double) (fArr[i] - fArr2[i]), 2.0d);
        }
        return Math.sqrt(d);
    }

    /* renamed from: Ι */
    private static boolean m1684(Sensor sensor) {
        return (sensor == null || sensor.getName() == null || sensor.getVendor() == null) ? false : true;
    }

    /* renamed from: ɩ */
    private static List<Float> m1682(float[] fArr) {
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float valueOf : fArr) {
            arrayList.add(Float.valueOf(valueOf));
        }
        return arrayList;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent != null && sensorEvent.values != null && m1684(sensorEvent.sensor)) {
            int type = sensorEvent.sensor.getType();
            String name = sensorEvent.sensor.getName();
            String vendor = sensorEvent.sensor.getVendor();
            long j = sensorEvent.timestamp;
            float[] fArr = sensorEvent.values;
            if (m1683(type, name, vendor)) {
                long currentTimeMillis = System.currentTimeMillis();
                float[][] fArr2 = this.f2011;
                float[] fArr3 = fArr2[0];
                if (fArr3 == null) {
                    fArr2[0] = Arrays.copyOf(fArr, fArr.length);
                    this.f2012[0] = currentTimeMillis;
                    return;
                }
                float[] fArr4 = fArr2[1];
                if (fArr4 == null) {
                    float[] copyOf = Arrays.copyOf(fArr, fArr.length);
                    this.f2011[1] = copyOf;
                    this.f2012[1] = currentTimeMillis;
                    this.f2015 = m1680(fArr3, copyOf);
                } else if (50000000 <= j - this.f2009) {
                    this.f2009 = j;
                    if (Arrays.equals(fArr4, fArr)) {
                        this.f2012[1] = currentTimeMillis;
                        return;
                    }
                    double r2 = m1680(fArr3, fArr);
                    if (r2 > this.f2015) {
                        this.f2011[1] = Arrays.copyOf(fArr, fArr.length);
                        this.f2012[1] = currentTimeMillis;
                        this.f2015 = r2;
                    }
                }
            }
        }
    }

    /* renamed from: ı */
    public final void mo16152(Map<C1704r, Map<String, Object>> map, boolean z) {
        if (m1681()) {
            map.put(this, m1685());
            if (z) {
                int length = this.f2011.length;
                for (int i = 0; i < length; i++) {
                    this.f2011[i] = null;
                }
                int length2 = this.f2012.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    this.f2012[i2] = 0;
                }
                this.f2015 = 0.0d;
                this.f2009 = 0;
            }
        } else if (!map.containsKey(this)) {
            map.put(this, m1685());
        }
    }

    /* renamed from: Ι */
    private boolean m1683(int i, String str, String str2) {
        return this.f2010 == i && this.f2008.equals(str) && this.f2013.equals(str2);
    }

    /* renamed from: ι */
    private Map<String, Object> m1685() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(7);
        concurrentHashMap.put("sT", Integer.valueOf(this.f2010));
        concurrentHashMap.put("sN", this.f2008);
        concurrentHashMap.put("sV", this.f2013);
        float[] fArr = this.f2011[0];
        if (fArr != null) {
            concurrentHashMap.put("sVS", m1682(fArr));
        }
        float[] fArr2 = this.f2011[1];
        if (fArr2 != null) {
            concurrentHashMap.put("sVE", m1682(fArr2));
        }
        return concurrentHashMap;
    }

    /* renamed from: ǃ */
    private boolean m1681() {
        return this.f2011[0] != null;
    }

    public final int hashCode() {
        return this.f2014;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1704r)) {
            return false;
        }
        C1704r rVar = (C1704r) obj;
        return m1683(rVar.f2010, rVar.f2008, rVar.f2013);
    }
}
