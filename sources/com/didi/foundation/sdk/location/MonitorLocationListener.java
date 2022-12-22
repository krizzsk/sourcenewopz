package com.didi.foundation.sdk.location;

import com.didi.foundation.sdk.log.LogService;
import com.didi.sdk.logging.Logger;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonitorLocationListener implements DIDILocationListener {

    /* renamed from: a */
    private final List<DIDILocationListener> f21218a = new ArrayList();

    /* renamed from: b */
    private Logger f21219b = LogService.getLogger((Class<?>) MonitorLocationListener.class);

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int add(com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener r5) {
        /*
            r4 = this;
            r0 = -1
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.util.List<com.didichuxing.bigdata.dp.locsdk.DIDILocationListener> r1 = r4.f21218a
            monitor-enter(r1)
            java.util.List<com.didichuxing.bigdata.dp.locsdk.DIDILocationListener> r2 = r4.f21218a     // Catch:{ all -> 0x001d }
            boolean r2 = r2.contains(r5)     // Catch:{ all -> 0x001d }
            r3 = 0
            if (r2 == 0) goto L_0x0012
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            return r3
        L_0x0012:
            java.util.List<com.didichuxing.bigdata.dp.locsdk.DIDILocationListener> r2 = r4.f21218a     // Catch:{ all -> 0x001d }
            boolean r5 = r2.add(r5)     // Catch:{ all -> 0x001d }
            if (r5 == 0) goto L_0x001b
            r0 = 0
        L_0x001b:
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            return r0
        L_0x001d:
            r5 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.foundation.sdk.location.MonitorLocationListener.add(com.didichuxing.bigdata.dp.locsdk.DIDILocationListener):int");
    }

    public void onLocationChanged(DIDILocation dIDILocation) {
        m15596a();
        for (int i = 0; i < this.f21218a.size(); i++) {
            if (this.f21218a.get(i) != null) {
                this.f21218a.get(i).onLocationChanged(dIDILocation);
            }
        }
        if (dIDILocation != null) {
            Logger logger = this.f21219b;
            logger.warn("location" + dIDILocation.toString(), new Object[0]);
        }
    }

    public void onLocationError(int i, ErrInfo errInfo) {
        for (int i2 = 0; i2 < this.f21218a.size(); i2++) {
            if (this.f21218a.get(i2) != null) {
                this.f21218a.get(i2).onLocationError(i, errInfo);
            }
        }
    }

    public void onStatusUpdate(String str, int i, String str2) {
        for (int i2 = 0; i2 < this.f21218a.size(); i2++) {
            if (this.f21218a.get(i2) != null) {
                this.f21218a.get(i2).onStatusUpdate(str, i, str2);
            }
        }
    }

    public int remove(DIDILocationListener dIDILocationListener) {
        int i = -1;
        if (dIDILocationListener == null) {
            return -1;
        }
        synchronized (this.f21218a) {
            if (this.f21218a.remove(dIDILocationListener)) {
                i = 0;
            }
        }
        return i;
    }

    /* renamed from: a */
    private void m15596a() {
        synchronized (this.f21218a) {
            Logger logger = this.f21219b;
            logger.warn("dump DIDILocationListener is " + Arrays.toString(this.f21218a.toArray()), new Object[0]);
        }
    }
}
