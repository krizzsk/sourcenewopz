package com.didi.entrega.pay.widget;

import android.content.Context;
import android.view.View;
import com.didi.entrega.customer.foundation.util.FlyImageLoader;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.pay.model.PayMethodInfoModel;
import com.taxis99.R;

public class Pay99SubItemView extends SubItemView {
    public Pay99SubItemView(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public void set99PayInfo(PayMethodInfoModel payMethodInfoModel) {
        FlyImageLoader.loadImageUnspecified(getContext(), payMethodInfoModel.mIconUrl).centerCrop().into(this.mPayIconView);
        this.mPayInfoTitleView.setText(payMethodInfoModel.mChannelName);
        setSubtitle(payMethodInfoModel.mReason);
        this.mPayRightIconView.setSelected(payMethodInfoModel.mIsSelected);
        setSaveString(payMethodInfoModel);
        int i = 1;
        if (!payMethodInfoModel.mIsDisplay) {
            i = -1;
            this.mMaskView.setVisibility(0);
            this.mArrowLayout.setVisibility(8);
            this.mPayRightIconView.setVisibility(8);
            this.mSaveStringView.setVisibility(8);
        } else if (payMethodInfoModel.mIsSigned != 1) {
            this.mPayRightIconView.setVisibility(8);
            this.mArrowLayout.setVisibility(0);
            this.mArrowTextView.setText(ResourceHelper.getString(R.string.customer_name_select_pay_top_up));
            i = 2;
        } else if (payMethodInfoModel.mIsBalanceEnough == 1) {
            this.mArrowLayout.setVisibility(8);
            this.mPayRightIconView.setVisibility(0);
            i = 0;
        } else {
            this.mPayRightIconView.setVisibility(8);
            this.mArrowLayout.setVisibility(0);
            this.mArrowTextView.setText(ResourceHelper.getString(R.string.customer_name_select_pay_top_up));
        }
        setOnClickListener(new View.OnClickListener(payMethodInfoModel, i) {
            public final /* synthetic */ PayMethodInfoModel f$1;
            public final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                Pay99SubItemView.this.m15383a(this.f$1, this.f$2, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15383a(PayMethodInfoModel payMethodInfoModel, int i, View view) {
        if (this.mListener != null) {
            this.mListener.onClick99Pay(payMethodInfoModel, i);
        }
    }
}
