package com.didi.entrega.customer.debug;

import android.app.Application;
import com.didi.common.map.model.LatLng;
import com.didi.entrega.customer.foundation.rpc.ApiUrlFactory;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcResult;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.lang.reflect.Method;

@ServiceProvider(alias = "release", value = {IToolBox.class})
public class ReleaseToolBox implements IToolBox {
    public boolean getIsSkipGoogle() {
        return false;
    }

    public SFRpcResult getLocalMockData(Method method) {
        return null;
    }

    public String getLoginMode() {
        return "release";
    }

    public String getMockHostApi() {
        return ApiUrlFactory.CUSTOMER_API_HTTPS_ONLINE;
    }

    public String getTransApolloName() {
        return "GJHWM_C";
    }

    public void initExternalParams() {
    }

    public void initToolBox(Application application) {
    }

    public void setUserToken(String str) {
    }

    public boolean shouldMockApi() {
        return false;
    }

    public int getCityId() {
        return PoiUtil.getCityId();
    }

    public long getCountyId() {
        return PoiUtil.getCountyId();
    }

    public long getPoiCountyGroupId() {
        return PoiUtil.getPoiCountyGroupId();
    }

    public LatLng getCurrentLatLng() {
        return PoiUtil.getCurrentLatLng();
    }

    public double getLat() {
        return PoiUtil.getLat();
    }

    public double getLng() {
        return PoiUtil.getLng();
    }

    public int getPoiCityId() {
        return PoiUtil.getPoiCityId();
    }

    public long getPoiCountyId() {
        return PoiUtil.getPoiCountyId();
    }

    public long getCountyGroupId() {
        return PoiUtil.getCountyGroupId();
    }

    public double getPoiLat() {
        return PoiUtil.getPoiLat();
    }

    public double getPoiLng() {
        return PoiUtil.getPoiLng();
    }
}
