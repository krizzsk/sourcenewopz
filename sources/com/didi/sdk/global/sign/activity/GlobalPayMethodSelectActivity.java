package com.didi.sdk.global.sign.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.api.Extend;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.PaySharedPreferencesUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletTopUpOmegaUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.model.local.PaySelPageData;
import com.didi.sdk.global.sign.payselect.utils.PaySelUT;
import com.didi.sdk.global.sign.presenter.GlobalSelectPagePresenter;
import com.didi.sdk.global.sign.view.PayMethodBaseFragmentView;
import com.didi.sdk.global.sign.view.PayMethodSelectFragmentView;
import com.didi.sdk.global.sign.view.helper.GlobalPayOmegaUtils;
import com.didi.sdk.global.sign.view.helper.PayMethodSelectCloseHelper;
import com.didi.sdk.global.util.GlobalOmegaUtils;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;

public class GlobalPayMethodSelectActivity extends GlobalBasePayMethodListActivity {

    /* renamed from: a */
    private PayMethodSelectFragmentView f36208a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f36209b = false;
    protected GlobalSelectPagePresenter mPresenter;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        initStatusBar();
        super.onCreate(bundle);
        setContentView((int) R.layout.one_payment_activity_global_paymethod_select_list);
        initBase();
        m25578a();
        m25582b();
        m25583c();
        GlobalSelectPagePresenter globalSelectPagePresenter = this.mPresenter;
        if (globalSelectPagePresenter != null) {
            globalSelectPagePresenter.onCreate(bundle);
        }
        if (WalletApolloUtil.isNewPayMethodListEnable()) {
            PayTracker.putGlobal(TransGlobalOmegaKey.KEY_WALLET_PAGEID, "pay_select_v2");
        } else {
            PayTracker.putGlobal(TransGlobalOmegaKey.KEY_WALLET_PAGEID, "pay_select");
        }
        if (this.mParam != null && this.mParam.from != null) {
            PaySelUT.INSTANCE.trackPageSourceFrom(this.mParam.from.ordinal());
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f36209b) {
            this.f36209b = false;
            this.mPresenter.refreshDataFromServer(190, "");
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        GlobalSelectPagePresenter globalSelectPagePresenter = this.mPresenter;
        if (globalSelectPagePresenter != null) {
            globalSelectPagePresenter.onDestroy();
        }
        sAdapter = null;
    }

    /* renamed from: a */
    private void m25578a() {
        findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalPayMethodSelectActivity.this.onBackPressed();
                GlobalOmegaUtils.trackPayMethodSelectPageReturnCK(GlobalPayMethodSelectActivity.this.mContext, GlobalPayMethodSelectActivity.this.mPresenter.getOmegaSource(), GlobalPayMethodSelectActivity.this.mParam.resourceId);
            }
        });
        this.f36208a = (PayMethodSelectFragmentView) findViewById(R.id.v_pay_select_view);
    }

    /* renamed from: b */
    private void m25582b() {
        GlobalSelectPagePresenter globalSelectPagePresenter = new GlobalSelectPagePresenter(this);
        this.mPresenter = globalSelectPagePresenter;
        globalSelectPagePresenter.setView(this.f36208a);
        String findDiscountStr = this.mPresenter.findDiscountStr(this.mParam, "add_card_discount_msg");
        this.f36208a.setDiscountContent(findDiscountStr);
        GlobalOmegaUtils.trackPayMethodSelectPageSW(this.mContext, this.mPresenter.getOmegaSource(), this.mPresenter.getOmegaDefaultPayment(), this.mParam.resourceId, TextUtils.isEmpty(findDiscountStr) ^ true ? 1 : 0);
        this.mPresenter.initPayMethodSelectAdapter(sAdapter);
        this.mPresenter.initData(this.mParam);
        sAdapter = null;
    }

    /* renamed from: c */
    private void m25583c() {
        this.f36208a.setPayMethodPageEventListener(new PayMethodBaseFragmentView.PayMethodPageEventListener() {
            public void onPayMethodClickEvent(View view, PaySelItemData paySelItemData) {
                if (paySelItemData != null) {
                    SystemUtils.log(3, "wallet", "onPayMethodClicked, name:" + paySelItemData.title + ", channelId=" + paySelItemData.channelId + ", cardIndex=" + paySelItemData.cardIndex, (Throwable) null, "com.didi.sdk.global.sign.activity.GlobalPayMethodSelectActivity$2", 137);
                    int i = paySelItemData.channelId;
                    if (i == 121) {
                        GlobalPayOmegaUtils.trackPayMethodSelectPageEnterpriseCK(GlobalPayMethodSelectActivity.this.mContext, GlobalPayMethodSelectActivity.this.mPresenter.getOmegaSource(), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaClickType(paySelItemData), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaCardCount());
                        GlobalPayMethodSelectActivity.this.mPresenter.jumpToEnterprisePage();
                    } else if (i == 150) {
                        GlobalPayMethodSelectActivity.this.mPresenter.jumpToCreditCardActivity(paySelItemData, GlobalPayMethodSelectActivity.this.mParam);
                        if (GlobalPayMethodSelectActivity.this.mParam != null) {
                            GlobalPayOmegaUtils.trackPayMethodSelectPageCreditCK(GlobalPayMethodSelectActivity.this.mContext, GlobalPayMethodSelectActivity.this.mPresenter.getOmegaSource(), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaClickType(paySelItemData), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaCardCount());
                        }
                    } else if (i == 152) {
                        GlobalPayMethodSelectActivity.this.mPresenter.jumpToPayPalPage(paySelItemData);
                        GlobalPayOmegaUtils.trackPayMethodSelectPagePaypalCK(GlobalPayMethodSelectActivity.this.mContext, GlobalPayMethodSelectActivity.this.mPresenter.getOmegaSource(), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaClickType(paySelItemData), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaCardCount());
                    } else if (i == 190) {
                        GlobalPayMethodSelectActivity.this.m25580a(paySelItemData);
                    } else if (i == 182) {
                        GlobalPayOmegaUtils.trackPayMethodSelectPaypayCK(GlobalPayMethodSelectActivity.this.mContext, GlobalPayMethodSelectActivity.this.mPresenter.getOmegaSource(), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaClickType(paySelItemData), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaCardCount());
                        GlobalPayMethodSelectActivity.this.mPresenter.jumpToPayPayPage();
                    } else if (i == 183) {
                        GlobalPayOmegaUtils.trackPayMethodSelectPaypalV2CK(GlobalPayMethodSelectActivity.this.mContext, GlobalPayMethodSelectActivity.this.mPresenter.getOmegaSource(), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaClickType(paySelItemData), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaCardCount());
                        GlobalPayMethodSelectActivity.this.mPresenter.jumpToPayPalV2Page();
                    }
                }
            }

            public boolean onInterceptPayMethodSelect(View view, PaySelItemData paySelItemData) {
                if (paySelItemData == null || TextUtils.isEmpty(paySelItemData.guideH5Url) || PaySharedPreferencesUtil.isNewPayChannelGuideH5Shown(GlobalPayMethodSelectActivity.this, paySelItemData.channelId)) {
                    return false;
                }
                PaySharedPreferencesUtil.setNewPayChannelGuideH5Shown(GlobalPayMethodSelectActivity.this, paySelItemData.channelId, true);
                WebBrowserUtil.startInternalWebActivity(GlobalPayMethodSelectActivity.this, paySelItemData.guideH5Url, "");
                GlobalPayMethodSelectActivity.this.mPresenter.postSelectedItemDelay(paySelItemData.channelId, paySelItemData.cardIndex);
                return true;
            }

            public void onPayMethodSelectEvent(View view, PaySelItemData paySelItemData) {
                if (paySelItemData == null) {
                    GlobalPayMethodSelectActivity.this.onBackPressedWrapper(paySelItemData);
                    return;
                }
                SystemUtils.log(3, "wallet", "onPayMethodSelected, name:" + paySelItemData.title + ", channelId=" + paySelItemData.channelId + ", cardIndex=" + paySelItemData.cardIndex, (Throwable) null, "com.didi.sdk.global.sign.activity.GlobalPayMethodSelectActivity$2", 193);
                int i = paySelItemData.channelId;
                if (i == 120) {
                    GlobalPayMethodSelectActivity.this.onBackPressedWrapper(paySelItemData);
                } else if (i == 121) {
                    GlobalOmegaUtils.trackPayMethodSelectPageEnterpriseCK(GlobalPayMethodSelectActivity.this.mContext, GlobalPayMethodSelectActivity.this.mPresenter.getOmegaSource(), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaClickType(paySelItemData), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaCardCount());
                    if (GlobalPayMethodSelectActivity.this.mParam == null || GlobalPayMethodSelectActivity.this.mParam.from != DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION) {
                        GlobalPayMethodSelectActivity.this.onBackPressedWrapper(paySelItemData);
                        return;
                    } else {
                        GlobalPayMethodSelectActivity.this.mPresenter.jumpToEnterprisePage();
                        return;
                    }
                } else if (i == 150) {
                    GlobalOmegaUtils.trackPayMethodSelectPageCreditCK(GlobalPayMethodSelectActivity.this.mContext, GlobalPayMethodSelectActivity.this.mPresenter.getOmegaSource(), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaClickType(paySelItemData), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaCardCount());
                    GlobalPayMethodSelectActivity.this.onBackPressedWrapper(paySelItemData);
                    return;
                } else if (i == 190) {
                    GlobalPayMethodSelectActivity.this.onBackPressedWrapper(paySelItemData);
                    return;
                } else if (i == 212) {
                    GlobalPayOmegaUtils.trackPayMethodSelectPIXCK(GlobalPayMethodSelectActivity.this.mContext, GlobalPayMethodSelectActivity.this.mPresenter.getCurrentSelectedChannelId());
                    GlobalPayMethodSelectActivity.this.onBackPressedWrapper(paySelItemData);
                    return;
                } else if (i == 182) {
                    GlobalPayOmegaUtils.trackPayMethodSelectPaypayCK(GlobalPayMethodSelectActivity.this.mContext, GlobalPayMethodSelectActivity.this.mPresenter.getOmegaSource(), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaClickType(paySelItemData), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaCardCount());
                    GlobalPayMethodSelectActivity.this.onBackPressedWrapper(paySelItemData);
                    return;
                } else if (i != 183) {
                    switch (i) {
                        case 152:
                            GlobalOmegaUtils.trackPayMethodSelectPagePaypalCK(GlobalPayMethodSelectActivity.this.mContext, GlobalPayMethodSelectActivity.this.mPresenter.getOmegaSource(), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaClickType(paySelItemData), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaCardCount());
                            GlobalPayMethodSelectActivity.this.onBackPressedWrapper(paySelItemData);
                            return;
                        case 153:
                            break;
                        case 154:
                            GlobalOmegaUtils.trackPayMethodSelectPagePosCK(GlobalPayMethodSelectActivity.this.mContext, GlobalPayMethodSelectActivity.this.mPresenter.getOmegaSource(), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaClickType(paySelItemData), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaCardCount());
                            GlobalPayMethodSelectActivity.this.onBackPressedWrapper(paySelItemData);
                            return;
                        default:
                            return;
                    }
                } else {
                    GlobalPayOmegaUtils.trackPayMethodSelectPaypalV2CK(GlobalPayMethodSelectActivity.this.mContext, GlobalPayMethodSelectActivity.this.mPresenter.getOmegaSource(), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaClickType(paySelItemData), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaCardCount());
                    GlobalPayMethodSelectActivity.this.onBackPressedWrapper(paySelItemData);
                    return;
                }
                GlobalOmegaUtils.trackPayMethodSelectPageCashCK(GlobalPayMethodSelectActivity.this.mContext, GlobalPayMethodSelectActivity.this.mPresenter.getOmegaSource(), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaClickType(paySelItemData), GlobalPayMethodSelectActivity.this.mPresenter.getOmegaCardCount());
                GlobalPayMethodSelectActivity.this.onBackPressedWrapper(paySelItemData);
            }

            public void onPageClickEvent(View view, PaySelPageData paySelPageData) {
                if (view.getId() == R.id.ll_empty) {
                    GlobalPayMethodSelectActivity.this.mPresenter.requestDataFromServer(GlobalPayMethodSelectActivity.this.mParam.from);
                }
            }

            public void onEnterpriseSwitch(View view, boolean z) {
                GlobalPayMethodSelectActivity.this.mPresenter.updateEnterpriseView(z);
            }

            public void onPageUrlClicked(String str) {
                if (!TextUtils.isEmpty(str)) {
                    WebBrowserUtil.startInternalWebActivity(GlobalPayMethodSelectActivity.this, str, "");
                }
            }

            public void onBalanceSwitchClick(boolean z) {
                GlobalPayMethodSelectActivity.this.mPresenter.setCombinePaymentStatus(z);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25580a(PaySelItemData paySelItemData) {
        if (paySelItemData.status != 1 || paySelItemData.isSufficient) {
            this.mPresenter.jumpToWalletHomePage();
        } else if (WalletApolloUtil.getTopUpIsNew()) {
            WalletTopUpOmegaUtil.Companion.trackEvent("fin_payment_topup_ck", new HashMap());
            ((Request) DRouter.build("GuaranaOneTravel://one/ddw_top_up?pub_source=rider_payment_topup").putExtra(Extend.START_ACTIVITY_REQUEST_CODE, 10)).start(this, new RouterCallback() {
                public void onResult(Result result) {
                    boolean unused = GlobalPayMethodSelectActivity.this.f36209b = true;
                }
            });
        } else if (this.mPresenter.hasAvailableCard()) {
            this.mPresenter.jumpTo99TopupAmountPage();
        } else {
            this.mPresenter.jumpToTopupChanelPage();
        }
    }

    public void onBackPressedWrapper(PaySelItemData paySelItemData) {
        if (paySelItemData == null || paySelItemData.style != 3) {
            for (PaySelItemData next : this.f36208a.getSelectedPayMethod()) {
                SystemUtils.log(3, "wallet", "wrapper, method name: " + next.title + ", style=" + next.style, (Throwable) null, "com.didi.sdk.global.sign.activity.GlobalPayMethodSelectActivity", 310);
                if (next.style == 3) {
                    SystemUtils.log(3, "wallet", "no auto onBackPressed as switch item is selected", (Throwable) null, "com.didi.sdk.global.sign.activity.GlobalPayMethodSelectActivity", 313);
                    return;
                }
            }
            onBackPressed();
            return;
        }
        SystemUtils.log(3, "wallet", "no auto onBackPressed as switch item is involved", (Throwable) null, "com.didi.sdk.global.sign.activity.GlobalPayMethodSelectActivity", 305);
    }

    public void onBackPressed() {
        List<PaySelItemData> selectedPayMethod = this.f36208a.getSelectedPayMethod();
        boolean z = false;
        if (!(this.mParam.from == DidiGlobalPayMethodListData.Entrance.FROM_SPLIT_FARE && selectedPayMethod == null) && !selectedPayMethod.isEmpty()) {
            PayMethodSelectCloseHelper.SelectionValidationResult validateSelection = PayMethodSelectCloseHelper.validateSelection(selectedPayMethod, this.f36208a.hasSelectablePayMethod());
            if (validateSelection != PayMethodSelectCloseHelper.SelectionValidationResult.SUCCESS) {
                ToastHelper.showLongInfo((Context) this, PayMethodSelectCloseHelper.getValidationErrorMessage(this, validateSelection), (int) R.drawable.pay_toast_error);
                return;
            }
            DidiGlobalPayMethodListData.PayMethodListResult prepareSelectedPayMethodResult = PayMethodSelectCloseHelper.prepareSelectedPayMethodResult(selectedPayMethod, this.mPresenter.getEnterpriseFlag());
            if (this.mPresenter.hasRequestDataFromServer() || PayMethodSelectCloseHelper.isChannelRefreshed(this, this.mParam, prepareSelectedPayMethodResult)) {
                z = true;
            }
            prepareSelectedPayMethodResult.hasRefreshed = z;
            SystemUtils.log(3, "wallet", "hasRefreshed? " + prepareSelectedPayMethodResult.hasRefreshed, (Throwable) null, "com.didi.sdk.global.sign.activity.GlobalPayMethodSelectActivity", 347);
            setResult(prepareSelectedPayMethodResult);
            return;
        }
        finish();
        overridePendingTransition(0, R.anim.one_payment_out_to_right);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        SystemUtils.log(3, "wallet", "OnActivityResult, requestCode=" + i + ", resultCode=" + i2, (Throwable) null, "com.didi.sdk.global.sign.activity.GlobalPayMethodSelectActivity", 356);
        String str = "";
        if (i != 1) {
            if (i != 3) {
                if (i != 5) {
                    if (i != 6) {
                        switch (i) {
                            case 8:
                            case 10:
                                this.mPresenter.refreshDataFromServer(190, str);
                                return;
                            case 9:
                                this.mPresenter.refreshDataFromServer();
                                return;
                            default:
                                return;
                        }
                    }
                } else if (i2 == -1) {
                    this.mPresenter.refreshDataFromLocal(121, str);
                    return;
                } else {
                    return;
                }
            } else if (i2 == -1 && intent != null && intent.getIntExtra("errno", -1) == 0) {
                this.mPresenter.refreshDataFromServer(152, str);
                return;
            } else {
                return;
            }
        }
        if (i2 == -1) {
            if (intent != null) {
                str = intent.getStringExtra("card_index");
            }
            this.mPresenter.refreshDataFromServer(150, str);
        }
    }
}
