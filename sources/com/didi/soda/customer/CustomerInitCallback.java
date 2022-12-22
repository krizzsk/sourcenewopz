package com.didi.soda.customer;

import android.app.Application;
import android.content.Context;
import com.didi.foundation.sdk.location.LocationService;
import com.didi.sdk.app.business.BusinessInitCallback;
import com.didi.soda.customer.app.CustomerActivityManager;
import com.didi.soda.customer.blocks.BlocksManager;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.p164im.ImMessageHelper;
import com.didi.soda.customer.service.CustomerServiceHelper;
import com.didi.soda.customer.service.CustomerServiceIRegister;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.timemachine.CustomerTimeMachineConfig;
import com.didi.soda.customer.timemachine.TimeMachineEngine;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@ServiceProvider(alias = "soda", value = {BusinessInitCallback.class})
public class CustomerInitCallback extends BusinessInitCallback implements CustomerServiceIRegister {

    /* renamed from: a */
    private static final String f40149a = CustomerInitCallback.class.getSimpleName();

    public void onSyncInit(Context context) {
        LogUtil.m29104i(f40149a, "外卖初始化");
        InitOnceUtils.Companion.initOnce(new Function0() {
            public final Object invoke() {
                return CustomerInitCallback.this.m28560a();
            }
        });
        TimeMachineEngine.getInstance().init(new CustomerTimeMachineConfig());
        CustomerManagerLoader.init();
        CustomerActivityManager.getInstance().init((Application) context.getApplicationContext());
        ImMessageHelper.getInstance().setMerchantCommonWords(context);
        ImMessageHelper.getInstance().setRiderCommonWords(context);
        BlocksManager.INSTANCE.initBlocks(context);
        LocationService.getInstance().startLocation(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ Unit m28560a() {
        CustomerServiceManager.init(this);
        return Unit.INSTANCE;
    }

    public Map<Class, Class> getRegisterService() {
        return CustomerServiceHelper.getRegisterService();
    }
}
