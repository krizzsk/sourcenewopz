package com.didi.soda.order.flutterpage;

import android.text.TextUtils;
import com.didi.rlab.uni_customer_business.order_service.OrderService;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.rpc.entity.OrderReceiptInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.router.DiRouter;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/order/flutterpage/NewOrderServicePlugin$sendReceipt$1", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderReceiptInfoEntity;", "onFailure", "", "exception", "Ljava/io/IOException;", "onRpcSuccess", "var1", "var2", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NewOrderServicePlugin.kt */
public final class NewOrderServicePlugin$sendReceipt$1 extends CustomerRpcCallback<OrderReceiptInfoEntity> {
    final /* synthetic */ String $orderId;
    final /* synthetic */ OrderService.Result<Boolean> $result;

    NewOrderServicePlugin$sendReceipt$1(OrderService.Result<Boolean> result, String str) {
        this.$result = result;
        this.$orderId = str;
    }

    public void onRpcSuccess(OrderReceiptInfoEntity orderReceiptInfoEntity, long j) {
        OrderService.Result<Boolean> result = this.$result;
        if (result != null) {
            result.success(true);
        }
        if (orderReceiptInfoEntity != null) {
            if (TextUtils.isEmpty(orderReceiptInfoEntity.email)) {
                LoginUtil.go2ModifyEmail(GlobalContext.getContext(), new NewOrderServicePlugin$sendReceipt$1$onRpcSuccess$1());
            } else {
                DiRouter.request().path(RoutePath.SEND_RECEIPT).putString("orderid", this.$orderId).putInt(Const.PageParams.RECEIPT_PAGE_TYPE, 1).putSerializable(Const.PageParams.RECEIPT_ENTITIES, orderReceiptInfoEntity).open();
            }
        }
    }

    public void onFailure(IOException iOException) {
        Intrinsics.checkNotNullParameter(iOException, "exception");
        super.onFailure(iOException);
        OrderService.Result<Boolean> result = this.$result;
        if (result != null) {
            result.success(false);
        }
    }
}
