package com.didi.dimina.container.secondparty.imghook;

import java.util.HashSet;

public class ImgHookConfig {

    /* renamed from: g */
    private static final boolean f17168g = true;

    /* renamed from: k */
    private static final String f17169k = "dimina_saga_big_img_report_config";

    /* renamed from: l */
    private static volatile ImgHookConfig f17170l;

    /* renamed from: a */
    String f17171a = "307_200";

    /* renamed from: b */
    String f17172b = "307_200";

    /* renamed from: c */
    String f17173c = "4G_5G_WIFI";

    /* renamed from: d */
    String f17174d = "^x-cache.+$";

    /* renamed from: e */
    int f17175e = 10;

    /* renamed from: f */
    int f17176f = 1;

    /* renamed from: h */
    private long f17177h = -1;

    /* renamed from: i */
    private long f17178i = -1;

    /* renamed from: j */
    private HashSet<Integer> f17179j = null;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo55676a() {
        long j = this.f17177h;
        if (j != -1) {
            return j;
        }
        try {
            long parseLong = Long.parseLong(this.f17171a.replace("_", ""));
            this.f17177h = parseLong;
            return parseLong;
        } catch (Throwable unused) {
            this.f17177h = 307200;
            return 307200;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public long mo55677b() {
        long j = this.f17178i;
        if (j != -1) {
            return j;
        }
        try {
            long parseLong = Long.parseLong(this.f17172b.replace("_", ""));
            this.f17178i = parseLong;
            return parseLong;
        } catch (Throwable unused) {
            this.f17178i = 307200;
            return 307200;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public HashSet<Integer> mo55678c() {
        HashSet<Integer> hashSet = this.f17179j;
        if (hashSet != null) {
            return hashSet;
        }
        try {
            String[] split = this.f17173c.split("_");
            this.f17179j = new HashSet<>();
            for (String str : split) {
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -2015525726) {
                    if (hashCode != 1621) {
                        if (hashCode != 1652) {
                            if (hashCode != 1683) {
                                if (hashCode != 1714) {
                                    if (hashCode == 2664213) {
                                        if (str.equals("WIFI")) {
                                            c = 4;
                                        }
                                    }
                                } else if (str.equals("5G")) {
                                    c = 3;
                                }
                            } else if (str.equals("4G")) {
                                c = 2;
                            }
                        } else if (str.equals("3G")) {
                            c = 1;
                        }
                    } else if (str.equals("2G")) {
                        c = 0;
                    }
                } else if (str.equals("MOBILE")) {
                    c = 5;
                }
                if (c == 0) {
                    this.f17179j.add(2);
                } else if (c == 1) {
                    this.f17179j.add(3);
                } else if (c == 2) {
                    this.f17179j.add(5);
                } else if (c == 3) {
                    this.f17179j.add(6);
                } else if (c == 4) {
                    this.f17179j.add(1);
                } else if (c == 5) {
                    this.f17179j.add(4);
                }
            }
            return this.f17179j;
        } catch (Throwable unused) {
            HashSet<Integer> hashSet2 = new HashSet<>();
            this.f17179j = hashSet2;
            hashSet2.add(5);
            this.f17179j.add(6);
            this.f17179j.add(1);
            return this.f17179j;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0098, code lost:
        return f17170l;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.didi.dimina.container.secondparty.imghook.ImgHookConfig getConfig() {
        /*
            com.didi.dimina.container.secondparty.imghook.ImgHookConfig r0 = f17170l
            if (r0 == 0) goto L_0x0007
            com.didi.dimina.container.secondparty.imghook.ImgHookConfig r0 = f17170l
            return r0
        L_0x0007:
            java.lang.Class<com.didi.dimina.container.secondparty.imghook.ImgLoadHooker> r0 = com.didi.dimina.container.secondparty.imghook.ImgLoadHooker.class
            monitor-enter(r0)
            com.didi.dimina.container.Dimina$Config r1 = com.didi.dimina.container.Dimina.getConfig()     // Catch:{ all -> 0x0099 }
            boolean r1 = r1.isDebug()     // Catch:{ all -> 0x0099 }
            if (r1 == 0) goto L_0x001f
            com.didi.dimina.container.secondparty.imghook.ImgHookConfig r1 = new com.didi.dimina.container.secondparty.imghook.ImgHookConfig     // Catch:{ all -> 0x0099 }
            r1.<init>()     // Catch:{ all -> 0x0099 }
            f17170l = r1     // Catch:{ all -> 0x0099 }
            com.didi.dimina.container.secondparty.imghook.ImgHookConfig r1 = f17170l     // Catch:{ all -> 0x0099 }
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            return r1
        L_0x001f:
            com.didi.dimina.container.secondparty.imghook.ImgHookConfig r1 = f17170l     // Catch:{ all -> 0x0099 }
            if (r1 != 0) goto L_0x0095
            java.lang.String r1 = "dimina_saga_big_img_report_config"
            com.didichuxing.apollo.sdk.IToggle r1 = com.didichuxing.apollo.sdk.Apollo.getToggle(r1)     // Catch:{ all -> 0x0099 }
            boolean r2 = r1.allow()     // Catch:{ all -> 0x0099 }
            if (r2 != 0) goto L_0x0032
            r1 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            return r1
        L_0x0032:
            com.didi.dimina.container.secondparty.imghook.ImgHookConfig r2 = new com.didi.dimina.container.secondparty.imghook.ImgHookConfig     // Catch:{ all -> 0x0099 }
            r2.<init>()     // Catch:{ all -> 0x0099 }
            com.didichuxing.apollo.sdk.IExperiment r3 = r1.getExperiment()     // Catch:{ all -> 0x0099 }
            java.lang.String r4 = "resolution"
            java.lang.String r5 = r2.f17171a     // Catch:{ all -> 0x0099 }
            java.lang.String r3 = r3.getStringParam(r4, r5)     // Catch:{ all -> 0x0099 }
            r2.f17171a = r3     // Catch:{ all -> 0x0099 }
            com.didichuxing.apollo.sdk.IExperiment r3 = r1.getExperiment()     // Catch:{ all -> 0x0099 }
            java.lang.String r4 = "byte_count"
            java.lang.String r5 = r2.f17172b     // Catch:{ all -> 0x0099 }
            java.lang.String r3 = r3.getStringParam(r4, r5)     // Catch:{ all -> 0x0099 }
            r2.f17172b = r3     // Catch:{ all -> 0x0099 }
            com.didichuxing.apollo.sdk.IExperiment r3 = r1.getExperiment()     // Catch:{ all -> 0x0099 }
            java.lang.String r4 = "net_types"
            java.lang.String r5 = r2.f17173c     // Catch:{ all -> 0x0099 }
            java.lang.String r3 = r3.getStringParam(r4, r5)     // Catch:{ all -> 0x0099 }
            r2.f17173c = r3     // Catch:{ all -> 0x0099 }
            com.didichuxing.apollo.sdk.IExperiment r3 = r1.getExperiment()     // Catch:{ all -> 0x0099 }
            java.lang.String r4 = "cdn_regx"
            java.lang.String r5 = r2.f17174d     // Catch:{ all -> 0x0099 }
            java.lang.String r3 = r3.getStringParam(r4, r5)     // Catch:{ all -> 0x0099 }
            r2.f17174d = r3     // Catch:{ all -> 0x0099 }
            com.didichuxing.apollo.sdk.IExperiment r3 = r1.getExperiment()     // Catch:{ all -> 0x0099 }
            java.lang.String r4 = "async_request_count"
            int r5 = r2.f17175e     // Catch:{ all -> 0x0099 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0099 }
            int r3 = r3.getIntParam(r4, r5)     // Catch:{ all -> 0x0099 }
            r2.f17175e = r3     // Catch:{ all -> 0x0099 }
            com.didichuxing.apollo.sdk.IExperiment r1 = r1.getExperiment()     // Catch:{ all -> 0x0099 }
            java.lang.String r3 = "async_gif"
            int r4 = r2.f17176f     // Catch:{ all -> 0x0099 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0099 }
            int r1 = r1.getIntParam(r3, r4)     // Catch:{ all -> 0x0099 }
            r2.f17176f = r1     // Catch:{ all -> 0x0099 }
            f17170l = r2     // Catch:{ all -> 0x0099 }
        L_0x0095:
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            com.didi.dimina.container.secondparty.imghook.ImgHookConfig r0 = f17170l
            return r0
        L_0x0099:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.imghook.ImgHookConfig.getConfig():com.didi.dimina.container.secondparty.imghook.ImgHookConfig");
    }

    public static String getConfigStr() {
        if (f17170l == null) {
            return "";
        }
        return "ImgHookConfig{resolution='" + f17170l.f17171a + '\'' + ", byteCount='" + f17170l.f17172b + '\'' + ", netTypes='" + f17170l.f17173c + '\'' + ", cdnRegx='" + f17170l.f17174d + '\'' + ", asyncRequestCount=" + f17170l.f17175e + ", asyncGif=" + f17170l.f17176f + '}';
    }
}
