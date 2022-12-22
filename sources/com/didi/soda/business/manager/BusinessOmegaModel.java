package com.didi.soda.business.manager;

import android.text.TextUtils;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.BusinessCateEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import java.io.Serializable;
import java.util.HashSet;

public class BusinessOmegaModel implements Serializable {
    private static final String ACTIVITY_TAB_ID = "2";
    private static final String HOT_SALE_TAB_ID = "1";
    private static final String NEW_SEARCH_RECOMMEND_TAB_ID = "5";
    private static final String NORMAL_TAB_ID = "0";
    private static final String OLD_CUSTOMER_TAB_ID = "4";
    private static final String SEARCH_RECOMMEND_TAB_ID = "3";
    private static final long serialVersionUID = 8078336503097276995L;
    public int couponNum = 0;
    public String mDeliveryFee;
    public int mDeliveryTime;
    public int mDeliveryType;
    public int mDistance;
    public int mExposureActivityNum;
    public GoodsAddCartOmegaModel mGoodsAddCartOmegaModel = new GoodsAddCartOmegaModel();
    public boolean mIsCouponLogo = false;
    public int mIsMarketArea = 0;
    public String mRecId;
    public int mReturnWay = 0;
    public String mTabTypeList;
    public String mTraceId;

    public static String getCategoryTypeFromId(String str) {
        if ("1".equals(str)) {
            return "1";
        }
        if ("2".equals(str)) {
            return "2";
        }
        return "0";
    }

    public static BusinessOmegaModel newInstance(BusinessInfoEntity businessInfoEntity) {
        BusinessOmegaModel businessOmegaModel = new BusinessOmegaModel();
        if (businessInfoEntity != null) {
            businessOmegaModel.mDeliveryFee = businessInfoEntity.currency + "_" + businessInfoEntity.deliveryPriceOri + "_" + businessInfoEntity.deliveryPriceAct;
            businessOmegaModel.mDeliveryTime = businessInfoEntity.deliveryTime;
            businessOmegaModel.mDistance = businessInfoEntity.distance;
            businessOmegaModel.mExposureActivityNum = businessInfoEntity.actTips == null ? 0 : businessInfoEntity.actTips.size();
            businessOmegaModel.mDeliveryType = businessInfoEntity.deliveryType;
        }
        return businessOmegaModel;
    }

    public static BusinessOmegaModel newInstance(BusinessEntity businessEntity, String str) {
        BusinessOmegaModel businessOmegaModel = new BusinessOmegaModel();
        businessOmegaModel.mRecId = businessEntity.recId;
        businessOmegaModel.mTraceId = str;
        OmegaCommonParamHelper.setLv3RecId(businessEntity.recId);
        if (businessEntity.shopInfo != null) {
            businessOmegaModel.mDeliveryFee = businessEntity.shopInfo.currency + "_" + businessEntity.shopInfo.deliveryPriceOri + "_" + businessEntity.shopInfo.deliveryPriceAct;
            businessOmegaModel.mDeliveryTime = businessEntity.shopInfo.deliveryTime;
            businessOmegaModel.mDistance = businessEntity.shopInfo.distance;
            int size = businessEntity.shopInfo.actTips == null ? 0 : businessEntity.shopInfo.actTips.size();
            businessOmegaModel.mExposureActivityNum = size;
            if (size > 0) {
                for (PromptEntity promptEntity : businessEntity.shopInfo.actTips) {
                    if (!TextUtils.isEmpty(promptEntity.tagImg)) {
                        businessOmegaModel.mIsCouponLogo = true;
                    }
                }
            }
            businessOmegaModel.mDeliveryType = businessEntity.shopInfo.deliveryType;
        }
        if (!(businessEntity.shopHeader == null || CollectionsUtil.isEmpty(businessEntity.shopHeader.getMJsonComponentList()) || businessEntity.shopHeader.getMJsonComponentList().get(0) == null)) {
            try {
                businessOmegaModel.couponNum = businessEntity.shopHeader.getMJsonComponentList().get(0).getAsJsonObject("data").getAsJsonArray("couponTags").size();
            } catch (Exception e) {
                LogUtil.m29100d(RoutePath.BUSINESS_HOME, "handleCouponNum expection:" + e.toString());
            }
        }
        if (!CollectionsUtil.isEmpty(businessEntity.cateInfo)) {
            HashSet<String> hashSet = new HashSet<>();
            for (BusinessCateEntity next : businessEntity.cateInfo) {
                if ("1".equals(next.cateId)) {
                    hashSet.add("1");
                } else if ("2".equals(next.cateId)) {
                    hashSet.add("2");
                } else if ("3".equals(next.cateId)) {
                    hashSet.add("3");
                } else if ("4".equals(next.cateId)) {
                    hashSet.add("4");
                } else if ("5".equals(next.cateId)) {
                    hashSet.add("5");
                } else {
                    hashSet.add("0");
                }
            }
            StringBuilder sb = new StringBuilder();
            for (String append : hashSet) {
                sb.append(append);
                sb.append(",");
            }
            businessOmegaModel.mTabTypeList = sb.substring(0, sb.length() - 1);
        } else {
            businessOmegaModel.mTabTypeList = "";
        }
        return businessOmegaModel;
    }

    public BusinessOmegaModel setAddType(int i) {
        this.mGoodsAddCartOmegaModel.mAddType = i;
        return this;
    }

    public BusinessOmegaModel setBusinessInfo() {
        this.mGoodsAddCartOmegaModel.mDeliveryFee = this.mDeliveryFee;
        this.mGoodsAddCartOmegaModel.mDeliveryTime = this.mDeliveryTime;
        this.mGoodsAddCartOmegaModel.mDistance = this.mDistance;
        return this;
    }

    public BusinessOmegaModel setCartId(String str) {
        this.mGoodsAddCartOmegaModel.mCartId = str;
        return this;
    }

    public BusinessOmegaModel setGoodsItemInfo(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        if (this.mGoodsAddCartOmegaModel == null) {
            this.mGoodsAddCartOmegaModel = new GoodsAddCartOmegaModel();
        }
        this.mGoodsAddCartOmegaModel.mGoodsId = businessGoodsItemRvModel.mGoodsId;
        this.mGoodsAddCartOmegaModel.mGoodsStatus = businessGoodsItemRvModel.mStatus;
        this.mGoodsAddCartOmegaModel.mGoodsMarketingTip = businessGoodsItemRvModel.mGoodsMarketingTipString;
        this.mGoodsAddCartOmegaModel.mCateId = businessGoodsItemRvModel.mCateId;
        return this;
    }

    public String toString() {
        return "BusinessOmegaModel{mDeliveryFee='" + this.mDeliveryFee + '\'' + ", mDeliveryTime=" + this.mDeliveryTime + ", mDistance=" + this.mDistance + ", mExposureActivityNum=" + this.mExposureActivityNum + ", mTabTypeList='" + this.mTabTypeList + '\'' + ", mDeliveryType=" + this.mDeliveryType + ", mReturnWay=" + this.mReturnWay + ", mGoodsAddCartOmegaModel=" + this.mGoodsAddCartOmegaModel + '}';
    }

    public class GoodsAddCartOmegaModel implements Serializable {
        public static final int ADD_TYPE_ADD = 1;
        public static final int ADD_TYPE_SUBTRACT = 2;
        private static final long serialVersionUID = -7051049577019094627L;
        public int mAddType;
        public String mCartId = "";
        public String mCartInfo = "";
        public String mCateId;
        public String mDeliveryFee;
        public int mDeliveryTime;
        public int mDistance;
        public String mGoodsId;
        public String mGoodsMarketingTip;
        public int mGoodsStatus;

        public GoodsAddCartOmegaModel() {
        }

        public String toString() {
            return "GoodsAddCartOmegaModel{mGoodsId='" + this.mGoodsId + '\'' + ", mGoodsStatus=" + this.mGoodsStatus + ", mGoodsMarketingTip='" + this.mGoodsMarketingTip + '\'' + ", mCateId='" + this.mCateId + '\'' + ", mDeliveryFee='" + this.mDeliveryFee + '\'' + ", mDeliveryTime=" + this.mDeliveryTime + ", mDistance=" + this.mDistance + ", mAddType=" + this.mAddType + ", mCartInfo='" + this.mCartInfo + '\'' + ", mCartId='" + this.mCartId + '\'' + '}';
        }
    }
}
