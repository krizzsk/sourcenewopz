package com.didi.sdk.global.sign.payselect;

import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.sign.payselect.utils.PayDataConverter;
import com.didi.sdk.global.sign.presenter.PayMethodSelectAdapter;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/sdk/global/sign/payselect/PayMethodSelVM$init$1", "Lcom/didi/sdk/global/sign/presenter/PayMethodSelectAdapter$AdapterDataObserver;", "onFailed", "", "onFinished", "onSuccess", "param", "Lcom/didi/sdk/global/DidiGlobalPayMethodListData$PayMethodListParam;", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayMethodSelVM.kt */
public final class PayMethodSelVM$init$1 implements PayMethodSelectAdapter.AdapterDataObserver {
    final /* synthetic */ PayMethodSelVM this$0;

    PayMethodSelVM$init$1(PayMethodSelVM payMethodSelVM) {
        this.this$0 = payMethodSelVM;
    }

    public void onSuccess(DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam) {
        this.this$0.isLoadingLD().setValue(false);
        this.this$0.onRequestSuccess(PayDataConverter.convert(payMethodListParam));
    }

    public void onFailed() {
        this.this$0.isLoadingLD().setValue(false);
        this.this$0.isNetErrorLD().setValue(true);
    }

    public void onFinished() {
        this.this$0.isLoadingLD().setValue(false);
    }
}
