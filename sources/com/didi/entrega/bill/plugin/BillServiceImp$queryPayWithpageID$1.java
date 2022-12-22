package com.didi.entrega.bill.plugin;

import com.didi.entrega.customer.flutter.plugin.listener.OnPluginResultListener;
import com.didi.entrega.customer.foundation.util.GsonUtil;
import com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/entrega/bill/plugin/BillServiceImp$queryPayWithpageID$1", "Lcom/didi/entrega/customer/flutter/plugin/listener/OnPluginResultListener;", "onResult", "", "value", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillServiceImp.kt */
public final class BillServiceImp$queryPayWithpageID$1 implements OnPluginResultListener {
    final /* synthetic */ GLEUniBillNativeModuleService.Result<String> $result;

    BillServiceImp$queryPayWithpageID$1(GLEUniBillNativeModuleService.Result<String> result) {
        this.$result = result;
    }

    public void onError(String str, String str2, Object obj) {
        OnPluginResultListener.DefaultImpls.onError(this, str, str2, obj);
    }

    public void onResult(Object obj) {
        if (obj != null) {
            GLEUniBillNativeModuleService.Result<String> result = this.$result;
            if (result != null) {
                result.success(GsonUtil.toJson(obj));
                return;
            }
            return;
        }
        GLEUniBillNativeModuleService.Result<String> result2 = this.$result;
        if (result2 != null) {
            result2.success(null);
        }
    }
}
