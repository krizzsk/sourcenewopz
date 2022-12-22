package com.didi.payment.utilities.entrance;

import android.content.Context;
import com.didi.payment.utilities.base.CsRouter;
import com.didi.sdk.global.utilities.IUtilitiesProxy;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({IUtilitiesProxy.class})
public class CsUtilitiesServiceProvider implements IUtilitiesProxy {
    public void startUtilitiesEntranceActivity(Context context) {
        CsRouter.startUtilitiesActivity(context);
    }
}
