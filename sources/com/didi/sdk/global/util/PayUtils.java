package com.didi.sdk.global.util;

import android.content.Context;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/sdk/global/util/PayUtils;", "", "()V", "isBrazilClient", "", "context", "Landroid/content/Context;", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayUtils.kt */
public final class PayUtils {
    public static final PayUtils INSTANCE = new PayUtils();

    private PayUtils() {
    }

    public final boolean isBrazilClient(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String terminalId = WalletCommonParamsUtil.getTerminalId(context);
        if (terminalId != null) {
            return Intrinsics.areEqual((Object) "5", (Object) terminalId.toString());
        }
        return false;
    }
}
