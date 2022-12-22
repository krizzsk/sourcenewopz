package com.didi.payment.wallet.global.wallet.view.view;

import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.model.resp.WalletPageQueryResp;
import com.didi.payment.wallet.global.wallet.contract.WalletNewPayMethodListContract;
import com.didi.payment.wallet.global.wallet.entity.WalletPageInfo;

public interface IWalletMainListEventListener extends WalletNewPayMethodListContract.Listener, IPixEntryClickListener {
    void onAccountMainBtnClickEvent(WalletPageQueryResp.AccountSectionItem accountSectionItem);

    void onAccountMoreBtnClickEvent(WalletPageQueryResp.AccountSectionItem accountSectionItem);

    void onBalanceBannerClickEvent(String str);

    void onBalanceDetailClickEvent(String str);

    void onBalanceHelpEvent(String str);

    void onBalanceItemClickEvent(WalletPageInfo.BalanceItem balanceItem);

    void onCloseEvent();

    boolean onConsumeItemClickIntercept(WalletHomeResp.ConsumeItem consumeItem);

    void onConsumeItemClicked(WalletHomeResp.ConsumeItem consumeItem);

    void onFinanceItemClick(WalletPageQueryResp.FinanceItem financeItem);

    void onPayMethodAddEvent(WalletPageInfo.AddPayMethodEntryDialogInfo addPayMethodEntryDialogInfo);

    void onPayMethodHelpEvent(String str);

    void onPayMethodItemClickEvent(WalletPageInfo.PayMethodItem payMethodItem);

    void onPromotionItemClickEvent(WalletPageInfo.PromotionItem promotionItem);

    void onRefreshPage();

    void onServiceCenterClicked();

    void onSettingClicked();

    void onTransactionClicked();
}
