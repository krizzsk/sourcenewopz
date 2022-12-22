package com.didi.payment.pix.transfer.p141vm.model;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.pix.net.response.PixOrderDetailResp;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/payment/pix/transfer/vm/model/AmountEditVM$queryOrderDetail$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/payment/pix/net/response/PixOrderDetailResp;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.pix.transfer.vm.model.AmountEditVM$queryOrderDetail$1 */
/* compiled from: AmountEditVM.kt */
public final class AmountEditVM$queryOrderDetail$1 implements RpcService.Callback<PixOrderDetailResp> {
    final /* synthetic */ boolean $isLastCheck;
    final /* synthetic */ String $orderId;
    final /* synthetic */ AmountEditVM this$0;

    AmountEditVM$queryOrderDetail$1(AmountEditVM amountEditVM, boolean z, String str) {
        this.this$0 = amountEditVM;
        this.$isLastCheck = z;
        this.$orderId = str;
    }

    /* JADX WARNING: type inference failed for: r6v2, types: [com.didi.payment.commonsdk.net.IValidator] */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r0 = (com.didi.payment.pix.net.response.PixOrderDetailResp.OrderDetail) r6.data;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(com.didi.payment.pix.net.response.PixOrderDetailResp r6) {
        /*
            r5 = this;
            com.didi.payment.commonsdk.utils.NWHttpUtil$Companion r0 = com.didi.payment.commonsdk.utils.NWHttpUtil.Companion
            r1 = r6
            com.didi.payment.commonsdk.net.WBaseRespTemplate r1 = (com.didi.payment.commonsdk.net.WBaseRespTemplate) r1
            boolean r0 = r0.isRespValid(r1)
            r2 = 0
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r3 = 0
            if (r0 == 0) goto L_0x0047
            if (r6 != 0) goto L_0x0015
        L_0x0013:
            r0 = r3
            goto L_0x0024
        L_0x0015:
            com.didi.payment.commonsdk.net.IValidator r0 = r6.data
            com.didi.payment.pix.net.response.PixOrderDetailResp$OrderDetail r0 = (com.didi.payment.pix.net.response.PixOrderDetailResp.OrderDetail) r0
            if (r0 != 0) goto L_0x001c
            goto L_0x0013
        L_0x001c:
            boolean r0 = r0.isDialogBlock()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        L_0x0024:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0047
            com.didi.payment.pix.transfer.vm.model.AmountEditVM r0 = r5.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.getOrderDetailLooping()
            r0.setValue(r2)
            com.didi.payment.pix.transfer.vm.model.AmountEditVM r0 = r5.this$0
            r0.stopCountTimer()
            com.didi.payment.pix.transfer.vm.model.AmountEditVM r0 = r5.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.getOrderDetailLD()
            com.didi.payment.commonsdk.net.IValidator r6 = r6.data
            r0.setValue(r6)
            return
        L_0x0047:
            boolean r0 = r5.$isLastCheck
            if (r0 == 0) goto L_0x0088
            com.didi.payment.pix.transfer.vm.model.AmountEditVM r0 = r5.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.getOrderDetailLooping()
            r0.setValue(r2)
            com.didi.payment.commonsdk.utils.NWHttpUtil$Companion r0 = com.didi.payment.commonsdk.utils.NWHttpUtil.Companion
            boolean r0 = r0.isRespValid(r1)
            if (r0 == 0) goto L_0x007e
            if (r6 != 0) goto L_0x0060
            r0 = r3
            goto L_0x0064
        L_0x0060:
            com.didi.payment.commonsdk.net.IValidator r0 = r6.data
            com.didi.payment.pix.net.response.PixOrderDetailResp$OrderDetail r0 = (com.didi.payment.pix.net.response.PixOrderDetailResp.OrderDetail) r0
        L_0x0064:
            if (r0 != 0) goto L_0x0067
            goto L_0x006c
        L_0x0067:
            java.lang.String r1 = r5.$orderId
            r0.setOrderId(r1)
        L_0x006c:
            com.didi.payment.pix.transfer.vm.model.AmountEditVM r0 = r5.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.getOrderDetailLD()
            if (r6 != 0) goto L_0x0075
            goto L_0x007a
        L_0x0075:
            com.didi.payment.commonsdk.net.IValidator r6 = r6.data
            r3 = r6
            com.didi.payment.pix.net.response.PixOrderDetailResp$OrderDetail r3 = (com.didi.payment.pix.net.response.PixOrderDetailResp.OrderDetail) r3
        L_0x007a:
            r0.setValue(r3)
            return
        L_0x007e:
            com.didi.payment.pix.transfer.vm.model.AmountEditVM r0 = r5.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.getErrObj()
            r0.setValue(r6)
            return
        L_0x0088:
            if (r6 != 0) goto L_0x008b
            goto L_0x00d9
        L_0x008b:
            com.didi.payment.pix.transfer.vm.model.AmountEditVM r0 = r5.this$0
            java.lang.String r1 = r5.$orderId
            boolean r3 = r6.isValid()
            if (r3 == 0) goto L_0x00d9
            com.didi.payment.commonsdk.net.IValidator r3 = r6.data
            com.didi.payment.pix.net.response.PixOrderDetailResp$OrderDetail r3 = (com.didi.payment.pix.net.response.PixOrderDetailResp.OrderDetail) r3
            int r3 = r3.getStatus()
            com.didi.payment.pix.net.response.PixOrderDetailResp$OrderDetail$Companion r4 = com.didi.payment.pix.net.response.PixOrderDetailResp.OrderDetail.Companion
            int r4 = r4.getSTATUS_SUCCESS()
            if (r3 == r4) goto L_0x00b5
            com.didi.payment.commonsdk.net.IValidator r3 = r6.data
            com.didi.payment.pix.net.response.PixOrderDetailResp$OrderDetail r3 = (com.didi.payment.pix.net.response.PixOrderDetailResp.OrderDetail) r3
            int r3 = r3.getStatus()
            com.didi.payment.pix.net.response.PixOrderDetailResp$OrderDetail$Companion r4 = com.didi.payment.pix.net.response.PixOrderDetailResp.OrderDetail.Companion
            int r4 = r4.getSTATUS_FAIL()
            if (r3 != r4) goto L_0x00d9
        L_0x00b5:
            androidx.lifecycle.MutableLiveData r3 = r0.getOrderDetailLooping()
            r3.setValue(r2)
            android.os.CountDownTimer r2 = r0.f31261a
            if (r2 != 0) goto L_0x00c3
            goto L_0x00c6
        L_0x00c3:
            r2.cancel()
        L_0x00c6:
            com.didi.payment.commonsdk.net.IValidator r2 = r6.data
            com.didi.payment.pix.net.response.PixOrderDetailResp$OrderDetail r2 = (com.didi.payment.pix.net.response.PixOrderDetailResp.OrderDetail) r2
            if (r2 != 0) goto L_0x00cd
            goto L_0x00d0
        L_0x00cd:
            r2.setOrderId(r1)
        L_0x00d0:
            androidx.lifecycle.MutableLiveData r0 = r0.getOrderDetailLD()
            com.didi.payment.commonsdk.net.IValidator r6 = r6.data
            r0.setValue(r6)
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.pix.transfer.p141vm.model.AmountEditVM$queryOrderDetail$1.onSuccess(com.didi.payment.pix.net.response.PixOrderDetailResp):void");
    }

    public void onFailure(IOException iOException) {
        if (this.$isLastCheck) {
            this.this$0.getOrderDetailLooping().setValue(false);
            this.this$0.getErrObj().setValue(new WBaseResp().onRequestFail());
        }
    }
}
