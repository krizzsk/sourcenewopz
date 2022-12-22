package com.didi.map.sdk.sharetrack.google.inner.apollo;

import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.example.compapollovisitor.BaseApollo;

public class PushEdaApollo extends BaseApollo {

    /* renamed from: a */
    private volatile int f28815a = -1;

    /* renamed from: b */
    private volatile int f28816b = -1;

    /* access modifiers changed from: protected */
    public boolean reAllow() {
        return false;
    }

    /* access modifiers changed from: protected */
    public String getKey() {
        String countryCode = PlatInfo.getInstance().getCountryCode();
        if ("BR".equals(countryCode)) {
            return "ora_call_dmc_for_psg_in_wait_BR_v2";
        }
        return "MX".equals(countryCode) ? "ora_call_dmc_for_psg_in_wait_v2" : "ora_call_dmc_for_psg_in_wait_google_v2";
    }

    /* access modifiers changed from: protected */
    public void initParams(IExperiment iExperiment) {
        try {
            this.f28815a = Integer.parseInt((String) iExperiment.getParam("EDAShort", "-1"));
        } catch (Exception unused) {
        }
        try {
            this.f28816b = Integer.parseInt((String) iExperiment.getParam("EDALong", "-1"));
        } catch (Exception unused2) {
        }
    }

    public int getShortEda() {
        return this.f28815a;
    }

    public int getLongEda() {
        return this.f28816b;
    }
}
