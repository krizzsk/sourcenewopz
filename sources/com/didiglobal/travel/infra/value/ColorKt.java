package com.didiglobal.travel.infra.value;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\bø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005*\f\b\u0002\u0010\u0006\"\u00020\u00072\u00020\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, mo175978d2 = {"orColor", "Lcom/didiglobal/travel/infra/value/Color;", "supplier", "Lkotlin/Function0;", "orColor-iaNQXO8", "(JLkotlin/jvm/functions/Function0;)J", "RawColor", "Landroid/graphics/Color;", "lib-common_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: Color.kt */
public final class ColorKt {
    /* renamed from: orColor-iaNQXO8  reason: not valid java name */
    public static final long m47246orColoriaNQXO8(long j, Function0<Color> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "supplier");
        Color r4 = Color.m47226boximpl(j);
        if (!(!Color.m47233equalsimpl0(r4.m47245unboximpl(), Color.Companion.getUNKNOWN()))) {
            r4 = null;
        }
        if (r4 == null) {
            r4 = function0.invoke();
        }
        return r4.m47245unboximpl();
    }
}
