package com.didi.payment.wallet.global.wallet.delegate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.wallet.global.wallet.contract.WalletCommonContract;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.WalletHomePage;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.WalletHomeV2Presenter;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.popmgr.WHomePopChain;

public class WalletHomeDelegate implements IWalletHomeDelegate {

    /* renamed from: a */
    private WalletHomeContract.Presenter f32012a;

    /* renamed from: b */
    private WalletCommonContract.View f32013b;

    /* renamed from: c */
    private Activity f32014c;

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public WalletHomeDelegate(Activity activity) {
        this.f32014c = activity;
    }

    public View onCreateView(Bundle bundle) {
        PayTracker.getTracker().putGlobal("pix_transfer_source_page", "wallet_home_page");
        this.f32013b = new WalletHomePage(this.f32014c);
        m22666a();
        return (View) this.f32013b;
    }

    /* renamed from: a */
    private void m22666a() {
        WalletHomeV2Presenter walletHomeV2Presenter = new WalletHomeV2Presenter(this.f32014c, (WalletHomeContract.V2View) this.f32013b, "2");
        this.f32012a = walletHomeV2Presenter;
        walletHomeV2Presenter.init();
    }

    public void onStart() {
        this.f32012a.requestDataIfNeeded();
        WHomePopChain.INSTANCE.addTask(300).start(this.f32014c, 300);
        m22667b();
    }

    public void onResume() {
        this.f32012a.onResume();
        WHomePopChain.INSTANCE.setHomeVisible(true);
        this.f32012a.requestDataIfNeeded();
        this.f32012a.checkQRCode("");
    }

    /* renamed from: b */
    private void m22667b() {
        if (WalletApolloUtil.isNewPayMethodListEnable()) {
            PayTracker.putGlobal(TransGlobalOmegaKey.KEY_WALLET_PAGEID, "wallet_home_v2");
        } else {
            PayTracker.putGlobal(TransGlobalOmegaKey.KEY_WALLET_PAGEID, "wallet_home");
        }
    }

    public void onStop() {
        WHomePopChain.INSTANCE.setHomeVisible(false);
    }

    public void requestData() {
        this.f32012a.requestData();
    }

    public void onDestroy() {
        this.f32012a.onDestroy();
    }
}
