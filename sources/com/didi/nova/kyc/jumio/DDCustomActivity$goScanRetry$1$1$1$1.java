package com.didi.nova.kyc.jumio;

import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.scanpart.JumioScanPart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DDCustomActivity.kt */
final class DDCustomActivity$goScanRetry$1$1$1$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ JumioRetryReason $it;
    final /* synthetic */ DDCustomActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DDCustomActivity$goScanRetry$1$1$1$1(DDCustomActivity dDCustomActivity, JumioRetryReason jumioRetryReason) {
        super(0);
        this.this$0 = dDCustomActivity;
        this.$it = jumioRetryReason;
    }

    public final Object invoke() {
        JumioScanPart access$getScanPart$p = this.this$0.f29334p;
        if (access$getScanPart$p == null) {
            return null;
        }
        access$getScanPart$p.retry(this.$it);
        return Unit.INSTANCE;
    }
}
