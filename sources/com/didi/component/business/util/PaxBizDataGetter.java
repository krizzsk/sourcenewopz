package com.didi.component.business.util;

import com.didi.map.sdk.env.IBizDataGetter;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.SystemUtil;

public final class PaxBizDataGetter {
    public static void setBizDataGetter() {
        PaxEnvironment.getInstance().setBizDataGetter(new IBizDataGetter() {
            public String getToken() {
                return NationTypeUtil.getNationComponentData().getLoginInfo().getToken();
            }

            public String getUid() {
                return NationTypeUtil.getNationComponentData().getLoginInfo().getUid();
            }

            public String getPhoneNumber() {
                return NationTypeUtil.getNationComponentData().getLoginInfo().getPhone();
            }

            public String getProductId() {
                return BusinessDataUtil.getProductId();
            }

            public String getAppVersion() {
                return SystemUtil.getVersionName(DIDIApplicationDelegate.getAppContext());
            }

            public String getCountryCode() {
                return ConfProxy.getInstance().getCountryIsoCode();
            }

            public int getCityId() {
                return ConfProxy.getInstance().getCityId();
            }
        });
    }
}
