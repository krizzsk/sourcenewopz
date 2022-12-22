package com.didi.payment.wallet.password;

import android.content.Intent;
import com.didi.drouter.router.RouterCallback;
import com.didiglobal.pay.paysecure.CertificationResultListener;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/payment/wallet/password/OpenCertificationManager$fullKyc$2", "Lcom/didi/drouter/router/RouterCallback$ActivityCallback;", "onActivityResult", "", "resultCode", "", "data", "Landroid/content/Intent;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OpenCertificationManager.kt */
public final class OpenCertificationManager$fullKyc$2 extends RouterCallback.ActivityCallback {
    final /* synthetic */ String $params;
    final /* synthetic */ CertificationResultListener $resultListener;
    final /* synthetic */ OpenCertificationManager this$0;

    OpenCertificationManager$fullKyc$2(OpenCertificationManager openCertificationManager, String str, CertificationResultListener certificationResultListener) {
        this.this$0 = openCertificationManager;
        this.$params = str;
        this.$resultListener = certificationResultListener;
    }

    public void onActivityResult(int i, Intent intent) {
        this.this$0.m23180a(this.$params, this.$resultListener);
    }
}
