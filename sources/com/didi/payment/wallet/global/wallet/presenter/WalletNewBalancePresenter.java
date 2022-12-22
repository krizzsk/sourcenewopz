package com.didi.payment.wallet.global.wallet.presenter;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.wallet.global.model.WalletBalanceModel;
import com.didi.payment.wallet.global.model.event.WalletNewBalanceLoadingEvent;
import com.didi.payment.wallet.global.model.resp.WalletBalanceInfoResp;
import com.didi.payment.wallet.global.wallet.contract.WalletNewBalanceContract;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class WalletNewBalancePresenter implements WalletNewBalanceContract.Presenter {

    /* renamed from: a */
    boolean f32064a;

    /* renamed from: b */
    int f32065b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletNewBalanceContract.View f32066c;

    /* renamed from: d */
    private FragmentActivity f32067d;

    /* renamed from: e */
    private AccountFreezeData f32068e = null;

    /* renamed from: f */
    private int f32069f = 0;

    /* renamed from: g */
    private WalletBalanceModel f32070g;

    public void onDestroy() {
    }

    public void requestData() {
    }

    public WalletNewBalancePresenter(FragmentActivity fragmentActivity, WalletNewBalanceContract.View view) {
        this.f32067d = fragmentActivity;
        this.f32066c = view;
        this.f32070g = new WalletBalanceModel(fragmentActivity);
    }

    public void init() {
        EventBus.getDefault().register(this);
        Bundle extras = this.f32067d.getIntent().getExtras();
        if (extras != null) {
            this.f32068e = (AccountFreezeData) extras.getSerializable(WalletExtraConstant.Key.KEY_BLOCK_DATA);
            this.f32069f = 0;
            this.f32064a = extras.getBoolean(WalletExtraConstant.Key.HAS_INTEREST);
            this.f32065b = extras.getInt(WalletExtraConstant.Key.BALANCE_TAB, 6);
        }
        this.f32066c.showLoadingDialog();
        this.f32070g.getBalanceInfo(new RpcService.Callback<WalletBalanceInfoResp>() {
            public void onSuccess(WalletBalanceInfoResp walletBalanceInfoResp) {
                if (walletBalanceInfoResp == null) {
                    onFailure((IOException) null);
                    return;
                }
                WalletNewBalancePresenter.this.f32066c.dismissLoadingDialog();
                WalletNewBalancePresenter.this.f32066c.updateContent(walletBalanceInfoResp.data, WalletNewBalancePresenter.this.f32065b);
            }

            public void onFailure(IOException iOException) {
                WalletNewBalancePresenter.this.f32066c.dismissLoadingDialog();
                WalletNewBalancePresenter.this.f32066c.updateContent((WalletBalanceInfoResp.BalanceInfoData) null, WalletNewBalancePresenter.this.f32065b);
            }
        });
    }

    public void onServicesClicked() {
        WebBrowserUtil.startInternalWebActivity(this.f32067d, "https://help.didiglobal.com/passenger-index-new.html?source=99pay&kfPageSource=99pay", "");
    }

    public void onTabHistoryClicked() {
        this.f32066c.showBalanceHistory();
    }

    public void onTabInterestClicked() {
        this.f32066c.showBalanceInterest();
    }

    public void onTabCashbackClicked() {
        this.f32066c.showBalanceCallback();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSignUpSucceed(WalletNewBalanceLoadingEvent walletNewBalanceLoadingEvent) {
        int i;
        if (walletNewBalanceLoadingEvent == null || !walletNewBalanceLoadingEvent.showLoading) {
            this.f32066c.dismissLoadingDialog();
            AccountFreezeData accountFreezeData = this.f32068e;
            if (accountFreezeData != null && (i = this.f32069f) == 0) {
                this.f32069f = i + 1;
                this.f32066c.showVerifyDialog(accountFreezeData);
                return;
            }
            return;
        }
        this.f32066c.showLoadingDialog();
    }

    public void onVerifyNowClicked(String str) {
        DRouter.build(str).start((Context) null);
        FinOmegaSDK.trackEvent("ibt_didipay_interest_verify_ck");
    }

    public void onDetailsClicked(String str) {
        WebBrowserUtil.startInternalWebActivity(this.f32067d, str, "");
        FinOmegaSDK.trackEvent("ibt_didipay_interest_verify_details_ck");
    }
}
