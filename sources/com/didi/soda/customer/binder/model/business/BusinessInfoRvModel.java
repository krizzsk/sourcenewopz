package com.didi.soda.customer.binder.model.business;

import android.content.Context;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.customer.animation.transitions.name.BusinessTransitionNameSet;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.didi.soda.customer.foundation.tracker.model.ModuleModel;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.search.SearchFoodItemView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class BusinessInfoRvModel extends ModuleModel implements RecyclerModel {
    public static final int BUSINESS_SOURCE_HOME = 0;
    public static final int BUSINESS_SOURCE_HOME_TOPIC = 1;
    public static final int BUSINESS_SOURCE_SEARCH = 2;
    public static final int BUSINESS_TYPE_LARGE = 1;
    public static final int BUSINESS_TYPE_NORMAL = 0;
    public static final int SEARCH_FOOD_ITEM_DEFAULT_SHOW_NUM = 1;
    public static final int SEARCH_FOOD_ITEM_MAX_SHOW_NUM = 4;
    public String mActTip;
    public List<String> mActTipList;
    public String mAnchorId;
    public int mAnchorType;
    public String mBgImg;
    public String mBusinessNextOpenTimeDesc;
    public List<String> mCateHighlightKeys;
    public String mCateTip;
    public String mComponentType;
    public String mCurrency;
    public CharSequence mDeliveryDesc;
    public int mDeliveryPriceAct;
    public int mDeliveryPriceOri;
    public int mDeliveryTime;
    public int mExactMatchType;
    public List<SearchFoodItemView.SearchFoodItemModel> mFoodItemList;
    public boolean mIsFoodExpanded = false;
    public String mLogoImg;
    public boolean mMask = false;
    public String mMatchItemIds;
    public String mShopId;
    public String mShopName;
    public int mShopStatus;
    public String mShopStatusDesc;
    public String mShopTip;
    public List<String> mShopTipList;
    public int mSource = -1;
    public String mStatusDesc;
    public BusinessTransitionNameSet mTransitionNameSet;
    public int mType;

    public static BusinessInfoRvModel convertBusinessInfoEntity(BusinessInfoEntity businessInfoEntity, int i, int i2, Context context, String str) {
        BusinessInfoRvModel businessInfoRvModel = new BusinessInfoRvModel();
        businessInfoRvModel.mType = i;
        businessInfoRvModel.mComponentType = str;
        businessInfoRvModel.mSource = i2;
        businessInfoRvModel.mShopName = businessInfoEntity.shopName;
        businessInfoRvModel.mShopId = businessInfoEntity.shopId;
        businessInfoRvModel.mShopStatus = businessInfoEntity.cShopStatus;
        businessInfoRvModel.mShopStatusDesc = businessInfoEntity.cShopStatusDesc;
        boolean z = false;
        if (businessInfoEntity.actTips != null && businessInfoEntity.actTips.size() > 0) {
            businessInfoRvModel.mActTip = businessInfoEntity.actTips.get(0).content.toString();
            businessInfoRvModel.mActTipList = new ArrayList();
            for (PromptEntity promptEntity : businessInfoEntity.actTips) {
                businessInfoRvModel.mActTipList.add(promptEntity.content);
            }
        }
        if (businessInfoEntity.cateTips != null && businessInfoEntity.cateTips.size() > 0) {
            businessInfoRvModel.mCateHighlightKeys = new ArrayList();
            int min = Math.min(businessInfoEntity.cateTips.size(), 2);
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < min; i3++) {
                PromptEntity promptEntity2 = businessInfoEntity.cateTips.get(i3);
                if (promptEntity2.highLight == 1) {
                    businessInfoRvModel.mCateHighlightKeys.add(promptEntity2.content);
                }
                sb.append(promptEntity2.content);
                if (i3 < min - 1) {
                    sb.append(ResourceHelper.getString(R.string.customer_global_blank));
                    sb.append(ResourceHelper.getString(R.string.customer_global_middle_dot));
                    sb.append(ResourceHelper.getString(R.string.customer_global_blank));
                }
            }
            businessInfoRvModel.mCateTip = sb.toString();
        }
        if (businessInfoEntity.anchorInfo != null) {
            int i4 = businessInfoEntity.anchorInfo.anchorStatus;
            businessInfoRvModel.mAnchorType = i4;
            if (i4 == 1) {
                businessInfoRvModel.mAnchorId = businessInfoEntity.anchorInfo.itemId;
            } else if (i4 == 2) {
                businessInfoRvModel.mAnchorId = businessInfoEntity.anchorInfo.cateId;
            }
        }
        if (businessInfoEntity.shopTips != null && businessInfoEntity.shopTips.size() > 0) {
            businessInfoRvModel.mShopTip = businessInfoEntity.shopTips.get(0).content;
            businessInfoRvModel.mShopTipList = new ArrayList();
            for (PromptEntity promptEntity3 : businessInfoEntity.shopTips) {
                businessInfoRvModel.mShopTipList.add(promptEntity3.content);
            }
        }
        businessInfoRvModel.mStatusDesc = businessInfoEntity.cShopStatusDesc;
        businessInfoRvModel.mDeliveryDesc = BusinessDataHelper.getBusinessDeliveryInfoForHome(context, businessInfoEntity);
        businessInfoRvModel.mBusinessNextOpenTimeDesc = businessInfoEntity.nextBizTimeDesc;
        businessInfoRvModel.mDeliveryPriceOri = businessInfoEntity.deliveryPriceOri;
        businessInfoRvModel.mDeliveryPriceAct = businessInfoEntity.deliveryPriceAct;
        businessInfoRvModel.mCurrency = businessInfoEntity.currency;
        businessInfoRvModel.mDeliveryTime = businessInfoEntity.deliveryTime;
        businessInfoRvModel.mLogoImg = businessInfoEntity.logoImg;
        businessInfoRvModel.mBgImg = businessInfoEntity.bgImg;
        businessInfoRvModel.mMask = !BusinessDataHelper.checkBusinessStatusNormal(businessInfoEntity.cShopStatus);
        if (!CollectionsUtil.isEmpty(businessInfoEntity.itemList)) {
            businessInfoRvModel.mFoodItemList = new ArrayList();
            for (int i5 = 0; i5 < businessInfoEntity.itemList.size(); i5++) {
                businessInfoRvModel.mFoodItemList.add(SearchFoodItemView.SearchFoodItemModel.convertGoodsItemEntity(businessInfoEntity.itemList.get(i5), i5));
            }
            if (businessInfoRvModel.mFoodItemList.size() <= 1) {
                z = true;
            }
            businessInfoRvModel.mIsFoodExpanded = z;
        }
        businessInfoRvModel.mMatchItemIds = businessInfoEntity.matchItemIds;
        businessInfoRvModel.mExactMatchType = businessInfoEntity.exactMatchType;
        return businessInfoRvModel;
    }
}
