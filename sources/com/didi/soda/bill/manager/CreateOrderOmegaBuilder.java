package com.didi.soda.bill.manager;

import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\u000b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\u000f\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\u0013\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\u0018\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0015\u0010\u0019\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0015\u0010\u001a\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\u001f\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0015\u0010 \u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0015\u0010!\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0010\u0010\"\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0015\u0010#\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0010\u0010$\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0016\u0010%\u001a\u00020\u0000*\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0003R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, mo175978d2 = {"Lcom/didi/soda/bill/manager/CreateOrderOmegaBuilder;", "", "()V", "paramMap", "", "", "addressDetail", "value", "aid", "build", "cartId", "deliveryType", "", "(Ljava/lang/Integer;)Lcom/didi/soda/bill/manager/CreateOrderOmegaBuilder;", "errorMsg", "eventType", "failureReason", "fireBaseAppInstanceId", "fromPage", "isSuc", "isTableWare", "", "itemDetail", "orderId", "payFailureReason", "payMethod", "platformCouponAmount", "poiType", "preOrderId", "priceList", "pubBizType", "rCouponAmount", "riskCode", "shopCouponAmount", "shopId", "total", "traceId", "set", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateOrderOmegaBuilder.kt */
public final class CreateOrderOmegaBuilder {

    /* renamed from: a */
    private final Map<String, Object> f39015a = new LinkedHashMap();

    /* renamed from: a */
    private final CreateOrderOmegaBuilder m27731a(String str, Object obj) {
        this.f39015a.put(str, obj);
        return this;
    }

    public final Map<String, Object> build() {
        return this.f39015a;
    }

    public final CreateOrderOmegaBuilder fromPage(String str) {
        return m27731a("from_page", str);
    }

    public final CreateOrderOmegaBuilder cartId(String str) {
        return m27731a("cart_id", str);
    }

    public final CreateOrderOmegaBuilder shopId(String str) {
        return m27731a("shop_id", str);
    }

    public final CreateOrderOmegaBuilder itemDetail(String str) {
        return m27731a(ParamConst.PARAM_ITEM_DETAIL, str);
    }

    public final CreateOrderOmegaBuilder payMethod(Integer num) {
        return m27731a("pay_method", num);
    }

    public final CreateOrderOmegaBuilder total(Integer num) {
        return m27731a(ParamConst.PARAM_TOTAL, num);
    }

    public final CreateOrderOmegaBuilder preOrderId(String str) {
        return m27731a("pre_order_id", str);
    }

    public final CreateOrderOmegaBuilder aid(String str) {
        return m27731a("aid", str);
    }

    public final CreateOrderOmegaBuilder isSuc(Integer num) {
        return m27731a("is_suc", num);
    }

    public final CreateOrderOmegaBuilder payFailureReason(Integer num) {
        return m27731a("failure_reason", num);
    }

    public final CreateOrderOmegaBuilder eventType(Integer num) {
        return m27731a("event_type", num);
    }

    public final CreateOrderOmegaBuilder priceList(String str) {
        return m27731a(ParamConst.PARAM_PRICE_LIST, str);
    }

    public final CreateOrderOmegaBuilder platformCouponAmount(Integer num) {
        return m27731a(ParamConst.PARAM_PLATFORM_COUPON_AMOUNT, num);
    }

    public final CreateOrderOmegaBuilder shopCouponAmount(Integer num) {
        return m27731a(ParamConst.PARAM_SHOP_COUPON_AMOUNT, num);
    }

    public final CreateOrderOmegaBuilder deliveryType(Integer num) {
        return m27731a(ParamConst.PARAM_DELIVERY_TYPE, num);
    }

    public final CreateOrderOmegaBuilder rCouponAmount(Integer num) {
        return m27731a(ParamConst.PARAM_R_COUPON_AMOUNT, num);
    }

    public final CreateOrderOmegaBuilder orderId(String str) {
        return m27731a("order_id", str);
    }

    public final CreateOrderOmegaBuilder failureReason(Integer num) {
        return m27731a("error_code", num);
    }

    public final CreateOrderOmegaBuilder errorMsg(String str) {
        return m27731a("error_msg", str);
    }

    public final CreateOrderOmegaBuilder riskCode(Integer num) {
        return m27731a(ParamConst.PARAM_RISK_CODE, num);
    }

    public final CreateOrderOmegaBuilder fireBaseAppInstanceId(String str) {
        return m27731a(ParamConst.PARAMS_GOOGLE_APP_INSTANCE_ID, str);
    }

    public final CreateOrderOmegaBuilder addressDetail(String str) {
        return m27731a(ParamConst.PARAM_ADDRESS_DETAIL, str);
    }

    public final CreateOrderOmegaBuilder traceId(String str) {
        return m27731a(ParamConst.TRACE_ID, str);
    }

    public final CreateOrderOmegaBuilder poiType(String str) {
        return m27731a(ParamConst.PARAM_POI_TYPE, str);
    }

    public final CreateOrderOmegaBuilder pubBizType(String str) {
        return m27731a(ParamConst.PARAM_PUB_BIZ_LINE, str);
    }

    public final CreateOrderOmegaBuilder isTableWare(boolean z) {
        return m27731a(ParamConst.PARAM_IS_TABLEWARE, Integer.valueOf(z ? 1 : 0));
    }
}
