package com.didi.payment.wallet.global.wallet.presenter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.net.CarServerParam;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.dialog.GGKDialogFragment;
import com.didi.global.globalgenerickit.dialog.GGKDialogModel6;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.payment.base.dialog.GGKUICreatorWithThemeCheck;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.PaySharedPreferencesUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.view.PayBaseToast;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.net.PixQrCodeQueryResp;
import com.didi.payment.commonsdk.p129ui.listener.OnQRCodeDetectedListener;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.payment.creditcard.open.DidiGlobalDeleteCardData;
import com.didi.payment.creditcard.open.DidiGlobalVerifyCardData;
import com.didi.payment.paymethod.open.DidiSignFactory;
import com.didi.payment.paymethod.open.callback.Callback;
import com.didi.payment.paymethod.open.callback.SignCallback;
import com.didi.payment.paymethod.open.param.CancelSignParam;
import com.didi.payment.paymethod.open.param.SignParam;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.wallet.global.model.WalletApolloUtils;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.model.resp.WalletPageQueryResp;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.proxy.PayPalProxy;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.utils.WalletSPUtils;
import com.didi.payment.wallet.global.wallet.entity.WalletModelConvert;
import com.didi.payment.wallet.global.wallet.entity.WalletPageInfo;
import com.didi.payment.wallet.global.wallet.view.view.WalletMainListView;
import com.didi.payment.wallet.global.wallet.view.widget.AddPayMethodDialogFragment;
import com.didi.payment.wallet.global.wallet.view.widget.MobileTopUpTipDialogFragment;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.didi.sdk.util.ResourcesHelper;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class WalletMainListPresenter {

    /* renamed from: a */
    WalletPageModel f32025a = new WalletPageModel(this.f32027c);

    /* renamed from: b */
    private FragmentManager f32026b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f32027c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FragmentActivity f32028d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public WalletMainListView f32029e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public WalletPageInfo f32030f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f32031g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public GGKDialogFragment f32032h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public OnQRCodeDetectedListener f32033i;

    public WalletMainListPresenter(FragmentActivity fragmentActivity, WalletMainListView walletMainListView) {
        this.f32027c = fragmentActivity;
        this.f32026b = fragmentActivity.getSupportFragmentManager();
        this.f32028d = fragmentActivity;
        this.f32029e = walletMainListView;
    }

    public void requestWalletPageList() {
        this.f32031g = false;
        this.f32029e.showProgressDialog();
        C111751 r0 = new RpcService.Callback<WalletPageQueryResp>() {
            public void onSuccess(WalletPageQueryResp walletPageQueryResp) {
                WalletMainListPresenter.this.f32029e.dismissProgressDialog();
                if (walletPageQueryResp == null || walletPageQueryResp.data == null) {
                    PayBaseToast.showInfo(WalletMainListPresenter.this.f32027c, (int) R.string.one_payment_global_net_toast_serverbusy);
                } else if (walletPageQueryResp.errno == 0) {
                    if (walletPageQueryResp.data.balanceSection != null) {
                        GlobalOmegaUtils.trackPayMethodSettingPageBalanceSW(WalletMainListPresenter.this.f32027c);
                    }
                    WalletPageInfo convert = WalletModelConvert.convert(walletPageQueryResp);
                    if (walletPageQueryResp.data.accountFreezeData != null && walletPageQueryResp.data.accountFreezeData.isBlocked()) {
                        if (!(walletPageQueryResp.data.consumeSection == null || walletPageQueryResp.data.consumeSection.entryList == null)) {
                            for (WalletHomeResp.ConsumeItem consumeItem : walletPageQueryResp.data.consumeSection.entryList) {
                                consumeItem.isBlocked = true;
                            }
                        }
                        if (!(walletPageQueryResp.data.pixSection == null || walletPageQueryResp.data.pixSection.entryList == null)) {
                            for (WalletHomeResp.PixEntry pixEntry : walletPageQueryResp.data.pixSection.entryList) {
                                pixEntry.isBlocked = true;
                            }
                        }
                        if (convert != null) {
                            convert.accountSection.freezeData = walletPageQueryResp.data.accountFreezeData;
                        }
                    }
                    if (!(convert == null || convert.accountSection == null)) {
                        PayTracker.putGlobal("wallet_account_status", Integer.valueOf(convert.accountSection.status));
                        PayTracker.putGlobal("facial_recognition_status", convert.accountSection.facialRecognitionStatus);
                    }
                    if (convert != null && convert.accountSection != null && !TextUtils.isEmpty(convert.accountSection.detailsText) && convert.accountSection.status == 1) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, Integer.valueOf(convert.accountSection.status));
                        hashMap.put("interest_status", Integer.valueOf(convert.accountSection.interestStatus));
                        PayTracker.trackEvent("ibt_didipay_sidebar_interest_status_sw", hashMap);
                    }
                    WalletPageInfo unused = WalletMainListPresenter.this.f32030f = convert;
                    WalletMainListPresenter.this.f32029e.updateContent(convert);
                    if (!WalletMainListPresenter.this.m22694a(convert)) {
                        WalletMainListPresenter.this.m22704e();
                    }
                } else {
                    PayBaseToast.showInfo(WalletMainListPresenter.this.f32027c, walletPageQueryResp.errmsg);
                }
            }

            public void onFailure(IOException iOException) {
                WalletMainListPresenter.this.f32029e.dismissProgressDialog();
                PayBaseToast.showInfo(WalletMainListPresenter.this.f32027c, (int) R.string.one_payment_global_net_toast_connectionerror);
                WalletMainListPresenter.this.f32029e.updateContent((WalletPageInfo) null);
            }
        };
        if (WalletApolloUtils.useOldServer()) {
            this.f32025a.requestWalletPageListOldServer(r0);
        } else {
            this.f32025a.requestWalletPageList(r0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m22694a(WalletPageInfo walletPageInfo) {
        if (walletPageInfo == null || walletPageInfo.accountSection == null || walletPageInfo.accountSection.status != 1 || !WalletSPUtils.needShowTopUpGuide(this.f32027c) || walletPageInfo.accountSection.channelId != 190) {
            return false;
        }
        WalletRouter.gotoTopUpGuidePage(this.f32027c, walletPageInfo.accountSection.accountStatus);
        WalletSPUtils.topUpGuideHasShowed(this.f32027c);
        return true;
    }

    public void handleBalanceItemClickEvent(WalletPageInfo.BalanceItem balanceItem) {
        if (balanceItem != null && !TextUtils.isEmpty(balanceItem.f32015id)) {
            String str = balanceItem.f32015id;
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -934825418) {
                if (hashCode != 110546608) {
                    if (hashCode == 273184065 && str.equals("discount")) {
                        c = 2;
                    }
                } else if (str.equals("topup")) {
                    c = 0;
                }
            } else if (str.equals(WalletPageInfo.BalanceItem.MOBILEPREPAID)) {
                c = 1;
            }
            if (c == 0) {
                jumpToTopUpPage(balanceItem);
            } else if (c == 1) {
                jumpToMobilePrepaidPage(balanceItem.linkUrl, balanceItem.title);
            } else if (c == 2) {
                jumpToDiscountPage(balanceItem.linkUrl, balanceItem.title);
            }
        }
    }

    public void handlePromotionItemClickEvent(WalletPageInfo.PromotionItem promotionItem) {
        if (promotionItem != null) {
            WebBrowserUtil.startInternalWebActivity(this.f32027c, promotionItem.linkUrl, "");
        }
    }

    public void handlePayMethodItemClickEvent(WalletPageInfo.PayMethodItem payMethodItem) {
        if (payMethodItem != null) {
            int i = payMethodItem.channelId;
            if (i != 150) {
                if (!(i == 175 || i == 178)) {
                    if (i != 182) {
                        if (i != 183) {
                            switch (i) {
                                case 152:
                                    m22697b();
                                    return;
                                case 153:
                                case 154:
                                    break;
                                default:
                                    if (!TextUtils.isEmpty(payMethodItem.linkUrl)) {
                                        WebBrowserUtil.startInternalWebActivity(this.f32027c, payMethodItem.linkUrl, "");
                                        return;
                                    }
                                    return;
                            }
                        } else {
                            m22693a(payMethodItem.profileIdentifier);
                            return;
                        }
                    } else if (payMethodItem.signStatus == 1) {
                        m22698b(payMethodItem.profileIdentifier);
                        return;
                    } else {
                        m22703d();
                        return;
                    }
                }
                WebBrowserUtil.startInternalWebActivity(this.f32027c, payMethodItem.linkUrl, "");
            } else if (payMethodItem.cardStatus == 1) {
                m22690a(this.f32028d, 5, payMethodItem.title, payMethodItem.cardIndex);
            } else {
                m22691a(this.f32028d, 2, payMethodItem.title, payMethodItem.cardExpiryDate, payMethodItem.cardIndex, payMethodItem.expired);
            }
        }
    }

    public void handleNewPayMethodItemClicked(int i) {
        WalletPageQueryResp.PaymentMethodEntryItemBean paymentMethodEntryItemBean;
        int i2 = i;
        WalletPageInfo walletPageInfo = this.f32030f;
        if (walletPageInfo != null && walletPageInfo.newPayMethodSection != null && !CollectionUtil.isEmpty((Collection) this.f32030f.newPayMethodSection.entryList) && i2 <= this.f32030f.newPayMethodSection.entryList.size() - 1 && (paymentMethodEntryItemBean = this.f32030f.newPayMethodSection.entryList.get(i2)) != null) {
            int i3 = paymentMethodEntryItemBean.channelId;
            if (i3 == 150) {
                if (TextUtils.isEmpty(paymentMethodEntryItemBean.cardIndex)) {
                    m22688a(this.f32028d, 1);
                } else if (paymentMethodEntryItemBean.cardStatus == 1) {
                    m22690a(this.f32028d, 5, paymentMethodEntryItemBean.name, paymentMethodEntryItemBean.cardIndex);
                } else {
                    m22691a(this.f32028d, 2, paymentMethodEntryItemBean.name, paymentMethodEntryItemBean.expireDate, paymentMethodEntryItemBean.cardIndex, paymentMethodEntryItemBean.expired);
                }
                if (TextUtils.isEmpty(paymentMethodEntryItemBean.cardIndex)) {
                    GlobalOmegaUtils.trackPayMethodSettingPageCreditCK(this.f32027c, 3, getCardCount());
                } else {
                    GlobalOmegaUtils.trackPayMethodSettingPageCreditCK(this.f32027c, 1, getCardCount());
                }
            } else if (i3 != 190) {
                if (i3 == 999) {
                    GlobalOmegaUtils.trackPayMethodSettingPageDiscountsCK(this.f32027c);
                }
                if (!TextUtils.isEmpty(paymentMethodEntryItemBean.linkUrl)) {
                    WebBrowserUtil.startInternalWebActivity(this.f32027c, paymentMethodEntryItemBean.linkUrl, "");
                }
            } else {
                PayTracker.getTracker().trackEvent("gp_99pay_payment_blank_ck");
                if (this.f32030f.accountSection == null) {
                    return;
                }
                if (paymentMethodEntryItemBean.freezeData == null || !paymentMethodEntryItemBean.freezeData.isBlocked()) {
                    WalletRouter.gotoAccountBalancePage(this.f32027c, this.f32030f.accountSection.richText, this.f32030f.accountSection.channelId, this.f32030f.accountSection.detailsText, this.f32030f.accountSection.balanceAmount, this.f32030f.accountSection.status, this.f32030f.accountSection.accountStatus, this.f32030f.accountSection.hasInterest, 6);
                    return;
                }
                WalletRouter.gotoAccountBalancePageWithBlockData(this.f32027c, this.f32030f.accountSection.richText, this.f32030f.accountSection.channelId, this.f32030f.accountSection.detailsText, this.f32030f.accountSection.balanceAmount, this.f32030f.accountSection.status, this.f32030f.accountSection.accountStatus, this.f32030f.accountSection.hasInterest, 6, paymentMethodEntryItemBean.freezeData);
            }
        }
    }

    public void handleNewPayMethodItemRightLabelClicked(int i) {
        PayTracker.getTracker().trackEvent("gp_99pay_payment_btn_ck");
        WalletRouter.gotoTopUpChannelPage(this.f32027c);
    }

    public void jumpToPayMethodHelpPage(String str) {
        WebBrowserUtil.startInternalWebActivity(this.f32027c, str, "");
    }

    public void jumpToBalanceHelpPage(String str) {
        WebBrowserUtil.startInternalWebActivity(this.f32027c, str, "");
    }

    public void jumpToBalanceBannerPage(String str) {
        this.f32031g = true;
        WebBrowserUtil.startInternalWebActivity(this.f32027c, str, "");
    }

    public void jumpToBalanceDetailPage(String str) {
        WebBrowserUtil.startInternalWebActivity(this.f32027c, str, "");
    }

    public void jumpToServiceCenter() {
        WalletPageInfo walletPageInfo = this.f32030f;
        if (walletPageInfo != null && walletPageInfo.serviceCenterUrl != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("page", "wallet");
            hashMap.put("source_page", "sidebar");
            hashMap.put(CarServerParam.PARAM_BUTTON, "top_help");
            FinOmegaSDK.trackEvent("ibt_wallet_ck", hashMap);
            WebBrowserUtil.startInternalWebActivity(this.f32027c, this.f32030f.serviceCenterUrl, "");
        }
    }

    public void jumpToSettingPage() {
        if (this.f32030f != null) {
            PayTracker.getTracker().trackEvent("ibt_didipay_sidebar_payment_setting_ck");
            WalletRouter.gotoMainListSettingPage(this.f32028d, WalletModelConvert.convertByWalletPageInfo(this.f32030f));
        }
    }

    public void jumpToTransactionPage() {
        WalletPageInfo walletPageInfo = this.f32030f;
        if (walletPageInfo != null && walletPageInfo.extendEntrySection != null && this.f32030f.extendEntrySection.transaction != null) {
            String str = this.f32030f.extendEntrySection.transaction.linkUrl;
            if (!TextUtils.isEmpty(str)) {
                WebBrowserUtil.startInternalWebActivity(this.f32027c, str, "");
            }
        }
    }

    public void jumpToMobilePrepaidPage(final String str, final String str2) {
        if (MobileTopUpTipDialogFragment.canShow(this.f32027c)) {
            MobileTopUpTipDialogFragment mobileTopUpTipDialogFragment = new MobileTopUpTipDialogFragment();
            mobileTopUpTipDialogFragment.setConfirmClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GlobalOmegaUtils.trackPayMethodSettingPageRechargeBtnCk(WalletMainListPresenter.this.f32027c);
                    boolean unused = WalletMainListPresenter.this.f32031g = true;
                    WebBrowserUtil.startInternalWebActivity(WalletMainListPresenter.this.f32027c, str, str2);
                }
            });
            mobileTopUpTipDialogFragment.setCancelClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GlobalOmegaUtils.trackPayMethodSettingPageRechargeCancelBtnCk(WalletMainListPresenter.this.f32027c);
                }
            });
            mobileTopUpTipDialogFragment.setContext(this.f32027c);
            mobileTopUpTipDialogFragment.show(this.f32026b, "");
            GlobalOmegaUtils.trackPayMethodSettingPageRechargePopupSW(this.f32027c);
            return;
        }
        this.f32031g = true;
        WebBrowserUtil.startInternalWebActivity(this.f32027c, str, str2);
    }

    public void jumpToTopUpPage(WalletPageInfo.BalanceItem balanceItem) {
        this.f32031g = true;
        WalletRouter.gotoTopUpChannelActivity(this.f32027c, false);
    }

    public void jumpToDiscountPage(String str, String str2) {
        WebBrowserUtil.startInternalWebActivity(this.f32027c, str, str2);
    }

    public void showAddPayMethodDialog(WalletPageInfo.AddPayMethodEntryDialogInfo addPayMethodEntryDialogInfo) {
        AddPayMethodDialogFragment addPayMethodDialogFragment = new AddPayMethodDialogFragment();
        addPayMethodDialogFragment.setData(addPayMethodEntryDialogInfo);
        addPayMethodDialogFragment.setAddPayMethodListener(new AddPayMethodDialogFragment.AddPayMethodDialogListener() {
            public void onItemClick(WalletPageInfo.AddPayMethodEntryDialogItem addPayMethodEntryDialogItem) {
                if (addPayMethodEntryDialogItem != null) {
                    int i = addPayMethodEntryDialogItem.channelId;
                    if (i == 150) {
                        GlobalOmegaUtils.trackPayMethodSettingPageCreditCK(WalletMainListPresenter.this.f32027c, 3, WalletMainListPresenter.this.getCardCount());
                        WalletMainListPresenter walletMainListPresenter = WalletMainListPresenter.this;
                        walletMainListPresenter.m22688a(walletMainListPresenter.f32028d, 1);
                    } else if (i == 152) {
                        GlobalOmegaUtils.trackPayMethodSettingPagePaypalCK(WalletMainListPresenter.this.f32027c, 3, WalletMainListPresenter.this.getCardCount());
                        WalletMainListPresenter.this.m22687a();
                    } else if (i == 182) {
                        GlobalOmegaUtils.trackPayMethodSettingPagePayPayCK(WalletMainListPresenter.this.f32027c, 3, WalletMainListPresenter.this.getCardCount());
                        WalletMainListPresenter.this.m22703d();
                    } else if (i == 183) {
                        GlobalOmegaUtils.trackPayMethodSettingPagePaypal2CK(WalletMainListPresenter.this.f32027c, 3, WalletMainListPresenter.this.getCardCount());
                        WalletMainListPresenter.this.m22700c();
                    }
                }
            }

            public void onShow() {
                GlobalOmegaUtils.trackPayMethodSettingPagebalancePopupSW(WalletMainListPresenter.this.f32027c);
            }

            public void onClose() {
                GlobalOmegaUtils.trackPayMethodSettingPagebalancePopupCloseCK(WalletMainListPresenter.this.f32027c);
            }
        });
        addPayMethodDialogFragment.show(this.f32026b, "addpaymethod");
    }

    public int getCardCount() {
        WalletPageInfo walletPageInfo = this.f32030f;
        int i = 0;
        if (!(walletPageInfo == null || walletPageInfo.payMethodSection == null || this.f32030f.payMethodSection.payMethodItems == null)) {
            for (WalletPageInfo.PayMethodItem payMethodItem : this.f32030f.payMethodSection.payMethodItems) {
                if (payMethodItem.channelId == 150) {
                    i++;
                }
            }
        }
        return i;
    }

    public boolean getBackRefreshFlag() {
        return this.f32031g;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22687a() {
        if (PayPalProxy.getProxy() != null) {
            PayPalProxy.getProxy().startPayPalActivity(this.f32028d, 3);
        }
    }

    /* renamed from: b */
    private void m22697b() {
        if (PayPalProxy.getProxy() != null) {
            PayPalProxy.getProxy().startPayPalDetailActivity(this.f32028d, 4);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m22700c() {
        SignParam signParam = new SignParam();
        signParam.channelId = 183;
        signParam.bindType = 1;
        DidiSignFactory.createSignApi().sign((Activity) this.f32028d, signParam, (SignCallback) new SignCallback() {
            public void onPullStart() {
            }

            public void onResult(int i, String str, String str2) {
                if (i == 0) {
                    WalletMainListPresenter.this.requestWalletPageList();
                }
            }
        });
    }

    /* renamed from: a */
    private void m22693a(String str) {
        CancelSignParam cancelSignParam = new CancelSignParam();
        cancelSignParam.channelId = 183;
        cancelSignParam.email = str;
        DidiSignFactory.createSignApi().cancelSign(this.f32028d, cancelSignParam, new Callback() {
            public void onResult(int i, String str, String str2) {
                if (i == 0) {
                    WalletMainListPresenter.this.requestWalletPageList();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m22703d() {
        SignParam signParam = new SignParam();
        signParam.channelId = 182;
        signParam.bindType = 1;
        DidiSignFactory.createSignApi().sign((Activity) this.f32028d, signParam, (SignCallback) new SignCallback() {
            public void onPullStart() {
            }

            public void onResult(int i, String str, String str2) {
                if (i == 0) {
                    WalletMainListPresenter.this.requestWalletPageList();
                }
            }
        });
    }

    /* renamed from: b */
    private void m22698b(String str) {
        CancelSignParam cancelSignParam = new CancelSignParam();
        cancelSignParam.channelId = 182;
        cancelSignParam.email = str;
        DidiSignFactory.createSignApi().cancelSign(this.f32028d, cancelSignParam, new Callback() {
            public void onResult(int i, String str, String str2) {
                if (i == 0) {
                    WalletMainListPresenter.this.requestWalletPageList();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22688a(FragmentActivity fragmentActivity, int i) {
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        addCardParam.bindType = 1;
        addCardParam.resourceId = "1";
        LoadingProxyHolder.setProxy(new LoadingProxyHolder.ILoadingProxy() {
            public void showLoading() {
                if (WalletMainListPresenter.this.f32029e != null) {
                    WalletMainListPresenter.this.f32029e.showProgressDialog();
                }
            }

            public void dismissLoading() {
                if (WalletMainListPresenter.this.f32029e != null) {
                    WalletMainListPresenter.this.f32029e.dismissProgressDialog();
                }
            }
        });
        DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity((Activity) fragmentActivity, i, addCardParam);
    }

    /* renamed from: a */
    private void m22691a(FragmentActivity fragmentActivity, int i, String str, String str2, String str3, int i2) {
        DidiGlobalDeleteCardData.DeleteCardParam deleteCardParam = new DidiGlobalDeleteCardData.DeleteCardParam();
        deleteCardParam.expiryDate = str2;
        deleteCardParam.cardNo = str;
        deleteCardParam.cardIndex = str3;
        deleteCardParam.expired = i2;
        deleteCardParam.resourceId = "1";
        DidiCreditCardFactory.createGlobalCreditCardApi().startCreditCardDetailActivity(fragmentActivity, i, deleteCardParam);
    }

    /* renamed from: a */
    private void m22690a(FragmentActivity fragmentActivity, int i, String str, String str2) {
        DidiGlobalVerifyCardData.VerifyCardParam verifyCardParam = new DidiGlobalVerifyCardData.VerifyCardParam();
        verifyCardParam.cardNo = str;
        verifyCardParam.cardIndex = str2;
        DidiCreditCardFactory.createGlobalCreditCardApi().startVerifyBalanceActivity(fragmentActivity, i, verifyCardParam);
    }

    /* renamed from: a */
    private void m22689a(FragmentActivity fragmentActivity, int i, String str) {
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        addCardParam.bindType = 1;
        addCardParam.cardNo = str;
        DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity((Activity) fragmentActivity, i, addCardParam);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m22704e() {
        if (WalletApolloUtil.isNewPayMethodListEnable() && !PaySharedPreferencesUtil.isWalletNewFeatureDialogShown(this.f32027c)) {
            PaySharedPreferencesUtil.setWalletNewFeatureDialogShown(this.f32027c, true);
            String string = ResourcesHelper.getString(this.f32027c, R.string.GRider_Cognition_99Pay_brand_WCsi);
            ArrayList arrayList = new ArrayList();
            arrayList.add(ResourcesHelper.getString(this.f32027c, R.string.GRider_Cognition_99_All_hYxN));
            arrayList.add(ResourcesHelper.getString(this.f32027c, R.string.GRider_Cognition_Payment_of_apzc));
            arrayList.add(ResourcesHelper.getString(this.f32027c, R.string.GRider_Cognition_A_variety_YbZX));
            GGKDialogModel6 gGKDialogModel6 = new GGKDialogModel6(string, arrayList, new GGKBtnTextAndCallback(ResourcesHelper.getString(this.f32027c, R.string.GRider_Cognition_I_see_WDeU), new GGKOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (WalletMainListPresenter.this.f32032h != null) {
                        WalletMainListPresenter.this.f32032h.dismiss();
                        GGKDialogFragment unused = WalletMainListPresenter.this.f32032h = null;
                    }
                }
            }));
            gGKDialogModel6.setImageResId(R.drawable.wallet_new_feature_dialog_top_img);
            this.f32032h = GGKUICreatorWithThemeCheck.showDialogModel(this.f32028d, gGKDialogModel6, "wallet_new_feature_dialog");
            PayTracker.getTracker().trackEvent("ibt_didipay_sidebar_payment_upgrade_sw");
        }
    }

    public void autoVerifyQRCode(String str) {
        this.f32025a.queryPixQrCode(str, new RpcService.Callback<PixQrCodeQueryResp>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(PixQrCodeQueryResp pixQrCodeQueryResp) {
                if (pixQrCodeQueryResp != null && pixQrCodeQueryResp.errno == 0 && WalletMainListPresenter.this.f32033i != null) {
                    WalletMainListPresenter.this.f32033i.onQRCodeDetected(pixQrCodeQueryResp.data);
                }
            }
        });
    }

    public void setQrCodeDetectedListener(OnQRCodeDetectedListener onQRCodeDetectedListener) {
        this.f32033i = onQRCodeDetectedListener;
    }

    public WalletPageInfo getPageInfo() {
        return this.f32030f;
    }
}
