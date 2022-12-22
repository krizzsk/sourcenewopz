package com.didichuxing.dfbasesdk.downloader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileDownloader {

    /* renamed from: a */
    private static Handler f46575a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private static ExecutorService f46576b = Executors.newCachedThreadPool();

    public static class Param {
        public String directory;
        public String fileName;
        public String md5;
        public int retryDelayInMills = 3000;
        public int retryTime = 0;
        public int timeoutInMills = 0;
        public String url;
        public boolean useRange = false;
    }

    public static void download(Context context, Param param, FileDownloaderListener fileDownloaderListener) {
        m33428b(context, fileDownloaderListener, param);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m33428b(Context context, FileDownloaderListener fileDownloaderListener, Param param) {
        final long currentTimeMillis = param.timeoutInMills > 0 ? System.currentTimeMillis() + ((long) param.timeoutInMills) : 0;
        final Param param2 = param;
        final Context context2 = context;
        final FileDownloaderListener fileDownloaderListener2 = fileDownloaderListener;
        f46576b.execute(new Runnable() {
            /* JADX WARNING: Can't wrap try/catch for region: R(10:46|(3:48|49|(2:51|(3:53|54|123)(1:125)))|56|57|(1:59)|60|(3:61|62|(2:63|(5:(2:66|(6:119|68|(2:70|71)|72|73|126))(1:75)|76|77|(2:79|121)(1:122)|80)(4:120|81|(1:86)(1:85)|(2:88|89))))|90|91|130) */
            /* JADX WARNING: Code restructure failed: missing block: B:128:?, code lost:
                return;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x018c */
            /* JADX WARNING: Missing exception handler attribute for start block: B:90:0x01eb */
            /* JADX WARNING: Removed duplicated region for block: B:104:0x0222 A[SYNTHETIC, Splitter:B:104:0x0222] */
            /* JADX WARNING: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r19 = this;
                    r1 = r19
                    java.io.File r0 = new java.io.File
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r2 = r3
                    java.lang.String r2 = r2.directory
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r3 = r3
                    java.lang.String r3 = r3.fileName
                    r0.<init>(r2, r3)
                    boolean r2 = r0.isDirectory()
                    if (r2 == 0) goto L_0x0019
                    com.didichuxing.dfbasesdk.utils.FileUtils.deleteDir(r0)
                    goto L_0x0045
                L_0x0019:
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r2 = r3
                    java.lang.String r2 = r2.md5
                    boolean r2 = android.text.TextUtils.isEmpty(r2)
                    if (r2 != 0) goto L_0x0045
                    boolean r2 = r0.isFile()
                    if (r2 == 0) goto L_0x0045
                    java.lang.String r2 = com.didichuxing.dfbasesdk.utils.FileUtils.fileToMD5(r0)
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r3 = r3
                    java.lang.String r3 = r3.md5
                    boolean r2 = r2.equalsIgnoreCase(r3)
                    if (r2 == 0) goto L_0x0045
                    android.content.Context r2 = r4
                    com.didichuxing.dfbasesdk.downloader.FileDownloaderListener r3 = r5
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r4 = r3
                    java.lang.String r0 = r0.getAbsolutePath()
                    com.didichuxing.dfbasesdk.downloader.FileDownloader.m33429b((android.content.Context) r2, (com.didichuxing.dfbasesdk.downloader.FileDownloaderListener) r3, (com.didichuxing.dfbasesdk.downloader.FileDownloader.Param) r4, (java.lang.String) r0)
                    return
                L_0x0045:
                    r2 = 0
                    java.net.URL r3 = new java.net.URL     // Catch:{ all -> 0x0215 }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r4 = r3     // Catch:{ all -> 0x0215 }
                    java.lang.String r4 = r4.url     // Catch:{ all -> 0x0215 }
                    r3.<init>(r4)     // Catch:{ all -> 0x0215 }
                    java.net.URLConnection r3 = r3.openConnection()     // Catch:{ all -> 0x0215 }
                    java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ all -> 0x0215 }
                    java.lang.String r4 = "GET"
                    r3.setRequestMethod(r4)     // Catch:{ all -> 0x0215 }
                    r4 = 10000(0x2710, float:1.4013E-41)
                    r3.setConnectTimeout(r4)     // Catch:{ all -> 0x0215 }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r4 = r3     // Catch:{ all -> 0x0215 }
                    int r4 = r4.timeoutInMills     // Catch:{ all -> 0x0215 }
                    if (r4 <= 0) goto L_0x006c
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r4 = r3     // Catch:{ all -> 0x0215 }
                    int r4 = r4.timeoutInMills     // Catch:{ all -> 0x0215 }
                    r3.setReadTimeout(r4)     // Catch:{ all -> 0x0215 }
                L_0x006c:
                    r4 = 0
                    r3.setInstanceFollowRedirects(r4)     // Catch:{ all -> 0x0215 }
                    java.lang.String r5 = "Accept"
                    java.lang.String r6 = "*/*"
                    r3.setRequestProperty(r5, r6)     // Catch:{ all -> 0x0215 }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r5 = r3     // Catch:{ all -> 0x0215 }
                    boolean r5 = r5.useRange     // Catch:{ all -> 0x0215 }
                    r6 = 0
                    if (r5 == 0) goto L_0x00a9
                    boolean r5 = r0.isFile()     // Catch:{ all -> 0x0215 }
                    if (r5 == 0) goto L_0x00a9
                    long r8 = r0.length()     // Catch:{ all -> 0x0215 }
                    int r5 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                    if (r5 <= 0) goto L_0x00aa
                    java.lang.String r5 = "Range"
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0215 }
                    r10.<init>()     // Catch:{ all -> 0x0215 }
                    java.lang.String r11 = "bytes="
                    r10.append(r11)     // Catch:{ all -> 0x0215 }
                    r10.append(r8)     // Catch:{ all -> 0x0215 }
                    java.lang.String r11 = "-"
                    r10.append(r11)     // Catch:{ all -> 0x0215 }
                    java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0215 }
                    r3.setRequestProperty(r5, r10)     // Catch:{ all -> 0x0215 }
                    goto L_0x00aa
                L_0x00a9:
                    r8 = r6
                L_0x00aa:
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r5 = r3     // Catch:{ all -> 0x0215 }
                    int r5 = r5.timeoutInMills     // Catch:{ all -> 0x0215 }
                    if (r5 <= 0) goto L_0x00bb
                    long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0215 }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r5 = r3     // Catch:{ all -> 0x0215 }
                    int r5 = r5.timeoutInMills     // Catch:{ all -> 0x0215 }
                    long r12 = (long) r5     // Catch:{ all -> 0x0215 }
                    long r10 = r10 + r12
                    goto L_0x00bc
                L_0x00bb:
                    r10 = r6
                L_0x00bc:
                    r3.connect()     // Catch:{ all -> 0x0215 }
                    java.lang.String r5 = "time out!!"
                    int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                    if (r12 <= 0) goto L_0x00de
                    long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0215 }
                    long r10 = r6     // Catch:{ all -> 0x0215 }
                    int r13 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
                    if (r13 <= 0) goto L_0x00de
                    android.content.Context r0 = r4     // Catch:{ all -> 0x0215 }
                    com.didichuxing.dfbasesdk.downloader.FileDownloaderListener r3 = r5     // Catch:{ all -> 0x0215 }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r4 = r3     // Catch:{ all -> 0x0215 }
                    java.lang.Exception r6 = new java.lang.Exception     // Catch:{ all -> 0x0215 }
                    r6.<init>(r5)     // Catch:{ all -> 0x0215 }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader.m33430b((android.content.Context) r0, (com.didichuxing.dfbasesdk.downloader.FileDownloaderListener) r3, (com.didichuxing.dfbasesdk.downloader.FileDownloader.Param) r4, (java.lang.Throwable) r6)     // Catch:{ all -> 0x0215 }
                    return
                L_0x00de:
                    int r6 = r3.getResponseCode()     // Catch:{ all -> 0x0215 }
                    r7 = 200(0xc8, float:2.8E-43)
                    if (r6 < r7) goto L_0x01f5
                    r7 = 300(0x12c, float:4.2E-43)
                    if (r6 < r7) goto L_0x00ec
                    goto L_0x01f5
                L_0x00ec:
                    if (r12 <= 0) goto L_0x0107
                    long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0215 }
                    long r10 = r6     // Catch:{ all -> 0x0215 }
                    int r13 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
                    if (r13 <= 0) goto L_0x0107
                    android.content.Context r0 = r4     // Catch:{ all -> 0x0215 }
                    com.didichuxing.dfbasesdk.downloader.FileDownloaderListener r3 = r5     // Catch:{ all -> 0x0215 }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r4 = r3     // Catch:{ all -> 0x0215 }
                    java.lang.Exception r6 = new java.lang.Exception     // Catch:{ all -> 0x0215 }
                    r6.<init>(r5)     // Catch:{ all -> 0x0215 }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader.m33430b((android.content.Context) r0, (com.didichuxing.dfbasesdk.downloader.FileDownloaderListener) r3, (com.didichuxing.dfbasesdk.downloader.FileDownloader.Param) r4, (java.lang.Throwable) r6)     // Catch:{ all -> 0x0215 }
                    return
                L_0x0107:
                    java.io.InputStream r6 = r3.getInputStream()     // Catch:{ all -> 0x0215 }
                    if (r12 <= 0) goto L_0x012b
                    long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01f1 }
                    long r13 = r6     // Catch:{ all -> 0x01f1 }
                    int r7 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
                    if (r7 <= 0) goto L_0x012b
                    android.content.Context r0 = r4     // Catch:{ all -> 0x01f1 }
                    com.didichuxing.dfbasesdk.downloader.FileDownloaderListener r3 = r5     // Catch:{ all -> 0x01f1 }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r4 = r3     // Catch:{ all -> 0x01f1 }
                    java.lang.Exception r7 = new java.lang.Exception     // Catch:{ all -> 0x01f1 }
                    r7.<init>(r5)     // Catch:{ all -> 0x01f1 }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader.m33430b((android.content.Context) r0, (com.didichuxing.dfbasesdk.downloader.FileDownloaderListener) r3, (com.didichuxing.dfbasesdk.downloader.FileDownloader.Param) r4, (java.lang.Throwable) r7)     // Catch:{ all -> 0x01f1 }
                    if (r6 == 0) goto L_0x012a
                    r6.close()     // Catch:{ all -> 0x012a }
                L_0x012a:
                    return
                L_0x012b:
                    java.io.File r7 = new java.io.File     // Catch:{ all -> 0x01f1 }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r10 = r3     // Catch:{ all -> 0x01f1 }
                    java.lang.String r10 = r10.directory     // Catch:{ all -> 0x01f1 }
                    r7.<init>(r10)     // Catch:{ all -> 0x01f1 }
                    r7.mkdirs()     // Catch:{ all -> 0x01f1 }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r7 = r3     // Catch:{ all -> 0x01f1 }
                    boolean r7 = r7.useRange     // Catch:{ all -> 0x01f1 }
                    if (r7 != 0) goto L_0x0140
                    com.didichuxing.dfbasesdk.utils.FileUtils.deleteDir(r0)     // Catch:{ all -> 0x01f1 }
                L_0x0140:
                    java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ all -> 0x01f1 }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r10 = r3     // Catch:{ all -> 0x01f1 }
                    boolean r10 = r10.useRange     // Catch:{ all -> 0x01f1 }
                    r7.<init>(r0, r10)     // Catch:{ all -> 0x01f1 }
                    int r2 = r3.getContentLength()     // Catch:{ all -> 0x01ef }
                    long r2 = (long) r2     // Catch:{ all -> 0x01ef }
                    long r2 = r2 + r8
                    float r10 = (float) r8     // Catch:{ all -> 0x01ef }
                    r11 = 1065353216(0x3f800000, float:1.0)
                    float r10 = r10 * r11
                    float r2 = (float) r2     // Catch:{ all -> 0x01ef }
                    float r10 = r10 / r2
                    r3 = 1120403456(0x42c80000, float:100.0)
                    float r10 = r10 * r3
                    int r10 = (int) r10     // Catch:{ all -> 0x01ef }
                    com.didichuxing.dfbasesdk.downloader.FileDownloaderListener r13 = r5     // Catch:{ all -> 0x01ef }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader.m33431b(r13, r10)     // Catch:{ all -> 0x01ef }
                    r13 = 2048(0x800, float:2.87E-42)
                    byte[] r13 = new byte[r13]     // Catch:{ all -> 0x01ef }
                L_0x0164:
                    int r14 = r6.read(r13)     // Catch:{ all -> 0x01ef }
                    r15 = -1
                    if (r14 == r15) goto L_0x01b0
                    if (r12 <= 0) goto L_0x0190
                    long r15 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01ef }
                    r17 = r12
                    long r11 = r6     // Catch:{ all -> 0x01ef }
                    int r18 = (r15 > r11 ? 1 : (r15 == r11 ? 0 : -1))
                    if (r18 <= 0) goto L_0x0192
                    android.content.Context r0 = r4     // Catch:{ all -> 0x01ef }
                    com.didichuxing.dfbasesdk.downloader.FileDownloaderListener r2 = r5     // Catch:{ all -> 0x01ef }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r3 = r3     // Catch:{ all -> 0x01ef }
                    java.lang.Exception r4 = new java.lang.Exception     // Catch:{ all -> 0x01ef }
                    r4.<init>(r5)     // Catch:{ all -> 0x01ef }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader.m33430b((android.content.Context) r0, (com.didichuxing.dfbasesdk.downloader.FileDownloaderListener) r2, (com.didichuxing.dfbasesdk.downloader.FileDownloader.Param) r3, (java.lang.Throwable) r4)     // Catch:{ all -> 0x01ef }
                    if (r6 == 0) goto L_0x018c
                    r6.close()     // Catch:{ all -> 0x018c }
                L_0x018c:
                    r7.close()     // Catch:{ all -> 0x018f }
                L_0x018f:
                    return
                L_0x0190:
                    r17 = r12
                L_0x0192:
                    r7.write(r13, r4, r14)     // Catch:{ all -> 0x01ef }
                    r7.flush()     // Catch:{ all -> 0x01ef }
                    long r11 = (long) r14     // Catch:{ all -> 0x01ef }
                    long r8 = r8 + r11
                    float r11 = (float) r8     // Catch:{ all -> 0x01ef }
                    r12 = 1065353216(0x3f800000, float:1.0)
                    float r11 = r11 * r12
                    float r11 = r11 / r2
                    float r11 = r11 * r3
                    int r11 = (int) r11     // Catch:{ all -> 0x01ef }
                    if (r11 <= r10) goto L_0x01ab
                    com.didichuxing.dfbasesdk.downloader.FileDownloaderListener r10 = r5     // Catch:{ all -> 0x01ef }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader.m33431b(r10, r11)     // Catch:{ all -> 0x01ef }
                    r10 = r11
                L_0x01ab:
                    r12 = r17
                    r11 = 1065353216(0x3f800000, float:1.0)
                    goto L_0x0164
                L_0x01b0:
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r2 = r3     // Catch:{ all -> 0x01ef }
                    java.lang.String r2 = r2.md5     // Catch:{ all -> 0x01ef }
                    boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x01ef }
                    if (r2 != 0) goto L_0x01d9
                    java.lang.String r2 = com.didichuxing.dfbasesdk.utils.FileUtils.fileToMD5(r0)     // Catch:{ all -> 0x01ef }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r3 = r3     // Catch:{ all -> 0x01ef }
                    java.lang.String r3 = r3.md5     // Catch:{ all -> 0x01ef }
                    boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ all -> 0x01ef }
                    if (r2 != 0) goto L_0x01d9
                    android.content.Context r0 = r4     // Catch:{ all -> 0x01ef }
                    com.didichuxing.dfbasesdk.downloader.FileDownloaderListener r2 = r5     // Catch:{ all -> 0x01ef }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r3 = r3     // Catch:{ all -> 0x01ef }
                    java.lang.Exception r4 = new java.lang.Exception     // Catch:{ all -> 0x01ef }
                    java.lang.String r5 = "md5校验失败"
                    r4.<init>(r5)     // Catch:{ all -> 0x01ef }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader.m33430b((android.content.Context) r0, (com.didichuxing.dfbasesdk.downloader.FileDownloaderListener) r2, (com.didichuxing.dfbasesdk.downloader.FileDownloader.Param) r3, (java.lang.Throwable) r4)     // Catch:{ all -> 0x01ef }
                    goto L_0x01e6
                L_0x01d9:
                    android.content.Context r2 = r4     // Catch:{ all -> 0x01ef }
                    com.didichuxing.dfbasesdk.downloader.FileDownloaderListener r3 = r5     // Catch:{ all -> 0x01ef }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r4 = r3     // Catch:{ all -> 0x01ef }
                    java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x01ef }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader.m33429b((android.content.Context) r2, (com.didichuxing.dfbasesdk.downloader.FileDownloaderListener) r3, (com.didichuxing.dfbasesdk.downloader.FileDownloader.Param) r4, (java.lang.String) r0)     // Catch:{ all -> 0x01ef }
                L_0x01e6:
                    if (r6 == 0) goto L_0x01eb
                    r6.close()     // Catch:{ all -> 0x01eb }
                L_0x01eb:
                    r7.close()     // Catch:{ all -> 0x022a }
                    goto L_0x022a
                L_0x01ef:
                    r0 = move-exception
                    goto L_0x01f3
                L_0x01f1:
                    r0 = move-exception
                    r7 = r2
                L_0x01f3:
                    r2 = r6
                    goto L_0x0217
                L_0x01f5:
                    android.content.Context r0 = r4     // Catch:{ all -> 0x0215 }
                    com.didichuxing.dfbasesdk.downloader.FileDownloaderListener r3 = r5     // Catch:{ all -> 0x0215 }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r4 = r3     // Catch:{ all -> 0x0215 }
                    java.lang.Exception r5 = new java.lang.Exception     // Catch:{ all -> 0x0215 }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0215 }
                    r7.<init>()     // Catch:{ all -> 0x0215 }
                    java.lang.String r8 = "response code "
                    r7.append(r8)     // Catch:{ all -> 0x0215 }
                    r7.append(r6)     // Catch:{ all -> 0x0215 }
                    java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x0215 }
                    r5.<init>(r6)     // Catch:{ all -> 0x0215 }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader.m33430b((android.content.Context) r0, (com.didichuxing.dfbasesdk.downloader.FileDownloaderListener) r3, (com.didichuxing.dfbasesdk.downloader.FileDownloader.Param) r4, (java.lang.Throwable) r5)     // Catch:{ all -> 0x0215 }
                    return
                L_0x0215:
                    r0 = move-exception
                    r7 = r2
                L_0x0217:
                    android.content.Context r3 = r4     // Catch:{ all -> 0x022b }
                    com.didichuxing.dfbasesdk.downloader.FileDownloaderListener r4 = r5     // Catch:{ all -> 0x022b }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader$Param r5 = r3     // Catch:{ all -> 0x022b }
                    com.didichuxing.dfbasesdk.downloader.FileDownloader.m33430b((android.content.Context) r3, (com.didichuxing.dfbasesdk.downloader.FileDownloaderListener) r4, (com.didichuxing.dfbasesdk.downloader.FileDownloader.Param) r5, (java.lang.Throwable) r0)     // Catch:{ all -> 0x022b }
                    if (r2 == 0) goto L_0x0227
                    r2.close()     // Catch:{ all -> 0x0226 }
                    goto L_0x0227
                L_0x0226:
                L_0x0227:
                    if (r7 == 0) goto L_0x022a
                    goto L_0x01eb
                L_0x022a:
                    return
                L_0x022b:
                    r0 = move-exception
                    if (r2 == 0) goto L_0x0233
                    r2.close()     // Catch:{ all -> 0x0232 }
                    goto L_0x0233
                L_0x0232:
                L_0x0233:
                    if (r7 == 0) goto L_0x0238
                    r7.close()     // Catch:{ all -> 0x0238 }
                L_0x0238:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.downloader.FileDownloader.C152881.run():void");
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m33431b(final FileDownloaderListener fileDownloaderListener, final int i) {
        if (fileDownloaderListener != null) {
            f46575a.post(new Runnable() {
                public void run() {
                    fileDownloaderListener.progress(i);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m33429b(Context context, final FileDownloaderListener fileDownloaderListener, final Param param, final String str) {
        if (fileDownloaderListener != null) {
            f46575a.post(new Runnable() {
                public void run() {
                    fileDownloaderListener.success(param.url, str);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m33430b(final Context context, final FileDownloaderListener fileDownloaderListener, final Param param, final Throwable th) {
        if (param.retryTime > 0) {
            param.retryTime--;
            f46575a.postDelayed(new Runnable() {
                public void run() {
                    FileDownloader.m33428b(context, fileDownloaderListener, param);
                }
            }, (long) param.retryDelayInMills);
        } else if (fileDownloaderListener != null) {
            f46575a.post(new Runnable() {
                public void run() {
                    fileDownloaderListener.failed(th);
                }
            });
        }
    }

    public static class ParamBuilder {
        private Param param = new Param();

        public Param build() {
            return this.param;
        }

        public ParamBuilder setUrl(String str) {
            this.param.url = str;
            return this;
        }

        public ParamBuilder setMd5(String str) {
            this.param.md5 = str;
            return this;
        }

        public ParamBuilder setDirectory(String str) {
            this.param.directory = str;
            return this;
        }

        public ParamBuilder setFileName(String str) {
            this.param.fileName = str;
            return this;
        }

        @Deprecated
        public ParamBuilder setTimeoutInMills(int i) {
            this.param.timeoutInMills = i;
            return this;
        }

        public ParamBuilder setRetryTime(int i) {
            this.param.retryTime = i;
            return this;
        }

        public ParamBuilder setRetryDelayInMills(int i) {
            this.param.retryDelayInMills = i;
            return this;
        }

        public ParamBuilder setUseRange(boolean z) {
            this.param.useRange = z;
            return this;
        }
    }
}
