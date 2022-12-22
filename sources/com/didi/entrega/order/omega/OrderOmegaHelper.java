package com.didi.entrega.order.omega;

import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.entrega.customer.foundation.tracker.event.EventConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001f\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u001f\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\b¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/entrega/order/omega/OrderOmegaHelper;", "", "()V", "orderChannelError", "", "type", "", "orderRequestError", "", "errorName", "(Ljava/lang/Integer;Ljava/lang/String;)V", "traceDebtCK", "orderId", "orderStatus", "(Ljava/lang/String;Ljava/lang/Integer;)V", "traceDebtSW", "trackOrderIdError", "from", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderOmegaHelper.kt */
public final class OrderOmegaHelper {
    public static final OrderOmegaHelper INSTANCE = new OrderOmegaHelper();

    private OrderOmegaHelper() {
    }

    public final void traceDebtSW(String str, Integer num) {
        int i;
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Debt.ORDER_DEBT_SW);
        if (str == null) {
            str = "";
        }
        OmegaTracker.Builder addEventParam = create.addEventParam("order_id", str);
        if (num == null) {
            i = 0;
        } else {
            i = num.intValue();
        }
        addEventParam.addEventParam("order_status", Integer.valueOf(i)).build().track();
    }

    public final void traceDebtCK(String str, Integer num) {
        int i;
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Debt.ORDER_DEBT_CK);
        if (str == null) {
            str = "";
        }
        OmegaTracker.Builder addEventParam = create.addEventParam("order_id", str);
        if (num == null) {
            i = 0;
        } else {
            i = num.intValue();
        }
        addEventParam.addEventParam("order_status", Integer.valueOf(i)).build().track();
    }

    public final void orderRequestError(Integer num, String str) {
        String str2;
        ErrorTracker.Builder addModuleName = ErrorTracker.create(ErrorConst.ErrorName.TECH_C_ORDER_DETAIL_API_ERROR).addModuleName("order");
        if (num == null || (str2 = num.toString()) == null) {
            str2 = "unknow";
        }
        ErrorTracker.Builder addErrorType = addModuleName.addErrorType(str2);
        if (str == null) {
            str = "unknow";
        }
        addErrorType.addErrorMsg(str).build().trackError();
    }

    public final void orderChannelError(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        ErrorTracker.create(ErrorConst.ErrorName.TECH_C_ORDER_GET_PLUGIN_ERROR).addModuleName("order").addErrorType(str).addErrorMsg("Plugin not found").build().trackError();
    }

    public final void trackOrderIdError(int i) {
        ErrorTracker.create(ErrorConst.ErrorName.TECH_C_ORDER_ORDERID_ERROR).addModuleName("order").addErrorType(String.valueOf(i)).addErrorMsg("orderIds is empty").build().trackError();
    }
}
