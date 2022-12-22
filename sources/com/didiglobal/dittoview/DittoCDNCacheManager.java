package com.didiglobal.dittoview;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.didi.global.globalresource.GRBaseResourceLoader;
import com.didi.global.globalresource.GRResourceLoaderFactory;
import com.didi.global.globaluikit.utils.UIThreadHandler;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.dittoview.callback.CDNCallback;
import com.didiglobal.dittoview.constant.DittoErrNo;
import com.didiglobal.dittoview.mvvm.DittoData;
import com.didiglobal.dittoview.mvvm.DittoViewBinder;
import com.didiglobal.dittoview.util.DittoUtil;
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

public class DittoCDNCacheManager {

    /* renamed from: b */
    private static final String f49858b = "CDNCacheManager";

    /* renamed from: c */
    private static final String f49859c = "template";

    /* renamed from: d */
    private static final String f49860d = ".tmp";

    /* renamed from: e */
    private static final String f49861e = ".zip";

    /* renamed from: f */
    private static final String f49862f = ".xml";

    /* renamed from: g */
    private static final String f49863g = ".js";

    /* renamed from: h */
    private static final int f49864h = 1;

    /* renamed from: i */
    private static final int f49865i = 2;

    /* renamed from: a */
    Map<String, Set<CDNCallback>> f49866a;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Context f49867j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f49868k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Set<String> f49869l;

    /* renamed from: m */
    private String f49870m;

    /* renamed from: n */
    private LinkedHashMap<String, DittoXMLCacheEntity> f49871n;

    /* renamed from: o */
    private ExecutorService f49872o;

    private DittoCDNCacheManager() {
        this.f49868k = 40;
        this.f49869l = Collections.synchronizedSet(new HashSet());
        this.f49866a = new HashMap();
        this.f49871n = new LinkedHashMap<String, DittoXMLCacheEntity>(this.f49868k) {
            /* access modifiers changed from: protected */
            public boolean removeEldestEntry(Map.Entry<String, DittoXMLCacheEntity> entry) {
                return size() > DittoCDNCacheManager.this.f49868k;
            }
        };
        this.f49872o = new ThreadPoolExecutor(2, 10, 60, TimeUnit.SECONDS, new ArrayBlockingQueue(20), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    public DittoXMLCacheEntity get(String str) {
        return this.f49871n.get(str);
    }

    public void tryCache(DittoData dittoData, DittoViewBinder dittoViewBinder) {
        final WeakReference weakReference = new WeakReference(dittoViewBinder);
        final String cdn = dittoData.getCdn();
        final String template = dittoData.getTemplate();
        m35963a(cdn, dittoData.getCDNCallback());
        if (TextUtils.isEmpty(cdn) || TextUtils.isEmpty(template) || this.f49869l.contains(cdn)) {
            SystemUtils.log(4, f49858b, cdn + " 任务重复 或者 cdn template 为空", (Throwable) null, "com.didiglobal.dittoview.DittoCDNCacheManager", 83);
            return;
        }
        final String str = this.f49870m + File.separator + template + File.separator + DittoUtil.MD5encode(cdn);
        this.f49869l.add(cdn);
        final DittoData dittoData2 = dittoData;
        this.f49872o.execute(new Runnable() {
            public void run() {
                long currentTimeMillis;
                try {
                    if (!DittoCDNCacheManager.this.m35966a(str, cdn, weakReference, dittoData2)) {
                        GRBaseResourceLoader resourceLoader = GRResourceLoaderFactory.getResourceLoader(1);
                        currentTimeMillis = System.currentTimeMillis();
                        if (resourceLoader != null) {
                            if (!TextUtils.isEmpty(resourceLoader.hasResource(DittoCDNCacheManager.this.f49867j, cdn))) {
                                AssetManager assets = DittoCDNCacheManager.this.f49867j.getAssets();
                                DittoCDNCacheManager.this.m35962a(assets.open("xml/" + resourceLoader.hasResource(DittoCDNCacheManager.this.f49867j, cdn)), str);
                                SystemUtils.log(3, "lxsLoadTime", (System.currentTimeMillis() - currentTimeMillis) + "", (Throwable) null, "com.didiglobal.dittoview.DittoCDNCacheManager$2", 106);
                                boolean unused = DittoCDNCacheManager.this.m35966a(str, cdn, weakReference, dittoData2);
                                DittoCDNCacheManager.this.f49869l.remove(cdn);
                                return;
                            }
                        }
                        SystemUtils.log(4, DittoCDNCacheManager.f49858b, "loadCdn 下载cdn " + cdn, (Throwable) null, "com.didiglobal.dittoview.DittoCDNCacheManager$2", 126);
                        int a = DittoCDNCacheManager.this.m35953a(str, cdn);
                        File file = new File(str + File.separator + "template" + ".zip");
                        if (a == 2) {
                            SystemUtils.log(4, DittoCDNCacheManager.f49858b, "load cnd failed: cdn=" + cdn + ", template=" + template, (Throwable) null, "com.didiglobal.dittoview.DittoCDNCacheManager$2", 131);
                            DittoCDNCacheManager.this.m35960a(dittoData2, DittoErrNo.ERR_DOWNLOAD_FAILED);
                        } else {
                            DittoCDNCacheManager.this.m35961a(file, str);
                            SystemUtils.log(3, "lxsLoadTimeNet", (System.currentTimeMillis() - currentTimeMillis) + "", (Throwable) null, "com.didiglobal.dittoview.DittoCDNCacheManager$2", 136);
                            boolean unused2 = DittoCDNCacheManager.this.m35966a(str, cdn, weakReference, dittoData2);
                            DittoCDNCacheManager.this.f49869l.remove(cdn);
                            return;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    int a2 = DittoCDNCacheManager.this.m35953a(str, cdn);
                    File file2 = new File(str + File.separator + "template" + ".zip");
                    if (a2 == 2) {
                        SystemUtils.log(4, DittoCDNCacheManager.f49858b, "load cnd failed: cdn=" + cdn + ", template=" + template, (Throwable) null, "com.didiglobal.dittoview.DittoCDNCacheManager$2", 115);
                        DittoCDNCacheManager.this.m35960a(dittoData2, DittoErrNo.ERR_DOWNLOAD_FAILED);
                    } else {
                        DittoCDNCacheManager.this.m35961a(file2, str);
                        SystemUtils.log(3, "lxsLoadTime", (System.currentTimeMillis() - currentTimeMillis) + "", (Throwable) null, "com.didiglobal.dittoview.DittoCDNCacheManager$2", 120);
                        boolean unused3 = DittoCDNCacheManager.this.m35966a(str, cdn, weakReference, dittoData2);
                    }
                } catch (Throwable th) {
                    DittoCDNCacheManager.this.f49869l.remove(cdn);
                    throw th;
                }
                DittoCDNCacheManager.this.f49869l.remove(cdn);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35960a(final DittoData dittoData, final String str) {
        if (dittoData != null && dittoData.getCDNCallback() != null) {
            UIThreadHandler.post(new Runnable() {
                public void run() {
                    dittoData.getCDNCallback().onCDNCachedFailed(str);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m35966a(String str, String str2, WeakReference<DittoViewBinder> weakReference, DittoData dittoData) {
        File a = m35954a(str + File.separator + "template" + f49862f);
        File a2 = m35954a(str + File.separator + "template" + ".js");
        if (a == null || a2 == null) {
            return false;
        }
        m35964a(str, str2, m35955a(a), m35955a(a2), weakReference, dittoData);
        return true;
    }

    private static class SingleTon {
        /* access modifiers changed from: private */
        public static DittoCDNCacheManager sInstance = new DittoCDNCacheManager();

        private SingleTon() {
        }
    }

    public static DittoCDNCacheManager getInstance(Context context) {
        if (SingleTon.sInstance.f49867j == null) {
            SingleTon.sInstance.f49867j = context.getApplicationContext();
            DittoCDNCacheManager access$900 = SingleTon.sInstance;
            access$900.f49870m = context.getCacheDir() + File.separator + "cdn_cache";
        }
        return SingleTon.sInstance;
    }

    /* renamed from: a */
    private File m35954a(String str) {
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
    private java.lang.String m35955a(java.io.File r6) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.dittoview.DittoCDNCacheManager.m35955a(java.io.File):java.lang.String");
    }

    /* renamed from: a */
    private void m35964a(String str, String str2, String str3, String str4, WeakReference<DittoViewBinder> weakReference, DittoData dittoData) {
        String str5 = str;
        String str6 = str2;
        String str7 = str4;
        Element parseXML = DittoUtil.parseXML(str3);
        if (parseXML == null || str7 == null) {
            SystemUtils.log(4, f49858b, "doCdnCallback js 或者 template 文件存在问题，删除", (Throwable) null, "com.didiglobal.dittoview.DittoCDNCacheManager", 261);
            File file = new File(str + File.separator + "template" + f49862f);
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(str + File.separator + "template" + ".js");
            if (file2.exists()) {
                file2.delete();
            }
            m35960a(dittoData, DittoErrNo.ERR_INVALID_JS_OR_TEMPLATE);
            return;
        }
        SystemUtils.log(4, f49858b, "doCdnCallback 写入缓存，cdn=" + str6, (Throwable) null, "com.didiglobal.dittoview.DittoCDNCacheManager", 232);
        final DittoXMLCacheEntity dittoXMLCacheEntity = new DittoXMLCacheEntity();
        dittoXMLCacheEntity.element = parseXML;
        dittoXMLCacheEntity.script = str7;
        this.f49871n.put(str6, dittoXMLCacheEntity);
        final String str8 = str2;
        final DittoData dittoData2 = dittoData;
        final WeakReference<DittoViewBinder> weakReference2 = weakReference;
        UIThreadHandler.post(new Runnable() {
            public void run() {
                synchronized (DittoCDNCacheManager.class) {
                    Set<CDNCallback> a = DittoCDNCacheManager.this.m35968b(str8);
                    if (!(dittoData2 == null || a == null)) {
                        HashSet<CDNCallback> hashSet = new HashSet<>();
                        for (CDNCallback cDNCallback : a) {
                            cDNCallback.onCDNCached();
                            hashSet.add(cDNCallback);
                        }
                        for (CDNCallback remove : hashSet) {
                            a.remove(remove);
                        }
                    }
                    DittoViewBinder dittoViewBinder = (DittoViewBinder) weakReference2.get();
                    if (dittoViewBinder != null) {
                        dittoViewBinder.onCDNCached(dittoXMLCacheEntity);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00fe A[SYNTHETIC, Splitter:B:57:0x00fe] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0103 A[Catch:{ IOException -> 0x00db }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0108 A[Catch:{ IOException -> 0x00db }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x010f A[SYNTHETIC, Splitter:B:66:0x010f] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0117 A[Catch:{ IOException -> 0x0113 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x011c A[Catch:{ IOException -> 0x0113 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int m35953a(java.lang.String r12, java.lang.String r13) {
        /*
            r11 = this;
            r0 = 2
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            r2.<init>(r12)     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            r3.<init>()     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            r3.append(r12)     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            java.lang.String r12 = java.io.File.separator     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            r3.append(r12)     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            java.lang.String r12 = "template"
            r3.append(r12)     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            java.lang.String r12 = r3.toString()     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            boolean r3 = r2.exists()     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            if (r3 != 0) goto L_0x0026
            r2.mkdirs()     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
        L_0x0026:
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            r3.<init>()     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            r3.append(r12)     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            java.lang.String r4 = ".tmp"
            r3.append(r4)     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            boolean r3 = r2.exists()     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            if (r3 != 0) goto L_0x0045
            r2.createNewFile()     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
        L_0x0045:
            java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            r3.<init>(r13)     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            java.net.URLConnection r13 = r3.openConnection()     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            java.net.HttpURLConnection r13 = (java.net.HttpURLConnection) r13     // Catch:{ IOException -> 0x00f6, all -> 0x00f2 }
            java.lang.String r3 = "GET"
            r13.setRequestMethod(r3)     // Catch:{ IOException -> 0x00ef, all -> 0x00ec }
            r3 = 5000(0x1388, float:7.006E-42)
            r13.setConnectTimeout(r3)     // Catch:{ IOException -> 0x00ef, all -> 0x00ec }
            r13.setReadTimeout(r3)     // Catch:{ IOException -> 0x00ef, all -> 0x00ec }
            int r3 = r13.getResponseCode()     // Catch:{ IOException -> 0x00ef, all -> 0x00ec }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L_0x00c7
            java.io.InputStream r3 = r13.getInputStream()     // Catch:{ IOException -> 0x00ef, all -> 0x00ec }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00ef, all -> 0x00ec }
            r4.<init>(r3)     // Catch:{ IOException -> 0x00ef, all -> 0x00ec }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x00c3, all -> 0x00bf }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00c3, all -> 0x00bf }
            r5.<init>(r2)     // Catch:{ IOException -> 0x00c3, all -> 0x00bf }
            r3.<init>(r5)     // Catch:{ IOException -> 0x00c3, all -> 0x00bf }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x00bd, all -> 0x00bb }
        L_0x007c:
            int r5 = r4.read(r1)     // Catch:{ IOException -> 0x00bd, all -> 0x00bb }
            r6 = -1
            if (r5 == r6) goto L_0x0088
            r6 = 0
            r3.write(r1, r6, r5)     // Catch:{ IOException -> 0x00bd, all -> 0x00bb }
            goto L_0x007c
        L_0x0088:
            java.lang.String r6 = "CDNCacheManager"
            java.lang.String r7 = "下载成功，开始解压"
            r5 = 4
            r8 = 0
            java.lang.String r9 = "com.didiglobal.dittoview.DittoCDNCacheManager"
            r10 = 313(0x139, float:4.39E-43)
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)     // Catch:{ IOException -> 0x00bd, all -> 0x00bb }
            r3.flush()     // Catch:{ IOException -> 0x00bd, all -> 0x00bb }
            r4.close()     // Catch:{ IOException -> 0x00bd, all -> 0x00bb }
            r3.close()     // Catch:{ IOException -> 0x00bd, all -> 0x00bb }
            r1 = 1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00bd, all -> 0x00bb }
            r5.<init>()     // Catch:{ IOException -> 0x00bd, all -> 0x00bb }
            r5.append(r12)     // Catch:{ IOException -> 0x00bd, all -> 0x00bb }
            java.lang.String r12 = ".zip"
            r5.append(r12)     // Catch:{ IOException -> 0x00bd, all -> 0x00bb }
            java.lang.String r12 = r5.toString()     // Catch:{ IOException -> 0x00bd, all -> 0x00bb }
            java.io.File r5 = new java.io.File     // Catch:{ IOException -> 0x00bd, all -> 0x00bb }
            r5.<init>(r12)     // Catch:{ IOException -> 0x00bd, all -> 0x00bb }
            r2.renameTo(r5)     // Catch:{ IOException -> 0x00bd, all -> 0x00bb }
            r1 = r4
            r0 = 1
            goto L_0x00d5
        L_0x00bb:
            r12 = move-exception
            goto L_0x00c1
        L_0x00bd:
            r12 = move-exception
            goto L_0x00c5
        L_0x00bf:
            r12 = move-exception
            r3 = r1
        L_0x00c1:
            r1 = r4
            goto L_0x010d
        L_0x00c3:
            r12 = move-exception
            r3 = r1
        L_0x00c5:
            r1 = r4
            goto L_0x00f9
        L_0x00c7:
            java.lang.String r3 = "CDNCacheManager"
            java.lang.String r4 = "网络请求失败"
            r2 = 4
            r5 = 0
            java.lang.String r6 = "com.didiglobal.dittoview.DittoCDNCacheManager"
            r7 = 322(0x142, float:4.51E-43)
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x00ef, all -> 0x00ec }
            r3 = r1
        L_0x00d5:
            if (r1 == 0) goto L_0x00dd
            r1.close()     // Catch:{ IOException -> 0x00db }
            goto L_0x00dd
        L_0x00db:
            r12 = move-exception
            goto L_0x00e8
        L_0x00dd:
            if (r3 == 0) goto L_0x00e2
            r3.close()     // Catch:{ IOException -> 0x00db }
        L_0x00e2:
            if (r13 == 0) goto L_0x010b
            r13.disconnect()     // Catch:{ IOException -> 0x00db }
            goto L_0x010b
        L_0x00e8:
            r12.printStackTrace()
            goto L_0x010b
        L_0x00ec:
            r12 = move-exception
            r3 = r1
            goto L_0x010d
        L_0x00ef:
            r12 = move-exception
            r3 = r1
            goto L_0x00f9
        L_0x00f2:
            r12 = move-exception
            r13 = r1
            r3 = r13
            goto L_0x010d
        L_0x00f6:
            r12 = move-exception
            r13 = r1
            r3 = r13
        L_0x00f9:
            r12.printStackTrace()     // Catch:{ all -> 0x010c }
            if (r1 == 0) goto L_0x0101
            r1.close()     // Catch:{ IOException -> 0x00db }
        L_0x0101:
            if (r3 == 0) goto L_0x0106
            r3.close()     // Catch:{ IOException -> 0x00db }
        L_0x0106:
            if (r13 == 0) goto L_0x010b
            r13.disconnect()     // Catch:{ IOException -> 0x00db }
        L_0x010b:
            return r0
        L_0x010c:
            r12 = move-exception
        L_0x010d:
            if (r1 == 0) goto L_0x0115
            r1.close()     // Catch:{ IOException -> 0x0113 }
            goto L_0x0115
        L_0x0113:
            r13 = move-exception
            goto L_0x0120
        L_0x0115:
            if (r3 == 0) goto L_0x011a
            r3.close()     // Catch:{ IOException -> 0x0113 }
        L_0x011a:
            if (r13 == 0) goto L_0x0123
            r13.disconnect()     // Catch:{ IOException -> 0x0113 }
            goto L_0x0123
        L_0x0120:
            r13.printStackTrace()
        L_0x0123:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.dittoview.DittoCDNCacheManager.m35953a(java.lang.String, java.lang.String):int");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ca A[SYNTHETIC, Splitter:B:42:0x00ca] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00de A[SYNTHETIC, Splitter:B:50:0x00de] */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m35961a(java.io.File r12, java.lang.String r13) {
        /*
            r11 = this;
            r0 = 0
            java.util.zip.ZipInputStream r1 = new java.util.zip.ZipInputStream     // Catch:{ Exception -> 0x00bb }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00bb }
            r2.<init>(r12)     // Catch:{ Exception -> 0x00bb }
            r1.<init>(r2)     // Catch:{ Exception -> 0x00bb }
        L_0x000b:
            java.util.zip.ZipEntry r0 = r1.getNextEntry()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            if (r0 == 0) goto L_0x00a6
            java.lang.String r2 = r0.getName()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            java.lang.String r3 = "../"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            if (r3 == 0) goto L_0x002b
            java.lang.String r5 = "CDNCacheManager"
            java.lang.String r6 = "Unsecurity zip file!!"
            r4 = 6
            r7 = 0
            java.lang.String r8 = "com.didiglobal.dittoview.DittoCDNCacheManager"
            r9 = 373(0x175, float:5.23E-43)
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            goto L_0x000b
        L_0x002b:
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r4.<init>()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r4.append(r13)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            java.lang.String r5 = java.io.File.separator     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r4.append(r5)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r4.append(r2)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            java.lang.String r6 = "CDNCacheManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r4.<init>()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            java.lang.String r5 = "解压文件 "
            r4.append(r5)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r4.append(r2)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            java.lang.String r7 = r4.toString()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r5 = 4
            r8 = 0
            java.lang.String r9 = "com.didiglobal.dittoview.DittoCDNCacheManager"
            r10 = 377(0x179, float:5.28E-43)
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            java.io.File r2 = r3.getParentFile()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            boolean r2 = r2.exists()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            if (r2 != 0) goto L_0x0071
            java.io.File r2 = r3.getParentFile()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r2.mkdir()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
        L_0x0071:
            boolean r0 = r0.isDirectory()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            if (r0 == 0) goto L_0x0081
            boolean r0 = r3.exists()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            if (r0 != 0) goto L_0x000b
            r3.mkdir()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            goto L_0x000b
        L_0x0081:
            boolean r0 = r3.exists()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            if (r0 != 0) goto L_0x008a
            r3.createNewFile()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
        L_0x008a:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
        L_0x0093:
            int r3 = r1.read(r2)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            if (r3 <= 0) goto L_0x009e
            r4 = 0
            r0.write(r2, r4, r3)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            goto L_0x0093
        L_0x009e:
            r0.flush()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r0.close()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            goto L_0x000b
        L_0x00a6:
            boolean r13 = r12.exists()
            if (r13 == 0) goto L_0x00af
            r12.delete()
        L_0x00af:
            r1.close()     // Catch:{ IOException -> 0x00ce }
            goto L_0x00d2
        L_0x00b3:
            r13 = move-exception
            r0 = r1
            goto L_0x00d3
        L_0x00b6:
            r13 = move-exception
            r0 = r1
            goto L_0x00bc
        L_0x00b9:
            r13 = move-exception
            goto L_0x00d3
        L_0x00bb:
            r13 = move-exception
        L_0x00bc:
            r13.printStackTrace()     // Catch:{ all -> 0x00b9 }
            boolean r13 = r12.exists()
            if (r13 == 0) goto L_0x00c8
            r12.delete()
        L_0x00c8:
            if (r0 == 0) goto L_0x00d2
            r0.close()     // Catch:{ IOException -> 0x00ce }
            goto L_0x00d2
        L_0x00ce:
            r12 = move-exception
            r12.printStackTrace()
        L_0x00d2:
            return
        L_0x00d3:
            boolean r1 = r12.exists()
            if (r1 == 0) goto L_0x00dc
            r12.delete()
        L_0x00dc:
            if (r0 == 0) goto L_0x00e6
            r0.close()     // Catch:{ IOException -> 0x00e2 }
            goto L_0x00e6
        L_0x00e2:
            r12 = move-exception
            r12.printStackTrace()
        L_0x00e6:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.dittoview.DittoCDNCacheManager.m35961a(java.io.File, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c1 A[SYNTHETIC, Splitter:B:39:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cc A[SYNTHETIC, Splitter:B:44:0x00cc] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m35962a(java.io.InputStream r11, java.lang.String r12) {
        /*
            r10 = this;
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x00bb }
            r1.<init>(r12)     // Catch:{ Exception -> 0x00bb }
            boolean r2 = r1.exists()     // Catch:{ Exception -> 0x00bb }
            if (r2 != 0) goto L_0x000f
            r1.mkdirs()     // Catch:{ Exception -> 0x00bb }
        L_0x000f:
            java.util.zip.ZipInputStream r1 = new java.util.zip.ZipInputStream     // Catch:{ Exception -> 0x00bb }
            r1.<init>(r11)     // Catch:{ Exception -> 0x00bb }
        L_0x0014:
            java.util.zip.ZipEntry r11 = r1.getNextEntry()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            if (r11 == 0) goto L_0x00af
            java.lang.String r0 = r11.getName()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            java.lang.String r2 = "../"
            boolean r2 = r0.contains(r2)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            if (r2 == 0) goto L_0x0034
            java.lang.String r4 = "CDNCacheManager"
            java.lang.String r5 = "Unsecurity zip file!!"
            r3 = 6
            r6 = 0
            java.lang.String r7 = "com.didiglobal.dittoview.DittoCDNCacheManager"
            r8 = 441(0x1b9, float:6.18E-43)
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            goto L_0x0014
        L_0x0034:
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r3.<init>()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r3.append(r12)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            java.lang.String r4 = java.io.File.separator     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r3.append(r4)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r3.append(r0)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            java.lang.String r5 = "CDNCacheManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r3.<init>()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            java.lang.String r4 = "解压文件 "
            r3.append(r4)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r3.append(r0)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            java.lang.String r6 = r3.toString()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r4 = 4
            r7 = 0
            java.lang.String r8 = "com.didiglobal.dittoview.DittoCDNCacheManager"
            r9 = 445(0x1bd, float:6.24E-43)
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            java.io.File r0 = r2.getParentFile()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            boolean r0 = r0.exists()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            if (r0 != 0) goto L_0x007a
            java.io.File r0 = r2.getParentFile()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r0.mkdir()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
        L_0x007a:
            boolean r11 = r11.isDirectory()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            if (r11 == 0) goto L_0x008a
            boolean r11 = r2.exists()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            if (r11 != 0) goto L_0x0014
            r2.mkdir()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            goto L_0x0014
        L_0x008a:
            boolean r11 = r2.exists()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            if (r11 != 0) goto L_0x0093
            r2.createNewFile()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
        L_0x0093:
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r11.<init>(r2)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
        L_0x009c:
            int r2 = r1.read(r0)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            if (r2 <= 0) goto L_0x00a7
            r3 = 0
            r11.write(r0, r3, r2)     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            goto L_0x009c
        L_0x00a7:
            r11.flush()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            r11.close()     // Catch:{ Exception -> 0x00b6, all -> 0x00b3 }
            goto L_0x0014
        L_0x00af:
            r1.close()     // Catch:{ IOException -> 0x00c5 }
            goto L_0x00c9
        L_0x00b3:
            r11 = move-exception
            r0 = r1
            goto L_0x00ca
        L_0x00b6:
            r11 = move-exception
            r0 = r1
            goto L_0x00bc
        L_0x00b9:
            r11 = move-exception
            goto L_0x00ca
        L_0x00bb:
            r11 = move-exception
        L_0x00bc:
            r11.printStackTrace()     // Catch:{ all -> 0x00b9 }
            if (r0 == 0) goto L_0x00c9
            r0.close()     // Catch:{ IOException -> 0x00c5 }
            goto L_0x00c9
        L_0x00c5:
            r11 = move-exception
            r11.printStackTrace()
        L_0x00c9:
            return
        L_0x00ca:
            if (r0 == 0) goto L_0x00d4
            r0.close()     // Catch:{ IOException -> 0x00d0 }
            goto L_0x00d4
        L_0x00d0:
            r12 = move-exception
            r12.printStackTrace()
        L_0x00d4:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.dittoview.DittoCDNCacheManager.m35962a(java.io.InputStream, java.lang.String):void");
    }

    /* renamed from: a */
    private void m35963a(String str, CDNCallback cDNCallback) {
        if (!TextUtils.isEmpty(str) && cDNCallback != null) {
            if (this.f49866a.containsKey(str)) {
                this.f49866a.get(str).add(cDNCallback);
                return;
            }
            HashSet hashSet = new HashSet();
            hashSet.add(cDNCallback);
            this.f49866a.put(str, hashSet);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public Set<CDNCallback> m35968b(String str) {
        return this.f49866a.get(str);
    }
}
