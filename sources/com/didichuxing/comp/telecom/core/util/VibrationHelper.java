package com.didichuxing.comp.telecom.core.util;

import android.content.Context;
import android.os.Vibrator;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
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

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/util/VibrationHelper;", "", "()V", "mPatterns", "", "mVibrator", "Landroid/os/Vibrator;", "tryStop", "", "vibrate", "loop", "", "Companion", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: VibrationHelper.kt */
public final class VibrationHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Lazy f46420c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, VibrationHelper$Companion$sInstance$2.INSTANCE);

    /* renamed from: a */
    private Vibrator f46421a;

    /* renamed from: b */
    private final long[] f46422b = {500, 500, 500, 500};

    @JvmStatic
    public static final VibrationHelper getInstance() {
        return Companion.getInstance();
    }

    public VibrationHelper() {
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        Context appContext = instance.getAppContext();
        if (appContext != null) {
            Object systemService = appContext.getSystemService("vibrator");
            this.f46421a = (Vibrator) (!(systemService instanceof Vibrator) ? null : systemService);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/util/VibrationHelper$Companion;", "", "()V", "sInstance", "Lcom/didichuxing/comp/telecom/core/util/VibrationHelper;", "getSInstance", "()Lcom/didichuxing/comp/telecom/core/util/VibrationHelper;", "sInstance$delegate", "Lkotlin/Lazy;", "getInstance", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
    /* compiled from: VibrationHelper.kt */
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {C21490Reflection.property1(new PropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(Companion.class), "sInstance", "getSInstance()Lcom/didichuxing/comp/telecom/core/util/VibrationHelper;"))};

        private final VibrationHelper getSInstance() {
            Lazy access$getSInstance$cp = VibrationHelper.f46420c;
            Companion companion = VibrationHelper.Companion;
            KProperty kProperty = $$delegatedProperties[0];
            return (VibrationHelper) access$getSInstance$cp.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final VibrationHelper getInstance() {
            return getSInstance();
        }
    }

    public static /* synthetic */ void vibrate$default(VibrationHelper vibrationHelper, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        vibrationHelper.vibrate(z);
    }

    public final void vibrate(boolean z) {
        Vibrator vibrator = this.f46421a;
        if (vibrator != null) {
            try {
                vibrator.vibrate(this.f46422b, z ? 0 : -1);
            } catch (Exception unused) {
            }
        }
    }

    public final void tryStop() {
        Vibrator vibrator = this.f46421a;
        if (vibrator != null) {
            try {
                vibrator.cancel();
            } catch (Exception unused) {
            }
        }
    }
}
