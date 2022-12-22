package com.didi.soda.pay.widget;

import android.content.Context;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.pay.model.PayMethodInfoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/pay/widget/DidiCashSubItemView;", "Lcom/didi/soda/pay/widget/SubItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "setPayInfo", "", "payMethodInfo", "Lcom/didi/soda/pay/model/PayMethodInfoModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DidiCashSubItemView.kt */
public final class DidiCashSubItemView extends SubItemView {
    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DidiCashSubItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setPayInfo(PayMethodInfoModel payMethodInfoModel) {
        Intrinsics.checkNotNullParameter(payMethodInfoModel, "payMethodInfo");
        FlyImageLoader.loadImageUnspecified(getContext(), payMethodInfoModel.mIconUrl).centerCrop().into(this.mPayIconView);
        this.mPayInfoTitleView.setText(payMethodInfoModel.mChannelName);
        setSubtitle(payMethodInfoModel.mReason);
        this.mPayRightIconView.setSelected(payMethodInfoModel.mIsSelected);
        this.mArrowLayout.setVisibility(8);
        if (payMethodInfoModel.mIsDisplay) {
            showOrHideMaskView(false);
            this.mPayRightIconView.setVisibility(0);
            return;
        }
        showOrHideMaskView(true);
        this.mPayRightIconView.setVisibility(8);
    }
}
