package com.dmap.navigation.engine.core;

import com.didi.map.base.TrafficEventRoutePoint;
import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.base.route.IMatchRouteInfo;
import com.dmap.navigation.base.route.IRoute;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface INaviEngine {
    void addMoreRoutes(List<IRoute> list);

    void changeNaviStutas(int i);

    void closeCurrentMJO();

    void forcePassedNext();

    BigInteger getCurrentRouteId();

    Map<String, Long> getGpsHealthInfo();

    IMatchRouteInfo getMatchRouteInfo();

    String getNGVoiceContent(int i);

    IRoute getRouteById(BigInteger bigInteger);

    void init();

    void naviPushData(int i, String str);

    void playMannalVoice();

    void playOpenningVoice(INaviLocation iNaviLocation);

    void selectRoute(BigInteger bigInteger, boolean z);

    void setDayNight(boolean z);

    void setMJOEnable(boolean z);

    void setNaviEventListener(INaviEventListener iNaviEventListener);

    void setTrafficEventPoints(BigInteger bigInteger, List<TrafficEventRoutePoint> list);

    void setVecEnlargeInfo(int i, int i2);

    void setVoiceAssistantState(int i);

    void startNavi(IRoute iRoute, INaviLocation iNaviLocation);

    void stopNavi();

    void updateAppAction(int i);

    void updateLocation(INaviLocation iNaviLocation);

    void updateNaviScene();

    void updateTrafficEtas(int i, int[] iArr);

    void updateTrafficStatus(byte[] bArr);
}
