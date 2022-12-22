package com.didi.soda.search.helper;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.base.pages.RoutePath;
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
import com.didi.soda.customer.foundation.util.StringUtils;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.widget.search.SearchFoodItemView;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.search.binder.model.SearchRecommendCardModel;
import com.didi.soda.search.component.suggestion.SearchSuggestionState;
import com.didi.soda.search.repo.SearchHotWordsModel;
import com.didi.soda.search.repo.SearchWordModel;
import com.didi.soda.search.repo.SearchWordRepo;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class SearchNewOmegaHelper {
    public static final String BRAND_ID = "brand";
    public static final String OUT_RANGE_ID = "outRange";
    public static final String RECOMMEND_ID = "recommend";
    public static final String SEARCH_ID = "search";

    /* renamed from: a */
    private static final int f43766a = 30;

    /* renamed from: b */
    private static SearchNewOmegaHelper f43767b = new SearchNewOmegaHelper();

    /* renamed from: c */
    private WeakReference<ScopeContext> f43768c;

    /* renamed from: d */
    private OnceActionUtil.ActionPool f43769d;

    public static SearchNewOmegaHelper getInstance() {
        return f43767b;
    }

    public static String genBusinessBiData(HomeBusinessInfoRvModel homeBusinessInfoRvModel, SearchFoodItemView.SearchFoodItemModel searchFoodItemModel) {
        SearchWordModel value = ((SearchWordRepo) RepoFactory.getRepo(SearchWordRepo.class)).getValue();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("page", (Number) Integer.valueOf(homeBusinessInfoRvModel.mPageInModule));
        jsonObject.addProperty(ParamConst.SHOP_INDEX, (Number) Integer.valueOf(homeBusinessInfoRvModel.mIndexInModule));
        jsonObject.addProperty("shop_id", homeBusinessInfoRvModel.mShopId);
        jsonObject.addProperty(ParamConst.SORT_TYPE, (Number) Integer.valueOf(value.mSortType.getValue()));
        jsonObject.addProperty("module", homeBusinessInfoRvModel.mModuleId);
        if (searchFoodItemModel != null) {
            jsonObject.addProperty("item_id", searchFoodItemModel.goodsId);
            jsonObject.addProperty(ParamConst.PARAM_ITEM_INDEX, (Number) Integer.valueOf(searchFoodItemModel.position));
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty(ParamConst.BIDATA_ID, (Number) 30);
        jsonObject2.addProperty("recId", homeBusinessInfoRvModel.mRecId);
        jsonObject2.add(ParamConst.CLICK_JSON, jsonObject);
        return jsonObject2.toString();
    }

    public void attach(ScopeContext scopeContext) {
        this.f43768c = new WeakReference<>(scopeContext);
        this.f43769d = new OnceActionUtil.ActionPool();
    }

    public void detach(ScopeContext scopeContext) {
        WeakReference<ScopeContext> weakReference = this.f43768c;
        if (weakReference != null && scopeContext == weakReference.get()) {
            this.f43768c = null;
            this.f43769d = null;
        }
    }

    public static int getFromPageValueForTrack(String str) {
        if (StringUtils.isEmpty(str)) {
            return 0;
        }
        if (str.equals("homePage")) {
            return 1;
        }
        if (str.equals(RoutePath.SHOP_CATEGORY_LANDING_PAGE)) {
            return 2;
        }
        return 0;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getComponentDescWithType(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r0) {
                case 49: goto L_0x0029;
                case 50: goto L_0x001f;
                case 51: goto L_0x0015;
                case 52: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0033
        L_0x000b:
            java.lang.String r0 = "4"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0033
            r4 = 3
            goto L_0x0034
        L_0x0015:
            java.lang.String r0 = "3"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0033
            r4 = 2
            goto L_0x0034
        L_0x001f:
            java.lang.String r0 = "2"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0033
            r4 = 1
            goto L_0x0034
        L_0x0029:
            java.lang.String r0 = "1"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0033
            r4 = 0
            goto L_0x0034
        L_0x0033:
            r4 = -1
        L_0x0034:
            if (r4 == 0) goto L_0x0049
            if (r4 == r3) goto L_0x0046
            if (r4 == r2) goto L_0x0043
            if (r4 == r1) goto L_0x003f
            java.lang.String r4 = ""
            goto L_0x004c
        L_0x003f:
            java.lang.String r4 = "shopwithitems"
            goto L_0x004c
        L_0x0043:
            java.lang.String r4 = "brandother"
            goto L_0x004c
        L_0x0046:
            java.lang.String r4 = "brandtop"
            goto L_0x004c
        L_0x0049:
            java.lang.String r4 = "shop"
        L_0x004c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.search.helper.SearchNewOmegaHelper.getComponentDescWithType(java.lang.String):java.lang.String");
    }

    public void itemExposure(HomeBusinessInfoRvModel homeBusinessInfoRvModel, boolean z) {
        if (!TextUtils.isEmpty(homeBusinessInfoRvModel.mShopId)) {
            final String a = m31091a(homeBusinessInfoRvModel);
            final SearchWordModel value = ((SearchWordRepo) RepoFactory.getRepo(SearchWordRepo.class)).getValue();
            final HomeBusinessInfoRvModel homeBusinessInfoRvModel2 = homeBusinessInfoRvModel;
            final boolean z2 = z;
            m31095a(new OnceActionUtil.OnceAction(new Object[]{homeBusinessInfoRvModel.mShopId, homeBusinessInfoRvModel.mComponentType, a}) {
                public void run() {
                    HomeRealExposureModel homeRealExposureModel = new HomeRealExposureModel();
                    homeRealExposureModel.f41102id = homeBusinessInfoRvModel2.mShopId;
                    homeRealExposureModel.type = homeBusinessInfoRvModel2.mComponentType;
                    homeRealExposureModel.location = a;
                    homeRealExposureModel.status = homeBusinessInfoRvModel2.mShopStatus;
                    homeRealExposureModel.deliveryFee = homeBusinessInfoRvModel2.mCurrency + "_" + homeBusinessInfoRvModel2.mDeliveryPriceOri + "_" + homeBusinessInfoRvModel2.mDeliveryPriceAct;
                    homeRealExposureModel.deliveryTime = homeBusinessInfoRvModel2.mDeliveryTime;
                    homeRealExposureModel.recId = homeBusinessInfoRvModel2.mRecId;
                    homeRealExposureModel.sortType = value.mSortType.getValue();
                    int i = 2;
                    homeRealExposureModel.hasCouponLogo = homeBusinessInfoRvModel2.mIsCouponLogo ? 1 : 2;
                    homeRealExposureModel.searchWordType = homeBusinessInfoRvModel2.intentionType;
                    homeRealExposureModel.itemRecallNum = homeBusinessInfoRvModel2.mFoodItems != null ? homeBusinessInfoRvModel2.mFoodItems.size() : 0;
                    if (z2) {
                        if (homeBusinessInfoRvModel2.mRecInfo != null) {
                            i = 1;
                        }
                        homeRealExposureModel.hasRecInfo = i;
                    }
                    homeRealExposureModel.isShopLogo = TextUtils.isEmpty(homeBusinessInfoRvModel2.mLogo) ^ true ? 1 : 0;
                    String str = "";
                    OmegaTracker.Builder addEventParam = SearchNewOmegaHelper.this.m31089a(EventConst.Search.SHOP_EXPOSURE).addEventParam("content_json", GsonUtil.toJson(homeRealExposureModel)).addEventParam(ParamConst.PARAM_MODULE_TYPE, z2 ? homeBusinessInfoRvModel2.mModuleType : str).addEventParam(ParamConst.PARAM_MODULE_SEQUENCE, z2 ? homeBusinessInfoRvModel2.mModuleIndex : str).addEventParam(ParamConst.TRACE_ID, homeBusinessInfoRvModel2.mTraceId).addEventParam(ParamConst.FILTER_PARAM, homeBusinessInfoRvModel2.mPageFilter).addEventParam("from", Integer.valueOf(SearchNewOmegaHelper.getFromPageValueForTrack(homeBusinessInfoRvModel2.fromPage)));
                    if (homeBusinessInfoRvModel2.mComponentType != null) {
                        str = homeBusinessInfoRvModel2.mComponentType;
                    }
                    addEventParam.addEventParam(ParamConst.PARAM_SEARCH_SHOP_TYPE, str).build().track();
                }
            });
        }
    }

    public void itemExposureForDish(final HomeBusinessInfoRvModel homeBusinessInfoRvModel, final SearchFoodItemView.SearchFoodItemModel searchFoodItemModel) {
        if (!TextUtils.isEmpty(searchFoodItemModel.goodsId)) {
            m31095a(new OnceActionUtil.OnceAction(new Object[]{homeBusinessInfoRvModel.mShopId, searchFoodItemModel.goodsId, m31092a(homeBusinessInfoRvModel, searchFoodItemModel)}) {
                public void run() {
                    SearchNewOmegaHelper.this.m31089a(EventConst.Search.SHOP_WITH_DISH_EXPOSURE).addEventParam("shop_id", homeBusinessInfoRvModel.mShopId).addEventParam("item_id", searchFoodItemModel.goodsId).addEventParam("rec_id", homeBusinessInfoRvModel.mRecId).addEventParam("price", Integer.valueOf(searchFoodItemModel.price)).addEventParam("discount_price", Integer.valueOf(searchFoodItemModel.specialPrice)).addEventParam("page", "searchpage").addEventParam("module", homeBusinessInfoRvModel.mModuleId).addEventParam(ParamConst.PARAM_ABSOLUTE_POSITION, Integer.valueOf(homeBusinessInfoRvModel.mAbsoluteIndex)).addEventParam("index", Integer.valueOf(searchFoodItemModel.position)).addEventParam("from", Integer.valueOf(SearchNewOmegaHelper.getFromPageValueForTrack(homeBusinessInfoRvModel.fromPage))).addEventParam("search_word_type", Integer.valueOf(homeBusinessInfoRvModel.intentionType)).addEventParam(ParamConst.PARAM_SEARCH_SHOP_TYPE, homeBusinessInfoRvModel.mComponentType).addEventParam(ParamConst.FILTER_PARAM, homeBusinessInfoRvModel.mPageFilter).addEventParam(ParamConst.TRACE_ID, homeBusinessInfoRvModel.mTraceId).build().track();
                }
            });
        }
    }

    public void itemExposureForGoods(HomeBusinessInfoRvModel homeBusinessInfoRvModel, SearchFoodItemView.SearchFoodItemModel searchFoodItemModel, boolean z) {
        if (!TextUtils.isEmpty(searchFoodItemModel.goodsId)) {
            final String a = m31092a(homeBusinessInfoRvModel, searchFoodItemModel);
            final SearchWordModel value = ((SearchWordRepo) RepoFactory.getRepo(SearchWordRepo.class)).getValue();
            final HomeBusinessInfoRvModel homeBusinessInfoRvModel2 = homeBusinessInfoRvModel;
            final SearchFoodItemView.SearchFoodItemModel searchFoodItemModel2 = searchFoodItemModel;
            final boolean z2 = z;
            m31095a(new OnceActionUtil.OnceAction(new Object[]{homeBusinessInfoRvModel.mShopId, searchFoodItemModel.goodsId, a}) {
                public void run() {
                    HomeRealExposureModel homeRealExposureModel = new HomeRealExposureModel();
                    homeRealExposureModel.f41102id = homeBusinessInfoRvModel2.mShopId;
                    homeRealExposureModel.item_id = searchFoodItemModel2.goodsId;
                    homeRealExposureModel.type = "item";
                    homeRealExposureModel.location = a;
                    homeRealExposureModel.status = homeBusinessInfoRvModel2.mShopStatus;
                    homeRealExposureModel.deliveryFee = homeBusinessInfoRvModel2.mCurrency + "_" + homeBusinessInfoRvModel2.mDeliveryPriceOri + "_" + homeBusinessInfoRvModel2.mDeliveryPriceAct;
                    homeRealExposureModel.deliveryTime = homeBusinessInfoRvModel2.mDeliveryTime;
                    homeRealExposureModel.recId = homeBusinessInfoRvModel2.mRecId;
                    homeRealExposureModel.sortType = value.mSortType.getValue();
                    if (z2) {
                        homeRealExposureModel.hasRecInfo = homeBusinessInfoRvModel2.mRecInfo == null ? 2 : 1;
                    }
                    String str = "";
                    OmegaTracker.Builder addEventParam = SearchNewOmegaHelper.this.m31089a(EventConst.Search.SHOP_EXPOSURE).addEventParam("content_json", GsonUtil.toJson(homeRealExposureModel)).addEventParam(ParamConst.PARAM_MODULE_TYPE, z2 ? homeBusinessInfoRvModel2.mModuleType : str);
                    if (z2) {
                        str = homeBusinessInfoRvModel2.mModuleIndex;
                    }
                    addEventParam.addEventParam(ParamConst.PARAM_MODULE_SEQUENCE, str).addEventParam(ParamConst.TRACE_ID, homeBusinessInfoRvModel2.mTraceId).build().track();
                }
            });
        }
    }

    public void itemExposureForRecommendCard(final SearchRecommendCardModel searchRecommendCardModel) {
        if (!CollectionsUtil.isEmpty(searchRecommendCardModel.mCardWordList)) {
            final String a = m31093a(searchRecommendCardModel);
            m31095a(new OnceActionUtil.OnceAction(new Object[]{searchRecommendCardModel.mComponentType, searchRecommendCardModel.mSessionId, Integer.valueOf(searchRecommendCardModel.mSessionIter), a}) {
                public void run() {
                    SearchRecCardExposureModel searchRecCardExposureModel = new SearchRecCardExposureModel();
                    searchRecCardExposureModel.location = a;
                    searchRecCardExposureModel.status = -1;
                    searchRecCardExposureModel.recId = searchRecommendCardModel.mRecId;
                    searchRecCardExposureModel.sessionID = searchRecommendCardModel.mSessionId;
                    searchRecCardExposureModel.sessionIter = searchRecommendCardModel.mSessionIter;
                    searchRecCardExposureModel.words = searchRecommendCardModel.mCardWordList;
                    SearchNewOmegaHelper.this.m31089a(EventConst.Search.SHOP_EXPOSURE).addEventParam("content_json", GsonUtil.toJson(searchRecCardExposureModel)).addEventParam(ParamConst.TRACE_ID, searchRecommendCardModel.traceId).build().track();
                }
            });
        }
    }

    public void setBusinessGuideParam(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        String a = m31091a(homeBusinessInfoRvModel);
        String str = homeBusinessInfoRvModel.mRecId;
        m31094a(a, str, "shop_" + homeBusinessInfoRvModel.mShopId);
    }

    public void setGoodsGuideParam(HomeBusinessInfoRvModel homeBusinessInfoRvModel, SearchFoodItemView.SearchFoodItemModel searchFoodItemModel) {
        String a = m31092a(homeBusinessInfoRvModel, searchFoodItemModel);
        String str = homeBusinessInfoRvModel.mRecId;
        m31094a(a, str, com.didichuxing.dfbasesdk.utils.StringUtils.SP_DATA_ITEM + searchFoodItemModel.goodsId);
    }

    public void trackBusinessClick(HomeBusinessInfoRvModel homeBusinessInfoRvModel, SearchFoodItemView.SearchFoodItemModel searchFoodItemModel, boolean z) {
        String str;
        SearchWordModel value = ((SearchWordRepo) RepoFactory.getRepo(SearchWordRepo.class)).getValue();
        SearchWordModel.SearchFrom searchFrom = value.mSearchFrom;
        String str2 = "";
        String str3 = TextUtils.equals(homeBusinessInfoRvModel.mModuleIndex, "default") ? str2 : homeBusinessInfoRvModel.mModuleIndex;
        OmegaTracker.Builder a = m31089a(EventConst.Search.SHOP_CK);
        if (searchFoodItemModel == null) {
            str = str2;
        } else {
            str = searchFoodItemModel.goodsId;
        }
        OmegaTracker.Builder addEventParam = a.addEventParam("item_id", str).addEventParam("shop_id", homeBusinessInfoRvModel.mShopId);
        int i = 0;
        OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("event_type", Integer.valueOf(searchFoodItemModel == null ? 0 : 1)).addEventParam(ParamConst.PARAM_SHOP_STATUS, Integer.valueOf(homeBusinessInfoRvModel.mShopStatus));
        OmegaTracker.Builder addEventParam3 = addEventParam2.addEventParam(ParamConst.PARAM_SHOP_DELIVERY_FEE, homeBusinessInfoRvModel.mCurrency + "_" + homeBusinessInfoRvModel.mDeliveryPriceOri + "_" + homeBusinessInfoRvModel.mDeliveryPriceAct).addEventParam(ParamConst.PARAM_SHOP_DELIVERY_TIME, Integer.valueOf(homeBusinessInfoRvModel.mDeliveryTime)).addEventParam(ParamConst.PARAM_SHOP_TAG, SentenceUtil.foldStringList(homeBusinessInfoRvModel.mShopTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_DISCOUNT_TAG, SentenceUtil.foldStringList(homeBusinessInfoRvModel.mActTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_MAIN_TAG, homeBusinessInfoRvModel.mShopCateInfoDescForTrack).addEventParam("rec_id", homeBusinessInfoRvModel.mRecId).addEventParam(ParamConst.TRACE_ID, homeBusinessInfoRvModel.mTraceId).addEventParam("module", homeBusinessInfoRvModel.mModuleId).addEventParam(ParamConst.SORT_TYPE, Integer.valueOf(value.mSortType.getValue())).addEventParam(ParamConst.ITEM_POSITION, str3).addEventParam(ParamConst.PARAM_MODULE_TYPE, z ? homeBusinessInfoRvModel.mModuleType : str2).addEventParam(ParamConst.PARAM_MODULE_SEQUENCE, z ? homeBusinessInfoRvModel.mModuleIndex : str2).addEventParam(ParamConst.PARAM_IS_RECOMMEND_REASON, Integer.valueOf(z ? homeBusinessInfoRvModel.mRecInfo == null ? 2 : 1 : 0)).addEventParam("search_word_type", Integer.valueOf(homeBusinessInfoRvModel.intentionType));
        if (homeBusinessInfoRvModel.mComponentType != null) {
            str2 = homeBusinessInfoRvModel.mComponentType;
        }
        OmegaTracker.Builder addEventParam4 = addEventParam3.addEventParam(ParamConst.PARAM_SEARCH_SHOP_TYPE, str2);
        if (homeBusinessInfoRvModel.mFoodItems != null) {
            i = homeBusinessInfoRvModel.mFoodItems.size();
        }
        addEventParam4.addEventParam(ParamConst.PARAM_ITEM_RECALL_NUM, Integer.valueOf(i)).addEventParam("from", Integer.valueOf(getFromPageValueForTrack(homeBusinessInfoRvModel.fromPage))).addEventParam(ParamConst.PARAM_IS_SHOP_LOGO, Integer.valueOf(TextUtils.isEmpty(homeBusinessInfoRvModel.mLogo) ^ true ? 1 : 0)).addEventParam(ParamConst.FILTER_PARAM, homeBusinessInfoRvModel.mPageFilter).enableGuideParam().build().track();
    }

    public void trackBusinessOrGoodsClick(HomeBusinessInfoRvModel homeBusinessInfoRvModel, SearchFoodItemView.SearchFoodItemModel searchFoodItemModel, boolean z) {
        String str;
        SearchWordModel value = ((SearchWordRepo) RepoFactory.getRepo(SearchWordRepo.class)).getValue();
        String str2 = value.mSearchFrom == SearchWordModel.SearchFrom.RECOMMEND ? "searchrec" : "searchresult";
        OmegaTracker.Builder a = m31089a(EventConst.Search.SHOP_CK);
        String str3 = "";
        if (searchFoodItemModel == null) {
            str = str3;
        } else {
            str = searchFoodItemModel.goodsId;
        }
        OmegaTracker.Builder addEventParam = a.addEventParam("item_id", str).addEventParam("shop_id", homeBusinessInfoRvModel.mShopId);
        int i = 0;
        OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("event_type", Integer.valueOf(searchFoodItemModel == null ? 0 : 1)).addEventParam(ParamConst.PARAM_SHOP_STATUS, Integer.valueOf(homeBusinessInfoRvModel.mShopStatus));
        OmegaTracker.Builder addEventParam3 = addEventParam2.addEventParam(ParamConst.PARAM_SHOP_DELIVERY_FEE, homeBusinessInfoRvModel.mCurrency + "_" + homeBusinessInfoRvModel.mDeliveryPriceOri + "_" + homeBusinessInfoRvModel.mDeliveryPriceAct).addEventParam(ParamConst.PARAM_SHOP_DELIVERY_TIME, Integer.valueOf(homeBusinessInfoRvModel.mDeliveryTime)).addEventParam(ParamConst.PARAM_SHOP_TAG, SentenceUtil.foldStringList(homeBusinessInfoRvModel.mShopTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_DISCOUNT_TAG, SentenceUtil.foldStringList(homeBusinessInfoRvModel.mActTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_MAIN_TAG, homeBusinessInfoRvModel.mShopCateInfoDescForTrack).addEventParam("rec_id", homeBusinessInfoRvModel.mRecId).addEventParam(ParamConst.TRACE_ID, homeBusinessInfoRvModel.mTraceId).addEventParam("module", str2).addEventParam(ParamConst.SORT_TYPE, Integer.valueOf(value.mSortType.getValue())).addEventParam(ParamConst.ITEM_POSITION, homeBusinessInfoRvModel.mModuleIndex).addEventParam(ParamConst.PARAM_MODULE_TYPE, z ? homeBusinessInfoRvModel.mModuleType : str3);
        if (z) {
            str3 = homeBusinessInfoRvModel.mModuleIndex;
        }
        OmegaTracker.Builder addEventParam4 = addEventParam3.addEventParam(ParamConst.PARAM_MODULE_SEQUENCE, str3);
        if (z) {
            i = homeBusinessInfoRvModel.mRecInfo == null ? 2 : 1;
        }
        addEventParam4.addEventParam(ParamConst.PARAM_IS_RECOMMEND_REASON, Integer.valueOf(i)).enableGuideParam().build().track();
    }

    public void trackGoodsClick(HomeBusinessInfoRvModel homeBusinessInfoRvModel, SearchFoodItemView.SearchFoodItemModel searchFoodItemModel, boolean z, int i) {
        String str;
        SearchWordModel value = ((SearchWordRepo) RepoFactory.getRepo(SearchWordRepo.class)).getValue();
        OmegaTracker.Builder a = m31089a(EventConst.Search.SHOP_WITH_DISH_CK);
        String str2 = "";
        if (searchFoodItemModel == null) {
            str = str2;
        } else {
            str = searchFoodItemModel.goodsId;
        }
        OmegaTracker.Builder addEventParam = a.addEventParam("item_id", str).addEventParam("shop_id", homeBusinessInfoRvModel.mShopId).addEventParam("price", Integer.valueOf(searchFoodItemModel.price)).addEventParam("discount_price", Integer.valueOf(searchFoodItemModel.specialPrice)).addEventParam("module", homeBusinessInfoRvModel.mModuleId).addEventParam("page", "searchpage").addEventParam("rec_id", homeBusinessInfoRvModel.mRecId).addEventParam(ParamConst.PARAM_ABSOLUTE_POSITION, Integer.valueOf(homeBusinessInfoRvModel.mAbsoluteIndex)).addEventParam("index", Integer.valueOf(searchFoodItemModel.position)).addEventParam("from", Integer.valueOf(getFromPageValueForTrack(homeBusinessInfoRvModel.fromPage))).addEventParam("search_word_type", Integer.valueOf(homeBusinessInfoRvModel.intentionType)).addEventParam(ParamConst.PARAM_SEARCH_SHOP_TYPE, homeBusinessInfoRvModel.mComponentType).addEventParam("button_type", Integer.valueOf(i));
        int i2 = 0;
        int i3 = 1;
        OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("has_multi_content", Integer.valueOf(searchFoodItemModel.maxLevel > 1 ? 1 : 0)).addEventParam(ParamConst.FILTER_PARAM, homeBusinessInfoRvModel.mPageFilter).addEventParam("event_type", Integer.valueOf(searchFoodItemModel == null ? 0 : 1)).addEventParam(ParamConst.PARAM_SHOP_STATUS, Integer.valueOf(homeBusinessInfoRvModel.mShopStatus));
        OmegaTracker.Builder addEventParam3 = addEventParam2.addEventParam(ParamConst.PARAM_SHOP_DELIVERY_FEE, homeBusinessInfoRvModel.mCurrency + "_" + homeBusinessInfoRvModel.mDeliveryPriceOri + "_" + homeBusinessInfoRvModel.mDeliveryPriceAct).addEventParam(ParamConst.PARAM_SHOP_DELIVERY_TIME, Integer.valueOf(homeBusinessInfoRvModel.mDeliveryTime)).addEventParam(ParamConst.PARAM_SHOP_TAG, SentenceUtil.foldStringList(homeBusinessInfoRvModel.mShopTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_DISCOUNT_TAG, SentenceUtil.foldStringList(homeBusinessInfoRvModel.mActTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_MAIN_TAG, homeBusinessInfoRvModel.mShopCateInfoDescForTrack).addEventParam(ParamConst.TRACE_ID, homeBusinessInfoRvModel.mTraceId).addEventParam(ParamConst.SORT_TYPE, Integer.valueOf(value.mSortType.getValue())).addEventParam(ParamConst.ITEM_POSITION, homeBusinessInfoRvModel.mModuleIndex).addEventParam(ParamConst.PARAM_MODULE_TYPE, z ? homeBusinessInfoRvModel.mModuleType : str2);
        if (z) {
            str2 = homeBusinessInfoRvModel.mModuleIndex;
        }
        OmegaTracker.Builder addEventParam4 = addEventParam3.addEventParam(ParamConst.PARAM_MODULE_SEQUENCE, str2);
        if (!z) {
            i3 = 0;
        } else if (homeBusinessInfoRvModel.mRecInfo == null) {
            i3 = 2;
        }
        OmegaTracker.Builder addEventParam5 = addEventParam4.addEventParam(ParamConst.PARAM_IS_RECOMMEND_REASON, Integer.valueOf(i3)).addEventParam("search_word_type", Integer.valueOf(homeBusinessInfoRvModel.intentionType));
        if (homeBusinessInfoRvModel.mFoodItems != null) {
            i2 = homeBusinessInfoRvModel.mFoodItems.size();
        }
        addEventParam5.addEventParam(ParamConst.PARAM_ITEM_RECALL_NUM, Integer.valueOf(i2)).addEventParam(ParamConst.FILTER_PARAM, homeBusinessInfoRvModel.mPageFilter).addEventParam("type", homeBusinessInfoRvModel.mComponentType).build().track();
    }

    public void trackRecommendTagShow(String str, int i, List<SearchHotWordsModel> list) {
        List<SearchHotWordsModel> list2;
        int i2;
        if (list != null) {
            i2 = list.size();
            if (i2 >= i) {
                list2 = list.subList(0, i);
            } else {
                return;
            }
        } else {
            list2 = null;
            i2 = 0;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list2.size(); i3++) {
            SearchHotWordsModel searchHotWordsModel = list2.get(i3);
            if (searchHotWordsModel != null && !TextUtils.isEmpty(searchHotWordsModel.getWord())) {
                arrayList.add(searchHotWordsModel.getWord());
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            SearchHotWordsModel searchHotWordsModel2 = list.get(i4);
            if (searchHotWordsModel2 != null && !TextUtils.isEmpty(searchHotWordsModel2.getWord())) {
                arrayList2.add(searchHotWordsModel2.getWord());
            }
        }
        m31089a(EventConst.Search.REC_WORD_SW).addEventParam(ParamConst.RECOMMEND_REC_ID, str).addEventParam(ParamConst.RECOMMEND_REC_NUM, Integer.valueOf(i2)).addEventParam(ParamConst.RECOMMEND_TAG_LIST, SentenceUtil.foldStringList(arrayList2, ",")).addEventParam(ParamConst.VISIBLE_RECOMMEND_TAG_NUM, Integer.valueOf(i)).addEventParam(ParamConst.VISIBLE_RECOMMEND_TAG_LIST, SentenceUtil.foldStringList(arrayList, ",")).build().track();
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
        m31089a(EventConst.Search.HISTORY_WORD).addEventParam(ParamConst.RECOMMEND_REC_ID, str).addEventParam(ParamConst.HISTORY_NUM, Integer.valueOf(i2)).addEventParam(ParamConst.HISTORY_LIST, SentenceUtil.foldStringList(list, ",")).addEventParam(ParamConst.VISIBLE_HISTORY_NUM, Integer.valueOf(i)).addEventParam(ParamConst.VISIBLE_HISTORY_LIST, SentenceUtil.foldStringList(list2, ",")).build().track();
    }

    public void trackSearchWordInput(String str) {
        m31089a(EventConst.Search.SEARCH_WORD_INPUT).addEventParam("name", str).build().track();
    }

    public void trackSearchEditViewClick() {
        m31089a(EventConst.Search.SEARCH_EDITVIEW_CK).build().track();
    }

    public void trackHistoryWordClick(String str, String str2, int i) {
        m31089a(EventConst.Search.HISTORY_WORD_CK).addEventParam("name", str).addEventParam("rec_id", str2).build().track();
    }

    public void trackRecommendWordClick(String str, String str2, int i) {
        m31089a(EventConst.Search.RECOMMENT_WORD_CK).addEventParam("name", str).addEventParam("rec_id", str2).build().track();
    }

    public void trackSugWordResultShow(SearchSuggestionState searchSuggestionState, int i) {
        if (!TextUtils.isEmpty(searchSuggestionState.searchKey)) {
            m31089a(EventConst.Search.SUGGESTION_SW).addEventParam(ParamConst.INPUT_WORD, searchSuggestionState.searchKey).addEventParam("result_num", Integer.valueOf(i)).addEventParam(ParamConst.SUG_REG_ID, searchSuggestionState.sugId).addEventParam("index", Integer.valueOf(searchSuggestionState.sugIndex)).addEventParam(ParamConst.SUG_TRACE_ID, searchSuggestionState.traceId).enableGuideParam().build().track();
        }
    }

    public void trackSearchBackClick(Boolean bool) {
        String str;
        WeakReference<ScopeContext> weakReference = this.f43768c;
        if (weakReference != null) {
            ScopeContext scopeContext = (ScopeContext) weakReference.get();
            if (bool.booleanValue()) {
                str = RoutePath.SEARCH_RESULT_PAGE;
            } else {
                str = (scopeContext == null || scopeContext.getObject("PageName") == null) ? "" : (String) scopeContext.getObject("PageName");
            }
            m31089a("sailing_c_x_page_return_ck").addEventParam("from", str).build().track();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trackSearchHotWordCK(com.didi.soda.search.repo.SearchHotWordsModel r6, java.lang.String r7) {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            java.lang.ref.WeakReference<com.didi.app.nova.skeleton.ScopeContext> r1 = r5.f43768c     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x002c
            java.lang.ref.WeakReference<com.didi.app.nova.skeleton.ScopeContext> r1 = r5.f43768c     // Catch:{ Exception -> 0x00d7 }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x00d7 }
            com.didi.app.nova.skeleton.ScopeContext r1 = (com.didi.app.nova.skeleton.ScopeContext) r1     // Catch:{ Exception -> 0x00d7 }
            android.os.Bundle r3 = r1.getBundle()     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r4 = "fromPage"
            java.lang.String r3 = r3.getString(r4)     // Catch:{ Exception -> 0x00d7 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00d7 }
            if (r4 == 0) goto L_0x002d
            java.lang.String r3 = "PageName"
            java.lang.Object r1 = r1.getObject(r3)     // Catch:{ Exception -> 0x00d7 }
            r3 = r1
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x00d7 }
            goto L_0x002d
        L_0x002c:
            r3 = r2
        L_0x002d:
            java.lang.String r1 = "homePage"
            boolean r1 = r3.contains(r1)     // Catch:{ Exception -> 0x00d7 }
            if (r1 == 0) goto L_0x0037
            r0 = 1
            goto L_0x004a
        L_0x0037:
            java.lang.String r1 = "specialpage"
            boolean r1 = r3.contains(r1)     // Catch:{ Exception -> 0x00d7 }
            if (r1 != 0) goto L_0x0049
            java.lang.String r1 = "shopCategoryLandingPage"
            boolean r1 = r3.contains(r1)     // Catch:{ Exception -> 0x00d7 }
            if (r1 == 0) goto L_0x004a
        L_0x0049:
            r0 = 2
        L_0x004a:
            java.lang.String r1 = "sailing_c_x_search_common_ck"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r5.m31089a((java.lang.String) r1)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r3 = "poplular_recid"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r1.addEventParam(r3, r7)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r1 = "input_word"
            java.lang.String r3 = r6.getWord()     // Catch:{ Exception -> 0x00d7 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00d7 }
            if (r3 != 0) goto L_0x0069
            java.lang.String r3 = r6.getWord()     // Catch:{ Exception -> 0x00d7 }
            goto L_0x006a
        L_0x0069:
            r3 = r2
        L_0x006a:
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r7.addEventParam(r1, r3)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r1 = "activity_id"
            java.lang.String r3 = r6.getActivityId()     // Catch:{ Exception -> 0x00d7 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00d7 }
            if (r3 != 0) goto L_0x007f
            java.lang.String r3 = r6.getActivityId()     // Catch:{ Exception -> 0x00d7 }
            goto L_0x0080
        L_0x007f:
            r3 = r2
        L_0x0080:
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r7.addEventParam(r1, r3)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r1 = "activity_type"
            java.lang.String r3 = r6.getActivityCate()     // Catch:{ Exception -> 0x00d7 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00d7 }
            if (r3 != 0) goto L_0x0095
            java.lang.String r3 = r6.getActivityCate()     // Catch:{ Exception -> 0x00d7 }
            goto L_0x0096
        L_0x0095:
            r3 = r2
        L_0x0096:
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r7.addEventParam(r1, r3)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r1 = "from"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x00d7 }
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r7.addEventParam(r1, r0)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r0 = "resource_id"
            java.lang.String r1 = r6.getResourceId()     // Catch:{ Exception -> 0x00d7 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00d7 }
            if (r1 != 0) goto L_0x00b6
            java.lang.String r1 = r6.getResourceId()     // Catch:{ Exception -> 0x00d7 }
            goto L_0x00b7
        L_0x00b6:
            r1 = r2
        L_0x00b7:
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r7.addEventParam(r0, r1)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r0 = "activity_url"
            java.lang.String r1 = r6.getUrl()     // Catch:{ Exception -> 0x00d7 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00d7 }
            if (r1 != 0) goto L_0x00cb
            java.lang.String r2 = r6.getUrl()     // Catch:{ Exception -> 0x00d7 }
        L_0x00cb:
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r6 = r7.addEventParam(r0, r2)     // Catch:{ Exception -> 0x00d7 }
            com.didi.soda.customer.foundation.tracker.OmegaTracker r6 = r6.build()     // Catch:{ Exception -> 0x00d7 }
            r6.track()     // Catch:{ Exception -> 0x00d7 }
            goto L_0x00db
        L_0x00d7:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.search.helper.SearchNewOmegaHelper.trackSearchHotWordCK(com.didi.soda.search.repo.SearchHotWordsModel, java.lang.String):void");
    }

    public void reset() {
        OnceActionUtil.ActionPool actionPool = this.f43769d;
        if (actionPool != null) {
            actionPool.reset();
        }
    }

    /* renamed from: a */
    private void m31095a(OnceActionUtil.OnceAction... onceActionArr) {
        OnceActionUtil.ActionPool actionPool = this.f43769d;
        if (actionPool != null) {
            actionPool.doAction(onceActionArr);
        }
    }

    /* renamed from: a */
    private String m31091a(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        return "searchPage_" + homeBusinessInfoRvModel.mModuleId + "_paginatedModule_" + getComponentDescWithType(homeBusinessInfoRvModel.mComponentType) + "_" + homeBusinessInfoRvModel.mModuleIndex + "_" + homeBusinessInfoRvModel.mPageInModule + "_" + homeBusinessInfoRvModel.mIndexInModule + "_1_" + homeBusinessInfoRvModel.mAbsoluteIndex;
    }

    /* renamed from: a */
    private String m31092a(HomeBusinessInfoRvModel homeBusinessInfoRvModel, SearchFoodItemView.SearchFoodItemModel searchFoodItemModel) {
        return "searchPage_" + homeBusinessInfoRvModel.mModuleId + "_" + homeBusinessInfoRvModel.mModuleType + "_item_" + homeBusinessInfoRvModel.mModuleIndex + "_" + homeBusinessInfoRvModel.mPageInModule + "_" + homeBusinessInfoRvModel.mRowInModule + "_" + homeBusinessInfoRvModel.mColumnInModule + "_" + homeBusinessInfoRvModel.mIndexInModule + "_" + searchFoodItemModel.goodsId + "_" + searchFoodItemModel.position;
    }

    /* renamed from: a */
    private String m31093a(SearchRecommendCardModel searchRecommendCardModel) {
        return "searchPage_" + searchRecommendCardModel.mModuleId + "_" + searchRecommendCardModel.mModuleType + "_" + searchRecommendCardModel.mComponentType + "_" + searchRecommendCardModel.mModuleIndex + "_" + searchRecommendCardModel.mPageInModule + "_" + searchRecommendCardModel.mRowInModule + "_" + searchRecommendCardModel.mColumnInModule + "_" + searchRecommendCardModel.mIndexInModule;
    }

    /* renamed from: a */
    private String m31090a(int i) {
        return "searchPage_search_fullAmountModule_searchWords_3_0_0_0_" + i;
    }

    /* renamed from: a */
    private void m31094a(String str, String str2, String str3) {
        OmegaCommonParamHelper.setLv1Location(str);
        OmegaCommonParamHelper.setLv1RecId(str2);
        OmegaCommonParamHelper.setLv1Body(str3);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public OmegaTracker.Builder m31089a(String str) {
        WeakReference<ScopeContext> weakReference = this.f43768c;
        if (weakReference != null) {
            return OmegaTracker.Builder.create(str, (ScopeContext) weakReference.get());
        }
        return OmegaTracker.Builder.create(str);
    }

    public void headerFilterSw(final String str, final String str2, String str3) {
        m31095a(new OnceActionUtil.OnceAction(str3) {
            public void run() {
                SearchNewOmegaHelper.this.m31089a(EventConst.Home.HOME_FILTER_ITEM_REALEXPOSURE_SW).addEventParam(ParamConst.PARAM_FILTER_INFO, str2).addEventParam("resource_id", str).addEventParam("from", 3).build().track();
            }
        });
    }

    public void brandSearchSeeMoreCk(String str, int i) {
        OmegaTracker.Builder a = m31089a(EventConst.Home.HOME_SEARCH_RESULT_SEE_MORE_CK);
        if (str == null) {
            str = "";
        }
        a.addEventParam("search_word", str).addEventParam("search_word_source", Integer.valueOf(i)).build().track();
    }
}
