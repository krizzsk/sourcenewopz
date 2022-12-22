package com.didi.component.business.secondconf.model;

import com.didi.sdk.misconfig.model.WarmupActivity;
import java.io.Serializable;
import java.util.List;

public class RideConfModel implements Serializable {
    private String curVersion;
    private List<RideConfBizModel> secondaryMenu;
    private int showStatus;
    private WarmupActivity warmupActivity;

    public String getCurVersion() {
        return this.curVersion;
    }

    public int getShowStatus() {
        return this.showStatus;
    }

    public WarmupActivity getWarmupActivity() {
        return this.warmupActivity;
    }

    public List<RideConfBizModel> getSecondaryMenu() {
        return this.secondaryMenu;
    }
}
