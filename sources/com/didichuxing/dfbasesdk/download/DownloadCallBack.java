package com.didichuxing.dfbasesdk.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didichuxing.foundation.net.rpc.http.HttpRpc;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import java.io.File;
import java.io.IOException;

@Deprecated
public class DownloadCallBack implements Handler.Callback, HttpRpc.Callback {
    public static final int FAILED = 101;
    public static final int PROGRESS = 102;
    public static final int SUCCESS = 100;

    /* renamed from: a */
    private final String f46568a;

    /* renamed from: b */
    private final int f46569b;

    /* renamed from: c */
    private final String f46570c;

    /* renamed from: d */
    private final String f46571d;

    /* renamed from: e */
    private final IDownloadListener f46572e;

    /* renamed from: f */
    private Handler f46573f = new Handler(Looper.getMainLooper(), this);

    public DownloadCallBack(String str, int i, String str2, String str3, IDownloadListener iDownloadListener) {
        this.f46572e = iDownloadListener;
        this.f46568a = str;
        this.f46569b = i;
        this.f46570c = str2;
        this.f46571d = str3;
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 100:
                this.f46572e.success(this.f46568a, (String) message.obj);
                return false;
            case 101:
                this.f46572e.failed((Exception) message.obj);
                return false;
            case 102:
                this.f46572e.progress(message.arg1);
                return false;
            default:
                return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00dc A[SYNTHETIC, Splitter:B:39:0x00dc] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e6 A[SYNTHETIC, Splitter:B:44:0x00e6] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f2 A[SYNTHETIC, Splitter:B:50:0x00f2] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00fc A[SYNTHETIC, Splitter:B:55:0x00fc] */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(com.didichuxing.foundation.net.rpc.http.HttpRpcResponse r14) {
        /*
            r13 = this;
            r0 = 2048(0x800, float:2.87E-42)
            r1 = 0
            r2 = 101(0x65, float:1.42E-43)
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x00cc, all -> 0x00c9 }
            java.lang.String r3 = r13.f46570c     // Catch:{ Exception -> 0x00cc, all -> 0x00c9 }
            java.lang.String r3 = com.didichuxing.dfbasesdk.utils.FileUtils.ensureDirectory(r3)     // Catch:{ Exception -> 0x00cc, all -> 0x00c9 }
            com.didichuxing.foundation.net.http.HttpEntity r4 = r14.getEntity()     // Catch:{ Exception -> 0x00cc, all -> 0x00c9 }
            java.io.InputStream r4 = r4.getContent()     // Catch:{ Exception -> 0x00cc, all -> 0x00c9 }
            com.didichuxing.foundation.net.http.HttpEntity r14 = r14.getEntity()     // Catch:{ Exception -> 0x00c5, all -> 0x00c1 }
            long r5 = r14.getContentLength()     // Catch:{ Exception -> 0x00c5, all -> 0x00c1 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c5, all -> 0x00c1 }
            r14.<init>()     // Catch:{ Exception -> 0x00c5, all -> 0x00c1 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00c5, all -> 0x00c1 }
            r14.append(r7)     // Catch:{ Exception -> 0x00c5, all -> 0x00c1 }
            java.lang.String r7 = ".tmp"
            r14.append(r7)     // Catch:{ Exception -> 0x00c5, all -> 0x00c1 }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x00c5, all -> 0x00c1 }
            java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x00c5, all -> 0x00c1 }
            r7.<init>(r3, r14)     // Catch:{ Exception -> 0x00c5, all -> 0x00c1 }
            java.io.FileOutputStream r14 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00c5, all -> 0x00c1 }
            r14.<init>(r7)     // Catch:{ Exception -> 0x00c5, all -> 0x00c1 }
            r8 = 0
        L_0x003e:
            int r1 = r4.read(r0)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r10 = -1
            if (r1 == r10) goto L_0x0063
            r10 = 0
            r14.write(r0, r10, r1)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            long r11 = (long) r1     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            long r8 = r8 + r11
            float r1 = (float) r8     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r11 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 * r11
            float r11 = (float) r5     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            float r1 = r1 / r11
            r11 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 * r11
            int r1 = (int) r1     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            android.os.Handler r11 = r13.f46573f     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r12 = 102(0x66, float:1.43E-43)
            android.os.Message r1 = r11.obtainMessage(r12, r1, r10)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r1.sendToTarget()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            goto L_0x003e
        L_0x0063:
            r14.flush()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            int r0 = r13.f46569b     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            boolean r0 = r13.m33418a(r7, r0)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            if (r0 == 0) goto L_0x009c
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r1 = r13.f46571d     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r0.<init>(r3, r1)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            boolean r1 = com.didichuxing.dfbasesdk.utils.FileUtils.rename(r7, r0)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            if (r1 == 0) goto L_0x008b
            android.os.Handler r1 = r13.f46573f     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r3 = 100
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            android.os.Message r0 = r1.obtainMessage(r3, r0)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r0.sendToTarget()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            goto L_0x00af
        L_0x008b:
            android.os.Handler r0 = r13.f46573f     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r3 = "重命名失败"
            r1.<init>(r3)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            android.os.Message r0 = r0.obtainMessage(r2, r1)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r0.sendToTarget()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            goto L_0x00af
        L_0x009c:
            com.didichuxing.dfbasesdk.utils.FileUtils.delete((java.io.File) r7)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            android.os.Handler r0 = r13.f46573f     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r3 = "下载失败"
            r1.<init>(r3)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            android.os.Message r0 = r0.obtainMessage(r2, r1)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r0.sendToTarget()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
        L_0x00af:
            if (r4 == 0) goto L_0x00b9
            r4.close()     // Catch:{ IOException -> 0x00b5 }
            goto L_0x00b9
        L_0x00b5:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00b9:
            r14.close()     // Catch:{ IOException -> 0x00ea }
            goto L_0x00ee
        L_0x00bd:
            r0 = move-exception
            goto L_0x00c3
        L_0x00bf:
            r0 = move-exception
            goto L_0x00c7
        L_0x00c1:
            r0 = move-exception
            r14 = r1
        L_0x00c3:
            r1 = r4
            goto L_0x00f0
        L_0x00c5:
            r0 = move-exception
            r14 = r1
        L_0x00c7:
            r1 = r4
            goto L_0x00ce
        L_0x00c9:
            r0 = move-exception
            r14 = r1
            goto L_0x00f0
        L_0x00cc:
            r0 = move-exception
            r14 = r1
        L_0x00ce:
            r0.printStackTrace()     // Catch:{ all -> 0x00ef }
            android.os.Handler r3 = r13.f46573f     // Catch:{ all -> 0x00ef }
            android.os.Message r0 = r3.obtainMessage(r2, r0)     // Catch:{ all -> 0x00ef }
            r0.sendToTarget()     // Catch:{ all -> 0x00ef }
            if (r1 == 0) goto L_0x00e4
            r1.close()     // Catch:{ IOException -> 0x00e0 }
            goto L_0x00e4
        L_0x00e0:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00e4:
            if (r14 == 0) goto L_0x00ee
            r14.close()     // Catch:{ IOException -> 0x00ea }
            goto L_0x00ee
        L_0x00ea:
            r14 = move-exception
            r14.printStackTrace()
        L_0x00ee:
            return
        L_0x00ef:
            r0 = move-exception
        L_0x00f0:
            if (r1 == 0) goto L_0x00fa
            r1.close()     // Catch:{ IOException -> 0x00f6 }
            goto L_0x00fa
        L_0x00f6:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00fa:
            if (r14 == 0) goto L_0x0104
            r14.close()     // Catch:{ IOException -> 0x0100 }
            goto L_0x0104
        L_0x0100:
            r14 = move-exception
            r14.printStackTrace()
        L_0x0104:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.download.DownloadCallBack.onSuccess(com.didichuxing.foundation.net.rpc.http.HttpRpcResponse):void");
    }

    /* renamed from: a */
    private boolean m33418a(File file, int i) {
        return i <= 0 || file.length() == ((long) i);
    }

    public void onFailure(HttpRpcRequest httpRpcRequest, IOException iOException) {
        this.f46573f.obtainMessage(101, iOException).sendToTarget();
    }
}
