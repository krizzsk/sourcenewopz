package com.didi.address.util;

import android.text.TextUtils;
import com.didi.common.map.util.DLog;
import com.didi.sdk.address.address.entity.Address;

public class PoiidCompleteUtils {
    public static final String DEFAULT_POIID = "app_default_poiid";
    public static int count;

    public static void completePoiid(Address address) {
        if (CommonUtils.isValidLocation(address) && TextUtils.isEmpty(address.poiId)) {
            DLog.m7384d("SugAddress", "start address.poiid = null,address = " + address, new Object[0]);
            address.poiId = address.uid;
            if (TextUtils.isEmpty(address.poiId)) {
                StringBuilder sb = new StringBuilder();
                sb.append(DEFAULT_POIID);
                int i = count;
                count = i + 1;
                sb.append(i);
                address.poiId = sb.toString();
            }
        }
    }
}
