package com.didichuxing.bigdata.p173dp.locsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiManager;
import android.util.Log;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.SensorMonitor */
public class SensorMonitor {

    /* renamed from: c */
    private static volatile SensorMonitor f45718c = null;

    /* renamed from: p */
    private static final long f45719p = 20000;

    /* renamed from: a */
    BroadcastReceiver f45720a = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction().equals("android.net.wifi.supplicant.STATE_CHANGE")) {
                SupplicantState supplicantState = (SupplicantState) intent.getParcelableExtra("newState");
                if (supplicantState == null || !supplicantState.equals(SupplicantState.COMPLETED)) {
                    boolean unused = SensorMonitor.this.f45727i = false;
                } else {
                    boolean unused2 = SensorMonitor.this.f45727i = true;
                }
            }
        }
    };

    /* renamed from: b */
    SensorEventListener f45721b = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            long currentTimeMillis = System.currentTimeMillis();
            if (sensorEvent.sensor.getType() == 5) {
                long unused = SensorMonitor.this.f45730l = currentTimeMillis;
                float unused2 = SensorMonitor.this.f45728j = sensorEvent.values[0];
            }
            if (sensorEvent.sensor.getType() == 6) {
                long unused3 = SensorMonitor.this.f45731m = currentTimeMillis;
                float unused4 = SensorMonitor.this.f45729k = sensorEvent.values[0];
            }
        }
    };

    /* renamed from: d */
    private Context f45722d;

    /* renamed from: e */
    private WifiManager f45723e;

    /* renamed from: f */
    private SensorManager f45724f;

    /* renamed from: g */
    private Sensor f45725g;

    /* renamed from: h */
    private Sensor f45726h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f45727i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public float f45728j = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public float f45729k = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public long f45730l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public long f45731m = 0;

    /* renamed from: n */
    private long f45732n = 0;

    /* renamed from: o */
    private long f45733o = 0;

    private SensorMonitor(Context context) {
        this.f45722d = context;
        this.f45723e = (WifiManager) context.getSystemService("wifi");
    }

    public static SensorMonitor getInstance(Context context) {
        if (context == null) {
            return null;
        }
        if (f45718c == null) {
            synchronized (SensorMonitor.class) {
                if (f45718c == null) {
                    f45718c = new SensorMonitor(context);
                }
            }
        }
        return f45718c;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:(4:3|4|5|6)|11|13|14|15|16|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0045 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start() {
        /*
            r4 = this;
            android.content.Context r0 = r4.f45722d
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.content.IntentFilter r0 = new android.content.IntentFilter     // Catch:{ Exception -> 0x001f }
            r0.<init>()     // Catch:{ Exception -> 0x001f }
            java.lang.String r1 = "android.net.wifi.supplicant.STATE_CHANGE"
            r0.addAction(r1)     // Catch:{ Exception -> 0x001f }
            android.content.Context r1 = r4.f45722d     // Catch:{ Exception -> 0x001f }
            android.content.BroadcastReceiver r2 = r4.f45720a     // Catch:{ Exception -> 0x001f }
            r1.registerReceiver(r2, r0)     // Catch:{ Exception -> 0x0017 }
            goto L_0x001f
        L_0x0017:
            r0 = move-exception
            java.lang.String r1 = "Context"
            java.lang.String r2 = "registerReceiver"
            android.util.Log.d(r1, r2, r0)     // Catch:{ Exception -> 0x001f }
        L_0x001f:
            android.content.Context r0 = r4.f45722d
            java.lang.String r1 = "sensor"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.hardware.SensorManager r0 = (android.hardware.SensorManager) r0
            r4.f45724f = r0
            r1 = 5
            android.hardware.Sensor r0 = r0.getDefaultSensor(r1)
            r4.f45725g = r0
            android.hardware.SensorManager r0 = r4.f45724f
            r1 = 6
            android.hardware.Sensor r0 = r0.getDefaultSensor(r1)
            r4.f45726h = r0
            r0 = 3
            android.hardware.SensorManager r1 = r4.f45724f     // Catch:{ Exception -> 0x0045 }
            android.hardware.SensorEventListener r2 = r4.f45721b     // Catch:{ Exception -> 0x0045 }
            android.hardware.Sensor r3 = r4.f45725g     // Catch:{ Exception -> 0x0045 }
            r1.registerListener(r2, r3, r0)     // Catch:{ Exception -> 0x0045 }
        L_0x0045:
            android.hardware.SensorManager r1 = r4.f45724f     // Catch:{ Exception -> 0x004e }
            android.hardware.SensorEventListener r2 = r4.f45721b     // Catch:{ Exception -> 0x004e }
            android.hardware.Sensor r3 = r4.f45726h     // Catch:{ Exception -> 0x004e }
            r1.registerListener(r2, r3, r0)     // Catch:{ Exception -> 0x004e }
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p173dp.locsdk.SensorMonitor.start():void");
    }

    public void stop() {
        if (this.f45722d != null) {
            this.f45724f.unregisterListener(this.f45721b);
            try {
                try {
                    this.f45722d.unregisterReceiver(this.f45720a);
                } catch (Exception e) {
                    Log.d("Context", "unregisterReceiver", e);
                }
            } catch (Exception unused) {
            }
        }
    }

    public boolean isWifiEnabled() {
        WifiManager wifiManager = this.f45723e;
        if (wifiManager == null) {
            return false;
        }
        try {
            return wifiManager.isWifiEnabled();
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isWifiAllowScan() {
        if (this.f45723e == null || Utils.getSdk() <= 17) {
            return false;
        }
        try {
            return String.valueOf(Reflect.invokeMethod(this.f45723e, "isScanAlwaysAvailable", new Object[0])).equals("true");
        } catch (Exception e) {
            OmegaUtils.trackReflectError(e, "isWifiAllowScan");
            return false;
        }
    }

    public boolean isGpsEnabled() {
        LocationManager locationManager = (LocationManager) this.f45722d.getSystemService("location");
        if (locationManager == null) {
            return true;
        }
        try {
            return locationManager.isProviderEnabled("gps");
        } catch (Throwable th) {
            DLog.m32737d(th.toString());
            return true;
        }
    }

    public boolean isWifiConnected() {
        return this.f45727i;
    }

    public int getAirPressure() {
        if (System.currentTimeMillis() - this.f45731m > 20000) {
            return 0;
        }
        return (int) (this.f45729k * 100.0f);
    }

    public int getLight() {
        if (System.currentTimeMillis() - this.f45730l > 20000) {
            return 0;
        }
        return (int) this.f45728j;
    }

    public void setGpsFixedTimestamp(long j) {
        long j2 = this.f45732n;
        if (j2 != 0) {
            this.f45733o = j - j2;
        }
        this.f45732n = j;
    }

    public int getGpsFixedInterval() {
        if (System.currentTimeMillis() - this.f45732n > 20000) {
            return 0;
        }
        return (int) this.f45733o;
    }
}
