package com.didi.entrega.pay.widget;

import android.content.Context;
import android.view.View;
import com.didi.entrega.customer.foundation.util.FlyImageLoader;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.pay.model.PayMethodInfoModel;
import com.taxis99.R;

public class PayPaySubItemView extends SubItemView {
    public PayPaySubItemView(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public void setPayPayInfo(PayMethodInfoModel payMethodInfoModel) {
        if (payMethodInfoModel.mIsSigned == 1) {
            FlyImageLoader.loadImageUnspecified(getContext(), payMethodInfoModel.mIconUrl).centerCrop().into(this.mPayIconView);
            this.mPayInfoTitleView.setText(payMethodInfoModel.mChannelName);
            setSubtitle(payMethodInfoModel.mReason);
            this.mPayRightIconView.setSelected(payMethodInfoModel.mIsSelected);
            setSaveString(payMethodInfoModel);
            if (payMethodInfoModel.mIsDisplay) {
                this.mMaskView.setVisibility(8);
                this.mArrowLayout.setVisibility(8);
                this.mPayRightIconView.setVisibility(0);
            } else {
                this.mMaskView.setVisibility(0);
                this.mArrowLayout.setVisibility(8);
                this.mPayRightIconView.setVisibility(8);
                this.mSaveStringView.setVisibility(8);
            }
        } else {
            FlyImageLoader.loadImageUnspecified(getContext(), "").placeholder((int) R.drawable.entrega_icon_add_card).centerCrop().into(this.mPayIconView);
            this.mMaskView.setVisibility(8);
            this.mPayRightIconView.setVisibility(8);
            this.mArrowLayout.setVisibility(8);
            this.mPayInfoTitleView.setText(ResourceHelper.getString(R.string.customer_name_pay_method_add_paypay));
            setSubtitle(ResourceHelper.getString(R.string.customer_global_home_sort_recommend));
        }
        setOnClickListener(new View.OnClickListener(payMethodInfoModel) {
            public final /* synthetic */ PayMethodInfoModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                PayPaySubItemView.this.m15390a(this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15390a(PayMethodInfoModel payMethodInfoModel, View view) {
        if (this.mListener != null) {
            this.mListener.onClickPayPay(payMethodInfoModel);
        }
    }
}
