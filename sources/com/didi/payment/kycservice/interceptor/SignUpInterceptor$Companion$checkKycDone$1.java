package com.didi.payment.kycservice.interceptor;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.didi.drouter.router.Request;
import com.didi.global.loading.Loading;
import com.didi.global.loading.LoadingRenderType;
import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import com.didi.payment.kycservice.utils.KycStore;
import com.taxis99.R;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/payment/kycservice/interceptor/SignUpInterceptor$Companion$checkKycDone$1", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp;", "onComplete", "", "onFailure", "exception", "Ljava/io/IOException;", "onStart", "onSuccess", "response", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SignUpInterceptor.kt */
public final class SignUpInterceptor$Companion$checkKycDone$1 extends WNetCallback<GuidesInfoResp> {
    final /* synthetic */ Request $request;
    final /* synthetic */ String $source;

    SignUpInterceptor$Companion$checkKycDone$1(Request request, String str) {
        this.$request = request;
        this.$source = str;
    }

    public void onStart() {
        View findViewById;
        super.onStart();
        Context context = this.$request.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            Window window = activity.getWindow();
            if (window == null || (findViewById = window.findViewById(16908290)) == null) {
                Void voidR = null;
            } else {
                Loading.make((Context) activity, LoadingRenderType.ANIMATION, findViewById, true, 48).show();
                return;
            }
        }
        SignUpInterceptor.Companion.goSignPage(this.$request, this.$source);
    }

    public void onComplete() {
        super.onComplete();
        Loading.hide();
    }

    public void onFailure(IOException iOException) {
        super.onFailure(iOException);
        SignUpInterceptor.Companion.goSignPage(this.$request, this.$source);
    }

    public void onSuccess(GuidesInfoResp guidesInfoResp) {
        Intrinsics.checkNotNullParameter(guidesInfoResp, "response");
        super.onSuccess(guidesInfoResp);
        GuidesInfoResp.Data data = guidesInfoResp.getData();
        boolean z = true;
        int i = 0;
        if (data == null || data.getLatourKycStatus() != 1) {
            z = false;
        }
        if (z) {
            KycStore kycStore = KycStore.INSTANCE;
            GuidesInfoResp.Data data2 = guidesInfoResp.getData();
            if (data2 != null) {
                i = data2.getLatourKycStatus();
            }
            kycStore.setLatourKycStatus(i);
            KycStore kycStore2 = KycStore.INSTANCE;
            GuidesInfoResp.Data data3 = guidesInfoResp.getData();
            kycStore2.setPixStatus(data3 == null ? null : data3.getPixStatus());
            WalletToastNew.showFailedMsg(this.$request.getContext(), this.$request.getContext().getString(R.string.Others_APP_Network_exception_UfeG));
            return;
        }
        SignUpInterceptor.Companion.goSignPage(this.$request, this.$source);
    }
}
