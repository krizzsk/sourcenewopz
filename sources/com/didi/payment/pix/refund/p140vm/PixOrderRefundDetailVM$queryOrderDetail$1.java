package com.didi.payment.pix.refund.p140vm;

import com.didi.payment.commonsdk.utils.NWHttpUtil;
import com.didi.payment.pix.net.response.PixRefundResultResp;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/payment/pix/refund/vm/PixOrderRefundDetailVM$queryOrderDetail$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/payment/pix/net/response/PixRefundResultResp;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.pix.refund.vm.PixOrderRefundDetailVM$queryOrderDetail$1 */
/* compiled from: PixOrderRefundDetailVM.kt */
public final class PixOrderRefundDetailVM$queryOrderDetail$1 implements RpcService.Callback<PixRefundResultResp> {
    final /* synthetic */ boolean $isLast;
    final /* synthetic */ PixOrderRefundDetailVM this$0;

    PixOrderRefundDetailVM$queryOrderDetail$1(PixOrderRefundDetailVM pixOrderRefundDetailVM, boolean z) {
        this.this$0 = pixOrderRefundDetailVM;
        this.$isLast = z;
    }

    public void onSuccess(PixRefundResultResp pixRefundResultResp) {
        if (NWHttpUtil.Companion.isRespValid(pixRefundResultResp)) {
            this.this$0.getRefundDetails().setValue(pixRefundResultResp == null ? null : (PixRefundResultResp.OrderRefundDetails) pixRefundResultResp.data);
            this.this$0.stopCountTimer();
            this.this$0.isLoading().setValue(false);
        } else if (pixRefundResultResp != null) {
            boolean z = this.$isLast;
            PixOrderRefundDetailVM pixOrderRefundDetailVM = this.this$0;
            if (z) {
                pixOrderRefundDetailVM.getRefundDetails().setValue(pixRefundResultResp.data);
                pixOrderRefundDetailVM.isLoading().setValue(false);
            }
        }
    }

    public void onFailure(IOException iOException) {
        if (this.$isLast) {
            this.this$0.isLoading().setValue(false);
        }
    }
}
