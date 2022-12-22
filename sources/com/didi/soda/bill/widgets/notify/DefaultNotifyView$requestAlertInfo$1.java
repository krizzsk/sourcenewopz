package com.didi.soda.bill.widgets.notify;

import com.didi.soda.customer.foundation.rpc.entity.bill.BillNotifyEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/bill/widgets/notify/DefaultNotifyView$requestAlertInfo$1", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillNotifyEntity;", "onFailure", "", "exception", "Ljava/io/IOException;", "onRpcSuccess", "entity", "var2", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DefaultNotifyView.kt */
public final class DefaultNotifyView$requestAlertInfo$1 extends CustomerRpcCallback<BillNotifyEntity> {
    final /* synthetic */ DefaultNotifyView this$0;

    DefaultNotifyView$requestAlertInfo$1(DefaultNotifyView defaultNotifyView) {
        this.this$0 = defaultNotifyView;
    }

    public void onRpcSuccess(BillNotifyEntity billNotifyEntity, long j) {
        Function0 access$getNotifyPreparedCompleted$p;
        if ((billNotifyEntity == null ? null : billNotifyEntity.getAlertInfo()) != null) {
            this.this$0.f39311b = billNotifyEntity.getAlertInfo().getContent();
            CharSequence access$getContent$p = this.this$0.f39311b;
            if (!(access$getContent$p == null || access$getContent$p.length() == 0) && (access$getNotifyPreparedCompleted$p = this.this$0.f39312c) != null) {
                access$getNotifyPreparedCompleted$p.invoke();
            }
        }
    }

    public void onFailure(IOException iOException) {
        super.onFailure(iOException);
    }
}
