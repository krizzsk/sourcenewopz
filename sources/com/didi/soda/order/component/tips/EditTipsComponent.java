package com.didi.soda.order.component.tips;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.cart.component.globalmini.Contract;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;

public class EditTipsComponent extends MvpComponent<Contract.AbsEditTipsView, Contract.AbsEditTipsPresenter> {
    public EditTipsComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void onSelectPayCard(PayChannelEntity payChannelEntity) {
        ((Contract.AbsEditTipsPresenter) getPresenter()).onSelectCard(payChannelEntity);
    }

    /* access modifiers changed from: protected */
    public Contract.AbsEditTipsPresenter onCreatePresenter() {
        return new EditTipsPresenter();
    }

    /* access modifiers changed from: protected */
    public Contract.AbsEditTipsView onCreateView() {
        return new EditTipsView();
    }
}
