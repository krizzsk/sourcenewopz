package com.didi.entrega.pay.widget;

import android.content.Context;
import android.text.TextUtils;
import com.didi.entrega.customer.foundation.util.FlyImageLoader;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.pay.model.PayMethodInfoModel;
import com.taxis99.R;

public class CardPaySubItemView extends SubItemView {
    public CardPaySubItemView(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo62600a(PayMethodInfoModel payMethodInfoModel, PayMethodInfoModel.CardInfoModel cardInfoModel) {
        this.mPaySubtitleView.setVisibility(8);
        this.mPaySubtitleView.setText("");
        this.mPayInfoTitleView.setText(cardInfoModel.cardSuffix);
        if (cardInfoModel.mDataType == 1) {
            this.mPayRightIconView.setSelected(cardInfoModel.mIsSelected);
            FlyImageLoader.loadImageUnspecified(getContext(), cardInfoModel.cardOrg).centerCrop().into(this.mPayIconView);
            if (!payMethodInfoModel.mIsDisplay || cardInfoModel.isDisable == 1) {
                this.mMaskView.setVisibility(0);
                this.mPayRightIconView.setVisibility(8);
                this.mSaveStringView.setVisibility(8);
                setSubtitle(cardInfoModel.disableReason);
            } else {
                this.mMaskView.setVisibility(8);
            }
            if (cardInfoModel.needExValidate == 1) {
                this.mPayRightIconView.setVisibility(8);
                this.mArrowLayout.setVisibility(0);
                this.mArrowTextView.setText(ResourceHelper.getString(R.string.FoodC_order_To_be_Notd));
                return;
            }
            m15381b(payMethodInfoModel, cardInfoModel);
            return;
        }
        this.mPayIconView.setImageResource(cardInfoModel.mAddCardIconRes);
        setSubtitle(cardInfoModel.mAddCardSubtitle);
        this.mPayRightIconView.setVisibility(8);
        this.mArrowLayout.setVisibility(8);
        if (!m15380a(payMethodInfoModel) && !TextUtils.isEmpty(cardInfoModel.mRecommendString)) {
            this.mRecommendView.setVisibility(0);
            this.mRecommendView.setText(cardInfoModel.mRecommendString);
        }
    }

    /* renamed from: a */
    private boolean m15380a(PayMethodInfoModel payMethodInfoModel) {
        if (payMethodInfoModel.mCardInfoList == null || payMethodInfoModel.mCardInfoList.size() <= 1) {
            return setSaveString(payMethodInfoModel);
        }
        this.mSaveStringView.setVisibility(8);
        return false;
    }

    /* renamed from: b */
    private void m15381b(PayMethodInfoModel payMethodInfoModel, PayMethodInfoModel.CardInfoModel cardInfoModel) {
        if (!TextUtils.isEmpty(cardInfoModel.tip)) {
            this.mSaveStringView.setText(cardInfoModel.tip);
        } else {
            setSaveString(payMethodInfoModel);
        }
    }
}
