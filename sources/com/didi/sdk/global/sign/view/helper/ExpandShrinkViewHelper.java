package com.didi.sdk.global.sign.view.helper;

import com.didi.sdk.global.sign.model.local.PaySelItemData;
import java.util.List;

public class ExpandShrinkViewHelper {
    public static int getMaxDisplayCardIndex(List<PaySelItemData> list, boolean z) {
        int a = z ? m25716a(list) : m25717b(list);
        int i = 0;
        int i2 = 0;
        for (PaySelItemData paySelItemData : list) {
            if (paySelItemData.channelId == 150) {
                i++;
            }
            if (i > a) {
                break;
            }
            i2++;
        }
        return i2;
    }

    public static boolean isShowSwitchView(List<PaySelItemData> list) {
        return list.size() > 6 && m25716a(list) > 1;
    }

    /* renamed from: a */
    private static int m25716a(List<PaySelItemData> list) {
        if (list == null) {
            return 0;
        }
        int i = 0;
        for (PaySelItemData next : list) {
            if (next != null && next.channelId == 150) {
                i++;
            }
        }
        return Math.max(i - 1, 0);
    }

    /* renamed from: b */
    private static int m25717b(List<PaySelItemData> list) {
        int i;
        if (isShowSwitchView(list)) {
            i = 6 - (list.size() - m25716a(list));
        } else {
            i = m25716a(list);
        }
        return Math.max(0, i);
    }
}
