package com.didi.soda.order.manager;

import android.content.Context;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/order/manager/AppRateCompact;", "", "()V", "goToRate", "", "context", "Landroid/content/Context;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AppRateCompact.kt */
public final class AppRateCompact {
    public static final AppRateCompact INSTANCE = new AppRateCompact();

    private AppRateCompact() {
    }

    public final void goToRate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        CustomerSystemUtil.gotoRate(context);
    }
}
