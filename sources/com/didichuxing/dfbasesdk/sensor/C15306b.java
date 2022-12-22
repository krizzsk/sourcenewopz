package com.didichuxing.dfbasesdk.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.didi.security.wireless.ISecurityConf;
import com.didichuxing.dfbasesdk.sensor.SensorData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.didichuxing.dfbasesdk.sensor.b */
/* compiled from: SensorDataCollector */
class C15306b {

    /* renamed from: a */
    private static volatile C15306b f46666a;

    /* renamed from: f */
    private static Gson f46667f = new GsonBuilder().serializeSpecialFloatingPointValues().create();

    /* renamed from: b */
    private SensorManager f46668b;

    /* renamed from: c */
    private Map<SensorConfig, SensorEventListener> f46669c = new HashMap();

    /* renamed from: d */
    private Map<SensorConfig, SensorData> f46670d = new HashMap();

    /* renamed from: e */
    private boolean f46671e;

    private C15306b(Context context) {
        if (context != null) {
            this.f46668b = (SensorManager) context.getSystemService(ISecurityConf.KEY_SENSOR);
        }
    }

    /* renamed from: a */
    public static C15306b m33516a(Context context) {
        if (f46666a == null) {
            synchronized (C15306b.class) {
                if (f46666a == null) {
                    f46666a = new C15306b(context);
                }
            }
        }
        return f46666a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0073, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo115724a(com.didichuxing.dfbasesdk.sensor.SensorConfig r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 != 0) goto L_0x0005
            monitor-exit(r4)
            return
        L_0x0005:
            int r0 = r5.type     // Catch:{ all -> 0x0074 }
            boolean r0 = r4.m33520a((int) r0)     // Catch:{ all -> 0x0074 }
            if (r0 != 0) goto L_0x000f
            monitor-exit(r4)
            return
        L_0x000f:
            java.util.Map<com.didichuxing.dfbasesdk.sensor.SensorConfig, android.hardware.SensorEventListener> r0 = r4.f46669c     // Catch:{ all -> 0x0074 }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x0074 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0074 }
        L_0x0019:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0074 }
            if (r1 == 0) goto L_0x002d
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0074 }
            com.didichuxing.dfbasesdk.sensor.SensorConfig r1 = (com.didichuxing.dfbasesdk.sensor.SensorConfig) r1     // Catch:{ all -> 0x0074 }
            int r1 = r1.type     // Catch:{ all -> 0x0074 }
            int r2 = r5.type     // Catch:{ all -> 0x0074 }
            if (r1 != r2) goto L_0x0019
            monitor-exit(r4)
            return
        L_0x002d:
            com.didichuxing.dfbasesdk.sensor.SensorData r0 = new com.didichuxing.dfbasesdk.sensor.SensorData     // Catch:{ all -> 0x0074 }
            r0.<init>()     // Catch:{ all -> 0x0074 }
            int r1 = r5.type     // Catch:{ all -> 0x0074 }
            r0.type = r1     // Catch:{ all -> 0x0074 }
            java.util.Map<com.didichuxing.dfbasesdk.sensor.SensorConfig, com.didichuxing.dfbasesdk.sensor.SensorData> r1 = r4.f46670d     // Catch:{ all -> 0x0074 }
            r1.put(r5, r0)     // Catch:{ all -> 0x0074 }
            com.didichuxing.dfbasesdk.sensor.SensorDataCollector$1 r1 = new com.didichuxing.dfbasesdk.sensor.SensorDataCollector$1     // Catch:{ all -> 0x0074 }
            r1.<init>(r4, r5, r0)     // Catch:{ all -> 0x0074 }
            java.util.Map<com.didichuxing.dfbasesdk.sensor.SensorConfig, android.hardware.SensorEventListener> r2 = r4.f46669c     // Catch:{ all -> 0x0074 }
            r2.put(r5, r1)     // Catch:{ all -> 0x0074 }
            boolean r2 = r4.f46671e     // Catch:{ all -> 0x0074 }
            if (r2 == 0) goto L_0x0072
            android.hardware.SensorManager r2 = r4.f46668b     // Catch:{ all -> 0x0074 }
            if (r2 == 0) goto L_0x0072
            android.hardware.SensorManager r2 = r4.f46668b     // Catch:{ all -> 0x0074 }
            int r3 = r5.type     // Catch:{ all -> 0x0074 }
            android.hardware.Sensor r2 = r2.getDefaultSensor(r3)     // Catch:{ all -> 0x0074 }
            if (r2 != 0) goto L_0x005c
            r5 = 1
            r0.errCode = r5     // Catch:{ all -> 0x0074 }
            monitor-exit(r4)
            return
        L_0x005c:
            r4.m33518a((com.didichuxing.dfbasesdk.sensor.SensorData) r0, (android.hardware.Sensor) r2, (com.didichuxing.dfbasesdk.sensor.SensorConfig) r5)     // Catch:{ all -> 0x0074 }
            android.hardware.SensorManager r3 = r4.f46668b     // Catch:{ all -> 0x0074 }
            int r5 = r5.delay     // Catch:{ all -> 0x0074 }
            int r5 = r5 * 1000
            boolean r5 = r3.registerListener(r1, r2, r5)     // Catch:{ all -> 0x0074 }
            if (r5 == 0) goto L_0x006f
            r5 = 0
            r0.errCode = r5     // Catch:{ all -> 0x0074 }
            goto L_0x0072
        L_0x006f:
            r5 = 2
            r0.errCode = r5     // Catch:{ all -> 0x0074 }
        L_0x0072:
            monitor-exit(r4)
            return
        L_0x0074:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.sensor.C15306b.mo115724a(com.didichuxing.dfbasesdk.sensor.SensorConfig):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m33517a(SensorEvent sensorEvent, SensorConfig sensorConfig, SensorData sensorData) {
        if (sensorData.data == null) {
            sensorData.data = new LinkedList();
        }
        List<SensorData.Sample> list = sensorData.data;
        if (list.size() > 0) {
            if (sensorEvent.timestamp - list.get(list.size() - 1).time >= ((long) sensorConfig.delay) * 1000000) {
                if (list.size() >= sensorConfig.limit) {
                    C15305a.m33514a(list.remove(0));
                }
            } else {
                return;
            }
        }
        SensorData.Sample a = C15305a.m33513a(sensorEvent.values != null ? sensorEvent.values.length : 0);
        if (sensorEvent.values != null && sensorEvent.values.length > 0) {
            for (int i = 0; i < sensorEvent.values.length; i++) {
                a.values[i] = sensorEvent.values[i];
            }
        }
        a.time = sensorEvent.timestamp;
        list.add(a);
    }

    /* renamed from: a */
    private boolean m33520a(int i) {
        for (int i2 : SensorData.types) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public synchronized void mo115725a(List<SensorConfig> list) {
        if (list != null) {
            for (SensorConfig a : list) {
                mo115724a(a);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006f, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo115723a() {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.f46671e     // Catch:{ all -> 0x0070 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r7)
            return
        L_0x0007:
            r0 = 1
            r7.f46671e = r0     // Catch:{ all -> 0x0070 }
            java.util.Map<com.didichuxing.dfbasesdk.sensor.SensorConfig, android.hardware.SensorEventListener> r1 = r7.f46669c     // Catch:{ all -> 0x0070 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0070 }
            if (r1 != 0) goto L_0x006e
            java.util.Map<com.didichuxing.dfbasesdk.sensor.SensorConfig, android.hardware.SensorEventListener> r1 = r7.f46669c     // Catch:{ all -> 0x0070 }
            java.util.Set r1 = r1.entrySet()     // Catch:{ all -> 0x0070 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0070 }
        L_0x001c:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0070 }
            if (r2 == 0) goto L_0x006e
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0070 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x0070 }
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x0070 }
            com.didichuxing.dfbasesdk.sensor.SensorConfig r3 = (com.didichuxing.dfbasesdk.sensor.SensorConfig) r3     // Catch:{ all -> 0x0070 }
            java.util.Map<com.didichuxing.dfbasesdk.sensor.SensorConfig, com.didichuxing.dfbasesdk.sensor.SensorData> r4 = r7.f46670d     // Catch:{ all -> 0x0070 }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ all -> 0x0070 }
            com.didichuxing.dfbasesdk.sensor.SensorData r4 = (com.didichuxing.dfbasesdk.sensor.SensorData) r4     // Catch:{ all -> 0x0070 }
            android.hardware.SensorManager r5 = r7.f46668b     // Catch:{ all -> 0x0070 }
            if (r5 == 0) goto L_0x0043
            android.hardware.SensorManager r5 = r7.f46668b     // Catch:{ all -> 0x0070 }
            int r6 = r3.type     // Catch:{ all -> 0x0070 }
            android.hardware.Sensor r5 = r5.getDefaultSensor(r6)     // Catch:{ all -> 0x0070 }
            goto L_0x0044
        L_0x0043:
            r5 = 0
        L_0x0044:
            if (r5 != 0) goto L_0x004b
            if (r4 == 0) goto L_0x001c
            r4.errCode = r0     // Catch:{ all -> 0x0070 }
            goto L_0x001c
        L_0x004b:
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0070 }
            android.hardware.SensorEventListener r2 = (android.hardware.SensorEventListener) r2     // Catch:{ all -> 0x0070 }
            if (r4 == 0) goto L_0x0056
            r7.m33518a((com.didichuxing.dfbasesdk.sensor.SensorData) r4, (android.hardware.Sensor) r5, (com.didichuxing.dfbasesdk.sensor.SensorConfig) r3)     // Catch:{ all -> 0x0070 }
        L_0x0056:
            android.hardware.SensorManager r6 = r7.f46668b     // Catch:{ all -> 0x0070 }
            int r3 = r3.delay     // Catch:{ all -> 0x0070 }
            int r3 = r3 * 1000
            boolean r2 = r6.registerListener(r2, r5, r3)     // Catch:{ all -> 0x0070 }
            if (r2 == 0) goto L_0x0068
            if (r4 == 0) goto L_0x001c
            r2 = 0
            r4.errCode = r2     // Catch:{ all -> 0x0070 }
            goto L_0x001c
        L_0x0068:
            if (r4 == 0) goto L_0x001c
            r2 = 2
            r4.errCode = r2     // Catch:{ all -> 0x0070 }
            goto L_0x001c
        L_0x006e:
            monitor-exit(r7)
            return
        L_0x0070:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.sensor.C15306b.mo115723a():void");
    }

    /* renamed from: a */
    private void m33518a(SensorData sensorData, Sensor sensor, SensorConfig sensorConfig) {
        sensorData.type = sensor.getType();
        sensorData.delay = sensorConfig.delay;
        sensorData.limit = sensorConfig.limit;
        if (Build.VERSION.SDK_INT >= 21) {
            sensorData.reportingMode = sensor.getReportingMode();
        }
        sensorData.name = sensor.getName();
        sensorData.resolution = sensor.getResolution();
    }

    /* renamed from: b */
    public synchronized void mo115726b() {
        this.f46671e = false;
        if (this.f46668b != null && !this.f46669c.isEmpty()) {
            for (Map.Entry<SensorConfig, SensorEventListener> value : this.f46669c.entrySet()) {
                this.f46668b.unregisterListener((SensorEventListener) value.getValue());
            }
        }
    }

    /* renamed from: c */
    public synchronized String mo115727c() {
        try {
            Collection<SensorData> values = this.f46670d.values();
            if (values != null) {
                if (!values.isEmpty()) {
                    return f46667f.toJson((Object) values);
                }
            }
            return "no data, isCollectingData = " + this.f46671e;
        } catch (Throwable th) {
            return "Gson.toJson() exception: " + th;
        }
    }
}
