package com.didi.entrega.order.page;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.flutter.plugin.listener.OnCallPluginListener;
import com.didi.entrega.customer.flutter.plugin.listener.OnPluginResultListener;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.order.contact.IMContactModel;
import com.didi.entrega.order.contact.OrderContactUtil;
import com.didi.entrega.order.plugin.OrderServicePlugin;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/entrega/order/page/OrderPage$newOrderServiceListener$1", "Lcom/didi/entrega/customer/flutter/plugin/listener/OnCallPluginListener;", "callPlugin", "", "action", "", "params", "", "", "resultListener", "Lcom/didi/entrega/customer/flutter/plugin/listener/OnPluginResultListener;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderPage.kt */
public final class OrderPage$newOrderServiceListener$1 implements OnCallPluginListener {
    final /* synthetic */ OrderPage this$0;

    OrderPage$newOrderServiceListener$1(OrderPage orderPage) {
        this.this$0 = orderPage;
    }

    public void callPlugin(String str, Map<String, ? extends Object> map, OnPluginResultListener onPluginResultListener) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "action");
        if (Intrinsics.areEqual((Object) str, (Object) OrderServicePlugin.DIRECT_CONTACT)) {
            String str2 = null;
            if (map == null) {
                obj = null;
            } else {
                obj = map.get(Const.PageParams.PHONE_NUMBER);
            }
            if (obj instanceof String) {
                str2 = (String) obj;
            }
            if (str2 != null) {
                CustomerSystemUtil.doCall(this.this$0.getContext(), str2);
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) Intrinsics.stringPlus("contactIM", this.this$0.getPageId()))) {
            if (map != null) {
                OrderContactUtil.Companion companion = OrderContactUtil.Companion;
                ScopeContext scopeContext = this.this$0.getScopeContext();
                Object obj2 = map.get("orderId");
                if (obj2 != null) {
                    String str3 = (String) obj2;
                    Object obj3 = map.get(Const.PageParams.CONTACT_TYPE);
                    if (obj3 != null) {
                        companion.doPageContact(scopeContext, str3, (IMContactModel) null, ((Integer) obj3).intValue(), 2);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) Intrinsics.stringPlus("updateOrderInfoById", this.this$0.getPageId()))) {
            this.this$0.m15327a(onPluginResultListener);
        }
    }
}
