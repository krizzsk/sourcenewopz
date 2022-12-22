package com.didichuxing.comp.telecom.core.util;

import android.content.Context;
import android.telephony.TelephonyManager;
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

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/util/PhoneCallHelper;", "", "()V", "TAG", "", "mTelephonyManager", "Landroid/telephony/TelephonyManager;", "isPhoneCalling", "", "Companion", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: PhoneCallHelper.kt */
public final class PhoneCallHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Lazy f46411c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, PhoneCallHelper$Companion$sInstance$2.INSTANCE);

    /* renamed from: a */
    private final String f46412a = "PhoneCallHelper";

    /* renamed from: b */
    private TelephonyManager f46413b;

    @JvmStatic
    public static final PhoneCallHelper getInstance() {
        return Companion.getInstance();
    }

    public PhoneCallHelper() {
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        Context appContext = instance.getAppContext();
        Object obj = null;
        Object systemService = appContext != null ? appContext.getSystemService("phone") : null;
        this.f46413b = (TelephonyManager) (systemService instanceof TelephonyManager ? systemService : obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isPhoneCalling() {
        /*
            r5 = this;
            android.telephony.TelephonyManager r0 = r5.f46413b
            r1 = 0
            if (r0 == 0) goto L_0x0030
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 31
            r4 = 1
            if (r2 < r3) goto L_0x0026
            com.didichuxing.comp.telecom.core.CallManagerAssist r2 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
            java.lang.String r3 = "CallManagerAssist.getInstance()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            android.content.Context r2 = r2.getAppContext()
            if (r2 == 0) goto L_0x0024
            java.lang.String r3 = "android.permission.READ_PHONE_STATE"
            int r2 = r2.checkSelfPermission(r3)
            if (r2 != 0) goto L_0x0024
            goto L_0x0026
        L_0x0024:
            r2 = 0
            goto L_0x0027
        L_0x0026:
            r2 = 1
        L_0x0027:
            if (r2 == 0) goto L_0x0030
            int r0 = r0.getCallState()
            if (r0 == 0) goto L_0x0030
            r1 = 1
        L_0x0030:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.core.util.PhoneCallHelper.isPhoneCalling():boolean");
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/util/PhoneCallHelper$Companion;", "", "()V", "sInstance", "Lcom/didichuxing/comp/telecom/core/util/PhoneCallHelper;", "getSInstance", "()Lcom/didichuxing/comp/telecom/core/util/PhoneCallHelper;", "sInstance$delegate", "Lkotlin/Lazy;", "getInstance", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
    /* compiled from: PhoneCallHelper.kt */
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {C21490Reflection.property1(new PropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(Companion.class), "sInstance", "getSInstance()Lcom/didichuxing/comp/telecom/core/util/PhoneCallHelper;"))};

        private final PhoneCallHelper getSInstance() {
            Lazy access$getSInstance$cp = PhoneCallHelper.f46411c;
            Companion companion = PhoneCallHelper.Companion;
            KProperty kProperty = $$delegatedProperties[0];
            return (PhoneCallHelper) access$getSInstance$cp.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final PhoneCallHelper getInstance() {
            return getSInstance();
        }
    }
}
