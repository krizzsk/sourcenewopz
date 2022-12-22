package com.didi.soda.home.topgun.component.topic.data;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.FilterEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeFeedEntity;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.model.HomeRealExposureModel;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import com.didi.soda.customer.foundation.util.SentenceUtil;
import com.didi.soda.home.topgun.binder.HomeBusinessItemBinder;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;

public class HomeTopicOmegaHelper implements HomeBusinessItemBinder.HomeBusinessOmegaInterface {

    /* renamed from: a */
    private static final String f42899a = "HomeTopicOmegaHelper";

    /* renamed from: b */
    private static HomeTopicOmegaHelper f42900b = new HomeTopicOmegaHelper();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WeakReference<ScopeContext> f42901c;

    /* renamed from: d */
    private OnceActionUtil.ActionPool f42902d;

    public static HomeTopicOmegaHelper getInstance() {
        return f42900b;
    }

    public void attach(ScopeContext scopeContext) {
        this.f42901c = new WeakReference<>(scopeContext);
        this.f42902d = new OnceActionUtil.ActionPool();
    }

    public void detach(ScopeContext scopeContext) {
        WeakReference<ScopeContext> weakReference = this.f42901c;
        if (weakReference != null && scopeContext == weakReference.get()) {
            this.f42901c = null;
            this.f42902d = null;
        }
    }

    public void itemExposure(final HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        if (!TextUtils.isEmpty(homeBusinessInfoRvModel.mShopId)) {
            final String moduleString = homeBusinessInfoRvModel.toModuleString();
            C140321 r1 = new OnceActionUtil.OnceAction(new Object[]{homeBusinessInfoRvModel.mShopId, homeBusinessInfoRvModel.mComponentType, moduleString}) {
                public void run() {
                    HomeRealExposureModel homeRealExposureModel = new HomeRealExposureModel();
                    homeRealExposureModel.f41102id = homeBusinessInfoRvModel.mShopId;
                    homeRealExposureModel.type = homeBusinessInfoRvModel.mComponentType;
                    homeRealExposureModel.location = moduleString;
                    homeRealExposureModel.status = homeBusinessInfoRvModel.mShopStatus;
                    homeRealExposureModel.deliveryFee = homeBusinessInfoRvModel.mCurrency + "_" + homeBusinessInfoRvModel.mDeliveryPriceOri + "_" + homeBusinessInfoRvModel.mDeliveryPriceAct;
                    homeRealExposureModel.deliveryTime = homeBusinessInfoRvModel.mDeliveryTime;
                    homeRealExposureModel.recId = homeBusinessInfoRvModel.mRecId;
                    if (HomeTopicOmegaHelper.this.f42901c != null) {
                        HomeTopicOmegaHelper.this.m30355a(EventConst.Home.HOME_TOPIC_SHOP_SW).addEventParam("content_json", GsonUtil.toJson(homeRealExposureModel)).build().track();
                    }
                }
            };
            OnceActionUtil.ActionPool actionPool = this.f42902d;
            if (actionPool != null) {
                actionPool.doAction(r1);
            }
        }
    }

    public void reset() {
        OnceActionUtil.ActionPool actionPool = this.f42902d;
        if (actionPool != null) {
            actionPool.reset();
        }
    }

    public void trackBusinessClick(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        if (this.f42901c != null) {
            OmegaTracker.Builder addEventParam = m30355a(EventConst.Home.HOME_TOPIC_SHOP_CK).addEventParam("shop_id", homeBusinessInfoRvModel.mShopId).addEventParam(ParamConst.PARAM_SHOP_NAME, homeBusinessInfoRvModel.mShopName).addEventParam(ParamConst.PARAM_SHOP_STATUS, Integer.valueOf(homeBusinessInfoRvModel.mShopStatus));
            addEventParam.addEventParam(ParamConst.PARAM_SHOP_DELIVERY_FEE, homeBusinessInfoRvModel.mCurrency + "_" + homeBusinessInfoRvModel.mDeliveryPriceOri + "_" + homeBusinessInfoRvModel.mDeliveryPriceAct).addEventParam(ParamConst.PARAM_SHOP_DELIVERY_TIME, Integer.valueOf(homeBusinessInfoRvModel.mDeliveryTime)).addEventParam(ParamConst.PARAM_SHOP_TAG, SentenceUtil.foldStringList(homeBusinessInfoRvModel.mShopTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_DISCOUNT_TAG, SentenceUtil.foldStringList(homeBusinessInfoRvModel.mActTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_MAIN_TAG, homeBusinessInfoRvModel.mShopCateInfoDescForTrack).enableGuideParam().build().track();
        }
    }

    public void trackHomeTopicFeedShow(HomeFeedEntity homeFeedEntity, AddressEntity addressEntity, String str) {
        String str2;
        int i = homeFeedEntity == null ? 1 : 0;
        String str3 = "";
        if (addressEntity == null || addressEntity.poi == null) {
            str2 = str3;
        } else {
            str3 = addressEntity.poi.poiId;
            str2 = addressEntity.aid;
        }
        if (this.f42901c != null) {
            m30355a(EventConst.Home.HOME_TOPIC_PAGE_SW).addEventParam("poi_id", str3).addEventParam("aid", str2).addEventParam("rec_id", str).addEventParam("error_type", Integer.valueOf(i)).build().track();
        }
    }

    public void onOmegaBusinessSw(HomeBusinessInfoRvModel homeBusinessInfoRvModel, boolean z) {
        itemExposure(homeBusinessInfoRvModel);
    }

    public void onOmegaBusinessCk(HomeBusinessInfoRvModel homeBusinessInfoRvModel, boolean z) {
        trackBusinessClick(homeBusinessInfoRvModel);
    }

    public void setOmegaGuideParam(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        String moduleString = homeBusinessInfoRvModel.toModuleString();
        String str = homeBusinessInfoRvModel.mRecId;
        m30357a(moduleString, str, "shop_" + homeBusinessInfoRvModel.mShopId, homeBusinessInfoRvModel.mPageFilter);
    }

    public String getBusinessBiData(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("user_id", LoginUtil.getUid());
        jsonObject.addProperty("shop_id", homeBusinessInfoRvModel.mShopId);
        jsonObject.addProperty("from_page", homeBusinessInfoRvModel.mPageId);
        JsonElement jsonElement = FilterEntity.toJsonElement(homeBusinessInfoRvModel.mPageFilter);
        if (jsonElement != null) {
            jsonObject.add("lv1_filter", jsonElement);
        }
        jsonObject.addProperty("lv1_location", homeBusinessInfoRvModel.toModuleString());
        jsonObject.addProperty("lv1_recid", homeBusinessInfoRvModel.mRecId);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add(ParamConst.CLICK_JSON, jsonObject);
        return jsonObject2.toString();
    }

    /* renamed from: a */
    private void m30357a(String str, String str2, String str3, String str4) {
        OmegaCommonParamHelper.setLv1Location(str);
        OmegaCommonParamHelper.setLv1RecId(str2);
        OmegaCommonParamHelper.setLv1Body(str3);
        OmegaCommonParamHelper.setLv1Filter(str4);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public OmegaTracker.Builder m30355a(String str) {
        return OmegaTracker.Builder.create(str, (ScopeContext) this.f42901c.get());
    }
}
