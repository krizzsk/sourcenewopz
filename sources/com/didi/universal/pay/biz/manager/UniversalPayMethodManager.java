package com.didi.universal.pay.biz.manager;

import android.text.TextUtils;
import com.didi.universal.pay.biz.model.UniversalPayItemModel;
import java.util.List;

public class UniversalPayMethodManager {
    /* renamed from: a */
    private static String m32379a(int i) {
        if (i == 161) {
            return "didicredit";
        }
        if (i == 162) {
            return "spgateway";
        }
        switch (i) {
            case 108:
                return "experiencecard";
            case 115:
                return "rechargeablecard";
            case 118:
                return "advance";
            case 121:
                return "firm";
            case 123:
                return "card";
            case 144:
                return "fastqqpay";
            case 150:
                return "adyen";
            case 152:
                return "paypal";
            case 166:
                return "ddpay";
            case 190:
                return "nineninepay";
            case 192:
                return "mpgs";
            case 9100:
                return "familypay";
            default:
                switch (i) {
                    case 126:
                        return "balance";
                    case 127:
                        return "wechat";
                    case 128:
                        return "alipay";
                    default:
                        switch (i) {
                            case 132:
                                return "qqpay";
                            case 133:
                            case 134:
                                return "fastwechat";
                            case 135:
                                return "zsdebitcard";
                            case 136:
                                return "fastzsdebitcard";
                            default:
                                switch (i) {
                                    case 170:
                                        return "alipayroam";
                                    case 171:
                                        return "wechatroam";
                                    case 172:
                                        return "alipayhk";
                                    case 173:
                                        return "wechathk";
                                    default:
                                        return "null";
                                }
                        }
                }
        }
    }

    public static String getPayMethod(List<UniversalPayItemModel> list) {
        String str = "";
        if (!(list == null || list.size() == 0)) {
            for (UniversalPayItemModel next : list) {
                if (next.getState() == 1) {
                    if (TextUtils.isEmpty(str)) {
                        str = str + m32379a(next.f45101id);
                    } else {
                        str = str + "," + m32379a(next.f45101id);
                    }
                }
            }
        }
        return str;
    }

    public static String getNewPayMethod(List<UniversalPayItemModel> list, int i) {
        if (list == null || list.size() == 0 || UniversalPayChannelManager.isPayChannelEnabled(i)) {
            return "";
        }
        String a = m32379a(i);
        for (UniversalPayItemModel next : list) {
            if (next.getState() == 1) {
                if (UniversalPayChannelManager.isPlatformPayChannel(i)) {
                    a = a + "," + next.f45101id;
                } else if (UniversalPayChannelManager.isThirdPayChannel(i) && UniversalPayChannelManager.isPlatformPayChannel(next.f45101id)) {
                    a = a + "," + next.f45101id;
                }
            }
        }
        return a;
    }
}
