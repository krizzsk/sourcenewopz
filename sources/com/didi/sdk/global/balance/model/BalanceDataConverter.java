package com.didi.sdk.global.balance.model;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.balance.model.bean.TopUpMethodDetail;

@Deprecated
public class BalanceDataConverter {

    /* renamed from: a */
    private static final String f36022a = "Balance";

    public static TopUpMethodItemInfo convertToPayMethodItemInfo(TopUpMethodDetail topUpMethodDetail) {
        TopUpMethodItemInfo topUpMethodItemInfo = new TopUpMethodItemInfo();
        if (topUpMethodDetail == null) {
            SystemUtils.log(6, "Balance", "Trying to convert from null", (Throwable) null, "com.didi.sdk.global.balance.model.BalanceDataConverter", 28);
            return topUpMethodItemInfo;
        }
        topUpMethodItemInfo.channelId = 120;
        topUpMethodItemInfo.name = topUpMethodDetail.channelName;
        topUpMethodItemInfo.iconUrl = topUpMethodDetail.channelIcon;
        topUpMethodItemInfo.description = "";
        topUpMethodItemInfo.valuePrefix = topUpMethodDetail.discountMainDesc;
        topUpMethodItemInfo.value = topUpMethodDetail.discountSubDesc;
        return topUpMethodItemInfo;
    }
}
