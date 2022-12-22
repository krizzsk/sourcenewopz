package com.didiglobal.xbanner.template.yoga;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.xbanner.template.mdel.XBannerCDNData;
import com.didiglobal.xbanner.template.yoga.template.XBannerCDNView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collections;
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

    /* renamed from: a */
    private static final String f51500a = "CDNCacheManager";

    /* renamed from: b */
    private static final String f51501b = "template";

    /* renamed from: c */
    private static final String f51502c = ".tmp";

    /* renamed from: d */
    private static final String f51503d = ".zip";

    /* renamed from: e */
    private static final String f51504e = ".xml";

    /* renamed from: f */
    private static final String f51505f = ".js";

    /* renamed from: g */
    private static final int f51506g = 1;

    /* renamed from: h */
    private static final int f51507h = 2;

    /* renamed from: i */
    private Context f51508i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f51509j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Set<String> f51510k;

    /* renamed from: l */
    private String f51511l;

    /* renamed from: m */
    private LinkedHashMap<String, XMLCacheEntity> f51512m;

    /* renamed from: n */
    private ExecutorService f51513n;

    private CDNCacheManager() {
        this.f51509j = 40;
        this.f51510k = Collections.synchronizedSet(new HashSet());
        this.f51512m = new LinkedHashMap<String, XMLCacheEntity>(this.f51509j) {
            /* access modifiers changed from: protected */
            public boolean removeEldestEntry(Map.Entry<String, XMLCacheEntity> entry) {
                return size() > CDNCacheManager.this.f51509j;
            }
        };
        this.f51513n = new ThreadPoolExecutor(2, 10, 60, TimeUnit.SECONDS, new ArrayBlockingQueue(20), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    public XMLCacheEntity get(String str) {
        return this.f51512m.get(str);
    }

    public void tryCache(XBannerCDNData xBannerCDNData, XBannerCDNView xBannerCDNView) {
        final WeakReference weakReference = new WeakReference(xBannerCDNView);
        final String cdn = xBannerCDNData.getCdn();
        final String template = xBannerCDNData.getTemplate();
        if (TextUtils.isEmpty(cdn) || TextUtils.isEmpty(template) || this.f51510k.contains(cdn)) {
            SystemUtils.log(4, f51500a, cdn + " 任务重复 或者 cdn template 为空", (Throwable) null, "com.didiglobal.xbanner.template.yoga.CDNCacheManager", 73);
            return;
        }
        final String str = this.f51511l + File.separator + template + File.separator + KitHelper.MD5encode(cdn);
        this.f51510k.add(cdn);
        this.f51513n.execute(new Runnable() {
            public void run() {
                try {
                    if (!CDNCacheManager.this.m36873a(str, cdn, (WeakReference<XBannerCDNView>) weakReference)) {
                        SystemUtils.log(4, CDNCacheManager.f51500a, "loadCdn 下载cdn " + cdn, (Throwable) null, "com.didiglobal.xbanner.template.yoga.CDNCacheManager$2", 88);
                        int a = CDNCacheManager.this.m36866a(str, cdn);
                        File file = new File(str + File.separator + "template" + ".zip");
                        if (a == 2) {
                            SystemUtils.log(4, CDNCacheManager.f51500a, "load cnd failed: cdn=" + cdn + ", template=" + template, (Throwable) null, "com.didiglobal.xbanner.template.yoga.CDNCacheManager$2", 93);
                        } else {
                            CDNCacheManager.this.m36870a(file, str);
                            boolean unused = CDNCacheManager.this.m36873a(str, cdn, (WeakReference<XBannerCDNView>) weakReference);
                            CDNCacheManager.this.f51510k.remove(cdn);
                        }
                    }
                } finally {
                    CDNCacheManager.this.f51510k.remove(cdn);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m36873a(String str, String str2, WeakReference<XBannerCDNView> weakReference) {
        File a = m36867a(str + File.separator + "template" + f51504e);
        File a2 = m36867a(str + File.separator + "template" + ".js");
        if (a == null || a2 == null) {
            return false;
        }
        m36871a(str, str2, m36868a(a), m36868a(a2), weakReference);
        return true;
    }

    private static class SingleTon {
        /* access modifiers changed from: private */
        public static CDNCacheManager sInstance = new CDNCacheManager();

        private SingleTon() {
        }
    }

    public static CDNCacheManager getInstance(Context context) {
        if (SingleTon.sInstance.f51508i == null) {
            SingleTon.sInstance.f51508i = context.getApplicationContext();
            CDNCacheManager access$600 = SingleTon.sInstance;
            access$600.f51511l = context.getCacheDir() + File.separator + "cdn_cache";
        }
        return SingleTon.sInstance;
    }

    /* renamed from: a */
    private File m36867a(String str) {
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
    private java.lang.String m36868a(java.io.File r6) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.xbanner.template.yoga.CDNCacheManager.m36868a(java.io.File):java.lang.String");
    }

    /* renamed from: a */
    private void m36871a(String str, String str2, String str3, String str4, final WeakReference<XBannerCDNView> weakReference) {
        Element parseXML = KitHelper.parseXML(str3);
        if (parseXML == null || str4 == null) {
            SystemUtils.log(4, f51500a, "doCdnCallback js 或者 template 文件存在问题，删除", (Throwable) null, "com.didiglobal.xbanner.template.yoga.CDNCacheManager", 190);
            File file = new File(str + File.separator + "template" + f51504e);
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(str + File.separator + "template" + ".js");
            if (file2.exists()) {
                file2.delete();
                return;
            }
            return;
        }
        SystemUtils.log(4, f51500a, "doCdnCallback 写入缓存，cdn=" + str2, (Throwable) null, "com.didiglobal.xbanner.template.yoga.CDNCacheManager", 174);
        final XMLCacheEntity xMLCacheEntity = new XMLCacheEntity();
        xMLCacheEntity.element = parseXML;
        xMLCacheEntity.script = str4;
        this.f51512m.put(str2, xMLCacheEntity);
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                XBannerCDNView xBannerCDNView = (XBannerCDNView) weakReference.get();
                if (xBannerCDNView != null) {
                    xBannerCDNView.onCDNCached(xMLCacheEntity);
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
    public int m36866a(java.lang.String r12, java.lang.String r13) {
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
            java.lang.String r9 = "com.didiglobal.xbanner.template.yoga.CDNCacheManager"
            r10 = 240(0xf0, float:3.36E-43)
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
            java.lang.String r6 = "com.didiglobal.xbanner.template.yoga.CDNCacheManager"
            r7 = 249(0xf9, float:3.49E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.xbanner.template.yoga.CDNCacheManager.m36866a(java.lang.String, java.lang.String):int");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ca A[SYNTHETIC, Splitter:B:42:0x00ca] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00de A[SYNTHETIC, Splitter:B:50:0x00de] */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m36870a(java.io.File r12, java.lang.String r13) {
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
            java.lang.String r8 = "com.didiglobal.xbanner.template.yoga.CDNCacheManager"
            r9 = 289(0x121, float:4.05E-43)
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
            java.lang.String r9 = "com.didiglobal.xbanner.template.yoga.CDNCacheManager"
            r10 = 293(0x125, float:4.1E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.xbanner.template.yoga.CDNCacheManager.m36870a(java.io.File, java.lang.String):void");
    }
}
