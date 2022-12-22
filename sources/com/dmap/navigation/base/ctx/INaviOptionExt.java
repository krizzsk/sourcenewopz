package com.dmap.navigation.base.ctx;

public interface INaviOptionExt extends INaviOption {
    public static final String KEY_GUIDE = "guide";
    public static final String KEY_MAIN_ROUTE = "main_route";
    public static final String KEY_MAIN_ROUTE_BUBBLE = "main_route_bubble";

    public interface OptionChangedListener {
        void onChanged(String str, String str2);
    }

    int getAvoidJamType();

    void setAvoidJamType(int i);

    void setMandatory(boolean z);

    void setOptionChangedListener(OptionChangedListener optionChangedListener);
}
