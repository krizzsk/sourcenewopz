package com.didi.soda.customer.debug;

import android.app.Application;
import com.didi.common.map.model.LatLng;
import com.didi.soda.customer.foundation.rpc.net.SFRpcResult;
import java.lang.reflect.Method;

public interface IToolBox {
    int getCityId();

    long getCountyGroupId();

    long getCountyId();

    LatLng getCurrentLatLng();

    boolean getIsBlockDebugOn();

    boolean getIsSkipGoogle();

    double getLat();

    double getLng();

    SFRpcResult getLocalMockData(Method method);

    String getLoginMode();

    String getMockHostApi();

    int getPoiCityId();

    long getPoiCountyGroupId();

    long getPoiCountyId();

    double getPoiLat();

    double getPoiLng();

    String getTransApolloName();

    void initExternalParams();

    void initToolBox(Application application);

    void openMockLocation();

    void setUserToken(String str);

    boolean shouldMockApi();
}
