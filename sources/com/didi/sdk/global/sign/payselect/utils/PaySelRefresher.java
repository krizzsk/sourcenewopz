package com.didi.sdk.global.sign.payselect.utils;

import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.enterprise.util.EnterpriseUtil;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.model.local.PaySelPageData;
import com.didi.sdk.util.TextUtil;
import java.util.Iterator;

public class PaySelRefresher {
    public static boolean refreshPayMethodStatus(PaySelPageData paySelPageData, int i, String str) {
        Iterator<PaySelItemData> it = paySelPageData.payMethodList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PaySelItemData next = it.next();
            if (next.channelId == i && m25666a(str, next.cardIndex) && i == 121) {
                if (EnterpriseUtil.isEnterpriseSigned()) {
                    next.status = 1;
                    next.style = PayDataConverter.getButtonStyle(next, DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION);
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m25666a(String str, String str2) {
        if (TextUtil.isEmpty(str)) {
            return TextUtil.isEmpty(str2);
        }
        if (TextUtil.isEmpty(str2)) {
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }
}
