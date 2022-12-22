package com.didi.sdk.global.sign.model.convert;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.enterprise.util.EnterpriseUtil;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.model.local.PaySelPageData;
import com.didi.sdk.global.sign.model.server.PayMethodPageResponse;
import com.didi.sdk.util.TextUtil;
import java.util.Iterator;

public class SelectPageInfoRefresher {
    public static boolean refreshPayMethodStatus(PaySelPageData paySelPageData, int i, String str) {
        Iterator<PaySelItemData> it = paySelPageData.payMethodList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PaySelItemData next = it.next();
            if (next.channelId == i && m25596a(str, next.cardIndex) && i == 121) {
                if (EnterpriseUtil.isEnterpriseSigned()) {
                    next.status = 1;
                    next.style = SelectPageInfoConverter.getButtonStyle(next, DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION);
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m25596a(String str, String str2) {
        if (TextUtil.isEmpty(str)) {
            return TextUtil.isEmpty(str2);
        }
        if (TextUtil.isEmpty(str2)) {
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static boolean refresh(PaySelPageData paySelPageData, PayMethodPageResponse payMethodPageResponse, int i, String str) {
        if (payMethodPageResponse == null || payMethodPageResponse.data == null || payMethodPageResponse.data.allEntries == null || payMethodPageResponse.data.allEntries.size() == 0) {
            SystemUtils.log(6, "wallet", "invalid response data, nothing to refresh", (Throwable) null, "com.didi.sdk.global.sign.model.convert.SelectPageInfoRefresher", 87);
            return false;
        }
        PaySelItemData a = m25592a(payMethodPageResponse, i, str);
        if (a == null) {
            SystemUtils.log(6, "wallet", "No specific pay method in server response, nothing to refresh", (Throwable) null, "com.didi.sdk.global.sign.model.convert.SelectPageInfoRefresher", 93);
            return false;
        } else if (m25595a(paySelPageData, i, str, a)) {
            return true;
        } else {
            m25593a(a, paySelPageData);
            m25594a(paySelPageData, a);
            return true;
        }
    }

    /* renamed from: a */
    private static void m25593a(PaySelItemData paySelItemData, PaySelPageData paySelPageData) {
        int i = paySelItemData.channelId;
        paySelItemData.style = SelectPageInfoConverter.getButtonStyle(paySelItemData, DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION);
        for (PaySelItemData next : paySelPageData.payMethodList) {
            if (next.channelId == i) {
                paySelItemData.combineTag = next.combineTag;
                paySelItemData.allowedCombineTags.addAll(next.allowedCombineTags);
                paySelItemData.isSufficient = next.isSufficient;
                return;
            }
        }
    }

    /* renamed from: a */
    private static boolean m25595a(PaySelPageData paySelPageData, int i, String str, PaySelItemData paySelItemData) {
        for (PaySelItemData next : paySelPageData.payMethodList) {
            if (next.channelId == i && m25596a(next.cardIndex, str)) {
                next.status = paySelItemData.status;
                next.style = paySelItemData.style;
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static void m25594a(PaySelPageData paySelPageData, PaySelItemData paySelItemData) {
        int i = 0;
        while (i < paySelPageData.payMethodList.size()) {
            if (paySelPageData.payMethodList.get(i).channelId != paySelItemData.channelId) {
                i++;
            } else {
                paySelPageData.payMethodList.add(i + 1, paySelItemData);
                return;
            }
        }
        paySelPageData.payMethodList.add(paySelItemData);
    }

    /* renamed from: a */
    private static PaySelItemData m25592a(PayMethodPageResponse payMethodPageResponse, int i, String str) {
        PaySelPageData convert = SettingPageInfoConverter.convert(payMethodPageResponse);
        if (!(convert == null || convert.payMethodList == null || convert.payMethodList.isEmpty())) {
            for (PaySelItemData next : convert.payMethodList) {
                if (next.channelId == i && m25596a(next.cardIndex, str)) {
                    return next;
                }
            }
        }
        return null;
    }
}
