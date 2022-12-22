package com.didi.soda.order.flutterpage;

import android.app.Activity;
import androidx.core.app.NotificationCompat;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.soda.customer.flutter.plugin.CustomerBasePlugin;
import com.didi.soda.customer.foundation.rpc.entity.OrderLayoutEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerOrderManager;
import com.didi.soda.manager.base.ICustomerPayManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0015J\u0010\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/soda/order/flutterpage/OrderServicePlugin;", "Lcom/didi/soda/customer/flutter/plugin/CustomerBasePlugin;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "mChannel", "Lio/flutter/plugin/common/MethodChannel;", "getOrderInfoById", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "goToPay", "onAttachedToEngine", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "onMethodCall", "queryUnreadCount", "role", "", "orderId", "", "unReadCount", "sendOrderInfo", "orderLayoutEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderLayoutEntity;", "updateOrderInfoById", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderServicePlugin.kt */
public final class OrderServicePlugin extends CustomerBasePlugin {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String THIRD_PAY_SUCCESS = "thirdPaySuccess";
    public static final String UPDATE_ORDER_INFO = "updateOrderInfoById";

    /* renamed from: a */
    private final Activity f43504a;

    /* renamed from: b */
    private MethodChannel f43505b;

    public OrderServicePlugin(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f43504a = activity;
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "com.didi.rlab/order_service_plugin");
        this.f43505b = methodChannel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(this);
        }
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        MethodChannel methodChannel = this.f43505b;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 880912216) {
                if (hashCode != 1355353990) {
                    if (hashCode == 1946104005 && str.equals("updateOrderInfoById")) {
                        m30826c(methodCall, result);
                        return;
                    }
                } else if (str.equals("payOrder")) {
                    m30824a(methodCall, result);
                    return;
                }
            } else if (str.equals("getOrderInfoById")) {
                m30825b(methodCall, result);
                return;
            }
        }
        result.success((Object) null);
    }

    /* renamed from: a */
    private final void m30824a(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.hasArgument("transId")) {
            ICustomerPayManager.PayParamEntity payParamEntity = new ICustomerPayManager.PayParamEntity();
            payParamEntity.token = LoginUtil.getToken();
            payParamEntity.transId = (String) methodCall.argument("transId");
            payParamEntity.setOrderId((String) methodCall.argument("orderId"));
            ((ICustomerPayManager) CustomerManagerLoader.loadManager(ICustomerPayManager.class)).pay((ScopeContext) null, this.f43504a, payParamEntity, new OrderServicePlugin$goToPay$1(result, this, (String) methodCall.argument("pageId")));
        }
    }

    /* renamed from: b */
    private final void m30825b(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        String str2 = (String) methodCall.argument("orderId");
        OrderLayoutEntity orderLayoutById = ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).getOrderLayoutById(str2);
        if (orderLayoutById == null) {
            orderLayoutById = ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).getOrderLayoutByPreId(str2);
        }
        if (orderLayoutById == null) {
            str = null;
        } else {
            str = GsonUtil.toJson(orderLayoutById);
        }
        result.success(str);
    }

    /* renamed from: c */
    private final void m30826c(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("pageId");
        if (!getListeners().isEmpty()) {
            CustomerBasePlugin.notifyAllObserver$default(this, Intrinsics.stringPlus("updateOrderInfoById", str), (Map) null, new OrderServicePlugin$updateOrderInfoById$1(result), 2, (Object) null);
        }
    }

    public final void sendOrderInfo(OrderLayoutEntity orderLayoutEntity) {
        String str;
        MethodChannel methodChannel = this.f43505b;
        if (methodChannel != null && methodChannel != null) {
            if (orderLayoutEntity == null) {
                str = null;
            } else {
                str = GsonUtil.toJson(orderLayoutEntity);
            }
            methodChannel.invokeMethod("updateOrderInfo", str);
        }
    }

    public final void queryUnreadCount(int i, String str, int i2) {
        Map hashMap = new HashMap();
        hashMap.put("orderId", str);
        hashMap.put(Const.PageParams.COUNT, Integer.valueOf(i2));
        hashMap.put("type", Integer.valueOf(i));
        MethodChannel methodChannel = this.f43505b;
        if (methodChannel != null) {
            methodChannel.invokeMethod("queryUnreadCount", hashMap);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/order/flutterpage/OrderServicePlugin$Companion;", "", "()V", "THIRD_PAY_SUCCESS", "", "UPDATE_ORDER_INFO", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderServicePlugin.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
