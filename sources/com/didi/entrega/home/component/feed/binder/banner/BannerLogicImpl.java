package com.didi.entrega.home.component.feed.binder.banner;

import com.didi.entrega.customer.base.binder.EmptyItemLogic;
import com.didi.entrega.customer.biz.scheme.SchemeHelper;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.entrega.home.component.feed.binder.model.banner.BannerRvModel;
import com.didi.entrega.home.manager.HomeOmegaHelper;

public class BannerLogicImpl extends RvBannerLogic {

    /* renamed from: a */
    private static final String f20668a = "BannerLogicImpl";

    public Class<EmptyItemLogic> bindLogicRepoType() {
        return EmptyItemLogic.class;
    }

    public void onBannerClick(BannerRvModel bannerRvModel, int i) {
        String str = bannerRvModel.mBannerList.get(i).mUrl;
        SchemeHelper.dispatchMsg(str);
        HomeOmegaHelper.Companion.trackBannerClick(bannerRvModel, i);
        m15122a("onBannerClick", "c-act|").setOtherParam("url", str).build().info();
    }

    public void onBannerPageSelected(BannerRvModel bannerRvModel, int i) {
        HomeOmegaHelper.Companion.itemExposureForBanner(bannerRvModel, i);
    }

    /* renamed from: a */
    private RecordTracker.Builder m15122a(String str, String str2) {
        return RecordTracker.Builder.create().setTag(f20668a).setLogModule("m-home|").setMessage(str).setLogCategory(str2);
    }
}
