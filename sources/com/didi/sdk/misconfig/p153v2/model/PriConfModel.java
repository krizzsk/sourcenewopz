package com.didi.sdk.misconfig.p153v2.model;

import com.didi.sdk.misconfig.model.HotInfo;
import java.io.Serializable;
import java.util.List;

/* renamed from: com.didi.sdk.misconfig.v2.model.PriConfModel */
public class PriConfModel implements Serializable {
    private int cityId;
    private int countryId;
    private String countryIsoCode;
    private int countyId;
    private String curVersion;
    private HotInfo hotInfo;
    private List<PriConfGroupModel> primaryMenu;
    private int utcOffset;

    public String getCurVersion() {
        return this.curVersion;
    }

    public List<PriConfGroupModel> getPrimaryMenu() {
        return this.primaryMenu;
    }

    public HotInfo getHotInfo() {
        return this.hotInfo;
    }

    public int getCountryId() {
        return this.countryId;
    }

    public int getCityId() {
        return this.cityId;
    }

    public int getCountyId() {
        return this.countyId;
    }

    public int getUtcOffset() {
        return this.utcOffset;
    }

    public String getCountryIsoCode() {
        return this.countryIsoCode;
    }
}
