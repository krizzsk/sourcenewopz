package com.didi.foundation.sdk.swarm;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.didi.beatles.p099im.picture.config.IMPictureMimeType;
import com.didi.common.map.MapView;
import com.didi.common.map.listener.OnCaptureMapViewListener;
import com.didichuxing.swarm.toolkit.ScreenshotService;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;

final class ScreenShotServiceImp implements Application.ActivityLifecycleCallbacks, ScreenshotService {

    /* renamed from: a */
    private static final String f21343a = "ScreenshotService";

    /* renamed from: b */
    private static final int f21344b = 75;

    /* renamed from: c */
    private final SimpleDateFormat f21345c = new SimpleDateFormat("yyyyMMddhhmmssSSS");

    /* renamed from: d */
    private List<MapView> f21346d = new ArrayList();

    /* renamed from: e */
    private Activity f21347e;

    /* renamed from: f */
    private Context f21348f;

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    ScreenShotServiceImp(Application application) {
        this.f21348f = application;
        application.registerActivityLifecycleCallbacks(this);
    }

    public void takeScreenshot(ScreenshotService.Callback callback) {
        takeScreenshot(1, callback);
    }

    public void takeScreenshot(int i, final ScreenshotService.Callback callback) {
        Activity activity = this.f21347e;
        if (activity != null) {
            final File b = m15689b();
            final View rootView = activity.getWindow().getDecorView().getRootView();
            boolean isDrawingCacheEnabled = rootView.isDrawingCacheEnabled();
            int drawingCacheBackgroundColor = rootView.getDrawingCacheBackgroundColor();
            rootView.setDrawingCacheBackgroundColor(0);
            rootView.setDrawingCacheEnabled(true);
            rootView.buildDrawingCache();
            final Bitmap createBitmap = Bitmap.createBitmap(rootView.getDrawingCache());
            rootView.setDrawingCacheBackgroundColor(drawingCacheBackgroundColor);
            rootView.setDrawingCacheEnabled(isDrawingCacheEnabled);
            rootView.destroyDrawingCache();
            final C83891 r5 = new ScreenshotService.Callback() {
                public void onScreenshotTaken(Uri uri) {
                    callback.onScreenshotTaken(uri);
                }
            };
            final int i2 = i;
            new Thread(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:14:0x0021 A[SYNTHETIC, Splitter:B:14:0x0021] */
                /* JADX WARNING: Removed duplicated region for block: B:22:0x0032 A[SYNTHETIC, Splitter:B:22:0x0032] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r6 = this;
                        r0 = 0
                        java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x002f, all -> 0x001b }
                        java.io.File r2 = r3     // Catch:{ IOException -> 0x002f, all -> 0x001b }
                        r1.<init>(r2)     // Catch:{ IOException -> 0x002f, all -> 0x001b }
                        android.graphics.Bitmap r0 = r4     // Catch:{ IOException -> 0x0019, all -> 0x0017 }
                        android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ IOException -> 0x0019, all -> 0x0017 }
                        r3 = 75
                        r0.compress(r2, r3, r1)     // Catch:{ IOException -> 0x0019, all -> 0x0017 }
                        r1.close()     // Catch:{ IOException -> 0x0015 }
                        goto L_0x003a
                    L_0x0015:
                        r0 = move-exception
                        goto L_0x0037
                    L_0x0017:
                        r0 = move-exception
                        goto L_0x001f
                    L_0x0019:
                        r0 = r1
                        goto L_0x0030
                    L_0x001b:
                        r1 = move-exception
                        r5 = r1
                        r1 = r0
                        r0 = r5
                    L_0x001f:
                        if (r1 == 0) goto L_0x0029
                        r1.close()     // Catch:{ IOException -> 0x0025 }
                        goto L_0x0029
                    L_0x0025:
                        r1 = move-exception
                        r1.printStackTrace()
                    L_0x0029:
                        android.graphics.Bitmap r1 = r4
                        r1.recycle()
                        throw r0
                    L_0x002f:
                    L_0x0030:
                        if (r0 == 0) goto L_0x003a
                        r0.close()     // Catch:{ IOException -> 0x0036 }
                        goto L_0x003a
                    L_0x0036:
                        r0 = move-exception
                    L_0x0037:
                        r0.printStackTrace()
                    L_0x003a:
                        android.graphics.Bitmap r0 = r4
                        r0.recycle()
                        com.didichuxing.swarm.toolkit.ScreenshotService$Callback r0 = r5
                        com.didi.foundation.sdk.swarm.ScreenShotServiceImp r1 = com.didi.foundation.sdk.swarm.ScreenShotServiceImp.this
                        android.view.View r2 = r6
                        java.io.File r3 = r3
                        int r4 = r7
                        java.io.File r1 = r1.m15683a((android.view.View) r2, (java.io.File) r3, (int) r4)
                        android.net.Uri r1 = android.net.Uri.fromFile(r1)
                        r0.onScreenshotTaken(r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.didi.foundation.sdk.swarm.ScreenShotServiceImp.C83902.run():void");
                }
            }).start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public File m15683a(View view, File file, int i) {
        m15687a(view);
        final ArrayList arrayList = new ArrayList();
        List<MapView> list = this.f21346d;
        if (list != null && !list.isEmpty()) {
            final CountDownLatch countDownLatch = new CountDownLatch(this.f21346d.size());
            for (MapView next : this.f21346d) {
                try {
                    final Snapshot snapshot = new Snapshot(next, i);
                    next.getMap().captureMapView(new OnCaptureMapViewListener() {
                        public void onCaptureFinish(Bitmap bitmap) {
                            ScreenShotServiceImp.this.m15686a(bitmap, snapshot, (List<Snapshot>) arrayList, countDownLatch);
                        }
                    }, Bitmap.Config.ARGB_8888);
                } catch (Exception unused) {
                    new Handler(Looper.getMainLooper()) {
                        public void handleMessage(Message message) {
                            countDownLatch.countDown();
                        }
                    }.obtainMessage().sendToTarget();
                }
            }
            m15685a();
            try {
                countDownLatch.await();
                if (arrayList.isEmpty()) {
                    return file;
                }
                return m15682a(i, (List<Snapshot>) arrayList, file);
            } catch (InterruptedException unused2) {
            }
        }
        return file;
    }

    /* renamed from: a */
    private void m15687a(View view) {
        m15685a();
        Stack stack = new Stack();
        stack.push(view);
        while (!stack.isEmpty()) {
            View view2 = (View) stack.pop();
            if ((view2 instanceof MapView) && view2.getVisibility() == 0) {
                this.f21346d.add((MapView) view2);
            }
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    stack.push(viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* renamed from: a */
    private void m15685a() {
        List<MapView> list = this.f21346d;
        if (list != null && list.size() != 0) {
            this.f21346d.clear();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0029 A[SYNTHETIC, Splitter:B:19:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0038 A[SYNTHETIC, Splitter:B:27:0x0038] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m15686a(android.graphics.Bitmap r4, com.didi.foundation.sdk.swarm.ScreenShotServiceImp.Snapshot r5, java.util.List<com.didi.foundation.sdk.swarm.ScreenShotServiceImp.Snapshot> r6, java.util.concurrent.CountDownLatch r7) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0035, all -> 0x0026 }
            java.io.File r2 = r5.mFile     // Catch:{ IOException -> 0x0035, all -> 0x0026 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0035, all -> 0x0026 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ IOException -> 0x0024, all -> 0x0021 }
            r2 = 75
            boolean r0 = r4.compress(r0, r2, r1)     // Catch:{ IOException -> 0x0024, all -> 0x0021 }
            if (r0 == 0) goto L_0x0018
            r6.add(r5)     // Catch:{ IOException -> 0x0024, all -> 0x0021 }
        L_0x0018:
            r4.recycle()     // Catch:{ IOException -> 0x0024, all -> 0x0021 }
            r1.close()     // Catch:{ IOException -> 0x001f }
            goto L_0x0040
        L_0x001f:
            r4 = move-exception
            goto L_0x003d
        L_0x0021:
            r4 = move-exception
            r0 = r1
            goto L_0x0027
        L_0x0024:
            r0 = r1
            goto L_0x0036
        L_0x0026:
            r4 = move-exception
        L_0x0027:
            if (r0 == 0) goto L_0x0031
            r0.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0031:
            r7.countDown()
            throw r4
        L_0x0035:
        L_0x0036:
            if (r0 == 0) goto L_0x0040
            r0.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0040
        L_0x003c:
            r4 = move-exception
        L_0x003d:
            r4.printStackTrace()
        L_0x0040:
            r7.countDown()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.foundation.sdk.swarm.ScreenShotServiceImp.m15686a(android.graphics.Bitmap, com.didi.foundation.sdk.swarm.ScreenShotServiceImp$Snapshot, java.util.List, java.util.concurrent.CountDownLatch):void");
    }

    /* renamed from: b */
    private File m15689b() {
        File file = new File(new File(this.f21348f.getFilesDir(), "Screenshots"), this.f21345c.format(new Date()) + IMPictureMimeType.PNG);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        return file;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x009d A[SYNTHETIC, Splitter:B:39:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b3 A[LOOP:4: B:43:0x00ad->B:45:0x00b3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c1 A[SYNTHETIC, Splitter:B:49:0x00c1] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.File m15682a(int r11, java.util.List<com.didi.foundation.sdk.swarm.ScreenShotServiceImp.Snapshot> r12, java.io.File r13) {
        /*
            r10 = this;
            java.io.File r0 = r10.m15689b()
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options
            r1.<init>()
            r1.inSampleSize = r11
            java.util.Iterator r11 = r12.iterator()
        L_0x000f:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto L_0x0028
            java.lang.Object r2 = r11.next()
            com.didi.foundation.sdk.swarm.ScreenShotServiceImp$Snapshot r2 = (com.didi.foundation.sdk.swarm.ScreenShotServiceImp.Snapshot) r2
            java.io.File r3 = r2.mFile
            java.lang.String r3 = r3.getAbsolutePath()
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeFile(r3, r1)
            r2.mImage = r3
            goto L_0x000f
        L_0x0028:
            java.lang.String r11 = r13.getAbsolutePath()
            android.graphics.Bitmap r11 = android.graphics.BitmapFactory.decodeFile(r11, r1)
            int r13 = r11.getWidth()
            int r1 = r11.getHeight()
            android.graphics.Bitmap$Config r2 = r11.getConfig()
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r13, r1, r2)
            r3 = 0
            r4 = 0
        L_0x0042:
            if (r4 >= r1) goto L_0x0078
            r5 = 0
        L_0x0045:
            if (r5 >= r13) goto L_0x0075
            int r6 = r11.getPixel(r5, r4)     // Catch:{ all -> 0x0073 }
            r7 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            if (r7 != r6) goto L_0x006d
            java.util.Iterator r6 = r12.iterator()     // Catch:{ all -> 0x0073 }
        L_0x0053:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0073 }
            if (r7 == 0) goto L_0x0070
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0073 }
            com.didi.foundation.sdk.swarm.ScreenShotServiceImp$Snapshot r7 = (com.didi.foundation.sdk.swarm.ScreenShotServiceImp.Snapshot) r7     // Catch:{ all -> 0x0073 }
            boolean r8 = r7.contains(r5, r4)     // Catch:{ all -> 0x0073 }
            if (r8 == 0) goto L_0x0053
            int r6 = r7.getPixel(r5, r4)     // Catch:{ all -> 0x0073 }
            r2.setPixel(r5, r4, r6)     // Catch:{ all -> 0x0073 }
            goto L_0x0070
        L_0x006d:
            r2.setPixel(r5, r4, r6)     // Catch:{ all -> 0x0073 }
        L_0x0070:
            int r5 = r5 + 1
            goto L_0x0045
        L_0x0073:
            r13 = move-exception
            goto L_0x00ca
        L_0x0075:
            int r4 = r4 + 1
            goto L_0x0042
        L_0x0078:
            r13 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0094, all -> 0x0090 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x0094, all -> 0x0090 }
            android.graphics.Bitmap$CompressFormat r13 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ IOException -> 0x008e }
            r3 = 75
            r2.compress(r13, r3, r1)     // Catch:{ IOException -> 0x008e }
            r1.close()     // Catch:{ IOException -> 0x0089 }
            goto L_0x00a3
        L_0x0089:
            r13 = move-exception
        L_0x008a:
            r13.printStackTrace()     // Catch:{ all -> 0x0073 }
            goto L_0x00a3
        L_0x008e:
            r13 = move-exception
            goto L_0x0098
        L_0x0090:
            r0 = move-exception
            r1 = r13
            r13 = r0
            goto L_0x00bf
        L_0x0094:
            r1 = move-exception
            r9 = r1
            r1 = r13
            r13 = r9
        L_0x0098:
            r13.printStackTrace()     // Catch:{ all -> 0x00be }
            if (r1 == 0) goto L_0x00a3
            r1.close()     // Catch:{ IOException -> 0x00a1 }
            goto L_0x00a3
        L_0x00a1:
            r13 = move-exception
            goto L_0x008a
        L_0x00a3:
            r11.recycle()
            r2.recycle()
            java.util.Iterator r11 = r12.iterator()
        L_0x00ad:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x00bd
            java.lang.Object r12 = r11.next()
            com.didi.foundation.sdk.swarm.ScreenShotServiceImp$Snapshot r12 = (com.didi.foundation.sdk.swarm.ScreenShotServiceImp.Snapshot) r12
            r12.recycle()
            goto L_0x00ad
        L_0x00bd:
            return r0
        L_0x00be:
            r13 = move-exception
        L_0x00bf:
            if (r1 == 0) goto L_0x00c9
            r1.close()     // Catch:{ IOException -> 0x00c5 }
            goto L_0x00c9
        L_0x00c5:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0073 }
        L_0x00c9:
            throw r13     // Catch:{ all -> 0x0073 }
        L_0x00ca:
            r11.recycle()
            r2.recycle()
            java.util.Iterator r11 = r12.iterator()
        L_0x00d4:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x00e4
            java.lang.Object r12 = r11.next()
            com.didi.foundation.sdk.swarm.ScreenShotServiceImp$Snapshot r12 = (com.didi.foundation.sdk.swarm.ScreenShotServiceImp.Snapshot) r12
            r12.recycle()
            goto L_0x00d4
        L_0x00e4:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.foundation.sdk.swarm.ScreenShotServiceImp.m15682a(int, java.util.List, java.io.File):java.io.File");
    }

    public void onActivityResumed(Activity activity) {
        this.f21347e = activity;
    }

    public void onActivityPaused(Activity activity) {
        this.f21347e = null;
    }

    private class Snapshot {
        final Rect mBound;
        final File mFile;
        Bitmap mImage;

        Snapshot(View view, int i) throws IOException {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            this.mBound = new Rect(iArr[0] / i, iArr[1] / i, (iArr[0] + view.getWidth()) / i, (iArr[1] + view.getHeight()) / i);
            File createTempFile = File.createTempFile("swarm.", ".snapshot");
            this.mFile = createTempFile;
            createTempFile.deleteOnExit();
        }

        /* access modifiers changed from: package-private */
        public boolean contains(int i, int i2) {
            return this.mBound.contains(i, i2);
        }

        /* access modifiers changed from: package-private */
        public int getPixel(int i, int i2) {
            Bitmap bitmap = this.mImage;
            if (bitmap != null) {
                try {
                    return bitmap.getPixel(i - this.mBound.left, i2 - this.mBound.top);
                } catch (IllegalArgumentException unused) {
                }
            }
            return -16777216;
        }

        /* access modifiers changed from: package-private */
        public void recycle() {
            Bitmap bitmap = this.mImage;
            if (bitmap != null) {
                bitmap.recycle();
                this.mImage = null;
            }
        }
    }
}
