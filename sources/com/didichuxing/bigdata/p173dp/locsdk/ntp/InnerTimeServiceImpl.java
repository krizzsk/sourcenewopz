package com.didichuxing.bigdata.p173dp.locsdk.ntp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.MD5;
import com.didichuxing.bigdata.p173dp.locsdk.ApolloProxy;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.OmegaUtils;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.ntp.InnerTimeServiceImpl */
class InnerTimeServiceImpl {

    /* renamed from: a */
    private static final String f46001a = "ntp_server";

    /* renamed from: b */
    private static final String f46002b = "ntp_timeout";

    /* renamed from: c */
    private static final String f46003c = "prefs_locsdk_ntp";

    /* renamed from: d */
    private static final String f46004d = "ntp_timediff";

    /* renamed from: e */
    private static final String f46005e = "boot_utc_time";

    /* renamed from: f */
    private static final long f46006f = ApolloProxy.getInstance().getNTPCacheTimeDiffToleranceMillis();

    /* renamed from: g */
    private static final long f46007g = ApolloProxy.getInstance().getNTPCacheBootUTCToleranceMillis();

    /* renamed from: h */
    private static final String f46008h = "2.android.pool.ntp.org";

    /* renamed from: i */
    private static final long f46009i = 20000;

    /* renamed from: j */
    private static final long f46010j = 1660293840720L;

    /* renamed from: k */
    private static final long f46011k = new GregorianCalendar(2020, 0, 1).getTimeInMillis();

    /* renamed from: l */
    private static final long f46012l = 86400000;

    /* renamed from: m */
    private static final long f46013m = 31536000000L;

    /* renamed from: u */
    private static final boolean f46014u = ApolloProxy.getInstance().isNTPUseStandardTimeRef();

    /* renamed from: v */
    private static final long f46015v = 30000;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Context f46016n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public String f46017o = f46008h;

    /* renamed from: p */
    private long f46018p = 20000;

    /* renamed from: q */
    private volatile Long f46019q = null;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public volatile long f46020r = 0;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public volatile String f46021s = "";

    /* renamed from: t */
    private ThreadPoolExecutor f46022t = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    /* renamed from: w */
    private Map<TimeSource, TimeRefInfo> f46023w = new ConcurrentHashMap();

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.ntp.InnerTimeServiceImpl$TimeRefInfo */
    private static class TimeRefInfo {
        long baseTime;
        long bootTime = SystemClock.elapsedRealtime();

        TimeRefInfo(long j) {
            this.baseTime = j;
        }
    }

    InnerTimeServiceImpl(Context context, boolean z) {
        this.f46016n = context.getApplicationContext();
        if (z) {
            m33027g();
        }
        m33015a(m33028h());
    }

    /* renamed from: a */
    public void mo114606a() {
        this.f46020r = SystemClock.elapsedRealtime();
        this.f46021s = m33030j();
    }

    public boolean isAvailable() {
        return m33025f() != null;
    }

    /* renamed from: b */
    public long mo114609b() {
        return System.currentTimeMillis() + mo114610c();
    }

    /* renamed from: c */
    public long mo114610c() {
        Long f = m33025f();
        if (f != null) {
            return f.longValue();
        }
        return 0;
    }

    public void sync() {
        mo114608a((String) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo114608a(final String str) {
        DLog.m32737d("InnerTimeServiceImpl request sync scene=" + str);
        ThreadPoolExecutor threadPoolExecutor = this.f46022t;
        if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown() && !this.f46022t.isTerminated() && this.f46022t.getActiveCount() == 0) {
            this.f46022t.submit(new Runnable() {
                public void run() {
                    DLog.m32737d("InnerTimeServiceImpl request sync scene=" + str + " run!");
                    InnerTimeServiceImpl innerTimeServiceImpl = InnerTimeServiceImpl.this;
                    boolean a = innerTimeServiceImpl.m33016a(innerTimeServiceImpl.f46016n);
                    Long b = InnerTimeServiceImpl.this.m33025f();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    Long c = a ? InnerTimeServiceImpl.this.m33023e() : null;
                    long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                    long elapsedRealtime3 = SystemClock.elapsedRealtime() - InnerTimeServiceImpl.this.f46020r;
                    int a2 = InnerTimeServiceImpl.this.m33018b(c);
                    boolean z = a2 == 0;
                    if (z) {
                        InnerTimeServiceImpl.this.m33015a(c);
                        OmegaUtils.trackNTPAndMobileTimeDiff(c.longValue());
                    }
                    DLog.m32737d("InnerTimeServiceImpl sync done ntptimediff=" + c + " vaildCode=" + a2);
                    DLog.m32737d("InnerTimeServiceImpl sync done timediff=" + c + " vaildCode=" + a2 + " lastTimediff=" + b + " netConnected=" + a);
                    OmegaUtils.trackNTPSync(InnerTimeServiceImpl.this.f46021s, z, c, b, elapsedRealtime2, elapsedRealtime3, InnerTimeServiceImpl.this.f46017o, str, a2, a);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo114611d() {
        m33015a((Long) null);
    }

    /* renamed from: a */
    public void mo114607a(TimeSource timeSource, long j) {
        if (f46014u && j > f46011k) {
            this.f46023w.put(timeSource, new TimeRefInfo(j));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public Long m33023e() {
        if (this.f46017o == null || this.f46018p <= 0) {
            return null;
        }
        C15147a aVar = new C15147a();
        if (aVar.mo114625a(this.f46017o, (int) this.f46018p)) {
            return Long.valueOf(((aVar.mo114624a() + SystemClock.elapsedRealtime()) - aVar.mo114626b()) - System.currentTimeMillis());
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public Long m33025f() {
        return this.f46019q;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33015a(Long l) {
        this.f46019q = l;
        if (l != null) {
            m33014a(l.longValue());
        } else {
            m33029i();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035 A[Catch:{ Exception -> 0x0048 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0058  */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m33027g() {
        /*
            r10 = this;
            java.lang.String r0 = "android"
            r1 = 0
            r2 = 0
            android.content.Context r4 = r10.f46016n     // Catch:{ Exception -> 0x002d }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ Exception -> 0x002d }
            android.content.res.Resources r5 = android.content.res.Resources.getSystem()     // Catch:{ Exception -> 0x002d }
            java.lang.String r6 = "config_ntpServer"
            java.lang.String r7 = "string"
            int r5 = r5.getIdentifier(r6, r7, r0)     // Catch:{ Exception -> 0x002d }
            java.lang.String r5 = r4.getString(r5)     // Catch:{ Exception -> 0x002d }
            android.content.res.Resources r6 = android.content.res.Resources.getSystem()     // Catch:{ Exception -> 0x002e }
            java.lang.String r7 = "config_ntpTimeout"
            java.lang.String r8 = "integer"
            int r0 = r6.getIdentifier(r7, r8, r0)     // Catch:{ Exception -> 0x002e }
            int r0 = r4.getInteger(r0)     // Catch:{ Exception -> 0x002e }
            long r6 = (long) r0
            goto L_0x002f
        L_0x002d:
            r5 = r1
        L_0x002e:
            r6 = r2
        L_0x002f:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0048 }
            r4 = 17
            if (r0 < r4) goto L_0x0048
            android.content.Context r0 = r10.f46016n     // Catch:{ Exception -> 0x0048 }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x0048 }
            java.lang.String r4 = "ntp_server"
            java.lang.String r1 = android.provider.Settings.Global.getString(r0, r4)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r4 = "ntp_timeout"
            long r8 = android.provider.Settings.Global.getLong(r0, r4, r2)     // Catch:{ Exception -> 0x0048 }
            goto L_0x0049
        L_0x0048:
            r8 = r2
        L_0x0049:
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L_0x0058
            int r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0058
            r10.f46017o = r1
            r10.f46018p = r8
            goto L_0x0066
        L_0x0058:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L_0x0066
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0066
            r10.f46017o = r5
            r10.f46018p = r6
        L_0x0066:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "InnerTimeServiceImpl loadSystemConfig server="
            r0.append(r1)
            java.lang.String r1 = r10.f46017o
            r0.append(r1)
            java.lang.String r1 = " timeout="
            r0.append(r1)
            long r1 = r10.f46018p
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p173dp.locsdk.ntp.InnerTimeServiceImpl.m33027g():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00b0  */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Long m33028h() {
        /*
            r14 = this;
            r0 = 0
            r1 = 0
            android.content.Context r2 = r14.f46016n     // Catch:{ Exception -> 0x0099 }
            java.lang.String r3 = "prefs_locsdk_ntp"
            android.content.SharedPreferences r2 = com.didi.sdk.apm.SystemUtils.getSharedPreferences(r2, r3, r0)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r3 = "ntp_timediff"
            r4 = -9223372036854775808
            long r6 = r2.getLong(r3, r4)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r3 = "boot_utc_time"
            long r2 = r2.getLong(r3, r4)     // Catch:{ Exception -> 0x0099 }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0099 }
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0099 }
            long r8 = r8 - r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0099 }
            r10.<init>()     // Catch:{ Exception -> 0x0099 }
            java.lang.String r11 = "InnerTimeServiceImpl loadTimeDiffCache TIMEDIFF_TOLERANCE="
            r10.append(r11)     // Catch:{ Exception -> 0x0099 }
            long r11 = f46006f     // Catch:{ Exception -> 0x0099 }
            r10.append(r11)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r11 = " BOOT_UTC_TOLERANCE="
            r10.append(r11)     // Catch:{ Exception -> 0x0099 }
            long r11 = f46007g     // Catch:{ Exception -> 0x0099 }
            r10.append(r11)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0099 }
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r10)     // Catch:{ Exception -> 0x0099 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0099 }
            r10.<init>()     // Catch:{ Exception -> 0x0099 }
            java.lang.String r11 = "InnerTimeServiceImpl loadTimeDiffCache ntpTimeDiffCached="
            r10.append(r11)     // Catch:{ Exception -> 0x0099 }
            r10.append(r6)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r11 = " bootUTCTimeCached="
            r10.append(r11)     // Catch:{ Exception -> 0x0099 }
            r10.append(r2)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r11 = " bootUTCTime="
            r10.append(r11)     // Catch:{ Exception -> 0x0099 }
            r10.append(r8)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0099 }
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r10)     // Catch:{ Exception -> 0x0099 }
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0099
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0099
            long r4 = java.lang.Math.abs(r6)     // Catch:{ Exception -> 0x0099 }
            long r10 = f46006f     // Catch:{ Exception -> 0x0099 }
            int r12 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r12 >= 0) goto L_0x007f
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x0099 }
            r13 = r2
            r2 = r1
            r1 = r13
            goto L_0x009a
        L_0x007f:
            long r8 = r8 - r2
            java.lang.Long r2 = java.lang.Long.valueOf(r8)     // Catch:{ Exception -> 0x0099 }
            long r3 = r2.longValue()     // Catch:{ Exception -> 0x0097 }
            long r3 = java.lang.Math.abs(r3)     // Catch:{ Exception -> 0x0097 }
            long r8 = f46007g     // Catch:{ Exception -> 0x0097 }
            int r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r5 >= 0) goto L_0x009a
            java.lang.Long r1 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x0097 }
            goto L_0x009a
        L_0x0097:
            goto L_0x009a
        L_0x0099:
            r2 = r1
        L_0x009a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "InnerTimeServiceImpl loadTimeDiffCache ret="
            r3.append(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            com.didichuxing.bigdata.p173dp.locsdk.DLog.m32737d(r3)
            if (r1 == 0) goto L_0x00b1
            r0 = 1
        L_0x00b1:
            com.didichuxing.bigdata.p173dp.locsdk.OmegaUtils.trackNTPCache(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p173dp.locsdk.ntp.InnerTimeServiceImpl.m33028h():java.lang.Long");
    }

    /* renamed from: a */
    private void m33014a(long j) {
        try {
            SystemUtils.getSharedPreferences(this.f46016n, f46003c, 0).edit().putLong(f46004d, j).putLong(f46005e, System.currentTimeMillis() - SystemClock.elapsedRealtime()).apply();
            DLog.m32737d("InnerTimeServiceImpl updateTimeDiffCache timeDiffMillis=" + j);
        } catch (Exception unused) {
        }
    }

    /* renamed from: i */
    private void m33029i() {
        try {
            SystemUtils.getSharedPreferences(this.f46016n, f46003c, 0).edit().remove(f46004d).remove(f46005e).apply();
            DLog.m32737d("InnerTimeServiceImpl clearTimeDiffCache");
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m33018b(Long l) {
        if (l == null) {
            return -1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long longValue = l.longValue() + currentTimeMillis;
        if (longValue < f46011k) {
            return -2;
        }
        if (Math.abs(l.longValue()) > 86400000 && f46010j > f46011k) {
            int i = (longValue > currentTimeMillis ? 1 : (longValue == currentTimeMillis ? 0 : -1));
            if (i < 0 && longValue < f46010j) {
                return -3;
            }
            if (i > 0 && currentTimeMillis > f46010j && longValue - f46010j > 63072000000L) {
                return -4;
            }
        }
        if (Math.abs(l.longValue()) <= 30000) {
            return 0;
        }
        for (Map.Entry next : this.f46023w.entrySet()) {
            long j = ((TimeRefInfo) next.getValue()).baseTime;
            long elapsedRealtime = (SystemClock.elapsedRealtime() - ((TimeRefInfo) next.getValue()).bootTime) + j;
            long currentTimeMillis2 = System.currentTimeMillis();
            DLog.m32737d("InnerTimeServiceImpl check by timeref source=" + next.getKey() + " baseTime=" + j + " targetBaseTime=" + elapsedRealtime + " ntpTimeDiff=" + l);
            if (Math.abs(l.longValue()) / 2 > Math.abs(elapsedRealtime - currentTimeMillis2)) {
                DLog.m32737d("InnerTimeServiceImpl check vaild=false by timeref source=" + next.getKey());
                return -5;
            }
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m33016a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: j */
    private String m33030j() {
        String md5 = MD5.toMD5(UUID.randomUUID().toString());
        return (md5 == null || md5.length() != 32) ? "" : md5.toLowerCase().substring(12, 20);
    }
}
