package com.didi.entrega.customer.foundation.tracker.error;

import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/tracker/error/OmegaErrorHandler;", "Lcom/didi/entrega/customer/foundation/tracker/error/ErrorTrackerHandler;", "()V", "trackError", "", "moduleName", "", "errorName", "errorType", "errorMsg", "map", "", "", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OmegaErrorHandler.kt */
public final class OmegaErrorHandler implements ErrorTrackerHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final String f20045a = "OmegaErrorHandler";

    public void trackError(String str, String str2, String str3, String str4, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str2, "errorName");
        OmegaSDK.trackError(str, str2, str3, str4, map);
        OmegaTracker.Builder create = OmegaTracker.Builder.create(str2);
        CharSequence charSequence = str3;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            create.addEventParam("error_type", str3);
        }
        CharSequence charSequence2 = str4;
        if (charSequence2 == null || charSequence2.length() == 0) {
            z = true;
        }
        if (!z) {
            create.addEventParam("error_msg", str4);
        }
        create.build().track();
        LogUtil.m14767w(f20045a, str2);
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/tracker/error/OmegaErrorHandler$Companion;", "", "()V", "TAG", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OmegaErrorHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
