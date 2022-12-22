package com.didi.sdk.app;

import android.app.Activity;
import android.content.Intent;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({MainActivityIntentFilter.class})
public class RouterIntentFilter implements MainActivityIntentFilter {
    public static final String ROUTER_URL_KEY = "global_router_url";

    public boolean doFilter(Intent intent, Activity activity, BusinessContextHelper businessContextHelper) {
        String stringExtra;
        if (intent == null || (stringExtra = intent.getStringExtra(ROUTER_URL_KEY)) == null) {
            return false;
        }
        Logger logger = LoggerFactory.getLogger("RouterIntentFilter");
        logger.debug("mainActivity get router url = " + stringExtra, new Object[0]);
        DRouter.build(stringExtra).start(activity);
        return false;
    }
}
