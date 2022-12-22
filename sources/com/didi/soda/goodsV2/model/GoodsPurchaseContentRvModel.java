package com.didi.soda.goodsV2.model;

import com.didi.soda.customer.foundation.rpc.entity.GoodsContentEntity;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.didi.soda.goodsV2.helper.GoodsDataHelper;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GoodsPurchaseContentRvModel extends BaseGoodsPurchaseRvModel {
    public String mContentId;
    public String mContentName;
    public String mContentType;
    public GoodsContentAnimation mGoodsContentAnimation = GoodsContentAnimation.ANIMATION_NONE;
    public boolean mHasSelectedItems;
    public boolean mIsObliged;
    public boolean mIsSatisfied;
    public int mMaxItemNum;
    public int mMinItemNum;
    public String mNumRestrictionTip;
    public int mRvIndex = 0;
    public List<GoodsPurchaseSubItemRvModel> mSubItemList = new ArrayList();

    public enum GoodsContentAnimation {
        ANIMATION_NONE,
        ANIMATION_REMIND,
        ANIMATION_SATISFIED,
        ANIMATION_UNSATISFIED,
        ANIMATION_ITEM_SELECTED,
        ANIMATION_CHANGE_RED
    }

    public static GoodsPurchaseContentRvModel newInstance(GoodsContentEntity goodsContentEntity) {
        GoodsPurchaseContentRvModel goodsPurchaseContentRvModel = new GoodsPurchaseContentRvModel();
        goodsPurchaseContentRvModel.mContentId = goodsContentEntity.contentId;
        goodsPurchaseContentRvModel.mContentName = goodsContentEntity.contentName;
        goodsPurchaseContentRvModel.mMinItemNum = goodsContentEntity.minItemNum;
        goodsPurchaseContentRvModel.mMaxItemNum = goodsContentEntity.maxItemNum;
        boolean isContentObliged = GoodsDataHelper.isContentObliged(goodsContentEntity);
        goodsPurchaseContentRvModel.mIsObliged = isContentObliged;
        goodsPurchaseContentRvModel.mIsSatisfied = !isContentObliged;
        goodsPurchaseContentRvModel.mContentType = goodsContentEntity.minItemNum + "_" + goodsContentEntity.maxItemNum;
        goodsPurchaseContentRvModel.mNumRestrictionTip = m29978a(goodsContentEntity.minItemNum, goodsContentEntity.maxItemNum);
        return goodsPurchaseContentRvModel;
    }

    /* renamed from: a */
    private static String m29978a(int i, int i2) {
        if (i < 0) {
            return "";
        }
        if (i > 0) {
            if (i == i2) {
                Locale currentLocale = ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocale();
                String string = ResourceHelper.getString(R.string.FoodC_Collection__KxnV);
                return String.format(currentLocale, string, new Object[]{i + ""});
            }
            Locale currentLocale2 = ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocale();
            String string2 = ResourceHelper.getString(R.string.FoodC_Collection__ftEq);
            return String.format(currentLocale2, string2, new Object[]{i + "-" + i2});
        } else if (i2 <= 0) {
            return "";
        } else {
            Locale currentLocale3 = ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocale();
            String string3 = ResourceHelper.getString(R.string.FoodC_page2__ZHGg);
            return String.format(currentLocale3, string3, new Object[]{i2 + ""});
        }
    }

    public void setRvIndex(int i) {
        this.mRvIndex = i;
    }

    public void updateSatisfiedState() {
        if (!CollectionsUtil.isEmpty(this.mSubItemList)) {
            int i = 0;
            for (GoodsPurchaseSubItemRvModel selectedAmount : this.mSubItemList) {
                i += selectedAmount.getSelectedAmount();
            }
            updateSatisfiedState(i);
        }
    }

    public void updateSatisfiedState(int i) {
        boolean z = false;
        if (this.mIsObliged) {
            if (i >= this.mMinItemNum && i <= this.mMaxItemNum) {
                z = true;
            }
            this.mIsSatisfied = z;
            return;
        }
        if (i == 0 || (i >= this.mMinItemNum && i <= this.mMaxItemNum)) {
            z = true;
        }
        this.mIsSatisfied = z;
    }

    public void resetAnimationState() {
        this.mGoodsContentAnimation = GoodsContentAnimation.ANIMATION_NONE;
    }
}
