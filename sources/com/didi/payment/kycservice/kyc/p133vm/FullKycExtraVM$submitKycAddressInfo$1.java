package com.didi.payment.kycservice.kyc.p133vm;

import android.text.TextUtils;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/payment/kycservice/kyc/vm/FullKycExtraVM$submitKycAddressInfo$1", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "onComplete", "", "onFailure", "exception", "Ljava/io/IOException;", "onStart", "onSuccess", "value", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.FullKycExtraVM$submitKycAddressInfo$1 */
/* compiled from: FullKycExtraVM.kt */
public final class FullKycExtraVM$submitKycAddressInfo$1 extends WNetCallback<WBaseResp> {
    final /* synthetic */ FullKycExtraVM this$0;

    FullKycExtraVM$submitKycAddressInfo$1(FullKycExtraVM fullKycExtraVM) {
        this.this$0 = fullKycExtraVM;
    }

    public void onStart() {
        this.this$0.isLoading().setValue(true);
    }

    public void onComplete() {
        this.this$0.isLoading().setValue(false);
    }

    public void onSuccess(WBaseResp wBaseResp) {
        Intrinsics.checkNotNullParameter(wBaseResp, "value");
        super.onSuccess(wBaseResp);
        if (wBaseResp.errno == 0) {
            EventBus.getDefault().post(new WalletRefreshDataEvent());
            this.this$0.getBFinishCreateAccount().setValue(true);
        } else if (wBaseResp.errno != 0 && !TextUtils.isEmpty(wBaseResp.errmsg)) {
            WalletToastNew.showFailedMsg(this.this$0.getApplication(), wBaseResp.errmsg);
            this.this$0.getErrorMsg().setValue(wBaseResp.errmsg);
        }
    }

    public void onFailure(IOException iOException) {
        super.onFailure(iOException);
        this.this$0.getBFinishCreateAccount().setValue(false);
    }
}
