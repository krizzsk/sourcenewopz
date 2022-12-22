package com.didi.payment.kycservice.key.create.p131vm;

import androidx.lifecycle.MutableLiveData;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.kycservice.key.create.response.PollStatusResp;
import com.didi.payment.kycservice.kyc.response.MigrateTipData;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import com.didi.payment.kycservice.utils.IPollResultCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/payment/kycservice/key/create/vm/CheckCodeVM$doPoll$1", "Lcom/didi/payment/kycservice/utils/IPollResultCallback;", "onFail", "", "response", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "onSuccess", "Lcom/didi/payment/kycservice/key/create/response/PollStatusResp;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.key.create.vm.CheckCodeVM$doPoll$1 */
/* compiled from: CheckCodeVM.kt */
public final class CheckCodeVM$doPoll$1 implements IPollResultCallback {
    final /* synthetic */ CheckCodeVM this$0;

    CheckCodeVM$doPoll$1(CheckCodeVM checkCodeVM) {
        this.this$0 = checkCodeVM;
    }

    public void onSuccess(PollStatusResp pollStatusResp) {
        Intrinsics.checkNotNullParameter(pollStatusResp, "response");
        if (60200 == pollStatusResp.errno) {
            this.this$0.isLoading().setValue(false);
            MutableLiveData<MigrateTipData> showMigrateTipLD = this.this$0.getShowMigrateTipLD();
            PollStatusResp.Data data = pollStatusResp.getData();
            Intrinsics.checkNotNull(data);
            showMigrateTipLD.setValue(data.getMigrateTipData());
            return;
        }
        ResultPageData resultPageData = this.this$0.getResultPageData();
        if (resultPageData != null) {
            resultPageData.setKeyStatus(true);
        }
        this.this$0.getShowResultPageLD().setValue(true);
    }

    public void onFail(WBaseResp wBaseResp) {
        Intrinsics.checkNotNullParameter(wBaseResp, "response");
        this.this$0.getShowToastLD().setValue(wBaseResp.errmsg);
    }
}
