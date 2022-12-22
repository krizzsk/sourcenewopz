package com.didi.soda.business.model;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.ActTagEntity;
import com.didi.soda.customer.foundation.rpc.entity.ButtonInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.ImageBottomTagEntity;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.CustomerTypeFaceSpan;
import com.didi.soda.customer.foundation.util.CustomerVerticalCenterSpan;
import com.didi.soda.customer.foundation.util.FontUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.SentenceUtil;
import com.didi.soda.customer.foundation.util.locale.LocalizationUtils;
import com.didi.soda.goods.contract.GoodsAmountModel;
import com.didi.soda.goods.helper.GoodsDataHelper;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BusinessGoodsItemRvModel extends BaseBusinessRvModel implements IEntity {
    private static final long serialVersionUID = -8248389162782218344L;
    public boolean hasMultipleContents;
    public boolean isShowed = false;
    public String mActLabel;
    public List<ActTagEntity> mActTagList;
    public ActInfoEntity mActinfo;
    public int mActivityType;
    public boolean mAddToCartAnimation = false;
    public int mAdditionalType = 0;
    public String mBizTimeDesc;
    public ImageBottomTagEntity mBottomTagEntity;
    public ButtonInfoEntity mBtnInfo;
    public String mBusinessId;
    public int mBuyButtonWidth;
    public String mBuyDesc;
    public String mBuyGiftDesc;
    public String mBuyGiftOriPriceDisplay;
    public CharSequence mBuyGiftPriceDisplay;
    public String mCateId;
    public int mCateIndex;
    public String mCateName;
    public String mCurrency;
    public int mDeliveryFee;
    public long mDeliveryTime;
    public int mDiscountDeliveryFee;
    public List<PromptEntity> mFulfillment;
    public GoodsAmountModel mGoodsAmountModel;
    public String mGoodsId;
    public String mGoodsMarketingTipString;
    public List<String> mGoodsMarketingTips = new ArrayList();
    public String mGoodsName;
    public int mHasWine;
    public String mHeadImg;
    public int mInCategoryIndex;
    public int mIndexInModule;
    public boolean mIsAnchorItem = false;
    public boolean mIsLineFeed;
    public String mItemImg;
    public String mItemUniqKey;
    public String mLimitedTime;
    public String mLogo;
    public String mLogoImg;
    public SpannableStringBuilder mMarketingTipSpan;
    public int mMaxLevel;
    public int mMaxOrderSale;
    public boolean mNeedAlcoholRemind = false;
    public int mNeedReloadDetail;
    public ItemNodeEntity mNode;
    public String mOriginalPriceDesc;
    public int mPosition;
    public int mPrice;
    public CharSequence mPriceCharSequenceDisplay;
    public String mPriceDesc;
    public String mPriceDisplay;
    public List<PromptEntity> mRating;
    public List<PromptEntity> mRecInfoList;
    public String mRectId;
    public String mShopName;
    public String mShortDesc;
    public int mSoldStatus;
    public String mSoldTimeDesc;
    public int mSpecialPrice;
    public String mSpecialPriceDisplay;
    public int mStatus;
    public String mStatusDesc;
    public List<PromptEntity> mTags;
    public int orderWay;

    public static BusinessGoodsItemRvModel newInstance(GoodsItemEntity goodsItemEntity) {
        BusinessGoodsItemRvModel businessGoodsItemRvModel = new BusinessGoodsItemRvModel();
        businessGoodsItemRvModel.mBusinessId = goodsItemEntity.shopId;
        businessGoodsItemRvModel.mGoodsId = goodsItemEntity.itemId;
        businessGoodsItemRvModel.mItemImg = goodsItemEntity.itemImg;
        businessGoodsItemRvModel.mDeliveryTime = goodsItemEntity.deliveryTime;
        businessGoodsItemRvModel.mDiscountDeliveryFee = goodsItemEntity.deliveryPriceAct;
        businessGoodsItemRvModel.mDeliveryFee = goodsItemEntity.deliveryPriceOri;
        businessGoodsItemRvModel.mMaxLevel = goodsItemEntity.maxLevel;
        if (TextUtils.isEmpty(goodsItemEntity.itemUniqKey)) {
            businessGoodsItemRvModel.mItemUniqKey = goodsItemEntity.itemId;
        } else {
            businessGoodsItemRvModel.mItemUniqKey = goodsItemEntity.itemUniqKey;
        }
        businessGoodsItemRvModel.mGoodsName = goodsItemEntity.itemName;
        if (TextUtils.isEmpty(goodsItemEntity.shortDesc)) {
            businessGoodsItemRvModel.mShortDesc = "";
        } else {
            businessGoodsItemRvModel.mShortDesc = goodsItemEntity.shortDesc.trim();
        }
        businessGoodsItemRvModel.orderWay = goodsItemEntity.orderWay;
        businessGoodsItemRvModel.mHeadImg = goodsItemEntity.headImg;
        businessGoodsItemRvModel.mStatus = goodsItemEntity.status;
        businessGoodsItemRvModel.mSoldStatus = goodsItemEntity.soldStatus;
        businessGoodsItemRvModel.mLimitedTime = goodsItemEntity.soldTimeDesc;
        businessGoodsItemRvModel.mPrice = goodsItemEntity.price;
        businessGoodsItemRvModel.mSpecialPrice = goodsItemEntity.specialPrice;
        businessGoodsItemRvModel.mPriceDisplay = LocalizationUtils.CurrencyUtils.getCurrencyDisplay(goodsItemEntity.priceDisplay, (long) goodsItemEntity.price, goodsItemEntity.currency, "shop");
        businessGoodsItemRvModel.mSpecialPriceDisplay = LocalizationUtils.CurrencyUtils.getCurrencyDisplay(goodsItemEntity.specialPriceDisplay, (long) goodsItemEntity.specialPrice, goodsItemEntity.currency, "shop");
        businessGoodsItemRvModel.mMaxOrderSale = goodsItemEntity.maxOrderSale;
        businessGoodsItemRvModel.mCurrency = goodsItemEntity.currency;
        if (!CollectionsUtil.isEmpty(goodsItemEntity.tips)) {
            for (PromptEntity promptEntity : goodsItemEntity.tips) {
                businessGoodsItemRvModel.mGoodsMarketingTips.add(promptEntity.content);
            }
        }
        businessGoodsItemRvModel.mGoodsMarketingTipString = SentenceUtil.foldStringList(businessGoodsItemRvModel.mGoodsMarketingTips, "_");
        businessGoodsItemRvModel.mMarketingTipSpan = new SpannableStringBuilder();
        if (!CollectionsUtil.isEmpty(businessGoodsItemRvModel.mGoodsMarketingTips)) {
            SpannableString spannableString = new SpannableString(ResourceHelper.getString(R.string.customer_common_icon_mealpreferences));
            spannableString.setSpan(new CustomerTypeFaceSpan(FontUtils.getIconTypeface()), 0, spannableString.length(), 33);
            spannableString.setSpan(new CustomerVerticalCenterSpan(14), 0, spannableString.length(), 33);
            businessGoodsItemRvModel.mMarketingTipSpan.append(spannableString);
            businessGoodsItemRvModel.mMarketingTipSpan.append(ResourceHelper.getString(R.string.customer_global_blank));
            for (String append : businessGoodsItemRvModel.mGoodsMarketingTips) {
                businessGoodsItemRvModel.mMarketingTipSpan.append(append);
                businessGoodsItemRvModel.mMarketingTipSpan.append(" ");
            }
        }
        businessGoodsItemRvModel.mSoldTimeDesc = goodsItemEntity.soldTimeDesc;
        businessGoodsItemRvModel.hasMultipleContents = GoodsDataHelper.hasMultipleContents(goodsItemEntity);
        businessGoodsItemRvModel.mHasWine = goodsItemEntity.cHasWine;
        businessGoodsItemRvModel.mNode = goodsItemEntity.node;
        businessGoodsItemRvModel.mLogo = goodsItemEntity.logo;
        businessGoodsItemRvModel.mBizTimeDesc = goodsItemEntity.bizTimeDesc;
        businessGoodsItemRvModel.mStatusDesc = goodsItemEntity.statusDesc;
        businessGoodsItemRvModel.mShopName = goodsItemEntity.shopName;
        businessGoodsItemRvModel.mRating = goodsItemEntity.rating;
        businessGoodsItemRvModel.mRecInfoList = goodsItemEntity.recInfoList;
        businessGoodsItemRvModel.mFulfillment = goodsItemEntity.fulfillment;
        businessGoodsItemRvModel.mTags = goodsItemEntity.tags;
        businessGoodsItemRvModel.mBottomTagEntity = goodsItemEntity.imgBottomTag;
        businessGoodsItemRvModel.mPriceDesc = goodsItemEntity.priceDesc;
        businessGoodsItemRvModel.mOriginalPriceDesc = goodsItemEntity.origPriceDesc;
        businessGoodsItemRvModel.mBtnInfo = goodsItemEntity.btnInfo;
        businessGoodsItemRvModel.mActTagList = goodsItemEntity.actTag;
        businessGoodsItemRvModel.mNeedReloadDetail = goodsItemEntity.needReloadDetail;
        businessGoodsItemRvModel.mActinfo = goodsItemEntity.actInfo;
        businessGoodsItemRvModel.mActivityType = goodsItemEntity.activityType;
        businessGoodsItemRvModel.mAdditionalType = goodsItemEntity.additionalType;
        return businessGoodsItemRvModel;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BusinessGoodsItemRvModel)) {
            return false;
        }
        BusinessGoodsItemRvModel businessGoodsItemRvModel = (BusinessGoodsItemRvModel) obj;
        try {
            if (!this.mBusinessId.equals(businessGoodsItemRvModel.mBusinessId) || !this.mGoodsId.equals(businessGoodsItemRvModel.mGoodsId) || !this.mItemUniqKey.equals(businessGoodsItemRvModel.mItemUniqKey) || !this.mCateId.equals(businessGoodsItemRvModel.mCateId)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mBusinessId, this.mGoodsId, this.mItemUniqKey, this.mCateId});
    }
}
