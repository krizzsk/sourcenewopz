package com.didi.rlab.uni_foundation.map;

public interface MapNavigationService {
    boolean canNavGoogle();

    boolean canNavWaze();

    void closeMapNavigation();

    long getUserSettingNavigationType();

    void gotoDownloadMapApp(long j);

    boolean isDowngradeMapNavigation();

    void openMapOutAppNavigation(double d, double d2, String str, long j);

    void selectNavigationType(long j);

    void setMapNavigationBestView();

    void setMapNavigationDestination(double d, double d2);

    void setMapNavigationOverView();

    void setMapNavigationPadding(double d, double d2, double d3, double d4);

    void setMapNavigationRecenter();

    void startMapNavigation(double d, double d2);
}
