package com.didi.sdk.event.service;

import java.util.HashMap;

public class BusinessServiceManager {

    /* renamed from: a */
    private static final HashMap<String, BusinessService> f35881a = new HashMap<>();

    /* renamed from: b */
    private static final HashMap<String, Class<? extends BusinessService>> f35882b = new HashMap<>();

    public static void registerService(String str, Class<? extends BusinessService> cls) {
        synchronized (f35882b) {
            f35882b.put(str, cls);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0 = f35882b.get(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        if (r0 != null) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
        r0 = (com.didi.sdk.event.service.BusinessService) com.didi.sdk.store.util.SpiUtil.makeInstance((java.lang.ClassLoader) null, r0.getName(), com.didi.sdk.event.service.BusinessService.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002c, code lost:
        if (r0 != null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
        r2 = f35881a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        f35881a.put(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0038, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003a, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        r1 = f35882b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        monitor-enter(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.didi.sdk.event.service.BusinessService getService(java.lang.String r4) {
        /*
            java.util.HashMap<java.lang.String, com.didi.sdk.event.service.BusinessService> r0 = f35881a
            monitor-enter(r0)
            java.util.HashMap<java.lang.String, com.didi.sdk.event.service.BusinessService> r1 = f35881a     // Catch:{ all -> 0x0041 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0041 }
            com.didi.sdk.event.service.BusinessService r1 = (com.didi.sdk.event.service.BusinessService) r1     // Catch:{ all -> 0x0041 }
            if (r1 == 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            return r1
        L_0x000f:
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            java.util.HashMap<java.lang.String, java.lang.Class<? extends com.didi.sdk.event.service.BusinessService>> r1 = f35882b
            monitor-enter(r1)
            java.util.HashMap<java.lang.String, java.lang.Class<? extends com.didi.sdk.event.service.BusinessService>> r0 = f35882b     // Catch:{ all -> 0x003e }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x003e }
            java.lang.Class r0 = (java.lang.Class) r0     // Catch:{ all -> 0x003e }
            r2 = 0
            if (r0 != 0) goto L_0x0020
            monitor-exit(r1)     // Catch:{ all -> 0x003e }
            return r2
        L_0x0020:
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x003e }
            java.lang.Class<com.didi.sdk.event.service.BusinessService> r3 = com.didi.sdk.event.service.BusinessService.class
            java.lang.Object r0 = com.didi.sdk.store.util.SpiUtil.makeInstance(r2, r0, r3)     // Catch:{ all -> 0x003e }
            com.didi.sdk.event.service.BusinessService r0 = (com.didi.sdk.event.service.BusinessService) r0     // Catch:{ all -> 0x003e }
            if (r0 != 0) goto L_0x0030
            monitor-exit(r1)     // Catch:{ all -> 0x003e }
            return r2
        L_0x0030:
            java.util.HashMap<java.lang.String, com.didi.sdk.event.service.BusinessService> r2 = f35881a     // Catch:{ all -> 0x003e }
            monitor-enter(r2)     // Catch:{ all -> 0x003e }
            java.util.HashMap<java.lang.String, com.didi.sdk.event.service.BusinessService> r3 = f35881a     // Catch:{ all -> 0x003b }
            r3.put(r4, r0)     // Catch:{ all -> 0x003b }
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            monitor-exit(r1)     // Catch:{ all -> 0x003e }
            return r0
        L_0x003b:
            r4 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            throw r4     // Catch:{ all -> 0x003e }
        L_0x003e:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x003e }
            throw r4
        L_0x0041:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.event.service.BusinessServiceManager.getService(java.lang.String):com.didi.sdk.event.service.BusinessService");
    }
}
