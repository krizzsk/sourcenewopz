package com.didiglobal.travel.infra.app;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b\u001a,\u0010\u0004\u001a\u0004\u0018\u0001H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\b¢\u0006\u0002\u0010\b¨\u0006\t"}, mo175978d2 = {"checkOsVersion", "", "versionCode", "", "meetVersion", "T", "block", "Lkotlin/Function0;", "(ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "lib-common_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: Instrument.kt */
public final class InstrumentKt {
    public static final boolean checkOsVersion(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    public static final <T> T meetVersion(int i, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "block");
        if (Build.VERSION.SDK_INT >= i) {
            return function0.invoke();
        }
        return null;
    }
}
