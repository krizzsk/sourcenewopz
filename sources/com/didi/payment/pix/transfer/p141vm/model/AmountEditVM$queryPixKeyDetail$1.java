package com.didi.payment.pix.transfer.p141vm.model;

import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.utils.NWHttpUtil;
import com.didi.payment.pix.net.response.PixKeyVerifyResp;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/payment/pix/transfer/vm/model/AmountEditVM$queryPixKeyDetail$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/payment/pix/net/response/PixKeyVerifyResp;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.pix.transfer.vm.model.AmountEditVM$queryPixKeyDetail$1 */
/* compiled from: AmountEditVM.kt */
public final class AmountEditVM$queryPixKeyDetail$1 implements RpcService.Callback<PixKeyVerifyResp> {
    final /* synthetic */ AmountEditVM this$0;

    AmountEditVM$queryPixKeyDetail$1(AmountEditVM amountEditVM) {
        this.this$0 = amountEditVM;
    }

    public void onSuccess(PixKeyVerifyResp pixKeyVerifyResp) {
        List<PixKeyVerifyResp.PixAccount> keyList;
        Intrinsics.checkNotNullParameter(pixKeyVerifyResp, "value");
        this.this$0.isLoading().setValue(false);
        if (NWHttpUtil.Companion.isRespValid(pixKeyVerifyResp)) {
            MutableLiveData<PixKeyVerifyResp.PixAccount> pixAccountQueryByQr = this.this$0.getPixAccountQueryByQr();
            PixKeyVerifyResp.PixKeyList pixKeyList = (PixKeyVerifyResp.PixKeyList) pixKeyVerifyResp.data;
            PixKeyVerifyResp.PixAccount pixAccount = null;
            if (!(pixKeyList == null || (keyList = pixKeyList.getKeyList()) == null)) {
                pixAccount = keyList.get(0);
            }
            pixAccountQueryByQr.setValue(pixAccount);
        } else if (pixKeyVerifyResp.errno == 0) {
            this.this$0.getPixAccountQueryByQr().setValue(new PixKeyVerifyResp.PixAccount());
        } else {
            this.this$0.isNetError().setValue(true);
        }
    }

    public void onFailure(IOException iOException) {
        this.this$0.isLoading().setValue(false);
    }
}
