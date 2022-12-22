package com.didi.soda.home.topgun.binder.model;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.TextView;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.HomeEfoInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.customer.foundation.tracker.model.ModuleModelV2;
import com.didi.soda.customer.foundation.util.CustomerTypeFaceSpan;
import com.didi.soda.customer.foundation.util.CustomerVerticalCenterSpan;
import com.didi.soda.customer.foundation.util.FontUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.datasource.parser.FeedPayload;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class HomeEfoRvModel extends ModuleModelV2 implements RecyclerModel {
    public String mBevelColor;
    public List<String> mBgcolor;
    public String mCountDownDesc;
    public int mCountDownSecond;
    public List<BusinessGoodsItemRvModel> mEfoGoodsList = new ArrayList();
    public boolean mHasLoadAnimate;
    public boolean mIsLineFeed;
    public String mMoreBgColor;
    public String mMoreTitle;
    public String mMoreUrl;
    public String mRecId;
    public String mRightPic;
    public long mSourceSysTime;
    public CharSequence mTitle;
    public String mUrl;

    public static HomeEfoRvModel convertRvModel(Context context, ComponentEntity componentEntity, FeedPayload feedPayload) {
        if (componentEntity == null || componentEntity.mEfoInfoEntity == null || componentEntity.mEfoInfoEntity.getEfoItemList() == null) {
            return null;
        }
        HomeEfoRvModel homeEfoRvModel = new HomeEfoRvModel();
        HomeEfoInfoEntity homeEfoInfoEntity = componentEntity.mEfoInfoEntity;
        if (homeEfoInfoEntity.getClickMore() != null) {
            homeEfoRvModel.mMoreTitle = homeEfoInfoEntity.getClickMore().getMoreTitle();
            homeEfoRvModel.mMoreUrl = homeEfoInfoEntity.getClickMore().getMoreUrl();
            homeEfoRvModel.mMoreBgColor = homeEfoInfoEntity.getClickMore().getBgColor();
        }
        homeEfoRvModel.mUrl = homeEfoInfoEntity.getUrl();
        homeEfoRvModel.mTitle = m30215a(homeEfoInfoEntity);
        homeEfoRvModel.mBevelColor = homeEfoInfoEntity.getBevelColor();
        homeEfoRvModel.mBgcolor = homeEfoInfoEntity.getBgColor();
        homeEfoRvModel.mRightPic = homeEfoInfoEntity.getRightPic();
        homeEfoRvModel.mCountDownDesc = homeEfoInfoEntity.getCountDownDesc();
        homeEfoRvModel.mCountDownSecond = homeEfoInfoEntity.getCountDownSecond().intValue();
        homeEfoRvModel.mSourceSysTime = System.currentTimeMillis();
        homeEfoRvModel.mIndexInModule = componentEntity.mPosition;
        int size = homeEfoInfoEntity.getEfoItemList().size();
        homeEfoRvModel.mComponentId = componentEntity.mComponentId;
        if (feedPayload != null) {
            homeEfoRvModel.mRecId = feedPayload.mRecId;
        }
        for (int i = 0; i < size; i++) {
            GoodsItemEntity goodsItemEntity = homeEfoInfoEntity.getEfoItemList().get(i);
            BusinessGoodsItemRvModel newInstance = BusinessGoodsItemRvModel.newInstance(goodsItemEntity);
            SpannableString spannableString = new SpannableString(newInstance.mPriceDisplay);
            spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            newInstance.mPriceCharSequenceDisplay = spannableString;
            newInstance.mShopName = goodsItemEntity.shopName;
            newInstance.mLogoImg = goodsItemEntity.logoImg;
            newInstance.mMaxLevel = goodsItemEntity.maxLevel;
            newInstance.mActLabel = goodsItemEntity.actLabel;
            newInstance.mRectId = homeEfoRvModel.mRecId;
            newInstance.mBuyDesc = context.getResources().getString(R.string.FoodC_dish_Purchase_NrCl);
            newInstance.mPosition = i;
            m30216a(context, newInstance, homeEfoRvModel);
            homeEfoRvModel.mEfoGoodsList.add(newInstance);
        }
        for (int i2 = 0; i2 < size; i2++) {
            homeEfoRvModel.mEfoGoodsList.get(i2).mIsLineFeed = homeEfoRvModel.mIsLineFeed;
        }
        return homeEfoRvModel;
    }

    /* renamed from: a */
    private static CharSequence m30215a(HomeEfoInfoEntity homeEfoInfoEntity) {
        if (homeEfoInfoEntity == null || TextUtils.isEmpty(homeEfoInfoEntity.getTitle())) {
            return "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = ResourceHelper.getString(R.string.customer_common_icon_arrow);
        SpannableString spannableString = new SpannableString(homeEfoInfoEntity.getTitle());
        SpannableString spannableString2 = new SpannableString(string);
        spannableString2.setSpan(new CustomerTypeFaceSpan(FontUtils.getIconTypeface()), 0, string.length(), 33);
        spannableString2.setSpan(new CustomerVerticalCenterSpan(8), 0, string.length(), 33);
        spannableStringBuilder.append(spannableString).append(" ").append(spannableString2);
        return spannableStringBuilder;
    }

    /* renamed from: a */
    private static void m30216a(Context context, BusinessGoodsItemRvModel businessGoodsItemRvModel, HomeEfoRvModel homeEfoRvModel) {
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.customer_302px) - context.getResources().getDimensionPixelOffset(R.dimen.customer_44px);
        RFMainButton rFMainButton = new RFMainButton(context);
        rFMainButton.setSpec(1);
        rFMainButton.setText(businessGoodsItemRvModel.mBuyDesc);
        rFMainButton.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = rFMainButton.getMeasuredWidth();
        if (measuredWidth <= context.getResources().getDimensionPixelOffset(R.dimen.customer_123px)) {
            businessGoodsItemRvModel.mBuyButtonWidth = context.getResources().getDimensionPixelOffset(R.dimen.customer_123px);
        } else {
            businessGoodsItemRvModel.mBuyButtonWidth = measuredWidth;
        }
        if (!homeEfoRvModel.mIsLineFeed) {
            TextView textView = new TextView(context);
            textView.setTextSize(1, 16.0f);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(textView, IToolsService.FontType.MEDIUM);
            textView.setText(businessGoodsItemRvModel.mSpecialPriceDisplay);
            TextView textView2 = new TextView(context);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(textView2, IToolsService.FontType.LIGHT);
            textView2.setTextSize(1, 12.0f);
            textView2.setText(businessGoodsItemRvModel.mPriceCharSequenceDisplay);
            int max = Math.max((int) textView.getPaint().measureText(textView.getText().toString()), (int) textView2.getPaint().measureText(textView2.getText().toString()));
            if (measuredWidth + max > dimensionPixelOffset || dimensionPixelOffset - max < context.getResources().getDimensionPixelOffset(R.dimen.customer_123px)) {
                homeEfoRvModel.mIsLineFeed = true;
            }
        }
    }
}
