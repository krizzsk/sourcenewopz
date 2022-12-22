package com.didi.sdk.componentspi;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.misconfig.model.CountryInfo;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.oneconf.OneConfStore;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.util.AppUtils;
import com.didi.unifylogin.api.ILoginStoreApi;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.usercenter.api.UserCenterFacade;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;

public class NationComponentDataDelegate extends NationComponentData {
    public DIDILocation getDidiLocation() {
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(DIDIApplicationDelegate.getAppContext()).getLastKnownLocation();
        setDidiLocation(lastKnownLocation);
        return lastKnownLocation;
    }

    public NationComponentData.LoginInfo getLoginInfo() {
        setLoginInfo(getLoginFacade(DIDIApplicationDelegate.getAppContext()));
        return super.getLoginInfo();
    }

    public int getTimeZoneUtcOffset() {
        setTimeZoneUtcOffset(AppUtils.getTimeZoneUtcOffset());
        return super.getTimeZoneUtcOffset();
    }

    public String getLocaleCode() {
        setLocaleCode(MultiLocaleStore.getInstance().getLocaleCode());
        return super.getLocaleCode();
    }

    public String getLocCountry() {
        CountryInfo countryInfo = ConfProxy.getInstance().getCountryInfo();
        if (countryInfo != null) {
            setLocCountry(countryInfo.getCountryIsoCode());
            setLocCountryId(countryInfo.getCountryId());
            SystemUtils.log(3, "NationTypeComponent", "" + super.getLocCountry() + ":" + super.getLocCountryId(), (Throwable) null, "com.didi.sdk.componentspi.NationComponentDataDelegate", 59);
        } else {
            setLocCountry(OneLoginFacade.getStore().getAreaCode());
        }
        return super.getLocCountry();
    }

    public String getCityId() {
        setCityId(OneConfStore.getInstance().getCityId() + "");
        return super.getCityId();
    }

    public String getGLang() {
        setGLang(MultiLocaleStore.getInstance().getLocaleCode());
        return super.getGLang();
    }

    private NationComponentData.LoginInfo getLoginFacade(Context context) {
        NationComponentData.LoginInfo loginInfo = new NationComponentData.LoginInfo();
        ILoginStoreApi store = OneLoginFacade.getStore();
        loginInfo.setToken(store.getToken());
        loginInfo.setkDToken(store.getToken());
        loginInfo.setUid(store.getUid());
        loginInfo.setPhone(store.getPhone());
        loginInfo.setPhoneCountryCode(store.getCountryCode());
        loginInfo.setLoginNow(store.isLoginNow());
        if (UserCenterFacade.getIns().getUserInfo(context) != null) {
            loginInfo.setFirstname(UserCenterFacade.getIns().getUserInfo(context).getFirst_name());
            loginInfo.setLastname(UserCenterFacade.getIns().getUserInfo(context).getLast_name());
        }
        return loginInfo;
    }

    public String getCurrency() {
        return super.getCurrency();
    }
}
