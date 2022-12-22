package com.didi.map.setting.common.apollo;

import com.didichuxing.apollo.sdk.IExperiment;
import com.example.compapollovisitor.BaseApollo;

public class NavShowListApollo extends BaseApollo {

    /* renamed from: a */
    private String f28937a = "";

    /* access modifiers changed from: protected */
    public String getKey() {
        return "global_driver_available_navlist_config";
    }

    /* access modifiers changed from: protected */
    public boolean reAllow() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void initParams(IExperiment iExperiment) {
        this.f28937a = (String) iExperiment.getParam("nav_list", "");
    }

    public String getNavFilter() {
        return this.f28937a;
    }
}
