package com.didi.component.business.receiver;

import android.content.Intent;
import com.didi.component.business.recovery.GlobalOrderRecovery;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.DataAuthority;
import com.didi.sdk.app.DataPatternMatcherPart;
import com.didi.sdk.app.DidiBroadcastReceiverImpl;
import com.didi.sdk.app.IntentFilter;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider(alias = "ride", value = {DidiBroadcastReceiverImpl.class})
@IntentFilter(actions = {"com.xiaojukeji.action.ORDER_RECOVER", "com.xiaojukeji.action.ON_THE_WAY", "com.xiaojukeji.action.NO_RECOVER"}, dataAuthorities = {@DataAuthority("extended")}, dataPaths = {@DataPatternMatcherPart("/recover"), @DataPatternMatcherPart("/ontheway"), @DataPatternMatcherPart("/norecover")}, dataSchemes = {"OneReceiver"})
public class GlobalRecoverReceiver extends DidiBroadcastReceiverImpl {
    /* access modifiers changed from: protected */
    public void onReceive(BusinessContext businessContext, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (ReceiverConstant.ACTION_ONTHEWAY.equals(action)) {
                new GlobalOrderRecovery(businessContext).onHistoryOrderRecovery(intent);
            } else if (ReceiverConstant.ACTION_RECOVERY.equals(action)) {
                new GlobalOrderRecovery(businessContext).onCurrentOrderRecovery(intent, intent.getIntExtra("source", 2));
            } else if (ReceiverConstant.ACTION_NO_RECOVER.equals(action)) {
                new GlobalOrderRecovery(businessContext).onNoOrderRecovery(intent);
            }
        }
    }
}
