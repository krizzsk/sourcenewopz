package com.didi.payment.wallet.password;

import com.didi.payment.wallet.password.FullKycStatus;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.pay.paysecure.CertificationResultListener;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/payment/wallet/password/OpenCertificationManager$checkAccount$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/payment/wallet/password/FullKycStatus;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OpenCertificationManager.kt */
public final class OpenCertificationManager$checkAccount$1 implements RpcService.Callback<FullKycStatus> {
    final /* synthetic */ String $params;
    final /* synthetic */ CertificationResultListener $resultListener;

    OpenCertificationManager$checkAccount$1(CertificationResultListener certificationResultListener, String str) {
        this.$resultListener = certificationResultListener;
        this.$params = str;
    }

    public void onSuccess(FullKycStatus fullKycStatus) {
        boolean z = true;
        if ((fullKycStatus != null && fullKycStatus.errno == 0) && fullKycStatus.getData() != null) {
            FullKycStatus.Data data = fullKycStatus.getData();
            if (data != null && data.getFullKycStatus() == 1) {
                FullKycStatus.Data data2 = fullKycStatus.getData();
                if (data2 == null || data2.getStatus() != 1) {
                    z = false;
                }
                if (z) {
                    this.$resultListener.onSuccess(this.$params);
                    return;
                }
            }
            this.$resultListener.onFailure("fail", "");
        }
    }

    public void onFailure(IOException iOException) {
        this.$resultListener.onFailure("fail", "");
    }
}
