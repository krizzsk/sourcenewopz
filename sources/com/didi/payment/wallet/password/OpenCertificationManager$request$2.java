package com.didi.payment.wallet.password;

import com.didi.payment.base.exts.ApplicationContextProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/payment/wallet/password/CertificationRequest;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OpenCertificationManager.kt */
final class OpenCertificationManager$request$2 extends Lambda implements Function0<CertificationRequest> {
    public static final OpenCertificationManager$request$2 INSTANCE = new OpenCertificationManager$request$2();

    OpenCertificationManager$request$2() {
        super(0);
    }

    public final CertificationRequest invoke() {
        return new CertificationRequest(ApplicationContextProvider.Companion.getContext());
    }
}
