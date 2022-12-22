package com.didi.map.sdk.departure.internal.bubble;

import android.text.TextUtils;
import com.didi.map.sdk.departure.DepartureAddress;

public class RecBubbleController {
    public static boolean hasBubbleDesc(DepartureAddress departureAddress) {
        return (departureAddress == null || departureAddress.getAddress() == null || departureAddress.getAddress().extend_info == null || TextUtils.isEmpty(departureAddress.getAddress().extend_info.bubbleDesc)) ? false : true;
    }
}
