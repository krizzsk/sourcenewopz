package com.didi.soda.pay;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;

public class PayMethodComponent extends MvpComponent<PayMethodView, PayMethodPresenter> {

    /* renamed from: a */
    private PayMethodPresenter f43627a;

    public PayMethodComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void trackSelectCard(PayChannelEntity payChannelEntity) {
        PayMethodPresenter payMethodPresenter = this.f43627a;
        if (payMethodPresenter != null) {
            payMethodPresenter.trackSelectCard(payChannelEntity);
        }
    }

    public void onPayMethodSelect(PayChannelEntity payChannelEntity) {
        PayMethodPresenter payMethodPresenter = this.f43627a;
        if (payMethodPresenter != null) {
            payMethodPresenter.onPayMethodSelect(payChannelEntity);
        }
    }

    /* access modifiers changed from: protected */
    public PayMethodPresenter onCreatePresenter() {
        PayMethodPresenter payMethodPresenter = new PayMethodPresenter();
        this.f43627a = payMethodPresenter;
        return payMethodPresenter;
    }

    /* access modifiers changed from: protected */
    public PayMethodView onCreateView() {
        return new PayMethodView();
    }
}
