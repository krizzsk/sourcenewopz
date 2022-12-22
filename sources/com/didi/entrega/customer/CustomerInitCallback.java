package com.didi.entrega.customer;

import android.app.Application;
import android.content.Context;
import com.didi.entrega.customer.app.CustomerActivityManager;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.p112im.ImMessageHelper;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.entrega.customer.foundation.tracker.error.OmegaErrorHandler;
import com.didi.entrega.customer.service.CustomerServiceHelper;
import com.didi.entrega.customer.service.CustomerServiceIRegister;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.timemachine.CustomerTimeMachineConfig;
import com.didi.entrega.customer.timemachine.TimeMachineEngine;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.foundation.sdk.location.LocationService;
import com.didi.sdk.app.business.BusinessInitCallback;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.Map;

@ServiceProvider(alias = "sodaEntrega", value = {BusinessInitCallback.class})
public class CustomerInitCallback extends BusinessInitCallback implements CustomerServiceIRegister {

    /* renamed from: a */
    private static final String f19636a = CustomerInitCallback.class.getSimpleName();

    public void onSyncInit(Context context) {
        LogUtil.m14765i(f19636a, "闪送初始化");
        CustomerServiceManager.init(this);
        TimeMachineEngine.getInstance().init(new CustomerTimeMachineConfig());
        CustomerManagerLoader.init();
        CustomerActivityManager.getInstance().init((Application) context.getApplicationContext());
        ImMessageHelper.getInstance().setRiderCommonWords(context);
        LocationService.getInstance().startLocation(context);
        ErrorTracker.init(new OmegaErrorHandler());
    }

    public Map<Class, Class> getRegisterService() {
        return CustomerServiceHelper.getRegisterService();
    }
}
