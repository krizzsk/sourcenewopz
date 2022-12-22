package com.didichuxing.xpanel.xcard.loader;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.collection.ArrayMap;
import com.didichuxing.ditest.agent.android.util.MD5;
import com.didichuxing.xpanel.agent.net.XPanelAgentData;
import com.didichuxing.xpanel.util.DomUtil;
import com.didichuxing.xpanel.util.LogcatUtil;
import com.didichuxing.xpanel.util.XPanelApolloUtil;
import com.didichuxing.xpanel.util.XPanelOmegaUtils;
import com.didichuxing.xpanel.xcard.ICardListener;
import com.didichuxing.xpanel.xcard.TemplateParser;
import com.didichuxing.xpanel.xcard.XCardNode;
import com.didichuxing.xpanel.xcard.XCardRenderer;
import com.didichuxing.xpanel.xcard.view.XPanelCardWrapper;
import com.taxis99.R;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.w3c.dom.Element;

public class XCardManager {
    public static final String WEEX_VERSION = "1.0.0";
    public static final String XML_VIEW = "xmlView";

    /* renamed from: a */
    private static String f49620a = null;

    /* renamed from: b */
    private static final String f49621b = "XCardManager";

    /* renamed from: c */
    private static final String f49622c = "template";

    /* renamed from: d */
    private static final String f49623d = ".tmp";

    /* renamed from: e */
    private static final String f49624e = ".zip";

    /* renamed from: f */
    private static final String f49625f = ".xml";

    /* renamed from: g */
    private static final String f49626g = ".js";

    /* renamed from: h */
    private static final String f49627h = "global_xcard";

    /* renamed from: i */
    private static final int f49628i = 1;

    /* renamed from: j */
    private static final int f49629j = 2;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ArrayMap<String, IXMLoaderCallback> f49630k;

    /* renamed from: l */
    private ExecutorService f49631l;

    /* renamed from: m */
    private Handler f49632m;

    /* renamed from: n */
    private XMLCache f49633n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Set<String> f49634o;

    /* renamed from: p */
    private int f49635p;

    private static class SingleTon {
        /* access modifiers changed from: private */
        public static XCardManager sInstance = new XCardManager();

        private SingleTon() {
        }
    }

    private XCardManager() {
        this.f49631l = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new ArrayBlockingQueue(20), new ThreadPoolExecutor.DiscardOldestPolicy());
        this.f49632m = new Handler(Looper.getMainLooper());
        this.f49634o = new HashSet();
        this.f49633n = XMLCache.getInstance();
        this.f49630k = new ArrayMap<>(2);
    }

    public static XCardManager getInstance() {
        return SingleTon.sInstance;
    }

    public static void setCacheFilePath(String str) {
        f49620a = str + File.separator + f49627h;
    }

    /* renamed from: a */
    private static String m35845a() {
        return f49620a;
    }

    /* renamed from: b */
    private static boolean m35855b() {
        return f49620a != null;
    }

    public void loadCdn(String str, String str2, String str3, boolean z) {
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2) || this.f49634o.contains(str3)) {
            LogcatUtil.m35796i(f49621b, str3 + " 任务重复 或者 cdn template 为空");
            return;
        }
        String encode = MD5.encode(str3);
        if (m35855b()) {
            final String str4 = m35845a() + File.separator + str2 + File.separator + encode;
            this.f49634o.add(str3);
            final String str5 = str3;
            final String str6 = str;
            final boolean z2 = z;
            final String str7 = str2;
            this.f49631l.execute(new Runnable() {
                public void run() {
                    XCardManager xCardManager = XCardManager.this;
                    File a = xCardManager.m35844a(str4 + File.separator + "template" + XCardManager.f49625f);
                    XCardManager xCardManager2 = XCardManager.this;
                    File a2 = xCardManager2.m35844a(str4 + File.separator + "template" + ".js");
                    if (a == null || a2 == null) {
                        LogcatUtil.m35796i(XCardManager.f49621b, "loadCdn 下载cdn " + str5);
                        int a3 = XCardManager.this.m35841a(str4, str5);
                        File file = new File(str4 + File.separator + "template" + ".zip");
                        if (a3 == 2) {
                            XCardManager.this.f49634o.remove(str5);
                            LogcatUtil.m35796i(XCardManager.f49621b, "load cnd failed: cdn=" + str5 + ", template=" + str7);
                            return;
                        }
                        XCardManager.this.m35852a(file, str4);
                        XCardManager xCardManager3 = XCardManager.this;
                        File a4 = xCardManager3.m35844a(str4 + File.separator + "template" + XCardManager.f49625f);
                        XCardManager xCardManager4 = XCardManager.this;
                        File a5 = xCardManager4.m35844a(str4 + File.separator + "template" + ".js");
                        if (!(a4 == null || a5 == null)) {
                            XCardManager.this.m35853a(str4, str5, str6, XCardManager.this.m35847a(a4), XCardManager.this.m35847a(a5), z2);
                        }
                    } else {
                        LogcatUtil.m35796i(XCardManager.f49621b, "loadCdn 读取本地cdn " + str5);
                        XCardManager.this.m35853a(str4, str5, str6, XCardManager.this.m35847a(a), XCardManager.this.m35847a(a2), z2);
                    }
                    XCardManager.this.f49634o.remove(str5);
                }
            });
        }
    }

    public XMLCacheEntity createCacheFromLocal(String str, String str2) {
        XMLCacheEntity xMLCacheEntity = null;
        if (m35855b() && !TextUtils.isEmpty(str2)) {
            String str3 = m35845a() + File.separator + str + File.separator + MD5.encode(str2);
            File a = m35844a(str3 + File.separator + "template" + f49625f);
            File a2 = m35844a(str3 + File.separator + "template" + ".js");
            if (!(a == null || a2 == null)) {
                LogcatUtil.m35796i(f49621b, "createCacheFromLocal 读取本地cdn " + str2);
                String a3 = m35847a(a);
                String a4 = m35847a(a2);
                Element parseXML = DomUtil.parseXML(a3);
                if (!(parseXML == null || a4 == null)) {
                    xMLCacheEntity = new XMLCacheEntity();
                    xMLCacheEntity.element = parseXML;
                    xMLCacheEntity.script = a4;
                    if (this.f49633n.getXMLCache().get(str2) == null) {
                        this.f49633n.putXMLCache(str2, xMLCacheEntity);
                    }
                }
            }
        }
        return xMLCacheEntity;
    }

    /* renamed from: a */
    private void m35849a(long j, int i, File file, XPanelAgentData xPanelAgentData) {
        String str = xPanelAgentData.cdn;
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("id", xPanelAgentData.f49304id);
        hashMap.put("template", xPanelAgentData.template);
        hashMap.put("status", Integer.valueOf(i));
        hashMap.put("download_time", Long.valueOf(System.currentTimeMillis() - j));
        if (file.exists()) {
            hashMap.put("content_size", Long.valueOf(file.length()));
        }
        XPanelOmegaUtils.trackEvent("xpanel_cdn_download", hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public File m35844a(String str) {
        File file = new File(str);
        if (!file.isFile() || !file.exists()) {
            return null;
        }
        return file;
    }

    public boolean prepareToBuildSingleCard(String str, String str2, String str3, IXMLLoaderTrackCallback iXMLLoaderTrackCallback) {
        return prepareToBuildSingleCard(str, str2, str3, false, iXMLLoaderTrackCallback);
    }

    public boolean prepareToBuildSingleCard(String str, String str2, String str3, boolean z, IXMLLoaderTrackCallback iXMLLoaderTrackCallback) {
        boolean z2;
        int i = 1;
        if (!m35855b() || TextUtils.isEmpty(str3) || !XPanelApolloUtil.isXPanelCdnEnabled()) {
            return true;
        }
        if (this.f49633n.getXMLCache().get(str3) == null) {
            LogcatUtil.m35796i(f49621b, "dealWithCdn: cdn缓存没有命中 " + str3 + " 准备读取文件或者下载");
            loadCdn(str, str2, str3, z);
            z2 = false;
            i = 2;
        } else {
            LogcatUtil.m35796i(f49621b, "dealWithCdn: 从缓存中取出 " + str3);
            z2 = true;
        }
        if (iXMLLoaderTrackCallback != null) {
            iXMLLoaderTrackCallback.onLoadTrack(i);
        }
        return z2;
    }

    public XMLCacheEntity getXMLCache(String str) {
        return this.f49633n.getXMLCache().get(str);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A[SYNTHETIC, Splitter:B:23:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0052 A[SYNTHETIC, Splitter:B:29:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String m35847a(java.io.File r6) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.xcard.loader.XCardManager.m35847a(java.io.File):java.lang.String");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fa A[SYNTHETIC, Splitter:B:60:0x00fa] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ff A[Catch:{ IOException -> 0x00d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0104 A[Catch:{ IOException -> 0x00d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x010b A[SYNTHETIC, Splitter:B:69:0x010b] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0113 A[Catch:{ IOException -> 0x010f }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0118 A[Catch:{ IOException -> 0x010f }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int m35841a(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            r0 = 2
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            r2.<init>(r9)     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            r3.<init>()     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            r3.append(r9)     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            java.lang.String r9 = java.io.File.separator     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            r3.append(r9)     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            java.lang.String r9 = "template"
            r3.append(r9)     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            java.lang.String r9 = r3.toString()     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            boolean r3 = r2.exists()     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            java.lang.String r4 = "XCardManager"
            if (r3 != 0) goto L_0x002d
            java.lang.String r3 = "文件夹不存在 创建"
            com.didichuxing.xpanel.util.LogcatUtil.m35796i(r4, r3)     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            r2.mkdirs()     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
        L_0x002d:
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            r3.<init>()     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            r3.append(r9)     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            java.lang.String r5 = ".tmp"
            r3.append(r5)     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            r2.<init>(r3)     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            boolean r3 = r2.exists()     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            if (r3 != 0) goto L_0x0051
            java.lang.String r3 = "文件不存在 创建"
            com.didichuxing.xpanel.util.LogcatUtil.m35796i(r4, r3)     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            r2.createNewFile()     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
        L_0x0051:
            java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            r3.<init>(r10)     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            java.net.URLConnection r10 = r3.openConnection()     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            java.net.HttpURLConnection r10 = (java.net.HttpURLConnection) r10     // Catch:{ IOException -> 0x00f2, all -> 0x00ee }
            java.lang.String r3 = "GET"
            r10.setRequestMethod(r3)     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
            r3 = 5000(0x1388, float:7.006E-42)
            r10.setConnectTimeout(r3)     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
            r10.setReadTimeout(r3)     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
            int r3 = r10.getResponseCode()     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r3 != r5) goto L_0x00cb
            java.io.InputStream r3 = r10.getInputStream()     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
            r5.<init>(r3)     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x00c7, all -> 0x00c3 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00c7, all -> 0x00c3 }
            r6.<init>(r2)     // Catch:{ IOException -> 0x00c7, all -> 0x00c3 }
            r3.<init>(r6)     // Catch:{ IOException -> 0x00c7, all -> 0x00c3 }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x00c1, all -> 0x00bf }
        L_0x0088:
            int r6 = r5.read(r1)     // Catch:{ IOException -> 0x00c1, all -> 0x00bf }
            r7 = -1
            if (r6 == r7) goto L_0x0094
            r7 = 0
            r3.write(r1, r7, r6)     // Catch:{ IOException -> 0x00c1, all -> 0x00bf }
            goto L_0x0088
        L_0x0094:
            java.lang.String r1 = "下载成功，开始解压"
            com.didichuxing.xpanel.util.LogcatUtil.m35796i(r4, r1)     // Catch:{ IOException -> 0x00c1, all -> 0x00bf }
            r3.flush()     // Catch:{ IOException -> 0x00c1, all -> 0x00bf }
            r5.close()     // Catch:{ IOException -> 0x00c1, all -> 0x00bf }
            r3.close()     // Catch:{ IOException -> 0x00c1, all -> 0x00bf }
            r1 = 1
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c1, all -> 0x00bf }
            r4.<init>()     // Catch:{ IOException -> 0x00c1, all -> 0x00bf }
            r4.append(r9)     // Catch:{ IOException -> 0x00c1, all -> 0x00bf }
            java.lang.String r9 = ".zip"
            r4.append(r9)     // Catch:{ IOException -> 0x00c1, all -> 0x00bf }
            java.lang.String r9 = r4.toString()     // Catch:{ IOException -> 0x00c1, all -> 0x00bf }
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x00c1, all -> 0x00bf }
            r4.<init>(r9)     // Catch:{ IOException -> 0x00c1, all -> 0x00bf }
            r2.renameTo(r4)     // Catch:{ IOException -> 0x00c1, all -> 0x00bf }
            r1 = r5
            r0 = 1
            goto L_0x00d1
        L_0x00bf:
            r9 = move-exception
            goto L_0x00c5
        L_0x00c1:
            r9 = move-exception
            goto L_0x00c9
        L_0x00c3:
            r9 = move-exception
            r3 = r1
        L_0x00c5:
            r1 = r5
            goto L_0x0109
        L_0x00c7:
            r9 = move-exception
            r3 = r1
        L_0x00c9:
            r1 = r5
            goto L_0x00f5
        L_0x00cb:
            java.lang.String r9 = "网络请求失败"
            com.didichuxing.xpanel.util.LogcatUtil.m35796i(r4, r9)     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
            r3 = r1
        L_0x00d1:
            if (r1 == 0) goto L_0x00d9
            r1.close()     // Catch:{ IOException -> 0x00d7 }
            goto L_0x00d9
        L_0x00d7:
            r9 = move-exception
            goto L_0x00e4
        L_0x00d9:
            if (r3 == 0) goto L_0x00de
            r3.close()     // Catch:{ IOException -> 0x00d7 }
        L_0x00de:
            if (r10 == 0) goto L_0x0107
            r10.disconnect()     // Catch:{ IOException -> 0x00d7 }
            goto L_0x0107
        L_0x00e4:
            r9.printStackTrace()
            goto L_0x0107
        L_0x00e8:
            r9 = move-exception
            r3 = r1
            goto L_0x0109
        L_0x00eb:
            r9 = move-exception
            r3 = r1
            goto L_0x00f5
        L_0x00ee:
            r9 = move-exception
            r10 = r1
            r3 = r10
            goto L_0x0109
        L_0x00f2:
            r9 = move-exception
            r10 = r1
            r3 = r10
        L_0x00f5:
            r9.printStackTrace()     // Catch:{ all -> 0x0108 }
            if (r1 == 0) goto L_0x00fd
            r1.close()     // Catch:{ IOException -> 0x00d7 }
        L_0x00fd:
            if (r3 == 0) goto L_0x0102
            r3.close()     // Catch:{ IOException -> 0x00d7 }
        L_0x0102:
            if (r10 == 0) goto L_0x0107
            r10.disconnect()     // Catch:{ IOException -> 0x00d7 }
        L_0x0107:
            return r0
        L_0x0108:
            r9 = move-exception
        L_0x0109:
            if (r1 == 0) goto L_0x0111
            r1.close()     // Catch:{ IOException -> 0x010f }
            goto L_0x0111
        L_0x010f:
            r10 = move-exception
            goto L_0x011c
        L_0x0111:
            if (r3 == 0) goto L_0x0116
            r3.close()     // Catch:{ IOException -> 0x010f }
        L_0x0116:
            if (r10 == 0) goto L_0x011f
            r10.disconnect()     // Catch:{ IOException -> 0x010f }
            goto L_0x011f
        L_0x011c:
            r10.printStackTrace()
        L_0x011f:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.xcard.loader.XCardManager.m35841a(java.lang.String, java.lang.String):int");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bc A[SYNTHETIC, Splitter:B:45:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d0 A[SYNTHETIC, Splitter:B:53:0x00d0] */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m35852a(java.io.File r8, java.lang.String r9) {
        /*
            r7 = this;
            r0 = 0
            java.util.zip.ZipInputStream r1 = new java.util.zip.ZipInputStream     // Catch:{ Exception -> 0x00ad }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00ad }
            r2.<init>(r8)     // Catch:{ Exception -> 0x00ad }
            r1.<init>(r2)     // Catch:{ Exception -> 0x00ad }
        L_0x000b:
            java.util.zip.ZipEntry r0 = r1.getNextEntry()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            if (r0 == 0) goto L_0x0098
            java.lang.String r2 = r0.getName()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.lang.String r3 = "../"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.lang.String r4 = "XCardManager"
            if (r3 == 0) goto L_0x0025
            java.lang.String r0 = "Unsecurity zip file!!"
            com.didichuxing.xpanel.util.LogcatUtil.m35795e(r4, r0)     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            goto L_0x000b
        L_0x0025:
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            r5.<init>()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            r5.append(r9)     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.lang.String r6 = java.io.File.separator     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            r5.append(r6)     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            r5.append(r2)     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            r5.<init>()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.lang.String r6 = "解压文件 "
            r5.append(r6)     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            r5.append(r2)     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            com.didichuxing.xpanel.util.LogcatUtil.m35796i(r4, r2)     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            java.io.File r2 = r3.getParentFile()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            boolean r2 = r2.exists()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            if (r2 != 0) goto L_0x0063
            java.io.File r2 = r3.getParentFile()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            r2.mkdir()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
        L_0x0063:
            boolean r0 = r0.isDirectory()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            if (r0 == 0) goto L_0x0073
            boolean r0 = r3.exists()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            if (r0 != 0) goto L_0x000b
            r3.mkdir()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            goto L_0x000b
        L_0x0073:
            boolean r0 = r3.exists()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            if (r0 != 0) goto L_0x007c
            r3.createNewFile()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
        L_0x007c:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
        L_0x0085:
            int r3 = r1.read(r2)     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            if (r3 <= 0) goto L_0x0090
            r4 = 0
            r0.write(r2, r4, r3)     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            goto L_0x0085
        L_0x0090:
            r0.flush()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            r0.close()     // Catch:{ Exception -> 0x00a8, all -> 0x00a5 }
            goto L_0x000b
        L_0x0098:
            boolean r9 = r8.exists()
            if (r9 == 0) goto L_0x00a1
            r8.delete()
        L_0x00a1:
            r1.close()     // Catch:{ IOException -> 0x00c0 }
            goto L_0x00c4
        L_0x00a5:
            r9 = move-exception
            r0 = r1
            goto L_0x00c5
        L_0x00a8:
            r9 = move-exception
            r0 = r1
            goto L_0x00ae
        L_0x00ab:
            r9 = move-exception
            goto L_0x00c5
        L_0x00ad:
            r9 = move-exception
        L_0x00ae:
            r9.printStackTrace()     // Catch:{ all -> 0x00ab }
            boolean r9 = r8.exists()
            if (r9 == 0) goto L_0x00ba
            r8.delete()
        L_0x00ba:
            if (r0 == 0) goto L_0x00c4
            r0.close()     // Catch:{ IOException -> 0x00c0 }
            goto L_0x00c4
        L_0x00c0:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00c4:
            return
        L_0x00c5:
            boolean r1 = r8.exists()
            if (r1 == 0) goto L_0x00ce
            r8.delete()
        L_0x00ce:
            if (r0 == 0) goto L_0x00d8
            r0.close()     // Catch:{ IOException -> 0x00d4 }
            goto L_0x00d8
        L_0x00d4:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00d8:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.xcard.loader.XCardManager.m35852a(java.io.File, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35853a(String str, String str2, final String str3, String str4, String str5, final boolean z) {
        Element parseXML = DomUtil.parseXML(str4);
        if (parseXML == null || str5 == null) {
            LogcatUtil.m35796i(f49621b, "doCdnCallback js 或者 template 文件存在问题，删除");
            File file = new File(str + File.separator + "template" + f49625f);
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(str + File.separator + "template" + ".js");
            if (file2.exists()) {
                file2.delete();
            }
        } else {
            LogcatUtil.m35796i(f49621b, "doCdnCallback 写入缓存，cdn=" + str2);
            XMLCacheEntity xMLCacheEntity = new XMLCacheEntity();
            xMLCacheEntity.element = parseXML;
            xMLCacheEntity.script = str5;
            this.f49633n.putXMLCache(str2, xMLCacheEntity);
        }
        this.f49632m.post(new Runnable() {
            public void run() {
                LogcatUtil.m35794d(XCardManager.f49621b, "current dimension: " + str3);
                IXMLoaderCallback iXMLoaderCallback = (IXMLoaderCallback) XCardManager.this.f49630k.get(str3);
                if (iXMLoaderCallback != null) {
                    iXMLoaderCallback.onTaskComplete(z);
                }
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void bindIXMLoaderCallback(java.lang.String r2, com.didichuxing.xpanel.xcard.loader.IXMLoaderCallback r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r3 == 0) goto L_0x0016
            androidx.collection.ArrayMap<java.lang.String, com.didichuxing.xpanel.xcard.loader.IXMLoaderCallback> r0 = r1.f49630k     // Catch:{ all -> 0x0013 }
            boolean r0 = r0.containsKey(r2)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x000c
            goto L_0x0016
        L_0x000c:
            androidx.collection.ArrayMap<java.lang.String, com.didichuxing.xpanel.xcard.loader.IXMLoaderCallback> r0 = r1.f49630k     // Catch:{ all -> 0x0013 }
            r0.put(r2, r3)     // Catch:{ all -> 0x0013 }
            monitor-exit(r1)
            return
        L_0x0013:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x0016:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.xcard.loader.XCardManager.bindIXMLoaderCallback(java.lang.String, com.didichuxing.xpanel.xcard.loader.IXMLoaderCallback):void");
    }

    public synchronized void unBindIXMLoaderCallback(String str) {
        this.f49630k.remove(str);
    }

    public View createXCardView(Context context, XMLCacheEntity xMLCacheEntity, Object obj, ICardListener iCardListener) {
        XCardNode parse;
        if (xMLCacheEntity == null || (parse = new TemplateParser().parse(xMLCacheEntity.element, obj)) == null) {
            return null;
        }
        XCardRenderer xCardRenderer = new XCardRenderer(context, this.f49635p, (XPanelAgentData) null);
        xCardRenderer.bindXCardListener(iCardListener);
        View render = xCardRenderer.render(parse);
        if (render == null) {
            return null;
        }
        return m35842a(context, render);
    }

    /* renamed from: a */
    private View m35842a(Context context, View view) {
        XPanelCardWrapper xPanelCardWrapper = new XPanelCardWrapper(context);
        Drawable background = view.getBackground();
        xPanelCardWrapper.setBackgroundColor(background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : -1);
        xPanelCardWrapper.setTag(R.id.itemId, XML_VIEW);
        xPanelCardWrapper.addView(view);
        return xPanelCardWrapper;
    }

    public void setLeftRightMargin(int i) {
        this.f49635p = i;
    }
}
