package com.didi.rlab.uni_im_map.map;

public interface NavigationIMService {
    boolean canNavGoogle();

    boolean canNavWaze();

    void closeMapNavigation();

    long getUserSettingNavigationType();

    void gotoDownloadMapApp(long j);

    void openMapOutAppNavigation(double d, double d2, String str);

    void selectNavigationType(long j);

    void setMapNavigationBestView();

    void setMapNavigationOverView();

    void setMapNavigationRecenter();

    void setNavigationPadding(double d, double d2, double d3, double d4);

    void startMapNavigation(double d, double d2);
}
