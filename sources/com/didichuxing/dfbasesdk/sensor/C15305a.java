package com.didichuxing.dfbasesdk.sensor;

import com.didichuxing.dfbasesdk.sensor.SensorData;

/* renamed from: com.didichuxing.dfbasesdk.sensor.a */
/* compiled from: SamplePool */
class C15305a {

    /* renamed from: a */
    static SensorData.Sample[] f46665a = new SensorData.Sample[11];

    C15305a() {
    }

    /* renamed from: a */
    static SensorData.Sample m33513a(int i) {
        if (i >= f46665a.length) {
            return m33515b(i);
        }
        int max = Math.max(i, 0);
        SensorData.Sample[] sampleArr = f46665a;
        SensorData.Sample sample = sampleArr[max];
        if (sample == null) {
            return m33515b(i);
        }
        sampleArr[max] = sample.next;
        sample.next = null;
        return sample;
    }

    /* renamed from: a */
    static void m33514a(SensorData.Sample sample) {
        if (sample != null) {
            int length = sample.values != null ? sample.values.length : 0;
            SensorData.Sample[] sampleArr = f46665a;
            if (length < sampleArr.length) {
                SensorData.Sample sample2 = sampleArr[length];
                if (sample2 != null) {
                    sample.next = sample2;
                }
                f46665a[length] = sample;
            }
        }
    }

    /* renamed from: b */
    private static SensorData.Sample m33515b(int i) {
        SensorData.Sample sample = new SensorData.Sample();
        if (i > 0) {
            sample.values = new float[i];
        }
        return sample;
    }
}
