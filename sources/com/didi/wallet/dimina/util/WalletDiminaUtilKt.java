package com.didi.wallet.dimina.util;

import com.didi.payment.base.utils.PayBaseConfigUtil;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"TAG", "", "logWD", "", "str", "wallet-service-dimina_globalRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletDiminaUtil.kt */
public final class WalletDiminaUtilKt {
    public static final String TAG = "WalletDimina";

    public static final void logWD(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        if (PayBaseConfigUtil.isDebugMode()) {
            SystemUtils.log(6, TAG, str, (Throwable) null, "com.didi.wallet.dimina.util.WalletDiminaUtilKt", 10);
        }
    }
}
