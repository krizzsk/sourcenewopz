package com.didi.payment.base.utils;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Landroid/os/Handler;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletExecutors.kt */
final class WalletExecutors$Companion$handler$2 extends Lambda implements Function0<Handler> {
    public static final WalletExecutors$Companion$handler$2 INSTANCE = new WalletExecutors$Companion$handler$2();

    WalletExecutors$Companion$handler$2() {
        super(0);
    }

    public final Handler invoke() {
        return new Handler(Looper.getMainLooper());
    }
}
