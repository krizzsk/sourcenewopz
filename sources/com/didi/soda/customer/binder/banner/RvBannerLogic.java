package com.didi.soda.customer.binder.banner;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.soda.customer.base.binder.logic.BinderLogic;
import com.didi.soda.customer.binder.model.banner.BannerRvModel;

public abstract class RvBannerLogic<LogicRepo extends Repo> extends BinderLogic<LogicRepo> {
    public abstract void onBannerClick(BannerRvModel bannerRvModel, int i);

    public abstract void onBannerPageSelected(BannerRvModel bannerRvModel, int i);
}
