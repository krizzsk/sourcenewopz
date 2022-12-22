package com.didi.soda.business.component.home;

import android.view.View;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.goods.contract.GoodsItemState;
import java.io.Serializable;

public class PreviewImageModel implements Serializable {
    private static final long serialVersionUID = 5766204232950898311L;
    public String mCateId;
    public int mCateIndex;
    public String mCateName;
    public String mGoodId;
    public GoodsItemState mGoodsItemState;
    public String mGoodsMarketingTipString;
    public String mImageUrl;
    public int mInCategoryIndex;
    public String mItemUniqKey;
    public String mLimitedTime;
    public String mName;
    public String mOriginPrice;
    public String mPreviewImageUrl;
    public String mPrice;
    public String mRecId;
    public String mShopId;
    public int mSoldStatus;
    public int mStatus;
    public int mTraceCnt;
    public int mViewHeight;
    public int mViewWidth;

    public static PreviewImageModel copyFrom(BusinessGoodsItemRvModel businessGoodsItemRvModel, View view, int i, String str, int i2) {
        PreviewImageModel previewImageModel = new PreviewImageModel();
        previewImageModel.mShopId = businessGoodsItemRvModel.mBusinessId;
        previewImageModel.mGoodId = businessGoodsItemRvModel.mGoodsId;
        previewImageModel.mItemUniqKey = businessGoodsItemRvModel.mItemUniqKey;
        previewImageModel.mCateId = businessGoodsItemRvModel.mCateId;
        previewImageModel.mCateName = businessGoodsItemRvModel.mCateName;
        previewImageModel.mCateIndex = i;
        previewImageModel.mGoodsItemState = businessGoodsItemRvModel.mGoodsAmountModel.mGoodsItemState;
        previewImageModel.mImageUrl = businessGoodsItemRvModel.mHeadImg;
        previewImageModel.mPreviewImageUrl = businessGoodsItemRvModel.mHeadImg;
        previewImageModel.mName = businessGoodsItemRvModel.mGoodsName;
        previewImageModel.mPrice = businessGoodsItemRvModel.mSpecialPrice >= 0 ? businessGoodsItemRvModel.mSpecialPriceDisplay : businessGoodsItemRvModel.mPriceDisplay;
        previewImageModel.mOriginPrice = businessGoodsItemRvModel.mSpecialPrice >= 0 ? businessGoodsItemRvModel.mPriceDisplay : "";
        previewImageModel.mViewHeight = view.getHeight();
        previewImageModel.mViewWidth = view.getWidth();
        previewImageModel.mStatus = businessGoodsItemRvModel.mStatus;
        previewImageModel.mSoldStatus = businessGoodsItemRvModel.mSoldStatus;
        previewImageModel.mGoodsMarketingTipString = businessGoodsItemRvModel.mGoodsMarketingTipString;
        previewImageModel.mLimitedTime = businessGoodsItemRvModel.mSoldTimeDesc;
        previewImageModel.mInCategoryIndex = businessGoodsItemRvModel.mInCategoryIndex;
        previewImageModel.mRecId = str;
        previewImageModel.mTraceCnt = i2;
        return previewImageModel;
    }

    public boolean isFromSearch() {
        return this.mTraceCnt >= 0;
    }
}
