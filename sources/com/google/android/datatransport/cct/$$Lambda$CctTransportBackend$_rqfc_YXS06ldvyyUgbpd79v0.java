package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.runtime.retries.RetryStrategy;

/* renamed from: com.google.android.datatransport.cct.-$$Lambda$CctTransportBackend$_rq-fc_YXS06ldvyyUgbpd79-v0  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CctTransportBackend$_rqfc_YXS06ldvyyUgbpd79v0 implements RetryStrategy {
    public static final /* synthetic */ $$Lambda$CctTransportBackend$_rqfc_YXS06ldvyyUgbpd79v0 INSTANCE = new $$Lambda$CctTransportBackend$_rqfc_YXS06ldvyyUgbpd79v0();

    private /* synthetic */ $$Lambda$CctTransportBackend$_rqfc_YXS06ldvyyUgbpd79v0() {
    }

    public final Object shouldRetry(Object obj, Object obj2) {
        return CctTransportBackend.lambda$send$0((CctTransportBackend.HttpRequest) obj, (CctTransportBackend.HttpResponse) obj2);
    }
}
