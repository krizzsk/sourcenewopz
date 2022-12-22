package com.didi.soda.business.manager;

import android.text.TextUtils;
import com.appsflyer.AppsFlyerLib;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.business.component.home.PreviewImageModel;
import com.didi.soda.business.component.search.helper.BusinessSearchOmegaModel;
import com.didi.soda.business.model.BusinessExpandRvModel;
import com.didi.soda.business.model.BusinessExposureModel;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import com.didichuxing.omega.sdk.common.utils.AdvertisingIdHelper;
import java.lang.ref.WeakReference;

public class BusinessOmegaHelper {

    /* renamed from: a */
    private static final String f39701a = "BusinessOmegaHelper";

    /* renamed from: b */
    private WeakReference<ScopeContext> f39702b;

    /* renamed from: c */
    private OnceActionUtil.ActionPool f39703c;

    /* renamed from: d */
    private String f39704d;

    /* renamed from: e */
    private int f39705e;

    /* renamed from: f */
    private boolean f39706f = false;

    /* renamed from: g */
    private boolean f39707g = false;

    public BusinessOmegaHelper(ScopeContext scopeContext, String str, int i) {
        this.f39702b = new WeakReference<>(scopeContext);
        this.f39703c = new OnceActionUtil.ActionPool();
        this.f39704d = str;
        this.f39705e = i;
    }

    /* renamed from: a */
    private void m28301a(OnceActionUtil.OnceAction... onceActionArr) {
        OnceActionUtil.ActionPool actionPool = this.f39703c;
        if (actionPool != null) {
            actionPool.doAction(onceActionArr);
        }
    }

    public void onClassifyTabClick(String str, int i, String str2, int i2) {
        m28299a(EventConst.Business.SHOP_TAB_CK).addEventParam(ParamConst.PARAM_TAB_ID, str).addEventParam(ParamConst.PARAM_TAB_ORDER_NUM, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_TAB_NAME, str2).addEventParam("from", Integer.valueOf(i2)).build().track();
    }

    public void onClassifyTabSw(String str, int i, String str2, int i2, int i3, String str3) {
        final String str4 = str;
        final int i4 = i;
        final String str5 = str2;
        final int i5 = i2;
        final int i6 = i3;
        m28301a(new OnceActionUtil.OnceAction(new Object[]{EventConst.Business.SHOP_TAB_SW, str, str2, str3}) {
            public void run() {
                OmegaTracker.Builder a = BusinessOmegaHelper.this.m28299a(EventConst.Business.SHOP_TAB_SW);
                a.addEventParam(ParamConst.PARAM_TAB_ID, str4).addEventParam(ParamConst.PARAM_TAB_ORDER_NUM, Integer.valueOf(i4)).addEventParam(ParamConst.PARAM_TAB_NAME, str5).addEventParam("from", Integer.valueOf(i5));
                if (str4 == "5") {
                    a.addEventParam(ParamConst.PARAM_RECALL_NUM, Integer.valueOf(i6));
                }
                a.build().track();
            }
        });
    }

    public void onDismissMoreClassifyCk(int i) {
        m28299a(EventConst.Business.SHOP_MORE_TAB_CLOSE_CK).addEventParam("click_type", Integer.valueOf(i)).build().track();
    }

    public void onMoreClassifyTabCk() {
        m28299a(EventConst.Business.SHOP_MORE_TAB_CK).build().track();
    }

    public void onMoreClassifyTabSw() {
        m28299a(EventConst.Business.SHOP_MORE_TAB_SW).build().track();
    }

    public void onDetailAddressClick() {
        m28299a(EventConst.Business.SHOP_DETAIL_ADDRESS_CK).build().track();
    }

    public void onDetailRuleClick(int i) {
        m28299a(EventConst.Business.SHOP_DETAIL_RULE_CK).addEventParam("button_type", Integer.valueOf(i)).build().track();
    }

    public void onPreviewImageSw(PreviewImageModel previewImageModel) {
        PreviewImageModel previewImageModel2 = previewImageModel;
        OmegaTracker.Builder enableGuideParam = m28299a(EventConst.Business.SHOP_ITEM_PHOTO_SW).addEventParam("item_id", previewImageModel2.mGoodId).addEventParam("content_json", GsonUtil.toJson(getBusinessExposureModel(previewImageModel2.mGoodId, previewImageModel2.mStatus, previewImageModel2.mGoodsMarketingTipString, previewImageModel2.mCateId, previewImageModel2.mCateName, previewImageModel2.mCateIndex, previewImageModel2.mInCategoryIndex, 0, true, previewImageModel2.mRecId, previewImageModel.isFromSearch() ? ParamConst.PARAM_SHOP_SEARCH : "shop", previewImageModel2.mSoldStatus, previewImageModel2.mLimitedTime, ""))).enableGuideParam();
        if (previewImageModel2.mTraceCnt >= 0) {
            enableGuideParam.addEventParam(ParamConst.TRACE_CNT, Integer.valueOf(previewImageModel2.mTraceCnt));
        }
        enableGuideParam.build().track();
    }

    public BusinessExposureModel getBusinessExposureModel(String str, int i, String str2, String str3, String str4, int i2, int i3, int i4, boolean z, String str5, String str6, int i5, String str7, String str8) {
        BusinessExposureModel businessExposureModel = new BusinessExposureModel();
        businessExposureModel.f39717id = str;
        businessExposureModel.status = i;
        businessExposureModel.discount = str2;
        businessExposureModel.recId = str5;
        businessExposureModel.tabId = str3;
        businessExposureModel.tabName = str4;
        businessExposureModel.type = "item";
        businessExposureModel.hasPhoto = z ? 1 : 2;
        businessExposureModel.location = str6 + "_" + str3 + "_" + 0 + "_" + i2 + "_" + 0 + "_" + i3 + "_" + i4 + "_" + 0;
        businessExposureModel.soldStatus = i5;
        businessExposureModel.limitedTime = str7;
        businessExposureModel.activityType = str8;
        return businessExposureModel;
    }

    public void onPreviewImageCloseCk(String str, int i) {
        m28299a(EventConst.Business.SHOP_ITEM_PHOTO_CLOSE_CK).addEventParam("item_id", str).addEventParam("click_type", Integer.valueOf(i)).build().track();
    }

    public void onDetailExit() {
        OmegaTracker.Builder.create(EventConst.Business.SHOP_DETAIL_RETURN_CK).addEventParam("shop_id", this.f39704d).addEventParam(ParamConst.PARAM_SHOP_BIZ_STATUS, Integer.valueOf(this.f39705e)).build().track();
    }

    public void onDetailShow(int i, String str, int i2, int i3, String str2) {
        m28299a(EventConst.Business.SHOP_DETAIL_SW).addEventParam("distance", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_DELIVERY_FEE, str).addEventParam(ParamConst.PARAM_DELIVERY_TIME, Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_DELIVERY_TYPE, Integer.valueOf(i3)).addEventParam("rec_id", str2).enableGuideParam().build().track();
    }

    public void onExit(int i, int i2, String str, int i3, int i4, String str2, int i5, String str3) {
        OmegaTracker.Builder.create(EventConst.Business.SHOP_RETURN_CK).addEventParam("shop_id", this.f39704d).addEventParam(ParamConst.PARAM_SHOP_BIZ_STATUS, Integer.valueOf(this.f39705e)).addEventParam("distance", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_RETURN_WAY, Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_DELIVERY_FEE, str).addEventParam(ParamConst.PARAM_DELIVERY_TIME, Integer.valueOf(i3)).addEventParam(ParamConst.PARAM_EXPOSURE_ACTIVIY_NUM, Integer.valueOf(i4)).addEventParam(ParamConst.PARAM_TAB_TYPE_LIST, str2).addEventParam(ParamConst.PARAM_DELIVERY_TYPE, Integer.valueOf(i5)).addEventParam("rec_id", str3).build().track();
    }

    public void onExit(int i, int i2, String str, int i3, int i4, String str2, int i5, int i6, String str3, int i7) {
        OmegaTracker.Builder.create(EventConst.Business.SHOP_RETURN_CK).addEventParam("shop_id", this.f39704d).addEventParam(ParamConst.PARAM_SHOP_BIZ_STATUS, Integer.valueOf(this.f39705e)).addEventParam("distance", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_RETURN_WAY, Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_DELIVERY_FEE, str).addEventParam(ParamConst.PARAM_DELIVERY_TIME, Integer.valueOf(i3)).addEventParam(ParamConst.PARAM_EXPOSURE_ACTIVIY_NUM, Integer.valueOf(i4)).addEventParam(ParamConst.PARAM_TAB_TYPE_LIST, str2).addEventParam(ParamConst.PARAM_DELIVERY_TYPE, Integer.valueOf(i5)).addEventParam(ParamConst.PARAM_COUPON_NUM, Integer.valueOf(i6)).addEventParam("rec_id", str3).addEventParam(ParamConst.IS_MARKET_AREA, Integer.valueOf(i7)).build().track();
    }

    public void onGoodsItemClick(String str, BusinessGoodsItemRvModel businessGoodsItemRvModel, int i, int i2, BusinessOmegaModel businessOmegaModel) {
        BusinessGoodsItemRvModel businessGoodsItemRvModel2 = businessGoodsItemRvModel;
        BusinessOmegaModel businessOmegaModel2 = businessOmegaModel;
        m28300a(str, businessGoodsItemRvModel2.mGoodsId, businessGoodsItemRvModel2.mStatus, businessGoodsItemRvModel2.mGoodsMarketingTipString, businessGoodsItemRvModel2.mGoodsName, businessGoodsItemRvModel2.mSoldStatus, businessGoodsItemRvModel2.mLimitedTime, businessGoodsItemRvModel2.mCateId, !TextUtils.isEmpty(businessGoodsItemRvModel2.mHeadImg), i, i2, businessOmegaModel2.mDeliveryFee, businessOmegaModel2.mDeliveryTime, businessOmegaModel2.mDistance, businessGoodsItemRvModel2.mCateIndex, businessGoodsItemRvModel2.mPrice, businessGoodsItemRvModel2.mSpecialPrice, businessGoodsItemRvModel2.mActivityType, businessGoodsItemRvModel2.mAdditionalType == 1 ? 2 : 1, businessGoodsItemRvModel2.mInCategoryIndex).enableGuideParam().build().track();
    }

    public void onHeaderClick(int i, String str, int i2) {
        m28299a(EventConst.Business.SHOP_HEADER_CK).addEventParam("distance", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_DELIVERY_FEE, str).addEventParam(ParamConst.PARAM_DELIVERY_TIME, Integer.valueOf(i2)).build().track();
    }

    public void onHeaderSearchClick() {
        m28299a(EventConst.Business.SHOP_HEADER_SEARCH_CK).build().track();
    }

    public void onDemandMessageShow(int i) {
        m28299a(EventConst.Business.SHOP_TITLE_DEMAND_MESSAGE_SW).addEventParam("msg_type", Integer.valueOf(i)).build().track();
    }

    public void onDeliveryMessageShow() {
        m28299a(EventConst.Business.SHOP_TITLE_DELIVERY_MESSAGE_SW).build().track();
    }

    public void onDeliveryMessageClick() {
        m28299a(EventConst.Business.SHOP_TITLE_DELIVERY_MESSAGE_CK).build().track();
    }

    public void onExpandExposure(final BusinessExpandRvModel businessExpandRvModel) {
        String str = businessExpandRvModel.mExpandList.size() > 0 ? businessExpandRvModel.mExpandList.get(0).mGoodsId : "0";
        final String str2 = businessExpandRvModel.mIsExpand ? EventConst.Business.SHOP_FOLD_SW : EventConst.Business.SHOP_EXPAND_SW;
        m28301a(new OnceActionUtil.OnceAction(new Object[]{str2, str}) {
            public void run() {
                BusinessOmegaHelper.this.m28299a(str2).addEventParam(ParamConst.PARAM_HIDE_NUM, Integer.valueOf(businessExpandRvModel.mExpandList.size())).enableGuideParam().build().track();
            }
        });
    }

    public void onExpandClickEvent(BusinessExpandRvModel businessExpandRvModel) {
        if (businessExpandRvModel.mIsExpand) {
            m28299a(EventConst.Business.SHOP_ITEM_FOLD_CK).enableGuideParam().build().track();
        } else {
            m28299a(EventConst.Business.SHOP_ITEM_EXPAND_CK).addEventParam(ParamConst.PARAM_HIDE_NUM, Integer.valueOf(businessExpandRvModel.mExpandList.size())).enableGuideParam().build().track();
        }
    }

    public void onItemExposure(String str, int i, String str2, String str3, String str4, String str5, int i2, int i3, int i4, String str6, int i5, String str7, String str8, String str9, String str10, int i6, int i7, int i8, int i9) {
        int i10 = i6;
        Object[] objArr = new Object[8];
        Object[] objArr2 = objArr;
        objArr2[0] = EventConst.Business.SHOP_EXPOSURE_SW;
        objArr2[1] = str;
        objArr2[2] = Integer.valueOf(i);
        objArr2[3] = str2;
        objArr2[4] = str3;
        objArr2[5] = str4;
        objArr2[6] = Integer.valueOf(i3);
        objArr2[7] = Integer.valueOf(i4);
        m28301a(new OnceActionUtil.OnceAction(this, objArr, i10, str, i, str2, str4, str5, i2, i3, i4, str6, str3, i5, str7, str8, str9, str10, i7, i8, i9) {
            final /* synthetic */ BusinessOmegaHelper this$0;
            final /* synthetic */ String val$activityType;
            final /* synthetic */ int val$column;
            final /* synthetic */ String val$discount;
            final /* synthetic */ String val$goodsId;
            final /* synthetic */ String val$goodsMarketingTip;
            final /* synthetic */ int val$goodsStatus;
            final /* synthetic */ int val$has_multi_conte;
            final /* synthetic */ int val$itemLocation;
            final /* synthetic */ String val$limitedTime;
            final /* synthetic */ int val$mAdditionalType;
            final /* synthetic */ String val$photo;
            final /* synthetic */ String val$price;
            final /* synthetic */ String val$recId;
            final /* synthetic */ int val$row;
            final /* synthetic */ int val$soldStatus;
            final /* synthetic */ String val$tabId;
            final /* synthetic */ int val$tabIndex;
            final /* synthetic */ String val$tabName;
            final /* synthetic */ int val$tab_location;

            {
                this.this$0 = r3;
                this.val$mAdditionalType = r5;
                this.val$goodsId = r6;
                this.val$goodsStatus = r7;
                this.val$goodsMarketingTip = r8;
                this.val$tabId = r9;
                this.val$tabName = r10;
                this.val$tabIndex = r11;
                this.val$row = r12;
                this.val$column = r13;
                this.val$photo = r14;
                this.val$recId = r15;
                this.val$soldStatus = r16;
                this.val$limitedTime = r17;
                this.val$price = r18;
                this.val$discount = r19;
                this.val$activityType = r20;
                this.val$tab_location = r21;
                this.val$has_multi_conte = r22;
                this.val$itemLocation = r23;
                Object[] objArr = r4;
            }

            public void run() {
                this.this$0.m28299a(EventConst.Business.SHOP_EXPOSURE_SW).addEventParam("content_json", GsonUtil.toJson(this.this$0.getBusinessExposureModel(this.val$goodsId, this.val$goodsStatus, this.val$goodsMarketingTip, this.val$tabId, this.val$tabName, this.val$tabIndex, this.val$row, this.val$column, !TextUtils.isEmpty(this.val$photo), this.val$recId, "shop", this.val$soldStatus, this.val$limitedTime, this.val$price, this.val$discount, this.val$activityType, this.val$mAdditionalType == 1 ? 2 : 1, this.val$tab_location, this.val$has_multi_conte, this.val$itemLocation))).enableGuideParam().build().track();
            }
        });
    }

    public BusinessExposureModel getBusinessExposureModel(String str, int i, String str2, String str3, String str4, int i2, int i3, int i4, boolean z, String str5, String str6, int i5, String str7, String str8, String str9, String str10, int i6, int i7, int i8, int i9) {
        BusinessExposureModel businessExposureModel = new BusinessExposureModel();
        businessExposureModel.f39717id = str;
        businessExposureModel.status = i;
        businessExposureModel.discount = str2;
        businessExposureModel.recId = str5;
        businessExposureModel.tabId = str3;
        businessExposureModel.tabName = str4;
        businessExposureModel.type = "item";
        businessExposureModel.hasPhoto = z ? 1 : 2;
        businessExposureModel.price = str8;
        businessExposureModel.discountPrice = str9;
        businessExposureModel.activityType = str10;
        StringBuilder sb = new StringBuilder();
        sb.append(str6);
        sb.append("_");
        sb.append(str3);
        sb.append("_");
        sb.append(0);
        sb.append("_");
        int i10 = i2;
        sb.append(i2);
        sb.append("_");
        sb.append(0);
        sb.append("_");
        int i11 = i3;
        sb.append(i3);
        sb.append("_");
        int i12 = i4;
        sb.append(i4);
        sb.append("_");
        sb.append(0);
        businessExposureModel.location = sb.toString();
        businessExposureModel.soldStatus = i5;
        businessExposureModel.limitedTime = str7;
        businessExposureModel.addionType = i6;
        businessExposureModel.mTabLocation = i7;
        businessExposureModel.mHasMultiContent = i8;
        businessExposureModel.itemLocation = i9;
        return businessExposureModel;
    }

    public void onShow(int i, String str, int i2, int i3, String str2, int i4, String str3, int i5, boolean z, String str4) {
        m28299a(EventConst.Business.SHOP_COMMON_SW).addEventParam("distance", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_DELIVERY_FEE, str).addEventParam(ParamConst.PARAM_DELIVERY_TIME, Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_EXPOSURE_ACTIVIY_NUM, Integer.valueOf(i3)).addEventParam(ParamConst.PARAM_TAB_TYPE_LIST, str2).addEventParam(ParamConst.PARAM_DELIVERY_TYPE, Integer.valueOf(i4)).addEventParam("rec_id", str3).addEventParam(ParamConst.TRACE_ID, str4).addEventParam("from", Integer.valueOf(i5)).addEventParam(ParamConst.PARAMS_HAS_COUPON_LOGO, Integer.valueOf(z ? 2 : 1)).addEventParam("appsflyer_id", AppsFlyerLib.getInstance().getAppsFlyerUID(GlobalContext.getContext())).addEventParam("advertising_id", AdvertisingIdHelper.getInstance().getGAID()).enableGuideParam().build().track();
    }

    public void onShow(int i, String str, int i2, int i3, String str2, int i4, String str3, int i5, boolean z, String str4, int i6, int i7) {
        m28299a(EventConst.Business.SHOP_COMMON_SW).addEventParam("distance", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_DELIVERY_FEE, str).addEventParam(ParamConst.PARAM_DELIVERY_TIME, Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_EXPOSURE_ACTIVIY_NUM, Integer.valueOf(i3)).addEventParam(ParamConst.PARAM_TAB_TYPE_LIST, str2).addEventParam(ParamConst.PARAM_DELIVERY_TYPE, Integer.valueOf(i4)).addEventParam("rec_id", str3).addEventParam(ParamConst.TRACE_ID, str4).addEventParam("from", Integer.valueOf(i5)).addEventParam(ParamConst.PARAM_COUPON_NUM, Integer.valueOf(i6)).addEventParam(ParamConst.PARAMS_HAS_COUPON_LOGO, Integer.valueOf(z ? 2 : 1)).addEventParam(ParamConst.IS_MARKET_AREA, Integer.valueOf(i7)).enableGuideParam().build().track();
    }

    public void onSearchShow(BusinessSearchOmegaModel businessSearchOmegaModel) {
        m28299a(EventConst.Business.SHOP_SEARCH_SW).addEventParam("rec_id", businessSearchOmegaModel.mHotWordRecId).addEventParam(ParamConst.HOT_WORD_LIST, businessSearchOmegaModel.mHotWordList != null ? GsonUtil.toJson(businessSearchOmegaModel.mHotWordList) : null).build().track();
    }

    public void onSearchCloseClick(int i, String str) {
        m28299a(EventConst.Business.SHOP_SEARCH_CLOSE_CK).addEventParam("click_type", Integer.valueOf(i)).build().track();
        OmegaTracker.Builder.create("sailing_c_x_page_return_ck").addEventParam("from", str).build().track();
    }

    public void onSearchHotWordShow(BusinessSearchOmegaModel businessSearchOmegaModel) {
        m28299a(EventConst.Business.SHOP_SEARCH_HOT_WORD_SW).addEventParam("rec_id", businessSearchOmegaModel.mHotWordRecId).addEventParam(ParamConst.HOT_WORD_LIST, businessSearchOmegaModel.mHotWordList != null ? GsonUtil.toJson(businessSearchOmegaModel.mHotWordList) : null).build().track();
    }

    public void onSearchHotWordClick(String str, String str2) {
        m28299a(EventConst.Business.SHOP_SEARCH_HOT_WORD_CK).addEventParam("rec_id", str).addEventParam(ParamConst.HOT_WORD, str2).enableGuideParam().build().track();
    }

    public void onFavorClick(String str, int i, int i2) {
        m28299a(EventConst.Business.SHOP_FAVORITE_CK).addEventParam("shop_id", str).addEventParam(ParamConst.PARAM_SHOP_BIZ_STATUS, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_SHOP_FAVORITE, Integer.valueOf(i2)).build().track();
    }

    public void onSearchItemSw(String str, int i) {
        m28299a(EventConst.Business.SHOP_SEARCH_PAGE_SEARCH_ITEM_SW).addEventParam("rec_id", str).addEventParam(ParamConst.TRACE_CNT, Integer.valueOf(i)).build().track();
    }

    public void onSearchNoResultSw(String str, String str2) {
        m28299a(EventConst.Business.SHOP_SEARCH_NO_RESULT_SW).addEventParam("rec_id", str).addEventParam("search_word", str2).build().track();
    }

    public void onSearchItemExposure(BusinessGoodsItemRvModel businessGoodsItemRvModel, String str, int i, int i2, int i3, int i4) {
        BusinessGoodsItemRvModel businessGoodsItemRvModel2 = businessGoodsItemRvModel;
        int i5 = i2 == 1 ? 2 : 1;
        BusinessExposureModel businessExposureModel = getBusinessExposureModel(businessGoodsItemRvModel2.mGoodsId, businessGoodsItemRvModel2.mStatus, businessGoodsItemRvModel2.mGoodsMarketingTipString, businessGoodsItemRvModel2.mCateId, businessGoodsItemRvModel2.mCateName, 0, businessGoodsItemRvModel2.mInCategoryIndex, 0, !TextUtils.isEmpty(businessGoodsItemRvModel2.mHeadImg), str, ParamConst.PARAM_SHOP_SEARCH, businessGoodsItemRvModel2.mSoldStatus, businessGoodsItemRvModel2.mSoldTimeDesc, businessGoodsItemRvModel2.mActivityType + "", i5, i3, i4, businessGoodsItemRvModel2.mInCategoryIndex);
        final BusinessExposureModel businessExposureModel2 = businessExposureModel;
        final String str2 = str;
        final int i6 = i;
        m28301a(new OnceActionUtil.OnceAction(new Object[]{EventConst.Business.SHOP_EXPOSURE_SW, businessExposureModel.f39717id, Integer.valueOf(businessExposureModel.status), businessGoodsItemRvModel2.mGoodsMarketingTips, str, businessGoodsItemRvModel2.mCateId, Integer.valueOf(businessGoodsItemRvModel2.mInCategoryIndex), 0}) {
            public void run() {
                BusinessOmegaHelper.this.m28299a(EventConst.Business.SHOP_EXPOSURE_SW).addEventParam("content_json", GsonUtil.toJson(businessExposureModel2)).addEventParam("rec_id", str2).addEventParam(ParamConst.TRACE_CNT, Integer.valueOf(i6)).enableGuideParam().build().track();
            }
        });
    }

    public BusinessExposureModel getBusinessExposureModel(String str, int i, String str2, String str3, String str4, int i2, int i3, int i4, boolean z, String str5, String str6, int i5, String str7, String str8, int i6, int i7, int i8, int i9) {
        BusinessExposureModel businessExposureModel = new BusinessExposureModel();
        businessExposureModel.f39717id = str;
        businessExposureModel.status = i;
        businessExposureModel.discount = str2;
        businessExposureModel.recId = str5;
        businessExposureModel.tabId = str3;
        businessExposureModel.tabName = str4;
        businessExposureModel.type = "item";
        businessExposureModel.hasPhoto = z ? 1 : 2;
        StringBuilder sb = new StringBuilder();
        sb.append(str6);
        sb.append("_");
        sb.append(str3);
        sb.append("_");
        sb.append(0);
        sb.append("_");
        int i10 = i2;
        sb.append(i2);
        sb.append("_");
        sb.append(0);
        sb.append("_");
        int i11 = i3;
        sb.append(i3);
        sb.append("_");
        int i12 = i4;
        sb.append(i4);
        sb.append("_");
        sb.append(0);
        businessExposureModel.location = sb.toString();
        businessExposureModel.soldStatus = i5;
        businessExposureModel.limitedTime = str7;
        businessExposureModel.activityType = str8;
        businessExposureModel.addionType = i6;
        businessExposureModel.mTabLocation = i7;
        businessExposureModel.mHasMultiContent = i8;
        businessExposureModel.itemLocation = i9;
        return businessExposureModel;
    }

    public void onSearchGoodsItemClick(String str, BusinessGoodsItemRvModel businessGoodsItemRvModel, int i, int i2, BusinessOmegaModel businessOmegaModel, String str2, int i3) {
        BusinessGoodsItemRvModel businessGoodsItemRvModel2 = businessGoodsItemRvModel;
        BusinessOmegaModel businessOmegaModel2 = businessOmegaModel;
        m28300a(str, businessGoodsItemRvModel2.mGoodsId, businessGoodsItemRvModel2.mStatus, businessGoodsItemRvModel2.mGoodsMarketingTipString, businessGoodsItemRvModel2.mGoodsName, businessGoodsItemRvModel2.mSoldStatus, businessGoodsItemRvModel2.mSoldTimeDesc, businessGoodsItemRvModel2.mCateId, !TextUtils.isEmpty(businessGoodsItemRvModel2.mHeadImg), i, i2, businessOmegaModel2.mDeliveryFee, businessOmegaModel2.mDeliveryTime, businessOmegaModel2.mDistance, businessGoodsItemRvModel2.mCateIndex, businessGoodsItemRvModel2.mPrice, businessGoodsItemRvModel2.mSpecialPrice, businessGoodsItemRvModel2.mActivityType, businessGoodsItemRvModel2.mAdditionalType == 1 ? 2 : 1, businessGoodsItemRvModel2.mInCategoryIndex).addEventParam("rec_id", str2).addEventParam(ParamConst.TRACE_CNT, Integer.valueOf(i3)).enableGuideParam().build().track();
    }

    public void onGoodsAddPreCalculate(String str, int i, int i2, String str2, String str3, String str4, String str5, String str6, int i3, int i4) {
        m28299a(EventConst.Business.SHOP_GOODS_ITEM_TO_CART_SUCCESS).addEventParam("item_id", str).addEventParam(ParamConst.PARAM_ITEM_STATUS, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_ITEM_SOLD_STATUS, Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_ITEM_LIMITED_TIME, str2).addEventParam("price", str3).addEventParam("discount_price", str4).addEventParam("activity_type", str5).addEventParam(ParamConst.PARAM_COPY_NUM, 1).addEventParam(ParamConst.PARAM_TAB_ID, str6).addEventParam(ParamConst.PARAM_TAB_LOCATION, Integer.valueOf(i3)).addEventParam(ParamConst.PARAM_ITEM_LOCATION, Integer.valueOf(i4)).enableGuideParam().build().track();
    }

    public void onGoodsAddPostCalculate(String str, String str2, int i) {
        m28299a(EventConst.Business.SHOP_GOODS_ITEM_POST_CART_SUCCESS).addEventParam("cart_id", str).addEventParam("item_list", str2).addEventParam("is_suc", Integer.valueOf(i)).enableGuideParam().build().track();
    }

    public void onCouponReduceCk() {
        OmegaTracker.Builder.create(EventConst.Business.SHOP_HEADER_COUPON_REDUCE_CK, (ScopeContext) this.f39702b.get()).addEventParam("shop_id", this.f39704d).build().track();
    }

    public void onCouponReduceShow() {
        OmegaTracker.Builder.create(EventConst.Business.SHOP_HEADER_COUPON_REDUCE_SW, (ScopeContext) this.f39702b.get()).addEventParam("shop_id", this.f39704d).build().track();
    }

    public void onOutsideDeliveryPopupSw(int i) {
        OmegaTracker.Builder.create(EventConst.Business.SHOP_OUTSIDE_DELIVERY_POPUP_SW, (ScopeContext) this.f39702b.get()).addEventParam("shop_id", this.f39704d).addEventParam("from", Integer.valueOf(i)).build().track();
    }

    public void onOutsideDeliveryPopupCk(int i, int i2) {
        OmegaTracker.Builder.create(EventConst.Business.SHOP_OUTSIDE_DELIVERY_POPUP_CK, (ScopeContext) this.f39702b.get()).addEventParam("shop_id", this.f39704d).addEventParam("button_type", Integer.valueOf(i)).addEventParam("from", Integer.valueOf(i2)).build().track();
    }

    public void onOutsideClosePopupSw(int i) {
        OmegaTracker.Builder.create(EventConst.Business.SHOP_OUTSIDE_COLSE_POPUP_SW, (ScopeContext) this.f39702b.get()).addEventParam("shop_id", this.f39704d).addEventParam("from", Integer.valueOf(i)).build().track();
    }

    public void onOutsideClosePopupCk(int i, int i2) {
        OmegaTracker.Builder.create(EventConst.Business.SHOP_OUTSIDE_COLSE_POPUP_CK, (ScopeContext) this.f39702b.get()).addEventParam("shop_id", this.f39704d).addEventParam("button_type", Integer.valueOf(i)).addEventParam("from", Integer.valueOf(i2)).build().track();
    }

    public void onCouponReduceClose(int i) {
        OmegaTracker.Builder.create(EventConst.Business.SHOP_HEADER_COUPON_REDUCE_CLOSE_CK, (ScopeContext) this.f39702b.get()).addEventParam("shop_id", this.f39704d).addEventParam("button_type", Integer.valueOf(i)).build().track();
    }

    public void onRvScrolled(int i) {
        if (!this.f39706f) {
            m28299a(EventConst.Business.SAILING_C_X_SHOP_SLIDE_CK).addEventParam(ParamConst.PARAM_SHOP_SLIDE_TYPE, Integer.valueOf(i)).build().track();
            this.f39706f = true;
        }
    }

    public void onTabScrolled(int i) {
        if (!this.f39707g) {
            m28299a(EventConst.Business.SAILING_C_X_SHOP_TAB_SLIDE_CK).addEventParam(ParamConst.PARAM_SHOP_SLIDE_TYPE, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_SHOP_SLIDE_SCENE, 1).build().track();
            this.f39707g = true;
        }
    }

    public void reset() {
        this.f39703c.reset();
    }

    public void updateBusinessStatus(int i) {
        this.f39705e = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public OmegaTracker.Builder m28299a(String str) {
        return OmegaTracker.Builder.create(str, (ScopeContext) this.f39702b.get()).addEventParam("shop_id", this.f39704d).addEventParam(ParamConst.PARAM_SHOP_BIZ_STATUS, Integer.valueOf(this.f39705e));
    }

    /* renamed from: a */
    private OmegaTracker.Builder m28300a(String str, String str2, int i, String str3, String str4, int i2, String str5, String str6, boolean z, int i3, int i4, String str7, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        String str8 = str2;
        String str9 = str3;
        String str10 = str4;
        String str11 = str5;
        String str12 = str6;
        String str13 = str7;
        return m28299a(str).addEventParam("item_id", str2).addEventParam(ParamConst.PARAM_ITEM_STATUS, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_ITEM_DISCOUNT, str3).addEventParam("item_name", str4).addEventParam(ParamConst.PARAM_ITEM_SOLD_STATUS, Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_ITEM_LIMITED_TIME, str5).addEventParam(ParamConst.PARAM_ITEM_HAS_PICTURE, Boolean.valueOf(z)).addEventParam(ParamConst.PARAM_ITEM_PAGE_TYPE, Integer.valueOf(i3)).addEventParam("has_multi_content", Integer.valueOf(i4)).addEventParam(ParamConst.PARAM_TAB_ID, str6).addEventParam(ParamConst.PARAM_DELIVERY_FEE, str7).addEventParam(ParamConst.PARAM_DELIVERY_TIME, Integer.valueOf(i5)).addEventParam(ParamConst.PARAM_TAB_LOCATION, Integer.valueOf(i7)).addEventParam("price", Integer.valueOf(i8)).addEventParam("discount_price", Integer.valueOf(i9)).addEventParam("activity_type", Integer.valueOf(i10)).addEventParam(ParamConst.ITEM_COMBO_TYPE, Integer.valueOf(i11)).addEventParam("distance", Integer.valueOf(i6)).addEventParam(ParamConst.PARAM_ITEM_LOCATION, Integer.valueOf(i12));
    }
}
