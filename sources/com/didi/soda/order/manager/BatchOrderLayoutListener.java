package com.didi.soda.order.manager;

import com.didi.soda.customer.foundation.rpc.entity.OrderLayoutEntity;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H&¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/order/manager/BatchOrderLayoutListener;", "", "()V", "onBatchOrderLayout", "", "datas", "", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderLayoutEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BatchOrderLayoutListener.kt */
public abstract class BatchOrderLayoutListener {
    public abstract void onBatchOrderLayout(List<OrderLayoutEntity> list);
}
