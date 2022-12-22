package com.didi.sdk.global.balance.model;

@Deprecated
public class TopUpMethodItemInfo {
    public static final int STYLE_CLICK = 2;
    public static final int STYLE_SELECT = 1;
    public int channelId;
    public String description;
    public String iconUrl;
    public boolean isEnabled = true;
    public boolean isSelected = false;
    public boolean isShowRedDot = false;
    public boolean isSigned = false;
    public String name;
    public int style;
    public String value;
    public String valuePrefix;
}
