package com.didi.payment.wallet.global.useraccount.topup.banktransfer.presenter;

import androidx.fragment.app.FragmentActivity;
import com.didi.payment.wallet.global.useraccount.topup.banktransfer.contract.WalletBankTransferContract;

public class WalletBankTransferPresenter implements WalletBankTransferContract.Presenter {

    /* renamed from: a */
    private FragmentActivity f31840a;

    /* renamed from: b */
    private WalletBankTransferContract.View f31841b;

    public void requestData() {
    }

    public WalletBankTransferPresenter(FragmentActivity fragmentActivity, WalletBankTransferContract.View view) {
        this.f31840a = fragmentActivity;
        this.f31841b = view;
    }
}
