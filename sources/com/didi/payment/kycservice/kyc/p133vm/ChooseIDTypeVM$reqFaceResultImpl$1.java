package com.didi.payment.kycservice.kyc.p133vm;

import com.didi.global.globaluikit.utils.UIThreadHandler;
import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.kycservice.kyc.response.FaceResultResp;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, mo175978d2 = {"com/didi/payment/kycservice/kyc/vm/ChooseIDTypeVM$reqFaceResultImpl$1", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/kycservice/kyc/response/FaceResultResp;", "onFailure", "", "exception", "Ljava/io/IOException;", "onStart", "onSuccess", "response", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.ChooseIDTypeVM$reqFaceResultImpl$1 */
/* compiled from: ChooseIDTypeVM.kt */
public final class ChooseIDTypeVM$reqFaceResultImpl$1 extends WNetCallback<FaceResultResp> {
    final /* synthetic */ int $faceScene;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ ChooseIDTypeVM this$0;

    ChooseIDTypeVM$reqFaceResultImpl$1(ChooseIDTypeVM chooseIDTypeVM, String str, int i) {
        this.this$0 = chooseIDTypeVM;
        this.$sessionId = str;
        this.$faceScene = i;
    }

    public void onStart() {
        this.this$0.isLoading().setValue(true);
    }

    public void onFailure(IOException iOException) {
        super.onFailure(iOException);
        KycOmega.Companion.fin_tech_wallet_http_req_lite_en(-11, "", "api/v0/identity/faceverity/check");
        this.this$0.isLoading().setValue(false);
    }

    public void onSuccess(FaceResultResp faceResultResp) {
        Intrinsics.checkNotNullParameter(faceResultResp, "response");
        super.onSuccess(faceResultResp);
        if (faceResultResp.errno != 60201) {
            this.this$0.isLoading().setValue(false);
            this.this$0.getFaceResultLD().setValue(faceResultResp);
            KycOmega.Companion companion = KycOmega.Companion;
            int i = faceResultResp.errno;
            String str = faceResultResp.errmsg;
            Intrinsics.checkNotNullExpressionValue(str, "response.errmsg");
            companion.fin_tech_wallet_http_req_lite_en(i, str, "/api/v0/identity/faceverity/check");
        } else if (this.this$0.f30860j < 10) {
            UIThreadHandler.post(new Runnable(this.$sessionId, this.$faceScene) {
                public final /* synthetic */ String f$1;
                public final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    ChooseIDTypeVM$reqFaceResultImpl$1.m46578onSuccess$lambda0(ChooseIDTypeVM.this, this.f$1, this.f$2);
                }
            }, 2000);
        } else {
            this.this$0.isLoading().setValue(false);
            FaceResultResp.Data data = faceResultResp.getData();
            ResultPageData resultPageData = null;
            if ((data == null ? null : data.getResultPageData()) != null) {
                ChooseIDTypeVM chooseIDTypeVM = this.this$0;
                FaceResultResp.Data data2 = faceResultResp.getData();
                if (data2 != null) {
                    resultPageData = data2.getResultPageData();
                }
                chooseIDTypeVM.setResultPageData(resultPageData);
                this.this$0.getShowResultPageLD().setValue(true);
                return;
            }
            this.this$0.getFaceResultLD().setValue(faceResultResp);
            KycOmega.Companion companion2 = KycOmega.Companion;
            int i2 = faceResultResp.errno;
            String str2 = faceResultResp.errmsg;
            Intrinsics.checkNotNullExpressionValue(str2, "response.errmsg");
            companion2.fin_tech_wallet_http_req_lite_en(i2, str2, "/api/v0/identity/faceverity/check");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-0  reason: not valid java name */
    public static final void m46578onSuccess$lambda0(ChooseIDTypeVM chooseIDTypeVM, String str, int i) {
        Intrinsics.checkNotNullParameter(chooseIDTypeVM, "this$0");
        Intrinsics.checkNotNullParameter(str, "$sessionId");
        chooseIDTypeVM.f30860j = chooseIDTypeVM.f30860j + 1;
        chooseIDTypeVM.m21732a(str, i);
    }
}
