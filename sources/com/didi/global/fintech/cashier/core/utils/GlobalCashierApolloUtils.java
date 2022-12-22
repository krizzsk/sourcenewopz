package com.didi.global.fintech.cashier.core.utils;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/utils/GlobalCashierApolloUtils;", "", "()V", "getStatus", "", "key", "", "defaultStatus", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierApolloUtils.kt */
public final class GlobalCashierApolloUtils {
    public static final GlobalCashierApolloUtils INSTANCE = new GlobalCashierApolloUtils();

    private GlobalCashierApolloUtils() {
    }

    public final boolean getStatus(String str, boolean z) {
        try {
            IToggle toggle = Apollo.getToggle(str, z);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }
}
