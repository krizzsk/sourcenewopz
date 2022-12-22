package com.didi.travel.psnger.store;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.utils.OmegaUtils;
import com.didichuxing.mas.sdk.quality.init.MASSDK;
import com.didichuxing.mas.sdk.quality.report.customevent.CustomEventMap;

public class DDTravelOrderStore {

    /* renamed from: a */
    private static ICarOrder f44231a;

    public static ICarOrder getOrder() {
        return f44231a;
    }

    public static void setOrder(ICarOrder iCarOrder) {
        String str;
        f44231a = iCarOrder;
        String str2 = "0";
        if (iCarOrder == null) {
            OmegaUtils.removeGlobal("g_OrderId");
            str = str2;
        } else {
            OmegaUtils.putGlobal("g_OrderId", getOid());
            str2 = String.valueOf(f44231a.getStatus());
            str = String.valueOf(f44231a.getSubStatus());
        }
        MASSDK.addCustomEvent(CustomEventMap.PUB_BIZ, "status", str2, false);
        MASSDK.addCustomEvent(CustomEventMap.PUB_BIZ, ParamKeys.PARAM_SUB_STATUS, str, false);
    }

    public static String getOid() {
        ICarOrder iCarOrder = f44231a;
        return iCarOrder != null ? iCarOrder.getOid() : "";
    }
}
