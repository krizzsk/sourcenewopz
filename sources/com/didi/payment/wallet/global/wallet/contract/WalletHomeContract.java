package com.didi.payment.wallet.global.wallet.contract;

import com.didi.payment.commonsdk.net.PixQrCodeQueryResp;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp;
import com.didi.payment.wallet.global.wallet.contract.WalletCommonContract;
import com.didi.payment.wallet.global.wallet.contract.WalletNewPayMethodListContract;
import com.didi.payment.wallet.global.wallet.contract.WalletOperationBannerContract;
import com.didi.payment.wallet.global.wallet.view.view.IPixEntryClickListener;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Data;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Entry;

public interface WalletHomeContract {

    public interface Listener extends WalletNewPayMethodListContract.Listener, WalletOperationBannerContract.Listener, IPixEntryClickListener {
        void onAccountBlocked2BalanceWithData(WalletHomeResp.AccountSection accountSection);

        void onAccountBlocked2UnBlock(String str);

        void onAccountFrozenDetailClick(String str);

        void onAccountMainEnterClicked(WalletHomeResp.AccountSection accountSection);

        void onConsumeItemClicked(WalletHomeResp.ConsumeItem consumeItem);

        void onDetailsClicked(WalletHomeResp.AccountSection accountSection);

        void onPromotionHeaderClicked(WalletHomeResp.AccountSection accountSection);

        void onRefreshPage();

        void onStatusMsgClicked(WalletHomeResp.AccountSection accountSection);

        void onTermAndConditionsClicked();

        void onWholeCardClicked(WalletHomeResp.AccountSection accountSection);
    }

    public interface Presenter extends WalletCommonContract.Presenter {
        void checkQRCode(String str);

        void onResume();

        void requestDataIfNeeded();

        void requestPwdGuideData();
    }

    public interface V2Listener {
        void onAccountBlocked2UnBlock(String str);

        void onAccountMainEnterClicked(String str, String str2);

        void onBankListClick(String str);

        void onConsumeItemClicked(Entry entry);

        void onRefreshPage();

        void onRefreshUI();

        void onStatusMsgClicked(Data data);
    }

    public interface V2View extends WalletCommonContract.ILoadingView, WalletCommonContract.View<Data, V2Listener> {
        void dismissFlowerAnimation();

        void onQRCodeDetected(PixQrCodeQueryResp.QRCodeData qRCodeData);

        void onRefreshUI();

        void showFlowerAnimation();

        void showPwdGuideDialog(WalletPopUpWindowResp walletPopUpWindowResp);

        void updateEmptyView(String str);

        void updateTitleBar();
    }

    public interface View extends WalletCommonContract.ILoadingView, WalletCommonContract.View<WalletHomeResp.DataBean, Listener> {
        void dismissFlowerAnimation();

        void onQRCodeDetected(PixQrCodeQueryResp.QRCodeData qRCodeData);

        void showFlowerAnimation();

        void showPwdGuideDialog(WalletPopUpWindowResp walletPopUpWindowResp);

        void updateEmptyView(String str);

        void updateTitleBar();
    }
}
