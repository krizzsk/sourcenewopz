package com.didi.payment.wallet.global.wallet.presenter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didi.payment.wallet.global.wallet.contract.WalletTopUpChannelContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;

public class WalletTopUpChannelPresenter implements WalletTopUpChannelContract.Presenter {
    public static final String CHANNEL_ID_BRAZIL_CASH = "1004";

    /* renamed from: a */
    private static final String f32097a = "1000";

    /* renamed from: b */
    private static final String f32098b = "175";

    /* renamed from: c */
    private static final String f32099c = "212";

    /* renamed from: d */
    private static final String f32100d = "1001";

    /* renamed from: e */
    private static final String f32101e = "1002";

    /* renamed from: f */
    private static final String f32102f = "1003";
    public boolean collectAddress;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public FragmentActivity f32103g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public WalletTopUpChannelContract.View f32104h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public WalletLoadingContract f32105i;

    /* renamed from: j */
    private WalletPageModel f32106j;

    public WalletTopUpChannelPresenter(FragmentActivity fragmentActivity, WalletTopUpChannelContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f32103g = fragmentActivity;
        this.f32104h = view;
        this.f32105i = walletLoadingContract;
        this.f32106j = new WalletPageModel(fragmentActivity);
    }

    public void requestData() {
        this.f32105i.showLoadingDialog();
        this.f32106j.requestWalletTopUpChannel(new RpcService.Callback<WalletTopUpChannelResp>() {
            public void onSuccess(WalletTopUpChannelResp walletTopUpChannelResp) {
                WalletTopUpChannelPresenter.this.f32105i.dismissLoadingDialog();
                if (walletTopUpChannelResp == null) {
                    WalletToastNew.showFailedMsg(WalletTopUpChannelPresenter.this.f32103g, WalletTopUpChannelPresenter.this.f32103g.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    WalletTopUpChannelPresenter.this.f32104h.onNetworkError();
                } else if (walletTopUpChannelResp.errno == 0 && walletTopUpChannelResp.data != null) {
                    WalletTopUpChannelPresenter.this.collectAddress = walletTopUpChannelResp.data.collectAddress;
                    WalletTopUpChannelPresenter.this.f32104h.refreshUI(walletTopUpChannelResp.data);
                } else if (walletTopUpChannelResp.errno == 1010) {
                    WalletTopUpChannelPresenter.this.f32104h.showHomelandCityErrorPage();
                } else {
                    WalletToastNew.showFailedMsg(WalletTopUpChannelPresenter.this.f32103g, walletTopUpChannelResp.errmsg);
                    WalletTopUpChannelPresenter.this.f32104h.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                WalletTopUpChannelPresenter.this.f32105i.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(WalletTopUpChannelPresenter.this.f32103g, WalletTopUpChannelPresenter.this.f32103g.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                WalletTopUpChannelPresenter.this.f32104h.onNetworkError();
            }
        });
    }

    public void handleConditionClick(String str) {
        WalletRouter.gotoTopupConditionPage(this.f32103g, str);
    }

    public void handleChannelClick(WalletTopUpChannelResp.ChannelBean channelBean) {
        if (channelBean != null) {
            PayTracker.putGlobal("wallet_channel_id", channelBean.channelId);
            GlobalOmegaUtils.trackTopUpBtnCK(channelBean.name);
            if (TextUtils.equals(channelBean.channelId, f32098b)) {
                GlobalOmegaUtils.trackTopUpOfflineClick(this.f32103g);
                WalletRouter.gotoMexicoOfflinePage(this.f32103g, channelBean);
            } else if (TextUtils.equals(channelBean.channelId, "1000")) {
                GlobalOmegaUtils.trackTopUpOnlineClick(this.f32103g);
                Bundle bundle = new Bundle();
                bundle.putInt("key_from", this.f32103g.getIntent().getIntExtra("key_from", -1));
                WalletRouter.gotoTopupOnlinePay(this.f32103g, bundle, 100);
                trackOnlinePayClick();
            } else if (TextUtils.equals(channelBean.channelId, "1002")) {
                GlobalOmegaUtils.trackTopupChannelBankTransferCK();
                WalletRouter.gotoBankTransferPage(this.f32103g, channelBean);
            } else if (TextUtils.equals(channelBean.channelId, "1001")) {
                GlobalOmegaUtils.trackTopupChannelBoletoCK();
                if (this.collectAddress) {
                    WalletRouter.gotoBoletoPatchAddressPage(this.f32103g, channelBean);
                } else {
                    WalletRouter.gotoBoletoCashinPage(this.f32103g, channelBean);
                }
            } else if (TextUtils.equals(channelBean.channelId, "1003")) {
                GlobalOmegaUtils.trackTopupCardPaymentCK();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("key_from", this.f32103g.getIntent().getIntExtra("key_from", -1));
                WalletRouter.gotoTopupOnlinePay(this.f32103g, bundle2, 100);
                trackOnlinePayClick();
            } else if (TextUtils.equals(channelBean.channelId, "1004")) {
                m22785a(channelBean);
            } else if (TextUtils.equals(channelBean.channelId, f32099c)) {
                WalletRouter.gotoPixTopUpPage(this.f32103g, channelBean);
                m22784a();
            }
        }
    }

    /* renamed from: a */
    private void m22785a(WalletTopUpChannelResp.ChannelBean channelBean) {
        if (channelBean.statusInfo != null) {
            if (channelBean.statusInfo.status == 1) {
                showTopUpByDriverDisabledTips(channelBean);
            } else if (!TextUtils.isEmpty(channelBean.statusInfo.extMetaData)) {
                Bundle bundle = new Bundle();
                bundle.putInt("order_type", 1);
                bundle.putString(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_EXT_METADATA, channelBean.statusInfo.extMetaData);
                bundle.putInt("key_from", this.f32103g.getIntent().getIntExtra("key_from", -1));
                WalletRouter.gotoTopupOnlinePay(this.f32103g, bundle, 1001);
                trackOnlinePayClick();
            }
            HashMap hashMap = new HashMap();
            if (channelBean.statusInfo.status == 1) {
                hashMap.put("availability", 0);
            } else {
                hashMap.put("availability", 1);
            }
            if (WalletTopUpChannelResp.ChannelStatusInfo.isOrderInTrip(channelBean.statusInfo.extMetaData)) {
                hashMap.put("trip_status", 1);
            } else {
                hashMap.put("trip_status", 0);
            }
            PayTracker.trackEvent("ibt_mouton_pax_phone_topup_homepage_by_drv_ck", hashMap);
        }
    }

    /* renamed from: a */
    private void m22784a() {
        PayTracker.trackEvent("ibt_didipay_topup_pix_ck");
    }

    public void trackOnlinePayClick() {
        HashMap hashMap = new HashMap();
        hashMap.put(TransGlobalOmegaKey.KEY_WALLET_PAGEID, Integer.valueOf(this.f32103g.getIntent().getIntExtra("key_from", -1)));
        PayTracker.trackEvent("ibt_mouton_pax_phone_topup_homepage_online_ck", hashMap);
    }

    public void showTopUpByDriverDisabledTips(WalletTopUpChannelResp.ChannelBean channelBean) {
        if (channelBean.statusInfo != null) {
            WalletToastNew.showFailedMsg(this.f32103g, channelBean.statusInfo.title);
            HashMap hashMap = new HashMap();
            hashMap.put("unavailable_reason", Integer.valueOf(channelBean.statusInfo.unableReasonCode));
            if (WalletTopUpChannelResp.ChannelStatusInfo.isOrderInTrip(channelBean.statusInfo.extMetaData)) {
                hashMap.put("trip_status", 1);
            } else {
                hashMap.put("trip_status", 0);
            }
            PayTracker.trackEvent("ibt_gp_didipay_driver_topup_unavailable_reason_sw", hashMap);
        }
    }

    public void handleVerifyClick(String str) {
        DRouter.build(str).start((Context) null);
        FinOmegaSDK.trackEvent("ibt_didipay_balance_cap_verify_ck");
    }
}
