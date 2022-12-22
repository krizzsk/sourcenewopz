package com.didi.payment.wallet.global.wallet.presenter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.api.Extend;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.RouterCallback;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.ServiceLoaderUtil;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.wallet.global.model.WalletSettingModel;
import com.didi.payment.wallet.global.model.resp.QueryNightlyLimitSettingResp;
import com.didi.payment.wallet.global.model.resp.WalletPageQueryResp;
import com.didi.payment.wallet.global.model.resp.WalletSettingsResp;
import com.didi.payment.wallet.global.proxy.PayPalProxy;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.contract.WalletMainListSettingContract;
import com.didi.payment.wallet.global.wallet.entity.WalletSettingPageInfo;
import com.didi.payment.wallet.global.wallet.view.activity.WalletChangeLimitResultActivity;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.AccountSection;
import com.didi.payment.wallet.password.PasswordScene;
import com.didi.sdk.util.ResourcesHelper;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.pay.paysecure.OpenCertificationListener;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.SetPwdResultListener;
import com.didiglobal.pay.paysecure.omega.OmegaUtilKt;
import com.taxis99.R;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WalletMainListSettingPresenter implements WalletMainListSettingContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WalletMainListSettingContract.View f32034a;

    /* renamed from: b */
    private FragmentActivity f32035b;

    /* renamed from: c */
    private WalletPageQueryResp.PaymentMethodEntryItemBean f32036c;

    /* renamed from: d */
    private WalletPageQueryResp.AccountSectionItem f32037d;

    /* renamed from: e */
    private boolean f32038e = false;

    /* renamed from: f */
    private boolean f32039f = false;

    /* renamed from: g */
    private WalletSettingPageInfo f32040g = null;

    /* renamed from: h */
    private WalletSettingModel f32041h;

    public void onDestroy() {
    }

    public WalletMainListSettingPresenter(FragmentActivity fragmentActivity, WalletMainListSettingContract.View view) {
        this.f32035b = fragmentActivity;
        this.f32034a = view;
        this.f32041h = new WalletSettingModel(fragmentActivity);
    }

    /* renamed from: a */
    private void m22716a(WalletSettingPageInfo walletSettingPageInfo) {
        if (walletSettingPageInfo != null) {
            this.f32034a.showLoadingDialog();
            this.f32037d = walletSettingPageInfo.accountSection;
            this.f32036c = walletSettingPageInfo.paypalItem;
            final WalletMainListSettingContract.SettingItemModel b = m22717b();
            this.f32041h.getSettingItems(new RpcService.Callback<WalletSettingsResp>() {
                public void onSuccess(WalletSettingsResp walletSettingsResp) {
                    if (walletSettingsResp.errno != 0 || walletSettingsResp.data == null) {
                        WalletMainListSettingPresenter.this.f32034a.updateContent(WalletMainListSettingPresenter.this.m22715a(b));
                    } else {
                        ArrayList arrayList = new ArrayList();
                        if (walletSettingsResp.data.settings != null) {
                            for (WalletSettingsResp.WalletSettingItem a : walletSettingsResp.data.settings) {
                                arrayList.add(WalletMainListSettingPresenter.this.m22711a(a));
                            }
                        }
                        WalletMainListSettingContract.SettingItemModel settingItemModel = b;
                        if (settingItemModel != null) {
                            arrayList.add(settingItemModel);
                        }
                        WalletMainListSettingPresenter.this.f32034a.updateContent(arrayList);
                    }
                    WalletMainListSettingPresenter.this.f32034a.dismissLoadingDialog();
                }

                public void onFailure(IOException iOException) {
                    WalletMainListSettingPresenter.this.f32034a.updateContent(WalletMainListSettingPresenter.this.m22715a(b));
                    WalletMainListSettingPresenter.this.f32034a.dismissLoadingDialog();
                }
            });
        }
    }

    public void init() {
        Intent intent = this.f32035b.getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WalletExtraConstant.Key.WALLET_SIDEBAR_PAGE_MODEL);
            if (serializableExtra instanceof WalletSettingPageInfo) {
                this.f32040g = (WalletSettingPageInfo) serializableExtra;
            }
            WalletSettingPageInfo walletSettingPageInfo = this.f32040g;
            if (walletSettingPageInfo != null) {
                m22716a(walletSettingPageInfo);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<WalletMainListSettingContract.SettingItemModel> m22715a(WalletMainListSettingContract.SettingItemModel... settingItemModelArr) {
        ArrayList arrayList = new ArrayList();
        for (WalletMainListSettingContract.SettingItemModel settingItemModel : settingItemModelArr) {
            if (settingItemModel != null) {
                arrayList.add(settingItemModel);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private WalletMainListSettingContract.SettingItemModel m22710a() {
        if (this.f32037d == null) {
            return null;
        }
        WalletMainListSettingContract.SettingItemModel settingItemModel = new WalletMainListSettingContract.SettingItemModel();
        settingItemModel.f32011id = 2;
        settingItemModel.imgId = R.drawable.wallet_setting_item_verify_icon;
        if (!this.f32037d.supportFullKyc || this.f32037d.status != 1) {
            settingItemModel.name = ResourcesHelper.getString(this.f32035b, R.string.GRider_Cognition_Accreditation_XGRK);
        } else {
            settingItemModel.name = ResourcesHelper.getString(this.f32035b, R.string.GRider_Optimization_Real_name_oUJx);
        }
        boolean z = false;
        if (this.f32037d.supportFullKyc) {
            if (this.f32037d.fullKycStatus != 1) {
                z = true;
            }
            settingItemModel.showArrow = z;
        } else {
            if (this.f32037d.status != 1) {
                z = true;
            }
            settingItemModel.showArrow = z;
        }
        if (this.f32037d.supportFullKyc && this.f32037d.status == 1) {
            settingItemModel.rightLabel1 = "";
            if (this.f32037d.fullKycStatus == 0) {
                settingItemModel.name = ResourcesHelper.getString(this.f32035b, R.string.GRider_Optimization_To_be_lzNa);
            } else if (this.f32037d.fullKycStatus == 1) {
                settingItemModel.name = ResourcesHelper.getString(this.f32035b, R.string.GRider_Optimization_Accreditation_completed_NNzQ);
            } else if (this.f32037d.fullKycStatus == 2) {
                settingItemModel.name = ResourcesHelper.getString(this.f32035b, R.string.GRider_Optimization_Verification_of_pSAn);
            } else if (this.f32037d.fullKycStatus == 3) {
                settingItemModel.name = ResourcesHelper.getString(this.f32035b, R.string.GRider_Optimization_Unable_to_zuXG);
            }
        } else if (this.f32037d.status == 1) {
            settingItemModel.rightLabel1 = ResourcesHelper.getString(this.f32035b, R.string.GRider_Cognition_Actual_NXgv);
        } else if (this.f32037d.status == 2) {
            settingItemModel.name = ResourcesHelper.getString(this.f32035b, R.string.GRider_Optimization_Audit_hBQw);
            settingItemModel.rightLabel1 = "";
        } else if (this.f32037d.status == 0) {
            settingItemModel.rightLabel1 = ResourcesHelper.getString(this.f32035b, R.string.GRider_Optimization_Register_here_jSPa);
        } else {
            settingItemModel.rightLabel1 = ResourcesHelper.getString(this.f32035b, R.string.GRider_Cognition_Not_real_HOdu);
        }
        return settingItemModel;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public WalletMainListSettingContract.SettingItemModel m22711a(WalletSettingsResp.WalletSettingItem walletSettingItem) {
        WalletMainListSettingContract.SettingItemModel settingItemModel = new WalletMainListSettingContract.SettingItemModel();
        boolean z = true;
        if (walletSettingItem.type == 1) {
            HashMap hashMap = new HashMap();
            hashMap.put(OmegaUtilKt.ENTRANCE_PAGE_ID, "setting_page_id");
            PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_page_sw", hashMap);
            settingItemModel.f32011id = 4;
            if (!(walletSettingItem.extra == null || walletSettingItem.extra.toBeValidText == null)) {
                settingItemModel.rightLabel2 = walletSettingItem.extra.toBeValidText;
                settingItemModel.rightLabel2Color = Color.parseColor("#FF8040");
            }
            if (walletSettingItem.extra == null || TextUtils.isEmpty(walletSettingItem.extra.toBeValidText)) {
                z = false;
            }
            this.f32038e = z;
        } else if (walletSettingItem.type == 2) {
            settingItemModel.f32011id = 5;
            if (walletSettingItem.extra == null || walletSettingItem.extra.setStatus != 1) {
                FinOmegaSDK.trackEvent("ibt_password_setting_item_sw");
            } else {
                this.f32039f = true;
                FinOmegaSDK.trackEvent("ibt_password_setting_reset_sw");
            }
        } else if (walletSettingItem.type == 4 || walletSettingItem.type == 41) {
            settingItemModel.f32011id = 2;
        } else if (walletSettingItem.type == 5) {
            settingItemModel.f32011id = 6;
            FinOmegaSDK.trackEvent("fin_payment_fastpaysetting_entrance_sw");
        }
        settingItemModel.imgId = R.drawable.wallet_setting_item_help;
        settingItemModel.name = walletSettingItem.title;
        settingItemModel.subName = walletSettingItem.note;
        settingItemModel.rightLabel1 = walletSettingItem.subtitle;
        settingItemModel.linkUrl = walletSettingItem.linkUrl;
        settingItemModel.hasRedPoint = walletSettingItem.hasRedPoint;
        settingItemModel.type = walletSettingItem.type;
        if (walletSettingItem.subSetting != null) {
            ArrayList<WalletMainListSettingContract.SettingItemModel> arrayList = new ArrayList<>();
            for (WalletSettingsResp.WalletSettingItem a : walletSettingItem.subSetting) {
                arrayList.add(m22711a(a));
            }
            settingItemModel.subSetting = arrayList;
        }
        return settingItemModel;
    }

    /* renamed from: b */
    private WalletMainListSettingContract.SettingItemModel m22717b() {
        WalletPageQueryResp.PaymentMethodEntryItemBean paymentMethodEntryItemBean = this.f32036c;
        if (paymentMethodEntryItemBean == null || paymentMethodEntryItemBean.signStatus != 1) {
            return null;
        }
        WalletMainListSettingContract.SettingItemModel settingItemModel = new WalletMainListSettingContract.SettingItemModel();
        settingItemModel.f32011id = 3;
        settingItemModel.imgId = R.drawable.wallet_setting_item_paypal_icon;
        settingItemModel.name = this.f32036c.name;
        return settingItemModel;
    }

    public void requestData() {
        m22716a(this.f32040g);
    }

    public void onSettingItemClicked(int i, String str, ArrayList<WalletMainListSettingContract.SettingItemModel> arrayList) {
        if (i != 2) {
            if (i == 3) {
                PayTracker.getTracker().trackEvent("ibt_didipay_sidebar_payment_setting_paypal_ck");
                m22720e();
            } else if (i != 4) {
                if (i == 5) {
                    OpenCertificationListener openCertificationListener = (OpenCertificationListener) ServiceLoaderUtil.getInstance().load(OpenCertificationListener.class);
                    if (this.f32039f) {
                        FinOmegaSDK.trackEvent("ibt_password_setting_reset_ck");
                        if (openCertificationListener != null) {
                            PaySecure.INSTANCE.resetPayPassword(PasswordScene.CHANGE.name(), openCertificationListener, new SetPwdResultListener() {
                                public void onFailure(String str, String str2) {
                                }

                                public void onSuccess(String str) {
                                    WalletMainListSettingPresenter.this.init();
                                }
                            });
                            return;
                        }
                        return;
                    }
                    FinOmegaSDK.trackEvent("ibt_password_setting_item_payment_password_ck");
                    if (openCertificationListener != null) {
                        PaySecure.INSTANCE.createPayPassword(PasswordScene.SETTING.name(), openCertificationListener, new SetPwdResultListener() {
                            public void onFailure(String str, String str2) {
                            }

                            public void onSuccess(String str) {
                                WalletMainListSettingPresenter.this.init();
                            }
                        });
                        return;
                    }
                    return;
                } else if (i != 6) {
                    DRouter.build(str).start(this.f32035b);
                    return;
                } else {
                    FinOmegaSDK.trackEvent("fin_payment_fastpaysetting_entrance_ck");
                    ((Request) DRouter.build(str).putExtra(Extend.START_ACTIVITY_REQUEST_CODE, 10001)).start(this.f32035b);
                    return;
                }
            }
            PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_night_transfer_limit_ck");
            m22718c();
            return;
        }
        PayTracker.getTracker().trackEvent("ibt_didipay_sidebar_payment_setting_verify_ck");
        AccountSection accountSection = new AccountSection();
        accountSection.setAccountStatus(this.f32037d.accountStatus);
        accountSection.setKycStatus(Integer.toString(this.f32037d.status));
        accountSection.setSupportFullKyc(Boolean.valueOf(this.f32037d.supportFullKyc));
        accountSection.setFullKycStatus(Integer.toString(this.f32037d.fullKycStatus));
        if (!TextUtils.isEmpty(str)) {
            ((Request) ((Request) DRouter.build(str).putExtra("accountSection", (Serializable) accountSection)).putParcelableArrayList("subSettingsData", arrayList)).start(this.f32035b);
        }
    }

    /* renamed from: c */
    private void m22718c() {
        WalletPageQueryResp.AccountSectionItem accountSectionItem = this.f32037d;
        if (accountSectionItem != null && accountSectionItem.freezeData != null && this.f32037d.freezeData.isBlocked()) {
            AccountFreezeData.Dialog dialog = this.f32037d.freezeData.dialogData;
            if (dialog != null && !TextUtils.isEmpty(dialog.landingUrl)) {
                DRouter.build(dialog.landingUrl).start(this.f32035b);
            }
        } else if (!this.f32038e) {
            ((Request) DRouter.build("99pay://one/nightly_limit_setting").putExtra("pageFrom", "setting_page_id")).start(this.f32035b, new RouterCallback.ActivityCallback() {
                public void onActivityResult(int i, Intent intent) {
                    if (i == -1) {
                        WalletMainListSettingPresenter.this.init();
                    }
                }
            });
        } else {
            WalletChangeLimitResultActivity.start(this.f32035b, (QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo) null);
        }
    }

    /* renamed from: d */
    private void m22719d() {
        WalletPageQueryResp.AccountSectionItem accountSectionItem = this.f32037d;
        if (accountSectionItem != null) {
            if (accountSectionItem.status != 1) {
                HashMap hashMap = new HashMap();
                hashMap.put(TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, Integer.valueOf(this.f32037d.status));
                hashMap.put("interest_status", Integer.valueOf(this.f32037d.interestStatus));
                PayTracker.trackEvent("ibt_didipay_sidebar_interest_signup_ck", hashMap);
            }
            if (this.f32037d.status == 0) {
                DRouter.build("99pay://one/register").start((Context) null);
            } else if (this.f32037d.status == 3) {
                WalletRouter.gotoFailedReasonPage(this.f32035b, this.f32037d.accountStatus);
            } else if (this.f32037d.status == 2) {
                WalletRouter.gotoSignUpWaitingPage(this.f32035b, this.f32037d.accountStatus);
            } else if (this.f32037d.status == 1) {
                if (this.f32037d.supportFullKyc && 1 != this.f32037d.fullKycStatus) {
                    WalletRouter.gotoFullKycRegisterPage(this.f32035b, 1);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, Integer.valueOf(this.f32037d.status));
                    hashMap2.put("full_kyc_status", Integer.valueOf(this.f32037d.fullKycStatus));
                    PayTracker.trackEvent("ibt_didipay_kyc_user_verify_ck", hashMap2);
                } else {
                    return;
                }
            }
            try {
                this.f32035b.finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: e */
    private void m22720e() {
        PayPalProxy.IPayPalProxy proxy;
        if (this.f32036c != null && (proxy = PayPalProxy.getProxy()) != null) {
            proxy.startPayPalDetailActivity(this.f32035b, 4);
        }
    }
}
