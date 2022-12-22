package com.didi.soda.goods.manager;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.repo.CustomerResource;
import com.didichuxing.afanty.common.utils.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0004JN\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0007JF\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/soda/goods/manager/GoodsDetailRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "Lcom/didi/soda/customer/repo/CustomerResource;", "Lcom/didi/soda/customer/foundation/rpc/entity/GoodsItemEntity;", "()V", "rpcService", "Lcom/didi/soda/customer/foundation/rpc/CustomerRpcService;", "requestGoodsDetail", "", "businessId", "", "goodsId", "mduId", "cartId", "source", "", "actInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/ActInfoEntity;", "callback", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GoodsDetailRepo.kt */
public final class GoodsDetailRepo extends Repo<CustomerResource<GoodsItemEntity>> {

    /* renamed from: a */
    private final CustomerRpcService f42428a;

    public GoodsDetailRepo() {
        CustomerRpcService customerRpcService = CustomerRpcManagerProxy.get();
        Intrinsics.checkNotNullExpressionValue(customerRpcService, "get()");
        this.f42428a = customerRpcService;
    }

    public static /* synthetic */ void requestGoodsDetail$default(GoodsDetailRepo goodsDetailRepo, String str, String str2, String str3, String str4, int i, ActInfoEntity actInfoEntity, int i2, Object obj) {
        goodsDetailRepo.requestGoodsDetail(str, str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? 0 : i, actInfoEntity);
    }

    public final void requestGoodsDetail(String str, String str2, String str3, String str4, int i, ActInfoEntity actInfoEntity) {
        this.f42428a.getGoodsDetail(str, str2, str3, str4, i, actInfoEntity, false, new GoodsDetailRepo$requestGoodsDetail$1(this));
    }

    public static /* synthetic */ void requestGoodsDetail$default(GoodsDetailRepo goodsDetailRepo, String str, String str2, String str3, String str4, int i, ActInfoEntity actInfoEntity, CustomerRpcCallback customerRpcCallback, int i2, Object obj) {
        goodsDetailRepo.requestGoodsDetail(str, str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? 0 : i, actInfoEntity, customerRpcCallback);
    }

    public final void requestGoodsDetail(String str, String str2, String str3, String str4, int i, ActInfoEntity actInfoEntity, CustomerRpcCallback<GoodsItemEntity> customerRpcCallback) {
        Intrinsics.checkNotNullParameter(str, Constants.JSON_BUSINESS_ID);
        Intrinsics.checkNotNullParameter(str2, "goodsId");
        Intrinsics.checkNotNullParameter(str3, "mduId");
        Intrinsics.checkNotNullParameter(str4, Const.BundleKey.CART_ID);
        CustomerRpcCallback<GoodsItemEntity> customerRpcCallback2 = customerRpcCallback;
        Intrinsics.checkNotNullParameter(customerRpcCallback2, "callback");
        this.f42428a.getGoodsDetail(str, str2, str3, str4, i, actInfoEntity, false, customerRpcCallback2);
    }
}
