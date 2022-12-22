package com.didi.global.fintech.cashier.p117ui.kts;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0003*\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004\u001a\u0011\u0010\u0000\u001a\u00020\u0005*\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006\u001a\u0011\u0010\u0000\u001a\u00020\u0007*\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b\u001a\n\u0010\t\u001a\u00020\n*\u00020\n¨\u0006\u000b"}, mo175978d2 = {"orZero", "", "(Ljava/lang/Double;)D", "", "(Ljava/lang/Float;)F", "", "(Ljava/lang/Integer;)I", "", "(Ljava/lang/Long;)J", "zeroOne", "", "cashier_ui_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.kts.NumberKtxKt */
/* compiled from: NumberKtx.kt */
public final class NumberKtxKt {
    public static final Number zeroOne(Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return Intrinsics.areEqual((Object) number, (Object) 0) ? (Number) 1 : number;
    }

    public static final int orZero(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static final float orZero(Float f) {
        if (f == null) {
            return 0.0f;
        }
        return f.floatValue();
    }

    public static final long orZero(Long l) {
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    public static final double orZero(Double d) {
        if (d == null) {
            return 0.0d;
        }
        return d.doubleValue();
    }
}
