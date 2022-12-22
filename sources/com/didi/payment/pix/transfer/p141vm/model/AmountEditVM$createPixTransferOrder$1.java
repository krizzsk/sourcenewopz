package com.didi.payment.pix.transfer.p141vm.model;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.utils.NWHttpUtil;
import com.didi.payment.pix.net.response.PixOrderCreateResp;
import com.didi.payment.wallet.password.PasswordDataVo;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/payment/pix/transfer/vm/model/AmountEditVM$createPixTransferOrder$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/payment/pix/net/response/PixOrderCreateResp;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.pix.transfer.vm.model.AmountEditVM$createPixTransferOrder$1 */
/* compiled from: AmountEditVM.kt */
public final class AmountEditVM$createPixTransferOrder$1 implements RpcService.Callback<PixOrderCreateResp> {
    final /* synthetic */ String $bizContent;
    final /* synthetic */ AmountEditVM this$0;

    AmountEditVM$createPixTransferOrder$1(AmountEditVM amountEditVM, String str) {
        this.this$0 = amountEditVM;
        this.$bizContent = str;
    }

    public void onSuccess(PixOrderCreateResp pixOrderCreateResp) {
        PixOrderCreateResp.OrderMetaData orderMetaData;
        String orderId;
        boolean z = true;
        if (!(pixOrderCreateResp != null && pixOrderCreateResp.errno == 60231)) {
            if (!(pixOrderCreateResp != null && pixOrderCreateResp.errno == 60232)) {
                if (pixOrderCreateResp == null || pixOrderCreateResp.errno != 60233) {
                    z = false;
                }
                if (z) {
                    PixOrderCreateResp.NoticeInfo noticeInfo = ((PixOrderCreateResp.OrderMetaData) pixOrderCreateResp.data).getNoticeInfo();
                    if (noticeInfo != null) {
                        this.this$0.getPwdData().setValue(new PasswordDataVo(0, this.$bizContent, (String) null, noticeInfo.getTitle(), noticeInfo.getContent(), noticeInfo.getConfirmButton(), noticeInfo.getCancelButton(), 4, (DefaultConstructorMarker) null));
                        return;
                    }
                    return;
                } else if (!NWHttpUtil.Companion.isRespValid(pixOrderCreateResp)) {
                    this.this$0.getOrderDetailLooping().setValue(false);
                    this.this$0.getErrCreateOrder().setValue(pixOrderCreateResp);
                    return;
                } else if (pixOrderCreateResp != null && (orderMetaData = (PixOrderCreateResp.OrderMetaData) pixOrderCreateResp.data) != null && (orderId = orderMetaData.getOrderId()) != null) {
                    this.this$0.loopQueryOrderDetail(orderId);
                    return;
                } else {
                    return;
                }
            }
        }
        PixOrderCreateResp.PaymentPasswordInfo paymentPasswordInfo = ((PixOrderCreateResp.OrderMetaData) pixOrderCreateResp.data).getPaymentPasswordInfo();
        if (paymentPasswordInfo != null) {
            this.this$0.getPwdData().setValue(new PasswordDataVo(1, this.$bizContent, paymentPasswordInfo.getPaySessionId(), (String) null, (String) null, (String) null, (String) null, 120, (DefaultConstructorMarker) null));
        }
    }

    public void onFailure(IOException iOException) {
        this.this$0.getOrderDetailLooping().setValue(false);
        this.this$0.getErrCreateOrder().setValue(new WBaseResp().onRequestFail());
    }
}
