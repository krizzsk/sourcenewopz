package com.didi.entrega.bill.page;

import com.didi.entrega.customer.flutter.plugin.listener.OnPluginResultListener;
import com.didi.entrega.manager.base.ICustomerPayManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/entrega/bill/page/CustomerBillPage$billServiceListener$1$callPlugin$2$1", "Lcom/didi/entrega/manager/base/ICustomerPayManager$PayCallback;", "onThirdPayStart", "", "channelId", "", "payFail", "code", "msg", "", "paySucceed", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBillPage.kt */
public final class CustomerBillPage$billServiceListener$1$callPlugin$2$1 implements ICustomerPayManager.PayCallback {
    final /* synthetic */ OnPluginResultListener $resultListener;

    public void onThirdPayStart(int i) {
    }

    CustomerBillPage$billServiceListener$1$callPlugin$2$1(OnPluginResultListener onPluginResultListener) {
        this.$resultListener = onPluginResultListener;
    }

    public void payFail(int i, String str) {
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("payResultCode", 0);
        map.put("paySDKErrorCode", Integer.valueOf(i));
        map.put("message", str);
        OnPluginResultListener onPluginResultListener = this.$resultListener;
        if (onPluginResultListener != null) {
            onPluginResultListener.onResult(hashMap);
        }
    }

    public void paySucceed() {
        HashMap hashMap = new HashMap();
        hashMap.put("payResultCode", 1);
        OnPluginResultListener onPluginResultListener = this.$resultListener;
        if (onPluginResultListener != null) {
            onPluginResultListener.onResult(hashMap);
        }
    }
}
