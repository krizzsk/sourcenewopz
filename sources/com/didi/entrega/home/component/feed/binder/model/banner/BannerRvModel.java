package com.didi.entrega.home.component.feed.binder.model.banner;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.entrega.customer.foundation.rpc.entity.BannerEntity;
import java.util.ArrayList;
import java.util.List;

public class BannerRvModel implements RecyclerModel {
    public List<BannerItemRvModel> mBannerList = new ArrayList();
    public boolean mDataChanged = false;

    public static class BannerItemRvModel implements RecyclerModel {
        public String mActivityId;
        public String mImg;
        public String mUrl;
    }

    public static BannerRvModel convertBannerEntity(List<BannerEntity> list) {
        BannerRvModel bannerRvModel = new BannerRvModel();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                BannerEntity bannerEntity = list.get(i);
                BannerItemRvModel bannerItemRvModel = new BannerItemRvModel();
                bannerItemRvModel.mImg = bannerEntity.img;
                bannerItemRvModel.mUrl = bannerEntity.url;
                bannerItemRvModel.mActivityId = bannerEntity.f20010id;
                bannerRvModel.mBannerList.add(bannerItemRvModel);
            }
            bannerRvModel.mDataChanged = true;
        }
        return bannerRvModel;
    }
}
