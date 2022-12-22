package com.didiglobal.travel.infra.dimens;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00058Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004\"\u0018\u0010\u0007\u001a\u00020\u0001*\u00020\u00058Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, mo175978d2 = {"dp", "Lcom/didiglobal/travel/infra/dimens/ValueDimensions;", "", "getDp", "(F)J", "", "(I)J", "sp", "getSp", "lib-common_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: ValueDimensions.kt */
public final class ValueDimensionsKt {
    public static final long getDp(float f) {
        return ValueDimensions.Companion.mo124860of(f, 1);
    }

    public static final long getSp(float f) {
        return ValueDimensions.Companion.mo124860of(f, 2);
    }

    public static final long getDp(int i) {
        return getDp((float) i);
    }

    public static final long getSp(int i) {
        return getSp((float) i);
    }
}
