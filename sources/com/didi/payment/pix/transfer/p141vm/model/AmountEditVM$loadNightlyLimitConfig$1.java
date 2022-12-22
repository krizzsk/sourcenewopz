package com.didi.payment.pix.transfer.p141vm.model;

import com.didi.payment.wallet.global.model.resp.GetNightlyLimitResp;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/payment/pix/transfer/vm/model/AmountEditVM$loadNightlyLimitConfig$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/payment/wallet/global/model/resp/GetNightlyLimitResp;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.pix.transfer.vm.model.AmountEditVM$loadNightlyLimitConfig$1 */
/* compiled from: AmountEditVM.kt */
public final class AmountEditVM$loadNightlyLimitConfig$1 implements RpcService.Callback<GetNightlyLimitResp> {
    final /* synthetic */ AmountEditVM this$0;

    AmountEditVM$loadNightlyLimitConfig$1(AmountEditVM amountEditVM) {
        this.this$0 = amountEditVM;
    }

    public void onSuccess(GetNightlyLimitResp getNightlyLimitResp) {
        GetNightlyLimitResp.NightlyLimitVo nightlyLimitVo;
        boolean z = false;
        this.this$0.isLoading().setValue(false);
        if (getNightlyLimitResp == null) {
            nightlyLimitVo = null;
        } else {
            nightlyLimitVo = getNightlyLimitResp.data;
        }
        if (getNightlyLimitResp != null && getNightlyLimitResp.errno == 0) {
            z = true;
        }
        if (z && nightlyLimitVo != null) {
            this.this$0.getNightlyLimitVo().setValue(nightlyLimitVo);
        }
    }

    public void onFailure(IOException iOException) {
        this.this$0.isLoading().setValue(false);
    }
}
