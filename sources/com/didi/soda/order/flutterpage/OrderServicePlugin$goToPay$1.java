package com.didi.soda.order.flutterpage;

import com.didi.soda.customer.flutter.plugin.CustomerBasePlugin;
import com.didi.soda.customer.flutter.plugin.listener.OnPluginResultListener;
import com.didi.soda.manager.base.ICustomerPayManager;
import com.didi.universal.pay.biz.model.PayStatusModel;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016¨\u0006\r"}, mo175978d2 = {"com/didi/soda/order/flutterpage/OrderServicePlugin$goToPay$1", "Lcom/didi/soda/manager/base/ICustomerPayManager$PayCallback;", "onThirdPayStart", "", "channelId", "", "payFail", "code", "msg", "", "statusModel", "Lcom/didi/universal/pay/biz/model/PayStatusModel;", "paySucceed", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderServicePlugin.kt */
public final class OrderServicePlugin$goToPay$1 implements ICustomerPayManager.PayCallback {
    final /* synthetic */ String $pageId;
    final /* synthetic */ MethodChannel.Result $result;
    final /* synthetic */ OrderServicePlugin this$0;

    public void onThirdPayStart(int i) {
    }

    OrderServicePlugin$goToPay$1(MethodChannel.Result result, OrderServicePlugin orderServicePlugin, String str) {
        this.$result = result;
        this.this$0 = orderServicePlugin;
        this.$pageId = str;
    }

    public void payFail(int i, String str, PayStatusModel payStatusModel) {
        int i2 = i != -1 ? i != 2 ? 3 : 1 : 4;
        Map hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("message", str);
        hashMap.put(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, Integer.valueOf(i2));
        hashMap.put("paySDKErrorStandardType", Integer.valueOf(i));
        this.$result.success(hashMap);
    }

    public void paySucceed() {
        if (!this.this$0.getListeners().isEmpty()) {
            CustomerBasePlugin.notifyAllObserver$default(this.this$0, Intrinsics.stringPlus(OrderServicePlugin.THIRD_PAY_SUCCESS, this.$pageId), (Map) null, (OnPluginResultListener) null, 6, (Object) null);
        }
        Map hashMap = new HashMap();
        hashMap.put(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, 2);
        this.$result.success(hashMap);
    }
}
