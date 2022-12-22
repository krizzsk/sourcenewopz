package com.didi.soda.home.topgun.manager;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.entity.topgun.CategoryNotifyEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.FilterEntity;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.model.HomeRealExposureModelV2;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import com.didi.soda.customer.foundation.util.SentenceUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.text.RichTextParser;
import com.didi.soda.home.topgun.binder.HomeBusinessItemBinder;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;

public class ShopCateLandingOmegaHelper implements HomeBusinessItemBinder.HomeBusinessOmegaInterface {

    /* renamed from: a */
    private static final String f43007a = "ShopCateLandingOmegaHelper";

    /* renamed from: b */
    private static ShopCateLandingOmegaHelper f43008b = new ShopCateLandingOmegaHelper();

    /* renamed from: c */
    private WeakReference<ScopeContext> f43009c;

    /* renamed from: d */
    private OnceActionUtil.ActionPool f43010d;

    public static ShopCateLandingOmegaHelper getInstance() {
        return f43008b;
    }

    public void attach(ScopeContext scopeContext) {
        this.f43009c = new WeakReference<>(scopeContext);
        this.f43010d = new OnceActionUtil.ActionPool();
    }

    public void detach(ScopeContext scopeContext) {
        WeakReference<ScopeContext> weakReference = this.f43009c;
        if (weakReference != null && scopeContext == weakReference.get()) {
            this.f43009c = null;
            this.f43010d = null;
        }
    }

    public void reset() {
        OnceActionUtil.ActionPool actionPool = this.f43010d;
        if (actionPool != null) {
            actionPool.reset();
        }
    }

    public void trackShopCateLandingSW(String str, String str2) {
        OmegaTracker.Builder.create(EventConst.ShopCateLanding.SAILING_C_X_SECOND_CATEGORY_SW).addEventParam(ParamConst.TRACE_ID, str).addEventParam(ParamConst.PARAM_CATEGORY_ID, str2).build().track();
    }

    public void onOmegaBusinessSw(HomeBusinessInfoRvModel homeBusinessInfoRvModel, boolean z) {
        if (!TextUtils.isEmpty(homeBusinessInfoRvModel.mShopId)) {
            final String moduleString = homeBusinessInfoRvModel.toModuleString();
            final HomeBusinessInfoRvModel homeBusinessInfoRvModel2 = homeBusinessInfoRvModel;
            final boolean z2 = z;
            m30435a(new OnceActionUtil.OnceAction(new Object[]{homeBusinessInfoRvModel.mShopId, homeBusinessInfoRvModel.mComponentType, moduleString}) {
                public void run() {
                    HomeRealExposureModelV2 homeRealExposureModelV2 = new HomeRealExposureModelV2();
                    homeRealExposureModelV2.f41103id = homeBusinessInfoRvModel2.mShopId;
                    homeRealExposureModelV2.type = homeBusinessInfoRvModel2.mComponentType;
                    homeRealExposureModelV2.location = moduleString;
                    homeRealExposureModelV2.status = homeBusinessInfoRvModel2.mShopStatus;
                    homeRealExposureModelV2.deliveryFee = homeBusinessInfoRvModel2.mCurrency + "_" + homeBusinessInfoRvModel2.mDeliveryPriceOri + "_" + homeBusinessInfoRvModel2.mDeliveryPriceAct;
                    homeRealExposureModelV2.deliveryTime = homeBusinessInfoRvModel2.mDeliveryTime;
                    homeRealExposureModelV2.deliveryType = homeBusinessInfoRvModel2.mDeliveryType;
                    homeRealExposureModelV2.recId = homeBusinessInfoRvModel2.mRecId;
                    int i = 1;
                    homeRealExposureModelV2.hasCouponLogo = homeBusinessInfoRvModel2.mIsCouponLogo ? 1 : 2;
                    if (z2) {
                        if (homeBusinessInfoRvModel2.mRecInfo == null) {
                            i = 2;
                        }
                        homeRealExposureModelV2.hasRecInfo = i;
                    }
                    homeRealExposureModelV2.page = Const.HomeBusinessPageSource.SHOP_SPECIAL_PAGE;
                    homeRealExposureModelV2.module = Const.HomeV3TraceModelId.SHOP_SPECIAL_PAGE;
                    homeRealExposureModelV2.index = homeBusinessInfoRvModel2.mIndexInModule;
                    homeRealExposureModelV2.absolutePosition = homeBusinessInfoRvModel2.mAbsoluteIndex;
                    homeRealExposureModelV2.cateId = homeBusinessInfoRvModel2.mCateId;
                    String appInstanceID = ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getAppInstanceID();
                    OmegaTracker.Builder addEventParam = ShopCateLandingOmegaHelper.this.m30433a(EventConst.Home.HOME_REAL_EXPOSURE_SW).addEventParam("content_json", GsonUtil.toJson(homeRealExposureModelV2)).addEventParam(ParamConst.FILTER_PARAM, homeBusinessInfoRvModel2.mPageFilter).addEventParam(ParamConst.PARAM_MODULE_TYPE, homeBusinessInfoRvModel2.mModuleType).addEventParam(ParamConst.PARAM_MODULE_SEQUENCE, homeBusinessInfoRvModel2.mModuleIndex).addEventParam(ParamConst.TRACE_ID, homeBusinessInfoRvModel2.mTraceId);
                    if (appInstanceID == null) {
                        appInstanceID = "";
                    }
                    addEventParam.addEventParam(ParamConst.PARAMS_GOOGLE_APP_INSTANCE_ID, appInstanceID).build().track();
                }
            });
        }
    }

    public void onOmegaBusinessCk(HomeBusinessInfoRvModel homeBusinessInfoRvModel, boolean z) {
        OmegaTracker.Builder addEventParam = m30433a(EventConst.Home.HOME_SHOP_CK).addEventParam("shop_id", homeBusinessInfoRvModel.mShopId).addEventParam(ParamConst.PARAM_SHOP_NAME, homeBusinessInfoRvModel.mShopName).addEventParam(ParamConst.PARAM_SHOP_STATUS, Integer.valueOf(homeBusinessInfoRvModel.mShopStatus));
        addEventParam.addEventParam(ParamConst.PARAM_SHOP_DELIVERY_FEE, homeBusinessInfoRvModel.mCurrency + "_" + homeBusinessInfoRvModel.mDeliveryPriceOri + "_" + homeBusinessInfoRvModel.mDeliveryPriceAct).addEventParam(ParamConst.PARAM_SHOP_DELIVERY_TIME, Integer.valueOf(homeBusinessInfoRvModel.mDeliveryTime)).addEventParam(ParamConst.PARAM_SHOP_TAG, SentenceUtil.foldStringList(homeBusinessInfoRvModel.mShopTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_DISCOUNT_TAG, SentenceUtil.foldStringList(homeBusinessInfoRvModel.mActTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_MAIN_TAG, homeBusinessInfoRvModel.mShopCateInfoDescForTrack).addEventParam(ParamConst.PARAM_MODULE_TYPE, homeBusinessInfoRvModel.mModuleType).addEventParam(ParamConst.PARAM_MODULE_SEQUENCE, homeBusinessInfoRvModel.mModuleIndex).addEventParam(ParamConst.PARAM_DELIVERY_TYPE, Integer.valueOf(homeBusinessInfoRvModel.mDeliveryType)).addEventParam(ParamConst.PARAM_IS_RECOMMEND_REASON, Integer.valueOf(z ? homeBusinessInfoRvModel.mRecInfo == null ? 2 : 1 : 0)).addEventParam(ParamConst.TRACE_ID, homeBusinessInfoRvModel.mTraceId).addEventParam("page", Const.HomeBusinessPageSource.SHOP_SPECIAL_PAGE).addEventParam("module", Const.HomeV3TraceModelId.SHOP_SPECIAL_PAGE).addEventParam("index", Integer.valueOf(homeBusinessInfoRvModel.mIndexInModule)).addEventParam(ParamConst.PARAM_ABSOLUTE_POSITION, Integer.valueOf(homeBusinessInfoRvModel.mAbsoluteIndex)).addEventParam(ParamConst.PARAM_CATEGORY_ID, homeBusinessInfoRvModel.mCateId).enableGuideParam().build().track();
    }

    public void setOmegaGuideParam(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        String moduleString = homeBusinessInfoRvModel.toModuleString();
        String str = homeBusinessInfoRvModel.mRecId;
        m30434a(moduleString, str, "shop_" + homeBusinessInfoRvModel.mShopId, homeBusinessInfoRvModel.mPageFilter);
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
        return jsonObject.toString();
    }

    /* renamed from: a */
    private void m30434a(String str, String str2, String str3, String str4) {
        OmegaCommonParamHelper.setLv1Location(str);
        OmegaCommonParamHelper.setLv1RecId(str2);
        OmegaCommonParamHelper.setLv1Body(str3);
        OmegaCommonParamHelper.setLv1Filter(str4);
    }

    public void headerFilterSw(final String str, final String str2, String str3) {
        m30435a(new OnceActionUtil.OnceAction(str3) {
            public void run() {
                ShopCateLandingOmegaHelper.this.m30433a(EventConst.Home.HOME_FILTER_ITEM_REALEXPOSURE_SW).addEventParam(ParamConst.PARAM_FILTER_INFO, str2).addEventParam("resource_id", str).addEventParam("from", 2).build().track();
            }
        });
    }

    public void categoryNotifySw(JsonElement jsonElement) {
        CategoryNotifyEntity categoryNotifyEntity = (CategoryNotifyEntity) GsonUtil.fromJson(jsonElement, (Type) CategoryNotifyEntity.class);
        if (categoryNotifyEntity != null && categoryNotifyEntity.getTip() != null && !TextUtils.isEmpty(categoryNotifyEntity.getTip().getContent())) {
            m30433a(EventConst.Home.SAILING_C_X_PROMPT_MSG_SW).addEventParam(ParamConst.PARAM_FLAG_CONTENT, RichTextParser.parseText(categoryNotifyEntity.getTip().getContent()).toString()).addEventParam("page", Const.HomeBusinessPageSource.SHOP_SPECIAL_PAGE).build().track();
        }
    }

    public void onSearchCk() {
        m30433a(EventConst.ShopCateLanding.SAILING_C_X_HOMEPAGE_SECOND_SEARCH_CK).build().track();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public OmegaTracker.Builder m30433a(String str) {
        WeakReference<ScopeContext> weakReference = this.f43009c;
        if (weakReference != null) {
            return OmegaTracker.Builder.create(str, (ScopeContext) weakReference.get());
        }
        return OmegaTracker.Builder.create(str);
    }

    /* renamed from: a */
    private void m30435a(OnceActionUtil.OnceAction... onceActionArr) {
        OnceActionUtil.ActionPool actionPool = this.f43010d;
        if (actionPool != null) {
            actionPool.doAction(onceActionArr);
        }
    }
}
