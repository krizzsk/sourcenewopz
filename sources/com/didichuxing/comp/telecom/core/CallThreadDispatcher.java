package com.didichuxing.comp.telecom.core;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/CallThreadDispatcher;", "", "()V", "mExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "mHandler", "Landroid/os/Handler;", "runAsync", "", "task", "Ljava/lang/Runnable;", "runOnUiThread", "action", "Companion", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: CallUtils.kt */
public final class CallThreadDispatcher {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Lazy f46394c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, CallThreadDispatcher$Companion$sInstance$2.INSTANCE);

    /* renamed from: a */
    private Handler f46395a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private ExecutorService f46396b = Executors.newSingleThreadExecutor(CallThreadDispatcher$mExecutor$1.INSTANCE);

    @JvmStatic
    public static final CallThreadDispatcher getInstance() {
        return Companion.getInstance();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/CallThreadDispatcher$Companion;", "", "()V", "sInstance", "Lcom/didichuxing/comp/telecom/core/CallThreadDispatcher;", "getSInstance", "()Lcom/didichuxing/comp/telecom/core/CallThreadDispatcher;", "sInstance$delegate", "Lkotlin/Lazy;", "getInstance", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
    /* compiled from: CallUtils.kt */
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {C21490Reflection.property1(new PropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(Companion.class), "sInstance", "getSInstance()Lcom/didichuxing/comp/telecom/core/CallThreadDispatcher;"))};

        private final CallThreadDispatcher getSInstance() {
            Lazy access$getSInstance$cp = CallThreadDispatcher.f46394c;
            Companion companion = CallThreadDispatcher.Companion;
            KProperty kProperty = $$delegatedProperties[0];
            return (CallThreadDispatcher) access$getSInstance$cp.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final CallThreadDispatcher getInstance() {
            return getSInstance();
        }
    }

    public final void runOnUiThread(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "action");
        if (!Intrinsics.areEqual((Object) Looper.getMainLooper(), (Object) Looper.myLooper())) {
            this.f46395a.post(runnable);
        } else {
            runnable.run();
        }
    }

    public final void runAsync(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "task");
        this.f46396b.submit(runnable);
    }
}
