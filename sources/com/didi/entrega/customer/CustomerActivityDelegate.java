package com.didi.entrega.customer;

import android.app.Activity;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.sdk.app.delegate.ActivityDelegate;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({ActivityDelegate.class})
public class CustomerActivityDelegate extends ActivityDelegate {
    public void onCreate(Activity activity) {
        super.onCreate(activity);
        GlobalContext.setContext(activity);
    }
}
