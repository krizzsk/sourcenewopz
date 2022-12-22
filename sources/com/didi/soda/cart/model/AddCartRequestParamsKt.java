package com.didi.soda.cart.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\n\u0010\u0006\u001a\u00020\u0004*\u00020\u0001¨\u0006\u0007"}, mo175978d2 = {"getBaseRevision", "", "Lcom/didi/soda/cart/model/SetItemAmountParams;", "plus", "", "Lcom/didi/soda/cart/model/SetItemParams;", "reversionToLong", "customer-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AddCartRequestParams.kt */
public final class AddCartRequestParamsKt {
    public static final long reversionToLong(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static final String getBaseRevision(SetItemParams setItemParams, long j) {
        long j2;
        Intrinsics.checkNotNullParameter(setItemParams, "<this>");
        try {
            j2 = Long.parseLong(setItemParams.getRevision());
        } catch (Exception unused) {
            j2 = 0;
        }
        return String.valueOf(j2 + j);
    }

    public static final String getBaseRevision(SetItemAmountParams setItemAmountParams, long j) {
        long j2;
        Intrinsics.checkNotNullParameter(setItemAmountParams, "<this>");
        try {
            j2 = Long.parseLong(setItemAmountParams.getRevision());
        } catch (Exception unused) {
            j2 = 0;
        }
        return String.valueOf(j2 + j);
    }
}
