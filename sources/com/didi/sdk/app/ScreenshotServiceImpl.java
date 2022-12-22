package com.didi.sdk.app;

import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import com.didi.beatles.p099im.picture.config.IMPictureMimeType;
import com.didi.common.map.MapView;
import com.didi.common.map.listener.OnCaptureMapViewListener;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.swarm.toolkit.ScreenshotService;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;

class ScreenshotServiceImpl implements Application.ActivityLifecycleCallbacks, ScreenshotService {

    /* renamed from: a */
    private static final String f35213a = "ScreenCapture";

    /* renamed from: b */
    private final SimpleDateFormat f35214b = new SimpleDateFormat("yyyyMMddhhmmssSSS");

    /* renamed from: c */
    private Activity f35215c;

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

    public ScreenshotServiceImpl(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public void takeScreenshot(ScreenshotService.Callback callback) {
        takeScreenshot(1, callback);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ac A[SYNTHETIC, Splitter:B:36:0x00ac] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b5 A[SYNTHETIC, Splitter:B:42:0x00b5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void takeScreenshot(int r11, final com.didichuxing.swarm.toolkit.ScreenshotService.Callback r12) {
        /*
            r10 = this;
            java.lang.String r0 = "ScreenCapture"
            long r1 = java.lang.System.currentTimeMillis()
            com.didi.sdk.app.ScreenshotServiceImpl$1 r5 = new com.didi.sdk.app.ScreenshotServiceImpl$1
            r5.<init>(r1, r12)
            android.app.Activity r12 = r10.f35215c
            r1 = 0
            if (r12 != 0) goto L_0x0014
            r5.onScreenshotTaken(r1)
            return
        L_0x0014:
            java.io.File r7 = r10.m24920a()
            android.view.Window r12 = r12.getWindow()
            android.view.View r12 = r12.getDecorView()
            android.view.View r12 = r12.getRootView()
            boolean r2 = r12.isDrawingCacheEnabled()
            int r3 = r12.getDrawingCacheBackgroundColor()
            r4 = 0
            r12.setDrawingCacheBackgroundColor(r4)
            r6 = 1
            r12.setDrawingCacheEnabled(r6)
            r12.buildDrawingCache()
            android.graphics.Bitmap r8 = r12.getDrawingCache()
            if (r8 != 0) goto L_0x0041
            r5.onScreenshotTaken(r1)
            return
        L_0x0041:
            android.graphics.Bitmap$Config r8 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r8 = m24919a(r12, r8)
            r12.setDrawingCacheBackgroundColor(r3)
            r12.setDrawingCacheEnabled(r2)
            r12.destroyDrawingCache()
            if (r8 != 0) goto L_0x0056
            r5.onScreenshotTaken(r1)
            return
        L_0x0056:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0099, all -> 0x0097 }
            r2.<init>(r7)     // Catch:{ IOException -> 0x0099, all -> 0x0097 }
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ IOException -> 0x0095 }
            r9 = 75
            r8.compress(r3, r9, r2)     // Catch:{ IOException -> 0x0095 }
            r2.close()     // Catch:{ IOException -> 0x0065 }
        L_0x0065:
            r8.recycle()
            java.util.Collection r12 = r10.m24923a(r12)
            if (r12 == 0) goto L_0x0074
            boolean r2 = r12.isEmpty()
            if (r2 == 0) goto L_0x0080
        L_0x0074:
            java.lang.Object[] r2 = new java.lang.Object[r6]
            java.lang.String r3 = "MapView empty!"
            r2[r4] = r3
            com.didi.sdk.log.Logger.m25808d(r0, r2)
            r5.onScreenshotTaken(r1)
        L_0x0080:
            java.lang.Thread r0 = new java.lang.Thread
            com.didi.sdk.app.ScreenshotServiceImpl$2 r1 = new com.didi.sdk.app.ScreenshotServiceImpl$2
            r3 = r1
            r4 = r10
            r6 = r12
            r8 = r11
            r3.<init>(r5, r6, r7, r8)
            r0.<init>(r1)
            r0.start()
            return
        L_0x0092:
            r11 = move-exception
            r1 = r2
            goto L_0x00b3
        L_0x0095:
            r11 = move-exception
            goto L_0x009b
        L_0x0097:
            r11 = move-exception
            goto L_0x00b3
        L_0x0099:
            r11 = move-exception
            r2 = r1
        L_0x009b:
            r12 = 2
            java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ all -> 0x0092 }
            java.lang.String r3 = "Take screenshot error"
            r12[r4] = r3     // Catch:{ all -> 0x0092 }
            r12[r6] = r11     // Catch:{ all -> 0x0092 }
            com.didi.sdk.log.Logger.m25808d(r0, r12)     // Catch:{ all -> 0x0092 }
            r5.onScreenshotTaken(r1)     // Catch:{ all -> 0x0092 }
            if (r2 == 0) goto L_0x00af
            r2.close()     // Catch:{ IOException -> 0x00af }
        L_0x00af:
            r8.recycle()
            return
        L_0x00b3:
            if (r1 == 0) goto L_0x00b8
            r1.close()     // Catch:{ IOException -> 0x00b8 }
        L_0x00b8:
            r8.recycle()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.app.ScreenshotServiceImpl.takeScreenshot(int, com.didichuxing.swarm.toolkit.ScreenshotService$Callback):void");
    }

    /* renamed from: a */
    private static Bitmap m24919a(View view, Bitmap.Config config) {
        view.clearFocus();
        Bitmap a = m24918a(view.getWidth(), view.getHeight(), config, 1);
        if (a != null) {
            Canvas canvas = new Canvas();
            canvas.setBitmap(a);
            view.draw(canvas);
            canvas.setBitmap((Bitmap) null);
        }
        return a;
    }

    /* renamed from: a */
    private static Bitmap m24918a(int i, int i2, Bitmap.Config config, int i3) {
        try {
            return Bitmap.createBitmap(i, i2, config);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            if (i3 <= 0) {
                return null;
            }
            System.gc();
            return m24918a(i, i2, config, i3 - 1);
        }
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* renamed from: a */
    public java.io.File m24922a(java.util.Collection<com.didi.common.map.MapView> r21, java.io.File r22, int r23) {
        /*
            r20 = this;
            r7 = r20
            r8 = r23
            java.lang.String r9 = "ScreenCapture"
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.concurrent.CountDownLatch r11 = new java.util.concurrent.CountDownLatch
            int r0 = r21.size()
            r11.<init>(r0)
            java.util.Iterator r12 = r21.iterator()
        L_0x0018:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x0065
            java.lang.Object r0 = r12.next()
            r3 = r0
            com.didi.common.map.MapView r3 = (com.didi.common.map.MapView) r3
            com.didi.sdk.app.ScreenshotServiceImpl$Snapshot r4 = new com.didi.sdk.app.ScreenshotServiceImpl$Snapshot     // Catch:{ Exception -> 0x0043 }
            r4.<init>(r3, r8)     // Catch:{ Exception -> 0x0043 }
            android.os.Handler r0 = new android.os.Handler     // Catch:{ Exception -> 0x0043 }
            android.app.Activity r1 = r7.f35215c     // Catch:{ Exception -> 0x0043 }
            android.os.Looper r1 = r1.getMainLooper()     // Catch:{ Exception -> 0x0043 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0043 }
            com.didi.sdk.app.ScreenshotServiceImpl$3 r13 = new com.didi.sdk.app.ScreenshotServiceImpl$3     // Catch:{ Exception -> 0x0043 }
            r1 = r13
            r2 = r20
            r5 = r10
            r6 = r11
            r1.<init>(r3, r4, r5, r6)     // Catch:{ Exception -> 0x0043 }
            r0.postAtFrontOfQueue(r13)     // Catch:{ Exception -> 0x0043 }
            goto L_0x0018
        L_0x0043:
            r0 = move-exception
            r17 = r0
            java.lang.String r16 = r17.getMessage()
            r14 = 6
            r19 = 182(0xb6, float:2.55E-43)
            java.lang.String r15 = "ScreenCapture"
            java.lang.String r18 = "com.didi.sdk.app.ScreenshotServiceImpl"
            com.didi.sdk.apm.SystemUtils.log(r14, r15, r16, r17, r18, r19)
            com.didi.sdk.app.ScreenshotServiceImpl$4 r0 = new com.didi.sdk.app.ScreenshotServiceImpl$4
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            r0.<init>(r1, r11)
            android.os.Message r0 = r0.obtainMessage()
            r0.sendToTarget()
            goto L_0x0018
        L_0x0065:
            r1 = 1
            r2 = 2
            r3 = 0
            r11.await()     // Catch:{ InterruptedException -> 0x0163 }
            boolean r0 = r10.isEmpty()     // Catch:{ InterruptedException -> 0x0163 }
            if (r0 == 0) goto L_0x0072
            return r22
        L_0x0072:
            java.io.File r4 = r20.m24920a()
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r0.inSampleSize = r8
            java.util.Iterator r5 = r10.iterator()
        L_0x0081:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x009a
            java.lang.Object r6 = r5.next()
            com.didi.sdk.app.ScreenshotServiceImpl$Snapshot r6 = (com.didi.sdk.app.ScreenshotServiceImpl.Snapshot) r6
            java.io.File r8 = r6.mFile
            java.lang.String r8 = r8.getAbsolutePath()
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeFile(r8, r0)
            r6.mImage = r8
            goto L_0x0081
        L_0x009a:
            java.lang.String r5 = r22.getAbsolutePath()
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeFile(r5, r0)
            int r0 = r5.getWidth()
            int r6 = r5.getHeight()
            android.graphics.Bitmap$Config r8 = r5.getConfig()
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createBitmap(r0, r6, r8)
            android.graphics.Canvas r0 = new android.graphics.Canvas     // Catch:{ all -> 0x013c }
            r0.<init>(r6)     // Catch:{ all -> 0x013c }
            java.util.Iterator r8 = r10.iterator()     // Catch:{ all -> 0x013c }
            boolean r11 = r8.hasNext()     // Catch:{ all -> 0x013c }
            r12 = 0
            r13 = 0
            if (r11 == 0) goto L_0x00dc
            java.lang.Object r8 = r8.next()     // Catch:{ all -> 0x013c }
            com.didi.sdk.app.ScreenshotServiceImpl$Snapshot r8 = (com.didi.sdk.app.ScreenshotServiceImpl.Snapshot) r8     // Catch:{ all -> 0x013c }
            if (r8 == 0) goto L_0x00dc
            android.graphics.Bitmap r8 = r8.mImage     // Catch:{ all -> 0x013c }
            int r11 = r8.getWidth()     // Catch:{ all -> 0x013c }
            int r14 = r8.getHeight()     // Catch:{ all -> 0x013c }
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createScaledBitmap(r8, r11, r14, r3)     // Catch:{ all -> 0x013c }
            r0.drawBitmap(r8, r13, r13, r12)     // Catch:{ all -> 0x013c }
        L_0x00dc:
            r0.drawBitmap(r5, r13, r13, r12)     // Catch:{ all -> 0x013c }
            r0.save()     // Catch:{ all -> 0x013c }
            r0.restore()     // Catch:{ all -> 0x013c }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00fd }
            r8.<init>(r4)     // Catch:{ IOException -> 0x00fd }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ IOException -> 0x00f8, all -> 0x00f5 }
            r11 = 75
            r6.compress(r0, r11, r8)     // Catch:{ IOException -> 0x00f8, all -> 0x00f5 }
            r8.close()     // Catch:{ IOException -> 0x0110 }
            goto L_0x0110
        L_0x00f5:
            r0 = move-exception
            r12 = r8
            goto L_0x0136
        L_0x00f8:
            r0 = move-exception
            r12 = r8
            goto L_0x00fe
        L_0x00fb:
            r0 = move-exception
            goto L_0x0136
        L_0x00fd:
            r0 = move-exception
        L_0x00fe:
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00fb }
            r2[r3] = r0     // Catch:{ all -> 0x00fb }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00fb }
            r2[r1] = r0     // Catch:{ all -> 0x00fb }
            com.didi.sdk.log.Logger.m25808d(r9, r2)     // Catch:{ all -> 0x00fb }
            if (r12 == 0) goto L_0x0110
            r12.close()     // Catch:{ IOException -> 0x0110 }
        L_0x0110:
            r5.recycle()
            r6.recycle()
            java.util.Iterator r0 = r10.iterator()
        L_0x011a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x012a
            java.lang.Object r1 = r0.next()
            com.didi.sdk.app.ScreenshotServiceImpl$Snapshot r1 = (com.didi.sdk.app.ScreenshotServiceImpl.Snapshot) r1
            r1.recycle()
            goto L_0x011a
        L_0x012a:
            if (r22 == 0) goto L_0x0135
            boolean r0 = r22.exists()
            if (r0 == 0) goto L_0x0135
            r22.delete()
        L_0x0135:
            return r4
        L_0x0136:
            if (r12 == 0) goto L_0x013b
            r12.close()     // Catch:{ IOException -> 0x013b }
        L_0x013b:
            throw r0     // Catch:{ all -> 0x013c }
        L_0x013c:
            r0 = move-exception
            r5.recycle()
            r6.recycle()
            java.util.Iterator r1 = r10.iterator()
        L_0x0147:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0157
            java.lang.Object r2 = r1.next()
            com.didi.sdk.app.ScreenshotServiceImpl$Snapshot r2 = (com.didi.sdk.app.ScreenshotServiceImpl.Snapshot) r2
            r2.recycle()
            goto L_0x0147
        L_0x0157:
            if (r22 == 0) goto L_0x0162
            boolean r1 = r22.exists()
            if (r1 == 0) goto L_0x0162
            r22.delete()
        L_0x0162:
            throw r0
        L_0x0163:
            r0 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r0
            java.lang.String r0 = r0.getMessage()
            r2[r1] = r0
            com.didi.sdk.log.Logger.m25808d(r9, r2)
            return r22
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.app.ScreenshotServiceImpl.m24922a(java.util.Collection, java.io.File, int):java.io.File");
    }

    /* renamed from: a */
    private Collection<MapView> m24923a(View view) {
        ArrayList arrayList = new ArrayList();
        Stack stack = new Stack();
        stack.push(view);
        while (!stack.isEmpty()) {
            View view2 = (View) stack.pop();
            if (view2 instanceof MapView) {
                arrayList.add((MapView) view2);
            }
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    stack.push(viewGroup.getChildAt(i));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private File m24920a() {
        File file = new File(new File(DIDIApplicationDelegate.getAppContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES), "Screenshots"), this.f35214b.format(new Date()) + IMPictureMimeType.PNG);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            SystemUtils.log(6, f35213a, e.getMessage(), e, "com.didi.sdk.app.ScreenshotServiceImpl", 326);
        }
        return file;
    }

    public void onActivityResumed(Activity activity) {
        this.f35215c = activity;
    }

    public void onActivityPaused(Activity activity) {
        this.f35215c = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m24925b(MapView mapView, final Snapshot snapshot, final List<Snapshot> list, final CountDownLatch countDownLatch) {
        mapView.getMap().captureMapView(new OnCaptureMapViewListener() {
            /* JADX WARNING: Removed duplicated region for block: B:27:0x0052 A[SYNTHETIC, Splitter:B:27:0x0052] */
            /* JADX WARNING: Removed duplicated region for block: B:33:0x005d A[SYNTHETIC, Splitter:B:33:0x005d] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onCaptureFinish(android.graphics.Bitmap r8) {
                /*
                    r7 = this;
                    r0 = 0
                    if (r8 != 0) goto L_0x0016
                    java.lang.String r8 = "ScreenCapture"
                    r1 = 1
                    java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ IOException -> 0x0040 }
                    r2 = 0
                    java.lang.String r3 = "Map get null bitmap!"
                    r1[r2] = r3     // Catch:{ IOException -> 0x0040 }
                    com.didi.sdk.log.Logger.m25808d(r8, r1)     // Catch:{ IOException -> 0x0040 }
                    java.util.concurrent.CountDownLatch r8 = r4
                    r8.countDown()
                    return
                L_0x0016:
                    java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0040 }
                    com.didi.sdk.app.ScreenshotServiceImpl$Snapshot r2 = r2     // Catch:{ IOException -> 0x0040 }
                    java.io.File r2 = r2.mFile     // Catch:{ IOException -> 0x0040 }
                    r1.<init>(r2)     // Catch:{ IOException -> 0x0040 }
                    android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ IOException -> 0x003a, all -> 0x0037 }
                    r2 = 75
                    boolean r0 = r8.compress(r0, r2, r1)     // Catch:{ IOException -> 0x003a, all -> 0x0037 }
                    if (r0 == 0) goto L_0x0030
                    java.util.List r0 = r3     // Catch:{ IOException -> 0x003a, all -> 0x0037 }
                    com.didi.sdk.app.ScreenshotServiceImpl$Snapshot r2 = r2     // Catch:{ IOException -> 0x003a, all -> 0x0037 }
                    r0.add(r2)     // Catch:{ IOException -> 0x003a, all -> 0x0037 }
                L_0x0030:
                    r8.recycle()     // Catch:{ IOException -> 0x003a, all -> 0x0037 }
                    r1.close()     // Catch:{ IOException -> 0x0055 }
                    goto L_0x0055
                L_0x0037:
                    r8 = move-exception
                    r0 = r1
                    goto L_0x005b
                L_0x003a:
                    r8 = move-exception
                    r4 = r8
                    r0 = r1
                    goto L_0x0042
                L_0x003e:
                    r8 = move-exception
                    goto L_0x005b
                L_0x0040:
                    r8 = move-exception
                    r4 = r8
                L_0x0042:
                    java.lang.String r2 = "ScreenCapture"
                    java.lang.String r3 = r4.getMessage()     // Catch:{ all -> 0x003e }
                    r1 = 6
                    java.lang.String r5 = "com.didi.sdk.app.ScreenshotServiceImpl$5"
                    r6 = 386(0x182, float:5.41E-43)
                    com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x003e }
                    if (r0 == 0) goto L_0x0055
                    r0.close()     // Catch:{ IOException -> 0x0055 }
                L_0x0055:
                    java.util.concurrent.CountDownLatch r8 = r4
                    r8.countDown()
                    return
                L_0x005b:
                    if (r0 == 0) goto L_0x0060
                    r0.close()     // Catch:{ IOException -> 0x0060 }
                L_0x0060:
                    java.util.concurrent.CountDownLatch r0 = r4
                    r0.countDown()
                    throw r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.app.ScreenshotServiceImpl.C120085.onCaptureFinish(android.graphics.Bitmap):void");
            }
        }, Bitmap.Config.ARGB_8888);
    }

    private static class Snapshot {
        final Rect mBound;
        final File mFile;
        Bitmap mImage;

        public Snapshot(View view, int i) throws IOException {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            this.mBound = new Rect(iArr[0] / i, iArr[1] / i, (iArr[0] + view.getWidth()) / i, (iArr[1] + view.getHeight()) / i);
            File createTempFile = File.createTempFile("swarm.", ".snapshot");
            this.mFile = createTempFile;
            createTempFile.deleteOnExit();
        }

        public boolean contains(int i, int i2) {
            return this.mBound.contains(i, i2);
        }

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

        public void recycle() {
            Bitmap bitmap = this.mImage;
            if (bitmap != null) {
                bitmap.recycle();
                this.mImage = null;
            }
        }
    }

    private static class ViewTree {
        private final View mRoot;

        public ViewTree(View view) {
            this.mRoot = view;
        }

        public void print() {
            Stack stack = new Stack();
            stack.push(new Node((Node) null, this.mRoot, 0, 0, 0));
            while (!stack.isEmpty()) {
                Node node = (Node) stack.pop();
                Node[] children = node.getChildren();
                node.print();
                for (int length = children.length - 1; length >= 0; length--) {
                    stack.push(children[length]);
                }
            }
        }

        private static class Node {
            final int mDepth;
            final int mIndex;
            final Node mParent;
            final int mSiblingCount;
            final View mView;

            public Node(Node node, View view, int i, int i2, int i3) {
                this.mParent = node;
                this.mView = view;
                this.mDepth = i;
                this.mSiblingCount = i2;
                this.mIndex = i3;
            }

            public Node[] getChildren() {
                View view = this.mView;
                if (!(view instanceof ViewGroup)) {
                    return new Node[0];
                }
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                Node[] nodeArr = new Node[childCount];
                for (int i = 0; i < childCount; i++) {
                    nodeArr[i] = new Node(this, viewGroup.getChildAt(i), this.mDepth + 1, childCount, i);
                }
                return nodeArr;
            }

            public StringBuilder getIndent() {
                if (this.mDepth <= 1) {
                    return new StringBuilder();
                }
                StringBuilder indent = this.mParent.getIndent();
                Node node = this.mParent;
                indent.append(node.mIndex + 1 >= node.mSiblingCount ? " " : "│");
                indent.append("   ");
                return indent;
            }

            public void print() {
                int i = this.mDepth;
                if (i <= 0) {
                    SystemUtils.log(4, "ViewTree", this.mView.toString(), (Throwable) null, "com.didi.sdk.app.ScreenshotServiceImpl$ViewTree$Node", 523);
                    return;
                }
                StringBuilder indent = i > 1 ? getIndent() : new StringBuilder();
                indent.append(this.mIndex + 1 >= this.mSiblingCount ? "└" : "├");
                indent.append("── ");
                indent.append(this.mView);
                SystemUtils.log(4, "ViewTree", indent.toString(), (Throwable) null, "com.didi.sdk.app.ScreenshotServiceImpl$ViewTree$Node", 528);
            }
        }
    }
}
