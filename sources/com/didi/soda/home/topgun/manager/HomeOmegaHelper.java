package com.didi.soda.home.topgun.manager;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.common.map.model.LatLng;
import com.didi.sdk.util.SystemUtil;
import com.didi.security.uuid.adapter.DeviceTokenWrapper;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.binder.model.banner.BannerRvModel;
import com.didi.soda.customer.debug.PoiUtil;
import com.didi.soda.customer.foundation.rpc.entity.OrderTipsEntity;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.CategoryEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.FilterEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.model.HomeRealExposureModelV2;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import com.didi.soda.customer.foundation.util.SentenceUtil;
import com.didi.soda.customer.foundation.util.startup.FallbackController;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.tabbar.TabBarItem;
import com.didi.soda.customer.widget.text.RichTextParser;
import com.didi.soda.home.binder.model.AllCategoryItemModel;
import com.didi.soda.home.topgun.binder.HomeBusinessItemBinder;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.home.topgun.binder.model.HomeEfoRvModel;
import com.didi.soda.home.topgun.binder.model.HomeHeaderRvModel;
import com.didi.soda.home.topgun.binder.model.HomeOrderCardRvModel;
import com.didi.soda.home.topgun.binder.model.HomeTopicRvModel;
import com.didi.soda.home.topgun.model.FilterItemParam;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.home.topgun.model.HomeSearchHotWordsModel;
import com.didi.soda.home.topgun.widget.HomeTopicOperationView;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.search.repo.SearchWordRepo;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeOmegaHelper implements HomeBusinessItemBinder.HomeBusinessOmegaInterface {

    /* renamed from: a */
    private static final String f42994a = "HomeOmegaHelper";

    /* renamed from: b */
    private static HomeOmegaHelper f42995b = new HomeOmegaHelper();

    /* renamed from: c */
    private WeakReference<ScopeContext> f42996c;

    /* renamed from: d */
    private OnceActionUtil.ActionPool f42997d;

    /* renamed from: e */
    private boolean f42998e = false;

    public static HomeOmegaHelper getInstance() {
        return f42995b;
    }

    public void attach(ScopeContext scopeContext) {
        this.f42996c = new WeakReference<>(scopeContext);
        this.f42997d = new OnceActionUtil.ActionPool();
    }

    public void detach(ScopeContext scopeContext) {
        WeakReference<ScopeContext> weakReference = this.f42996c;
        if (weakReference != null && scopeContext == weakReference.get()) {
            this.f42996c = null;
            this.f42997d = null;
        }
    }

    public void reset() {
        OnceActionUtil.ActionPool actionPool = this.f42997d;
        if (actionPool != null) {
            actionPool.reset();
        }
    }

    public void trackHeaderSpecialBannerCk(HomeHeaderRvModel homeHeaderRvModel) {
        OmegaTracker.Builder.create(EventConst.Home.HOME_HEADER_SPECIAL_CK).addEventParam("activity_id", homeHeaderRvModel.f42770id).addEventParam("activity_type", homeHeaderRvModel.activityType).addEventParam("rec_id", homeHeaderRvModel.recId).addEventParam(ParamConst.PARAM_ABSOLUTE_POSITION, 0).build().track();
    }

    public void trackHeaderSpecialBannerSw(final HomeHeaderRvModel homeHeaderRvModel) {
        m30428a(new OnceActionUtil.OnceAction(homeHeaderRvModel.f42770id) {
            public void run() {
                OmegaTracker.Builder.create(EventConst.Home.HOME_HEADER_SPECIAL_SW).addEventParam("activity_id", homeHeaderRvModel.f42770id).addEventParam("activity_type", homeHeaderRvModel.activityType).addEventParam("rec_id", homeHeaderRvModel.recId).addEventParam("resource_id", homeHeaderRvModel.resourceId).addEventParam("activity_url", homeHeaderRvModel.link).addEventParam(ParamConst.PARAM_ABSOLUTE_POSITION, 0).build().track();
            }
        });
    }

    public void trackFeedDataSw(int i, String str, boolean z, boolean z2) {
        OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create(EventConst.Home.END_REQUEST_FEED_INDEX).addEventParam("error_type", Integer.valueOf(i)).addEventParam("error_msg", str);
        int i2 = 1;
        OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("is_suc", Integer.valueOf(z ? 1 : 2));
        if (!z2) {
            i2 = 2;
        }
        addEventParam2.addEventParam(ParamConst.PARAM_HAS_MORE, Integer.valueOf(i2)).build().track();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void homeAddressNoneSW(boolean r4, boolean r5, boolean r6) {
        /*
            r3 = this;
            boolean r0 = com.didi.soda.customer.app.GlobalContext.isEmbed()
            if (r0 != 0) goto L_0x0021
            android.content.Context r0 = com.didi.soda.customer.app.GlobalContext.getContext()
            boolean r1 = r0 instanceof androidx.fragment.app.FragmentActivity
            if (r1 == 0) goto L_0x0021
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
            android.content.Intent r0 = r0.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L_0x0021
            java.lang.String r1 = "OutsideScheme"
            java.lang.String r0 = r0.getString(r1)
            goto L_0x0023
        L_0x0021:
            java.lang.String r0 = ""
        L_0x0023:
            r1 = 1
            r2 = 2
            if (r5 != 0) goto L_0x0029
            r5 = 4
            goto L_0x002e
        L_0x0029:
            if (r6 != 0) goto L_0x002d
            r5 = 1
            goto L_0x002e
        L_0x002d:
            r5 = 2
        L_0x002e:
            java.lang.String r6 = "sailing_c_x_homepage_address_none_sw"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r6 = r3.m30426a((java.lang.String) r6)
            if (r4 == 0) goto L_0x0038
            r1 = 2
        L_0x0038:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
            java.lang.String r1 = "from"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r6.addEventParam(r1, r4)
            java.lang.String r6 = "url"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r4.addEventParam(r6, r0)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "is_location"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r4.addEventParam(r6, r5)
            com.didi.soda.customer.foundation.tracker.OmegaTracker r4 = r4.build()
            r4.track()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.manager.HomeOmegaHelper.homeAddressNoneSW(boolean, boolean, boolean):void");
    }

    public void headerAddressClick() {
        m30426a(EventConst.Home.HOME_ADDRESS_CK).build().track();
    }

    public void headerPersonCenterClick() {
        m30426a(EventConst.Home.HOME_PERSON_CENTER_CK).build().track();
    }

    public void headerFilterSw(final String str, final String str2, String str3) {
        m30428a(new OnceActionUtil.OnceAction(str3) {
            public void run() {
                HomeOmegaHelper.this.m30426a(EventConst.Home.HOME_FILTER_ITEM_REALEXPOSURE_SW).addEventParam(ParamConst.PARAM_FILTER_INFO, str2).addEventParam("resource_id", str).addEventParam("from", 1).build().track();
            }
        });
    }

    public void filterResultSw(List<FilterModel> list, int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(",");
            sb.append(list.get(i2).getTrackTitle());
            sb.append("_");
            sb.append(i2);
        }
        m30426a(EventConst.Home.HOME_FILTER_ITEM_SW).addEventParam(ParamConst.PARAM_FILTER_LOCATION, sb.toString().replaceFirst(",", "")).addEventParam("from", Integer.valueOf(i)).build().track();
    }

    public void headerFilterItemOutClick(String str, int i, boolean z, String str2) {
        m30426a(EventConst.Home.HOME_FILTER_ITEM_OUT_CLICK).addEventParam(ParamConst.PARAM_FILTER_RESTAURANT_FEATTURE, str).addEventParam(ParamConst.PARAM_FILTER_CLICK_STATUS, Integer.valueOf(z ^ true ? 1 : 0)).addEventParam("from", Integer.valueOf(i)).addEventParam("resource_id", str2).build().track();
    }

    public void headerFilterClick(int i, int i2) {
        if (i == 1) {
            m30426a(EventConst.Home.HOME_FILTER_ITEM_SORT_CK).addEventParam("from", Integer.valueOf(i2)).build().track();
        } else if (i == 2) {
            m30426a(EventConst.Home.HOME_FILTER_ITEM_CATE_CK).build().track();
        } else if (i != 4) {
            m30426a(EventConst.Home.HOME_FILTER_OUTSIDE_CK).addEventParam(ParamConst.PARAM_FILTER_SCENE, String.valueOf(i)).addEventParam("from", Integer.valueOf(i2)).build().track();
        } else {
            m30426a(EventConst.Home.HOME_FILTER_ITEM_MUL_CK).addEventParam("from", Integer.valueOf(i2)).build().track();
        }
    }

    public void traceFilterResetSW(String str) {
        m30428a(new OnceActionUtil.OnceAction(str) {
            public void run() {
                HomeOmegaHelper.this.m30426a(EventConst.Home.HOME_FILTER_RESET_SHOW).build().track();
            }
        });
    }

    public void traceFilterResetCK() {
        m30426a(EventConst.Home.HOME_FILTER_RESET_CK).build().track();
    }

    public void traceOutsideConfirmCK(ArrayList<FilterItemParam> arrayList, String str, int i) {
        m30426a(EventConst.Home.HOME_FILTER_OUTSIDE_CONFIRM_CK).addEventParam(ParamConst.FILTER_PARAM, GsonUtil.toJson(arrayList)).addEventParam(ParamConst.PARAM_FILTER_SCENE, str).addEventParam("from", Integer.valueOf(i)).build().track();
    }

    public void onFilterNoResultSw(String str, String str2, String str3, String str4) {
        int i = (TextUtils.equals(RoutePath.SHOP_CATEGORY_LANDING_PAGE, str2) || TextUtils.equals(Const.HomeBusinessPageSource.SHOP_SPECIAL_PAGE, str2)) ? 2 : TextUtils.equals(RoutePath.SEARCH_HOME, str2) ? 3 : 1;
        OmegaTracker.Builder addEventParam = m30426a(EventConst.Home.HOME_FILTER_NO_RESULT_SW).addEventParam(ParamConst.FILTER_PARAM, str).addEventParam("from", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_CATEGORY_ID, str3);
        if (i == 3) {
            try {
                addEventParam.addEventParam("search_word", ((SearchWordRepo) RepoFactory.getRepo(SearchWordRepo.class)).getValue().mSearchTag);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        addEventParam.addEventParam("rec_id", str4);
        addEventParam.build().track();
    }

    public void trackFilterSortConfirm(ArrayList<FilterItemParam> arrayList, int i, String str) {
        m30426a(EventConst.Home.HOME_FILTER_ITEM_SORT_SELECT_CK).addEventParam(ParamConst.FILTER_PARAM, GsonUtil.toJson(arrayList)).addEventParam("from", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_CATEGORY_ID, str).build().track();
    }

    public void trackFilterCategoryConfirm(CategoryEntity categoryEntity, int i, String str, String str2) {
        m30426a(EventConst.Home.HOME_FILTER_ITEM_CATE_SELECT_CK).addEventParam(ParamConst.PARAM_CATEGORY_ID, categoryEntity.getCateId()).addEventParam(ParamConst.PARAM_CATEGORY_POSITION, Integer.valueOf(i)).addEventParam("activity_type", categoryEntity.getActivityCate()).addEventParam("rec_id", str).addEventParam("activity_id", categoryEntity.getActivityId()).addEventParam("type", categoryEntity.getType()).addEventParam("page", str2).build().track();
    }

    public void trackFilterMulConfirm(ArrayList<FilterItemParam> arrayList, int i, String str) {
        m30426a(EventConst.Home.HOME_FILTER_ITEM_MUL_CONFIRM_CK).addEventParam(ParamConst.FILTER_PARAM, GsonUtil.toJson(arrayList)).addEventParam("from", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_CATEGORY_ID, str).build().track();
    }

    public void trackMoudleSW(int i, int i2) {
        m30426a(EventConst.Home.HOME_FILTER_MODULE_INALL_SW).addEventParam(ParamConst.PARAM_FILTER_INFO, Integer.valueOf(i)).addEventParam("from", Integer.valueOf(i2)).build().track();
    }

    public void trackFilterCategoryPanelSw(List<AllCategoryItemModel> list, String str, String str2) {
        if (list != null && !list.isEmpty()) {
            JsonArray jsonArray = new JsonArray();
            for (int i = 0; i < list.size(); i++) {
                AllCategoryItemModel allCategoryItemModel = list.get(i);
                if (!(allCategoryItemModel == null || allCategoryItemModel.getCategory() == null)) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("activity_id", allCategoryItemModel.getCategory().getActivityId());
                    jsonObject.addProperty(ParamConst.PARAM_CATEGORY_ID, allCategoryItemModel.getCategory().getCateId());
                    jsonObject.addProperty("index", (Number) Integer.valueOf(i));
                    jsonObject.addProperty("activity_type", allCategoryItemModel.getCategory().getActivityCate());
                    jsonObject.addProperty("type", (Number) allCategoryItemModel.getCategory().getType());
                    jsonArray.add((JsonElement) jsonObject);
                }
            }
            m30426a(EventConst.Home.HOME_FILTER_CATE_SW).addEventParam(ParamConst.PARAM_CATEGORY_INFO, jsonArray.toString()).addEventParam("rec_id", str).addEventParam("page", str2).build().track();
        }
    }

    public void trackFilterCategoryRealSw(CategoryEntity categoryEntity, int i, String str, String str2) {
        if (categoryEntity != null) {
            OmegaTracker.Builder addEventParam = m30426a(EventConst.Home.HOME_FILTER_CATE_REAL_SW).addEventParam(ParamConst.PARAM_CATEGORY_ID, categoryEntity.getCateId()).addEventParam("activity_id", categoryEntity.getActivityId()).addEventParam("activity_type", categoryEntity.getActivityCate()).addEventParam(ParamConst.PARAM_CATEGORY_POSITION, Integer.valueOf(i)).addEventParam("page", str2);
            if (str == null) {
                str = "";
            }
            addEventParam.addEventParam("rec_id", str).addEventParam("type", categoryEntity.getType()).build().track();
        }
    }

    public void trackMulFilterRest() {
        m30426a(EventConst.Home.HOME_FILTER_ITEM_MUL_CLEAR_CK).build().track();
    }

    public void trackBeginRequest(int i, boolean z) {
        double d;
        String str;
        AddressEntity cacheAddress = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getCacheAddress();
        String str2 = "";
        String json = AddressUtil.checkAddressValid(cacheAddress) ? GsonUtil.toJson(cacheAddress) : str2;
        LatLng currentLatLng = PoiUtil.getCurrentLatLng();
        double d2 = 0.0d;
        if (currentLatLng != null) {
            double d3 = currentLatLng.longitude;
            d2 = currentLatLng.latitude;
            d = d3;
        } else {
            d = 0.0d;
        }
        if (AddressUtil.checkAddressValid(cacheAddress)) {
            str2 = cacheAddress.poi.poiId;
            str = cacheAddress.aid;
        } else {
            str = str2;
        }
        OmegaTracker.Builder addEventParam = m30426a(EventConst.Home.HOME_COMMON_REQUEST_SW).addEventParam("poi_id", str2).addEventParam("aid", str);
        int i2 = 1;
        OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam(ParamConst.PARAM_OPEN_LOCATION, Integer.valueOf(z ? 1 : 2)).addEventParam("has_location", Integer.valueOf(LocationUtil.hasValidLocation() ? 1 : 2));
        if (!AddressUtil.checkAddressValid(cacheAddress)) {
            i2 = 2;
        }
        addEventParam2.addEventParam(ParamConst.PARAM_HAS_CACHE_ADDRESS, Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_CACHE_ADDRESS, json).addEventParam(ParamConst.PARAM_ADDRESS_LAT, Double.valueOf(d2)).addEventParam(ParamConst.PARAM_ADDRESS_LNG, Double.valueOf(d)).addEventParam("scene", Integer.valueOf(i)).build().track();
    }

    public void trackPullRefresh() {
        m30426a(EventConst.Home.HOME_REFRESH).build().track();
    }

    public void trackLoadMore(int i) {
        m30426a(EventConst.Home.HOME_PULL_UP_TO_LOAD).addEventParam(ParamConst.PAGE_NUMBER, Integer.valueOf(i)).build().track();
    }

    public void trackHomeError(int i, String str) {
        m30426a(EventConst.Home.HOME_ERROR_SW).addEventParam("error_type", Integer.valueOf(i)).addEventParam("error_msg", str).build().track();
    }

    public void trackSearchEditViewClick(int i) {
        m30426a(EventConst.Search.SEARCH_EDITVIEW_CK).addEventParam(ParamConst.PARAM_SEARCH_STATUS, Integer.valueOf(i)).build().track();
    }

    public void orderExposure(final HomeOrderCardRvModel homeOrderCardRvModel) {
        if (!TextUtils.isEmpty(homeOrderCardRvModel.mOrderId)) {
            m30428a(new OnceActionUtil.OnceAction(homeOrderCardRvModel.mOrderId) {
                public void run() {
                    OrderTipsEntity orderTipsEntity;
                    int i = homeOrderCardRvModel.mDebtInfoRvModel != null ? homeOrderCardRvModel.mDebtInfoRvModel.mArrearsOrderStatus : 0;
                    String str = "";
                    String str2 = (homeOrderCardRvModel.tips == null || homeOrderCardRvModel.tips.size() <= 0 || (orderTipsEntity = homeOrderCardRvModel.tips.get(0)) == null) ? str : orderTipsEntity.msg;
                    if (homeOrderCardRvModel.mNeedTrackEta) {
                        str = homeOrderCardRvModel.mTimeDesc;
                    }
                    HomeOmegaHelper.this.m30426a(EventConst.Home.HOME_ORDERLIST_SW).addEventParam(ParamConst.PARAM_ORDER_LIST_NUM, Integer.valueOf(homeOrderCardRvModel.mTotalNum)).addEventParam(ParamConst.PARAM_CURRENT_ORDER_NUM, 0).addEventParam(ParamConst.PARAM_CURRENT_ORDER_ID, homeOrderCardRvModel.mOrderId).addEventParam(ParamConst.PARAM_CURRENT_ORDER_STATUS, Integer.valueOf(homeOrderCardRvModel.mStatus)).addEventParam(ParamConst.PARAM_ARREARS_ORDER_STATUS, Integer.valueOf(i)).addEventParam("order_tips", str2).addEventParam("order_eta", str).addEventParam(ParamConst.PARAM_ARREARS_ORDER_SCENE, Integer.valueOf(homeOrderCardRvModel.scene)).build().track();
                }
            });
        }
    }

    public void trackOrderClick(HomeOrderCardRvModel homeOrderCardRvModel) {
        if (!TextUtils.isEmpty(homeOrderCardRvModel.mOrderId)) {
            m30426a(EventConst.Home.HOME_ORDERLIST_CK).addEventParam(ParamConst.PARAM_ORDER_LIST_NUM, Integer.valueOf(homeOrderCardRvModel.mTotalNum)).addEventParam(ParamConst.PARAM_CURRENT_ORDER_NUM, 0).addEventParam(ParamConst.PARAM_CURRENT_ORDER_ID, homeOrderCardRvModel.mOrderId).addEventParam(ParamConst.PARAM_CURRENT_ORDER_STATUS, Integer.valueOf(homeOrderCardRvModel.mStatus)).addEventParam(ParamConst.PARAM_ARREARS_ORDER_STATUS, Integer.valueOf(homeOrderCardRvModel.mDebtInfoRvModel != null ? homeOrderCardRvModel.mDebtInfoRvModel.mArrearsOrderStatus : 0)).build().track();
        }
    }

    public void trackOrderShowAllShow() {
        m30426a(EventConst.Home.HOME_ORDERLIST_SHOWALL_SW).build().track();
    }

    public void trackOrderShowAllClick() {
        m30426a(EventConst.Home.HOME_ORDERLIST_SHOWALL_CK).build().track();
    }

    public void setTofuOmegaGuideParams(HomeTopicOperationView.TopicOperationItemModel topicOperationItemModel) {
        String moduleString = topicOperationItemModel.toModuleString();
        String str = topicOperationItemModel.mRecId;
        m30427a(moduleString, str, "activity_" + topicOperationItemModel.mActId, topicOperationItemModel.mPageFilter);
    }

    public void trackHomeFeedShow(HomeEntity homeEntity, AddressEntity addressEntity, String str, boolean z, boolean z2) {
        String str2;
        String str3;
        String str4;
        int i = 1;
        int i2 = homeEntity == null ? 1 : 0;
        String str5 = "";
        if (addressEntity == null || addressEntity.poi == null) {
            str2 = str5;
            str4 = str2;
            str3 = str4;
        } else {
            str4 = addressEntity.poi.poiId;
            str3 = addressEntity.aid;
            str2 = addressEntity.poi.poiType;
        }
        if (this.f42996c != null) {
            if (!z) {
                i = 4;
            } else if (z2) {
                i = LocationUtil.hasValidLocation() ? 3 : 2;
            }
            ErrInfo errorInfo = LocationUtil.getErrorInfo();
            if (errorInfo != null) {
                str5 = String.valueOf(errorInfo.getErrNo());
            }
            m30426a(EventConst.Home.HOME_COMMON_SW).addEventParam("poi_id", str4).addEventParam("aid", str3).addEventParam("rec_id", str).addEventParam("error_type", Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_IS_LOCATION, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_LOCATION_ERROR_CODE, str5).addEventParam(ParamConst.PARAM_POI_TYPE, str2).build().track();
        }
    }

    public void onOmegaBusinessSw(HomeBusinessInfoRvModel homeBusinessInfoRvModel, boolean z) {
        if (!TextUtils.isEmpty(homeBusinessInfoRvModel.mShopId)) {
            final String moduleString = homeBusinessInfoRvModel.toModuleString();
            final HomeBusinessInfoRvModel homeBusinessInfoRvModel2 = homeBusinessInfoRvModel;
            final boolean z2 = z;
            m30428a(new OnceActionUtil.OnceAction(new Object[]{homeBusinessInfoRvModel.mShopId, homeBusinessInfoRvModel.mComponentType, moduleString}) {
                public void run() {
                    String str;
                    String str2;
                    String str3;
                    HomeRealExposureModelV2 homeRealExposureModelV2 = new HomeRealExposureModelV2();
                    homeRealExposureModelV2.f41103id = homeBusinessInfoRvModel2.mShopId;
                    homeRealExposureModelV2.type = homeBusinessInfoRvModel2.mComponentType;
                    homeRealExposureModelV2.location = moduleString;
                    homeRealExposureModelV2.status = homeBusinessInfoRvModel2.mShopStatus;
                    homeRealExposureModelV2.deliveryFee = homeBusinessInfoRvModel2.mCurrency + "_" + homeBusinessInfoRvModel2.mDeliveryPriceOri + "_" + homeBusinessInfoRvModel2.mDeliveryPriceAct;
                    homeRealExposureModelV2.deliveryTime = homeBusinessInfoRvModel2.mDeliveryTime;
                    homeRealExposureModelV2.deliveryType = homeBusinessInfoRvModel2.mDeliveryType;
                    homeRealExposureModelV2.recId = homeBusinessInfoRvModel2.mRecId;
                    int i = 2;
                    int i2 = 1;
                    homeRealExposureModelV2.hasCouponLogo = homeBusinessInfoRvModel2.mIsCouponLogo ? 1 : 2;
                    if (z2) {
                        if (homeBusinessInfoRvModel2.mRecInfo != null) {
                            i = 1;
                        }
                        homeRealExposureModelV2.hasRecInfo = i;
                    }
                    homeRealExposureModelV2.page = "homepage";
                    homeRealExposureModelV2.module = Const.HomeV3TraceModelId.HOME_PAGE;
                    homeRealExposureModelV2.index = homeBusinessInfoRvModel2.mIndexInModule;
                    homeRealExposureModelV2.absolutePosition = homeBusinessInfoRvModel2.mAbsoluteIndex;
                    homeRealExposureModelV2.cateId = homeBusinessInfoRvModel2.mCateId;
                    homeRealExposureModelV2.isShopLogo = TextUtils.isEmpty(homeBusinessInfoRvModel2.mLogo) ^ true ? 1 : 0;
                    if (!CollectionsUtil.isEmpty(homeBusinessInfoRvModel2.mTags)) {
                        JsonArray jsonArray = new JsonArray();
                        for (PromptEntity next : homeBusinessInfoRvModel2.mTags) {
                            if (next != null) {
                                JsonObject jsonObject = new JsonObject();
                                if (!TextUtils.isEmpty(next.activityId)) {
                                    jsonObject.addProperty("activity_id", next.activityId);
                                }
                                if (!TextUtils.isEmpty(next.activityType)) {
                                    jsonObject.addProperty("activity_type", next.activityType);
                                }
                                if (jsonObject.size() > 0) {
                                    jsonArray.add((JsonElement) jsonObject);
                                }
                            }
                        }
                        if (!jsonArray.isEmpty()) {
                            homeRealExposureModelV2.activityInfos = jsonArray;
                        }
                    }
                    String appInstanceID = ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getAppInstanceID();
                    if (homeBusinessInfoRvModel2.coordShopModel != null) {
                        str3 = homeBusinessInfoRvModel2.coordShopModel.getSynergyShopId();
                        str2 = homeBusinessInfoRvModel2.coordShopModel.getSourcePosition() + "";
                        str = homeBusinessInfoRvModel2.coordShopModel.getSynergySeq() + "";
                    } else {
                        str3 = "";
                        str2 = str3;
                        str = str2;
                    }
                    OmegaTracker.Builder addEventParam = HomeOmegaHelper.this.m30426a(EventConst.Home.HOME_REAL_EXPOSURE_SW).addEventParam("content_json", GsonUtil.toJson(homeRealExposureModelV2)).addEventParam(ParamConst.FILTER_PARAM, homeBusinessInfoRvModel2.mPageFilter).addEventParam(ParamConst.PARAM_MODULE_TYPE, homeBusinessInfoRvModel2.mModuleType).addEventParam(ParamConst.PARAM_MODULE_SEQUENCE, homeBusinessInfoRvModel2.mModuleIndex).addEventParam(ParamConst.TRACE_ID, homeBusinessInfoRvModel2.mTraceId).addEventParam("resource_id", homeBusinessInfoRvModel2.mResourceId).addEventParam(ParamConst.PARAM_PERFORMANCE_APM_ENABLED, Boolean.valueOf(FallbackController.getFallbackInfo().isOpen));
                    if (appInstanceID == null) {
                        appInstanceID = "";
                    }
                    OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam(ParamConst.PARAMS_GOOGLE_APP_INSTANCE_ID, appInstanceID).addEventParam(ParamConst.PARAM_SYNERGY_SHOP_ID, str3).addEventParam(ParamConst.PARAM_SYNERGY_INDEX, str2).addEventParam(ParamConst.PARAM_SYNERGY_SEQ, str);
                    if (homeBusinessInfoRvModel2.coordShopModel == null) {
                        i2 = 0;
                    }
                    addEventParam2.addEventParam(ParamConst.PARAM_IS_SYNERGY, Integer.valueOf(i2)).build().track();
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onOmegaBusinessCk(com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel r10, boolean r11) {
        /*
            r9 = this;
            java.util.List<com.didi.soda.customer.foundation.rpc.entity.PromptEntity> r0 = r10.mTags
            boolean r0 = com.didi.soda.customer.foundation.util.CollectionsUtil.isEmpty(r0)
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x005b
            com.google.gson.JsonArray r0 = new com.google.gson.JsonArray
            r0.<init>()
            java.util.List<com.didi.soda.customer.foundation.rpc.entity.PromptEntity> r2 = r10.mTags
            java.util.Iterator r2 = r2.iterator()
        L_0x0015:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0050
            java.lang.Object r3 = r2.next()
            com.didi.soda.customer.foundation.rpc.entity.PromptEntity r3 = (com.didi.soda.customer.foundation.rpc.entity.PromptEntity) r3
            if (r3 == 0) goto L_0x0015
            com.google.gson.JsonObject r4 = new com.google.gson.JsonObject
            r4.<init>()
            java.lang.String r5 = r3.activityId
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0037
            java.lang.String r5 = r3.activityId
            java.lang.String r6 = "activity_id"
            r4.addProperty((java.lang.String) r6, (java.lang.String) r5)
        L_0x0037:
            java.lang.String r5 = r3.activityType
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0046
            java.lang.String r3 = r3.activityType
            java.lang.String r5 = "activity_type"
            r4.addProperty((java.lang.String) r5, (java.lang.String) r3)
        L_0x0046:
            int r3 = r4.size()
            if (r3 <= 0) goto L_0x0015
            r0.add((com.google.gson.JsonElement) r4)
            goto L_0x0015
        L_0x0050:
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x005b
            java.lang.String r0 = com.didi.soda.customer.foundation.util.GsonUtil.toJson(r0)
            goto L_0x005c
        L_0x005b:
            r0 = r1
        L_0x005c:
            com.didi.soda.customer.coordshop.CoordShopModel r2 = r10.coordShopModel
            if (r2 == 0) goto L_0x0094
            com.didi.soda.customer.coordshop.CoordShopModel r2 = r10.coordShopModel
            java.lang.String r2 = r2.getSynergyShopId()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            com.didi.soda.customer.coordshop.CoordShopModel r4 = r10.coordShopModel
            int r4 = r4.getSourcePosition()
            r3.append(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            com.didi.soda.customer.coordshop.CoordShopModel r5 = r10.coordShopModel
            int r5 = r5.getSynergySeq()
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r8 = r2
            r2 = r1
            r1 = r8
            goto L_0x0096
        L_0x0094:
            r2 = r1
            r3 = r2
        L_0x0096:
            java.lang.String r4 = "sailing_c_x_homepage_shop_ck"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r9.m30426a((java.lang.String) r4)
            java.lang.String r5 = r10.mShopId
            java.lang.String r6 = "shop_id"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r4.addEventParam(r6, r5)
            java.lang.String r5 = r10.mShopName
            java.lang.String r6 = "shop_name"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r4.addEventParam(r6, r5)
            int r5 = r10.mShopStatus
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "shop_status"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r4.addEventParam(r6, r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r10.mCurrency
            r5.append(r6)
            java.lang.String r6 = "_"
            r5.append(r6)
            int r7 = r10.mDeliveryPriceOri
            r5.append(r7)
            r5.append(r6)
            int r6 = r10.mDeliveryPriceAct
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "shop_delivery_fee"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r4.addEventParam(r6, r5)
            int r5 = r10.mDeliveryTime
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "shop_delivery_time"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r4.addEventParam(r6, r5)
            java.util.List<java.lang.String> r5 = r10.mShopTipList
            java.lang.String r6 = ","
            java.lang.String r5 = com.didi.soda.customer.foundation.util.SentenceUtil.foldStringList(r5, r6)
            java.lang.String r7 = "shop_tag"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r4.addEventParam(r7, r5)
            java.util.List<java.lang.String> r5 = r10.mActTipList
            java.lang.String r5 = com.didi.soda.customer.foundation.util.SentenceUtil.foldStringList(r5, r6)
            java.lang.String r6 = "shop_discount_tag"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r4.addEventParam(r6, r5)
            java.lang.CharSequence r5 = r10.mShopCateInfoDescForTrack
            java.lang.String r6 = "shop_main_tag"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r4.addEventParam(r6, r5)
            java.lang.String r5 = r10.mModuleType
            java.lang.String r6 = "module_type"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r4.addEventParam(r6, r5)
            java.lang.String r5 = r10.mModuleIndex
            java.lang.String r6 = "module_sequence"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r4.addEventParam(r6, r5)
            int r5 = r10.mDeliveryType
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "delivery_type"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r4 = r4.addEventParam(r6, r5)
            r5 = 0
            r6 = 1
            if (r11 == 0) goto L_0x013d
            com.didi.soda.customer.foundation.rpc.entity.PromptEntity r11 = r10.mRecInfo
            if (r11 != 0) goto L_0x013b
            r11 = 2
            goto L_0x013e
        L_0x013b:
            r11 = 1
            goto L_0x013e
        L_0x013d:
            r11 = 0
        L_0x013e:
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            java.lang.String r7 = "is_recommend_reason"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r11 = r4.addEventParam(r7, r11)
            java.lang.String r4 = r10.mTraceId
            java.lang.String r7 = "trace_id"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r11 = r11.addEventParam(r7, r4)
            java.lang.String r4 = "page"
            java.lang.String r7 = "homepage"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r11 = r11.addEventParam(r4, r7)
            java.lang.String r4 = "module"
            java.lang.String r7 = "8888"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r11 = r11.addEventParam(r4, r7)
            int r4 = r10.mIndexInModule
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r7 = "index"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r11 = r11.addEventParam(r7, r4)
            int r4 = r10.mAbsoluteIndex
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r7 = "absolute_position"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r11 = r11.addEventParam(r7, r4)
            java.lang.String r4 = r10.mCateId
            java.lang.String r7 = "category_id"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r11 = r11.addEventParam(r7, r4)
            java.lang.String r4 = "activity_info"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r11 = r11.addEventParam(r4, r0)
            java.lang.String r0 = r10.mLogo
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r0 = r0 ^ r6
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r4 = "is_shop_logo"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r11 = r11.addEventParam(r4, r0)
            java.lang.String r0 = r10.mResourceId
            java.lang.String r4 = "resource_id"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r11 = r11.addEventParam(r4, r0)
            java.lang.String r0 = "synergy_shop_id"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r11 = r11.addEventParam(r0, r1)
            java.lang.String r0 = "synergy_index"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r11 = r11.addEventParam(r0, r3)
            java.lang.String r0 = "synergy_sequence"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r11 = r11.addEventParam(r0, r2)
            com.didi.soda.customer.coordshop.CoordShopModel r10 = r10.coordShopModel
            if (r10 == 0) goto L_0x01bc
            r5 = 1
        L_0x01bc:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r5)
            java.lang.String r0 = "is_synergy_shop"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r10 = r11.addEventParam(r0, r10)
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r10 = r10.enableGuideParam()
            com.didi.soda.customer.foundation.tracker.OmegaTracker r10 = r10.build()
            r10.track()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.manager.HomeOmegaHelper.onOmegaBusinessCk(com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel, boolean):void");
    }

    public void setOmegaGuideParam(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        String moduleString = homeBusinessInfoRvModel.toModuleString();
        String str = homeBusinessInfoRvModel.mRecId;
        m30427a(moduleString, str, "shop_" + homeBusinessInfoRvModel.mShopId, homeBusinessInfoRvModel.mPageFilter);
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

    public void trackShowAllClick() {
        m30426a(EventConst.Home.HOME_SHOWALL_CK).build().track();
    }

    public void trackBannerClick(BannerRvModel bannerRvModel, int i) {
        BannerRvModel.BannerItemRvModel bannerItemRvModel = bannerRvModel.mBannerList.get(i);
        m30426a(EventConst.Home.HOME_BANNER_CK).addEventParam(ParamConst.PARAM_BANNER_NUM, Integer.valueOf(bannerRvModel.mBannerList.size())).addEventParam(ParamConst.PARAM_BANNER_ORDER, Integer.valueOf(i)).addEventParam("activity_id", bannerItemRvModel.mActivityId).addEventParam(ParamConst.PARAM_BANNER_URL, bannerItemRvModel.mUrl).addEventParam("rec_id", bannerItemRvModel.mRecId).addEventParam("page", "homepage").addEventParam("module", Const.HomeV3TraceModelId.BANNER).addEventParam("index", Integer.valueOf(bannerRvModel.mIndexInModule)).addEventParam(ParamConst.PARAM_ABSOLUTE_POSITION, Integer.valueOf(bannerRvModel.mAbsoluteIndex)).addEventParam("resource_id", bannerItemRvModel.mResourceId).enableGuideParam().build().track();
    }

    public void itemExposureForBanner(BannerRvModel bannerRvModel, int i) {
        final BannerRvModel.BannerItemRvModel bannerItemRvModel = bannerRvModel.mBannerList.get(i);
        final BannerRvModel bannerRvModel2 = bannerRvModel;
        final int i2 = i;
        m30428a(new OnceActionUtil.OnceAction(new Object[]{EventConst.Home.HOME_BANNER_SW, bannerItemRvModel.mActivityId, bannerItemRvModel.mUrl, bannerItemRvModel.mImg, Integer.valueOf(bannerItemRvModel.mAbsoluteIndex), Integer.valueOf(i), bannerItemRvModel.mTraceId}) {
            public void run() {
                HomeOmegaHelper.this.m30426a(EventConst.Home.HOME_BANNER_SW).addEventParam(ParamConst.PARAM_BANNER_NUM, Integer.valueOf(bannerRvModel2.mBannerList.size())).addEventParam(ParamConst.PARAM_BANNER_ORDER, Integer.valueOf(i2)).addEventParam("activity_id", bannerItemRvModel.mActivityId).addEventParam(ParamConst.PARAM_BANNER_URL, bannerItemRvModel.mUrl).addEventParam("rec_id", bannerItemRvModel.mRecId).addEventParam("resource_id", bannerItemRvModel.mResourceId).addEventParam("page", "homepage").addEventParam("module", Const.HomeV3TraceModelId.BANNER).addEventParam("index", Integer.valueOf(bannerRvModel2.mIndexInModule)).addEventParam(ParamConst.PARAM_ABSOLUTE_POSITION, Integer.valueOf(bannerRvModel2.mAbsoluteIndex)).build().track();
            }
        });
    }

    public void trackLawDialog(int i) {
        if (i == 1) {
            m30426a(EventConst.LawDialog.SAILING_C_X_STARTPAGE_ACTUALIZATION_IMPORTANTE_SW).build().track();
        } else {
            m30426a(EventConst.LawDialog.SAILING_C_X_LAW_WINDOW_SW).addEventParam("brand", CustomerSystemUtil.getDeviceBrand()).addEventParam(ParamConst.PARAM_DEVICE_TOKEN, DeviceTokenWrapper.getInstance().getDeviceToken()).addEventParam("device_id", CustomerSystemUtil.getDeviceId()).addEventParam("imei", SystemUtil.getIMEI()).build().track();
        }
    }

    public void trackLawDialogClick(boolean z, int i) {
        if (i == 1) {
            m30426a(EventConst.LawDialog.SAILING_C_X_STARTPAGE_ACTUALIZATION_IMPORTANTE_CK).build().track();
        } else {
            m30426a(z ? EventConst.LawDialog.SAILING_C_X_LAWWINDOW_AGREE_CK : EventConst.LawDialog.SAILING_C_X_LAWWINDOW_CANCEL_CK).addEventParam("brand", CustomerSystemUtil.getDeviceBrand()).addEventParam(ParamConst.PARAM_DEVICE_TOKEN, DeviceTokenWrapper.getInstance().getDeviceToken()).addEventParam("device_id", CustomerSystemUtil.getDeviceId()).addEventParam("imei", SystemUtil.getIMEI()).build().track();
        }
    }

    public void trackLawDialogPolicyClick(int i) {
        if (i == 1) {
            m30426a(EventConst.LawDialog.SAILING_C_X_STARTPAGE_ACTUALIZATION_IMPORTANTE_TEXTLINK_CK).build().track();
        } else {
            m30426a(EventConst.LawDialog.SAILING_C_X_LAWWINDOW_POLICY_CK).addEventParam("brand", CustomerSystemUtil.getDeviceBrand()).addEventParam(ParamConst.PARAM_DEVICE_TOKEN, DeviceTokenWrapper.getInstance().getDeviceToken()).addEventParam("device_id", CustomerSystemUtil.getDeviceId()).addEventParam("imei", SystemUtil.getIMEI()).build().track();
        }
    }

    public void setBannerGuideParam(BannerRvModel.BannerItemRvModel bannerItemRvModel) {
        String moduleString = bannerItemRvModel.toModuleString();
        String str = bannerItemRvModel.mRecId;
        m30427a(moduleString, str, "activity_" + bannerItemRvModel.mActivityId, bannerItemRvModel.mPageFilter);
    }

    public void trackHomeNoServiceSW(int i) {
        String str;
        if (i == 40101) {
            str = EventConst.Home.HOME_CITY_UNAVAILABLE_SW;
        } else if (i != 40114) {
            switch (i) {
                case 40109:
                    str = EventConst.Home.HOME_CITY_WARM_UP_SW;
                    break;
                case 40110:
                    str = EventConst.Home.HOME_DANGEROUS_AREA_SW;
                    break;
                case 40111:
                    str = EventConst.Home.HOME_NO_MERCHANT_SW;
                    break;
                case 40112:
                    str = EventConst.Home.HOME_NON_ACTIVATED_AREA_SW;
                    break;
                default:
                    str = "*";
                    break;
            }
        } else {
            str = EventConst.Home.HOME_COUNTRY_UNAVAILABLE_SW;
        }
        m30426a(str).addEventParam(ParamConst.PARAM_POI_ID_CITY, String.valueOf(LocationUtil.getPoiCityId())).build().track();
    }

    public void trackHomeNoServiceCK(int i, String str) {
        m30426a(str).addEventParam("from", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_POI_ID_CITY, String.valueOf(LocationUtil.getPoiCityId())).build().track();
    }

    public void trackHomeNoServiceNotice(int i) {
        m30426a(EventConst.Home.HOME_SERVICE_NOTIFICATION_CK).addEventParam("from", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_LOGIN_STATUS, Integer.valueOf(LoginUtil.isLogin() ? 1 : 0)).addEventParam(ParamConst.PARAM_POI_ID_CITY, String.valueOf(LocationUtil.getPoiCityId())).build().track();
    }

    public void trackHomeGuidePageSW() {
        m30426a(EventConst.Home.HOME_LOGIN_GUIDANCE_SW).build().track();
    }

    public void trackHomeGuideLoginCK() {
        m30426a(EventConst.Home.HOME_LOGIN_GUIDANCE_LOGIN_CK).build().track();
    }

    public void trackHomeGuideSkipCK() {
        m30426a(EventConst.Home.HOME_LOGIN_GUIDANCE_SKIP_CK).build().track();
    }

    public void trackHomeIsShowSkip(int i) {
        m30426a(EventConst.Home.HOME_LOGIN_GUIDANCE_IS_SHOW_SKIP).addEventParam("skip_ishidden", Integer.valueOf(i)).build().track();
    }

    public void trackHomeGuideCloseCK() {
        m30426a(EventConst.Home.HOME_LOGIN_GUIDANCE_CLOSE_CK).build().track();
    }

    public void trackHomeEfoSw(HomeEfoRvModel homeEfoRvModel) {
        m30426a(EventConst.Home.HOME_EFO_SW).addEventParam("rec_id", homeEfoRvModel.mRecId).addEventParam("location", Integer.valueOf(homeEfoRvModel.mIndexInModule)).build().track();
    }

    public void trackEfoPageEntered(int i, HomeEfoRvModel homeEfoRvModel) {
        m30426a(EventConst.Home.HOME_EFO_ENTER_CK).addEventParam("rec_id", homeEfoRvModel.mRecId).addEventParam("location", Integer.valueOf(homeEfoRvModel.mIndexInModule)).addEventParam("from", Integer.valueOf(i)).build().track();
    }

    public void trackEfoItemExposure(final int i, final BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        if (!TextUtils.isEmpty(businessGoodsItemRvModel.mGoodsId)) {
            m30428a(new OnceActionUtil.OnceAction(businessGoodsItemRvModel.mGoodsId) {
                public void run() {
                    HomeOmegaHelper.this.m30426a(EventConst.Home.HOME_EFO_ITEM_SW).addEventParam("rec_id", businessGoodsItemRvModel.mRectId).addEventParam("index", Integer.valueOf(i)).addEventParam("from", 1).addEventParam("item_id", businessGoodsItemRvModel.mGoodsId).addEventParam("shop_id", businessGoodsItemRvModel.mBusinessId).build().track();
                }
            });
        }
    }

    public void trackEfoItemCk(int i, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        m30426a(EventConst.Home.HOME_EFO_ITEM_CK).addEventParam("rec_id", businessGoodsItemRvModel.mRectId).addEventParam("index", Integer.valueOf(i)).addEventParam("from", 1).addEventParam("item_id", businessGoodsItemRvModel.mGoodsId).addEventParam("shop_id", businessGoodsItemRvModel.mBusinessId).build().track();
    }

    public void trackEfoBuyButtonCk(int i, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        int i2 = 1;
        OmegaTracker.Builder addEventParam = m30426a(EventConst.Home.HOME_EFO_ITEM_BUY_CK).addEventParam("rec_id", businessGoodsItemRvModel.mRectId).addEventParam("index", Integer.valueOf(i)).addEventParam("from", 1).addEventParam("item_id", businessGoodsItemRvModel.mGoodsId).addEventParam("shop_id", businessGoodsItemRvModel.mBusinessId);
        if (businessGoodsItemRvModel.mMaxLevel <= 1) {
            i2 = 0;
        }
        addEventParam.addEventParam("has_multi_content", Integer.valueOf(i2)).build().track();
    }

    public void trackTaskCenterSw(String str, int i, String str2, String str3) {
        final String str4 = str;
        final int i2 = i;
        final String str5 = str3;
        final String str6 = str2;
        m30428a(new OnceActionUtil.OnceAction(str) {
            public void run() {
                HomeOmegaHelper.this.m30426a(EventConst.Home.HOME_TASK_CENTER_SW).addEventParam("activity_id", str4).addEventParam(ParamConst.PARAM_TASK_NUM, Integer.valueOf(i2)).addEventParam("resource_id", str5).addEventParam(ParamConst.PARAM_TASK_STATUS, str6).build().track();
            }
        });
    }

    public void trackTaskCenterCk(String str, int i, String str2) {
        m30426a(EventConst.Home.HOME_TASK_CENTER_CK).addEventParam("activity_id", str).addEventParam(ParamConst.PARAM_TASK_NUM, Integer.valueOf(i)).addEventParam("resource_id", str2).build().track();
    }

    public void trackHomepageProfileSw(int i) {
        if (!this.f42998e) {
            m30426a(EventConst.Home.SAILING_C_X_HOMEPAGE_PROFILE_COMMON_SW).addEventParam(ParamConst.PARAM_HAS_WAIT_PROCESS, Integer.valueOf(i)).build().track();
            this.f42998e = true;
        }
    }

    /* renamed from: a */
    private void m30427a(String str, String str2, String str3, String str4) {
        OmegaCommonParamHelper.setLv1Location(str);
        OmegaCommonParamHelper.setLv1RecId(str2);
        OmegaCommonParamHelper.setLv1Body(str3);
        OmegaCommonParamHelper.setLv1Filter(str4);
    }

    /* renamed from: a */
    private void m30428a(OnceActionUtil.OnceAction... onceActionArr) {
        OnceActionUtil.ActionPool actionPool = this.f42997d;
        if (actionPool != null) {
            actionPool.doAction(onceActionArr);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public OmegaTracker.Builder m30426a(String str) {
        WeakReference<ScopeContext> weakReference = this.f42996c;
        if (weakReference != null) {
            return OmegaTracker.Builder.create(str, (ScopeContext) weakReference.get());
        }
        return OmegaTracker.Builder.create(str);
    }

    public void traceHomeBottomLoginSW() {
        m30426a(EventConst.Home.HOME_BOTTOM_LOGIN_SW).build().track();
    }

    public void traceHomeBottomLoginCK() {
        m30426a(EventConst.Home.HOME_BOTTOM_LOGIN_CK).build().track();
    }

    public void traceTopicSW(final HomeTopicRvModel homeTopicRvModel) {
        final HomeTopicEntity data = homeTopicRvModel.getData();
        m30428a(new OnceActionUtil.OnceAction(new Object[]{"sailing_c_x_homepage_top_common_sw", homeTopicRvModel.mTraceId, Integer.valueOf(homeTopicRvModel.mAbsoluteIndex)}) {
            public void run() {
                OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create("sailing_c_x_homepage_top_common_sw").addEventParam("rec_id", homeTopicRvModel.mRecId).addEventParam("location", Integer.valueOf(homeTopicRvModel.mIndexInModule)).addEventParam(ParamConst.PARAM_ABSOLUTE_POSITION, Integer.valueOf(homeTopicRvModel.mAbsoluteIndex)).addEventParam("topic_id", homeTopicRvModel.mComponentId).addEventParam("lv1_filter", homeTopicRvModel.getFilterParams());
                HomeTopicEntity homeTopicEntity = data;
                if (homeTopicEntity != null) {
                    if (homeTopicEntity.actInfo != null) {
                        addEventParam.addEventParam("activity_id", data.actInfo.getActId());
                    }
                    if (data.countDown != null) {
                        addEventParam.addEventParam(ParamConst.PARAMS_IS_COUNTDOWN, Integer.valueOf(data.countDown.getTime()));
                    }
                    addEventParam.addEventParam("scene", Integer.valueOf(data.scene)).addEventParam("session_id", data.tabId);
                }
                addEventParam.build().track();
            }
        });
    }

    public void traceTopicMoreCK(HomeTopicRvModel homeTopicRvModel, boolean z) {
        HomeTopicEntity data = homeTopicRvModel.getData();
        OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create(EventConst.Home.HOME_TOPIC_MORE_CK).addEventParam("rec_id", homeTopicRvModel.mRecId).addEventParam("from", Integer.valueOf(z ? 1 : 2)).addEventParam("topic_id", homeTopicRvModel.mComponentId).addEventParam("lv1_filter", homeTopicRvModel.getFilterParams());
        if (data != null) {
            if (data.actInfo != null) {
                addEventParam.addEventParam("activity_id", data.actInfo.getActId());
            }
            if (data.countDown != null) {
                addEventParam.addEventParam(ParamConst.PARAMS_IS_COUNTDOWN, Integer.valueOf(data.countDown.getTime()));
            }
            addEventParam.addEventParam("scene", Integer.valueOf(data.scene)).addEventParam("session_id", data.tabId);
        }
        addEventParam.build().track();
    }

    public void traceTopicGoodsItemSW(final HomeTopicRvModel homeTopicRvModel, final BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        m30428a(new OnceActionUtil.OnceAction(new Object[]{EventConst.Home.HOME_TOPIC_GOODS_ITEM_SW, businessGoodsItemRvModel.mGoodsId, businessGoodsItemRvModel.mCateId, Integer.valueOf(homeTopicRvModel.mAbsoluteIndex), homeTopicRvModel.mTraceId}) {
            public void run() {
                OmegaTracker.Builder.create(EventConst.Home.HOME_TOPIC_GOODS_ITEM_SW).addAllEventParam(HomeOmegaHelper.createTopicGoodCommonParam(homeTopicRvModel, businessGoodsItemRvModel)).addEventParam("lv1_filter", homeTopicRvModel.getFilterParams()).build().track();
            }
        });
    }

    public void traceTopicGoodsItemCK(HomeTopicRvModel homeTopicRvModel, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        OmegaTracker.Builder.create(EventConst.Home.HOME_TOPIC_GOOD_ITEM_CK).addAllEventParam(createTopicGoodCommonParam(homeTopicRvModel, businessGoodsItemRvModel)).addEventParam("lv1_filter", homeTopicRvModel.getFilterParams()).addEventParam(ParamConst.PARAMS_IS_LISTPAGE, Integer.valueOf(businessGoodsItemRvModel.orderWay == 3 ? 1 : 0)).build().track();
    }

    public void traceTopicShopItemSW(HomeTopicRvModel homeTopicRvModel, HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        OmegaTracker.Builder.create(EventConst.TopicActivity.LANDING_SHOP_ITEM_SHOW).addAllEventParam(createTopicShopCommonParam(homeTopicRvModel, homeBusinessInfoRvModel)).addEventParam("lv1_filter", homeTopicRvModel.getFilterParams()).build().track();
    }

    public void traceTopicShopItemCK(HomeTopicRvModel homeTopicRvModel, HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        OmegaTracker.Builder.create(EventConst.TopicActivity.LANDING_SHOP_ITEM_CLICK).addAllEventParam(createTopicShopCommonParam(homeTopicRvModel, homeBusinessInfoRvModel)).addEventParam("lv1_filter", homeTopicRvModel.getFilterParams()).build().track();
    }

    public void traceTopicBtnBuyCK(HomeTopicRvModel homeTopicRvModel, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        OmegaTracker.Builder.create(EventConst.Home.HOME_TOPIC_BUY_CK).addAllEventParam(createTopicGoodCommonParam(homeTopicRvModel, businessGoodsItemRvModel)).addEventParam("lv1_filter", homeTopicRvModel.getFilterParams()).addEventParam(ParamConst.PARAMS_IS_LISTPAGE, Integer.valueOf(businessGoodsItemRvModel.orderWay == 3 ? 1 : 0)).build().track();
    }

    public void traceTopicBtnOpenStoreCK(HomeTopicRvModel homeTopicRvModel, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        OmegaTracker.Builder.create(EventConst.Home.HOME_TOPIC_ENTER_STORE_CK).addAllEventParam(createTopicGoodCommonParam(homeTopicRvModel, businessGoodsItemRvModel)).addEventParam("lv1_filter", homeTopicRvModel.getFilterParams()).addEventParam(ParamConst.PARAMS_IS_LISTPAGE, Integer.valueOf(businessGoodsItemRvModel.orderWay == 3 ? 1 : 0)).build().track();
    }

    public static HashMap<String, Object> createTopicGoodCommonParam(HomeTopicRvModel homeTopicRvModel, BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("item_id", businessGoodsItemRvModel.mGoodsId);
        hashMap.put("shop_id", businessGoodsItemRvModel.mBusinessId);
        hashMap.put("index", Integer.valueOf(businessGoodsItemRvModel.mIndexInModule));
        hashMap.put("from", 1);
        if (businessGoodsItemRvModel.mActinfo != null) {
            hashMap.put("activity_id", businessGoodsItemRvModel.mActinfo.getActId());
        }
        hashMap.put(ParamConst.PARAMS_MAX_LEVEL, Integer.valueOf(businessGoodsItemRvModel.mMaxLevel));
        hashMap.put("price", Integer.valueOf(businessGoodsItemRvModel.mPrice));
        hashMap.put("discount_price", Integer.valueOf(businessGoodsItemRvModel.mSpecialPrice));
        if (homeTopicRvModel != null) {
            if (homeTopicRvModel.getData() != null) {
                hashMap.put("session_id", homeTopicRvModel.getData().tabId);
                hashMap.put("scene", Integer.valueOf(homeTopicRvModel.getData().scene));
            }
            hashMap.put("rec_id", homeTopicRvModel.mRecId);
            hashMap.put(ParamConst.TRACE_ID, homeTopicRvModel.mTraceId);
            hashMap.put("topic_id", homeTopicRvModel.mComponentId);
            hashMap.put(ParamConst.PARAM_ABSOLUTE_POSITION, Integer.valueOf(homeTopicRvModel.mAbsoluteIndex));
            hashMap.put("module", homeTopicRvModel.mComponentId);
        }
        hashMap.put(ParamConst.PARAM_DELIVERY_TIME, Long.valueOf(businessGoodsItemRvModel.mDeliveryTime));
        hashMap.put(ParamConst.PARAM_DELIVERY_FEE, Integer.valueOf(businessGoodsItemRvModel.mDeliveryFee));
        hashMap.put(ParamConst.PARAMS_DISCOUNT_DELIVERY_FEE, Integer.valueOf(businessGoodsItemRvModel.mDiscountDeliveryFee));
        hashMap.put("page", "homepage");
        return hashMap;
    }

    public static HashMap<String, Object> createTopicShopCommonParam(HomeTopicRvModel homeTopicRvModel, HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(ParamConst.PARAM_SHOP_STATUS, Integer.valueOf(homeBusinessInfoRvModel.mShopStatus));
        hashMap.put("shop_id", homeBusinessInfoRvModel.mShopId);
        hashMap.put(ParamConst.PARAM_SHOP_DELIVERY_FEE, homeBusinessInfoRvModel.mCurrency + "_" + homeBusinessInfoRvModel.mDeliveryPriceOri + "_" + homeBusinessInfoRvModel.mDeliveryPriceAct);
        hashMap.put(ParamConst.PARAM_DELIVERY_TIME, Integer.valueOf(homeBusinessInfoRvModel.mDeliveryTime));
        hashMap.put(ParamConst.PARAM_DELIVERY_TYPE, Integer.valueOf(homeBusinessInfoRvModel.mDeliveryType));
        hashMap.put(ParamConst.PARAM_SHOP_TAG, SentenceUtil.foldStringList(homeBusinessInfoRvModel.mShopTipList, ","));
        hashMap.put(ParamConst.PARAM_SHOP_DISCOUNT_TAG, SentenceUtil.foldStringList(homeBusinessInfoRvModel.mActTipList, ","));
        hashMap.put(ParamConst.PARAM_SHOP_MAIN_TAG, homeBusinessInfoRvModel.mShopCateInfoDescForTrack);
        hashMap.put("index", Integer.valueOf(homeBusinessInfoRvModel.mIndexInModule));
        hashMap.put("from", 1);
        if (homeBusinessInfoRvModel.mActInfo != null) {
            hashMap.put("activity_id", homeBusinessInfoRvModel.mActInfo.getActId());
        }
        if (homeTopicRvModel != null) {
            if (homeTopicRvModel.getData() != null) {
                hashMap.put("scene", Integer.valueOf(homeTopicRvModel.getData().scene));
            }
            hashMap.put("rec_id", homeTopicRvModel.mRecId);
            hashMap.put("topic_id", homeTopicRvModel.mComponentId);
            hashMap.put(ParamConst.PARAM_ABSOLUTE_POSITION, Integer.valueOf(homeTopicRvModel.mAbsoluteIndex));
            hashMap.put("module", homeTopicRvModel.mComponentId);
        }
        hashMap.put("page", "homepage");
        return hashMap;
    }

    public void locationSettingCk(boolean z, boolean z2, boolean z3, boolean z4) {
        int i = 1;
        int i2 = !z ? 1 : 2;
        int i3 = !z4 ? 1 : 2;
        if (!z2) {
            i = 4;
        } else if (z3) {
            i = 2;
        }
        OmegaTracker.Builder.create(EventConst.Home.HOMEPAGE_ADDRESS_NONE_CK).addEventParam("from", Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_IS_LOCATION, Integer.valueOf(i)).addEventParam("click_type", Integer.valueOf(i3)).build().track();
    }

    public void locationServiceSettingSw(int i) {
        OmegaTracker.Builder.create(EventConst.Home.HOMEPAGE_GOOGLE_SERVICE_AUTHORITY_SW).addEventParam("from_page", Integer.valueOf(i)).build().track();
    }

    public void locationServiceSettingCk(int i, boolean z) {
        OmegaTracker.Builder.create(EventConst.Home.HOMEPAGE_GOOGLE_SERVICE_AUTHORITY_CK).addEventParam("from_page", Integer.valueOf(i)).addEventParam(ParamConst.LOCATION_STATUS, Integer.valueOf(z ? 1 : 2)).build().track();
    }

    public void locationDialogSw(boolean z) {
        OmegaTracker.Builder.create(EventConst.Home.HOMEPAGE_OPEN_LOCATION_SW).addEventParam("scene", Integer.valueOf(!z ? 1 : 2)).build().track();
    }

    public void locationDialogCk(boolean z, boolean z2) {
        int i = 1;
        OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create(EventConst.Home.HOMEPAGE_OPEN_LOCATION_CK).addEventParam("scene", Integer.valueOf(!z ? 1 : 2));
        if (!z2) {
            i = 2;
        }
        addEventParam.addEventParam("click_type", Integer.valueOf(i)).build().track();
    }

    public void trackHomeSplashPageSW(String str, String str2, String str3) {
        m30426a(EventConst.Home.HOME_START_PAGE_COOPEN_SW).addEventParam("activity_id", str).addEventParam("resource_id", str2).addEventParam("activity_url", str3).build().track();
    }

    public void trackHomeSplashPageCK(String str, int i, String str2, String str3) {
        m30426a(EventConst.Home.HOME_START_PAGE_COOPEN_CK).addEventParam("activity_id", str).addEventParam("button_type", Integer.valueOf(i)).addEventParam("resource_id", str2).addEventParam("activity_url", str3).build().track();
    }

    public void trackHomeHotWordsSW(ArrayList<HomeSearchHotWordsModel> arrayList) {
        if (arrayList != null) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                HomeSearchHotWordsModel homeSearchHotWordsModel = arrayList.get(i);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(ParamConst.INPUT_WORD, homeSearchHotWordsModel.getWord());
                    jSONObject.put("activity_id", homeSearchHotWordsModel.getActivityId());
                    jSONObject.put("activity_type", homeSearchHotWordsModel.getActivityCate());
                    jSONObject.put("index", i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
            m30426a(EventConst.Home.SAILING_C_X_HOMEPAGE_SEARCH_INPUT_SW).addEventParam(ParamConst.INPUT_WORD_LIST, jSONArray.toString()).build().track();
        }
    }

    public void trackFeedbackSW(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        if (homeBusinessInfoRvModel != null) {
            m30426a(EventConst.Home.SAILING_C_X_HOMEPAGE_SHOP_FEEDBACK_SW).addEventParam("shop_id", homeBusinessInfoRvModel.mShopId).addEventParam("index", Integer.valueOf(homeBusinessInfoRvModel.mIndexInModule)).addEventParam("rec_id", homeBusinessInfoRvModel.mRecId).build().track();
        }
    }

    public void trackFeedbackCK(HomeBusinessInfoRvModel homeBusinessInfoRvModel, int i) {
        if (homeBusinessInfoRvModel != null) {
            m30426a(EventConst.Home.SAILING_C_X_HOMEPAGE_SHOP_FEEDBACK_CK).addEventParam("shop_id", homeBusinessInfoRvModel.mShopId).addEventParam("index", Integer.valueOf(homeBusinessInfoRvModel.mIndexInModule)).addEventParam("question_id", Integer.valueOf(i)).addEventParam("rec_id", homeBusinessInfoRvModel.mRecId).build().track();
        }
    }

    public void trackTabBarRedFlagSW(TabBarItem tabBarItem) {
        if (tabBarItem != null && tabBarItem.getMDiscountTag() != null) {
            String str = "";
            OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create(EventConst.Home.HOME_TAB_BAR_RED_FLAG_SW).addEventParam(ParamConst.PARAM_FLAG_LOCATION, Integer.valueOf(tabBarItem.getCurrentIndex())).addEventParam(ParamConst.PARAM_FLAG_CONTENT, !TextUtils.isEmpty(tabBarItem.getMDiscountTag().getContent()) ? RichTextParser.parseText(tabBarItem.getMDiscountTag().getContent()).toString() : str);
            if (!TextUtils.isEmpty(tabBarItem.getBottomName())) {
                str = tabBarItem.getBottomName();
            }
            addEventParam.addEventParam(ParamConst.PARAM_BOTTOM_NAME, str).build().track();
        }
    }
}
