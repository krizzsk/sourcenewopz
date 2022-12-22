package com.didi.payment.wallet.global.utils;

import android.content.Context;
import com.didi.payment.base.exts.ApplicationContextProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Landroid/content/Context;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletSecuritySPUtils.kt */
final class WalletSecuritySPUtils$context$2 extends Lambda implements Function0<Context> {
    public static final WalletSecuritySPUtils$context$2 INSTANCE = new WalletSecuritySPUtils$context$2();

    WalletSecuritySPUtils$context$2() {
        super(0);
    }

    public final Context invoke() {
        return ApplicationContextProvider.Companion.getContext();
    }
}
