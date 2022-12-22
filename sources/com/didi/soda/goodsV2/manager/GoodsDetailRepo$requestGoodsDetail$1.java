package com.didi.soda.goodsV2.manager;

import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.repo.CustomerResource;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/goodsV2/manager/GoodsDetailRepo$requestGoodsDetail$1", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/GoodsItemEntity;", "onRpcFailure", "", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "data", "var2", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GoodsDetailRepo.kt */
public final class GoodsDetailRepo$requestGoodsDetail$1 extends CustomerRpcCallback<GoodsItemEntity> {
    final /* synthetic */ GoodsDetailRepo this$0;

    GoodsDetailRepo$requestGoodsDetail$1(GoodsDetailRepo goodsDetailRepo) {
        this.this$0 = goodsDetailRepo;
    }

    public void onRpcSuccess(GoodsItemEntity goodsItemEntity, long j) {
        if (goodsItemEntity != null) {
            this.this$0.setValue(CustomerResource.success(goodsItemEntity));
        } else {
            this.this$0.setValue(CustomerResource.error(ResourceHelper.getString(R.string.customer_get_data_failure)));
        }
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        String str;
        super.onRpcFailure(sFRpcException);
        GoodsDetailRepo goodsDetailRepo = this.this$0;
        if (sFRpcException == null) {
            str = null;
        } else {
            str = sFRpcException.getMessage();
        }
        if (str == null) {
            str = ResourceHelper.getString(R.string.customer_get_data_failure);
        }
        goodsDetailRepo.setValue(CustomerResource.error(str));
    }
}
