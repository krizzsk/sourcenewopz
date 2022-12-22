package com.didi.soda.home.topgun.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.BannerEntity;
import com.didi.soda.customer.foundation.rpc.entity.SearchHotWordsEntity;
import com.didi.soda.home.topgun.model.HomeSearchHotWordsModel;
import java.util.ArrayList;
import java.util.List;

public class HomeHeaderRvModel implements RecyclerModel {
    public String activityType;
    public String ambientImg;
    public ArrayList<HomeSearchHotWordsModel> hotWordsList;

    /* renamed from: id */
    public String f42770id;
    public String link;
    public boolean mIsShowSpecial;
    public String recId;
    public String resourceId;
    public String specialBgImageUrl;
    public String specialImageUrl;

    public void update(BannerEntity bannerEntity, String str, String str2) {
        if (bannerEntity != null) {
            this.mIsShowSpecial = true;
            this.link = bannerEntity.url;
            this.specialImageUrl = bannerEntity.img;
            this.specialBgImageUrl = bannerEntity.bgImg;
            this.f42770id = bannerEntity.f41037id;
            this.activityType = bannerEntity.actType;
            this.recId = str2;
            this.resourceId = bannerEntity.resourceId;
        } else {
            this.mIsShowSpecial = false;
        }
        this.ambientImg = str;
    }

    public void update(List<SearchHotWordsEntity> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                SearchHotWordsEntity searchHotWordsEntity = list.get(i);
                if (searchHotWordsEntity != null) {
                    HomeSearchHotWordsModel convert2Model = HomeSearchHotWordsModel.convert2Model(searchHotWordsEntity);
                    convert2Model.setIndex(i);
                    arrayList.add(convert2Model);
                }
            }
            if (this.hotWordsList == null) {
                this.hotWordsList = new ArrayList<>();
            }
            this.hotWordsList.clear();
            this.hotWordsList.addAll(arrayList);
        }
    }
}
