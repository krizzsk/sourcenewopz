package com.didi.sdk.app;

import com.didi.map.global.flow.MapFlowView;
import com.didi.sdk.misconfig.model.CountryInfo;

public class BusinessContext extends BaseBusinessContext {
    private String businessGroupType;
    private CountryInfo countryInfo;
    private boolean isActive;
    private MapFlowView lockScreenMapFlowView;
    private MapFlowView mapFlowView;
    private int misDataFrom = 2;

    public String getBusinessGroupType() {
        return this.businessGroupType;
    }

    public void setBusinessGroupType(String str) {
        this.businessGroupType = str;
    }

    public void setCountryInfo(CountryInfo countryInfo2) {
        this.countryInfo = countryInfo2;
    }

    public int getMisDataFrom() {
        return this.misDataFrom;
    }

    public void setMisDataFrom(int i) {
        this.misDataFrom = i;
    }

    public CountryInfo getCountryInfo() {
        return this.countryInfo;
    }

    public void setActive(boolean z) {
        this.isActive = z;
    }

    public MapFlowView getMapFlowView() {
        return this.mapFlowView;
    }

    public void setMapFlowView(MapFlowView mapFlowView2) {
        this.mapFlowView = mapFlowView2;
    }

    public void setLockScreenMapFlowView(MapFlowView mapFlowView2) {
        this.lockScreenMapFlowView = mapFlowView2;
    }

    public MapFlowView getLockScreenMapFlowView() {
        return this.lockScreenMapFlowView;
    }
}
