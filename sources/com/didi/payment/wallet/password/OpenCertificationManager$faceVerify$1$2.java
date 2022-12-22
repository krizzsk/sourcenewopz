package com.didi.payment.wallet.password;

import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didiglobal.pay.paysecure.CertificationResultListener;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OpenCertificationManager.kt */
final class OpenCertificationManager$faceVerify$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ HashMap<String, Object> $map;
    final /* synthetic */ String $params;
    final /* synthetic */ CertificationResultListener $resultListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OpenCertificationManager$faceVerify$1$2(HashMap<String, Object> hashMap, CertificationResultListener certificationResultListener, String str) {
        super(0);
        this.$map = hashMap;
        this.$resultListener = certificationResultListener;
        this.$params = str;
    }

    public final void invoke() {
        FinOmegaSDK.trackEvent("ibt_password_frame_face_customer_service_ck", this.$map);
        this.$resultListener.onFailure("fail", this.$params);
    }
}
