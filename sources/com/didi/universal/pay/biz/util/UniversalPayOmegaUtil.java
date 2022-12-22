package com.didi.universal.pay.biz.util;

import android.text.TextUtils;
import com.didi.universal.pay.biz.model.UniversalPayItemModel;
import com.didi.universal.pay.sdk.method.model.DeductionInfo;
import java.util.List;

public class UniversalPayOmegaUtil {
    public static String getCoupon(DeductionInfo[] deductionInfoArr) {
        if (deductionInfoArr != null && deductionInfoArr.length > 0) {
            for (DeductionInfo deductionInfo : deductionInfoArr) {
                if (deductionInfo.type == 1) {
                    return deductionInfo.couponId;
                }
            }
        }
        return "";
    }

    public static String getPayChannel(List<UniversalPayItemModel> list) {
        if (list == null || list.size() <= 0) {
            return "";
        }
        String str = "";
        for (UniversalPayItemModel next : list) {
            if (next.getState() == 1) {
                if (TextUtils.isEmpty(str)) {
                    str = next.f45101id + "";
                } else {
                    str = str + "," + next.f45101id;
                }
            }
        }
        return str;
    }
}
