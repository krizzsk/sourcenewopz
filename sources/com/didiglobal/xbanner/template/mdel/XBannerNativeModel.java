package com.didiglobal.xbanner.template.mdel;

import com.didi.global.xbanner.basemodel.XBCardViewData;
import java.io.Serializable;

public abstract class XBannerNativeModel extends XBCardViewData implements Serializable {
    public abstract String getCardId();
}
