package com.didi.soda.business.model;

import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.soda.customer.foundation.rpc.entity.ActTipEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessOpenDayEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessShopPayEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.RuleDescEntity;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BusinessDetailModel {
    public List<BusinessOpenDayModel> mBizOpenDayList = new ArrayList();
    public String mBusinessAddress;
    public LatLng mBusinessLatLng;
    public String mBusinessName;
    public List<String> mBusinessPhone;
    public int mBusinessStatus;
    public String mDeliveryTypeDesc;
    public String mDisclaimerDesc;
    public String mDisclaimerUrl;
    public List<BusinessDiscountDescModel> mDiscountTipList = new ArrayList();
    public String mNextBizTimeDesc;
    public List<BusinessPayDescModel> mPayDescList = new ArrayList();
    public BusinessModeInfoModel modeInfoModel;
    public ShopFeatureTipModel shopFeatureTipModel;

    public static BusinessDetailModel newInstance(BusinessInfoEntity businessInfoEntity) {
        BusinessDetailModel businessDetailModel = new BusinessDetailModel();
        businessDetailModel.mBusinessAddress = businessInfoEntity.addr;
        businessDetailModel.mBusinessName = businessInfoEntity.shopName;
        businessDetailModel.mBusinessStatus = businessInfoEntity.cShopStatus;
        businessDetailModel.mNextBizTimeDesc = businessInfoEntity.nextBizTimeDesc;
        businessDetailModel.mDeliveryTypeDesc = businessInfoEntity.deliveryTypeDesc;
        if (!TextUtils.isEmpty(businessInfoEntity.phone)) {
            businessDetailModel.mBusinessPhone = Arrays.asList(businessInfoEntity.phone.split(","));
        }
        if (!CollectionsUtil.isEmpty(businessInfoEntity.bizDayTimeDesc)) {
            for (BusinessOpenDayEntity next : businessInfoEntity.bizDayTimeDesc) {
                if (next != null) {
                    businessDetailModel.mBizOpenDayList.add(new BusinessOpenDayModel(next.bizDayDesc, next.bizTimeDesc));
                }
            }
        }
        if (!CollectionsUtil.isEmpty(businessInfoEntity.shopPayDesc)) {
            for (BusinessShopPayEntity next2 : businessInfoEntity.shopPayDesc) {
                if (next2 != null) {
                    businessDetailModel.mPayDescList.add(new BusinessPayDescModel(next2.title, next2.cardDesc));
                }
            }
        }
        if (businessInfoEntity.disclaimer != null) {
            businessDetailModel.mDisclaimerUrl = businessInfoEntity.disclaimer.url;
            businessDetailModel.mDisclaimerDesc = businessInfoEntity.disclaimer.desc;
        }
        if (businessInfoEntity.shopFeatureTips != null) {
            businessDetailModel.shopFeatureTipModel = new ShopFeatureTipModel(businessInfoEntity.honorInfo != null ? businessInfoEntity.honorInfo.iconUrl : "", businessInfoEntity.shopFeatureTips.getTitle(), businessInfoEntity.shopFeatureTips.getTips());
        }
        if (!CollectionsUtil.isEmpty(businessInfoEntity.actTipsDetails)) {
            for (int i = 0; i < businessInfoEntity.actTipsDetails.size(); i++) {
                ActTipEntity actTipEntity = businessInfoEntity.actTipsDetails.get(i);
                businessDetailModel.mDiscountTipList.add(new BusinessDiscountDescModel(actTipEntity.cTypeDesc, actTipEntity.content, actTipEntity.ruleDesc));
            }
        }
        businessDetailModel.mBusinessLatLng = new LatLng(businessInfoEntity.lat, businessInfoEntity.lng);
        if (businessInfoEntity.modeInfo != null) {
            businessDetailModel.modeInfoModel = new BusinessModeInfoModel(businessInfoEntity.modeInfo.getType(), businessInfoEntity.modeInfo.getShortDesc(), businessInfoEntity.modeInfo.getRuleLink(), businessInfoEntity.modeInfo.getModeTagDesc(), businessInfoEntity.shopId);
        }
        return businessDetailModel;
    }

    public static class BusinessOpenDayModel {
        public String mDayDesc;
        public List<String> mTimeDesc;

        public BusinessOpenDayModel(String str, List<String> list) {
            this.mDayDesc = str;
            this.mTimeDesc = list;
        }
    }

    public static class BusinessPayDescModel {
        public List<String> mPayCardDesc;
        public String mPayTitle;

        public BusinessPayDescModel(String str, List<String> list) {
            this.mPayTitle = str;
            this.mPayCardDesc = list;
        }
    }

    public static class BusinessDiscountDescModel {
        public String mContent;
        public String mTypeDetail;
        public RuleDescEntity ruleDesc;

        public BusinessDiscountDescModel(String str, String str2, RuleDescEntity ruleDescEntity) {
            this.mTypeDetail = str;
            this.mContent = str2;
            if (ruleDescEntity != null) {
                RuleDescEntity copyByType = ruleDescEntity.copyByType(90);
                this.ruleDesc = copyByType;
                if (TextUtils.isEmpty(copyByType.btnDesc)) {
                    this.ruleDesc.btnDesc = ResourceHelper.getString(R.string.customer_dialog_confirm);
                }
            }
        }
    }

    public static class ShopFeatureTipModel {
        public String iconUrl;
        public List<ActTipEntity> tips;
        public String title;

        public ShopFeatureTipModel(String str, String str2, List list) {
            this.iconUrl = str;
            this.title = str2;
            this.tips = list;
        }
    }

    public static class BusinessModeInfoModel {
        public String mShopId;
        public String modeTagDesc;
        public String ruleLink;
        public String shortDesc;
        public int type;

        public boolean isBuyAgent() {
            return this.type == 2;
        }

        public BusinessModeInfoModel(int i, String str, String str2, String str3, String str4) {
            this.type = i;
            this.shortDesc = str;
            this.ruleLink = str2;
            this.modeTagDesc = str3;
            this.mShopId = str4;
        }
    }
}
