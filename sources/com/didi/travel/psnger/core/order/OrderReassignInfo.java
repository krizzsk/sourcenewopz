package com.didi.travel.psnger.core.order;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OrderReassignInfo {

    /* renamed from: a */
    private static final String f44193a = OrderReassignInfo.class.getSimpleName();

    /* renamed from: b */
    private static final OrderReassignInfo f44194b = new OrderReassignInfo();

    /* renamed from: c */
    private Map<String, Set<String>> f44195c = new HashMap();

    public static OrderReassignInfo getInstance() {
        return f44194b;
    }

    private OrderReassignInfo() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void store(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x004b }
            if (r0 != 0) goto L_0x0049
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x004b }
            if (r0 != 0) goto L_0x0049
            boolean r0 = android.text.TextUtils.equals(r3, r4)     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x0014
            goto L_0x0049
        L_0x0014:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x004b }
            r0.<init>()     // Catch:{ all -> 0x004b }
            java.lang.String r1 = "store:originId = "
            r0.append(r1)     // Catch:{ all -> 0x004b }
            r0.append(r3)     // Catch:{ all -> 0x004b }
            java.lang.String r1 = ", reassignOId = "
            r0.append(r1)     // Catch:{ all -> 0x004b }
            r0.append(r4)     // Catch:{ all -> 0x004b }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x004b }
            com.didi.travel.psnger.utils.LogUtil.m31432fi(r0)     // Catch:{ all -> 0x004b }
            java.util.Map<java.lang.String, java.util.Set<java.lang.String>> r0 = r2.f44195c     // Catch:{ all -> 0x004b }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x004b }
            java.util.Set r0 = (java.util.Set) r0     // Catch:{ all -> 0x004b }
            if (r0 != 0) goto L_0x0044
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ all -> 0x004b }
            r0.<init>()     // Catch:{ all -> 0x004b }
            java.util.Map<java.lang.String, java.util.Set<java.lang.String>> r1 = r2.f44195c     // Catch:{ all -> 0x004b }
            r1.put(r3, r0)     // Catch:{ all -> 0x004b }
        L_0x0044:
            r0.add(r4)     // Catch:{ all -> 0x004b }
            monitor-exit(r2)
            return
        L_0x0049:
            monitor-exit(r2)
            return
        L_0x004b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.travel.psnger.core.order.OrderReassignInfo.store(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean isReassignOidMatched(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0027 }
            r1 = 0
            if (r0 != 0) goto L_0x0025
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0027 }
            if (r0 != 0) goto L_0x0025
            boolean r0 = android.text.TextUtils.equals(r3, r4)     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0015
            goto L_0x0025
        L_0x0015:
            java.util.Map<java.lang.String, java.util.Set<java.lang.String>> r0 = r2.f44195c     // Catch:{ all -> 0x0027 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0027 }
            java.util.Set r3 = (java.util.Set) r3     // Catch:{ all -> 0x0027 }
            if (r3 == 0) goto L_0x0023
            boolean r1 = r3.contains(r4)     // Catch:{ all -> 0x0027 }
        L_0x0023:
            monitor-exit(r2)
            return r1
        L_0x0025:
            monitor-exit(r2)
            return r1
        L_0x0027:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.travel.psnger.core.order.OrderReassignInfo.isReassignOidMatched(java.lang.String, java.lang.String):boolean");
    }
}
