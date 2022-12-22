package com.didi.soda.home.topgun.binder.model;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.customer.animation.transitions.name.BusinessTransitionNameSet;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.coordshop.CoordShopModel;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.ImageBottomTagEntity;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ViewMoreEntity;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.tracker.model.ModuleModelV2;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.CustomerSideSpacingSpan;
import com.didi.soda.customer.foundation.util.CustomerTypeFaceSpan;
import com.didi.soda.customer.foundation.util.CustomerVerticalCenterSpan;
import com.didi.soda.customer.foundation.util.FontUtils;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.locale.LocalizationUtils;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.search.SearchFoodItemView;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.home.topgun.manager.HomeBusinessPool;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.taxis99.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HomeBusinessInfoRvModel extends ModuleModelV2 implements RecyclerModel {
    public static final int BUSINESS_SOURCE_SEARCH = 2;
    public int businessType = 1;
    public CoordShopModel coordShopModel;
    public String fromPage;
    public int intentionType;
    public boolean isShowed = false;
    public List<PromptEntity> mActEntityList;
    public ActInfoEntity mActInfo;
    public PromptEntity mActTip;
    public List<String> mActTipList;
    public String mAdTagDesc;
    public String mAvgPrice;
    public String mBgImg;
    public String mBizTimeDesc;
    public ImageBottomTagEntity mBottomTagEntity;
    public String mBusinessNextOpenTimeDesc;
    public CharSequence mBuyAgentDesc;
    public String mCateId;
    public String mCurrency;
    public boolean mDeletable = false;
    public CharSequence mDeliveryDesc;
    public int mDeliveryPriceAct;
    public int mDeliveryPriceOri;
    public int mDeliveryTime;
    public int mDeliveryType;
    public int mExactMatchType;
    public List<SearchFoodItemView.SearchFoodItemModel> mFoodItemList;
    public List<SearchFoodItemView.SearchFoodItemModel> mFoodItems;
    public List<PromptEntity> mFulfillment;
    public int mHasWine;
    public String mHonorIconUrl;
    public boolean mIsCouponLogo = false;
    public String mItemId;
    public String mLogo;
    public String mLogoImg;
    public boolean mMask = false;
    public String mMatchItemIds;
    public int mMaxLevel;
    public ItemNodeEntity mNode;
    public String mPromotionImg;
    public List<PromptEntity> mRating;
    public PromptEntity mRecInfo;
    public List<PromptEntity> mRecInfoList;
    public String mResourceId;
    public CharSequence mShopCateInfoDesc;
    public CharSequence mShopCateInfoDescForTrack;
    public String mShopId;
    public String mShopImg;
    public String mShopName;
    public int mShopStatus;
    public PromptEntity mShopTag;
    public String mShopTip;
    public List<String> mShopTipList;
    public int mSource = -1;
    public String mStatusDesc;
    public List<PromptEntity> mTags;
    public BusinessTransitionNameSet mTransitionNameSet;
    public int orderWay;
    public String statusDesc;
    public String url;
    public ViewMoreEntity viewMoreCard;

    public static ComponentModel convertRvEntity(ComponentEntity componentEntity, FeedPayload feedPayload) {
        ComponentModel componentModel = new ComponentModel();
        HomeBusinessInfoRvModel convertBusinessInfoEntity = convertBusinessInfoEntity(componentEntity, feedPayload);
        if (!TextUtils.isEmpty(componentEntity.mComponentV2.getTmplId())) {
            convertBusinessInfoEntity.mModuleType = componentEntity.mComponentV2.getTmplId();
            componentModel.setTemplateId(componentEntity.mComponentV2.getTmplId());
        }
        if (!TextUtils.isEmpty(componentEntity.mComponentV2.getTmplTag())) {
            convertBusinessInfoEntity.mModuleIndex = componentEntity.mComponentV2.getTmplTag();
        }
        if (TextUtils.isEmpty(convertBusinessInfoEntity.mComponentId) && !TextUtils.isEmpty(componentEntity.mComponentV2.getComponentId())) {
            convertBusinessInfoEntity.mComponentId = componentEntity.mComponentV2.getComponentId();
        }
        if (TextUtils.isEmpty(convertBusinessInfoEntity.mComponentType) && !TextUtils.isEmpty(componentEntity.mComponentV2.getType())) {
            convertBusinessInfoEntity.mComponentType = componentEntity.mComponentV2.getType();
        }
        if (componentEntity.mComponentV2.getPosition() != Integer.MIN_VALUE) {
            convertBusinessInfoEntity.mIndexInModule = componentEntity.mComponentV2.getPosition();
        }
        JsonParser jsonParser = new JsonParser();
        componentModel.setDataModel(convertBusinessInfoEntity);
        if (componentEntity.mComponentV2.getTmplId() != null) {
            componentModel.setWidgetNodeModel(BlocksEngine.Companion.getInstance().buildWidgetNode(componentEntity.mComponentV2.getTmplId(), (JsonObject) jsonParser.parse(GsonUtil.toJson(componentEntity)), componentModel));
        }
        return componentModel;
    }

    public static HomeBusinessInfoRvModel convertCompJson(JsonObject jsonObject, FeedPayload feedPayload) {
        HomeBusinessInfoRvModel homeBusinessInfoRvModel = new HomeBusinessInfoRvModel();
        JsonElement jsonElement = jsonObject.get("data");
        if (jsonElement == null) {
            return homeBusinessInfoRvModel;
        }
        try {
            homeBusinessInfoRvModel = convertBusinessInfoEntity((BusinessInfoEntity) GsonUtil.fromJson(jsonElement, (Type) BusinessInfoEntity.class));
            if (feedPayload != null) {
                homeBusinessInfoRvModel.mPageId = feedPayload.mPageId;
                homeBusinessInfoRvModel.mPageInModule = feedPayload.mPageIndex;
                homeBusinessInfoRvModel.mRowInModule = feedPayload.mComponentIndex;
                homeBusinessInfoRvModel.mPageFilter = feedPayload.mPageFilter;
                homeBusinessInfoRvModel.mAbsoluteIndex = feedPayload.mComponentIndex;
                homeBusinessInfoRvModel.mRecId = feedPayload.mRecId;
                homeBusinessInfoRvModel.mTraceId = feedPayload.mTraceId;
                homeBusinessInfoRvModel.mCateId = feedPayload.mCateId;
                homeBusinessInfoRvModel.fromPage = feedPayload.mFromPage;
                homeBusinessInfoRvModel.intentionType = feedPayload.mIntentionType;
                homeBusinessInfoRvModel.mSource = feedPayload.mSource;
            }
            if (jsonObject.get(BlocksConst.BLOCK_PARAM_COMPONENT_ID) != null) {
                homeBusinessInfoRvModel.mComponentId = jsonObject.get(BlocksConst.BLOCK_PARAM_COMPONENT_ID).getAsString();
            }
            if (jsonObject.get("type") != null) {
                homeBusinessInfoRvModel.mComponentType = jsonObject.get("type").getAsString();
            }
            if (jsonObject.get("position") != null) {
                homeBusinessInfoRvModel.mIndexInModule = jsonObject.get("position").getAsInt();
            }
            if (jsonElement.isJsonObject() && jsonElement.getAsJsonObject().get(BlocksConst.BLOCK_PARAM_MODULE_ID) != null) {
                homeBusinessInfoRvModel.mModuleId = jsonElement.getAsJsonObject().get(BlocksConst.BLOCK_PARAM_MODULE_ID).getAsString();
            }
            homeBusinessInfoRvModel.mColumnInModule = -1;
        } catch (Exception unused) {
        }
        return homeBusinessInfoRvModel;
    }

    public static HomeBusinessInfoRvModel convertBusinessFromTopic(ComponentEntity componentEntity, FeedPayload feedPayload) {
        HomeBusinessInfoRvModel homeBusinessInfoRvModel = new HomeBusinessInfoRvModel();
        JsonObject jsonObject = componentEntity.data;
        if (jsonObject == null) {
            return homeBusinessInfoRvModel;
        }
        try {
            homeBusinessInfoRvModel = convertBusinessInfoEntity((BusinessInfoEntity) GsonUtil.fromJson((JsonElement) jsonObject, (Type) BusinessInfoEntity.class));
            if (feedPayload != null) {
                homeBusinessInfoRvModel.mPageId = feedPayload.mPageId;
                homeBusinessInfoRvModel.mPageInModule = feedPayload.mPageIndex;
                homeBusinessInfoRvModel.mRowInModule = feedPayload.mComponentIndex;
                homeBusinessInfoRvModel.mPageFilter = feedPayload.mPageFilter;
                homeBusinessInfoRvModel.mAbsoluteIndex = feedPayload.mComponentIndex;
                homeBusinessInfoRvModel.mRecId = feedPayload.mRecId;
                homeBusinessInfoRvModel.mTraceId = feedPayload.mTraceId;
                homeBusinessInfoRvModel.mCateId = feedPayload.mCateId;
            }
            homeBusinessInfoRvModel.mComponentId = componentEntity.mComponentId;
            homeBusinessInfoRvModel.mComponentType = componentEntity.mType;
            homeBusinessInfoRvModel.mColumnInModule = -1;
            homeBusinessInfoRvModel.mIndexInModule = componentEntity.mPosition;
        } catch (Exception unused) {
        }
        return homeBusinessInfoRvModel;
    }

    public static HomeBusinessInfoRvModel convertBusinessInfoEntity(ComponentEntity componentEntity, FeedPayload feedPayload) {
        HomeBusinessInfoRvModel convertBusinessInfoEntity = convertBusinessInfoEntity(componentEntity.mBusinessInfo);
        if (feedPayload != null) {
            convertBusinessInfoEntity.mPageId = feedPayload.mPageId;
            convertBusinessInfoEntity.mPageInModule = feedPayload.mPageIndex;
            convertBusinessInfoEntity.mRowInModule = feedPayload.mComponentIndex;
            convertBusinessInfoEntity.mPageFilter = feedPayload.mPageFilter;
            convertBusinessInfoEntity.mAbsoluteIndex = feedPayload.mComponentIndex;
            convertBusinessInfoEntity.mRecId = feedPayload.mRecId;
            convertBusinessInfoEntity.mTraceId = feedPayload.mTraceId;
        }
        convertBusinessInfoEntity.mComponentId = componentEntity.mComponentId;
        convertBusinessInfoEntity.mComponentType = componentEntity.mType;
        convertBusinessInfoEntity.mColumnInModule = -1;
        convertBusinessInfoEntity.mIndexInModule = componentEntity.mPosition;
        return convertBusinessInfoEntity;
    }

    public static HomeBusinessInfoRvModel convertBusinessInfoEntity(BusinessInfoEntity businessInfoEntity, FeedPayload feedPayload) {
        HomeBusinessInfoRvModel convertBusinessInfoEntity = convertBusinessInfoEntity(businessInfoEntity);
        if (feedPayload != null) {
            convertBusinessInfoEntity.mPageId = feedPayload.mPageId;
            convertBusinessInfoEntity.mPageInModule = feedPayload.mPageIndex;
            convertBusinessInfoEntity.mRowInModule = feedPayload.mComponentIndex;
            convertBusinessInfoEntity.mPageFilter = feedPayload.mPageFilter;
            convertBusinessInfoEntity.mAbsoluteIndex = feedPayload.mComponentIndex;
            convertBusinessInfoEntity.mRecId = feedPayload.mRecId;
            convertBusinessInfoEntity.mTraceId = feedPayload.mTraceId;
        }
        return convertBusinessInfoEntity;
    }

    public static HomeBusinessInfoRvModel convertBusinessInfoEntity(BusinessInfoEntity businessInfoEntity) {
        HomeBusinessPool.getPool().putBusiness(businessInfoEntity.shopId, businessInfoEntity);
        HomeBusinessInfoRvModel homeBusinessInfoRvModel = new HomeBusinessInfoRvModel();
        homeBusinessInfoRvModel.mShopName = businessInfoEntity.shopName;
        homeBusinessInfoRvModel.mShopId = businessInfoEntity.shopId;
        homeBusinessInfoRvModel.businessType = businessInfoEntity.businessType;
        homeBusinessInfoRvModel.url = businessInfoEntity.url;
        homeBusinessInfoRvModel.mShopStatus = businessInfoEntity.cShopStatus;
        homeBusinessInfoRvModel.mAvgPrice = businessInfoEntity.shopAvgPriceDesc;
        homeBusinessInfoRvModel.mPromotionImg = null;
        homeBusinessInfoRvModel.mBottomTagEntity = businessInfoEntity.imgBottomTag;
        homeBusinessInfoRvModel.mActEntityList = businessInfoEntity.actTips;
        if (businessInfoEntity.actTips != null && businessInfoEntity.actTips.size() > 0) {
            homeBusinessInfoRvModel.mActTip = businessInfoEntity.actTips.get(0);
            homeBusinessInfoRvModel.mActTipList = new ArrayList();
            for (PromptEntity next : businessInfoEntity.actTips) {
                homeBusinessInfoRvModel.mActTipList.add(next.content);
                if (!TextUtils.isEmpty(next.tagImg)) {
                    homeBusinessInfoRvModel.mIsCouponLogo = true;
                }
            }
        }
        homeBusinessInfoRvModel.mShopCateInfoDesc = m30213b(businessInfoEntity);
        homeBusinessInfoRvModel.mShopCateInfoDescForTrack = m30212a(businessInfoEntity);
        if (businessInfoEntity.recommendTips != null && businessInfoEntity.recommendTips.size() > 0) {
            homeBusinessInfoRvModel.mShopTip = businessInfoEntity.recommendTips.get(0).content;
            homeBusinessInfoRvModel.mShopTipList = new ArrayList();
            for (PromptEntity promptEntity : businessInfoEntity.recommendTips) {
                homeBusinessInfoRvModel.mShopTipList.add(promptEntity.content);
            }
        }
        homeBusinessInfoRvModel.mStatusDesc = businessInfoEntity.cShopStatusDesc;
        homeBusinessInfoRvModel.mDeliveryDesc = m30214c(businessInfoEntity);
        homeBusinessInfoRvModel.mBusinessNextOpenTimeDesc = businessInfoEntity.nextBizTimeDesc;
        homeBusinessInfoRvModel.mDeliveryPriceOri = businessInfoEntity.deliveryPriceOri;
        homeBusinessInfoRvModel.mDeliveryPriceAct = businessInfoEntity.deliveryPriceAct;
        homeBusinessInfoRvModel.mCurrency = businessInfoEntity.currency;
        homeBusinessInfoRvModel.mDeliveryTime = businessInfoEntity.deliveryTime;
        homeBusinessInfoRvModel.mLogoImg = businessInfoEntity.logoImg;
        homeBusinessInfoRvModel.mLogo = businessInfoEntity.logo;
        homeBusinessInfoRvModel.mBgImg = businessInfoEntity.bgImg;
        homeBusinessInfoRvModel.mItemId = businessInfoEntity.itemId;
        homeBusinessInfoRvModel.mHasWine = businessInfoEntity.cHasWine;
        homeBusinessInfoRvModel.mMaxLevel = businessInfoEntity.maxLevel;
        homeBusinessInfoRvModel.mNode = businessInfoEntity.node;
        homeBusinessInfoRvModel.mActInfo = businessInfoEntity.actInfo;
        homeBusinessInfoRvModel.orderWay = businessInfoEntity.orderWay;
        homeBusinessInfoRvModel.mMask = !BusinessDataHelper.checkBusinessStatusNormal(businessInfoEntity.cShopStatus);
        if (!CollectionsUtil.isEmpty(businessInfoEntity.itemList)) {
            homeBusinessInfoRvModel.mFoodItemList = new ArrayList();
            for (int i = 0; i < businessInfoEntity.itemList.size(); i++) {
                homeBusinessInfoRvModel.mFoodItemList.add(SearchFoodItemView.SearchFoodItemModel.convertGoodsItemEntity(businessInfoEntity.itemList.get(i), i));
            }
        }
        if (!CollectionsUtil.isEmpty(businessInfoEntity.items)) {
            homeBusinessInfoRvModel.mFoodItems = new ArrayList();
            for (int i2 = 0; i2 < businessInfoEntity.items.size(); i2++) {
                homeBusinessInfoRvModel.mFoodItems.add(SearchFoodItemView.SearchFoodItemModel.convertModel(businessInfoEntity.items.get(i2), i2));
            }
            if (businessInfoEntity.viewMoreCard != null) {
                homeBusinessInfoRvModel.mFoodItems.add(SearchFoodItemView.SearchFoodItemModel.convertModel(businessInfoEntity.viewMoreCard, homeBusinessInfoRvModel.mFoodItems.size()));
            }
        }
        homeBusinessInfoRvModel.mMatchItemIds = businessInfoEntity.matchItemIds;
        homeBusinessInfoRvModel.mExactMatchType = businessInfoEntity.exactMatchType;
        homeBusinessInfoRvModel.mBuyAgentDesc = getBuyAgentDesc(businessInfoEntity);
        homeBusinessInfoRvModel.mHonorIconUrl = businessInfoEntity.honorInfo != null ? businessInfoEntity.honorInfo.iconUrl : "";
        homeBusinessInfoRvModel.mShopImg = businessInfoEntity.shopImg;
        homeBusinessInfoRvModel.mShopTag = businessInfoEntity.shopTag;
        homeBusinessInfoRvModel.mRating = businessInfoEntity.rating;
        homeBusinessInfoRvModel.mRecInfo = businessInfoEntity.recInfo;
        homeBusinessInfoRvModel.mRecInfoList = businessInfoEntity.recInfoList;
        homeBusinessInfoRvModel.mFulfillment = businessInfoEntity.fulfillment;
        homeBusinessInfoRvModel.mTags = businessInfoEntity.tags;
        homeBusinessInfoRvModel.mAdTagDesc = businessInfoEntity.adTagDesc;
        homeBusinessInfoRvModel.mBizTimeDesc = businessInfoEntity.bizTimeDesc;
        homeBusinessInfoRvModel.mDeliveryType = businessInfoEntity.deliveryType;
        homeBusinessInfoRvModel.statusDesc = businessInfoEntity.statusDesc;
        homeBusinessInfoRvModel.mResourceId = businessInfoEntity.resourceId;
        return homeBusinessInfoRvModel;
    }

    /* renamed from: a */
    private static String m30212a(BusinessInfoEntity businessInfoEntity) {
        if (CollectionsUtil.isEmpty(businessInfoEntity.cateTips)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = businessInfoEntity.cateTips.size();
        for (int i = 0; i < size; i++) {
            sb.append(",");
            sb.append(businessInfoEntity.cateTips.get(i).content);
        }
        return sb.toString().replaceFirst(",", "");
    }

    /* renamed from: b */
    private static CharSequence m30213b(BusinessInfoEntity businessInfoEntity) {
        boolean z;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableString createStarRatingSpanString = BusinessDataHelper.createStarRatingSpanString(businessInfoEntity);
        boolean z2 = true;
        if (!TextUtils.isEmpty(createStarRatingSpanString)) {
            spannableStringBuilder.append(createStarRatingSpanString);
            z = true;
        } else {
            z = false;
        }
        if (z && !TextUtils.isEmpty(businessInfoEntity.shopAvgPriceDesc)) {
            spannableStringBuilder.append(" ");
            spannableStringBuilder.append(m30211a("·", 14));
            spannableStringBuilder.append(" ");
        }
        if (!TextUtils.isEmpty(businessInfoEntity.shopAvgPriceDesc)) {
            spannableStringBuilder.append(businessInfoEntity.shopAvgPriceDesc);
        } else {
            z2 = z;
        }
        if (z2 && !CollectionsUtil.isEmpty(businessInfoEntity.cateTips)) {
            spannableStringBuilder.append(" ");
            spannableStringBuilder.append(m30211a("·", 14));
            spannableStringBuilder.append(" ");
        }
        if (!CollectionsUtil.isEmpty(businessInfoEntity.cateTips)) {
            int size = businessInfoEntity.cateTips.size();
            for (int i = 0; i < size; i++) {
                spannableStringBuilder.append(businessInfoEntity.cateTips.get(i).content);
                if (i < size - 1) {
                    SpannableString spannableString = new SpannableString("/");
                    spannableString.setSpan(new CustomerSideSpacingSpan(13, ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC), DisplayUtils.dip2px(GlobalContext.getContext(), 2.5f)), 0, spannableString.length(), 33);
                    spannableStringBuilder.append(spannableString);
                }
            }
        }
        return spannableStringBuilder;
    }

    /* renamed from: c */
    private static CharSequence m30214c(BusinessInfoEntity businessInfoEntity) {
        if (businessInfoEntity == null || businessInfoEntity.deliveryPriceAct < 0) {
            return "";
        }
        Context context = GlobalContext.getContext();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(businessInfoEntity.deliveryDesc)) {
            SpannableString spannableString = new SpannableString(businessInfoEntity.deliveryDesc);
            spannableString.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableString.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.rf_color_gery_1_0_000000)), 0, spannableString.length(), 33);
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append(" ");
            spannableStringBuilder.append(m30211a("·", 14));
            spannableStringBuilder.append(" ");
        }
        if (businessInfoEntity.deliveryPriceAct <= 0) {
            SpannableString spannableString2 = new SpannableString(ResourceHelper.getString(R.string.customer_common_icon_freedelivery));
            spannableString2.setSpan(new CustomerTypeFaceSpan(FontUtils.getIconTypeface()), 0, spannableString2.length(), 33);
            spannableString2.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableString2.length(), 33);
            spannableString2.setSpan(new ForegroundColorSpan(SkinUtil.getBrandPrimaryColor()), 0, spannableString2.length(), 33);
            spannableString2.setSpan(new CustomerVerticalCenterSpan(14, SkinUtil.getBrandPrimaryColor()), 0, spannableString2.length(), 33);
            spannableStringBuilder.append(spannableString2);
            spannableStringBuilder.append(" ");
            SpannableString spannableString3 = new SpannableString(ResourceHelper.getString(R.string.customer_business_delivery_free));
            spannableString3.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableString3.length(), 33);
            spannableString3.setSpan(new ForegroundColorSpan(SkinUtil.getBrandPrimaryColor()), 0, spannableString3.length(), 33);
            spannableStringBuilder.append(spannableString3);
        } else if (businessInfoEntity.deliveryPriceOri > businessInfoEntity.deliveryPriceAct) {
            SpannableString spannableString4 = new SpannableString(LocalizationUtils.CurrencyUtils.getSimplifiedCurrencyWithSymbolDisplay(businessInfoEntity.deliveryPriceActDisplay, (long) businessInfoEntity.deliveryPriceAct, businessInfoEntity.currency, "home"));
            spannableString4.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableString4.length(), 33);
            spannableString4.setSpan(new CustomerTypeFaceSpan(((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getFontTypeFace(IToolsService.FontType.NORMAL)), 0, spannableString4.length(), 33);
            spannableString4.setSpan(new ForegroundColorSpan(SkinUtil.getBrandPrimaryColor()), 0, spannableString4.length(), 33);
            spannableStringBuilder.append(spannableString4);
            spannableStringBuilder.append(" ");
            SpannableString spannableString5 = new SpannableString(LocalizationUtils.CurrencyUtils.getSimplifiedCurrencyWithSymbolDisplay(businessInfoEntity.deliveryPriceOriDisplay, (long) businessInfoEntity.deliveryPriceOri, businessInfoEntity.currency, "home"));
            spannableString5.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString5.length(), 33);
            spannableString5.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.rf_color_gery_3_60_999999)), 0, spannableString5.length(), 33);
            spannableString5.setSpan(new StrikethroughSpan(), 0, spannableString5.length(), 33);
            spannableStringBuilder.append(spannableString5);
            spannableStringBuilder.append(" ");
        } else {
            SpannableString spannableString6 = new SpannableString(LocalizationUtils.CurrencyUtils.getSimplifiedCurrencyWithSymbolDisplay(businessInfoEntity.deliveryPriceActDisplay, (long) businessInfoEntity.deliveryPriceAct, businessInfoEntity.currency, "home"));
            spannableString6.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableString6.length(), 33);
            spannableString6.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.rf_color_gery_1_0_000000)), 0, spannableString6.length(), 33);
            spannableStringBuilder.append(spannableString6);
            spannableStringBuilder.append(" ");
        }
        return spannableStringBuilder;
    }

    /* renamed from: a */
    private static SpannableString m30211a(String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(i, true), 0, spannableString.length(), 33);
        spannableString.setSpan(new CustomerTypeFaceSpan(((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getFontTypeFace(IToolsService.FontType.BOLD)), 0, spannableString.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC)), 0, spannableString.length(), 33);
        return spannableString;
    }

    public static CharSequence getBuyAgentDesc(BusinessInfoEntity businessInfoEntity) {
        if (businessInfoEntity == null || businessInfoEntity.modeInfo == null || !businessInfoEntity.modeInfo.isBuyAgent() || TextUtils.isEmpty(businessInfoEntity.modeInfo.getModeTagDesc())) {
            return "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = ResourceHelper.getString(R.string.customer_common_icon_buy_by_rider);
        SpannableString spannableString = new SpannableString(string + " " + businessInfoEntity.modeInfo.getModeTagDesc());
        spannableString.setSpan(new CustomerTypeFaceSpan(FontUtils.getIconTypeface()), 0, string.length(), 33);
        spannableString.setSpan(new CustomerVerticalCenterSpan(14), 0, string.length(), 33);
        spannableStringBuilder.append(spannableString);
        return spannableStringBuilder;
    }
}
