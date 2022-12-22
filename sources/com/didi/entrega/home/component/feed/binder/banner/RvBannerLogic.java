package com.didi.entrega.home.component.feed.binder.banner;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.entrega.customer.base.binder.logic.BinderLogic;
import com.didi.entrega.home.component.feed.binder.model.banner.BannerRvModel;

public abstract class RvBannerLogic<LogicRepo extends Repo> extends BinderLogic<LogicRepo> {
    public abstract void onBannerClick(BannerRvModel bannerRvModel, int i);

    public abstract void onBannerPageSelected(BannerRvModel bannerRvModel, int i);
}
