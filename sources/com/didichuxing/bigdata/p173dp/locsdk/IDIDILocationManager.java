package com.didichuxing.bigdata.p173dp.locsdk;

import com.didichuxing.bigdata.p173dp.locsdk.Config;
import java.io.File;
import java.util.List;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.IDIDILocationManager */
public interface IDIDILocationManager {
    void enableMockLocation(boolean z);

    String getAppid();

    String getBuildBranch();

    String getBuildVersion();

    int getCellStatus();

    DIDILocationUpdateOption getDefaultLocationUpdateOption();

    int getGpsStatus();

    DIDILocation getLastKnownLocation();

    String getListenersInfo();

    List<DIDILocation> getRecentLocation(int i);

    String getVersion();

    int getWifiStatus();

    boolean isGpsLocationAvailable();

    boolean isHighAccuracyLocationAvailable();

    boolean isLocationSwitchOff();

    boolean isNetLocationAvailable();

    boolean isRunning();

    int removeLocationUpdates(DIDILocationListener dIDILocationListener);

    @Deprecated
    int requestLocationUpdateOnce(DIDILocationListener dIDILocationListener, DIDILocationUpdateOnceParam dIDILocationUpdateOnceParam, int i);

    int requestLocationUpdateOnce(DIDILocationListener dIDILocationListener, String str);

    @Deprecated
    int requestLocationUpdateOnce(DIDILocationListener dIDILocationListener, String str, int i);

    int requestLocationUpdates(DIDILocationListener dIDILocationListener, DIDILocationUpdateOption dIDILocationUpdateOption);

    @Deprecated
    void setApolloToggleName(String str);

    void setAppVersionName(String str);

    void setAppid(String str);

    void setCoordinateType(int i);

    void setLocateMode(Config.LocateMode locateMode);

    void setLocatePermissonStrategy(Config.LocatePermissonStrategy locatePermissonStrategy);

    @Deprecated
    void setLogPath(File file);

    void setOnlyOSLocationAbroad(boolean z);

    void setPhonenum(String str);

    void setTimeServiceImpl(Object obj);

    @Deprecated
    void setUseFlp(boolean z);

    int startNavLocate(DIDILocationListener dIDILocationListener, String str);

    void stopNavLocate();
}
