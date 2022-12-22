package com.didi.payment.wallet.global.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.dcrypto.util.network.NetworkConstants;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.CashierLaunchListener;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.service.IWalletService;
import com.didi.payment.base.utils.NewCashierApolloUtils;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.base.view.webview.WalletWebActivity;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.kycservice.utils.ApolloSignUpUtil;
import com.didi.payment.kycservice.utils.KycRegisterUtils;
import com.didi.payment.wallet.global.account.common.model.WalletCommonPageModel;
import com.didi.payment.wallet.global.account.common.view.WalletCommonStatusPageActivity;
import com.didi.payment.wallet.global.model.WalletApolloUtils;
import com.didi.payment.wallet.global.model.resp.WalletCreateOrderResp;
import com.didi.payment.wallet.global.model.resp.WalletCreateOrderRespOldServer;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.didi.payment.wallet.global.useraccount.topup.banktransfer.view.activity.WalletBankTransferActivity;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.activities.WalletBoletoPatchAddressActivity;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.activities.WalletBoletoCashinActivity;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.activities.WalletBoletoHistoryActivity;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.activities.WalletViewBoletoActivity;
import com.didi.payment.wallet.global.wallet.entity.WalletSettingPageInfo;
import com.didi.payment.wallet.global.wallet.view.activity.WalletMainListSettingActivity;
import com.didi.payment.wallet.global.wallet.view.activity.WalletNewBalanceActivity;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpAmountActivity;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpAmountActivityOldServer;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpChannelActivity;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpChannelActivityOldServer;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpUniPayActivity;
import com.didi.payment.wallet.open.DidiWalletFactory;
import com.didi.unifiedPay.component.model.PayParam;
import com.google.gson.Gson;
import com.taxis99.R;
import java.util.Map;

public class WalletRouter {
    public static void gotoFailedReasonPage(Context context, IWalletService.AccountInfo accountInfo) {
        if (ApolloSignUpUtil.getApolloExp()) {
            KycRegisterUtils.INSTANCE.go2SignUpActivity(context, "1", false, (KycRegisterUtils.RouterListener) null);
            return;
        }
        WalletCommonPageModel walletCommonPageModel = new WalletCommonPageModel();
        walletCommonPageModel.accountStatus = accountInfo;
        walletCommonPageModel.topImageId = R.drawable.wallet_common_png_create_failed;
        walletCommonPageModel.targetPage = 4;
        WalletCommonStatusPageActivity.startActivity(context, walletCommonPageModel);
    }

    public static void gotoSignUpGuidePage(Context context, IWalletService.AccountInfo accountInfo) {
        if (ApolloSignUpUtil.getApolloExp()) {
            KycRegisterUtils.INSTANCE.go2SignUpActivity(context, "1", false, (KycRegisterUtils.RouterListener) null);
            return;
        }
        WalletCommonPageModel walletCommonPageModel = new WalletCommonPageModel();
        walletCommonPageModel.accountStatus = accountInfo;
        walletCommonPageModel.targetPage = 1;
        WalletCommonStatusPageActivity.startActivity(context, walletCommonPageModel);
    }

    public static void gotoTopUpGuidePage(Context context, IWalletService.AccountInfo accountInfo) {
        WalletCommonPageModel walletCommonPageModel = new WalletCommonPageModel();
        walletCommonPageModel.accountStatus = accountInfo;
        walletCommonPageModel.targetPage = 3;
        WalletCommonStatusPageActivity.startActivity(context, walletCommonPageModel);
    }

    public static void gotoSignUpWaitingPage(Context context, IWalletService.AccountInfo accountInfo) {
        if (ApolloSignUpUtil.getApolloExp()) {
            KycRegisterUtils.INSTANCE.go2SignUpActivity(context, "1", false, (KycRegisterUtils.RouterListener) null);
            return;
        }
        WalletCommonPageModel walletCommonPageModel = new WalletCommonPageModel();
        walletCommonPageModel.accountStatus = accountInfo;
        walletCommonPageModel.targetPage = 2;
        WalletCommonStatusPageActivity.startActivity(context, walletCommonPageModel);
    }

    public static void gotoApplyAccountPage(Context context) {
        KycRegisterUtils.INSTANCE.go2SignUpActivity(context, "1", false, (KycRegisterUtils.RouterListener) null);
    }

    public static void gotoTopUpPage(Context context) {
        DidiWalletFactory.createGlobalWalletApi().openWalletTopUpChannelPage(context);
    }

    public static void gotoTopUpPage(Context context, int i) {
        DidiWalletFactory.createGlobalWalletApi().openWalletTopUpChannelPage(context, i);
    }

    public static void gotoBoletoCashinPage(FragmentActivity fragmentActivity, WalletTopUpChannelResp.ChannelBean channelBean) {
        if (channelBean == null || channelBean.extraData == null) {
            WalletBoletoCashinActivity.launch(fragmentActivity);
        } else {
            WalletBoletoCashinActivity.launch(fragmentActivity, (WalletTopUpChannelResp.ChannelExtraData) new Gson().fromJson(channelBean.extraData, WalletTopUpChannelResp.ChannelExtraData.class));
        }
    }

    public static void gotoBoletoPatchAddressPage(FragmentActivity fragmentActivity, WalletTopUpChannelResp.ChannelBean channelBean) {
        WalletBoletoPatchAddressActivity.launch(fragmentActivity, channelBean);
    }

    public static void gotoBankTransferPage(FragmentActivity fragmentActivity, WalletTopUpChannelResp.ChannelBean channelBean) {
        WalletBankTransferActivity.launch(fragmentActivity, (WalletTopUpChannelResp.ExtraDataBrazilBankTransfer) new Gson().fromJson(channelBean.extraData, WalletTopUpChannelResp.ExtraDataBrazilBankTransfer.class));
    }

    public static void gotoMexicoOnlinePage(FragmentActivity fragmentActivity, WalletTopUpChannelResp.ChannelBean channelBean) {
        boolean z = false;
        if (fragmentActivity.getIntent() != null && fragmentActivity.getIntent().getBooleanExtra("key_from_wallet", false)) {
            z = true;
        }
        WalletTopUpAmountActivityOldServer.launch(fragmentActivity, (WalletTopUpChannelResp.ExtraDataMexicoOnline) new Gson().fromJson(channelBean.extraData, WalletTopUpChannelResp.ExtraDataMexicoOnline.class), z);
    }

    public static void gotoMexicoOfflinePage(FragmentActivity fragmentActivity, WalletTopUpChannelResp.ChannelBean channelBean) {
        WebBrowserUtil.startInternalWebActivity(fragmentActivity, channelBean.linkUrl, "");
    }

    public static void gotoTopUpOnePay(String str, String str2, FragmentActivity fragmentActivity, int i) {
        if (WalletApolloUtil.getTopUpIsNew()) {
            DRouter.build("GuaranaOneTravel://one/wallet_topup_main?source=" + str).start();
        } else if (str2 == null || str2.isEmpty()) {
            gotoTopupOnlinePay(fragmentActivity, i);
        } else {
            DRouter.build(str2).start();
        }
    }

    public static void gotoTopupOnlinePay(FragmentActivity fragmentActivity, int i) {
        gotoTopupOnlinePay(fragmentActivity, (Bundle) null, i);
    }

    public static void gotoTopupOnlinePay(Context context, Bundle bundle, int i) {
        WalletTopUpAmountActivity.launch(context, bundle, i);
    }

    public static void gotoTopupConditionPage(FragmentActivity fragmentActivity, String str) {
        WebBrowserUtil.startInternalWebActivity(fragmentActivity, str, "");
    }

    public static void gotoUniPayPage(final FragmentActivity fragmentActivity, final WalletCreateOrderRespOldServer.DataBean dataBean) {
        if (NewCashierApolloUtils.useNewCashier()) {
            CashierParam cashierParam = new CashierParam();
            cashierParam.setSign(dataBean.sign);
            cashierParam.setSignType(dataBean.signType);
            cashierParam.setBizContent(dataBean.bizContent);
            CashierFacade.getInstance().launchForResult((Activity) fragmentActivity, 200, cashierParam, (CashierLaunchListener) new CashierLaunchListener() {
                public void onCashierLaunch(boolean z) {
                    if (!z) {
                        WalletRouter.m22662b(FragmentActivity.this, dataBean);
                    }
                }
            });
            return;
        }
        m22662b(fragmentActivity, dataBean);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m22662b(FragmentActivity fragmentActivity, WalletCreateOrderRespOldServer.DataBean dataBean) {
        PayParam payParam = new PayParam();
        payParam.sign = dataBean.sign;
        payParam.signType = dataBean.signType;
        payParam.bizContent = dataBean.bizContent;
        WalletTopUpUniPayActivity.launch(fragmentActivity, payParam, 100);
    }

    public static void gotoUniPayPage(final FragmentActivity fragmentActivity, final WalletCreateOrderResp.DataBean dataBean, final Map<String, Object> map) {
        if (NewCashierApolloUtils.useNewCashier()) {
            CashierParam cashierParam = new CashierParam();
            cashierParam.setOmegaAttrs(map);
            cashierParam.setOutTradeId(dataBean.outTradeId);
            CashierFacade.getInstance().launchForResult((Activity) fragmentActivity, 200, cashierParam, (CashierLaunchListener) new CashierLaunchListener() {
                public void onCashierLaunch(boolean z) {
                    if (!z) {
                        WalletRouter.m22661b(FragmentActivity.this, dataBean, map);
                    }
                }
            });
            return;
        }
        m22661b(fragmentActivity, dataBean, map);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m22661b(FragmentActivity fragmentActivity, WalletCreateOrderResp.DataBean dataBean, Map<String, Object> map) {
        PayParam payParam = new PayParam();
        payParam.outTradeId = dataBean.outTradeId;
        payParam.omegaAttrs = map;
        WalletTopUpUniPayActivity.launch(fragmentActivity, payParam, 100);
    }

    public static void gotoBoletoHistoryPage(FragmentActivity fragmentActivity) {
        WalletBoletoHistoryActivity.launch(fragmentActivity);
    }

    public static void gotoAccountBalancePage(Context context, PayRichInfo payRichInfo, int i, String str, double d, int i2, IWalletService.AccountInfo accountInfo, boolean z, int i3) {
        WalletNewBalanceActivity.launch(context, payRichInfo, i, str, d, i2, accountInfo, i3, z);
    }

    public static void gotoAccountBalancePageWithBlockData(Context context, PayRichInfo payRichInfo, int i, String str, double d, int i2, IWalletService.AccountInfo accountInfo, boolean z, int i3, AccountFreezeData accountFreezeData) {
        WalletNewBalanceActivity.launch(context, payRichInfo, i, str, d, i2, accountInfo, i3, z, accountFreezeData);
    }

    public static void gotoBoletoDetailPage(FragmentActivity fragmentActivity, WalletBoletoResp walletBoletoResp) {
        WalletViewBoletoActivity.launch(fragmentActivity, walletBoletoResp);
    }

    public static void gotoTopUpChannelActivity(Context context, boolean z) {
        gotoTopUpChannelActivity(context, z ? 1 : 0);
    }

    public static void gotoTopUpChannelActivity(Context context, int i) {
        if (WalletApolloUtils.useOldServer()) {
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            WalletTopUpChannelActivityOldServer.launch(context, z);
            return;
        }
        WalletTopUpChannelActivity.launch(context, i);
    }

    public static void gotoTopUpChannelActivity(Context context, int i, int i2) {
        if (WalletApolloUtils.useOldServer()) {
            boolean z = true;
            if (i2 != 1) {
                z = false;
            }
            WalletTopUpChannelActivityOldServer.launch(context, i, z);
            return;
        }
        WalletTopUpChannelActivity.launch(context, i, i2);
    }

    public static void gotoTopUpChannelPage(Context context, int i) {
        WalletTopUpChannelActivity.launch(context, i, 0);
    }

    public static void gotoTopUpChannelPageWithLaunchFrom(Context context, int i) {
        WalletTopUpChannelActivity.launch(context, i);
        if (WalletApolloUtils.useOldServerForMonitorOnly()) {
            WalletApolloUtils.trackOldServerToggleForMonitorOnly(context);
        } else {
            WalletApolloUtils.trackNewServerToggleForMonitorOnly(context);
        }
    }

    public static void gotoTopUpChannelPage(Context context) {
        gotoTopUpChannelPageWithLaunchFrom(context, 0);
    }

    public static void postClipboardChecker(Activity activity, int i) {
        Request build = DRouter.build("99pay://one/boleto_clipboard_check");
        build.putExtra("key_from", i);
        build.putExtra(WalletExtraConstant.Key.REMOVE, false);
        build.start(activity);
    }

    public static void removeClipboardChecker(Activity activity, int i) {
        Request build = DRouter.build("99pay://one/boleto_clipboard_check");
        build.putExtra("key_from", i);
        build.putExtra(WalletExtraConstant.Key.REMOVE, true);
        build.start(activity);
    }

    public static void gotoMainListSettingPage(Activity activity, WalletSettingPageInfo walletSettingPageInfo) {
        WalletMainListSettingActivity.startActivity(activity, walletSettingPageInfo);
    }

    public static void gotoFullKycRegisterPage(Context context, int i) {
        ((Request) DRouter.build(NetworkConstants.URL_BANNER_BOTTOM_KYC).putExtra("full_kyc_address_inbound_source", i)).start(context);
    }

    public static void gotoPixTopUpPage(Activity activity, WalletTopUpChannelResp.ChannelBean channelBean) {
        DRouter.build("99pay://one/pix_top_up").start(activity);
    }

    public static void gotoWebActivity(Context context, String str, String str2, String str3) {
        WalletWebActivity.launch(context, str, str2, str3);
    }
}
