package com.didi.sdk.global.sign;

import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.enterprise.util.EnterpriseUtil;

public class BaseDataConverter {
    protected static int getStatus(int i, boolean z, DidiGlobalPayMethodListData.Entrance entrance) {
        if (entrance == DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION && i == 121) {
            z = EnterpriseUtil.isEnterpriseSigned();
        }
        if (i == 153 || i == 154) {
            return 1;
        }
        return z ? 1 : 0;
    }

    protected static boolean getIsSufficient(DidiGlobalPayMethodListData.PayMethodInfo payMethodInfo, DidiGlobalPayMethodListData.Entrance entrance) {
        if (entrance != DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION) {
            return true;
        }
        return payMethodInfo.isSufficient;
    }
}
