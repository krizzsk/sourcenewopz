package com.didi.soda.customer;

import android.app.Activity;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.utils.IMBusinessConfig;
import com.didi.sdk.app.delegate.ActivityDelegate;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.debug.CustomerToolBoxUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({ActivityDelegate.class})
public class CustomerActivityDelegate extends ActivityDelegate {
    public void onCreate(Activity activity) {
        super.onCreate(activity);
        GlobalContext.setContext(activity);
        CustomerToolBoxUtil.initToolBox(activity.getApplication());
        CustomerToolBoxUtil.initExternalParams();
        IMBusinessConfig iMBusinessConfig = new IMBusinessConfig();
        iMBusinessConfig.setNeedSceneCommonWord(true);
        iMBusinessConfig.setLocationTopScheme("taxis99OneTravel://soda");
        IMEngine.registerBusinessConfig(activity, 601, iMBusinessConfig);
    }
}
