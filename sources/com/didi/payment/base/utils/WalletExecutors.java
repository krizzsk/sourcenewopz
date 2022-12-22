package com.didi.payment.base.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/base/utils/WalletExecutors;", "", "()V", "Companion", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletExecutors.kt */
public final class WalletExecutors {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Lazy<Handler> f30026a = LazyKt.lazy(WalletExecutors$Companion$handler$2.INSTANCE);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Lazy<ScheduledExecutorService> f30027b = LazyKt.lazy(WalletExecutors$Companion$singleScheduleExecutor$2.INSTANCE);

    @Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\"\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/payment/base/utils/WalletExecutors$Companion;", "", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "singleScheduleExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "getSingleScheduleExecutor", "()Ljava/util/concurrent/ScheduledExecutorService;", "singleScheduleExecutor$delegate", "postToMain", "", "delayMillis", "", "runnable", "Ljava/lang/Runnable;", "runOnMain", "scheduleOnce", "delay", "unit", "Ljava/util/concurrent/TimeUnit;", "command", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: WalletExecutors.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final Handler getHandler() {
            return (Handler) WalletExecutors.f30026a.getValue();
        }

        private final ScheduledExecutorService getSingleScheduleExecutor() {
            return (ScheduledExecutorService) WalletExecutors.f30027b.getValue();
        }

        public final void runOnMain(Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            if (Intrinsics.areEqual((Object) Thread.currentThread(), (Object) Looper.getMainLooper().getThread())) {
                runnable.run();
            } else {
                getHandler().post(runnable);
            }
        }

        public static /* synthetic */ void postToMain$default(Companion companion, long j, Runnable runnable, int i, Object obj) {
            if ((i & 1) != 0) {
                j = 0;
            }
            companion.postToMain(j, runnable);
        }

        public final void postToMain(long j, Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            getHandler().postDelayed(runnable, j);
        }

        public static /* synthetic */ void scheduleOnce$default(Companion companion, long j, TimeUnit timeUnit, Runnable runnable, int i, Object obj) {
            if ((i & 2) != 0) {
                timeUnit = TimeUnit.MILLISECONDS;
            }
            companion.scheduleOnce(j, timeUnit, runnable);
        }

        public final void scheduleOnce(long j, TimeUnit timeUnit, Runnable runnable) {
            Intrinsics.checkNotNullParameter(timeUnit, "unit");
            if (runnable != null) {
                getSingleScheduleExecutor().schedule(runnable, j, timeUnit);
            }
        }
    }
}
