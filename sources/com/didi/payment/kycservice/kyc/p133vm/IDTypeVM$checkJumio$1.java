package com.didi.payment.kycservice.kyc.p133vm;

import com.didi.global.globaluikit.utils.UIThreadHandler;
import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.kycservice.kyc.p133vm.IDTypeVM;
import com.didi.payment.kycservice.kyc.response.JumioCheckResp;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/payment/kycservice/kyc/vm/IDTypeVM$checkJumio$1", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/kycservice/kyc/response/JumioCheckResp;", "onComplete", "", "onFailure", "exception", "Ljava/io/IOException;", "onStart", "onSuccess", "response", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.IDTypeVM$checkJumio$1 */
/* compiled from: IDTypeVM.kt */
public final class IDTypeVM$checkJumio$1 extends WNetCallback<JumioCheckResp> {
    final /* synthetic */ IDTypeVM.CheckListener $listener;
    final /* synthetic */ IDTypeVM this$0;

    IDTypeVM$checkJumio$1(IDTypeVM iDTypeVM, IDTypeVM.CheckListener checkListener) {
        this.this$0 = iDTypeVM;
        this.$listener = checkListener;
    }

    public void onStart() {
        this.this$0.isLoading().setValue(true);
        this.this$0.isNetError().setValue(false);
    }

    public void onComplete() {
        this.this$0.isLoading().setValue(false);
    }

    public void onSuccess(JumioCheckResp jumioCheckResp) {
        Intrinsics.checkNotNullParameter(jumioCheckResp, "response");
        super.onSuccess(jumioCheckResp);
        int i = jumioCheckResp.errno;
        if (i == 0) {
            KycOmega.Companion.fin_jumiofacecheck_result_sw(1);
            KycOmega.Companion companion = KycOmega.Companion;
            int i2 = jumioCheckResp.errno;
            String str = jumioCheckResp.errmsg;
            Intrinsics.checkNotNullExpressionValue(str, "response.errmsg");
            companion.fin_tech_wallet_http_req_lite_en(i2, str, "/api/v0/identity/jumio/check");
            IDTypeVM.CheckListener checkListener = this.$listener;
            if (checkListener != null) {
                JumioCheckResp.Data data = jumioCheckResp.getData();
                checkListener.onSuccess(data == null ? null : data.getResultEntryFormat());
            }
        } else if (i != 60201) {
            KycOmega.Companion.fin_jumiofacecheck_result_sw(2);
            WalletToastNew.showFailedMsg(this.this$0.getApplication(), jumioCheckResp.errmsg);
            KycOmega.Companion companion2 = KycOmega.Companion;
            int i3 = jumioCheckResp.errno;
            String str2 = jumioCheckResp.errmsg;
            Intrinsics.checkNotNullExpressionValue(str2, "response.errmsg");
            companion2.fin_tech_wallet_http_req_lite_en(i3, str2, "/api/v0/identity/jumio/check");
        } else {
            UIThreadHandler.post(new Runnable() {
                public final void run() {
                    IDTypeVM$checkJumio$1.m46580onSuccess$lambda1(IDTypeVM.this);
                }
            }, 2000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-1  reason: not valid java name */
    public static final void m46580onSuccess$lambda1(IDTypeVM iDTypeVM) {
        Intrinsics.checkNotNullParameter(iDTypeVM, "this$0");
        iDTypeVM.setCount(iDTypeVM.getCount() + 1);
        iDTypeVM.checkJumio((IDTypeVM.CheckListener) null);
    }

    public void onFailure(IOException iOException) {
        super.onFailure(iOException);
        KycOmega.Companion.fin_jumiofacecheck_result_sw(2);
        this.this$0.isNetError().setValue(true);
        KycOmega.Companion.fin_tech_wallet_http_req_lite_en(-11, "", "/api/v0/identity/jumio/check");
    }
}
