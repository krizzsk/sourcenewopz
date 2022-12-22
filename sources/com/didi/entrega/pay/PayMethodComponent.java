package com.didi.entrega.pay;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.entrega.customer.foundation.rpc.entity.PayChannel;

public class PayMethodComponent extends MvpComponent<PayMethodView, PayMethodPresenter> {

    /* renamed from: a */
    private PayMethodPresenter f21001a;

    public PayMethodComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void trackSelectCard(PayChannel payChannel) {
        PayMethodPresenter payMethodPresenter = this.f21001a;
        if (payMethodPresenter != null) {
            payMethodPresenter.trackSelectCard(payChannel);
        }
    }

    public void onPayMethodSelect(PayChannel payChannel) {
        PayMethodPresenter payMethodPresenter = this.f21001a;
        if (payMethodPresenter != null) {
            payMethodPresenter.onPayMethodSelect(payChannel);
        }
    }

    /* access modifiers changed from: protected */
    public PayMethodPresenter onCreatePresenter() {
        PayMethodPresenter payMethodPresenter = new PayMethodPresenter();
        this.f21001a = payMethodPresenter;
        return payMethodPresenter;
    }

    /* access modifiers changed from: protected */
    public PayMethodView onCreateView() {
        return new PayMethodView();
    }
}
