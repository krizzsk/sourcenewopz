package com.didi.soda.goodsV2.model;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.CustomerTypeFaceSpan;
import com.didi.soda.customer.foundation.util.CustomerVerticalCenterSpan;
import com.didi.soda.customer.foundation.util.FontUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.SentenceUtil;
import com.didi.soda.goodsV2.helper.GoodsDataHelper;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class GoodsPurchaseHeaderRvModel extends BaseGoodsPurchaseRvModel {
    public GoodsItemEntity.ActDesc mActDesc;
    public ActTagModel mActTagModel;
    public String mBusinessId;
    public int mBusinessStatus;
    public String mGoodsId;
    public String mGoodsMarketingTipString;
    public List<String> mGoodsMarketingTips = new ArrayList();
    public String mGoodsName;
    public String mHeadImg;
    public String mLimitLabel;
    public SpannableStringBuilder mMarketingTipSpan;
    public boolean mNeedShowAlcoholRemind = false;
    public String mPriceDisplay;
    public String mShortDesc;
    public String mSoldDesc;
    public int mSoldStatus;
    public String mSoldTimeDesc;
    public int mSpecialPrice;
    public String mSpecialPriceDisplay;
    public int mStatus;
    public SpannableString mTipContent;
    public SpannableString mTipIcon;

    public static class ActTagModel implements IEntity {
        private static final long serialVersionUID = 1571047961877290177L;
        public SpannableString content;
        public String icon;
    }

    public static GoodsPurchaseHeaderRvModel newInstance(GoodsItemEntity goodsItemEntity) {
        GoodsPurchaseHeaderRvModel goodsPurchaseHeaderRvModel = new GoodsPurchaseHeaderRvModel();
        goodsPurchaseHeaderRvModel.mHeadImg = goodsItemEntity.headImg;
        goodsPurchaseHeaderRvModel.mBusinessId = goodsItemEntity.shopId;
        goodsPurchaseHeaderRvModel.mGoodsId = goodsItemEntity.itemId;
        goodsPurchaseHeaderRvModel.mGoodsName = goodsItemEntity.itemName;
        goodsPurchaseHeaderRvModel.mShortDesc = goodsItemEntity.shortDesc;
        goodsPurchaseHeaderRvModel.mSoldDesc = goodsItemEntity.soldDesc;
        goodsPurchaseHeaderRvModel.mStatus = goodsItemEntity.status;
        goodsPurchaseHeaderRvModel.mSoldStatus = goodsItemEntity.soldStatus;
        goodsPurchaseHeaderRvModel.mSoldTimeDesc = goodsItemEntity.soldTimeDesc;
        goodsPurchaseHeaderRvModel.mSpecialPriceDisplay = goodsItemEntity.specialPriceDisplay;
        goodsPurchaseHeaderRvModel.mPriceDisplay = goodsItemEntity.priceDisplay;
        goodsPurchaseHeaderRvModel.mSpecialPrice = goodsItemEntity.specialPrice;
        goodsPurchaseHeaderRvModel.mActDesc = goodsItemEntity.actDesc;
        if (goodsItemEntity.limitLabel != null) {
            goodsPurchaseHeaderRvModel.mLimitLabel = goodsItemEntity.limitLabel.limitLabelStr;
        }
        if (!CollectionsUtil.isEmpty(goodsItemEntity.tips)) {
            for (PromptEntity promptEntity : goodsItemEntity.tips) {
                goodsPurchaseHeaderRvModel.mGoodsMarketingTips.add(promptEntity.content);
            }
        }
        goodsPurchaseHeaderRvModel.mGoodsMarketingTipString = SentenceUtil.foldStringList(goodsPurchaseHeaderRvModel.mGoodsMarketingTips, "_");
        goodsPurchaseHeaderRvModel.mMarketingTipSpan = new SpannableStringBuilder();
        if (!CollectionsUtil.isEmpty(goodsPurchaseHeaderRvModel.mGoodsMarketingTips)) {
            SpannableString spannableString = new SpannableString(ResourceHelper.getString(R.string.customer_common_icon_mealpreferences));
            spannableString.setSpan(new CustomerTypeFaceSpan(FontUtils.getIconTypeface()), 0, spannableString.length(), 33);
            spannableString.setSpan(new CustomerVerticalCenterSpan(14), 0, spannableString.length(), 33);
            goodsPurchaseHeaderRvModel.mMarketingTipSpan.append(spannableString);
            goodsPurchaseHeaderRvModel.mMarketingTipSpan.append(ResourceHelper.getString(R.string.customer_global_blank));
            for (String append : goodsPurchaseHeaderRvModel.mGoodsMarketingTips) {
                goodsPurchaseHeaderRvModel.mMarketingTipSpan.append(append);
                goodsPurchaseHeaderRvModel.mMarketingTipSpan.append(" ");
            }
        }
        ActTagModel actTagModel = new ActTagModel();
        goodsPurchaseHeaderRvModel.mActTagModel = actTagModel;
        String str = "";
        actTagModel.icon = str;
        goodsPurchaseHeaderRvModel.mActTagModel.content = new SpannableString(str);
        if (!(goodsItemEntity == null || goodsItemEntity.actTag == null || goodsItemEntity.actTag.size() == 0 || goodsItemEntity.actTag.get(0) == null)) {
            str = goodsItemEntity.actTag.get(0).content;
        }
        if (goodsItemEntity.actDesc != null && !TextUtils.isEmpty(goodsItemEntity.actDesc.title)) {
            goodsPurchaseHeaderRvModel.mActTagModel.icon = ResourceHelper.getString(R.string.rf_icon_v3_outlined_information);
        }
        if (!TextUtils.isEmpty(str)) {
            goodsPurchaseHeaderRvModel.mActTagModel.content = m29979a(str);
        }
        return goodsPurchaseHeaderRvModel;
    }

    /* renamed from: a */
    private static SpannableString m29979a(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new CustomerTypeFaceSpan(FontUtils.getIconTypeface()), 0, str.length(), 33);
        spannableString.setSpan(new CustomerVerticalCenterSpan(14), 0, str.length(), 33);
        return spannableString;
    }

    /* renamed from: a */
    private static boolean m29980a(GoodsItemEntity goodsItemEntity) {
        if (!GoodsDataHelper.hasEFOActivityInfo(goodsItemEntity) || goodsItemEntity.activityInfo == null || goodsItemEntity.activityInfo.platSpecial == null || goodsItemEntity.actTag == null || goodsItemEntity.actTag.get(0) == null) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private static boolean m29981b(GoodsItemEntity goodsItemEntity) {
        if (goodsItemEntity.activityInfo == null || goodsItemEntity.activityInfo.buyGift == null || goodsItemEntity.actTag == null || goodsItemEntity.actTag.get(0) == null) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private static boolean m29982c(GoodsItemEntity goodsItemEntity) {
        if (!GoodsDataHelper.isRegularCustomer(goodsItemEntity.activityType) || goodsItemEntity.activityInfo == null || goodsItemEntity.activityInfo.platSpecial == null || goodsItemEntity.actTag == null || goodsItemEntity.actTag.get(0) == null) {
            return false;
        }
        return true;
    }
}
