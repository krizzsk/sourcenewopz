package com.didi.dqrutil.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalysisManager {

    /* renamed from: b */
    private static String f19112b;

    /* renamed from: c */
    private static String f19113c;

    /* renamed from: a */
    private AnalysisInter f19114a;

    /* renamed from: d */
    private List<String> f19115d;

    private static class InstanceHolder {
        public static AnalysisManager instance = new AnalysisManager();

        private InstanceHolder() {
        }
    }

    private AnalysisManager() {
        this.f19115d = new ArrayList();
    }

    public static void init(AnalysisInter analysisInter) {
        InstanceHolder.instance.f19114a = analysisInter;
        InstanceHolder.instance.f19115d = new ArrayList();
    }

    public static void setDecodeId(String str) {
        f19112b = str;
    }

    public static void setSessionId(String str) {
        f19113c = str;
    }

    public static String getDecodeId() {
        return f19112b;
    }

    public static String getSessionId() {
        return f19113c;
    }

    public static synchronized void report(String str) {
        synchronized (AnalysisManager.class) {
            InstanceHolder.instance.f19115d.add(str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a3, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void reportAll() {
        /*
            java.lang.Class<com.didi.dqrutil.analysis.AnalysisManager> r0 = com.didi.dqrutil.analysis.AnalysisManager.class
            monitor-enter(r0)
            com.didi.dqrutil.analysis.AnalysisManager r1 = com.didi.dqrutil.analysis.AnalysisManager.InstanceHolder.instance     // Catch:{ all -> 0x00a4 }
            java.util.List<java.lang.String> r1 = r1.f19115d     // Catch:{ all -> 0x00a4 }
            if (r1 != 0) goto L_0x000b
            monitor-exit(r0)
            return
        L_0x000b:
            com.didi.dqrutil.analysis.AnalysisManager r1 = com.didi.dqrutil.analysis.AnalysisManager.InstanceHolder.instance     // Catch:{ all -> 0x00a4 }
            java.util.List<java.lang.String> r1 = r1.f19115d     // Catch:{ all -> 0x00a4 }
            com.didi.dqrutil.analysis.AnalysisManager r2 = com.didi.dqrutil.analysis.AnalysisManager.InstanceHolder.instance     // Catch:{ all -> 0x00a4 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x00a4 }
            r3.<init>()     // Catch:{ all -> 0x00a4 }
            r2.f19115d = r3     // Catch:{ all -> 0x00a4 }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x00a4 }
            r3 = 18
            r2.<init>(r3)     // Catch:{ all -> 0x00a4 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00a4 }
        L_0x0023:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x00a4 }
            if (r3 == 0) goto L_0x004a
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x00a4 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00a4 }
            java.lang.Object r4 = r2.get(r3)     // Catch:{ all -> 0x00a4 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x00a4 }
            r5 = 1
            if (r4 != 0) goto L_0x003d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x00a4 }
            goto L_0x0046
        L_0x003d:
            int r4 = r4.intValue()     // Catch:{ all -> 0x00a4 }
            int r4 = r4 + r5
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00a4 }
        L_0x0046:
            r2.put(r3, r4)     // Catch:{ all -> 0x00a4 }
            goto L_0x0023
        L_0x004a:
            java.util.Set r1 = r2.entrySet()     // Catch:{ all -> 0x00a4 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00a4 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x00a4 }
            int r2 = r2.size()     // Catch:{ all -> 0x00a4 }
            r3.<init>(r2)     // Catch:{ all -> 0x00a4 }
        L_0x005b:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00a4 }
            if (r2 == 0) goto L_0x0084
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00a4 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00a4 }
            java.lang.Object r4 = r2.getKey()     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r5.<init>()     // Catch:{ all -> 0x00a4 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00a4 }
            r5.append(r2)     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = ""
            r5.append(r2)     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x00a4 }
            r3.put(r4, r2)     // Catch:{ all -> 0x00a4 }
            goto L_0x005b
        L_0x0084:
            java.lang.String r1 = "sessionId"
            java.lang.String r2 = f19113c     // Catch:{ all -> 0x00a4 }
            r3.put(r1, r2)     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = "decodeId"
            java.lang.String r2 = f19112b     // Catch:{ all -> 0x00a4 }
            r3.put(r1, r2)     // Catch:{ all -> 0x00a4 }
            com.didi.dqrutil.analysis.AnalysisManager r1 = com.didi.dqrutil.analysis.AnalysisManager.InstanceHolder.instance     // Catch:{ all -> 0x00a4 }
            com.didi.dqrutil.analysis.AnalysisInter r1 = r1.f19114a     // Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x00a2
            com.didi.dqrutil.analysis.AnalysisManager r1 = com.didi.dqrutil.analysis.AnalysisManager.InstanceHolder.instance     // Catch:{ all -> 0x00a4 }
            com.didi.dqrutil.analysis.AnalysisInter r1 = r1.f19114a     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = "dqr_scan_process"
            r1.report(r2, r3)     // Catch:{ all -> 0x00a4 }
        L_0x00a2:
            monitor-exit(r0)
            return
        L_0x00a4:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqrutil.analysis.AnalysisManager.reportAll():void");
    }

    public static Map<String, Object> getEventData() {
        int i;
        List<String> list = InstanceHolder.instance.f19115d;
        HashMap hashMap = new HashMap(18);
        try {
            for (String next : list) {
                Integer num = (Integer) hashMap.get(next);
                if (num == null) {
                    i = 1;
                } else {
                    i = Integer.valueOf(num.intValue() + 1);
                }
                hashMap.put(next, i);
            }
            HashMap hashMap2 = new HashMap(hashMap.size());
            for (Map.Entry entry : hashMap.entrySet()) {
                Object key = entry.getKey();
                hashMap2.put(key, entry.getValue() + "");
            }
            hashMap2.put("sessionId", f19113c);
            hashMap2.put("decodeId", f19112b);
            return hashMap2;
        } catch (Exception unused) {
            return new HashMap();
        }
    }
}
