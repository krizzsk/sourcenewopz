package com.didi.soda.customer.apk;

import com.didi.sdk.util.AnalysisAPK;
import com.didi.soda.customer.app.GlobalContext;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/customer/apk/CustomerAnalysisApk;", "", "()V", "isHmsApk", "", "()Z", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerAnalysisApk.kt */
public final class CustomerAnalysisApk {
    public static final CustomerAnalysisApk INSTANCE = new CustomerAnalysisApk();

    private CustomerAnalysisApk() {
    }

    public final boolean isHmsApk() {
        return AnalysisAPK.isGlobalHmsApk(GlobalContext.getContext());
    }
}
