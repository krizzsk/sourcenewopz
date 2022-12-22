package com.didi.global.globalgenerickit.template.yoga;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globalgenerickit.GGKViewBinder;
import com.didi.global.globalgenerickit.helper.KitHelper;
import com.didi.global.globalresource.GRBaseResourceLoader;
import com.didi.global.globalresource.GRResourceLoaderFactory;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.w3c.dom.Element;

public class CDNCacheManager {

    /* renamed from: b */
    private static final String f22208b = "CDNCacheManager";

    /* renamed from: c */
    private static final String f22209c = "template";

    /* renamed from: d */
    private static final String f22210d = ".tmp";

    /* renamed from: e */
    private static final String f22211e = ".zip";

    /* renamed from: f */
    private static final String f22212f = ".xml";

    /* renamed from: g */
    private static final String f22213g = ".js";

    /* renamed from: h */
    private static final int f22214h = 1;

    /* renamed from: i */
    private static final int f22215i = 2;

    /* renamed from: a */
    Map<String, Set<GGKData.CDNCallback>> f22216a;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Context f22217j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f22218k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Set<String> f22219l;

    /* renamed from: m */
    private String f22220m;

    /* renamed from: n */
    private LinkedHashMap<String, XMLCacheEntity> f22221n;

    /* renamed from: o */
    private ExecutorService f22222o;

    private CDNCacheManager() {
        this.f22218k = 40;
        this.f22219l = Collections.synchronizedSet(new HashSet());
        this.f22216a = new HashMap();
        this.f22221n = new LinkedHashMap<String, XMLCacheEntity>(this.f22218k) {
            /* access modifiers changed from: protected */
            public boolean removeEldestEntry(Map.Entry<String, XMLCacheEntity> entry) {
                return size() > CDNCacheManager.this.f22218k;
            }
        };
        this.f22222o = new ThreadPoolExecutor(2, 10, 60, TimeUnit.SECONDS, new ArrayBlockingQueue(20), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    public XMLCacheEntity get(String str) {
        return this.f22221n.get(str);
    }

    public void tryCache(GGKData gGKData, GGKViewBinder gGKViewBinder) {
        final WeakReference weakReference = new WeakReference(gGKViewBinder);
        final String cdn = gGKData.getCdn();
        final String template = gGKData.getTemplate();
        m16049a(cdn, gGKData.getCDNCallback());
        if (TextUtils.isEmpty(cdn) || TextUtils.isEmpty(template) || this.f22219l.contains(cdn)) {
            SystemUtils.log(4, f22208b, cdn + " 任务重复 或者 cdn template 为空", (Throwable) null, "com.didi.global.globalgenerickit.template.yoga.CDNCacheManager", 79);
            return;
        }
        final String str = this.f22220m + File.separator + template + File.separator + KitHelper.MD5encode(cdn);
        this.f22219l.add(cdn);
        final GGKData gGKData2 = gGKData;
        this.f22222o.execute(new Runnable() {
            public void run() {
                long currentTimeMillis;
                try {
                    if (!CDNCacheManager.this.m16052a(str, cdn, weakReference, gGKData2)) {
                        GRBaseResourceLoader resourceLoader = GRResourceLoaderFactory.getResourceLoader(1);
                        currentTimeMillis = System.currentTimeMillis();
                        if (resourceLoader != null) {
                            if (!TextUtils.isEmpty(resourceLoader.hasResource(CDNCacheManager.this.f22217j, cdn))) {
                                AssetManager assets = CDNCacheManager.this.f22217j.getAssets();
                                CDNCacheManager.this.m16048a(assets.open("xml/" + resourceLoader.hasResource(CDNCacheManager.this.f22217j, cdn)), str);
                                SystemUtils.log(3, "lxsLoadTime", (System.currentTimeMillis() - currentTimeMillis) + "", (Throwable) null, "com.didi.global.globalgenerickit.template.yoga.CDNCacheManager$2", 102);
                                boolean unused = CDNCacheManager.this.m16052a(str, cdn, weakReference, gGKData2);
                                CDNCacheManager.this.f22219l.remove(cdn);
                                return;
                            }
                        }
                        SystemUtils.log(4, CDNCacheManager.f22208b, "loadCdn 下载cdn " + cdn, (Throwable) null, "com.didi.global.globalgenerickit.template.yoga.CDNCacheManager$2", 121);
                        int a = CDNCacheManager.this.m16041a(str, cdn);
                        File file = new File(str + File.separator + "template" + ".zip");
                        if (a == 2) {
                            SystemUtils.log(4, CDNCacheManager.f22208b, "load cnd failed: cdn=" + cdn + ", template=" + template, (Throwable) null, "com.didi.global.globalgenerickit.template.yoga.CDNCacheManager$2", 126);
                        } else {
                            CDNCacheManager.this.m16047a(file, str);
                            SystemUtils.log(3, "lxsLoadTimeNet", (System.currentTimeMillis() - currentTimeMillis) + "", (Throwable) null, "com.didi.global.globalgenerickit.template.yoga.CDNCacheManager$2", 130);
                            boolean unused2 = CDNCacheManager.this.m16052a(str, cdn, weakReference, gGKData2);
                            CDNCacheManager.this.f22219l.remove(cdn);
                            return;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    int a2 = CDNCacheManager.this.m16041a(str, cdn);
                    File file2 = new File(str + File.separator + "template" + ".zip");
                    if (a2 == 2) {
                        SystemUtils.log(4, CDNCacheManager.f22208b, "load cnd failed: cdn=" + cdn + ", template=" + template, (Throwable) null, "com.didi.global.globalgenerickit.template.yoga.CDNCacheManager$2", 111);
                    } else {
                        CDNCacheManager.this.m16047a(file2, str);
                        SystemUtils.log(3, "lxsLoadTime", (System.currentTimeMillis() - currentTimeMillis) + "", (Throwable) null, "com.didi.global.globalgenerickit.template.yoga.CDNCacheManager$2", 115);
                        boolean unused3 = CDNCacheManager.this.m16052a(str, cdn, weakReference, gGKData2);
                    }
                } catch (Throwable th) {
                    CDNCacheManager.this.f22219l.remove(cdn);
                    throw th;
                }
                CDNCacheManager.this.f22219l.remove(cdn);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m16052a(String str, String str2, WeakReference<GGKViewBinder> weakReference, GGKData gGKData) {
        File a = m16042a(str + File.separator + "template" + f22212f);
        File a2 = m16042a(str + File.separator + "template" + ".js");
        if (a == null || a2 == null) {
            return false;
        }
        m16050a(str, str2, m16043a(a), m16043a(a2), weakReference, gGKData);
        return true;
    }

    private static class SingleTon {
        /* access modifiers changed from: private */
        public static CDNCacheManager sInstance = new CDNCacheManager();

        private SingleTon() {
        }
    }

    public static CDNCacheManager getInstance(Context context) {
        if (SingleTon.sInstance.f22217j == null) {
            SingleTon.sInstance.f22217j = context.getApplicationContext();
            CDNCacheManager access$800 = SingleTon.sInstance;
            access$800.f22220m = context.getCacheDir() + File.separator + "cdn_cache";
        }
        return SingleTon.sInstance;
    }

    /* renamed from: a */
    private File m16042a(String str) {
        File file = new File(str);
        if (!file.isFile() || !file.exists()) {
            return null;
        }
        return file;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A[SYNTHETIC, Splitter:B:23:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0052 A[SYNTHETIC, Splitter:B:29:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m16043a(java.io.File r6) {
        /*
            r5 = this;
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x003b, all -> 0x0036 }
            r1.<init>()     // Catch:{ IOException -> 0x003b, all -> 0x0036 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x003b, all -> 0x0036 }
            r2.<init>(r6)     // Catch:{ IOException -> 0x003b, all -> 0x0036 }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ IOException -> 0x003b, all -> 0x0036 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x003b, all -> 0x0036 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x003b, all -> 0x0036 }
            r6.<init>(r3)     // Catch:{ IOException -> 0x003b, all -> 0x0036 }
            r0 = 4096(0x1000, float:5.74E-42)
            char[] r0 = new char[r0]     // Catch:{ IOException -> 0x0034 }
        L_0x0019:
            int r2 = r6.read(r0)     // Catch:{ IOException -> 0x0034 }
            if (r2 <= 0) goto L_0x0024
            r3 = 0
            r1.append(r0, r3, r2)     // Catch:{ IOException -> 0x0034 }
            goto L_0x0019
        L_0x0024:
            r6.close()     // Catch:{ IOException -> 0x0034 }
            java.lang.String r0 = r1.toString()     // Catch:{ IOException -> 0x0034 }
            r6.close()     // Catch:{ IOException -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0033:
            return r0
        L_0x0034:
            r0 = move-exception
            goto L_0x003f
        L_0x0036:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
            goto L_0x0050
        L_0x003b:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x003f:
            r0.printStackTrace()     // Catch:{ all -> 0x004f }
            if (r6 == 0) goto L_0x004c
            r6.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x004c
        L_0x0048:
            r6 = move-exception
            r6.printStackTrace()
        L_0x004c:
            java.lang.String r6 = ""
            return r6
        L_0x004f:
            r0 = move-exception
        L_0x0050:
            if (r6 == 0) goto L_0x005a
            r6.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x005a
        L_0x0056:
            r6 = move-exception
            r6.printStackTrace()
        L_0x005a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.globalgenerickit.template.yoga.CDNCacheManager.m16043a(java.io.File):java.lang.String");
    }

    /* renamed from: a */
    private void m16050a(String str, String str2, String str3, String str4, WeakReference<GGKViewBinder> weakReference, GGKData gGKData) {
        String str5 = str;
        String str6 = str2;
        String str7 = str4;
        Element parseXML = KitHelper.parseXML(str3);
        if (parseXML == null || str7 == null) {
            SystemUtils.log(4, f22208b, "doCdnCallback js 或者 template 文件存在问题，删除", (Throwable) null, "com.didi.global.globalgenerickit.template.yoga.CDNCacheManager", 239);
            File file = new File(str5 + File.separator + "template" + f22212f);
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(str5 + File.separator + "template" + ".js");
            if (file2.exists()) {
                file2.delete();
                return;
            }
            return;
        }
        SystemUtils.log(4, f22208b, "doCdnCallback 写入缓存，cdn=" + str6, (Throwable) null, "com.didi.global.globalgenerickit.template.yoga.CDNCacheManager", 210);
        final XMLCacheEntity xMLCacheEntity = new XMLCacheEntity();
        xMLCacheEntity.element = parseXML;
        xMLCacheEntity.script = str7;
        this.f22221n.put(str6, xMLCacheEntity);
        final String str8 = str2;
        final GGKData gGKData2 = gGKData;
        final WeakReference<GGKViewBinder> weakReference2 = weakReference;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                synchronized (CDNCacheManager.class) {
                    Set<GGKData.CDNCallback> a = CDNCacheManager.this.m16054b(str8);
                    if (!(gGKData2 == null || a == null)) {
                        HashSet<GGKData.CDNCallback> hashSet = new HashSet<>();
                        for (GGKData.CDNCallback cDNCallback : a) {
                            cDNCallback.onCDNCached();
                            hashSet.add(cDNCallback);
                        }
                        for (GGKData.CDNCallback remove : hashSet) {
                            a.remove(remove);
                        }
                    }
                    GGKViewBinder gGKViewBinder = (GGKViewBinder) weakReference2.get();
                    if (gGKViewBinder != null) {
                        gGKViewBinder.onCDNCached(xMLCacheEntity);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0101 A[SYNTHETIC, Splitter:B:57:0x0101] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0106 A[Catch:{ IOException -> 0x00de }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x010b A[Catch:{ IOException -> 0x00de }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0112 A[SYNTHETIC, Splitter:B:66:0x0112] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x011a A[Catch:{ IOException -> 0x0116 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x011f A[Catch:{ IOException -> 0x0116 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int m16041a(java.lang.String r12, java.lang.String r13) {
        /*
            r11 = this;
            r0 = 2
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            r2.<init>(r12)     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            r3.<init>()     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            r3.append(r12)     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            java.lang.String r12 = java.io.File.separator     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            r3.append(r12)     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            java.lang.String r12 = "template"
            r3.append(r12)     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            java.lang.String r12 = r3.toString()     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            boolean r3 = r2.exists()     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            if (r3 != 0) goto L_0x0027
            r2.mkdirs()     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
        L_0x0027:
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            r3.<init>()     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            r3.append(r12)     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            java.lang.String r4 = ".tmp"
            r3.append(r4)     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            boolean r3 = r2.exists()     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            if (r3 != 0) goto L_0x0046
            r2.createNewFile()     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
        L_0x0046:
            java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            r3.<init>(r13)     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            java.net.URLConnection r13 = r3.openConnection()     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            java.net.HttpURLConnection r13 = (java.net.HttpURLConnection) r13     // Catch:{ IOException -> 0x00f9, all -> 0x00f5 }
            java.lang.String r3 = "GET"
            r13.setRequestMethod(r3)     // Catch:{ IOException -> 0x00f2, all -> 0x00ef }
            r3 = 5000(0x1388, float:7.006E-42)
            r13.setConnectTimeout(r3)     // Catch:{ IOException -> 0x00f2, all -> 0x00ef }
            r13.setReadTimeout(r3)     // Catch:{ IOException -> 0x00f2, all -> 0x00ef }
            int r3 = r13.getResponseCode()     // Catch:{ IOException -> 0x00f2, all -> 0x00ef }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L_0x00c9
            java.io.InputStream r3 = r13.getInputStream()     // Catch:{ IOException -> 0x00f2, all -> 0x00ef }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00f2, all -> 0x00ef }
            r4.<init>(r3)     // Catch:{ IOException -> 0x00f2, all -> 0x00ef }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x00c5, all -> 0x00c1 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00c5, all -> 0x00c1 }
            r5.<init>(r2)     // Catch:{ IOException -> 0x00c5, all -> 0x00c1 }
            r3.<init>(r5)     // Catch:{ IOException -> 0x00c5, all -> 0x00c1 }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x00bf, all -> 0x00bd }
        L_0x007d:
            int r5 = r4.read(r1)     // Catch:{ IOException -> 0x00bf, all -> 0x00bd }
            r6 = -1
            if (r5 == r6) goto L_0x0089
            r6 = 0
            r3.write(r1, r6, r5)     // Catch:{ IOException -> 0x00bf, all -> 0x00bd }
            goto L_0x007d
        L_0x0089:
            java.lang.String r6 = "CDNCacheManager"
            java.lang.String r7 = "下载成功，开始解压"
            r5 = 4
            r8 = 0
            java.lang.String r9 = "com.didi.global.globalgenerickit.template.yoga.CDNCacheManager"
            r10 = 289(0x121, float:4.05E-43)
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)     // Catch:{ IOException -> 0x00bf, all -> 0x00bd }
            r3.flush()     // Catch:{ IOException -> 0x00bf, all -> 0x00bd }
            r4.close()     // Catch:{ IOException -> 0x00bf, all -> 0x00bd }
            r3.close()     // Catch:{ IOException -> 0x00bf, all -> 0x00bd }
            r1 = 1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00bf, all -> 0x00bd }
            r5.<init>()     // Catch:{ IOException -> 0x00bf, all -> 0x00bd }
            r5.append(r12)     // Catch:{ IOException -> 0x00bf, all -> 0x00bd }
            java.lang.String r12 = ".zip"
            r5.append(r12)     // Catch:{ IOException -> 0x00bf, all -> 0x00bd }
            java.lang.String r12 = r5.toString()     // Catch:{ IOException -> 0x00bf, all -> 0x00bd }
            java.io.File r5 = new java.io.File     // Catch:{ IOException -> 0x00bf, all -> 0x00bd }
            r5.<init>(r12)     // Catch:{ IOException -> 0x00bf, all -> 0x00bd }
            r2.renameTo(r5)     // Catch:{ IOException -> 0x00bf, all -> 0x00bd }
            r1 = r4
            r0 = 1
            goto L_0x00d8
        L_0x00bd:
            r12 = move-exception
            goto L_0x00c3
        L_0x00bf:
            r12 = move-exception
            goto L_0x00c7
        L_0x00c1:
            r12 = move-exception
            r3 = r1
        L_0x00c3:
            r1 = r4
            goto L_0x0110
        L_0x00c5:
            r12 = move-exception
            r3 = r1
        L_0x00c7:
            r1 = r4
            goto L_0x00fc
        L_0x00c9:
            java.lang.String r3 = "CDNCacheManager"
            java.lang.String r4 = "网络请求失败"
            r2 = 4
            r5 = 0
            java.lang.String r6 = "com.didi.global.globalgenerickit.template.yoga.CDNCacheManager"
            r7 = 298(0x12a, float:4.18E-43)
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x00f2, all -> 0x00ef }
            r3 = r1
        L_0x00d8:
            if (r1 == 0) goto L_0x00e0
            r1.close()     // Catch:{ IOException -> 0x00de }
            goto L_0x00e0
        L_0x00de:
            r12 = move-exception
            goto L_0x00eb
        L_0x00e0:
            if (r3 == 0) goto L_0x00e5
            r3.close()     // Catch:{ IOException -> 0x00de }
        L_0x00e5:
            if (r13 == 0) goto L_0x010e
            r13.disconnect()     // Catch:{ IOException -> 0x00de }
            goto L_0x010e
        L_0x00eb:
            r12.printStackTrace()
            goto L_0x010e
        L_0x00ef:
            r12 = move-exception
            r3 = r1
            goto L_0x0110
        L_0x00f2:
            r12 = move-exception
            r3 = r1
            goto L_0x00fc
        L_0x00f5:
            r12 = move-exception
            r13 = r1
            r3 = r13
            goto L_0x0110
        L_0x00f9:
            r12 = move-exception
            r13 = r1
            r3 = r13
        L_0x00fc:
            r12.printStackTrace()     // Catch:{ all -> 0x010f }
            if (r1 == 0) goto L_0x0104
            r1.close()     // Catch:{ IOException -> 0x00de }
        L_0x0104:
            if (r3 == 0) goto L_0x0109
            r3.close()     // Catch:{ IOException -> 0x00de }
        L_0x0109:
            if (r13 == 0) goto L_0x010e
            r13.disconnect()     // Catch:{ IOException -> 0x00de }
        L_0x010e:
            return r0
        L_0x010f:
            r12 = move-exception
        L_0x0110:
            if (r1 == 0) goto L_0x0118
            r1.close()     // Catch:{ IOException -> 0x0116 }
            goto L_0x0118
        L_0x0116:
            r13 = move-exception
            goto L_0x0123
        L_0x0118:
            if (r3 == 0) goto L_0x011d
            r3.close()     // Catch:{ IOException -> 0x0116 }
        L_0x011d:
            if (r13 == 0) goto L_0x0126
            r13.disconnect()     // Catch:{ IOException -> 0x0116 }
            goto L_0x0126
        L_0x0123:
            r13.printStackTrace()
        L_0x0126:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.globalgenerickit.template.yoga.CDNCacheManager.m16041a(java.lang.String, java.lang.String):int");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00cb A[SYNTHETIC, Splitter:B:42:0x00cb] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00df A[SYNTHETIC, Splitter:B:50:0x00df] */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m16047a(java.io.File r12, java.lang.String r13) {
        /*
            r11 = this;
            r0 = 0
            java.util.zip.ZipInputStream r1 = new java.util.zip.ZipInputStream     // Catch:{ Exception -> 0x00bc }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00bc }
            r2.<init>(r12)     // Catch:{ Exception -> 0x00bc }
            r1.<init>(r2)     // Catch:{ Exception -> 0x00bc }
        L_0x000b:
            java.util.zip.ZipEntry r0 = r1.getNextEntry()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            if (r0 == 0) goto L_0x00a7
            java.lang.String r2 = r0.getName()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            java.lang.String r3 = "../"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            if (r3 == 0) goto L_0x002b
            java.lang.String r5 = "CDNCacheManager"
            java.lang.String r6 = "Unsecurity zip file!!"
            r4 = 6
            r7 = 0
            java.lang.String r8 = "com.didi.global.globalgenerickit.template.yoga.CDNCacheManager"
            r9 = 338(0x152, float:4.74E-43)
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            goto L_0x000b
        L_0x002b:
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r4.<init>()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r4.append(r13)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            java.lang.String r5 = java.io.File.separator     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r4.append(r5)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r4.append(r2)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            java.lang.String r6 = "CDNCacheManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r4.<init>()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            java.lang.String r5 = "解压文件 "
            r4.append(r5)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r4.append(r2)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            java.lang.String r7 = r4.toString()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r5 = 4
            r8 = 0
            java.lang.String r9 = "com.didi.global.globalgenerickit.template.yoga.CDNCacheManager"
            r10 = 342(0x156, float:4.79E-43)
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            java.io.File r2 = r3.getParentFile()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            boolean r2 = r2.exists()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            if (r2 != 0) goto L_0x0072
            java.io.File r2 = r3.getParentFile()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r2.mkdir()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
        L_0x0072:
            boolean r0 = r0.isDirectory()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            if (r0 == 0) goto L_0x0082
            boolean r0 = r3.exists()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            if (r0 != 0) goto L_0x000b
            r3.mkdir()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            goto L_0x000b
        L_0x0082:
            boolean r0 = r3.exists()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            if (r0 != 0) goto L_0x008b
            r3.createNewFile()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
        L_0x008b:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
        L_0x0094:
            int r3 = r1.read(r2)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            if (r3 <= 0) goto L_0x009f
            r4 = 0
            r0.write(r2, r4, r3)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            goto L_0x0094
        L_0x009f:
            r0.flush()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r0.close()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            goto L_0x000b
        L_0x00a7:
            boolean r13 = r12.exists()
            if (r13 == 0) goto L_0x00b0
            r12.delete()
        L_0x00b0:
            r1.close()     // Catch:{ IOException -> 0x00cf }
            goto L_0x00d3
        L_0x00b4:
            r13 = move-exception
            r0 = r1
            goto L_0x00d4
        L_0x00b7:
            r13 = move-exception
            r0 = r1
            goto L_0x00bd
        L_0x00ba:
            r13 = move-exception
            goto L_0x00d4
        L_0x00bc:
            r13 = move-exception
        L_0x00bd:
            r13.printStackTrace()     // Catch:{ all -> 0x00ba }
            boolean r13 = r12.exists()
            if (r13 == 0) goto L_0x00c9
            r12.delete()
        L_0x00c9:
            if (r0 == 0) goto L_0x00d3
            r0.close()     // Catch:{ IOException -> 0x00cf }
            goto L_0x00d3
        L_0x00cf:
            r12 = move-exception
            r12.printStackTrace()
        L_0x00d3:
            return
        L_0x00d4:
            boolean r1 = r12.exists()
            if (r1 == 0) goto L_0x00dd
            r12.delete()
        L_0x00dd:
            if (r0 == 0) goto L_0x00e7
            r0.close()     // Catch:{ IOException -> 0x00e3 }
            goto L_0x00e7
        L_0x00e3:
            r12 = move-exception
            r12.printStackTrace()
        L_0x00e7:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.globalgenerickit.template.yoga.CDNCacheManager.m16047a(java.io.File, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c2 A[SYNTHETIC, Splitter:B:39:0x00c2] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cd A[SYNTHETIC, Splitter:B:44:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m16048a(java.io.InputStream r11, java.lang.String r12) {
        /*
            r10 = this;
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x00bc }
            r1.<init>(r12)     // Catch:{ Exception -> 0x00bc }
            boolean r2 = r1.exists()     // Catch:{ Exception -> 0x00bc }
            if (r2 != 0) goto L_0x000f
            r1.mkdirs()     // Catch:{ Exception -> 0x00bc }
        L_0x000f:
            java.util.zip.ZipInputStream r1 = new java.util.zip.ZipInputStream     // Catch:{ Exception -> 0x00bc }
            r1.<init>(r11)     // Catch:{ Exception -> 0x00bc }
        L_0x0014:
            java.util.zip.ZipEntry r11 = r1.getNextEntry()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            if (r11 == 0) goto L_0x00b0
            java.lang.String r0 = r11.getName()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            java.lang.String r2 = "../"
            boolean r2 = r0.contains(r2)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            if (r2 == 0) goto L_0x0034
            java.lang.String r4 = "CDNCacheManager"
            java.lang.String r5 = "Unsecurity zip file!!"
            r3 = 6
            r6 = 0
            java.lang.String r7 = "com.didi.global.globalgenerickit.template.yoga.CDNCacheManager"
            r8 = 394(0x18a, float:5.52E-43)
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            goto L_0x0014
        L_0x0034:
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r3.<init>()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r3.append(r12)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            java.lang.String r4 = java.io.File.separator     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r3.append(r4)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r3.append(r0)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            java.lang.String r5 = "CDNCacheManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r3.<init>()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            java.lang.String r4 = "解压文件 "
            r3.append(r4)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r3.append(r0)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            java.lang.String r6 = r3.toString()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r4 = 4
            r7 = 0
            java.lang.String r8 = "com.didi.global.globalgenerickit.template.yoga.CDNCacheManager"
            r9 = 398(0x18e, float:5.58E-43)
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            java.io.File r0 = r2.getParentFile()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            boolean r0 = r0.exists()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            if (r0 != 0) goto L_0x007b
            java.io.File r0 = r2.getParentFile()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r0.mkdir()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
        L_0x007b:
            boolean r11 = r11.isDirectory()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            if (r11 == 0) goto L_0x008b
            boolean r11 = r2.exists()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            if (r11 != 0) goto L_0x0014
            r2.mkdir()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            goto L_0x0014
        L_0x008b:
            boolean r11 = r2.exists()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            if (r11 != 0) goto L_0x0094
            r2.createNewFile()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
        L_0x0094:
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r11.<init>(r2)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
        L_0x009d:
            int r2 = r1.read(r0)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            if (r2 <= 0) goto L_0x00a8
            r3 = 0
            r11.write(r0, r3, r2)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            goto L_0x009d
        L_0x00a8:
            r11.flush()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            r11.close()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
            goto L_0x0014
        L_0x00b0:
            r1.close()     // Catch:{ IOException -> 0x00c6 }
            goto L_0x00ca
        L_0x00b4:
            r11 = move-exception
            r0 = r1
            goto L_0x00cb
        L_0x00b7:
            r11 = move-exception
            r0 = r1
            goto L_0x00bd
        L_0x00ba:
            r11 = move-exception
            goto L_0x00cb
        L_0x00bc:
            r11 = move-exception
        L_0x00bd:
            r11.printStackTrace()     // Catch:{ all -> 0x00ba }
            if (r0 == 0) goto L_0x00ca
            r0.close()     // Catch:{ IOException -> 0x00c6 }
            goto L_0x00ca
        L_0x00c6:
            r11 = move-exception
            r11.printStackTrace()
        L_0x00ca:
            return
        L_0x00cb:
            if (r0 == 0) goto L_0x00d5
            r0.close()     // Catch:{ IOException -> 0x00d1 }
            goto L_0x00d5
        L_0x00d1:
            r12 = move-exception
            r12.printStackTrace()
        L_0x00d5:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.globalgenerickit.template.yoga.CDNCacheManager.m16048a(java.io.InputStream, java.lang.String):void");
    }

    /* renamed from: a */
    private void m16049a(String str, GGKData.CDNCallback cDNCallback) {
        if (!TextUtils.isEmpty(str) && cDNCallback != null) {
            if (this.f22216a.containsKey(str)) {
                this.f22216a.get(str).add(cDNCallback);
                return;
            }
            HashSet hashSet = new HashSet();
            hashSet.add(cDNCallback);
            this.f22216a.put(str, hashSet);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public Set<GGKData.CDNCallback> m16054b(String str) {
        return this.f22216a.get(str);
    }
}
