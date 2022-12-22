package com.didi.payment.pix.topup;

import androidx.lifecycle.MutableLiveData;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.pix.net.response.PixOrderCreateResp;
import com.didi.payment.wallet.password.PasswordDataVo;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/payment/pix/topup/TopUpByPixViewModel$topUp$callback$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/payment/pix/net/response/PixOrderCreateResp;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopUpByPixViewModel.kt */
public final class TopUpByPixViewModel$topUp$callback$1 implements RpcService.Callback<PixOrderCreateResp> {
    final /* synthetic */ TopUpByPixViewModel this$0;

    TopUpByPixViewModel$topUp$callback$1(TopUpByPixViewModel topUpByPixViewModel) {
        this.this$0 = topUpByPixViewModel;
    }

    public void onSuccess(PixOrderCreateResp pixOrderCreateResp) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        this.this$0.isLoading().setValue(false);
        if (pixOrderCreateResp != null && pixOrderCreateResp.errno == 60231) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (!(pixOrderCreateResp != null && pixOrderCreateResp.errno == 60232)) {
                if (pixOrderCreateResp != null && pixOrderCreateResp.errno == 60233) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    PixOrderCreateResp.NoticeInfo noticeInfo = ((PixOrderCreateResp.OrderMetaData) pixOrderCreateResp.data).getNoticeInfo();
                    if (noticeInfo != null) {
                        this.this$0.getPwdData().setValue(new PasswordDataVo(0, "", (String) null, noticeInfo.getTitle(), noticeInfo.getContent(), noticeInfo.getConfirmButton(), noticeInfo.getCancelButton(), 4, (DefaultConstructorMarker) null));
                        return;
                    }
                    return;
                }
                String str = null;
                PixOrderCreateResp.OrderMetaData orderMetaData = pixOrderCreateResp == null ? null : (PixOrderCreateResp.OrderMetaData) pixOrderCreateResp.data;
                if (pixOrderCreateResp != null && pixOrderCreateResp.isValid()) {
                    z3 = true;
                }
                if (!z3 || orderMetaData == null) {
                    MutableLiveData<String> failedToast = this.this$0.getFailedToast();
                    if (pixOrderCreateResp != null) {
                        str = pixOrderCreateResp.errmsg;
                    }
                    if (str == null) {
                        str = this.this$0.getApplication().getString(R.string.pay_base_network_error);
                    }
                    failedToast.setValue(str);
                    return;
                }
                this.this$0.getSuccessOrder().setValue(orderMetaData);
                return;
            }
        }
        PixOrderCreateResp.PaymentPasswordInfo paymentPasswordInfo = ((PixOrderCreateResp.OrderMetaData) pixOrderCreateResp.data).getPaymentPasswordInfo();
        if (paymentPasswordInfo != null) {
            this.this$0.getPwdData().setValue(new PasswordDataVo(1, "", paymentPasswordInfo.getPaySessionId(), (String) null, (String) null, (String) null, (String) null, 120, (DefaultConstructorMarker) null));
        }
    }

    public void onFailure(IOException iOException) {
        this.this$0.getFailedToast().setValue(this.this$0.getApplication().getString(R.string.pay_base_network_error));
        FinOmegaSDK.trackError("Wallet_Pix_Top_Up", iOException);
        this.this$0.isLoading().setValue(false);
    }
}
