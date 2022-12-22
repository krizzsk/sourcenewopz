package com.didi.sdk.misconfig.p153v2;

import android.util.Pair;
import com.didi.sdk.home.model.TopBarData;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didi.sdk.misconfig.model.CountryInfo;
import com.didi.sdk.misconfig.model.HotInfo;
import com.didi.sdk.misconfig.p153v2.impl.PriConfImpl;
import com.didi.sdk.misconfig.store.ICityChangeListener;
import com.didi.sdk.misconfig.store.MisRequestParams;
import com.didi.sdk.util.SaApolloUtil;
import com.didichuxing.foundation.spi.ServiceLoader;

/* renamed from: com.didi.sdk.misconfig.v2.ConfProxy */
public class ConfProxy implements IPrimaryConf {

    /* renamed from: a */
    private IPrimaryConf f36816a;

    private ConfProxy() {
        if (SaApolloUtil.INSTANCE.getSaState()) {
            this.f36816a = ((IPrimaryConfDelegate) ServiceLoader.load(IPrimaryConfDelegate.class).get()).getPrimaryDelegate();
        } else {
            this.f36816a = new PriConfImpl();
        }
    }

    /* renamed from: com.didi.sdk.misconfig.v2.ConfProxy$SingletonHolder */
    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final ConfProxy instance = new ConfProxy();

        private SingletonHolder() {
        }
    }

    public static ConfProxy getInstance() {
        return SingletonHolder.instance;
    }

    public void updateConfigFromCache() {
        IPrimaryConf iPrimaryConf = this.f36816a;
        if (iPrimaryConf != null) {
            iPrimaryConf.updateConfigFromCache();
        }
    }

    public void getConfigFromNet(MisRequestParams misRequestParams) {
        IPrimaryConf iPrimaryConf = this.f36816a;
        if (iPrimaryConf != null) {
            iPrimaryConf.getConfigFromNet(misRequestParams);
        }
    }

    public int getCityId() {
        IPrimaryConf iPrimaryConf = this.f36816a;
        if (iPrimaryConf != null) {
            return iPrimaryConf.getCityId();
        }
        return 0;
    }

    public HotInfo getHotInfo() {
        IPrimaryConf iPrimaryConf = this.f36816a;
        if (iPrimaryConf != null) {
            return iPrimaryConf.getHotInfo();
        }
        return null;
    }

    public String getCountryIsoCode() {
        IPrimaryConf iPrimaryConf = this.f36816a;
        if (iPrimaryConf != null) {
            return iPrimaryConf.getCountryIsoCode();
        }
        return null;
    }

    public boolean isContainsGroupType(String str) {
        IPrimaryConf iPrimaryConf = this.f36816a;
        if (iPrimaryConf != null) {
            return iPrimaryConf.isContainsGroupType(str);
        }
        return false;
    }

    public int getSelectedGroupId() {
        IPrimaryConf iPrimaryConf = this.f36816a;
        if (iPrimaryConf != null) {
            return iPrimaryConf.getSelectedGroupId();
        }
        return 0;
    }

    public int getGroupIdByType(String str) {
        IPrimaryConf iPrimaryConf = this.f36816a;
        if (iPrimaryConf != null) {
            return iPrimaryConf.getGroupIdByType(str);
        }
        return 0;
    }

    public int getDefaultGroupId() {
        IPrimaryConf iPrimaryConf = this.f36816a;
        if (iPrimaryConf != null) {
            return iPrimaryConf.getDefaultGroupId();
        }
        return 0;
    }

    public String getDefaultSelectedType() {
        IPrimaryConf iPrimaryConf = this.f36816a;
        return iPrimaryConf != null ? iPrimaryConf.getDefaultSelectedType() : "ride";
    }

    public void setSelectedType(String str) {
        IPrimaryConf iPrimaryConf = this.f36816a;
        if (iPrimaryConf != null) {
            iPrimaryConf.setSelectedType(str);
        }
    }

    public String getSelectedType() {
        IPrimaryConf iPrimaryConf = this.f36816a;
        return iPrimaryConf != null ? iPrimaryConf.getSelectedType() : "ride";
    }

    public String getGroupIdArrayString() {
        IPrimaryConf iPrimaryConf = this.f36816a;
        if (iPrimaryConf != null) {
            return iPrimaryConf.getGroupIdArrayString();
        }
        return null;
    }

    public Pair<Integer, Integer> getSelectGroupId() {
        IPrimaryConf iPrimaryConf = this.f36816a;
        if (iPrimaryConf != null) {
            return iPrimaryConf.getSelectGroupId();
        }
        return null;
    }

    public String getH5Link(String str) {
        IPrimaryConf iPrimaryConf = this.f36816a;
        if (iPrimaryConf != null) {
            return iPrimaryConf.getH5Link(str);
        }
        return null;
    }

    public CarGrop getGroupByType(String str) {
        IPrimaryConf iPrimaryConf = this.f36816a;
        if (iPrimaryConf != null) {
            return iPrimaryConf.getGroupByType(str);
        }
        return null;
    }

    public TopBarData getTopBarData() {
        IPrimaryConf iPrimaryConf = this.f36816a;
        if (iPrimaryConf != null) {
            return iPrimaryConf.getTopBarData();
        }
        return null;
    }

    public CountryInfo getCountryInfo() {
        IPrimaryConf iPrimaryConf = this.f36816a;
        if (iPrimaryConf != null) {
            return iPrimaryConf.getCountryInfo();
        }
        return null;
    }

    public void setSelectGroup(CarGrop carGrop) {
        IPrimaryConf iPrimaryConf = this.f36816a;
        if (iPrimaryConf != null) {
            iPrimaryConf.setSelectGroup(carGrop);
        }
    }

    public void registerCityChangeListener(ICityChangeListener iCityChangeListener) {
        IPrimaryConf iPrimaryConf = this.f36816a;
        if (iPrimaryConf != null) {
            iPrimaryConf.registerCityChangeListener(iCityChangeListener);
        }
    }

    public void unRegisterCityChangeListener(ICityChangeListener iCityChangeListener) {
        IPrimaryConf iPrimaryConf = this.f36816a;
        if (iPrimaryConf != null) {
            iPrimaryConf.unRegisterCityChangeListener(iCityChangeListener);
        }
    }
}
