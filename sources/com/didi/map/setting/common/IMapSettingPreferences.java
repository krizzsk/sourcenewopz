package com.didi.map.setting.common;

import java.util.TreeSet;

public interface IMapSettingPreferences {
    int getBusinessID();

    String getCountCode();

    long getDriverID();

    boolean getGoogleLocalNav();

    boolean getInAppNavVoiceOpen();

    String getLastSelectedNav();

    boolean getNavAutoMock();

    int getNavDayNightMode();

    boolean getNavDefaultOpen();

    boolean getNavRemember();

    String getNavSelectedPath();

    int getNavigationDirection();

    boolean getOpenGuideLine();

    boolean getOpenRouteTraffic();

    boolean getShouldShowTrafficStatusBar();

    boolean getTrafficStatusIntroShown();

    boolean getUserCloseAutoNav();

    boolean getWindowShow();

    TreeSet<Long> getYandexNaviUseTimes();

    boolean hasShowYandexMapTips();

    boolean hasShowYandexMapTipsInOrder();

    boolean hasShowYandexNavTips();

    boolean hasShowYandexNavTipsInOrder();

    boolean hasUserSettingNav();

    boolean isHawaii();

    void setBusinessID(int i, long j);

    void setCountryCode(String str);

    void setGoogleLocalNav(boolean z);

    void setGuideLine(boolean z);

    void setInAppNavVoiceOpen(boolean z);

    void setIsHawaii(boolean z);

    void setLastSelectedNav(String str);

    void setNavAutoMock(boolean z);

    void setNavDayNightMode(int i);

    void setNavDefaultOpen(boolean z);

    void setNavRemember(boolean z);

    void setNavSelectedPath(String str);

    void setNavigationDirection(int i);

    void setRouteTraffic(boolean z);

    void setShouldShowTrafficStatusBar(boolean z);

    void setShowYandexMapTips(boolean z);

    void setShowYandexMapTipsInOrder(boolean z);

    void setShowYandexNavTips(boolean z);

    void setShowYandexNavTipsInOrder(boolean z);

    void setTrafficStatusIntroShown(boolean z);

    void setUserCloseAutoNav(boolean z);

    void setWindowShow(boolean z);

    void setYandexNaviUseTimes(TreeSet<Long> treeSet);
}
