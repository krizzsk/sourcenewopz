package com.didi.sdk.global.sign.payselect;

import com.didi.sdk.global.sign.model.server.PayMethodPageResponse;
import com.didi.sdk.global.sign.payselect.PayMethodSelVM;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/sdk/global/sign/payselect/PayMethodSelVM$DefaultPaySelectAdapter$refreshPayMethodList$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/sdk/global/sign/model/server/PayMethodPageResponse;", "onFailure", "", "e", "Ljava/io/IOException;", "onSuccess", "response", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayMethodSelVM.kt */
public final class PayMethodSelVM$DefaultPaySelectAdapter$refreshPayMethodList$1 implements RpcService.Callback<PayMethodPageResponse> {
    final /* synthetic */ PayMethodSelVM this$0;
    final /* synthetic */ PayMethodSelVM.DefaultPaySelectAdapter this$1;

    PayMethodSelVM$DefaultPaySelectAdapter$refreshPayMethodList$1(PayMethodSelVM payMethodSelVM, PayMethodSelVM.DefaultPaySelectAdapter defaultPaySelectAdapter) {
        this.this$0 = payMethodSelVM;
        this.this$1 = defaultPaySelectAdapter;
    }

    public void onSuccess(PayMethodPageResponse payMethodPageResponse) {
        this.this$0.onRequestSuccess(payMethodPageResponse);
        this.this$1.notifyRefreshFinished();
    }

    public void onFailure(IOException iOException) {
        Intrinsics.checkNotNullParameter(iOException, "e");
        this.this$1.notifyRefreshFailed();
    }
}
