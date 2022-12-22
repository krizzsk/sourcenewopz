package com.didi.payment.creditcard.global.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.payment.creditcard.global.model.CancelCardParam;
import com.didi.payment.creditcard.global.model.CreditCardModel;
import com.didi.payment.creditcard.global.model.SignCardParam;
import com.didi.payment.creditcard.global.model.bean.BindCardInfo;
import com.didi.payment.creditcard.global.p130v2.activity.GlobalCreditCardAddOptV2Activity;
import com.didi.payment.creditcard.global.p130v2.utils.BindCardApolloUtils;
import com.didi.payment.creditcard.global.p130v2.utils.CreditCardOmegaUtil;
import com.didi.payment.creditcard.global.presenter.GlobalVerificationPrePresenter;
import com.didi.payment.creditcard.open.DidiGlobalVerifyCardData;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;

public class GlobalCreditCardActivityRouter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static boolean f30298a;

    public interface PrepareAddCardCallback {
        void onIntentPrepared(Intent intent);
    }

    public static void launchAddCardActivity(final Activity activity, final int i, final SignCardParam signCardParam, boolean z) {
        if (activity != null && signCardParam != null && !f30298a) {
            f30298a = true;
            if (z) {
                m21270b();
            }
            CreditCardModel creditCardModel = new CreditCardModel(activity);
            final String str = TextUtils.isEmpty(signCardParam.discountContent) ? signCardParam.resourceId : "";
            creditCardModel.requestBindCardSignInfo(str, new RpcService.Callback<BindCardInfo>() {
                public void onSuccess(BindCardInfo bindCardInfo) {
                    boolean unused = GlobalCreditCardActivityRouter.f30298a = false;
                    GlobalCreditCardActivityRouter.m21272c();
                    if (bindCardInfo != null) {
                        GlobalCreditCardActivityRouter.m21271b(bindCardInfo, SignCardParam.this);
                        GlobalBaseActivity.traceVendor(str, bindCardInfo.vendor_type, "net");
                    } else {
                        GlobalBaseActivity.traceVendor(str, "", "net");
                    }
                    CreditCardOmegaUtil.Companion.setResourceId(SignCardParam.this.resourceId);
                    if (BindCardApolloUtils.useNewVersion()) {
                        GlobalCreditCardAddOptV2Activity.launch(activity, i, SignCardParam.this);
                    } else {
                        GlobalCreditCardAddOptActivity.launch(activity, i, SignCardParam.this);
                    }
                }

                public void onFailure(IOException iOException) {
                    boolean unused = GlobalCreditCardActivityRouter.f30298a = false;
                    GlobalCreditCardActivityRouter.m21272c();
                    GlobalBaseActivity.traceVendor(str, "", "net");
                    CreditCardOmegaUtil.Companion.setResourceId(SignCardParam.this.resourceId);
                    if (BindCardApolloUtils.useNewVersion()) {
                        GlobalCreditCardAddOptV2Activity.launch(activity, i, SignCardParam.this);
                    } else {
                        GlobalCreditCardAddOptActivity.launch(activity, i, SignCardParam.this);
                    }
                }
            });
        }
    }

    public static void launchAddCardActivity(final Fragment fragment, final int i, final SignCardParam signCardParam, boolean z) {
        if (fragment != null && signCardParam != null && !f30298a) {
            f30298a = true;
            FragmentActivity activity = fragment.getActivity();
            if (z) {
                m21270b();
            }
            CreditCardModel creditCardModel = new CreditCardModel(activity);
            final String str = TextUtils.isEmpty(signCardParam.discountContent) ? signCardParam.resourceId : "";
            creditCardModel.requestBindCardSignInfo(str, new RpcService.Callback<BindCardInfo>() {
                public void onSuccess(BindCardInfo bindCardInfo) {
                    boolean unused = GlobalCreditCardActivityRouter.f30298a = false;
                    GlobalCreditCardActivityRouter.m21272c();
                    if (bindCardInfo != null) {
                        GlobalCreditCardActivityRouter.m21271b(bindCardInfo, SignCardParam.this);
                        GlobalBaseActivity.traceVendor(str, bindCardInfo.vendor_type, "net");
                    } else {
                        GlobalBaseActivity.traceVendor(str, "", "net");
                    }
                    CreditCardOmegaUtil.Companion.setResourceId(SignCardParam.this.resourceId);
                    if (BindCardApolloUtils.useNewVersion()) {
                        GlobalCreditCardAddOptV2Activity.launch(fragment, i, SignCardParam.this);
                    } else {
                        GlobalCreditCardAddOptActivity.launch(fragment, i, SignCardParam.this);
                    }
                }

                public void onFailure(IOException iOException) {
                    boolean unused = GlobalCreditCardActivityRouter.f30298a = false;
                    GlobalCreditCardActivityRouter.m21272c();
                    GlobalBaseActivity.traceVendor(str, "", "net");
                    CreditCardOmegaUtil.Companion.setResourceId(SignCardParam.this.resourceId);
                    if (BindCardApolloUtils.useNewVersion()) {
                        GlobalCreditCardAddOptV2Activity.launch(fragment, i, SignCardParam.this);
                    } else {
                        GlobalCreditCardAddOptActivity.launch(fragment, i, SignCardParam.this);
                    }
                }
            });
        }
    }

    public static void launchCreditCardDetailActivity(FragmentActivity fragmentActivity, int i, CancelCardParam cancelCardParam) {
        GlobalCreditCardDetailActivity.launch(fragmentActivity, i, cancelCardParam);
    }

    public static void launchCreditCardVerificationActivity(FragmentActivity fragmentActivity, int i, DidiGlobalVerifyCardData.VerifyCardParam verifyCardParam) {
        new GlobalVerificationPrePresenter().startVerification(fragmentActivity, i, verifyCardParam);
    }

    public static void launchCreditCardVerificationActivity(Fragment fragment, int i, DidiGlobalVerifyCardData.VerifyCardParam verifyCardParam) {
        new GlobalVerificationPrePresenter().startVerification(fragment, i, verifyCardParam);
    }

    /* renamed from: b */
    private static void m21270b() {
        if (LoadingProxyHolder.getProxy() != null) {
            LoadingProxyHolder.getProxy().showLoading();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m21272c() {
        if (LoadingProxyHolder.getProxy() != null) {
            LoadingProxyHolder.getProxy().dismissLoading();
        }
    }

    public static void prepareAddCardActivityIntent(final Activity activity, final SignCardParam signCardParam, boolean z, final PrepareAddCardCallback prepareAddCardCallback) {
        if (activity != null && signCardParam != null && prepareAddCardCallback != null && !f30298a) {
            f30298a = true;
            if (z) {
                m21270b();
            }
            new CreditCardModel(activity).requestBindCardSignInfo("", new RpcService.Callback<BindCardInfo>() {
                public void onSuccess(BindCardInfo bindCardInfo) {
                    Intent intent;
                    boolean unused = GlobalCreditCardActivityRouter.f30298a = false;
                    GlobalCreditCardActivityRouter.m21272c();
                    if (bindCardInfo != null) {
                        GlobalCreditCardActivityRouter.m21271b(bindCardInfo, SignCardParam.this);
                        GlobalBaseActivity.traceVendor("", bindCardInfo.vendor_type, "net");
                    } else {
                        GlobalBaseActivity.traceVendor("", "", "net");
                    }
                    CreditCardOmegaUtil.Companion.setResourceId(SignCardParam.this.resourceId);
                    if (BindCardApolloUtils.useNewVersion()) {
                        intent = GlobalCreditCardAddOptV2Activity.getIntent(activity, SignCardParam.this);
                    } else {
                        intent = GlobalCreditCardAddOptActivity.getIntent(activity, SignCardParam.this);
                    }
                    prepareAddCardCallback.onIntentPrepared(intent);
                }

                public void onFailure(IOException iOException) {
                    Intent intent;
                    boolean unused = GlobalCreditCardActivityRouter.f30298a = false;
                    GlobalCreditCardActivityRouter.m21272c();
                    GlobalBaseActivity.traceVendor("", "", "net");
                    CreditCardOmegaUtil.Companion.setResourceId(SignCardParam.this.resourceId);
                    if (BindCardApolloUtils.useNewVersion()) {
                        intent = GlobalCreditCardAddOptV2Activity.getIntent(activity, SignCardParam.this);
                    } else {
                        intent = GlobalCreditCardAddOptActivity.getIntent(activity, SignCardParam.this);
                    }
                    prepareAddCardCallback.onIntentPrepared(intent);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m21271b(BindCardInfo bindCardInfo, SignCardParam signCardParam) {
        signCardParam.apolloName = bindCardInfo.validator_name;
        signCardParam.blackCardApolloName = bindCardInfo.black_card_name;
        signCardParam.noticeMsg = bindCardInfo.notice_msg;
        boolean z = false;
        signCardParam.isSupportOcr = bindCardInfo.ocr_flag == 1;
        if (bindCardInfo.ocr_verify_flag == 1) {
            z = true;
        }
        signCardParam.isSupportOcrVerify = z;
        signCardParam.vendorType = bindCardInfo.vendor_type;
        signCardParam.didi_icon = bindCardInfo.didi_icon;
        CreditCardOmegaUtil.Companion.setMarketingId(bindCardInfo.activity_id);
        CreditCardOmegaUtil.Companion.setResourceId(signCardParam.resourceId);
        if (TextUtils.isEmpty(signCardParam.discountContent)) {
            signCardParam.discountContent = bindCardInfo.marketing_discount_tips;
        }
        if (TextUtils.isEmpty(signCardParam.successTips)) {
            signCardParam.successTips = bindCardInfo.success_tips;
        }
        if (TextUtils.isEmpty(signCardParam.successUrl)) {
            signCardParam.successUrl = bindCardInfo.success_url;
        }
        if (TextUtils.isEmpty(signCardParam.retainTips)) {
            signCardParam.retainTips = bindCardInfo.retain_tips;
        }
    }
}
