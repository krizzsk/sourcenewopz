package com.didiglobal.travel.biz.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo175978d2 = {"omega", "", "block", "Lkotlin/Function1;", "Lcom/didiglobal/travel/biz/util/OmegaTraceWrapper;", "Lkotlin/ExtensionFunctionType;", "common_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TraceUtils.kt */
public final class TraceUtilsKt {
    public static final void omega(Function1<? super OmegaTraceWrapper, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        OmegaTraceWrapper omegaTraceWrapper = new OmegaTraceWrapper();
        function1.invoke(omegaTraceWrapper);
        omegaTraceWrapper.toComponents$common_release(TraceUtilsKt$omega$1.INSTANCE);
    }
}
