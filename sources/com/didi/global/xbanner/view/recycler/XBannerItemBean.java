package com.didi.global.xbanner.view.recycler;

import com.didi.global.xbanner.basemodel.XBCardView;
import com.didi.global.xbanner.basemodel.XBCardViewData;

public class XBannerItemBean {
    public String cardId;
    public XBCardView cardView;
    public XBCardViewData data;

    public XBannerItemBean(String str, XBCardView xBCardView, XBCardViewData xBCardViewData) {
        this.cardId = str;
        this.cardView = xBCardView;
        this.data = xBCardViewData;
    }
}
