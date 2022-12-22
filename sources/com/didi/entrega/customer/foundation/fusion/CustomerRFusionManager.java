package com.didi.entrega.customer.foundation.fusion;

import android.app.Application;
import android.text.TextUtils;
import android.widget.TextView;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.ILocaleService;
import com.didi.entrega.customer.service.IToolsService;
import com.didi.rfusion.RFusion;
import com.didi.rfusion.config.RFFontDelegate;
import com.didi.rfusion.config.RFusionConfig;
import java.util.Map;

public final class CustomerRFusionManager {
    private CustomerRFusionManager() {
    }

    public static void initRFusion(Application application) {
        RFusion.init(new RFusionConfig.Builder(application).setLogger(new RFusionConfig.IRFusionLogger() {
            public void debug(String str, String str2) {
                LogUtil.m14761d(str, str2);
            }

            public void info(String str, String str2) {
                LogUtil.m14765i(str, str2);
            }
        }).setTracker(new RFusionConfig.IRFusionTracker() {
            public void track(String str, Map<String, Object> map) {
                if (!TextUtils.isEmpty(str) && map != null && map.size() > 0) {
                    OmegaTracker.Builder create = OmegaTracker.Builder.create(str);
                    for (Map.Entry next : map.entrySet()) {
                        create.addEventParam((String) next.getKey(), next.getValue());
                    }
                    create.build().track();
                }
            }
        }).setFontDelegate(GlobalContext.isEmbed() ? new RFFontDelegate() {
            public void setTypeface(TextView textView, int i) {
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypefaceForRF(textView, i);
            }
        } : null).build());
        if (!GlobalContext.isEmbed()) {
            RFusion.updateLocale(((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocale());
        }
    }
}
