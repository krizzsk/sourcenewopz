package com.didi.payment.kycservice.kyc.p133vm;

import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.kycservice.net.response.JumioGuideResp;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/payment/kycservice/kyc/vm/IDTypeVM$loadData$1$1", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/kycservice/net/response/JumioGuideResp;", "onComplete", "", "onFailure", "exception", "Ljava/io/IOException;", "onStart", "onSuccess", "response", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.IDTypeVM$loadData$1$1 */
/* compiled from: IDTypeVM.kt */
public final class IDTypeVM$loadData$1$1 extends WNetCallback<JumioGuideResp> {
    final /* synthetic */ IDTypeVM this$0;

    IDTypeVM$loadData$1$1(IDTypeVM iDTypeVM) {
        this.this$0 = iDTypeVM;
    }

    public void onStart() {
        this.this$0.isLoading().setValue(true);
        this.this$0.isNetError().setValue(false);
    }

    public void onComplete() {
        this.this$0.isLoading().setValue(false);
    }

    public void onFailure(IOException iOException) {
        super.onFailure(iOException);
        this.this$0.isNetError().setValue(true);
    }

    public void onSuccess(JumioGuideResp jumioGuideResp) {
        Intrinsics.checkNotNullParameter(jumioGuideResp, "response");
        super.onSuccess(jumioGuideResp);
        if (jumioGuideResp.errno != 0) {
            WalletToastNew.showFailedMsg(this.this$0.getApplication(), jumioGuideResp.errmsg);
            return;
        }
        if (jumioGuideResp.getData() == null) {
            WalletToastNew.showFailedMsg(this.this$0.getApplication(), "Data parsing exception！！！");
        }
        JumioGuideResp.Data data = jumioGuideResp.getData();
        if (data != null) {
            this.this$0.getJumioGuideData().setValue(data);
        }
    }
}
