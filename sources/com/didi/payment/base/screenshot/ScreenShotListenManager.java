package com.didi.payment.base.screenshot;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.payment.base.utils.WalletExecutors;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001:B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010#J(\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004H\u0002J\u0006\u0010-\u001a\u00020\u0015J\u0012\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020&H\u0002J\u000e\u00103\u001a\u00020&2\u0006\u00100\u001a\u000201J\u0010\u00104\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010#J\u0006\u00105\u001a\u00020&J\b\u00106\u001a\u00020&H\u0002J\b\u00107\u001a\u00020&H\u0002J\b\u00108\u001a\u00020&H\u0002J\u0006\u00109\u001a\u00020&R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, mo175978d2 = {"Lcom/didi/payment/base/screenshot/ScreenShotListenManager;", "", "()V", "CACHE_SET_SIZE", "", "KEYWORDS", "", "", "[Ljava/lang/String;", "LOOP_CHECK_MILLIS", "", "LOOP_COUNT", "MEDIA_PROJECTIONS_API_16", "QUERY_ORDER_SQL", "START_DELAY_MILLIS", "cacheSet", "Ljava/util/LinkedHashSet;", "cacheSetLock", "", "curLoopCount", "isStart", "", "listenerLock", "mExternalObserver", "Lcom/didi/payment/base/screenshot/ScreenShotListenManager$MediaContentObserver;", "mInternalObserver", "mStartListenTime", "sScreenRealSize", "Landroid/graphics/Point;", "getSScreenRealSize", "()Landroid/graphics/Point;", "sScreenRealSize$delegate", "Lkotlin/Lazy;", "screenShotListenerSet", "", "Lcom/didi/payment/base/screenshot/ScreenShotListener;", "startLock", "addListener", "", "listener", "checkScreenShot", "data", "dateTaken", "width", "height", "checkScreenShotEnable", "getQueryCursor", "Landroid/database/Cursor;", "contentUri", "Landroid/net/Uri;", "loopCheck", "notifyChange", "removeListener", "start", "startInternal", "startReal", "startSyncInternal", "stop", "MediaContentObserver", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ScreenShotListenManager.kt */
public final class ScreenShotListenManager {
    public static final ScreenShotListenManager INSTANCE = new ScreenShotListenManager();

    /* renamed from: a */
    private static final long f29938a = 10000;

    /* renamed from: b */
    private static final long f29939b = 60000;

    /* renamed from: c */
    private static final int f29940c = 10;

    /* renamed from: d */
    private static volatile int f29941d = 0;

    /* renamed from: e */
    private static final int f29942e = 10;

    /* renamed from: f */
    private static byte[] f29943f = new byte[0];

    /* renamed from: g */
    private static final LinkedHashSet<String> f29944g = new LinkedHashSet<>();

    /* renamed from: h */
    private static byte[] f29945h = new byte[0];
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final Set<ScreenShotListener> f29946i = new LinkedHashSet();

    /* renamed from: j */
    private static final String f29947j = "date_added DESC LIMIT 1";

    /* renamed from: k */
    private static long f29948k;

    /* renamed from: l */
    private static final Lazy f29949l = LazyKt.lazy(ScreenShotListenManager$sScreenRealSize$2.INSTANCE);

    /* renamed from: m */
    private static final String[] f29950m = {"_data", "datetaken", "width", "height"};

    /* renamed from: n */
    private static final String[] f29951n = {"screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap", "截屏"};

    /* renamed from: o */
    private static volatile boolean f29952o;

    /* renamed from: p */
    private static byte[] f29953p = new byte[0];

    /* renamed from: q */
    private static MediaContentObserver f29954q;

    /* renamed from: r */
    private static MediaContentObserver f29955r;

    private ScreenShotListenManager() {
    }

    /* renamed from: a */
    private final Point m20992a() {
        return (Point) f29949l.getValue();
    }

    public final void addListener(ScreenShotListener screenShotListener) {
        if (screenShotListener != null) {
            synchronized (f29945h) {
                f29946i.add(screenShotListener);
            }
        }
    }

    public final void removeListener(ScreenShotListener screenShotListener) {
        if (screenShotListener != null) {
            synchronized (f29945h) {
                f29946i.remove(screenShotListener);
            }
        }
    }

    public final void start() {
        if (!f29952o) {
            synchronized (f29953p) {
                if (!f29952o) {
                    WalletScreenShotLifecycle.Companion.register(ApplicationContextProvider.Companion.getContext());
                    WalletExecutors.Companion.scheduleOnce$default(WalletExecutors.Companion, 10000, (TimeUnit) null, $$Lambda$ScreenShotListenManager$AgNZ1wJdwpRwkmNtdcZsDNDIjo.INSTANCE, 2, (Object) null);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        if (r0.intValue() != 1) goto L_0x000b;
     */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m20998f() {
        /*
            java.lang.String r0 = "wallet_screen_shot"
            com.didichuxing.apollo.sdk.IToggle r0 = com.didichuxing.apollo.sdk.Apollo.getToggle(r0)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x000d
        L_0x000b:
            r1 = 0
            goto L_0x0035
        L_0x000d:
            boolean r3 = r0.allow()
            if (r3 == 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            if (r0 != 0) goto L_0x0018
            goto L_0x000b
        L_0x0018:
            com.didichuxing.apollo.sdk.IExperiment r0 = r0.getExperiment()
            if (r0 != 0) goto L_0x001f
            goto L_0x000b
        L_0x001f:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            java.lang.String r4 = "screenshot_Android"
            java.lang.Object r0 = r0.getParam(r4, r3)
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 != 0) goto L_0x002f
            goto L_0x000b
        L_0x002f:
            int r0 = r0.intValue()
            if (r0 != r1) goto L_0x000b
        L_0x0035:
            if (r1 != 0) goto L_0x0038
            return
        L_0x0038:
            com.didi.payment.base.exts.ApplicationContextProvider$Companion r0 = com.didi.payment.base.exts.ApplicationContextProvider.Companion
            android.content.Context r0 = r0.getContext()
            java.lang.String r1 = "android.permission.READ_EXTERNAL_STORAGE"
            int r0 = androidx.core.app.ActivityCompat.checkSelfPermission(r0, r1)
            java.lang.String r1 = "has_sd_permission"
            java.lang.String r2 = "tech_has_sd_permission"
            if (r0 == 0) goto L_0x0056
            java.lang.String r0 = "0"
            com.didi.payment.base.tracker.FinOmegaSDK.trackEvent(r2, r1, r0)
            com.didi.payment.base.screenshot.ScreenShotListenManager r0 = INSTANCE
            r0.m20995c()
            return
        L_0x0056:
            java.lang.String r0 = "1"
            com.didi.payment.base.tracker.FinOmegaSDK.trackEvent(r2, r1, r0)
            com.didi.payment.base.screenshot.ScreenShotListenManager r0 = INSTANCE
            r0.m20994b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.base.screenshot.ScreenShotListenManager.m20998f():void");
    }

    public final boolean checkScreenShotEnable() {
        if (ActivityCompat.checkSelfPermission(ApplicationContextProvider.Companion.getContext(), Permission.READ_EXTERNAL_STORAGE) != 0) {
            return false;
        }
        m20994b();
        return true;
    }

    /* renamed from: b */
    private final void m20994b() {
        if (!f29952o) {
            synchronized (f29953p) {
                if (!f29952o) {
                    f29952o = true;
                    INSTANCE.m20996d();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    /* renamed from: c */
    private final void m20995c() {
        WalletExecutors.Companion.scheduleOnce$default(WalletExecutors.Companion, 60000, (TimeUnit) null, $$Lambda$ScreenShotListenManager$MuQoXVYnTUJJNY0VqDJZWu1tcA4.INSTANCE, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static final void m20999g() {
        if (ActivityCompat.checkSelfPermission(ApplicationContextProvider.Companion.getContext(), Permission.READ_EXTERNAL_STORAGE) != 0) {
            f29941d++;
            if (f29941d < 10) {
                INSTANCE.m20995c();
                return;
            }
            return;
        }
        INSTANCE.m20994b();
    }

    /* renamed from: d */
    private final void m20996d() {
        for (IRegisterScreenShotFirstListener onRegister : DRouter.build(IRegisterScreenShotFirstListener.class).getAllService(new Object[0])) {
            onRegister.onRegister();
        }
        m20997e();
    }

    /* renamed from: e */
    private final void m20997e() {
        Context context = ApplicationContextProvider.Companion.getContext();
        Uri uri = MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(uri, "INTERNAL_CONTENT_URI");
        MediaContentObserver mediaContentObserver = new MediaContentObserver(uri);
        f29954q = mediaContentObserver;
        boolean z = true;
        context.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, Build.VERSION.SDK_INT >= 29, mediaContentObserver);
        Uri uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(uri2, "EXTERNAL_CONTENT_URI");
        MediaContentObserver mediaContentObserver2 = new MediaContentObserver(uri2);
        f29955r = mediaContentObserver2;
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri3 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        if (Build.VERSION.SDK_INT < 29) {
            z = false;
        }
        contentResolver.registerContentObserver(uri3, z, mediaContentObserver2);
        f29948k = System.currentTimeMillis();
    }

    public final void stop() {
        if (f29952o) {
            synchronized (f29953p) {
                if (f29952o) {
                    f29946i.clear();
                    Context context = ApplicationContextProvider.Companion.getContext();
                    MediaContentObserver mediaContentObserver = f29954q;
                    if (mediaContentObserver != null) {
                        try {
                            context.getContentResolver().unregisterContentObserver(mediaContentObserver);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        f29954q = null;
                    }
                    MediaContentObserver mediaContentObserver2 = f29955r;
                    if (mediaContentObserver2 != null) {
                        try {
                            context.getContentResolver().unregisterContentObserver(mediaContentObserver2);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        f29955r = null;
                    }
                    f29952o = false;
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ab, code lost:
        r2 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b3, code lost:
        if (r2.hasNext() == false) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00b5, code lost:
        ((com.didi.payment.base.screenshot.ScreenShotListener) r2.next()).onScreenShot(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00ca, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        kotlin.p245io.CloseableKt.closeFinally(r13, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00ce, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void notifyChange(android.net.Uri r13) {
        /*
            r12 = this;
            java.lang.String r0 = "contentUri"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            android.database.Cursor r13 = r12.m20991a(r13)     // Catch:{ Exception -> 0x00cf }
            if (r13 != 0) goto L_0x000d
            goto L_0x00cf
        L_0x000d:
            boolean r0 = r13.moveToFirst()     // Catch:{ Exception -> 0x00cf }
            r1 = 0
            if (r0 == 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r13 = r1
        L_0x0016:
            if (r13 != 0) goto L_0x001a
            goto L_0x00cf
        L_0x001a:
            java.io.Closeable r13 = (java.io.Closeable) r13     // Catch:{ Exception -> 0x00cf }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ Exception -> 0x00cf }
            r0 = r13
            android.database.Cursor r0 = (android.database.Cursor) r0     // Catch:{ all -> 0x00c8 }
            java.lang.String r2 = "_data"
            int r2 = r0.getColumnIndex(r2)     // Catch:{ all -> 0x00c8 }
            java.lang.String r3 = "datetaken"
            int r3 = r0.getColumnIndex(r3)     // Catch:{ all -> 0x00c8 }
            java.lang.String r4 = "width"
            int r4 = r0.getColumnIndex(r4)     // Catch:{ all -> 0x00c8 }
            java.lang.String r5 = "height"
            int r5 = r0.getColumnIndex(r5)     // Catch:{ all -> 0x00c8 }
            java.lang.String r7 = r0.getString(r2)     // Catch:{ all -> 0x00c8 }
            java.lang.String r2 = "cursor.getString(dataIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)     // Catch:{ all -> 0x00c8 }
            long r2 = r0.getLong(r3)     // Catch:{ all -> 0x00c8 }
            r6 = 0
            if (r4 < 0) goto L_0x0050
            int r4 = r0.getInt(r4)     // Catch:{ all -> 0x00c8 }
            r10 = r4
            goto L_0x0051
        L_0x0050:
            r10 = 0
        L_0x0051:
            if (r5 < 0) goto L_0x0059
            int r0 = r0.getInt(r5)     // Catch:{ all -> 0x00c8 }
            r11 = r0
            goto L_0x005a
        L_0x0059:
            r11 = 0
        L_0x005a:
            com.didi.payment.base.screenshot.ScreenShotListenManager r6 = INSTANCE     // Catch:{ all -> 0x00c8 }
            r8 = r2
            boolean r0 = r6.m20993a(r7, r8, r10, r11)     // Catch:{ all -> 0x00c8 }
            if (r0 == 0) goto L_0x00c2
            java.util.Set<com.didi.payment.base.screenshot.ScreenShotListener> r0 = f29946i     // Catch:{ all -> 0x00c8 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00c8 }
            if (r0 == 0) goto L_0x006f
            kotlin.p245io.CloseableKt.closeFinally(r13, r1)     // Catch:{ Exception -> 0x00cf }
            return
        L_0x006f:
            com.didi.payment.base.screenshot.WalletScreenShotLifecycle$Companion r0 = com.didi.payment.base.screenshot.WalletScreenShotLifecycle.Companion     // Catch:{ all -> 0x00c8 }
            kotlin.Triple r0 = r0.getActivityNameByTime(r2)     // Catch:{ all -> 0x00c8 }
            if (r0 != 0) goto L_0x007b
            kotlin.p245io.CloseableKt.closeFinally(r13, r1)     // Catch:{ Exception -> 0x00cf }
            return
        L_0x007b:
            java.util.LinkedHashSet r2 = new java.util.LinkedHashSet     // Catch:{ all -> 0x00c8 }
            r2.<init>()     // Catch:{ all -> 0x00c8 }
            java.util.Set r2 = (java.util.Set) r2     // Catch:{ all -> 0x00c8 }
            byte[] r3 = f29945h     // Catch:{ all -> 0x00c8 }
            monitor-enter(r3)     // Catch:{ all -> 0x00c8 }
            java.util.Set<com.didi.payment.base.screenshot.ScreenShotListener> r4 = f29946i     // Catch:{ all -> 0x00bf }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x00bf }
            if (r4 == 0) goto L_0x0092
            monitor-exit(r3)     // Catch:{ all -> 0x00c8 }
            kotlin.p245io.CloseableKt.closeFinally(r13, r1)     // Catch:{ Exception -> 0x00cf }
            return
        L_0x0092:
            java.util.Set<com.didi.payment.base.screenshot.ScreenShotListener> r4 = f29946i     // Catch:{ all -> 0x00bf }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x00bf }
        L_0x0098:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x00bf }
            if (r5 == 0) goto L_0x00a8
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x00bf }
            com.didi.payment.base.screenshot.ScreenShotListener r5 = (com.didi.payment.base.screenshot.ScreenShotListener) r5     // Catch:{ all -> 0x00bf }
            r2.add(r5)     // Catch:{ all -> 0x00bf }
            goto L_0x0098
        L_0x00a8:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00bf }
            monitor-exit(r3)     // Catch:{ all -> 0x00c8 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00c8 }
        L_0x00af:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00c8 }
            if (r3 == 0) goto L_0x00c2
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00c8 }
            com.didi.payment.base.screenshot.ScreenShotListener r3 = (com.didi.payment.base.screenshot.ScreenShotListener) r3     // Catch:{ all -> 0x00c8 }
            r3.onScreenShot(r0)     // Catch:{ all -> 0x00c8 }
            goto L_0x00af
        L_0x00bf:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00c8 }
            throw r0     // Catch:{ all -> 0x00c8 }
        L_0x00c2:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00c8 }
            kotlin.p245io.CloseableKt.closeFinally(r13, r1)     // Catch:{ Exception -> 0x00cf }
            goto L_0x00cf
        L_0x00c8:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00ca }
        L_0x00ca:
            r1 = move-exception
            kotlin.p245io.CloseableKt.closeFinally(r13, r0)     // Catch:{ Exception -> 0x00cf }
            throw r1     // Catch:{ Exception -> 0x00cf }
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.base.screenshot.ScreenShotListenManager.notifyChange(android.net.Uri):void");
    }

    /* renamed from: a */
    private final Cursor m20991a(Uri uri) {
        try {
            Context context = ApplicationContextProvider.Companion.getContext();
            if (Build.VERSION.SDK_INT >= 29) {
                Bundle bundle = new Bundle();
                bundle.putStringArray("android:query-arg-sort-columns", new String[]{"datetaken"});
                bundle.putInt("android:query-arg-sort-direction", 1);
                bundle.putInt("android:query-arg-limit", 1);
                return context.getContentResolver().query(uri, f29950m, bundle, (CancellationSignal) null);
            }
            return context.getContentResolver().query(uri, f29950m, (String) null, (String[]) null, f29947j);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private final boolean m20993a(String str, long j, int i, int i2) {
        boolean z;
        if (TextUtils.isEmpty(str) || f29944g.contains(str) || j < f29948k || i > m20992a().x || i2 > m20992a().y || (i2 <= m20992a().x && i <= m20992a().y)) {
            return false;
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        if (str != null) {
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String[] strArr = f29951n;
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z = false;
                    break;
                }
                String str2 = strArr[i3];
                i3++;
                if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) str2, false, 2, (Object) null)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return false;
            }
            synchronized (f29943f) {
                if (f29944g.contains(str)) {
                    return false;
                }
                if (f29944g.size() > 10) {
                    Iterator it = f29944g.iterator();
                    if (it.hasNext()) {
                        it.next();
                        it.remove();
                    }
                }
                f29944g.add(str);
                return true;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/payment/base/screenshot/ScreenShotListenManager$MediaContentObserver;", "Landroid/database/ContentObserver;", "mContentUri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "onChange", "", "selfChange", "", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ScreenShotListenManager.kt */
    private static final class MediaContentObserver extends ContentObserver {
        private final Uri mContentUri;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MediaContentObserver(Uri uri) {
            super((Handler) null);
            Intrinsics.checkNotNullParameter(uri, "mContentUri");
            this.mContentUri = uri;
        }

        public void onChange(boolean z) {
            super.onChange(z);
            if (!ScreenShotListenManager.f29946i.isEmpty()) {
                ScreenShotListenManager.INSTANCE.notifyChange(this.mContentUri);
            }
        }
    }
}
