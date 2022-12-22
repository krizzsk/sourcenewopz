package com.didi.payment.kycservice.key.create.p131vm;

import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.kycservice.kyc.response.PixKeyMigrateInResp;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, mo175978d2 = {"com/didi/payment/kycservice/key/create/vm/CheckCodeVM$migrateIn$1", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/kycservice/kyc/response/PixKeyMigrateInResp;", "onFailure", "", "exception", "Ljava/io/IOException;", "onStart", "onSuccess", "response", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.key.create.vm.CheckCodeVM$migrateIn$1 */
/* compiled from: CheckCodeVM.kt */
public final class CheckCodeVM$migrateIn$1 extends WNetCallback<PixKeyMigrateInResp> {
    final /* synthetic */ int $keyType;
    final /* synthetic */ String $keyVal;
    final /* synthetic */ CheckCodeVM this$0;

    CheckCodeVM$migrateIn$1(CheckCodeVM checkCodeVM, int i, String str) {
        this.this$0 = checkCodeVM;
        this.$keyType = i;
        this.$keyVal = str;
    }

    public void onStart() {
        this.this$0.isLoading().setValue(true);
        this.this$0.setPollCount(0);
    }

    public void onFailure(IOException iOException) {
        super.onFailure(iOException);
        this.this$0.isLoading().setValue(false);
    }

    public void onSuccess(PixKeyMigrateInResp pixKeyMigrateInResp) {
        Intrinsics.checkNotNullParameter(pixKeyMigrateInResp, "response");
        super.onSuccess(pixKeyMigrateInResp);
        PixKeyMigrateInResp.Data data = pixKeyMigrateInResp.getData();
        if (data != null) {
            CheckCodeVM checkCodeVM = this.this$0;
            checkCodeVM.setResultPageData(data.getResultData());
            ResultPageData resultPageData = checkCodeVM.getResultPageData();
            if (resultPageData != null) {
                resultPageData.setFaceStatus(data.getFaceStatus());
            }
            ResultPageData resultPageData2 = checkCodeVM.getResultPageData();
            if (resultPageData2 != null) {
                resultPageData2.setKycStatus(data.getKycStatus());
            }
        }
        if (pixKeyMigrateInResp.errno == 60201) {
            this.this$0.m21562a(this.$keyType, this.$keyVal);
        } else if (pixKeyMigrateInResp.errno == 0) {
            this.this$0.isLoading().setValue(false);
            this.this$0.getShowResultPageLD().setValue(true);
        } else {
            this.this$0.isLoading().setValue(false);
            this.this$0.getShowToastLD().setValue(pixKeyMigrateInResp.errmsg);
            int i = this.$keyType;
        }
    }
}
