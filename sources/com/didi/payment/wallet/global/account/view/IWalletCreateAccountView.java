package com.didi.payment.wallet.global.account.view;

import com.didi.payment.base.mvp.IBaseView;
import com.didi.payment.wallet.global.model.resp.WalletGetApplyInfoResp;

public interface IWalletCreateAccountView extends IBaseView {
    void hideErrorPage();

    void showData(WalletGetApplyInfoResp.CPFInfo cPFInfo);

    void showErrorPage(boolean z, boolean z2);

    void showHomelandCityErrorPage();
}
