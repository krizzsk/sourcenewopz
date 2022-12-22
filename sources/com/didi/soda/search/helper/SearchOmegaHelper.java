package com.didi.soda.search.helper;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.binder.model.business.BusinessInfoRvModel;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.model.HomeRealExposureModel;
import com.didi.soda.customer.foundation.tracker.model.SearchRecCardExposureModel;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import com.didi.soda.customer.foundation.util.SentenceUtil;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.widget.search.SearchFoodItemView;
import com.didi.soda.search.binder.model.SearchRecommendCardModel;
import com.didi.soda.search.repo.SearchWordModel;
import com.didi.soda.search.repo.SearchWordRepo;
import com.didichuxing.dfbasesdk.utils.StringUtils;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;
import java.util.List;

public class SearchOmegaHelper {
    public static final String OUT_RANGE_ID = "outRange";
    public static final String RECOMMEND_ID = "recommend";
    public static final String SEARCH_ID = "search";

    /* renamed from: a */
    private static final int f43770a = 30;

    /* renamed from: b */
    private static SearchOmegaHelper f43771b = new SearchOmegaHelper();

    /* renamed from: c */
    private WeakReference<ScopeContext> f43772c;

    /* renamed from: d */
    private OnceActionUtil.ActionPool f43773d;

    public static SearchOmegaHelper getInstance() {
        return f43771b;
    }

    public static String genBusinessBiData(BusinessInfoRvModel businessInfoRvModel, SearchFoodItemView.SearchFoodItemModel searchFoodItemModel) {
        SearchWordModel value = ((SearchWordRepo) RepoFactory.getRepo(SearchWordRepo.class)).getValue();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("page", (Number) Integer.valueOf(businessInfoRvModel.mPageInModule));
        jsonObject.addProperty(ParamConst.SHOP_INDEX, (Number) Integer.valueOf(businessInfoRvModel.mIndexInModule));
        jsonObject.addProperty("shop_id", businessInfoRvModel.mShopId);
        jsonObject.addProperty(ParamConst.SORT_TYPE, (Number) Integer.valueOf(value.mSortType.getValue()));
        jsonObject.addProperty("module", businessInfoRvModel.mModuleId);
        if (searchFoodItemModel != null) {
            jsonObject.addProperty("item_id", searchFoodItemModel.goodsId);
            jsonObject.addProperty(ParamConst.PARAM_ITEM_INDEX, (Number) Integer.valueOf(searchFoodItemModel.position));
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty(ParamConst.BIDATA_ID, (Number) 30);
        jsonObject2.addProperty("recId", businessInfoRvModel.mRecId);
        jsonObject2.addProperty("from_page", RoutePath.SEARCH_HOME);
        jsonObject2.add(ParamConst.CLICK_JSON, jsonObject);
        return jsonObject2.toString();
    }

    public void attach(ScopeContext scopeContext) {
        this.f43772c = new WeakReference<>(scopeContext);
        this.f43773d = new OnceActionUtil.ActionPool();
    }

    public void detach(ScopeContext scopeContext) {
        WeakReference<ScopeContext> weakReference = this.f43772c;
        if (weakReference != null && scopeContext == weakReference.get()) {
            this.f43772c = null;
            this.f43773d = null;
        }
    }

    public void itemExposure(BusinessInfoRvModel businessInfoRvModel) {
        if (!TextUtils.isEmpty(businessInfoRvModel.mShopId)) {
            final String a = m31099a(businessInfoRvModel);
            final SearchWordModel value = ((SearchWordRepo) RepoFactory.getRepo(SearchWordRepo.class)).getValue();
            final BusinessInfoRvModel businessInfoRvModel2 = businessInfoRvModel;
            m31103a(new OnceActionUtil.OnceAction(new Object[]{businessInfoRvModel.mShopId, businessInfoRvModel.mComponentType, a}) {
                public void run() {
                    HomeRealExposureModel homeRealExposureModel = new HomeRealExposureModel();
                    homeRealExposureModel.f41102id = businessInfoRvModel2.mShopId;
                    homeRealExposureModel.type = businessInfoRvModel2.mComponentType;
                    homeRealExposureModel.location = a;
                    homeRealExposureModel.status = businessInfoRvModel2.mShopStatus;
                    homeRealExposureModel.deliveryFee = businessInfoRvModel2.mCurrency + "_" + businessInfoRvModel2.mDeliveryPriceOri + "_" + businessInfoRvModel2.mDeliveryPriceAct;
                    homeRealExposureModel.deliveryTime = businessInfoRvModel2.mDeliveryTime;
                    homeRealExposureModel.recId = businessInfoRvModel2.mRecId;
                    homeRealExposureModel.sortType = value.mSortType.getValue();
                    SearchOmegaHelper.this.m31097a(EventConst.Search.SHOP_EXPOSURE).addEventParam("content_json", GsonUtil.toJson(homeRealExposureModel)).build().track();
                }
            });
        }
    }

    public void itemExposureForGoods(BusinessInfoRvModel businessInfoRvModel, SearchFoodItemView.SearchFoodItemModel searchFoodItemModel) {
        if (!TextUtils.isEmpty(searchFoodItemModel.goodsId)) {
            final String a = m31100a(businessInfoRvModel, searchFoodItemModel);
            final SearchWordModel value = ((SearchWordRepo) RepoFactory.getRepo(SearchWordRepo.class)).getValue();
            final BusinessInfoRvModel businessInfoRvModel2 = businessInfoRvModel;
            final SearchFoodItemView.SearchFoodItemModel searchFoodItemModel2 = searchFoodItemModel;
            m31103a(new OnceActionUtil.OnceAction(new Object[]{businessInfoRvModel.mShopId, searchFoodItemModel.goodsId, a}) {
                public void run() {
                    HomeRealExposureModel homeRealExposureModel = new HomeRealExposureModel();
                    homeRealExposureModel.f41102id = businessInfoRvModel2.mShopId;
                    homeRealExposureModel.item_id = searchFoodItemModel2.goodsId;
                    homeRealExposureModel.type = "item";
                    homeRealExposureModel.location = a;
                    homeRealExposureModel.status = businessInfoRvModel2.mShopStatus;
                    homeRealExposureModel.deliveryFee = businessInfoRvModel2.mCurrency + "_" + businessInfoRvModel2.mDeliveryPriceOri + "_" + businessInfoRvModel2.mDeliveryPriceAct;
                    homeRealExposureModel.deliveryTime = businessInfoRvModel2.mDeliveryTime;
                    homeRealExposureModel.recId = businessInfoRvModel2.mRecId;
                    homeRealExposureModel.sortType = value.mSortType.getValue();
                    SearchOmegaHelper.this.m31097a(EventConst.Search.SHOP_EXPOSURE).addEventParam("content_json", GsonUtil.toJson(homeRealExposureModel)).build().track();
                }
            });
        }
    }

    public void itemExposureForRecommendCard(final SearchRecommendCardModel searchRecommendCardModel) {
        if (!CollectionsUtil.isEmpty(searchRecommendCardModel.mCardWordList)) {
            final String a = m31101a(searchRecommendCardModel);
            m31103a(new OnceActionUtil.OnceAction(new Object[]{searchRecommendCardModel.mComponentType, searchRecommendCardModel.mSessionId, Integer.valueOf(searchRecommendCardModel.mSessionIter), a}) {
                public void run() {
                    SearchRecCardExposureModel searchRecCardExposureModel = new SearchRecCardExposureModel();
                    searchRecCardExposureModel.location = a;
                    searchRecCardExposureModel.status = -1;
                    searchRecCardExposureModel.recId = searchRecommendCardModel.mRecId;
                    searchRecCardExposureModel.sessionID = searchRecommendCardModel.mSessionId;
                    searchRecCardExposureModel.sessionIter = searchRecommendCardModel.mSessionIter;
                    searchRecCardExposureModel.words = searchRecommendCardModel.mCardWordList;
                    SearchOmegaHelper.this.m31097a(EventConst.Search.SHOP_EXPOSURE).addEventParam("content_json", GsonUtil.toJson(searchRecCardExposureModel)).build().track();
                }
            });
        }
    }

    public void setBusinessGuideParam(BusinessInfoRvModel businessInfoRvModel) {
        String a = m31099a(businessInfoRvModel);
        String str = businessInfoRvModel.mRecId;
        m31102a(a, str, "shop_" + businessInfoRvModel.mShopId);
    }

    public void setGoodsGuideParam(BusinessInfoRvModel businessInfoRvModel, SearchFoodItemView.SearchFoodItemModel searchFoodItemModel) {
        String a = m31100a(businessInfoRvModel, searchFoodItemModel);
        String str = businessInfoRvModel.mRecId;
        m31102a(a, str, StringUtils.SP_DATA_ITEM + searchFoodItemModel.goodsId);
    }

    public void trackBusinessClick(BusinessInfoRvModel businessInfoRvModel) {
        SearchWordModel value = ((SearchWordRepo) RepoFactory.getRepo(SearchWordRepo.class)).getValue();
        String str = value.mSearchFrom == SearchWordModel.SearchFrom.RECOMMEND ? "searchrec" : "searchresult";
        OmegaTracker.Builder addEventParam = m31097a(EventConst.Search.SHOP_CK).addEventParam("shop_id", businessInfoRvModel.mShopId).addEventParam("event_type", 0).addEventParam(ParamConst.PARAM_SHOP_STATUS, Integer.valueOf(businessInfoRvModel.mShopStatus));
        addEventParam.addEventParam(ParamConst.PARAM_SHOP_DELIVERY_FEE, businessInfoRvModel.mCurrency + "_" + businessInfoRvModel.mDeliveryPriceOri + "_" + businessInfoRvModel.mDeliveryPriceAct).addEventParam(ParamConst.PARAM_SHOP_DELIVERY_TIME, Integer.valueOf(businessInfoRvModel.mDeliveryTime)).addEventParam(ParamConst.PARAM_SHOP_TAG, SentenceUtil.foldStringList(businessInfoRvModel.mShopTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_DISCOUNT_TAG, SentenceUtil.foldStringList(businessInfoRvModel.mActTipList, ",")).addEventParam("rec_id", businessInfoRvModel.mRecId).addEventParam(ParamConst.TRACE_ID, businessInfoRvModel.traceId).addEventParam("module", str).addEventParam(ParamConst.SORT_TYPE, Integer.valueOf(value.mSortType.getValue())).enableGuideParam().build().track();
    }

    public void trackGoodsClick(BusinessInfoRvModel businessInfoRvModel, SearchFoodItemView.SearchFoodItemModel searchFoodItemModel) {
        SearchWordModel value = ((SearchWordRepo) RepoFactory.getRepo(SearchWordRepo.class)).getValue();
        String str = value.mSearchFrom == SearchWordModel.SearchFrom.RECOMMEND ? "searchrec" : "searchresult";
        OmegaTracker.Builder addEventParam = m31097a(EventConst.Search.SHOP_CK).addEventParam("shop_id", businessInfoRvModel.mShopId).addEventParam(ParamConst.PARAM_DISH_ID, searchFoodItemModel.goodsId).addEventParam("event_type", 1).addEventParam(ParamConst.PARAM_SHOP_STATUS, Integer.valueOf(businessInfoRvModel.mShopStatus));
        addEventParam.addEventParam(ParamConst.PARAM_SHOP_DELIVERY_FEE, businessInfoRvModel.mCurrency + "_" + businessInfoRvModel.mDeliveryPriceOri + "_" + businessInfoRvModel.mDeliveryPriceAct).addEventParam(ParamConst.PARAM_SHOP_DELIVERY_TIME, Integer.valueOf(businessInfoRvModel.mDeliveryTime)).addEventParam(ParamConst.PARAM_SHOP_TAG, SentenceUtil.foldStringList(businessInfoRvModel.mShopTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_DISCOUNT_TAG, SentenceUtil.foldStringList(businessInfoRvModel.mActTipList, ",")).addEventParam("rec_id", businessInfoRvModel.mRecId).addEventParam(ParamConst.TRACE_ID, businessInfoRvModel.traceId).addEventParam("module", str).addEventParam(ParamConst.SORT_TYPE, Integer.valueOf(value.mSortType.getValue())).enableGuideParam().build().track();
    }

    public void trackRecommendTagShow(String str, int i, List<String> list) {
        List<String> list2;
        int i2 = 0;
        if (list != null) {
            int size = list.size();
            if (size >= i) {
                int i3 = size;
                list2 = list.subList(0, i);
                i2 = i3;
            } else {
                return;
            }
        } else {
            list2 = null;
        }
        m31097a(EventConst.Search.REC_WORD_SW).addEventParam(ParamConst.RECOMMEND_REC_ID, str).addEventParam(ParamConst.RECOMMEND_REC_NUM, Integer.valueOf(i2)).addEventParam(ParamConst.RECOMMEND_TAG_LIST, SentenceUtil.foldStringList(list, ",")).addEventParam(ParamConst.VISIBLE_RECOMMEND_TAG_NUM, Integer.valueOf(i)).addEventParam(ParamConst.VISIBLE_RECOMMEND_TAG_LIST, SentenceUtil.foldStringList(list2, ",")).build().track();
    }

    public void trackHistoryTagShow(String str, int i, List<String> list) {
        List<String> list2;
        int i2 = 0;
        if (list != null) {
            int size = list.size();
            if (size >= i) {
                int i3 = size;
                list2 = list.subList(0, i);
                i2 = i3;
            } else {
                return;
            }
        } else {
            list2 = null;
        }
        m31097a(EventConst.Search.HISTORY_WORD).addEventParam(ParamConst.RECOMMEND_REC_ID, str).addEventParam(ParamConst.HISTORY_NUM, Integer.valueOf(i2)).addEventParam(ParamConst.HISTORY_LIST, SentenceUtil.foldStringList(list, ",")).addEventParam(ParamConst.VISIBLE_HISTORY_NUM, Integer.valueOf(i)).addEventParam(ParamConst.VISIBLE_HISTORY_LIST, SentenceUtil.foldStringList(list2, ",")).build().track();
    }

    public void trackSearchWordInput(String str) {
        m31097a(EventConst.Search.SEARCH_WORD_INPUT).addEventParam("name", str).build().track();
    }

    public void trackSearchEditViewClick() {
        m31097a(EventConst.Search.SEARCH_EDITVIEW_CK).build().track();
    }

    public void trackHistoryWordClick(String str, String str2, int i) {
        m31097a(EventConst.Search.HISTORY_WORD_CK).addEventParam("name", str).addEventParam("rec_id", str2).build().track();
    }

    public void trackRecommendWordClick(String str, String str2, int i) {
        m31097a(EventConst.Search.RECOMMENT_WORD_CK).addEventParam("name", str).addEventParam("rec_id", str2).build().track();
    }

    public void reset() {
        OnceActionUtil.ActionPool actionPool = this.f43773d;
        if (actionPool != null) {
            actionPool.reset();
        }
    }

    /* renamed from: a */
    private void m31103a(OnceActionUtil.OnceAction... onceActionArr) {
        OnceActionUtil.ActionPool actionPool = this.f43773d;
        if (actionPool != null) {
            actionPool.doAction(onceActionArr);
        }
    }

    /* renamed from: a */
    private String m31099a(BusinessInfoRvModel businessInfoRvModel) {
        return "searchPage_" + businessInfoRvModel.mModuleId + "_" + businessInfoRvModel.mModuleType + "_" + businessInfoRvModel.mComponentType + "_" + businessInfoRvModel.mModuleIndex + "_" + businessInfoRvModel.mPageInModule + "_" + businessInfoRvModel.mRowInModule + "_" + businessInfoRvModel.mColumnInModule + "_" + businessInfoRvModel.mIndexInModule;
    }

    /* renamed from: a */
    private String m31100a(BusinessInfoRvModel businessInfoRvModel, SearchFoodItemView.SearchFoodItemModel searchFoodItemModel) {
        return "searchPage_" + businessInfoRvModel.mModuleId + "_" + businessInfoRvModel.mModuleType + "_item_" + businessInfoRvModel.mModuleIndex + "_" + businessInfoRvModel.mPageInModule + "_" + businessInfoRvModel.mRowInModule + "_" + businessInfoRvModel.mColumnInModule + "_" + businessInfoRvModel.mIndexInModule + "_" + searchFoodItemModel.goodsId + "_" + searchFoodItemModel.position;
    }

    /* renamed from: a */
    private String m31101a(SearchRecommendCardModel searchRecommendCardModel) {
        return "searchPage_" + searchRecommendCardModel.mModuleId + "_" + searchRecommendCardModel.mModuleType + "_" + searchRecommendCardModel.mComponentType + "_" + searchRecommendCardModel.mModuleIndex + "_" + searchRecommendCardModel.mPageInModule + "_" + searchRecommendCardModel.mRowInModule + "_" + searchRecommendCardModel.mColumnInModule + "_" + searchRecommendCardModel.mIndexInModule;
    }

    /* renamed from: a */
    private String m31098a(int i) {
        return "searchPage_search_fullAmountModule_searchWords_3_0_0_0_" + i;
    }

    /* renamed from: a */
    private void m31102a(String str, String str2, String str3) {
        OmegaCommonParamHelper.setLv1Location(str);
        OmegaCommonParamHelper.setLv1RecId(str2);
        OmegaCommonParamHelper.setLv1Body(str3);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public OmegaTracker.Builder m31097a(String str) {
        WeakReference<ScopeContext> weakReference = this.f43772c;
        if (weakReference != null) {
            return OmegaTracker.Builder.create(str, (ScopeContext) weakReference.get());
        }
        return OmegaTracker.Builder.create(str);
    }
}
