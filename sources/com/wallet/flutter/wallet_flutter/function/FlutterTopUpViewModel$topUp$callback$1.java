package com.wallet.flutter.wallet_flutter.function;

import androidx.lifecycle.MutableLiveData;
import com.didi.payment.wallet.password.PasswordDataVo;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.taxis99.R;
import com.wallet.flutter.wallet_flutter.http.PixOrderCreateRespEntity;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/wallet/flutter/wallet_flutter/function/FlutterTopUpViewModel$topUp$callback$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/wallet/flutter/wallet_flutter/http/PixOrderCreateRespEntity;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FlutterTopUpViewModel.kt */
public final class FlutterTopUpViewModel$topUp$callback$1 implements RpcService.Callback<PixOrderCreateRespEntity> {
    final /* synthetic */ FlutterTopUpViewModel this$0;

    FlutterTopUpViewModel$topUp$callback$1(FlutterTopUpViewModel flutterTopUpViewModel) {
        this.this$0 = flutterTopUpViewModel;
    }

    public void onSuccess(PixOrderCreateRespEntity pixOrderCreateRespEntity) {
        boolean z;
        boolean z2;
        PixOrderCreateRespEntity.OrderMetaData orderMetaData;
        PixOrderCreateRespEntity.OrderMetaData orderMetaData2;
        String h5;
        boolean z3 = false;
        this.this$0.isLoading().setValue(false);
        String str = null;
        if (pixOrderCreateRespEntity == null || (orderMetaData2 = (PixOrderCreateRespEntity.OrderMetaData) pixOrderCreateRespEntity.data) == null || (h5 = orderMetaData2.getH5()) == null) {
            if (pixOrderCreateRespEntity != null && pixOrderCreateRespEntity.errno == 60231) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (!(pixOrderCreateRespEntity != null && pixOrderCreateRespEntity.errno == 60232)) {
                    if (pixOrderCreateRespEntity != null && pixOrderCreateRespEntity.errno == 60233) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        PixOrderCreateRespEntity.NoticeInfo noticeInfo = ((PixOrderCreateRespEntity.OrderMetaData) pixOrderCreateRespEntity.data).getNoticeInfo();
                        if (noticeInfo != null) {
                            this.this$0.getPwdData().setValue(new PasswordDataVo(0, "", (String) null, noticeInfo.getTitle(), noticeInfo.getContent(), noticeInfo.getConfirmButton(), noticeInfo.getCancelButton(), 4, (DefaultConstructorMarker) null));
                        }
                        this.this$0.getFailedResult().setValue(null);
                        return;
                    }
                    if (pixOrderCreateRespEntity == null) {
                        orderMetaData = null;
                    } else {
                        orderMetaData = (PixOrderCreateRespEntity.OrderMetaData) pixOrderCreateRespEntity.data;
                    }
                    if (pixOrderCreateRespEntity != null && pixOrderCreateRespEntity.isValid()) {
                        z3 = true;
                    }
                    if (!z3 || orderMetaData == null) {
                        this.this$0.getFailedResult().setValue(null);
                        MutableLiveData<String> failedToast = this.this$0.getFailedToast();
                        if (pixOrderCreateRespEntity != null) {
                            str = pixOrderCreateRespEntity.errmsg;
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
            PixOrderCreateRespEntity.PaymentPasswordInfo paymentPasswordInfo = ((PixOrderCreateRespEntity.OrderMetaData) pixOrderCreateRespEntity.data).getPaymentPasswordInfo();
            if (paymentPasswordInfo != null) {
                this.this$0.getPwdData().setValue(new PasswordDataVo(1, "", paymentPasswordInfo.getPaySessionId(), (String) null, (String) null, (String) null, (String) null, 120, (DefaultConstructorMarker) null));
            }
            this.this$0.getFailedResult().setValue(null);
            return;
        }
        FlutterTopUpViewModel flutterTopUpViewModel = this.this$0;
        flutterTopUpViewModel.getToH5LiveData().setValue(h5);
        flutterTopUpViewModel.getFailedResult().setValue(null);
    }

    public void onFailure(IOException iOException) {
        this.this$0.getFailedToast().setValue(this.this$0.getApplication().getString(R.string.pay_base_network_error));
        OmegaSDK.trackError("Wallet_Pix_Top_Up", iOException);
        this.this$0.getFailedResult().setValue(null);
        this.this$0.isLoading().setValue(false);
    }
}
