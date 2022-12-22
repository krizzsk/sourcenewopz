package com.didi.component.business.receiver;

import android.content.Intent;
import com.didi.component.business.recovery.GlobalOrderRecovery;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.DidiBroadcastReceiverImpl;
import com.didi.sdk.app.IntentFilter;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider(alias = "ride", value = {DidiBroadcastReceiverImpl.class})
@IntentFilter(actions = {"com.xiaojukeji.action.SAFETY"}, dataSchemes = {"OneReceiver"})
public class SafetyReceiver extends DidiBroadcastReceiverImpl {
    /* access modifiers changed from: protected */
    public void onReceive(BusinessContext businessContext, Intent intent) {
        if (intent != null) {
            new GlobalOrderRecovery(businessContext).updateSafeSwitch(intent);
        }
    }
}
