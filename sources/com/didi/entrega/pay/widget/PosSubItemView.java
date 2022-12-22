package com.didi.entrega.pay.widget;

import android.content.Context;
import com.didi.entrega.customer.foundation.util.FlyImageLoader;
import com.didi.entrega.pay.model.PayMethodInfoModel;
import java.util.Iterator;

public class PosSubItemView extends SubItemView {
    public PosSubItemView(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public void setPosPayInfo(PayMethodInfoModel payMethodInfoModel) {
        FlyImageLoader.loadImageUnspecified(getContext(), payMethodInfoModel.mIconUrl).centerCrop().into(this.mPayIconView);
        this.mPayInfoTitleView.setText(payMethodInfoModel.mPayTypeDesc);
        setSubtitle(payMethodInfoModel.mReason);
        this.mPayRightIconView.setVisibility(8);
        this.mArrowLayout.setVisibility(0);
        if (payMethodInfoModel.mIsDisplay) {
            showOrHideMaskView(false);
        } else {
            showOrHideMaskView(true);
            this.mArrowLayout.setVisibility(8);
            this.mSaveStringView.setVisibility(8);
        }
        PayMethodInfoModel.CardInfoModel cardInfoModel = null;
        if (payMethodInfoModel.mCardInfoList != null) {
            Iterator<PayMethodInfoModel.CardInfoModel> it = payMethodInfoModel.mCardInfoList.iterator();
            while (it.hasNext()) {
                PayMethodInfoModel.CardInfoModel next = it.next();
                if (next.mIsSelected) {
                    cardInfoModel = next;
                }
            }
        }
        if (cardInfoModel != null) {
            this.mArrowImageView.setVisibility(0);
            FlyImageLoader.loadImageUnspecified(getContext(), cardInfoModel.cardOrg).centerCrop().into(this.mArrowImageView);
        }
    }
}
