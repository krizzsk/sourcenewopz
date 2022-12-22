package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.popmgr;

import android.content.Context;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp;
import com.didi.payment.wallet.global.utils.WalletSPUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/payment/wallet/global/wallet/view/view/home/v2/popmgr/PopUpApiTask$reqData$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/payment/wallet/global/model/resp/WalletPopUpWindowResp;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.PopUpApiTask$reqData$1 */
/* compiled from: PopUpApiTask.kt */
public final class PopUpApiTask$reqData$1 implements RpcService.Callback<WalletPopUpWindowResp> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<Unit> $onFinish;
    final /* synthetic */ PopUpApiTask this$0;

    PopUpApiTask$reqData$1(PopUpApiTask popUpApiTask, Function0<Unit> function0, Context context) {
        this.this$0 = popUpApiTask;
        this.$onFinish = function0;
        this.$context = context;
    }

    public void onSuccess(WalletPopUpWindowResp walletPopUpWindowResp) {
        this.this$0.f32768b = walletPopUpWindowResp;
        this.this$0.setStatus(2);
        SystemUtils.log(6, "DDF-PopUpApiTask", "reqData end", (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.PopUpApiTask$reqData$1", 106);
        this.$onFinish.invoke();
    }

    public void onFailure(IOException iOException) {
        Intrinsics.checkNotNullParameter(iOException, "exception");
        Context context = this.$context;
        WalletSPUtils.saveCanRequestPwd(context, WalletCommonParamsUtil.getToken(context), true);
        this.this$0.setStatus(2);
        SystemUtils.log(6, "DDF-PopUpApiTask", "reqData end", (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.PopUpApiTask$reqData$1", 117);
        this.$onFinish.invoke();
    }
}
