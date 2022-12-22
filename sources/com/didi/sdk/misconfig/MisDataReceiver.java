package com.didi.sdk.misconfig;

import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.event.CarInfoUpdateEvent;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.misconfig.p153v2.utils.ConfUtil;
import com.didi.sdk.util.EventKeys;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MisDataReceiver implements IMisDataReceiver {

    /* renamed from: a */
    private Logger f36806a = LoggerFactory.getLogger("MisReceiverComponent");

    /* renamed from: b */
    private HashMap<String, BusinessContext> f36807b = new HashMap<>();

    public void init() {
        EventBus.getDefault().register(this);
    }

    public void addContext(String str, BusinessContext businessContext) {
        if (businessContext != null && this.f36807b.get(str) == null) {
            this.f36807b.put(str, businessContext);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceive(CarInfoUpdateEvent carInfoUpdateEvent) {
        if (carInfoUpdateEvent != null && EventKeys.MisConfig.MIS_DATA_FROM_UPDATE.equalsIgnoreCase(carInfoUpdateEvent.tag)) {
            Logger logger = this.f36806a;
            logger.debug("onReceive CarInfoUpdateEvent result = " + carInfoUpdateEvent.result, new Object[0]);
            if (this.f36807b.size() > 0) {
                for (String str : this.f36807b.keySet()) {
                    BusinessContext businessContext = this.f36807b.get(str);
                    businessContext.setCountryInfo(ConfProxy.getInstance().getCountryInfo());
                    businessContext.setMisDataFrom(carInfoUpdateEvent.result);
                }
            }
            ConfUtil.dispatchCarInfoUpdate(carInfoUpdateEvent.result, carInfoUpdateEvent.seqId, carInfoUpdateEvent.versionChanged);
        }
    }

    public void destory() {
        EventBus.getDefault().unregister(this);
        this.f36807b.clear();
    }
}
