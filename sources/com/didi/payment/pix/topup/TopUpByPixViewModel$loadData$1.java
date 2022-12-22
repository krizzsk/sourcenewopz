package com.didi.payment.pix.topup;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.pix.net.response.PixTopUpOption;
import com.didi.payment.pix.net.response.PixTopUpOptionResp;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/payment/pix/topup/TopUpByPixViewModel$loadData$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/payment/pix/net/response/PixTopUpOptionResp;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopUpByPixViewModel.kt */
public final class TopUpByPixViewModel$loadData$1 implements RpcService.Callback<PixTopUpOptionResp> {
    final /* synthetic */ TopUpByPixViewModel this$0;

    TopUpByPixViewModel$loadData$1(TopUpByPixViewModel topUpByPixViewModel) {
        this.this$0 = topUpByPixViewModel;
    }

    public void onSuccess(PixTopUpOptionResp pixTopUpOptionResp) {
        PixTopUpOption pixTopUpOption;
        boolean z = false;
        this.this$0.isLoading().setValue(false);
        if (pixTopUpOptionResp == null) {
            pixTopUpOption = null;
        } else {
            pixTopUpOption = pixTopUpOptionResp.getData();
        }
        if (pixTopUpOptionResp != null && pixTopUpOptionResp.errno == 0) {
            z = true;
        }
        if (!z || pixTopUpOption == null) {
            this.this$0.getErrObj().setValue(pixTopUpOptionResp);
        } else {
            this.this$0.getPixTopUpOption().setValue(pixTopUpOption);
        }
    }

    public void onFailure(IOException iOException) {
        this.this$0.isLoading().setValue(false);
        this.this$0.getErrObj().setValue(new WBaseResp().onRequestFail());
    }
}
