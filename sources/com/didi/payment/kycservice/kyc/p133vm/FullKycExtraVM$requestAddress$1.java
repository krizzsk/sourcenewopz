package com.didi.payment.kycservice.kyc.p133vm;

import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.kycservice.net.response.AddressZipCodeResp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/payment/kycservice/kyc/vm/FullKycExtraVM$requestAddress$1", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/kycservice/net/response/AddressZipCodeResp;", "onComplete", "", "onStart", "onSuccess", "response", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.FullKycExtraVM$requestAddress$1 */
/* compiled from: FullKycExtraVM.kt */
public final class FullKycExtraVM$requestAddress$1 extends WNetCallback<AddressZipCodeResp> {
    final /* synthetic */ FullKycExtraVM this$0;

    FullKycExtraVM$requestAddress$1(FullKycExtraVM fullKycExtraVM) {
        this.this$0 = fullKycExtraVM;
    }

    public void onStart() {
        this.this$0.isLoading().setValue(true);
    }

    public void onComplete() {
        this.this$0.isLoading().setValue(false);
    }

    public void onSuccess(AddressZipCodeResp addressZipCodeResp) {
        Intrinsics.checkNotNullParameter(addressZipCodeResp, "response");
        super.onSuccess(addressZipCodeResp);
        if (addressZipCodeResp.errno == 0) {
            this.this$0.getAddressInfo().setValue(addressZipCodeResp.data);
        } else if (addressZipCodeResp.errmsg != null) {
            WalletToastNew.showFailedMsg(this.this$0.getApplication(), addressZipCodeResp.errmsg);
        }
    }
}
