package didihttpdns;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.didi.raven.config.RavenKey;
import didihttp.CacheControl;
import didihttp.Call;
import didihttp.Callback;
import didihttp.DidiHttpClient;
import didihttp.FormBody;
import didihttp.Interceptor;
import didihttp.Request;
import didihttp.Response;
import didihttpdns.cache.HttpDnsCache;
import didihttpdns.cache.LruHttpDnsCache;
import didihttpdns.log.LoggingInterceptor;
import didihttpdns.model.DnsParam;
import didihttpdns.model.DnsRecord;
import didihttpdns.model.DnsResponse;
import didihttpdns.net.NetUtils;
import didihttpdns.p230db.DBCacheStrategyFactory;
import didihttpdns.p230db.DBCacheType;
import didihttpdns.p230db.HttpDnsDBCacheManager;
import didihttpdns.security.InterceptorGetter;
import didihttpdns.security.SigGenerator;
import didihttpdns.statics.HttpDnsStatics;
import didinet.Logger;
import didinet.NetEngine;
import didinet.OmegaAPI;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public final class HttpDnsManager {
    public static final String TAG = "HttpDnsManager";

    /* renamed from: a */
    private static final int f57002a = 30;

    /* renamed from: b */
    private static final int f57003b = 30;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public HttpDnsCache f57004c = new LruHttpDnsCache();

    /* renamed from: d */
    private Context f57005d;

    /* renamed from: e */
    private AtomicBoolean f57006e = new AtomicBoolean();

    /* renamed from: f */
    private volatile boolean f57007f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public DidiHttpClient f57008g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final Set<String> f57009h = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Map<String, Long> f57010i = new HashMap();

    /* renamed from: j */
    private String f57011j;

    /* renamed from: k */
    private String f57012k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public HttpDnsDBCacheManager f57013l;

    /* renamed from: m */
    private List<String> f57014m = new ArrayList();

    /* renamed from: n */
    private final List<String> f57015n = new ArrayList();

    /* renamed from: o */
    private boolean f57016o;

    /* renamed from: p */
    private int f57017p;

    /* renamed from: q */
    private int f57018q;

    /* renamed from: r */
    private Timer f57019r = new Timer("hd_timer", true);

    /* renamed from: s */
    private TimerTask f57020s = new TimerTask() {
        public void run() {
            Logger.m40928d("HttpDnsManager", "begin check buffer");
            HttpDnsManager.this.m40908a();
        }
    };

    /* renamed from: t */
    private Ipv6Limit f57021t;

    public interface HttpDnsResponseListener {
        void onFailure(Exception exc);

        void onSuccess(DnsResponse dnsResponse);
    }

    public interface Ipv6Limit {
        boolean ignoreLimit(InetSocketAddress inetSocketAddress);
    }

    private static final class SingletonHolder {
        /* access modifiers changed from: private */
        public static final HttpDnsManager SINGLETON = new HttpDnsManager();

        private SingletonHolder() {
        }
    }

    public static HttpDnsManager getInstance() {
        return SingletonHolder.SINGLETON;
    }

    public void init(Context context, DnsParam dnsParam, SigGenerator sigGenerator) {
        init(context, dnsParam, sigGenerator, (InterceptorGetter[]) null);
    }

    public void init(Context context, DnsParam dnsParam, SigGenerator sigGenerator, InterceptorGetter... interceptorGetterArr) {
        if (this.f57006e.compareAndSet(false, true)) {
            HttpDnsApolloConfig.getConfig().mo170402a(dnsParam.apolloName);
            this.f57007f = HttpDnsApolloConfig.getConfig().mo170404c();
            Logger.m40928d("HttpDnsManager", "[init] mHttpDnsAllowed:" + this.f57007f);
            if (this.f57007f) {
                this.f57005d = context.getApplicationContext();
                HttpDnsDBCacheManager httpDnsDBCacheManager = new HttpDnsDBCacheManager(DBCacheStrategyFactory.create(this.f57005d, HttpDnsApolloConfig.getConfig().mo170405d(), this.f57004c));
                this.f57013l = httpDnsDBCacheManager;
                httpDnsDBCacheManager.readFromDb();
                DidiHttpClient.Builder addInterceptor = new DidiHttpClient.Builder().addInterceptor(new LoggingInterceptor());
                if (interceptorGetterArr != null) {
                    for (final InterceptorGetter interceptorGetter : interceptorGetterArr) {
                        addInterceptor.addInterceptor(new Interceptor() {
                            public Response intercept(Interceptor.Chain chain) throws IOException {
                                return interceptorGetter.get(HttpDnsManager.this.f57008g).intercept(chain);
                            }
                        });
                    }
                }
                this.f57008g = addInterceptor.build();
                this.f57012k = dnsParam.requestHttpDnsUrl;
                this.f57011j = dnsParam.uid;
                if (dnsParam.blackHosts != null) {
                    this.f57014m.addAll(dnsParam.blackHosts);
                }
                this.f57014m.addAll(HttpDnsApolloConfig.getConfig().mo170401a());
                Logger.m40928d("HttpDnsManager", "all blackhosts is " + this.f57014m.toString());
                m40910a(dnsParam.hostNames);
                this.f57016o = HttpDnsApolloConfig.getConfig().mo170411h();
                Logger.m40928d("HttpDnsManager", "usebuffer is " + this.f57016o);
                this.f57017p = HttpDnsApolloConfig.getConfig().mo170407f();
                Logger.m40928d("HttpDnsManager", "buffertime is " + this.f57017p);
                this.f57018q = HttpDnsApolloConfig.getConfig().mo170408g();
                Logger.m40928d("HttpDnsManager", "buffercount is " + this.f57018q);
                if (this.f57016o) {
                    this.f57019r.schedule(this.f57020s, 0, (long) (this.f57017p * 1000));
                }
            }
        }
    }

    public DnsRecord fullLookup(String str) {
        NetEngine.ExternalParam onGetExternalParam;
        try {
            if (TextUtils.isEmpty(this.f57012k)) {
                OmegaAPI omegaAPI = NetEngine.getInstance().getOmegaAPI();
                HashMap hashMap = new HashMap();
                hashMap.put("host", str);
                hashMap.put("reason", 10);
                omegaAPI.trackEvent("not_use_httpdns_detail", "", hashMap);
                return null;
            } else if (!this.f57007f) {
                OmegaAPI omegaAPI2 = NetEngine.getInstance().getOmegaAPI();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("host", str);
                hashMap2.put("reason", 1);
                omegaAPI2.trackEvent("not_use_httpdns_detail", "", hashMap2);
                return null;
            } else if (TextUtils.isEmpty(str)) {
                OmegaAPI omegaAPI3 = NetEngine.getInstance().getOmegaAPI();
                HashMap hashMap3 = new HashMap();
                hashMap3.put("host", str);
                hashMap3.put("reason", 2);
                omegaAPI3.trackEvent("not_use_httpdns_detail", "", hashMap3);
                return null;
            } else if (NetUtils.isIpv4(str)) {
                OmegaAPI omegaAPI4 = NetEngine.getInstance().getOmegaAPI();
                HashMap hashMap4 = new HashMap();
                hashMap4.put("host", str);
                hashMap4.put("reason", 3);
                omegaAPI4.trackEvent("not_use_httpdns_detail", "", hashMap4);
                return null;
            } else if (this.f57014m.contains(str)) {
                OmegaAPI omegaAPI5 = NetEngine.getInstance().getOmegaAPI();
                HashMap hashMap5 = new HashMap();
                hashMap5.put("host", str);
                hashMap5.put("reason", 4);
                omegaAPI5.trackEvent("not_use_httpdns_detail", "", hashMap5);
                return null;
            } else {
                if (HttpDnsApolloConfig.getConfig().mo170403b().contains(str)) {
                    NetEngine.ExternalParamGetter paramGetter = NetEngine.getInstance().getParamGetter();
                    if (!(paramGetter == null || (onGetExternalParam = paramGetter.onGetExternalParam()) == null || onGetExternalParam.getAppState() != 2)) {
                        Logger.m40928d("HttpDnsManager", "[lookup] dns record for " + str + " is forbidden in the background");
                        OmegaAPI omegaAPI6 = NetEngine.getInstance().getOmegaAPI();
                        HashMap hashMap6 = new HashMap();
                        hashMap6.put("host", str);
                        hashMap6.put("reason", 9);
                        omegaAPI6.trackEvent("not_use_httpdns_detail", "", hashMap6);
                        return null;
                    }
                }
                DnsRecord dnsRecord = this.f57004c.get(str);
                if (dnsRecord == null) {
                    Logger.m40928d("HttpDnsManager", "[lookup] no dns record for " + str);
                    queryHost(str, (HttpDnsResponseListener) null);
                    OmegaAPI omegaAPI7 = NetEngine.getInstance().getOmegaAPI();
                    HashMap hashMap7 = new HashMap();
                    hashMap7.put("host", str);
                    hashMap7.put("reason", 6);
                    omegaAPI7.trackEvent("not_use_httpdns_detail", "", hashMap7);
                    return null;
                } else if (dnsRecord.getType() == DBCacheType.USE_CACHE_ONCE.getValue()) {
                    Logger.m40928d("HttpDnsManager", String.format("[lookup] dns record for %s is from db, record is %s", new Object[]{str, dnsRecord.toString()}));
                    queryHost(str, (HttpDnsResponseListener) null);
                    return dnsRecord;
                } else if (dnsRecord.isExpired()) {
                    Logger.m40928d("HttpDnsManager", "[lookup] dns record for " + str + " is expired");
                    queryHost(str, (HttpDnsResponseListener) null);
                    if (HttpDnsApolloConfig.getConfig().mo170406e()) {
                        Logger.m40928d("HttpDnsManager", "[lookup] use dns expired record for " + str);
                        return dnsRecord;
                    }
                    OmegaAPI omegaAPI8 = NetEngine.getInstance().getOmegaAPI();
                    HashMap hashMap8 = new HashMap();
                    hashMap8.put("host", str);
                    hashMap8.put("reason", 7);
                    omegaAPI8.trackEvent("not_use_httpdns_detail", "", hashMap8);
                    return null;
                } else {
                    Logger.m40928d("HttpDnsManager", "[lookup] find dns record " + dnsRecord + " for " + str);
                    if (dnsRecord.isSoftExpired()) {
                        Logger.m40928d("HttpDnsManager", "[lookup] dns record for " + str + " is soft expired");
                        queryHost(str, (HttpDnsResponseListener) null);
                    }
                    return dnsRecord;
                }
            }
        } catch (Exception e) {
            Logger.m40928d("HttpDnsManager", "fullLookup: " + Log.getStackTraceString(e));
            OmegaAPI omegaAPI9 = NetEngine.getInstance().getOmegaAPI();
            HashMap hashMap9 = new HashMap();
            hashMap9.put("host", str);
            hashMap9.put("reason", 8);
            omegaAPI9.trackEvent("not_use_httpdns_detail", "", hashMap9);
            return null;
        } catch (Throwable th) {
            if (0 > 0) {
                OmegaAPI omegaAPI10 = NetEngine.getInstance().getOmegaAPI();
                HashMap hashMap10 = new HashMap();
                hashMap10.put("host", str);
                hashMap10.put("reason", 0);
                omegaAPI10.trackEvent("not_use_httpdns_detail", "", hashMap10);
            }
            throw th;
        }
    }

    public String lookup(String str) {
        DnsRecord fullLookup = fullLookup(str);
        if (fullLookup != null) {
            return fullLookup.getAvailableIp();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
        r1 = r10.f57010i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0050, code lost:
        if (r10.f57010i.containsKey(r11) == false) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
        r2 = r10.f57010i.get(r11).longValue();
        r4 = android.os.SystemClock.elapsedRealtime() / 1000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006b, code lost:
        if ((r4 - r2) >= 30) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006d, code lost:
        didinet.Logger.m40928d("HttpDnsManager", "[query] " + r11 + " occurs err in 30s, lastTime:" + r2 + ", curTime:" + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0093, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0094, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0095, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0098, code lost:
        if (r10.f57016o == false) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009a, code lost:
        if (r12 != null) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009c, code lost:
        r0 = r10.f57015n;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009e, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a7, code lost:
        if (r10.f57015n.size() >= 30) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00af, code lost:
        if (r10.f57015n.contains(r11) != false) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b1, code lost:
        r10.f57015n.add(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b6, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b7, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b8, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00bd, code lost:
        r0 = new java.lang.StringBuilder();
        r0.append(r10.f57012k);
        r1 = new java.util.HashMap();
        r1.put("host", r11);
        r1.put(com.didi.raven.config.RavenKey.VERSION, "1.0.0");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e4, code lost:
        if (didihttpdns.HttpDnsApolloConfig.getConfig().getIpv6Hosts().contains(r11) == false) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e6, code lost:
        r1.put("ipv6", "1");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f3, code lost:
        if (android.text.TextUtils.isEmpty(r10.f57011j) != false) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f5, code lost:
        r1.put("uid", r10.f57011j);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00fc, code lost:
        r1 = r1.entrySet().iterator();
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x010b, code lost:
        if (r1.hasNext() == false) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x010d, code lost:
        r5 = (java.util.Map.Entry) r1.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0113, code lost:
        if (r4 == false) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0115, code lost:
        r0.append((java.lang.String) r5.getKey());
        r0.append("=");
        r0.append((java.lang.String) r5.getValue());
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x012e, code lost:
        r0.append(com.didi.travel.psnger.common.net.base.ParamKeys.SIGN_AND);
        r0.append((java.lang.String) r5.getKey());
        r0.append("=");
        r0.append((java.lang.String) r5.getValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x014b, code lost:
        r0 = new didihttp.Request.Builder().url(r0.toString()).cacheControl(didihttp.CacheControl.FORCE_NETWORK).build();
        r4 = r10.f57009h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0164, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        r10.f57009h.add(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x016a, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x016b, code lost:
        r10.f57008g.newCall(r0).enqueue(new didihttpdns.HttpDnsManager.HttpDnsCallback(r10, java.util.Arrays.asList(new java.lang.String[]{r11}), r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0181, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void queryHost(java.lang.String r11, didihttpdns.HttpDnsManager.HttpDnsResponseListener r12) {
        /*
            r10 = this;
            java.lang.String r0 = r10.f57012k
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0010
            java.lang.String r11 = "HttpDnsManager"
            java.lang.String r12 = "[query] dns host is empty, drop request"
            didinet.Logger.m40928d(r11, r12)
            return
        L_0x0010:
            boolean r0 = r10.f57007f
            if (r0 != 0) goto L_0x0015
            return
        L_0x0015:
            android.content.Context r0 = r10.f57005d
            boolean r0 = didihttpdns.net.NetUtils.isNetAvailable(r0)
            if (r0 != 0) goto L_0x001e
            return
        L_0x001e:
            java.util.Set<java.lang.String> r0 = r10.f57009h
            monitor-enter(r0)
            java.util.Set<java.lang.String> r1 = r10.f57009h     // Catch:{ all -> 0x0188 }
            boolean r1 = r1.contains(r11)     // Catch:{ all -> 0x0188 }
            if (r1 == 0) goto L_0x0046
            java.lang.String r12 = "HttpDnsManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0188 }
            r1.<init>()     // Catch:{ all -> 0x0188 }
            java.lang.String r2 = "[query] "
            r1.append(r2)     // Catch:{ all -> 0x0188 }
            r1.append(r11)     // Catch:{ all -> 0x0188 }
            java.lang.String r11 = " is in query, drop request"
            r1.append(r11)     // Catch:{ all -> 0x0188 }
            java.lang.String r11 = r1.toString()     // Catch:{ all -> 0x0188 }
            didinet.Logger.m40928d(r12, r11)     // Catch:{ all -> 0x0188 }
            monitor-exit(r0)     // Catch:{ all -> 0x0188 }
            return
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0188 }
            java.util.Map<java.lang.String, java.lang.Long> r1 = r10.f57010i
            monitor-enter(r1)
            java.util.Map<java.lang.String, java.lang.Long> r0 = r10.f57010i     // Catch:{ all -> 0x0185 }
            boolean r0 = r0.containsKey(r11)     // Catch:{ all -> 0x0185 }
            if (r0 == 0) goto L_0x0095
            java.util.Map<java.lang.String, java.lang.Long> r0 = r10.f57010i     // Catch:{ all -> 0x0185 }
            java.lang.Object r0 = r0.get(r11)     // Catch:{ all -> 0x0185 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x0185 }
            long r2 = r0.longValue()     // Catch:{ all -> 0x0185 }
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0185 }
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 / r6
            long r6 = r4 - r2
            r8 = 30
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x0095
            java.lang.String r12 = "HttpDnsManager"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0185 }
            r0.<init>()     // Catch:{ all -> 0x0185 }
            java.lang.String r6 = "[query] "
            r0.append(r6)     // Catch:{ all -> 0x0185 }
            r0.append(r11)     // Catch:{ all -> 0x0185 }
            java.lang.String r11 = " occurs err in 30s, lastTime:"
            r0.append(r11)     // Catch:{ all -> 0x0185 }
            r0.append(r2)     // Catch:{ all -> 0x0185 }
            java.lang.String r11 = ", curTime:"
            r0.append(r11)     // Catch:{ all -> 0x0185 }
            r0.append(r4)     // Catch:{ all -> 0x0185 }
            java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x0185 }
            didinet.Logger.m40928d(r12, r11)     // Catch:{ all -> 0x0185 }
            monitor-exit(r1)     // Catch:{ all -> 0x0185 }
            return
        L_0x0095:
            monitor-exit(r1)     // Catch:{ all -> 0x0185 }
            boolean r0 = r10.f57016o
            if (r0 == 0) goto L_0x00bd
            if (r12 != 0) goto L_0x00bd
            java.util.List<java.lang.String> r0 = r10.f57015n
            monitor-enter(r0)
            java.util.List<java.lang.String> r1 = r10.f57015n     // Catch:{ all -> 0x00ba }
            int r1 = r1.size()     // Catch:{ all -> 0x00ba }
            r2 = 30
            if (r1 >= r2) goto L_0x00b8
            java.util.List<java.lang.String> r12 = r10.f57015n     // Catch:{ all -> 0x00ba }
            boolean r12 = r12.contains(r11)     // Catch:{ all -> 0x00ba }
            if (r12 != 0) goto L_0x00b6
            java.util.List<java.lang.String> r12 = r10.f57015n     // Catch:{ all -> 0x00ba }
            r12.add(r11)     // Catch:{ all -> 0x00ba }
        L_0x00b6:
            monitor-exit(r0)     // Catch:{ all -> 0x00ba }
            return
        L_0x00b8:
            monitor-exit(r0)     // Catch:{ all -> 0x00ba }
            goto L_0x00bd
        L_0x00ba:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00ba }
            throw r11
        L_0x00bd:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r10.f57012k
            r0.append(r1)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r2 = "host"
            r1.put(r2, r11)
            java.lang.String r2 = "v"
            java.lang.String r3 = "1.0.0"
            r1.put(r2, r3)
            didihttpdns.HttpDnsApolloConfig r2 = didihttpdns.HttpDnsApolloConfig.getConfig()
            java.util.List r2 = r2.getIpv6Hosts()
            boolean r2 = r2.contains(r11)
            if (r2 == 0) goto L_0x00ed
            java.lang.String r2 = "ipv6"
            java.lang.String r3 = "1"
            r1.put(r2, r3)
        L_0x00ed:
            java.lang.String r2 = r10.f57011j
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00fc
            java.lang.String r2 = "uid"
            java.lang.String r3 = r10.f57011j
            r1.put(r2, r3)
        L_0x00fc:
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
            r3 = 1
            r4 = 1
        L_0x0107:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x014b
            java.lang.Object r5 = r1.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            if (r4 == 0) goto L_0x012e
            java.lang.Object r4 = r5.getKey()
            java.lang.String r4 = (java.lang.String) r4
            r0.append(r4)
            java.lang.String r4 = "="
            r0.append(r4)
            java.lang.Object r4 = r5.getValue()
            java.lang.String r4 = (java.lang.String) r4
            r0.append(r4)
            r4 = 0
            goto L_0x0107
        L_0x012e:
            java.lang.String r6 = "&"
            r0.append(r6)
            java.lang.Object r6 = r5.getKey()
            java.lang.String r6 = (java.lang.String) r6
            r0.append(r6)
            java.lang.String r6 = "="
            r0.append(r6)
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            r0.append(r5)
            goto L_0x0107
        L_0x014b:
            didihttp.Request$Builder r1 = new didihttp.Request$Builder
            r1.<init>()
            java.lang.String r0 = r0.toString()
            didihttp.Request$Builder r0 = r1.url((java.lang.String) r0)
            didihttp.CacheControl r1 = didihttp.CacheControl.FORCE_NETWORK
            didihttp.Request$Builder r0 = r0.cacheControl(r1)
            didihttp.Request r0 = r0.build()
            java.util.Set<java.lang.String> r4 = r10.f57009h
            monitor-enter(r4)
            java.util.Set<java.lang.String> r1 = r10.f57009h     // Catch:{ all -> 0x0182 }
            r1.add(r11)     // Catch:{ all -> 0x0182 }
            monitor-exit(r4)     // Catch:{ all -> 0x0182 }
            didihttp.DidiHttpClient r1 = r10.f57008g
            didihttp.Call r0 = r1.newCall(r0)
            didihttpdns.HttpDnsManager$HttpDnsCallback r1 = new didihttpdns.HttpDnsManager$HttpDnsCallback
            java.lang.String[] r3 = new java.lang.String[r3]
            r3[r2] = r11
            java.util.List r11 = java.util.Arrays.asList(r3)
            r1.<init>(r11, r12)
            r0.enqueue(r1)
            return
        L_0x0182:
            r11 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0182 }
            throw r11
        L_0x0185:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0185 }
            throw r11
        L_0x0188:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0188 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttpdns.HttpDnsManager.queryHost(java.lang.String, didihttpdns.HttpDnsManager$HttpDnsResponseListener):void");
    }

    /* renamed from: a */
    private void m40910a(List<String> list) {
        if (this.f57007f && list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (String next : list) {
                if (!this.f57009h.contains(next)) {
                    arrayList.add(next);
                }
            }
            if (!arrayList.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    if (i == 0) {
                        sb.append((String) arrayList.get(i));
                    } else {
                        sb.append(" ");
                        sb.append((String) arrayList.get(i));
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f57012k);
                sb2.append("v=1.0.0");
                if (!TextUtils.isEmpty(this.f57011j)) {
                    sb2.append("&uid=");
                    sb2.append(this.f57011j);
                }
                boolean isPushInited = NetEngine.getInstance().getPushAPI().isPushInited();
                Logger.m40928d("HttpDnsManager", "[batchQueryHosts] isPushInit:" + isPushInited + ", supportIpv6:" + NetEngine.getInstance().supportIpv6());
                if (!isPushInited || NetEngine.getInstance().supportIpv6()) {
                    sb2.append("&ipv6=1");
                }
                String sb3 = sb.toString();
                FormBody build = new FormBody.Builder().add("hosts", sb3).build();
                HashMap hashMap = new HashMap();
                hashMap.put("hosts", sb3);
                hashMap.put(RavenKey.VERSION, "1.0.0");
                if (!TextUtils.isEmpty(this.f57011j)) {
                    hashMap.put("uid", this.f57011j);
                }
                synchronized (this.f57009h) {
                    this.f57009h.addAll(arrayList);
                }
                this.f57008g.newCall(new Request.Builder().url(sb2.toString()).post(build).cacheControl(CacheControl.FORCE_NETWORK).build()).enqueue(new HttpDnsCallback(arrayList, (HttpDnsResponseListener) null));
            }
        }
    }

    private class HttpDnsCallback implements Callback {
        private HttpDnsResponseListener listener;
        private List<String> queryHosts = new ArrayList();

        HttpDnsCallback(List<String> list, HttpDnsResponseListener httpDnsResponseListener) {
            if (list != null && !list.isEmpty()) {
                this.queryHosts.addAll(list);
                this.listener = httpDnsResponseListener;
            }
        }

        public void onFailure(Call call, IOException iOException) {
            removeQueryHosts();
            updateErrHosts();
            HttpDnsResponseListener httpDnsResponseListener = this.listener;
            if (httpDnsResponseListener != null) {
                httpDnsResponseListener.onFailure(iOException);
            }
            OmegaAPI omegaAPI = NetEngine.getInstance().getOmegaAPI();
            HashMap hashMap = new HashMap();
            hashMap.put(HttpDnsStatics.ATTR_HTTP_DNS_RESP_EXCEPTION_DETAIL, iOException.getClass().getSimpleName() + " " + iOException.getMessage());
            omegaAPI.trackEvent(HttpDnsStatics.ID_HTTP_DNS_RESP_EXCEPTION, HttpDnsStatics.LABEL_HTTP_DNS_RESP_FAILURE, hashMap);
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onResponse(didihttp.Call r9, didihttp.Response r10) throws java.io.IOException {
            /*
                r8 = this;
                r8.removeQueryHosts()
                boolean r9 = r10.isSuccessful()
                if (r9 != 0) goto L_0x004b
                r8.updateErrHosts()
                didihttpdns.HttpDnsManager$HttpDnsResponseListener r9 = r8.listener
                if (r9 == 0) goto L_0x002d
                java.io.IOException r0 = new java.io.IOException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "http status code is "
                r1.append(r2)
                int r2 = r10.code()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                r9.onFailure(r0)
            L_0x002d:
                didinet.NetEngine r9 = didinet.NetEngine.getInstance()
                didinet.OmegaAPI r9 = r9.getOmegaAPI()
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                java.lang.String r1 = "attr_http_dns_resp_exception_detail"
                java.lang.String r10 = r10.toString()
                r0.put(r1, r10)
                java.lang.String r10 = "id_http_dns_resp_exception"
                java.lang.String r1 = "label_http_dns_resp_code_abnormal"
                r9.trackEvent(r10, r1, r0)
                return
            L_0x004b:
                didihttp.ResponseBody r9 = r10.body()
                java.lang.String r9 = r9.string()
                java.lang.String r0 = "HttpDnsManager"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "[query] onResponse for "
                r1.append(r2)
                didihttp.Request r10 = r10.request()
                didihttp.HttpUrl r10 = r10.url()
                r1.append(r10)
                java.lang.String r10 = ", response:"
                r1.append(r10)
                r1.append(r9)
                java.lang.String r10 = r1.toString()
                didinet.Logger.m40928d(r0, r10)
                boolean r10 = android.text.TextUtils.isEmpty(r9)
                if (r10 == 0) goto L_0x0096
                r8.updateErrHosts()
                java.lang.String r9 = "response is empty"
                r8.uploadErrHosts(r9)
                didihttpdns.HttpDnsManager$HttpDnsResponseListener r9 = r8.listener
                if (r9 == 0) goto L_0x0095
                java.io.IOException r10 = new java.io.IOException
                java.lang.String r0 = "response is empty ！"
                r10.<init>(r0)
                r9.onFailure(r10)
            L_0x0095:
                return
            L_0x0096:
                org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x016e }
                r10.<init>(r9)     // Catch:{ Exception -> 0x016e }
                didihttpdns.model.DnsResponse r10 = didihttpdns.model.DnsResponse.parseFromJsonObject(r10)     // Catch:{ Exception -> 0x016e }
                if (r10 == 0) goto L_0x0148
                int r0 = r10.getErrno()     // Catch:{ Exception -> 0x016e }
                if (r0 == 0) goto L_0x00a9
                goto L_0x0148
            L_0x00a9:
                java.util.List r0 = r10.getList()     // Catch:{ Exception -> 0x016e }
                if (r0 == 0) goto L_0x0138
                boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x016e }
                if (r1 == 0) goto L_0x00b7
                goto L_0x0138
            L_0x00b7:
                java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x016e }
            L_0x00bb:
                boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x016e }
                if (r1 == 0) goto L_0x012e
                java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x016e }
                didihttpdns.model.DnsRecord r1 = (didihttpdns.model.DnsRecord) r1     // Catch:{ Exception -> 0x016e }
                java.util.List r2 = r1.getIps()     // Catch:{ Exception -> 0x016e }
                if (r2 == 0) goto L_0x0107
                java.util.List r2 = r1.getIps()     // Catch:{ Exception -> 0x016e }
                boolean r2 = r2.isEmpty()     // Catch:{ Exception -> 0x016e }
                if (r2 == 0) goto L_0x00d8
                goto L_0x0107
            L_0x00d8:
                didihttpdns.HttpDnsManager r2 = didihttpdns.HttpDnsManager.this     // Catch:{ Exception -> 0x016e }
                didihttpdns.cache.HttpDnsCache r2 = r2.f57004c     // Catch:{ Exception -> 0x016e }
                java.lang.String r3 = r1.getHost()     // Catch:{ Exception -> 0x016e }
                r2.put(r3, r1)     // Catch:{ Exception -> 0x016e }
                didihttpdns.HttpDnsManager r2 = didihttpdns.HttpDnsManager.this     // Catch:{ Exception -> 0x016e }
                didihttpdns.db.HttpDnsDBCacheManager r2 = r2.f57013l     // Catch:{ Exception -> 0x016e }
                r2.writeToDb(r1)     // Catch:{ Exception -> 0x016e }
                didihttpdns.HttpDnsManager r2 = didihttpdns.HttpDnsManager.this     // Catch:{ Exception -> 0x016e }
                java.util.Map r2 = r2.f57010i     // Catch:{ Exception -> 0x016e }
                monitor-enter(r2)     // Catch:{ Exception -> 0x016e }
                didihttpdns.HttpDnsManager r3 = didihttpdns.HttpDnsManager.this     // Catch:{ all -> 0x0104 }
                java.util.Map r3 = r3.f57010i     // Catch:{ all -> 0x0104 }
                java.lang.String r1 = r1.getHost()     // Catch:{ all -> 0x0104 }
                r3.remove(r1)     // Catch:{ all -> 0x0104 }
                monitor-exit(r2)     // Catch:{ all -> 0x0104 }
                goto L_0x00bb
            L_0x0104:
                r10 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0104 }
                throw r10     // Catch:{ Exception -> 0x016e }
            L_0x0107:
                didihttpdns.HttpDnsManager r2 = didihttpdns.HttpDnsManager.this     // Catch:{ Exception -> 0x016e }
                java.util.Map r2 = r2.f57010i     // Catch:{ Exception -> 0x016e }
                monitor-enter(r2)     // Catch:{ Exception -> 0x016e }
                didihttpdns.HttpDnsManager r3 = didihttpdns.HttpDnsManager.this     // Catch:{ all -> 0x012b }
                java.util.Map r3 = r3.f57010i     // Catch:{ all -> 0x012b }
                java.lang.String r1 = r1.getHost()     // Catch:{ all -> 0x012b }
                long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x012b }
                r6 = 1000(0x3e8, double:4.94E-321)
                long r4 = r4 / r6
                java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x012b }
                r3.put(r1, r4)     // Catch:{ all -> 0x012b }
                monitor-exit(r2)     // Catch:{ all -> 0x012b }
                r8.uploadErrHosts(r9)     // Catch:{ Exception -> 0x016e }
                goto L_0x00bb
            L_0x012b:
                r10 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x012b }
                throw r10     // Catch:{ Exception -> 0x016e }
            L_0x012e:
                didihttpdns.HttpDnsManager$HttpDnsResponseListener r0 = r8.listener     // Catch:{ Exception -> 0x016e }
                if (r0 == 0) goto L_0x018f
                didihttpdns.HttpDnsManager$HttpDnsResponseListener r0 = r8.listener     // Catch:{ Exception -> 0x016e }
                r0.onSuccess(r10)     // Catch:{ Exception -> 0x016e }
                goto L_0x018f
            L_0x0138:
                r8.updateErrHosts()     // Catch:{ Exception -> 0x016e }
                r8.uploadErrHosts(r9)     // Catch:{ Exception -> 0x016e }
                didihttpdns.HttpDnsManager$HttpDnsResponseListener r0 = r8.listener     // Catch:{ Exception -> 0x016e }
                if (r0 == 0) goto L_0x0147
                didihttpdns.HttpDnsManager$HttpDnsResponseListener r0 = r8.listener     // Catch:{ Exception -> 0x016e }
                r0.onSuccess(r10)     // Catch:{ Exception -> 0x016e }
            L_0x0147:
                return
            L_0x0148:
                r8.updateErrHosts()     // Catch:{ Exception -> 0x016e }
                r8.uploadErrHosts(r9)     // Catch:{ Exception -> 0x016e }
                didihttpdns.HttpDnsManager$HttpDnsResponseListener r10 = r8.listener     // Catch:{ Exception -> 0x016e }
                if (r10 == 0) goto L_0x016d
                didihttpdns.HttpDnsManager$HttpDnsResponseListener r10 = r8.listener     // Catch:{ Exception -> 0x016e }
                java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x016e }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016e }
                r1.<init>()     // Catch:{ Exception -> 0x016e }
                java.lang.String r2 = "response is "
                r1.append(r2)     // Catch:{ Exception -> 0x016e }
                r1.append(r9)     // Catch:{ Exception -> 0x016e }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x016e }
                r0.<init>(r1)     // Catch:{ Exception -> 0x016e }
                r10.onFailure(r0)     // Catch:{ Exception -> 0x016e }
            L_0x016d:
                return
            L_0x016e:
                r10 = move-exception
                didihttpdns.HttpDnsManager$HttpDnsResponseListener r0 = r8.listener
                if (r0 == 0) goto L_0x0176
                r0.onFailure(r10)
            L_0x0176:
                didinet.NetEngine r10 = didinet.NetEngine.getInstance()
                didinet.OmegaAPI r10 = r10.getOmegaAPI()
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                java.lang.String r1 = "attr_http_dns_resp_exception_detail"
                r0.put(r1, r9)
                java.lang.String r9 = "id_http_dns_resp_exception"
                java.lang.String r1 = "label_http_dns_resp_parse_exception"
                r10.trackEvent(r9, r1, r0)
            L_0x018f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: didihttpdns.HttpDnsManager.HttpDnsCallback.onResponse(didihttp.Call, didihttp.Response):void");
        }

        private void removeQueryHosts() {
            synchronized (HttpDnsManager.this.f57009h) {
                HttpDnsManager.this.f57009h.removeAll(this.queryHosts);
            }
        }

        private void updateErrHosts() {
            synchronized (HttpDnsManager.this.f57010i) {
                long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
                for (String put : this.queryHosts) {
                    HttpDnsManager.this.f57010i.put(put, Long.valueOf(elapsedRealtime));
                }
            }
        }

        private void uploadErrHosts(String str) {
            OmegaAPI omegaAPI = NetEngine.getInstance().getOmegaAPI();
            HashMap hashMap = new HashMap();
            hashMap.put(HttpDnsStatics.ATTR_HTTP_DNS_RESP_EXCEPTION_DETAIL, str);
            omegaAPI.trackEvent(HttpDnsStatics.ID_HTTP_DNS_RESP_EXCEPTION, HttpDnsStatics.LABEL_HTTP_DNS_RESP_HOST_ERR, hashMap);
        }
    }

    public boolean extendTTL() {
        return HttpDnsApolloConfig.getConfig().mo170406e();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40908a() {
        if (this.f57015n.size() > 0) {
            Logger.m40928d("HttpDnsManager", "begin flush buffer");
            m40912b();
        }
    }

    /* renamed from: b */
    private void m40912b() {
        int i;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f57015n) {
            for (int i2 = 0; i2 < this.f57015n.size(); i2++) {
                arrayList.add(this.f57015n.get(i2));
            }
            this.f57015n.clear();
        }
        int size = arrayList.size() / this.f57018q;
        int size2 = arrayList.size() % this.f57018q;
        int i3 = 0;
        for (i = 0; i < size; i++) {
            m40910a((List<String>) arrayList.subList(i3, this.f57018q + i3));
            i3 += this.f57018q;
        }
        if (size2 > 0) {
            m40910a((List<String>) arrayList.subList(i3, size2 + i3));
        }
    }

    public void setIpv6Limit(Ipv6Limit ipv6Limit) {
        if (ipv6Limit != null) {
            this.f57021t = ipv6Limit;
        }
    }

    public boolean ignoreIpv6Limit(InetSocketAddress inetSocketAddress) {
        Ipv6Limit ipv6Limit = this.f57021t;
        return ipv6Limit != null && ipv6Limit.ignoreLimit(inetSocketAddress);
    }
}
