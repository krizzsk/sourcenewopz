package com.didi.map.setting.common.data;

import java.util.List;

public class MapSettingListInfo {
    public static final int ICON_LEFT = 1;
    public static final int ICON_NONE = 3;
    public static final int ICON_RIGHT = 2;
    public int iconPosition;
    public boolean isItemEnable;
    public List<MapSettingItemInfo> itemInfoList;
    public int lineColor;
    public int textGrayColor;
    public int textNormalColor;
}
