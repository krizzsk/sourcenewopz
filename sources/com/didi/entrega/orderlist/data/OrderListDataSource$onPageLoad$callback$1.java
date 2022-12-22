package com.didi.entrega.orderlist.data;

import com.didi.entrega.customer.datasource.page.PageController;
import com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderListEntity;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.repo.CustomerResource;
import com.didi.entrega.orderlist.omega.OrderListOmegaHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/entrega/orderlist/data/OrderListDataSource$onPageLoad$callback$1", "Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/HistoryOrderListEntity;", "onRpcFailure", "", "ex", "Lcom/didi/entrega/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "var1", "var2", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderListDataSource.kt */
public final class OrderListDataSource$onPageLoad$callback$1 extends CustomerRpcCallback<HistoryOrderListEntity> {
    final /* synthetic */ OrderListDataSource this$0;

    OrderListDataSource$onPageLoad$callback$1(OrderListDataSource orderListDataSource) {
        this.this$0 = orderListDataSource;
    }

    public void onRpcSuccess(HistoryOrderListEntity historyOrderListEntity, long j) {
        Intrinsics.checkNotNullParameter(historyOrderListEntity, "var1");
        this.this$0.f20991c = historyOrderListEntity.getHaveNext() != 0;
        this.this$0.f20990b = historyOrderListEntity.getPageSize();
        PageController access$getMPageController$p = this.this$0.f20993e;
        if (access$getMPageController$p != null) {
            access$getMPageController$p.receiveResult(historyOrderListEntity.getOrderList(), this.this$0.f20989a);
        }
        OrderListDataSource orderListDataSource = this.this$0;
        CustomerResource success = CustomerResource.success(historyOrderListEntity);
        Intrinsics.checkNotNullExpressionValue(success, "success<HistoryOrderListEntity>(var1)");
        orderListDataSource.onPageLoadedResult(success);
        OrderListOmegaHelper.Companion.getInstance().trackOrderListSW(historyOrderListEntity.getOrderList(), this.this$0.f20989a * historyOrderListEntity.getPageSize());
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        Intrinsics.checkNotNullParameter(sFRpcException, "ex");
        super.onRpcFailure(sFRpcException);
        OrderListDataSource orderListDataSource = this.this$0;
        CustomerResource error = CustomerResource.error(sFRpcException.getCode(), sFRpcException.getMessage());
        Intrinsics.checkNotNullExpressionValue(error, "error<HistoryOrderListEntity>(ex.code, ex.message)");
        orderListDataSource.onPageLoadedResult(error);
        OrderListOmegaHelper.Companion.getInstance().trackOrderListApiError(sFRpcException.getCode(), sFRpcException.getOriginalMessage());
    }
}
