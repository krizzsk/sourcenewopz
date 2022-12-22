package com.didi.payment.wallet.global.wallet.view.view.home.p142v2;

import com.didi.payment.commonsdk.net.PixQrCodeQueryResp;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeV2Presenter$autoVerifyQRCode$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/payment/commonsdk/net/PixQrCodeQueryResp;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter$autoVerifyQRCode$1 */
/* compiled from: WalletHomeV2Presenter.kt */
public final class WalletHomeV2Presenter$autoVerifyQRCode$1 implements RpcService.Callback<PixQrCodeQueryResp> {
    final /* synthetic */ WalletHomeV2Presenter this$0;

    public void onFailure(IOException iOException) {
        Intrinsics.checkNotNullParameter(iOException, "exception");
    }

    WalletHomeV2Presenter$autoVerifyQRCode$1(WalletHomeV2Presenter walletHomeV2Presenter) {
        this.this$0 = walletHomeV2Presenter;
    }

    public void onSuccess(PixQrCodeQueryResp pixQrCodeQueryResp) {
        WalletHomeContract.V2View access$getMView$p;
        if (pixQrCodeQueryResp != null && pixQrCodeQueryResp.errno == 0 && (access$getMView$p = this.this$0.f32659c) != null) {
            access$getMView$p.onQRCodeDetected(pixQrCodeQueryResp.getData());
        }
    }
}
