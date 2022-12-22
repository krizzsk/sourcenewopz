package com.didi.payment.kycservice.kyc.p133vm;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, mo175978d2 = {"com/didi/payment/kycservice/kyc/vm/ChooseIDTypeVM$reqDoorGodResult$1", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "onFailure", "", "exception", "Ljava/io/IOException;", "onStart", "onSuccess", "response", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.ChooseIDTypeVM$reqDoorGodResult$1 */
/* compiled from: ChooseIDTypeVM.kt */
public final class ChooseIDTypeVM$reqDoorGodResult$1 extends WNetCallback<WBaseResp> {
    final /* synthetic */ ChooseIDTypeVM this$0;

    ChooseIDTypeVM$reqDoorGodResult$1(ChooseIDTypeVM chooseIDTypeVM) {
        this.this$0 = chooseIDTypeVM;
    }

    public void onStart() {
        this.this$0.isLoading().setValue(true);
    }

    public void onFailure(IOException iOException) {
        super.onFailure(iOException);
        this.this$0.isLoading().setValue(false);
    }

    public void onSuccess(WBaseResp wBaseResp) {
        Intrinsics.checkNotNullParameter(wBaseResp, "response");
        super.onSuccess(wBaseResp);
        if (wBaseResp.errno == 0) {
            ChooseIDTypeVM chooseIDTypeVM = this.this$0;
            chooseIDTypeVM.reqFaceInitInfo(chooseIDTypeVM.getVerifyFaceType());
            return;
        }
        this.this$0.isLoading().setValue(false);
        String str = wBaseResp.errmsg;
        if (str != null) {
            try {
                WalletToastNew.showFailedMsg(this.this$0.getApplication(), str);
            } catch (Exception unused) {
            }
        }
    }
}
