package com.didi.payment.kycservice.kyc.p133vm;

import android.text.TextUtils;
import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import com.didi.payment.kycservice.net.response.SubmitKycInfoV1Resp;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/payment/kycservice/kyc/vm/SignUp99PayVM$submitKycInfoV1$1", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/kycservice/net/response/SubmitKycInfoV1Resp;", "onComplete", "", "onFailure", "exception", "Ljava/io/IOException;", "onStart", "onSuccess", "response", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.SignUp99PayVM$submitKycInfoV1$1 */
/* compiled from: SignUp99PayVM.kt */
public final class SignUp99PayVM$submitKycInfoV1$1 extends WNetCallback<SubmitKycInfoV1Resp> {
    final /* synthetic */ SignUp99PayVM this$0;

    SignUp99PayVM$submitKycInfoV1$1(SignUp99PayVM signUp99PayVM) {
        this.this$0 = signUp99PayVM;
    }

    public void onStart() {
        this.this$0.isLoading().setValue(true);
    }

    public void onComplete() {
        this.this$0.isLoading().setValue(false);
    }

    public void onSuccess(SubmitKycInfoV1Resp submitKycInfoV1Resp) {
        ResultPageData resultEntryFormat;
        Intrinsics.checkNotNullParameter(submitKycInfoV1Resp, "response");
        super.onSuccess(submitKycInfoV1Resp);
        if (submitKycInfoV1Resp.errno == 0 && submitKycInfoV1Resp.getData() != null) {
            this.this$0.setExternalId(submitKycInfoV1Resp.getData().getExternalId());
            String bizCode = submitKycInfoV1Resp.getData().getBizCode();
            if (bizCode == null) {
                SubmitKycInfoV1Resp.DataBean data = submitKycInfoV1Resp.getData();
                if (data != null && (resultEntryFormat = data.getResultEntryFormat()) != null) {
                    this.this$0.finishCreate(resultEntryFormat);
                    return;
                }
                return;
            }
            this.this$0.getBizCode().setValue(bizCode);
        } else if (submitKycInfoV1Resp.errno == 1010) {
            this.this$0.getBShowHomelandCityErrorPage().setValue(true);
        } else if (submitKycInfoV1Resp.errno != 0 && !TextUtils.isEmpty(submitKycInfoV1Resp.errmsg)) {
            WalletToastNew.showFailedMsg(this.this$0.getApplication(), submitKycInfoV1Resp.errmsg);
            this.this$0.getErrorMsg().setValue(submitKycInfoV1Resp.errmsg);
        }
    }

    public void onFailure(IOException iOException) {
        super.onFailure(iOException);
        this.this$0.getBFinishCreateAccount().setValue(false);
    }
}
