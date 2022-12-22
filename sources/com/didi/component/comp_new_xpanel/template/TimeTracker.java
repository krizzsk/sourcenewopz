package com.didi.component.comp_new_xpanel.template;

import com.didi.component.business.util.CarOrderHelper;
import com.didi.sdk.util.GlobalOmegaUtils;
import java.util.HashMap;

public class TimeTracker {

    /* renamed from: a */
    private long f12297a = 0;

    public void trackNullTitle(String str) {
        if (str == null || !"".equals(str.trim())) {
            if (this.f12297a != 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("time", Long.valueOf((System.currentTimeMillis() - this.f12297a) / 1000));
                hashMap.put("id", CarOrderHelper.getOrderId());
                hashMap.put("substatus", Integer.valueOf(CarOrderHelper.getOrderSubStatus()));
                hashMap.put("status", Integer.valueOf(CarOrderHelper.getOrderStatus()));
                GlobalOmegaUtils.trackEvent("ibt_xpanel_msg_title_null_bt", hashMap);
                this.f12297a = 0;
            }
        } else if (this.f12297a == 0) {
            this.f12297a = System.currentTimeMillis();
        }
    }
}
