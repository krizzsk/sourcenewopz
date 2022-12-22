package com.didi.consume.channels.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.consume.base.CsNetModel;
import com.didi.consume.channels.model.CsTopUpChannelResp;
import com.didi.consume.channels.view.CsTopUpChannelContract;
import com.didi.consume.phone.view.activities.CsPhoneRefillActivity;
import com.didi.global.globalgenerickit.GGKUICreator;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel1;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.WalletToast;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.model.resp.WalletDriverATMResp;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didi.soda.blocks.constant.Const;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;

public class CsTopupChannelPresenter implements CsTopUpChannelContract.Presenter {

    /* renamed from: a */
    private static final String f16233a = "1";

    /* renamed from: b */
    private static final String f16234b = "2";

    /* renamed from: i */
    private static final String f16235i = "tab";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FragmentActivity f16236c;
    public boolean collectAddress;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CsTopUpChannelContract.View f16237d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public WalletLoadingContract f16238e;

    /* renamed from: f */
    private WalletPageModel f16239f;

    /* renamed from: g */
    private CsNetModel f16240g;

    /* renamed from: h */
    private int f16241h = -1;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public GGKDrawer f16242j;

    public CsTopupChannelPresenter(FragmentActivity fragmentActivity, CsTopUpChannelContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f16236c = fragmentActivity;
        this.f16237d = view;
        this.f16238e = walletLoadingContract;
        this.f16239f = new WalletPageModel(fragmentActivity);
        this.f16240g = CsNetModel.getIns(this.f16236c);
        Intent intent = fragmentActivity.getIntent();
        if ("tab".equals(intent.getStringExtra(Const.BlockParamConst.SRC))) {
            this.f16241h = 605;
        } else {
            this.f16241h = intent.getIntExtra("product_line", -1);
        }
    }

    public void requestData() {
        this.f16238e.showLoadingDialog();
        this.f16240g.requestPhoneTopUpChannel(new RpcService.Callback<CsTopUpChannelResp>() {
            public void onSuccess(CsTopUpChannelResp csTopUpChannelResp) {
                CsTopupChannelPresenter.this.f16238e.dismissLoadingDialog();
                if (csTopUpChannelResp == null) {
                    WalletToast.showFailedMsg(CsTopupChannelPresenter.this.f16236c, CsTopupChannelPresenter.this.f16236c.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    CsTopupChannelPresenter.this.f16237d.onNetworkError();
                } else if (csTopUpChannelResp.errno == 0) {
                    CsTopupChannelPresenter.this.collectAddress = csTopUpChannelResp.data.collectAddress;
                    CsTopupChannelPresenter.this.f16237d.refreshUI(csTopUpChannelResp.data);
                } else if (csTopUpChannelResp.errno == 1010) {
                    CsTopupChannelPresenter.this.f16237d.showHomelandCityErrorPage();
                } else {
                    WalletToast.showFailedMsg(CsTopupChannelPresenter.this.f16236c, csTopUpChannelResp.errmsg);
                    CsTopupChannelPresenter.this.f16237d.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                CsTopupChannelPresenter.this.f16238e.dismissLoadingDialog();
                WalletToast.showFailedMsg(CsTopupChannelPresenter.this.f16236c, CsTopupChannelPresenter.this.f16236c.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                CsTopupChannelPresenter.this.f16237d.onNetworkError();
            }
        });
    }

    /* renamed from: a */
    private void m11903a(int i) {
        this.f16238e.showLoadingDialog();
        this.f16239f.checkDriverATMStatus(i, new RpcService.Callback<WalletDriverATMResp>() {
            public void onSuccess(final WalletDriverATMResp walletDriverATMResp) {
                CsTopupChannelPresenter.this.f16238e.dismissLoadingDialog();
                if (walletDriverATMResp == null || walletDriverATMResp.data == null) {
                    WalletToast.showFailedMsg(CsTopupChannelPresenter.this.f16236c, CsTopupChannelPresenter.this.f16236c.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                } else if (walletDriverATMResp.canTopup4Psgr()) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("order_type", 1);
                    bundle.putString(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_EXT_METADATA, walletDriverATMResp.data.extMetaData);
                    CsPhoneRefillActivity.launch(CsTopupChannelPresenter.this.f16236c, bundle);
                } else {
                    GGKDrawerModel1 gGKDrawerModel1 = new GGKDrawerModel1(walletDriverATMResp.data.title, new GGKBtnTextAndCallback(CsTopupChannelPresenter.this.f16236c.getString(R.string.wallet_dialog_ok_ok), new GGKOnAntiShakeClickListener() {
                        public void onAntiShakeClick(View view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("source", 0);
                            hashMap.put("rejection_type", Integer.valueOf(walletDriverATMResp.errno));
                            FinOmegaSDK.trackEvent("ibt_mouton_pax_driver_topup_rejection_ck", hashMap);
                            if (CsTopupChannelPresenter.this.f16242j != null) {
                                CsTopupChannelPresenter.this.f16242j.dismiss();
                            }
                        }
                    }));
                    gGKDrawerModel1.setSubTitle(walletDriverATMResp.data.subTitle);
                    CsTopupChannelPresenter csTopupChannelPresenter = CsTopupChannelPresenter.this;
                    GGKDrawer unused = csTopupChannelPresenter.f16242j = GGKUICreator.showDrawerModel(csTopupChannelPresenter.f16236c, gGKDrawerModel1);
                    HashMap hashMap = new HashMap();
                    hashMap.put("source", 0);
                    hashMap.put("rejection_type", Integer.valueOf(walletDriverATMResp.errno));
                    FinOmegaSDK.trackEvent("ibt_mouton_pax_driver_topup_rejection_sw", hashMap);
                }
            }

            public void onFailure(IOException iOException) {
                CsTopupChannelPresenter.this.f16238e.dismissLoadingDialog();
                WalletToast.showFailedMsg(CsTopupChannelPresenter.this.f16236c, CsTopupChannelPresenter.this.f16236c.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
            }
        });
    }

    public void handleConditionClick(String str) {
        WalletRouter.gotoTopupConditionPage(this.f16236c, str);
    }

    public void handleChannelClick(WalletTopUpChannelResp.ChannelBean channelBean) {
        if (channelBean != null) {
            PayTracker.putGlobal("wallet_channel_id", channelBean.channelId);
            if (TextUtils.equals(channelBean.channelId, "1")) {
                FinOmegaSDK.trackEvent("ibt_mouton_pax_phone_topup_homepage_online_ck");
                CsPhoneRefillActivity.launch(this.f16236c, new Bundle());
            } else if (TextUtils.equals(channelBean.channelId, "2")) {
                FinOmegaSDK.trackEvent("ibt_mouton_pax_phone_topup_homepage_ck");
                m11903a(this.f16241h);
            }
        }
    }
}
