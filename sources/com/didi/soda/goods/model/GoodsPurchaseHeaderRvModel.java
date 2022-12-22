package com.didi.soda.goods.model;

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
import com.didi.soda.goods.helper.GoodsDataHelper;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class GoodsPurchaseHeaderRvModel extends BaseGoodsPurchaseRvModel {
    public ActTagModel mActTagModel;
    public String mBusinessId;
    public int mBusinessStatus;
    public String mGoodsId;
    public String mGoodsMarketingTipString;
    public List<String> mGoodsMarketingTips = new ArrayList();
    public String mGoodsName;
    public String mHeadImg;
    public SpannableStringBuilder mMarketingTipSpan;
    public boolean mNeedShowAlcoholRemind = false;
    public String mShortDesc;
    public String mSoldDesc;
    public int mSoldStatus;
    public String mSoldTimeDesc;
    public int mStatus;
    public SpannableString mTipContent;
    public SpannableString mTipIcon;

    public static class ActTagModel implements IEntity {
        private static final long serialVersionUID = 1571047961877290177L;
        public SpannableString content;
        public SpannableString icon;
    }

    public static GoodsPurchaseHeaderRvModel newInstance(GoodsItemEntity goodsItemEntity) {
        String str;
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
        String str2 = "";
        actTagModel.icon = new SpannableString(str2);
        goodsPurchaseHeaderRvModel.mActTagModel.content = new SpannableString(str2);
        if (goodsItemEntity == null || goodsItemEntity.actTag == null || goodsItemEntity.actTag.size() == 0 || goodsItemEntity.actTag.get(0) == null) {
            str = str2;
        } else {
            str2 = goodsItemEntity.actTag.get(0).icon;
            str = goodsItemEntity.actTag.get(0).content;
        }
        if (!TextUtils.isEmpty(str2)) {
            goodsPurchaseHeaderRvModel.mActTagModel.icon = m29904a(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            goodsPurchaseHeaderRvModel.mActTagModel.content = m29904a(str);
        }
        return goodsPurchaseHeaderRvModel;
    }

    /* renamed from: a */
    private static SpannableString m29904a(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new CustomerTypeFaceSpan(FontUtils.getIconTypeface()), 0, str.length(), 33);
        spannableString.setSpan(new CustomerVerticalCenterSpan(14), 0, str.length(), 33);
        return spannableString;
    }

    /* renamed from: a */
    private static boolean m29905a(GoodsItemEntity goodsItemEntity) {
        if (!GoodsDataHelper.hasEFOActivityInfo(goodsItemEntity) || goodsItemEntity.activityInfo == null || goodsItemEntity.activityInfo.platSpecial == null || goodsItemEntity.actTag == null || goodsItemEntity.actTag.get(0) == null) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private static boolean m29906b(GoodsItemEntity goodsItemEntity) {
        if (goodsItemEntity.activityInfo == null || goodsItemEntity.activityInfo.buyGift == null || goodsItemEntity.actTag == null || goodsItemEntity.actTag.get(0) == null) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private static boolean m29907c(GoodsItemEntity goodsItemEntity) {
        if (!GoodsDataHelper.isRegularCustomer(goodsItemEntity.activityType) || goodsItemEntity.activityInfo == null || goodsItemEntity.activityInfo.platSpecial == null || goodsItemEntity.actTag == null || goodsItemEntity.actTag.get(0) == null) {
            return false;
        }
        return true;
    }
}
