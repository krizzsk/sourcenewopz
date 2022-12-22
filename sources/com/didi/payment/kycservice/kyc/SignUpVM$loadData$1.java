package com.didi.payment.kycservice.kyc;

import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import java.io.IOException;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/payment/kycservice/kyc/SignUpVM$loadData$1", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp;", "onComplete", "", "onFailure", "exception", "Ljava/io/IOException;", "onStart", "onSuccess", "response", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SignUpVM.kt */
public final class SignUpVM$loadData$1 extends WNetCallback<GuidesInfoResp> {
    final /* synthetic */ SignUpVM this$0;

    SignUpVM$loadData$1(SignUpVM signUpVM) {
        this.this$0 = signUpVM;
    }

    public void onStart() {
        this.this$0.isLoading().setValue(true);
        this.this$0.isNetError().setValue(false);
    }

    public void onComplete() {
        this.this$0.isLoading().setValue(false);
    }

    public void onSuccess(GuidesInfoResp guidesInfoResp) {
        LinkedList<GuidesInfoResp.Income> incomeDetailList;
        Intrinsics.checkNotNullParameter(guidesInfoResp, "response");
        super.onSuccess(guidesInfoResp);
        if (guidesInfoResp.getData() != null) {
            this.this$0.setPixSignUpInfoData(guidesInfoResp.getData());
            SignUpVM signUpVM = this.this$0;
            signUpVM.saveStatus(signUpVM.getPixSignUpInfoData());
            SignUpVM signUpVM2 = this.this$0;
            GuidesInfoResp.Data data = guidesInfoResp.getData();
            Intrinsics.checkNotNull(data);
            signUpVM2.setResultPageData(data.getResultData());
            ResultPageData resultPageData = this.this$0.getResultPageData();
            if (resultPageData != null) {
                GuidesInfoResp.Data data2 = guidesInfoResp.getData();
                Intrinsics.checkNotNull(data2);
                resultPageData.setFaceStatus(data2.getFaceStatus());
            }
            ResultPageData resultPageData2 = this.this$0.getResultPageData();
            if (resultPageData2 != null) {
                GuidesInfoResp.Data data3 = guidesInfoResp.getData();
                Intrinsics.checkNotNull(data3);
                resultPageData2.setKycStatus(data3.getKycStatus());
            }
            SignUpVM signUpVM3 = this.this$0;
            GuidesInfoResp.Data pixSignUpInfoData = signUpVM3.getPixSignUpInfoData();
            signUpVM3.setExitDetail(pixSignUpInfoData == null ? null : pixSignUpInfoData.getExitDetail());
            GuidesInfoResp.Data data4 = guidesInfoResp.getData();
            Intrinsics.checkNotNull(data4);
            PayTracker.putGlobal(TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, Integer.valueOf(data4.getKycStatus()));
            GuidesInfoResp.Data data5 = guidesInfoResp.getData();
            Intrinsics.checkNotNull(data5);
            PayTracker.putGlobal("facial_recognition_status", Integer.valueOf(data5.getFaceStatus()));
            GuidesInfoResp.Data pixSignUpInfoData2 = this.this$0.getPixSignUpInfoData();
            if (!(pixSignUpInfoData2 == null || (incomeDetailList = pixSignUpInfoData2.getIncomeDetailList()) == null)) {
                this.this$0.setIncomeDetailList(incomeDetailList);
            }
            this.this$0.m21612a();
        }
    }

    public void onFailure(IOException iOException) {
        super.onFailure(iOException);
        this.this$0.isNetError().setValue(true);
    }
}
