package com.didi.payment.transfer.orderdetail.presenter;

import androidx.fragment.app.FragmentActivity;
import com.didi.payment.transfer.common.IPageLoading;
import com.didi.payment.wallet.global.wallet.contract.WalletOrderSharePicContract;
import com.didi.payment.wallet.global.wallet.presenter.WalletOrderSharePicPresenter;

public class TransOrderSharePicPresenter extends WalletOrderSharePicPresenter {

    /* renamed from: a */
    private IPageLoading f31478a;

    public TransOrderSharePicPresenter(FragmentActivity fragmentActivity, WalletOrderSharePicContract.View view) {
        super(fragmentActivity, view);
    }

    public void setLoadingView(IPageLoading iPageLoading) {
        this.f31478a = iPageLoading;
    }

    /* access modifiers changed from: protected */
    public void showLoading() {
        IPageLoading iPageLoading = this.f31478a;
        if (iPageLoading != null) {
            iPageLoading.onShowPageLoadding();
        }
    }

    /* access modifiers changed from: protected */
    public void dismissLoading() {
        IPageLoading iPageLoading = this.f31478a;
        if (iPageLoading != null) {
            iPageLoading.onDismissPageLoadding();
        }
    }
}
