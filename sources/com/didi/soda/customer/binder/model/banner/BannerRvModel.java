package com.didi.soda.customer.binder.model.banner;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.rpc.entity.BannerEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.customer.foundation.tracker.model.ModuleModelV2;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.datasource.parser.FeedPayload;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BannerRvModel extends ModuleModelV2 implements RecyclerModel {
    public List<BannerItemRvModel> mBannerList = new ArrayList();
    public boolean mDataChanged = false;

    public static class BannerItemRvModel extends ModuleModelV2 {
        public String actType;
        public String mActivityId;
        public String mImg;
        public String mResourceId;
        public String mUrl;
    }

    public static BannerRvModel convertBannerEntity(JsonObject jsonObject, FeedPayload feedPayload) {
        BannerRvModel bannerRvModel = new BannerRvModel();
        JsonElement jsonElement = jsonObject.get("data");
        if (jsonElement == null) {
            return bannerRvModel;
        }
        try {
            ComponentEntity componentEntity = (ComponentEntity) GsonUtil.fromJson(jsonElement, (Type) ComponentEntity.class);
            int i = -1;
            if (jsonObject.get("position") != null) {
                i = jsonObject.get("position").getAsInt();
            }
            JsonElement jsonElement2 = jsonObject.get(BlocksConst.BLOCK_PARAM_COMPONENT_ID);
            if (jsonElement2 != null) {
                bannerRvModel.mComponentId = jsonElement2.getAsString();
            }
            List<BannerEntity> list = componentEntity.mBannerList;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    BannerEntity bannerEntity = list.get(i2);
                    BannerItemRvModel bannerItemRvModel = new BannerItemRvModel();
                    bannerItemRvModel.mImg = bannerEntity.img;
                    bannerItemRvModel.mUrl = bannerEntity.url;
                    if (feedPayload != null) {
                        bannerItemRvModel.mPageId = feedPayload.mPageId;
                        bannerItemRvModel.mPageInModule = feedPayload.mPageIndex;
                        bannerItemRvModel.mRowInModule = feedPayload.mComponentIndex;
                        bannerItemRvModel.mAbsoluteIndex = feedPayload.mComponentIndex;
                        bannerItemRvModel.mRecId = feedPayload.mRecId;
                        bannerItemRvModel.mPageFilter = feedPayload.mPageFilter;
                    }
                    bannerItemRvModel.mActivityId = bannerEntity.f41037id;
                    bannerItemRvModel.mComponentId = componentEntity.mComponentId;
                    bannerItemRvModel.mComponentType = componentEntity.mType;
                    bannerItemRvModel.mColumnInModule = i2;
                    bannerItemRvModel.mIndexInModule = i;
                    bannerItemRvModel.mResourceId = bannerEntity.resourceId;
                    bannerRvModel.mBannerList.add(bannerItemRvModel);
                }
                bannerRvModel.mIndexInModule = i;
                if (feedPayload != null) {
                    bannerRvModel.mAbsoluteIndex = feedPayload.mComponentIndex;
                }
                bannerRvModel.mDataChanged = true;
            }
        } catch (Exception unused) {
        }
        return bannerRvModel;
    }

    public static BannerRvModel convertBannerEntity(List<BannerEntity> list, String str) {
        BannerRvModel bannerRvModel = new BannerRvModel();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                BannerEntity bannerEntity = list.get(i);
                BannerItemRvModel bannerItemRvModel = new BannerItemRvModel();
                bannerItemRvModel.mImg = bannerEntity.img;
                bannerItemRvModel.mUrl = bannerEntity.url;
                bannerItemRvModel.actType = bannerEntity.actType;
                bannerItemRvModel.mActivityId = bannerEntity.f41037id;
                bannerItemRvModel.mResourceId = bannerEntity.resourceId;
                bannerItemRvModel.mColumnInModule = i;
                bannerItemRvModel.mTraceId = str;
                bannerItemRvModel.mRecId = str;
                bannerRvModel.mBannerList.add(bannerItemRvModel);
            }
            bannerRvModel.mDataChanged = true;
        }
        return bannerRvModel;
    }
}
