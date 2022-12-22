package com.didi.payment.wallet.global.wallet.presenter;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.base.view.PayBaseToast;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.wallet.global.constant.ProtocolType;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelRespOldServer;
import com.didi.payment.wallet.global.model.resp.WalletUserProtocolsResp;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletTopUpChannelContractOldServer;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpAmountActivityOldServer;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class WalletTopUpChannelPresenterOldServer implements WalletTopUpChannelContractOldServer.Presenter {

    /* renamed from: a */
    private static final String f32107a = "mx_online";

    /* renamed from: b */
    private static final String f32108b = "oxxo";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FragmentActivity f32109c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WalletTopUpChannelContractOldServer.View f32110d;

    /* renamed from: e */
    private WalletPageModel f32111e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public WalletTopUpChannelRespOldServer.DataBean f32112f;

    public WalletTopUpChannelPresenterOldServer(FragmentActivity fragmentActivity, WalletTopUpChannelContractOldServer.View view) {
        this.f32109c = fragmentActivity;
        this.f32110d = view;
        this.f32111e = new WalletPageModel(fragmentActivity);
    }

    public void requestData() {
        this.f32110d.showLoadingDialog();
        this.f32111e.requestWalletTopUpChannelOldServer(new RpcService.Callback<WalletTopUpChannelRespOldServer>() {
            public void onSuccess(WalletTopUpChannelRespOldServer walletTopUpChannelRespOldServer) {
                WalletTopUpChannelPresenterOldServer.this.f32110d.dismissLoadingDialog();
                if (walletTopUpChannelRespOldServer == null || walletTopUpChannelRespOldServer.data == null) {
                    PayBaseToast.showInfo((Context) WalletTopUpChannelPresenterOldServer.this.f32109c, (int) R.string.one_payment_global_net_toast_serverbusy);
                    WalletTopUpChannelPresenterOldServer.this.f32110d.onNetworkError();
                } else if (walletTopUpChannelRespOldServer.errno == 0) {
                    WalletTopUpChannelRespOldServer.DataBean unused = WalletTopUpChannelPresenterOldServer.this.f32112f = walletTopUpChannelRespOldServer.data;
                    WalletTopUpChannelPresenterOldServer.this.f32110d.refreshUI(walletTopUpChannelRespOldServer.data);
                } else {
                    PayBaseToast.showInfo((Context) WalletTopUpChannelPresenterOldServer.this.f32109c, walletTopUpChannelRespOldServer.errmsg);
                    WalletTopUpChannelPresenterOldServer.this.f32110d.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                WalletTopUpChannelPresenterOldServer.this.f32110d.dismissLoadingDialog();
                PayBaseToast.showInfo((Context) WalletTopUpChannelPresenterOldServer.this.f32109c, (int) R.string.one_payment_global_net_toast_connectionerror);
                WalletTopUpChannelPresenterOldServer.this.f32110d.onNetworkError();
            }
        });
    }

    public void handleChannelClick(WalletTopUpChannelRespOldServer.ChannelBean channelBean) {
        if (channelBean != null) {
            if (TextUtils.equals(channelBean.f31758id, "oxxo")) {
                GlobalOmegaUtils.trackTopUpOfflineClick(this.f32109c);
                WebBrowserUtil.startInternalWebActivity(this.f32109c, channelBean.actionLink, "");
            } else if (TextUtils.equals(channelBean.f31758id, f32107a)) {
                GlobalOmegaUtils.trackTopUpOnlineClick(this.f32109c);
                boolean z = false;
                if (this.f32109c.getIntent() != null && this.f32109c.getIntent().getBooleanExtra("key_from_wallet", false)) {
                    z = true;
                }
                WalletTopUpAmountActivityOldServer.launch(this.f32109c, m22788a(), z);
            }
        }
    }

    public void requestTACProtocolInfo(String str) {
        this.f32110d.showLoadingDialog();
        this.f32111e.getUserRequiredAcceptProtocols(str, new RpcService.Callback<WalletUserProtocolsResp>() {
            public void onSuccess(WalletUserProtocolsResp walletUserProtocolsResp) {
                WalletTopUpChannelPresenterOldServer.this.f32110d.dismissLoadingDialog();
                if (walletUserProtocolsResp == null || walletUserProtocolsResp.data == null) {
                    PayBaseToast.showInfo((Context) WalletTopUpChannelPresenterOldServer.this.f32109c, (int) R.string.one_payment_global_net_toast_serverbusy);
                } else if (walletUserProtocolsResp.errno == 0) {
                    WalletTopUpChannelPresenterOldServer.this.f32110d.showTACDialog(walletUserProtocolsResp.data);
                } else {
                    PayBaseToast.showInfo((Context) WalletTopUpChannelPresenterOldServer.this.f32109c, walletUserProtocolsResp.errmsg);
                }
            }

            public void onFailure(IOException iOException) {
                WalletTopUpChannelPresenterOldServer.this.f32110d.dismissLoadingDialog();
                PayBaseToast.showInfo((Context) WalletTopUpChannelPresenterOldServer.this.f32109c, (int) R.string.one_payment_global_net_toast_connectionerror);
            }
        });
    }

    public void handleTACDialogBtnClick(WalletUserProtocolsResp.UnAcceptProtocol unAcceptProtocol) {
        this.f32110d.showLoadingDialog();
        String str = unAcceptProtocol.link;
        this.f32111e.updateUserAcceptedProtocol(unAcceptProtocol.type, unAcceptProtocol.version, new RpcService.Callback<WalletUserProtocolsResp>() {
            public void onSuccess(WalletUserProtocolsResp walletUserProtocolsResp) {
                WalletTopUpChannelPresenterOldServer.this.f32110d.dismissLoadingDialog();
                if (walletUserProtocolsResp != null) {
                    if (walletUserProtocolsResp.errno == 0) {
                        WalletTopUpChannelPresenterOldServer.this.requestTACProtocolInfo(ProtocolType.TOP_UP.name());
                    } else {
                        PayBaseToast.showInfo((Context) WalletTopUpChannelPresenterOldServer.this.f32109c, walletUserProtocolsResp.errmsg);
                    }
                }
            }

            public void onFailure(IOException iOException) {
                WalletTopUpChannelPresenterOldServer.this.f32110d.dismissLoadingDialog();
                PayBaseToast.showInfo((Context) WalletTopUpChannelPresenterOldServer.this.f32109c, (int) R.string.risk_page_no_internet_toast);
            }
        });
    }

    /* renamed from: a */
    private WalletTopUpChannelResp.ExtraDataMexicoOnline m22788a() {
        WalletTopUpChannelResp.ExtraDataMexicoOnline extraDataMexicoOnline = new WalletTopUpChannelResp.ExtraDataMexicoOnline();
        extraDataMexicoOnline.online_top_up_items = this.f32112f.amounts;
        extraDataMexicoOnline.select_amount_page_title = this.f32112f.channelPageTitle;
        extraDataMexicoOnline.select_amount_rule_text = this.f32112f.amountRuleText;
        extraDataMexicoOnline.select_amount_text = this.f32112f.amountDesc;
        extraDataMexicoOnline.top_up_button_text = this.f32112f.buttonText;
        return extraDataMexicoOnline;
    }
}
