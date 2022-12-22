package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0001¨\u0006\u0004"}, mo175978d2 = {"toDefaultInt", "", "", "default", "wallet_globalRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.WalletHomeModelKt */
/* compiled from: WalletHomeModel.kt */
public final class WalletHomeModelKt {
    public static /* synthetic */ int toDefaultInt$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return toDefaultInt(str, i);
    }

    public static final int toDefaultInt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Integer intOrNull = StringsKt.toIntOrNull(str);
        return intOrNull == null ? i : intOrNull.intValue();
    }
}
