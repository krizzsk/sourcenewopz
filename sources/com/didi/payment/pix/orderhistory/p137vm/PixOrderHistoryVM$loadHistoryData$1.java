package com.didi.payment.pix.orderhistory.p137vm;

import com.didi.payment.commonsdk.utils.NWHttpUtil;
import com.didi.payment.pix.net.response.PixOrderHistoryListResp;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/payment/pix/orderhistory/vm/PixOrderHistoryVM$loadHistoryData$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/payment/pix/net/response/PixOrderHistoryListResp;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.pix.orderhistory.vm.PixOrderHistoryVM$loadHistoryData$1 */
/* compiled from: PixOrderHistoryVM.kt */
public final class PixOrderHistoryVM$loadHistoryData$1 implements RpcService.Callback<PixOrderHistoryListResp> {
    final /* synthetic */ boolean $firstPage;
    final /* synthetic */ PixOrderHistoryVM this$0;

    PixOrderHistoryVM$loadHistoryData$1(PixOrderHistoryVM pixOrderHistoryVM, boolean z) {
        this.this$0 = pixOrderHistoryVM;
        this.$firstPage = z;
    }

    public void onSuccess(PixOrderHistoryListResp pixOrderHistoryListResp) {
        Intrinsics.checkNotNullParameter(pixOrderHistoryListResp, "value");
        this.this$0.f31134f = false;
        if (this.$firstPage) {
            this.this$0.isLoading().setValue(false);
        }
        if (NWHttpUtil.Companion.isRespValid(pixOrderHistoryListResp)) {
            this.this$0.f31133e = ((PixOrderHistoryListResp.DataModel) pixOrderHistoryListResp.data).nextIndex;
            this.this$0.getNextPageOrders().setValue(((PixOrderHistoryListResp.DataModel) pixOrderHistoryListResp.data).entryList);
        } else if (this.$firstPage) {
            this.this$0.getNextPageOrders().setValue(new ArrayList());
        }
    }

    public void onFailure(IOException iOException) {
        Intrinsics.checkNotNullParameter(iOException, "exception");
        this.this$0.f31134f = false;
        if (this.$firstPage) {
            this.this$0.isLoading().setValue(false);
            this.this$0.getNextPageOrders().setValue(new ArrayList());
        }
    }
}
