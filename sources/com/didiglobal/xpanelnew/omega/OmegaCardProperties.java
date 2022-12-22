package com.didiglobal.xpanelnew.omega;

import com.didiglobal.xpanelnew.base.XpCardProperty;

public class OmegaCardProperties {
    public long currentMillsOnShowing;
    public int pos;
    public XpCardProperty property;

    public OmegaCardProperties(int i, long j, XpCardProperty xpCardProperty) {
        this.pos = i;
        this.currentMillsOnShowing = j;
        this.property = xpCardProperty;
    }
}
