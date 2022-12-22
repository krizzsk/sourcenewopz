package com.didi.sdk.global.base.p151ui;

import com.didi.payment.base.proxy.LoadingProxyHolder;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo175978d2 = {"com/didi/sdk/global/base/ui/BaseActivity$onCreate$1", "Lcom/didi/payment/base/proxy/LoadingProxyHolder$ILoadingProxy;", "dismissLoading", "", "showLoading", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.sdk.global.base.ui.BaseActivity$onCreate$1 */
/* compiled from: BaseActivity.kt */
public final class BaseActivity$onCreate$1 implements LoadingProxyHolder.ILoadingProxy {
    final /* synthetic */ BaseActivity<T> this$0;

    BaseActivity$onCreate$1(BaseActivity<T> baseActivity) {
        this.this$0 = baseActivity;
    }

    public void showLoading() {
        this.this$0.showLoading();
    }

    public void dismissLoading() {
        this.this$0.hideLoading();
    }
}
