package com.didi.component.business.receiver;

import android.content.Context;
import android.content.Intent;
import com.didi.app.router.PageRouter;
import com.didi.component.business.recovery.GlobalOrderRecovery;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.DidiBroadcastReceiverImpl;
import com.didi.sdk.app.IntentFilter;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider(alias = "ride", value = {DidiBroadcastReceiverImpl.class})
@IntentFilter(actions = {"com.xiaojukeji.action.SERVICE"})
public class ServiceReceiver extends DidiBroadcastReceiverImpl {
    public static final String BID = "businessid";
    public static final String OID = "orderid";

    /* access modifiers changed from: protected */
    public void onReceive(BusinessContext businessContext, Intent intent) {
        Context context = businessContext.getContext();
        if (intent != null && context != null) {
            String stringExtra = intent.getStringExtra("orderid");
            int intExtra = intent.getIntExtra(BID, 0);
            if (intExtra > 0) {
                PageRouter.getInstance().startMainActivity(context, new Intent());
                new GlobalOrderRecovery(businessContext).recovery(intExtra, stringExtra, 2);
            }
        }
    }
}
