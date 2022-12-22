package com.didi.entrega.customer.application;

import android.app.Application;
import com.didi.sdk.app.delegate.ApplicationDelegate;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider(alias = "EntregaApplicationDelegate", value = {ApplicationDelegate.class})
public class EntregaApplicationDelegate extends ApplicationDelegate {
    public void onCreate(Application application) {
        super.onCreate(application);
    }
}
