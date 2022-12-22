package com.didi.soda.home.efo.detail;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.compose.action.ActionInterceptListener;
import com.didi.soda.customer.flutter.plugin.listener.OnPluginResultListener;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/home/efo/detail/DiscountDetailPluginListener$onRejectStrategy$1$1", "Lcom/didi/soda/customer/compose/action/ActionInterceptListener;", "onActionIntercept", "", "intercept", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DiscountDetailPluginListener.kt */
public final class DiscountDetailPluginListener$onRejectStrategy$1$1 implements ActionInterceptListener {
    final /* synthetic */ OnPluginResultListener $resultListener;
    final /* synthetic */ ScopeContext $scopeContext;

    DiscountDetailPluginListener$onRejectStrategy$1$1(OnPluginResultListener onPluginResultListener, ScopeContext scopeContext) {
        this.$resultListener = onPluginResultListener;
        this.$scopeContext = scopeContext;
    }

    public void onActionIntercept(boolean z) {
        if (!z) {
            Map hashMap = new HashMap();
            hashMap.put(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, 0);
            OnPluginResultListener onPluginResultListener = this.$resultListener;
            if (onPluginResultListener != null) {
                onPluginResultListener.onResult(hashMap);
            }
            Object object = this.$scopeContext.getObject("PageName");
            String str = object instanceof String ? (String) object : null;
            OmegaTracker.Builder create = OmegaTracker.Builder.create("sailing_c_x_page_return_ck");
            if (str == null) {
                str = "";
            }
            create.addEventParam("from", str).build().track();
        }
    }
}
