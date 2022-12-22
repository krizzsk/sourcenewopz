package com.didi.sdk.misconfig.p153v2;

import android.util.Pair;
import com.didi.sdk.home.model.TopBarData;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didi.sdk.misconfig.model.CountryInfo;
import com.didi.sdk.misconfig.model.HotInfo;
import com.didi.sdk.misconfig.store.ICityChangeListener;
import com.didi.sdk.misconfig.store.MisRequestParams;

/* renamed from: com.didi.sdk.misconfig.v2.IPrimaryConf */
public interface IPrimaryConf {
    int getCityId();

    void getConfigFromNet(MisRequestParams misRequestParams);

    CountryInfo getCountryInfo();

    String getCountryIsoCode();

    int getDefaultGroupId();

    String getDefaultSelectedType();

    CarGrop getGroupByType(String str);

    String getGroupIdArrayString();

    int getGroupIdByType(String str);

    String getH5Link(String str);

    HotInfo getHotInfo();

    Pair<Integer, Integer> getSelectGroupId();

    int getSelectedGroupId();

    String getSelectedType();

    TopBarData getTopBarData();

    boolean isContainsGroupType(String str);

    void registerCityChangeListener(ICityChangeListener iCityChangeListener);

    void setSelectGroup(CarGrop carGrop);

    void setSelectedType(String str);

    void unRegisterCityChangeListener(ICityChangeListener iCityChangeListener);

    void updateConfigFromCache();
}
