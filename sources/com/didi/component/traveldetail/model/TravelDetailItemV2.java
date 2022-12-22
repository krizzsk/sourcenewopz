package com.didi.component.traveldetail.model;

import android.text.TextUtils;

public class TravelDetailItemV2 {
    public static final String STATUS_ARRIVED = "1";
    public static final String STATUS_NOT_ARRIVE = "0";
    public static final String STATUS_ON_SERVICE = "2";
    public static final String TYPE_END_ADDRESS = "2";
    public static final String TYPE_START_ADDRESS = "1";
    public static final String TYPE_WAY_POINT_ADDRESS = "3";
    public String addressType;
    public int iconRes;
    public boolean isPlay = false;
    public boolean needAsh = false;
    public String title;
    public int titleColor;

    public boolean isStartAddress() {
        return TextUtils.equals("1", this.addressType);
    }
}
