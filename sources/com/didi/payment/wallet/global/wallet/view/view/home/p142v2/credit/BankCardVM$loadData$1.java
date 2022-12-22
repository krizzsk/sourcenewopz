package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.credit;

import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/payment/wallet/global/wallet/view/view/home/v2/credit/BankCardVM$loadData$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/BankCardResp;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.credit.BankCardVM$loadData$1 */
/* compiled from: BankCardVM.kt */
public final class BankCardVM$loadData$1 implements RpcService.Callback<BankCardResp> {
    final /* synthetic */ BankCardVM this$0;

    BankCardVM$loadData$1(BankCardVM bankCardVM) {
        this.this$0 = bankCardVM;
    }

    public void onSuccess(BankCardResp bankCardResp) {
        this.this$0.isLoading().setValue(false);
        this.this$0.getRespData().setValue(bankCardResp);
    }

    public void onFailure(IOException iOException) {
        this.this$0.isLoading().setValue(false);
    }
}
