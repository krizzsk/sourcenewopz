package com.didichuxing.swarm.launcher;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.swarm.toolkit.TimeService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.launch.Framework;

public class TimeServiceImpl implements TimeService {

    /* renamed from: a */
    private static final String f49174a = "TimeServiceImpl";

    /* renamed from: b */
    private static final int f49175b = 0;

    /* renamed from: c */
    private static final long f49176c = 20000;

    /* renamed from: d */
    private static final String f49177d = "2.android.pool.ntp.org";

    /* renamed from: e */
    private static final String f49178e = "ntp_server";

    /* renamed from: f */
    private static final String f49179f = "ntp_timeout";

    /* renamed from: g */
    private static final String f49180g = "file_time_difference";

    /* renamed from: h */
    private static final String f49181h = "key_time_difference";
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static volatile boolean f49182j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static volatile Boolean f49183k = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Framework f49184i;

    /* renamed from: l */
    private Application.ActivityLifecycleCallbacks f49185l = new DefActivityCallbackImpl() {
        public void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            if (TimeServiceImpl.f49182j) {
                TimeServiceImpl.this.m35464d();
            } else {
                TimeServiceImpl.this.m35465e();
            }
        }
    };

    TimeServiceImpl(Framework framework) {
        this.f49184i = framework;
        m35463c();
    }

    /* renamed from: c */
    private void m35463c() {
        if (!f49182j) {
            BundleContext bundleContext = this.f49184i.getBundleContext();
            ((Application) bundleContext.getService(bundleContext.getServiceReference(Application.class))).registerActivityLifecycleCallbacks(this.f49185l);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m35464d() {
        BundleContext bundleContext = this.f49184i.getBundleContext();
        ((Application) bundleContext.getService(bundleContext.getServiceReference(Application.class))).unregisterActivityLifecycleCallbacks(this.f49185l);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m35465e() {
        try {
            if (!f49182j) {
                SystemUtils.startThread(new Thread(new Runnable() {
                    /* JADX INFO: finally extract failed */
                    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003a, code lost:
                        if (android.os.Build.VERSION.SDK_INT < 17) goto L_0x0076;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
                        r3 = r1.getContentResolver();
                        r4 = android.provider.Settings.Global.getString(r3, com.didichuxing.swarm.launcher.TimeServiceImpl.f49178e);
                        r6 = android.provider.Settings.Global.getLong(r3, com.didichuxing.swarm.launcher.TimeServiceImpl.f49179f, 20000);
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004c, code lost:
                        if (r4 == null) goto L_0x0050;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004e, code lost:
                        r3 = r4;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0050, code lost:
                        r3 = com.didichuxing.swarm.launcher.TimeServiceImpl.f49177d;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
                        com.didi.sdk.apm.SystemUtils.log(3, com.didichuxing.swarm.launcher.TimeServiceImpl.f49174a, "server: " + r3 + ", secureServer: " + r4, (java.lang.Throwable) null, "com.didichuxing.swarm.launcher.TimeServiceImpl$2", 138);
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0076, code lost:
                        r4 = new com.didichuxing.swarm.launcher.SntpClient();
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0081, code lost:
                        if (r4.requestTime(r3, (int) r6) == false) goto L_0x0101;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0083, code lost:
                        r6 = (r4.getNtpTime() + android.os.SystemClock.elapsedRealtime()) - r4.getNtpTimeReference();
                        r3 = java.lang.System.currentTimeMillis();
                        r8 = r6 - r3;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
                        com.didi.sdk.apm.SystemUtils.log(3, com.didichuxing.swarm.launcher.TimeServiceImpl.f49174a, "networkTime: " + new java.util.Date(r6).toString() + ", localTime: " + new java.util.Date(r3).toString(), (java.lang.Throwable) null, "com.didichuxing.swarm.launcher.TimeServiceImpl$2", 150);
                        r3 = new java.lang.StringBuilder();
                        r3.append("differenceInMS: ");
                        r3.append(r8);
                        com.didi.sdk.apm.SystemUtils.log(3, com.didichuxing.swarm.launcher.TimeServiceImpl.f49174a, r3.toString(), (java.lang.Throwable) null, "com.didichuxing.swarm.launcher.TimeServiceImpl$2", 151);
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:30:0x010e, code lost:
                        r0 = th;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
                        r1 = com.didichuxing.swarm.launcher.TimeServiceImpl.m35462c(r22.this$0).getBundleContext();
                        r1 = (android.app.Application) r1.getService(r1.getServiceReference(android.app.Application.class));
                        r3 = com.didichuxing.swarm.launcher.TimeServiceImpl.f49177d;
                        r6 = 20000;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r22 = this;
                            java.lang.Boolean r1 = com.didichuxing.swarm.launcher.TimeServiceImpl.f49183k
                            monitor-enter(r1)
                            java.lang.Boolean r0 = com.didichuxing.swarm.launcher.TimeServiceImpl.f49183k     // Catch:{ all -> 0x0109 }
                            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0109 }
                            if (r0 == 0) goto L_0x0011
                            monitor-exit(r1)     // Catch:{ all -> 0x0109 }
                            return
                        L_0x0011:
                            r0 = 1
                            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0109 }
                            java.lang.Boolean unused = com.didichuxing.swarm.launcher.TimeServiceImpl.f49183k = r2     // Catch:{ all -> 0x0109 }
                            monitor-exit(r1)     // Catch:{ all -> 0x0109 }
                            r2 = r22
                            com.didichuxing.swarm.launcher.TimeServiceImpl r1 = com.didichuxing.swarm.launcher.TimeServiceImpl.this
                            org.osgi.framework.launch.Framework r1 = r1.f49184i
                            org.osgi.framework.BundleContext r1 = r1.getBundleContext()
                            java.lang.Class<android.app.Application> r3 = android.app.Application.class
                            org.osgi.framework.ServiceReference r3 = r1.getServiceReference(r3)
                            java.lang.Object r1 = r1.getService(r3)
                            android.app.Application r1 = (android.app.Application) r1
                            java.lang.String r3 = "2.android.pool.ntp.org"
                            int r4 = android.os.Build.VERSION.SDK_INT
                            r5 = 17
                            r6 = 20000(0x4e20, double:9.8813E-320)
                            if (r4 < r5) goto L_0x0076
                            android.content.ContentResolver r3 = r1.getContentResolver()
                            java.lang.String r4 = "ntp_server"
                            java.lang.String r4 = android.provider.Settings.Global.getString(r3, r4)
                            java.lang.String r5 = "ntp_timeout"
                            long r6 = android.provider.Settings.Global.getLong(r3, r5, r6)
                            if (r4 == 0) goto L_0x0050
                            r3 = r4
                            goto L_0x0052
                        L_0x0050:
                            java.lang.String r3 = "2.android.pool.ntp.org"
                        L_0x0052:
                            java.lang.String r9 = "TimeServiceImpl"
                            java.lang.StringBuilder r5 = new java.lang.StringBuilder
                            r5.<init>()
                            java.lang.String r8 = "server: "
                            r5.append(r8)
                            r5.append(r3)
                            java.lang.String r8 = ", secureServer: "
                            r5.append(r8)
                            r5.append(r4)
                            java.lang.String r10 = r5.toString()
                            r8 = 3
                            r11 = 0
                            java.lang.String r12 = "com.didichuxing.swarm.launcher.TimeServiceImpl$2"
                            r13 = 138(0x8a, float:1.93E-43)
                            com.didi.sdk.apm.SystemUtils.log(r8, r9, r10, r11, r12, r13)
                        L_0x0076:
                            com.didichuxing.swarm.launcher.SntpClient r4 = new com.didichuxing.swarm.launcher.SntpClient
                            r4.<init>()
                            int r5 = (int) r6
                            boolean r3 = r4.requestTime(r3, r5)
                            r5 = 0
                            if (r3 == 0) goto L_0x0101
                            long r6 = r4.getNtpTime()
                            long r8 = android.os.SystemClock.elapsedRealtime()
                            long r6 = r6 + r8
                            long r3 = r4.getNtpTimeReference()
                            long r6 = r6 - r3
                            long r3 = java.lang.System.currentTimeMillis()
                            long r8 = r6 - r3
                            java.lang.String r11 = "TimeServiceImpl"
                            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x00eb }
                            r10.<init>()     // Catch:{ AssertionError -> 0x00eb }
                            java.lang.String r12 = "networkTime: "
                            r10.append(r12)     // Catch:{ AssertionError -> 0x00eb }
                            java.util.Date r12 = new java.util.Date     // Catch:{ AssertionError -> 0x00eb }
                            r12.<init>(r6)     // Catch:{ AssertionError -> 0x00eb }
                            java.lang.String r6 = r12.toString()     // Catch:{ AssertionError -> 0x00eb }
                            r10.append(r6)     // Catch:{ AssertionError -> 0x00eb }
                            java.lang.String r6 = ", localTime: "
                            r10.append(r6)     // Catch:{ AssertionError -> 0x00eb }
                            java.util.Date r6 = new java.util.Date     // Catch:{ AssertionError -> 0x00eb }
                            r6.<init>(r3)     // Catch:{ AssertionError -> 0x00eb }
                            java.lang.String r3 = r6.toString()     // Catch:{ AssertionError -> 0x00eb }
                            r10.append(r3)     // Catch:{ AssertionError -> 0x00eb }
                            java.lang.String r12 = r10.toString()     // Catch:{ AssertionError -> 0x00eb }
                            r10 = 3
                            r13 = 0
                            java.lang.String r14 = "com.didichuxing.swarm.launcher.TimeServiceImpl$2"
                            r15 = 150(0x96, float:2.1E-43)
                            com.didi.sdk.apm.SystemUtils.log(r10, r11, r12, r13, r14, r15)     // Catch:{ AssertionError -> 0x00eb }
                            java.lang.String r17 = "TimeServiceImpl"
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x00eb }
                            r3.<init>()     // Catch:{ AssertionError -> 0x00eb }
                            java.lang.String r4 = "differenceInMS: "
                            r3.append(r4)     // Catch:{ AssertionError -> 0x00eb }
                            r3.append(r8)     // Catch:{ AssertionError -> 0x00eb }
                            java.lang.String r18 = r3.toString()     // Catch:{ AssertionError -> 0x00eb }
                            r16 = 3
                            r19 = 0
                            java.lang.String r20 = "com.didichuxing.swarm.launcher.TimeServiceImpl$2"
                            r21 = 151(0x97, float:2.12E-43)
                            com.didi.sdk.apm.SystemUtils.log(r16, r17, r18, r19, r20, r21)     // Catch:{ AssertionError -> 0x00eb }
                        L_0x00eb:
                            java.lang.String r3 = "file_time_difference"
                            android.content.SharedPreferences r1 = com.didi.sdk.apm.SystemUtils.getSharedPreferences(r1, r3, r5)
                            android.content.SharedPreferences$Editor r1 = r1.edit()
                            java.lang.String r3 = "key_time_difference"
                            android.content.SharedPreferences$Editor r1 = r1.putLong(r3, r8)
                            r1.apply()
                            boolean unused = com.didichuxing.swarm.launcher.TimeServiceImpl.f49182j = r0
                        L_0x0101:
                            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r5)
                            java.lang.Boolean unused = com.didichuxing.swarm.launcher.TimeServiceImpl.f49183k = r0
                            return
                        L_0x0109:
                            r0 = move-exception
                            r2 = r22
                        L_0x010c:
                            monitor-exit(r1)     // Catch:{ all -> 0x010e }
                            throw r0
                        L_0x010e:
                            r0 = move-exception
                            goto L_0x010c
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.swarm.launcher.TimeServiceImpl.C164932.run():void");
                    }
                }));
            }
        } catch (Exception e) {
            e.printStackTrace();
            SystemUtils.log(3, f49174a, " exception is " + e.getMessage(), (Throwable) null, "com.didichuxing.swarm.launcher.TimeServiceImpl", 169);
        }
    }

    public long getTimeDifference() {
        try {
            BundleContext bundleContext = this.f49184i.getBundleContext();
            return SystemUtils.getSharedPreferences((Application) bundleContext.getService(bundleContext.getServiceReference(Application.class)), f49180g, 0).getLong(f49181h, 0);
        } catch (Exception e) {
            e.printStackTrace();
            SystemUtils.log(6, f49174a, e.getMessage(), (Throwable) null, "com.didichuxing.swarm.launcher.TimeServiceImpl", 193);
            return 0;
        }
    }

    public void sync() {
        BundleContext bundleContext = this.f49184i.getBundleContext();
        SystemUtils.getSharedPreferences((Application) bundleContext.getService(bundleContext.getServiceReference(Application.class)), f49180g, 0).edit().putLong(f49181h, 0).apply();
        f49182j = false;
        m35463c();
        m35465e();
    }

    private static abstract class DefActivityCallbackImpl implements Application.ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        private DefActivityCallbackImpl() {
        }
    }
}
