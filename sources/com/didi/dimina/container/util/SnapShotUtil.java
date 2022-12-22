package com.didi.dimina.container.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.bridge.storage.MMKVUtil;
import com.didi.dimina.container.mina.DMThreadPool;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.webengine.WebViewEngine;
import java.io.File;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

public class SnapShotUtil {

    /* renamed from: b */
    private static final String f17964b = "SnapshotUtil";

    /* renamed from: c */
    private static final String f17965c = "dimina/snapshot/";

    /* renamed from: d */
    private static final String f17966d = "SNAPSHOTWIDTHKEY";

    /* renamed from: e */
    private static final String f17967e = "SNAPSHOTHEIGHTKEY";

    /* renamed from: g */
    private static SnapShotUtil f17968g;

    /* renamed from: a */
    Handler f17969a = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f17970f = false;

    private SnapShotUtil() {
    }

    public static SnapShotUtil getInstance() {
        if (f17968g == null) {
            synchronized (SnapShotUtil.class) {
                if (f17968g == null) {
                    f17968g = new SnapShotUtil();
                }
            }
        }
        return f17968g;
    }

    public void saveSnapshot(final DMPage dMPage) {
        LogUtil.iRelease(f17964b, "saveSnapshot start");
        final int[] iArr = {0};
        final int snapshotMaxTimes = dMPage.getDMMina().getConfig().getLaunchConfig().getSnapshotConfig().getSnapshotMaxTimes();
        this.f17969a.postDelayed(new Runnable() {
            public void run() {
                if (iArr[0] < snapshotMaxTimes) {
                    boolean unused = SnapShotUtil.this.f17970f = true;
                    int[] iArr = iArr;
                    iArr[0] = iArr[0] + 1;
                    SnapShotUtil.this.m13430a(dMPage);
                    SnapShotUtil.this.f17969a.postDelayed(this, (long) dMPage.getDMMina().getConfig().getLaunchConfig().getSnapshotConfig().getSnapshotTimeInterval());
                    return;
                }
                boolean unused2 = SnapShotUtil.this.f17970f = false;
            }
        }, (long) dMPage.getDMMina().getConfig().getLaunchConfig().getSnapshotConfig().getSnapshotFirstTimeInterval());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m13430a(DMPage dMPage) {
        try {
            DMThreadPool.getExecutor().execute(new Runnable(dMPage) {
                public final /* synthetic */ DMPage f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    SnapShotUtil.this.m13434c(this.f$1);
                }
            });
        } catch (Exception e) {
            LogUtil.eRelease(f17964b, "saveSnapshot exception:" + Log.getStackTraceString(e));
        }
        return;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m13434c(DMPage dMPage) {
        LogUtil.iRelease(f17964b, "doSave");
        WebViewEngine webView = dMPage.getWebViewContainer().getWebView();
        String b = m13433b(dMPage);
        if (dMPage.isDestroyed()) {
            LogUtil.wRelease(f17964b, "saveSnapshot: page is destroy");
        } else if (TextUtils.isEmpty(b)) {
            LogUtil.wRelease(f17964b, "saveSnapshot: The path to the current page could not be found");
        } else if (webView == null) {
            LogUtil.wRelease(f17964b, "saveSnapshot: webView is null");
        } else if (webView.getWebView().getWidth() <= 0 || webView.getWebView().getHeight() <= 0) {
            LogUtil.wRelease(f17964b, "saveSnapshot: webView  width <= 0 || height <= 0");
        } else {
            Bitmap createBitmap = Bitmap.createBitmap(webView.getWebView().getWidth(), webView.getWebView().getHeight(), Bitmap.Config.RGB_565);
            webView.getWebView().draw(new Canvas(createBitmap));
            saveBitmap(createBitmap, m13429a(dMPage.getDMMina().getConfig()), b, webView.getActivity());
        }
    }

    public void stopTimingSaveSnapshot() {
        LogUtil.iRelease(f17964b, "stopTimingSaveSnapshot");
        this.f17970f = false;
        this.f17969a.removeCallbacksAndMessages((Object) null);
    }

    public synchronized void hideSnapshot(DMPage dMPage) {
        dMPage.getClass();
        UIHandlerUtil.runOnUiThread(new Runnable() {
            public final void run() {
                DMPage.this.hideLoadingView();
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007c, code lost:
        if (r3 == null) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007e, code lost:
        r3.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cd, code lost:
        if (r3 != null) goto L_0x007e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00aa A[SYNTHETIC, Splitter:B:30:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d4 A[SYNTHETIC, Splitter:B:40:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f9 A[Catch:{ IOException -> 0x0060 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void saveBitmap(android.graphics.Bitmap r3, java.lang.String r4, java.lang.String r5, android.content.Context r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "SnapshotUtil"
            java.lang.String r1 = "saveBitmap: start"
            com.didi.dimina.container.util.LogUtil.iRelease(r0, r1)     // Catch:{ all -> 0x00fd }
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x008c }
            java.io.File r4 = com.didi.dimina.container.util.FileUtil.getInternalFilesDirectory(r6, r4)     // Catch:{ Exception -> 0x008c }
            r1.<init>(r4, r5)     // Catch:{ Exception -> 0x008c }
            boolean r4 = r1.exists()     // Catch:{ Exception -> 0x008c }
            if (r4 != 0) goto L_0x001c
            r1.createNewFile()     // Catch:{ Exception -> 0x008c }
        L_0x001c:
            java.lang.String r4 = r1.getAbsolutePath()     // Catch:{ Exception -> 0x008c }
            com.didi.dimina.container.util.FileUtil.delete((java.lang.String) r4)     // Catch:{ Exception -> 0x008c }
            com.didi.dimina.container.bridge.storage.MMKVUtil r4 = com.didi.dimina.container.bridge.storage.MMKVUtil.getInstance()     // Catch:{ Exception -> 0x008c }
            java.lang.String r5 = "SNAPSHOTWIDTHKEY"
            int r6 = r3.getWidth()     // Catch:{ Exception -> 0x008c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x008c }
            r4.save(r5, r6)     // Catch:{ Exception -> 0x008c }
            com.didi.dimina.container.bridge.storage.MMKVUtil r4 = com.didi.dimina.container.bridge.storage.MMKVUtil.getInstance()     // Catch:{ Exception -> 0x008c }
            java.lang.String r5 = "SNAPSHOTHEIGHTKEY"
            int r6 = r3.getHeight()     // Catch:{ Exception -> 0x008c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x008c }
            r4.save(r5, r6)     // Catch:{ Exception -> 0x008c }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x008c }
            r4.<init>(r1)     // Catch:{ Exception -> 0x008c }
            android.graphics.Bitmap$CompressFormat r5 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0086, all -> 0x0082 }
            r6 = 100
            r3.compress(r5, r6, r4)     // Catch:{ Exception -> 0x0086, all -> 0x0082 }
            java.lang.String r5 = "SnapshotUtil"
            java.lang.String r6 = "saveBitmap: success"
            com.didi.dimina.container.util.LogUtil.iRelease(r5, r6)     // Catch:{ Exception -> 0x0086, all -> 0x0082 }
            r4.flush()     // Catch:{ IOException -> 0x0060 }
            r4.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x007c
        L_0x0060:
            r4 = move-exception
            java.lang.String r5 = "SnapshotUtil"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fd }
            r6.<init>()     // Catch:{ all -> 0x00fd }
            java.lang.String r0 = "saveBitmap exception finally:"
            r6.append(r0)     // Catch:{ all -> 0x00fd }
            java.lang.String r4 = android.util.Log.getStackTraceString(r4)     // Catch:{ all -> 0x00fd }
            r6.append(r4)     // Catch:{ all -> 0x00fd }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x00fd }
            com.didi.dimina.container.util.LogUtil.eRelease(r5, r4)     // Catch:{ all -> 0x00fd }
        L_0x007c:
            if (r3 == 0) goto L_0x00d0
        L_0x007e:
            r3.recycle()     // Catch:{ all -> 0x00fd }
            goto L_0x00d0
        L_0x0082:
            r5 = move-exception
            r0 = r4
            r4 = r5
            goto L_0x00d2
        L_0x0086:
            r5 = move-exception
            r0 = r4
            r4 = r5
            goto L_0x008d
        L_0x008a:
            r4 = move-exception
            goto L_0x00d2
        L_0x008c:
            r4 = move-exception
        L_0x008d:
            java.lang.String r5 = "SnapshotUtil"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x008a }
            r6.<init>()     // Catch:{ all -> 0x008a }
            java.lang.String r1 = "saveBitmap exception:"
            r6.append(r1)     // Catch:{ all -> 0x008a }
            java.lang.String r4 = android.util.Log.getStackTraceString(r4)     // Catch:{ all -> 0x008a }
            r6.append(r4)     // Catch:{ all -> 0x008a }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x008a }
            com.didi.dimina.container.util.LogUtil.eRelease(r5, r4)     // Catch:{ all -> 0x008a }
            if (r0 == 0) goto L_0x00cd
            r0.flush()     // Catch:{ IOException -> 0x00b1 }
            r0.close()     // Catch:{ IOException -> 0x00b1 }
            goto L_0x00cd
        L_0x00b1:
            r4 = move-exception
            java.lang.String r5 = "SnapshotUtil"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fd }
            r6.<init>()     // Catch:{ all -> 0x00fd }
            java.lang.String r0 = "saveBitmap exception finally:"
            r6.append(r0)     // Catch:{ all -> 0x00fd }
            java.lang.String r4 = android.util.Log.getStackTraceString(r4)     // Catch:{ all -> 0x00fd }
            r6.append(r4)     // Catch:{ all -> 0x00fd }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x00fd }
            com.didi.dimina.container.util.LogUtil.eRelease(r5, r4)     // Catch:{ all -> 0x00fd }
        L_0x00cd:
            if (r3 == 0) goto L_0x00d0
            goto L_0x007e
        L_0x00d0:
            monitor-exit(r2)
            return
        L_0x00d2:
            if (r0 == 0) goto L_0x00f7
            r0.flush()     // Catch:{ IOException -> 0x00db }
            r0.close()     // Catch:{ IOException -> 0x00db }
            goto L_0x00f7
        L_0x00db:
            r5 = move-exception
            java.lang.String r6 = "SnapshotUtil"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fd }
            r0.<init>()     // Catch:{ all -> 0x00fd }
            java.lang.String r1 = "saveBitmap exception finally:"
            r0.append(r1)     // Catch:{ all -> 0x00fd }
            java.lang.String r5 = android.util.Log.getStackTraceString(r5)     // Catch:{ all -> 0x00fd }
            r0.append(r5)     // Catch:{ all -> 0x00fd }
            java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x00fd }
            com.didi.dimina.container.util.LogUtil.eRelease(r6, r5)     // Catch:{ all -> 0x00fd }
        L_0x00f7:
            if (r3 == 0) goto L_0x00fc
            r3.recycle()     // Catch:{ all -> 0x00fd }
        L_0x00fc:
            throw r4     // Catch:{ all -> 0x00fd }
        L_0x00fd:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.util.SnapShotUtil.saveBitmap(android.graphics.Bitmap, java.lang.String, java.lang.String, android.content.Context):void");
    }

    public Bitmap getSnapshot(DMPage dMPage) {
        try {
            LogUtil.iRelease(f17964b, "getSnapshot: start");
            String b = m13433b(dMPage);
            if (TextUtils.isEmpty(b)) {
                LogUtil.wRelease(f17964b, "getSnapshot: The path to the current page could not be found");
                return null;
            }
            File file = new File(FileUtil.getInternalFilesDirectory(dMPage.getContext(), m13429a(dMPage.getDMMina().getConfig())), b);
            if (!file.exists()) {
                LogUtil.iRelease(f17964b, "getSnapshot finish: The cached snapshot could not be found");
                return null;
            }
            return m13428a(file.getAbsolutePath(), ((Integer) MMKVUtil.getInstance().get(f17966d, 1080)).intValue(), ((Integer) MMKVUtil.getInstance().get(f17967e, 1920)).intValue());
        } catch (Exception e) {
            LogUtil.eRelease(f17964b, "getSnapshot exception:" + Log.getStackTraceString(e));
            return null;
        }
    }

    /* renamed from: b */
    private String m13433b(DMPage dMPage) {
        String str = dMPage.getNavigateConfig().url;
        if (str.contains("?")) {
            str = str.split("\\?")[0];
        }
        JSONObject jSONObject = JSONUtil.toJSONObject(dMPage.getNavigateConfig().query);
        if (jSONObject != null) {
            str = str + "fromDidiTabbar=" + jSONObject.optString("fromDidiTabbar");
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LogUtil.eRelease(f17964b, "getSnapshotFileName exception:" + Log.getStackTraceString(e));
            return "";
        }
    }

    /* renamed from: a */
    private String m13429a(DMConfig dMConfig) {
        return f17965c + dMConfig.getLaunchConfig().getAppId() + "/";
    }

    public boolean isNeedInterceptSnapshot() {
        return this.f17970f;
    }

    /* renamed from: a */
    private static Bitmap m13428a(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = m13427a(options, i, i2);
        PrintStream printStream = System.out;
        printStream.println("sampleSize1===" + options.inSampleSize);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    /* renamed from: a */
    private static int m13427a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            while (i3 / i5 >= i2 && i4 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }
}
