package com.didi.soda.business.model;

import android.content.Context;
import android.text.TextUtils;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.business.component.dynamic.BusinessHeaderParser;
import com.didi.soda.business.component.dynamic.BusinessPayload;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.BusinessAttentionInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;

public final class BusinessHeaderRvModel implements RecyclerModel {
    public BusinessPayload businessPayload;
    public ComponentModel componentModel;
    public JsonObject headerInfoObject;
    public int isFavor = -1;
    public BusinessAttentionInfoEntity mAttentionInfoEntity;
    public String mBusinessCategoryDesc;
    public String mBusinessExceptionDesc;
    public List<PromptEntity> mBusinessMarketingTips = new ArrayList();
    public String mBusinessName;
    public String mBusinessNextOpenTime;
    public List<BusinessCategoryRvModel> mCategoryList = new ArrayList();
    public LinkedHashMap<String, BusinessCategoryRvModel> mCategoryMap;
    public List<BusinessCategoryMenuRvModel> mCategoryMenuList = new ArrayList();
    public CharSequence mDeliveryInfo;
    public String mDyHeadImgUrl;
    public String mDyLogoUrl;
    public int mDynamicPadding = 0;
    public boolean mHasBuyMoreInfo = false;
    public String mHeadImgUrl;
    public String mHonorIconUrl;
    public String mLogoUrl;
    public int mStatus;

    private BusinessHeaderRvModel() {
    }

    public static BusinessHeaderRvModel newInstance(Context context, BusinessEntity businessEntity, BusinessPayload businessPayload2) {
        BusinessHeaderRvModel businessHeaderRvModel = new BusinessHeaderRvModel();
        if (!(businessEntity == null || businessEntity.shopInfo == null)) {
            BusinessInfoEntity businessInfoEntity = businessEntity.shopInfo;
            businessHeaderRvModel.mHeadImgUrl = businessInfoEntity.bgImg;
            businessHeaderRvModel.mBusinessName = businessInfoEntity.shopName;
            businessHeaderRvModel.mStatus = businessInfoEntity.cShopStatus;
            businessHeaderRvModel.mBusinessExceptionDesc = businessInfoEntity.cShopStatusDesc;
            businessHeaderRvModel.mBusinessNextOpenTime = businessInfoEntity.nextBizTimeDesc;
            businessHeaderRvModel.mBusinessCategoryDesc = BusinessDataHelper.getBusinessCategoryInfo(context, businessInfoEntity);
            businessHeaderRvModel.mDeliveryInfo = BusinessDataHelper.getBusinessDeliveryInfo(context, businessInfoEntity);
            businessHeaderRvModel.mLogoUrl = businessInfoEntity.logoImg;
            String str = "";
            businessHeaderRvModel.mHonorIconUrl = businessInfoEntity.honorInfo != null ? businessInfoEntity.honorInfo.iconUrl : str;
            businessHeaderRvModel.isFavor = businessInfoEntity.isFavor;
            businessHeaderRvModel.mBusinessMarketingTips.clear();
            if (!CollectionsUtil.isEmpty(businessInfoEntity.actTips)) {
                for (PromptEntity next : businessInfoEntity.actTips) {
                    if (!TextUtils.isEmpty(next.content)) {
                        businessHeaderRvModel.mBusinessMarketingTips.add(next);
                    }
                }
            }
            if (BusinessDataHelper.hasDynamicNotice(businessEntity)) {
                businessHeaderRvModel.mDynamicPadding = 0;
            } else {
                businessHeaderRvModel.mDynamicPadding = CustomerSystemUtil.getImmersiveStatusBarHeight(GlobalContext.getContext());
            }
            businessHeaderRvModel.mAttentionInfoEntity = businessEntity.attentionInfo;
            if (businessEntity.shopHeader == null || businessEntity.shopHeader.getMJsonComponentList() == null || businessEntity.shopHeader.getMJsonComponentList().size() <= 0) {
                if (businessEntity.shopHeader == null) {
                    str = "shopHeader = null";
                } else if (businessEntity.shopHeader != null && businessEntity.shopHeader.getMJsonComponentList() == null) {
                    str = "ComponentList = null";
                } else if (!(businessEntity.shopHeader == null || businessEntity.shopHeader.getMJsonComponentList() == null || businessEntity.shopHeader.getMJsonComponentList().size() > 0)) {
                    str = "ComponentList size is 0";
                }
                ErrorTracker.Builder addModuleName = ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_M_SHOP_HEADER_DY_ERROR).addModuleName("shop");
                addModuleName.addErrorType("newInstance" + str).addErrorMsg("newInstance 配置化数据解析失败").build().trackError();
            } else {
                JsonObject jsonObject = businessEntity.shopHeader.getMJsonComponentList().get(0);
                businessHeaderRvModel.headerInfoObject = jsonObject;
                if (jsonObject != null) {
                    businessHeaderRvModel.componentModel = (ComponentModel) new BusinessHeaderParser().parser((Context) null, businessHeaderRvModel.headerInfoObject, businessPayload2);
                    try {
                        businessHeaderRvModel.mDyLogoUrl = businessHeaderRvModel.headerInfoObject.getAsJsonObject("data").get("logo").getAsString();
                        businessHeaderRvModel.mDyHeadImgUrl = businessHeaderRvModel.headerInfoObject.getAsJsonObject("data").get("shopImg").getAsString();
                    } catch (Exception e) {
                        LogUtil.m29100d(RoutePath.BUSINESS_HOME, "handle logo and headimg expection:" + e.toString());
                    }
                } else {
                    LogUtil.m29100d("BusinessHeaderRvModel", "parse data headerInfoObject is null");
                }
                businessHeaderRvModel.businessPayload = businessPayload2;
            }
        }
        return businessHeaderRvModel;
    }

    public void updateBusinessStatus(int i, String str) {
        this.mStatus = i;
        this.mBusinessExceptionDesc = str;
        try {
            m28302a(str, this.mBusinessNextOpenTime);
        } catch (Exception e) {
            LogUtil.m29100d("BusinessHeaderRvModel", e.toString());
        }
    }

    /* renamed from: a */
    private void m28302a(String str, String str2) throws JSONException {
        JsonObject asJsonObject = this.headerInfoObject.getAsJsonObject("data");
        asJsonObject.addProperty("statusDesc", str);
        asJsonObject.addProperty(BlocksConst.BIZ_TIME_DESC, str2);
        asJsonObject.addProperty("cShopStatus", (Number) Integer.valueOf(this.mStatus));
        this.headerInfoObject.add("data", asJsonObject);
        if (this.headerInfoObject != null) {
            this.componentModel = (ComponentModel) new BusinessHeaderParser().parser((Context) null, this.headerInfoObject, this.businessPayload);
        } else {
            LogUtil.m29100d("BusinessHeaderRvModel", "updateHeaderDyStatus headerInfoObject is null");
        }
    }
}
