package com.appsflyer;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import com.appsflyer.internal.C1704r;
import com.didi.security.wireless.ISecurityConf;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class AFSensorManager {
    public static volatile AFSensorManager sInstance;

    /* renamed from: ȷ */
    private static final BitSet f1766 = new BitSet(6);

    /* renamed from: ɪ */
    private static final Handler f1767 = new Handler(Looper.getMainLooper());

    /* renamed from: ı */
    final Handler f1768;
    /* access modifiers changed from: package-private */

    /* renamed from: Ɩ */
    public int f1769 = 1;

    /* renamed from: ǃ */
    final Map<C1704r, C1704r> f1770 = new HashMap(f1766.size());
    /* access modifiers changed from: private */

    /* renamed from: ɨ */
    public final Runnable f1771 = new Runnable() {
        public final void run() {
            synchronized (AFSensorManager.this.f1776) {
                if (AFSensorManager.this.f1769 == 0) {
                    int unused = AFSensorManager.this.f1769 = 1;
                }
                AFSensorManager.this.f1768.postDelayed(AFSensorManager.this.f1778, ((long) AFSensorManager.this.f1769) * 500);
            }
        }
    };

    /* renamed from: ɩ */
    final SensorManager f1772;

    /* renamed from: ɹ */
    final Runnable f1773 = new Runnable() {
        public final void run() {
            synchronized (AFSensorManager.this.f1776) {
                AFSensorManager aFSensorManager = AFSensorManager.this;
                try {
                    for (Sensor next : aFSensorManager.f1772.getSensorList(-1)) {
                        if (AFSensorManager.m1520(next.getType())) {
                            C1704r rVar = new C1704r(next.getType(), next.getName(), next.getVendor());
                            if (!aFSensorManager.f1770.containsKey(rVar)) {
                                aFSensorManager.f1770.put(rVar, rVar);
                            }
                            aFSensorManager.f1772.registerListener(aFSensorManager.f1770.get(rVar), next, 0);
                        }
                    }
                } catch (Throwable unused) {
                }
                aFSensorManager.f1779 = true;
                AFSensorManager.this.f1768.postDelayed(AFSensorManager.this.f1771, 100);
                AFSensorManager.this.f1775 = true;
            }
        }
    };

    /* renamed from: ɾ */
    long f1774 = 0;

    /* renamed from: Ι */
    boolean f1775;

    /* renamed from: ι */
    final Object f1776 = new Object();

    /* renamed from: І */
    final Runnable f1777 = new Runnable() {
        public final void run() {
            synchronized (AFSensorManager.this.f1776) {
                if (AFSensorManager.this.f1775) {
                    AFSensorManager.this.f1768.removeCallbacks(AFSensorManager.this.f1773);
                    AFSensorManager.this.f1768.removeCallbacks(AFSensorManager.this.f1778);
                    AFSensorManager.this.mo15943();
                    AFSensorManager.this.f1775 = false;
                }
            }
        }
    };

    /* renamed from: і */
    final Runnable f1778 = new Runnable() {
        public final void run() {
            synchronized (AFSensorManager.this.f1776) {
                AFSensorManager.this.mo15943();
            }
        }
    };

    /* renamed from: Ӏ */
    boolean f1779;

    /* renamed from: ӏ */
    private final Map<C1704r, Map<String, Object>> f1780 = new ConcurrentHashMap(f1766.size());

    static {
        f1766.set(1);
        f1766.set(2);
        f1766.set(4);
    }

    private AFSensorManager(SensorManager sensorManager, Handler handler) {
        this.f1772 = sensorManager;
        this.f1768 = handler;
    }

    /* renamed from: ɩ */
    static AFSensorManager m1519(Context context) {
        if (sInstance != null) {
            return sInstance;
        }
        return m1516((SensorManager) context.getApplicationContext().getSystemService(ISecurityConf.KEY_SENSOR), f1767);
    }

    /* renamed from: ǃ */
    private static AFSensorManager m1516(SensorManager sensorManager, Handler handler) {
        if (sInstance == null) {
            synchronized (AFSensorManager.class) {
                if (sInstance == null) {
                    sInstance = new AFSensorManager(sensorManager, handler);
                }
            }
        }
        return sInstance;
    }

    /* renamed from: ɩ */
    static boolean m1520(int i) {
        return i >= 0 && f1766.get(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Ι */
    public final void mo15943() {
        try {
            if (!this.f1770.isEmpty()) {
                for (C1704r next : this.f1770.values()) {
                    this.f1772.unregisterListener(next);
                    next.mo16152(this.f1780, true);
                }
            }
        } catch (Throwable unused) {
        }
        this.f1769 = 0;
        this.f1779 = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ɩ */
    public final List<Map<String, Object>> mo15942() {
        for (C1704r r1 : this.f1770.values()) {
            r1.mo16152(this.f1780, true);
        }
        Map<C1704r, Map<String, Object>> map = this.f1780;
        if (map == null || map.isEmpty()) {
            return new CopyOnWriteArrayList(Collections.emptyList());
        }
        return new CopyOnWriteArrayList(this.f1780.values());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ι */
    public final List<Map<String, Object>> mo15944() {
        synchronized (this.f1776) {
            if (!this.f1770.isEmpty() && this.f1779) {
                for (C1704r r2 : this.f1770.values()) {
                    r2.mo16152(this.f1780, false);
                }
            }
            if (this.f1780.isEmpty()) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(Collections.emptyList());
                return copyOnWriteArrayList;
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList(this.f1780.values());
            return copyOnWriteArrayList2;
        }
    }
}
