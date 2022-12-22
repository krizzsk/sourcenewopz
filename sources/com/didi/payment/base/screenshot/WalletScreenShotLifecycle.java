package com.didi.payment.base.screenshot;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/payment/base/screenshot/WalletScreenShotLifecycle;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "Companion", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletScreenShotLifecycle.kt */
public final class WalletScreenShotLifecycle implements Application.ActivityLifecycleCallbacks {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final int f29956a = 1;

    /* renamed from: b */
    private static final int f29957b = 2;

    /* renamed from: c */
    private static final int f29958c = 1000;

    /* renamed from: d */
    private static final int f29959d = 10;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static byte[] f29960e = new byte[0];
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final LinkedList<Triple<Long, Integer, String>> f29961f = new LinkedList<>();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static volatile boolean f29962g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static byte[] f29963h = new byte[0];

    public /* synthetic */ WalletScreenShotLifecycle(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "outState");
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\rJ\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R)\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/payment/base/screenshot/WalletScreenShotLifecycle$Companion;", "", "()V", "LIFE_LIST_SIZE", "", "TIME_INTERNAL", "TYPE_ON_PAUSE", "TYPE_ON_RESUME", "hasRegister", "", "lifeList", "Ljava/util/LinkedList;", "Lkotlin/Triple;", "", "", "getLifeList", "()Ljava/util/LinkedList;", "lifeListLock", "", "registerLock", "getActivityNameByTime", "time", "register", "", "context", "Landroid/content/Context;", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: WalletScreenShotLifecycle.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LinkedList<Triple<Long, Integer, String>> getLifeList() {
            return WalletScreenShotLifecycle.f29961f;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void register(android.content.Context r4) {
            /*
                r3 = this;
                if (r4 == 0) goto L_0x003d
                boolean r0 = com.didi.payment.base.screenshot.WalletScreenShotLifecycle.f29962g
                if (r0 == 0) goto L_0x0009
                goto L_0x003d
            L_0x0009:
                byte[] r0 = com.didi.payment.base.screenshot.WalletScreenShotLifecycle.f29963h
                monitor-enter(r0)
                boolean r1 = com.didi.payment.base.screenshot.WalletScreenShotLifecycle.f29962g     // Catch:{ all -> 0x003a }
                if (r1 == 0) goto L_0x0016
                monitor-exit(r0)
                return
            L_0x0016:
                android.content.Context r4 = r4.getApplicationContext()     // Catch:{ all -> 0x003a }
                boolean r1 = r4 instanceof android.app.Application     // Catch:{ all -> 0x003a }
                r2 = 0
                if (r1 == 0) goto L_0x0022
                android.app.Application r4 = (android.app.Application) r4     // Catch:{ all -> 0x003a }
                goto L_0x0023
            L_0x0022:
                r4 = r2
            L_0x0023:
                if (r4 != 0) goto L_0x0026
                goto L_0x0038
            L_0x0026:
                com.didi.payment.base.screenshot.WalletScreenShotLifecycle r1 = new com.didi.payment.base.screenshot.WalletScreenShotLifecycle     // Catch:{ all -> 0x003a }
                r1.<init>(r2)     // Catch:{ all -> 0x003a }
                android.app.Application$ActivityLifecycleCallbacks r1 = (android.app.Application.ActivityLifecycleCallbacks) r1     // Catch:{ all -> 0x003a }
                r4.registerActivityLifecycleCallbacks(r1)     // Catch:{ all -> 0x003a }
                com.didi.payment.base.screenshot.WalletScreenShotLifecycle$Companion r4 = com.didi.payment.base.screenshot.WalletScreenShotLifecycle.Companion     // Catch:{ all -> 0x003a }
                r4 = 1
                com.didi.payment.base.screenshot.WalletScreenShotLifecycle.f29962g = r4     // Catch:{ all -> 0x003a }
                kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003a }
            L_0x0038:
                monitor-exit(r0)
                return
            L_0x003a:
                r4 = move-exception
                monitor-exit(r0)
                throw r4
            L_0x003d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.base.screenshot.WalletScreenShotLifecycle.Companion.register(android.content.Context):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d6, code lost:
            return r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d8, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final kotlin.Triple<java.lang.Long, java.lang.Integer, java.lang.String> getActivityNameByTime(long r13) {
            /*
                r12 = this;
                r0 = 0
                r1 = 0
                int r3 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
                if (r3 > 0) goto L_0x0008
                return r0
            L_0x0008:
                byte[] r1 = com.didi.payment.base.screenshot.WalletScreenShotLifecycle.f29960e
                monitor-enter(r1)
                com.didi.payment.base.screenshot.WalletScreenShotLifecycle$Companion r2 = com.didi.payment.base.screenshot.WalletScreenShotLifecycle.Companion     // Catch:{ all -> 0x00d9 }
                java.util.LinkedList r2 = r2.getLifeList()     // Catch:{ all -> 0x00d9 }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x00d9 }
                if (r2 == 0) goto L_0x001b
                monitor-exit(r1)
                return r0
            L_0x001b:
                com.didi.payment.base.screenshot.WalletScreenShotLifecycle$Companion r2 = com.didi.payment.base.screenshot.WalletScreenShotLifecycle.Companion     // Catch:{ all -> 0x00d9 }
                java.util.LinkedList r2 = r2.getLifeList()     // Catch:{ all -> 0x00d9 }
                java.lang.Object r2 = r2.getFirst()     // Catch:{ all -> 0x00d9 }
                kotlin.Triple r2 = (kotlin.Triple) r2     // Catch:{ all -> 0x00d9 }
                java.lang.Object r2 = r2.getFirst()     // Catch:{ all -> 0x00d9 }
                java.lang.Number r2 = (java.lang.Number) r2     // Catch:{ all -> 0x00d9 }
                long r2 = r2.longValue()     // Catch:{ all -> 0x00d9 }
                int r4 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
                if (r4 >= 0) goto L_0x0037
                monitor-exit(r1)
                return r0
            L_0x0037:
                com.didi.payment.base.screenshot.WalletScreenShotLifecycle$Companion r2 = com.didi.payment.base.screenshot.WalletScreenShotLifecycle.Companion     // Catch:{ all -> 0x00d9 }
                java.util.LinkedList r2 = r2.getLifeList()     // Catch:{ all -> 0x00d9 }
                java.lang.Object r2 = r2.getLast()     // Catch:{ all -> 0x00d9 }
                kotlin.Triple r2 = (kotlin.Triple) r2     // Catch:{ all -> 0x00d9 }
                java.lang.Object r3 = r2.getFirst()     // Catch:{ all -> 0x00d9 }
                java.lang.Number r3 = (java.lang.Number) r3     // Catch:{ all -> 0x00d9 }
                long r3 = r3.longValue()     // Catch:{ all -> 0x00d9 }
                r5 = 1000(0x3e8, double:4.94E-321)
                r7 = 1
                r8 = 2
                int r9 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
                if (r9 <= 0) goto L_0x0082
                java.lang.Object r3 = r2.getSecond()     // Catch:{ all -> 0x00d9 }
                java.lang.Number r3 = (java.lang.Number) r3     // Catch:{ all -> 0x00d9 }
                int r3 = r3.intValue()     // Catch:{ all -> 0x00d9 }
                if (r3 != r8) goto L_0x0074
                java.lang.Object r3 = r2.getFirst()     // Catch:{ all -> 0x00d9 }
                java.lang.Number r3 = (java.lang.Number) r3     // Catch:{ all -> 0x00d9 }
                long r3 = r3.longValue()     // Catch:{ all -> 0x00d9 }
                long r13 = r13 - r3
                int r3 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
                if (r3 >= 0) goto L_0x0072
                monitor-exit(r1)
                return r2
            L_0x0072:
                monitor-exit(r1)
                return r0
            L_0x0074:
                java.lang.Object r3 = r2.getSecond()     // Catch:{ all -> 0x00d9 }
                java.lang.Number r3 = (java.lang.Number) r3     // Catch:{ all -> 0x00d9 }
                int r3 = r3.intValue()     // Catch:{ all -> 0x00d9 }
                if (r3 != r7) goto L_0x0082
                monitor-exit(r1)
                return r2
            L_0x0082:
                com.didi.payment.base.screenshot.WalletScreenShotLifecycle$Companion r2 = com.didi.payment.base.screenshot.WalletScreenShotLifecycle.Companion     // Catch:{ all -> 0x00d9 }
                java.util.LinkedList r2 = r2.getLifeList()     // Catch:{ all -> 0x00d9 }
                java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00d9 }
                r3 = r0
            L_0x008d:
                boolean r4 = r2.hasNext()     // Catch:{ all -> 0x00d9 }
                if (r4 == 0) goto L_0x00a9
                java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x00d9 }
                kotlin.Triple r4 = (kotlin.Triple) r4     // Catch:{ all -> 0x00d9 }
                java.lang.Object r9 = r4.getFirst()     // Catch:{ all -> 0x00d9 }
                java.lang.Number r9 = (java.lang.Number) r9     // Catch:{ all -> 0x00d9 }
                long r9 = r9.longValue()     // Catch:{ all -> 0x00d9 }
                int r11 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
                if (r11 >= 0) goto L_0x00aa
                r3 = r4
                goto L_0x008d
            L_0x00a9:
                r4 = r0
            L_0x00aa:
                if (r3 == 0) goto L_0x00d7
                if (r4 == 0) goto L_0x00d7
                java.lang.Object r2 = r3.getSecond()     // Catch:{ all -> 0x00d9 }
                java.lang.Number r2 = (java.lang.Number) r2     // Catch:{ all -> 0x00d9 }
                int r2 = r2.intValue()     // Catch:{ all -> 0x00d9 }
                if (r2 == r7) goto L_0x00d5
                java.lang.Object r2 = r3.getSecond()     // Catch:{ all -> 0x00d9 }
                java.lang.Number r2 = (java.lang.Number) r2     // Catch:{ all -> 0x00d9 }
                int r2 = r2.intValue()     // Catch:{ all -> 0x00d9 }
                if (r2 != r8) goto L_0x00d7
                java.lang.Object r2 = r3.getFirst()     // Catch:{ all -> 0x00d9 }
                java.lang.Number r2 = (java.lang.Number) r2     // Catch:{ all -> 0x00d9 }
                long r7 = r2.longValue()     // Catch:{ all -> 0x00d9 }
                long r13 = r13 - r7
                int r2 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
                if (r2 >= 0) goto L_0x00d7
            L_0x00d5:
                monitor-exit(r1)
                return r3
            L_0x00d7:
                monitor-exit(r1)
                return r0
            L_0x00d9:
                r13 = move-exception
                monitor-exit(r1)
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.base.screenshot.WalletScreenShotLifecycle.Companion.getActivityNameByTime(long):kotlin.Triple");
        }
    }

    private WalletScreenShotLifecycle() {
    }

    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        synchronized (f29960e) {
            if (f29961f.size() >= 10) {
                f29961f.removeFirst();
            }
            f29961f.add(new Triple(Long.valueOf(System.currentTimeMillis()), 1, activity.getClass().getSimpleName()));
        }
    }

    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        synchronized (f29960e) {
            if (f29961f.size() >= 10) {
                f29961f.removeFirst();
            }
            f29961f.add(new Triple(Long.valueOf(System.currentTimeMillis()), 2, activity.getClass().getSimpleName()));
        }
    }
}
