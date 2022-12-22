package com.didi.payment.wallet.global.wallet.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.api.DRouter;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.CashierLaunchListener;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.proxy.CommonProxyHolder;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.NewCashierApolloUtils;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.model.resp.WalletPayResultResp;
import com.didi.payment.wallet.global.model.resp.model.WalletOperationItem;
import com.didi.payment.wallet.global.wallet.contract.WalletTopUpPayResultContract;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpUniPayActivity;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.unifiedPay.component.model.PayParam;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;

public class WalletTopUpPayResultPresenter implements WalletTopUpPayResultContract.Presenter {

    /* renamed from: a */
    private static final long f32115a = 1000;

    /* renamed from: b */
    private static final int f32116b = 10;

    /* renamed from: c */
    private int f32117c = -1;

    /* renamed from: d */
    private CountDownTimer f32118d;
    protected FragmentActivity mContext;
    protected WalletPayResultResp.PayResultData mData;
    protected String mOrderId;
    protected int mOrderType = -1;
    protected int mProductLine;
    protected WalletTopUpPayResultContract.View mView;
    protected WalletPageModel mWalletPageModel;

    public void handleEnterHistory() {
    }

    public boolean isCancelableOrder() {
        return false;
    }

    public boolean isTopupByDriver() {
        return false;
    }

    public void trackOmega(int i) {
    }

    public WalletTopUpPayResultPresenter(FragmentActivity fragmentActivity, WalletTopUpPayResultContract.View view) {
        this.mContext = fragmentActivity;
        this.mView = view;
        this.mWalletPageModel = new WalletPageModel(fragmentActivity);
        Intent intent = fragmentActivity.getIntent();
        if (intent != null) {
            this.mProductLine = intent.getIntExtra("product_line", 0);
            this.mOrderId = intent.getStringExtra("order_id");
            this.mOrderType = intent.getIntExtra("order_type", -1);
            this.f32117c = intent.getIntExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, -1);
        }
        m22810e();
    }

    public void onOperationItemShown(WalletOperationItem walletOperationItem) {
        PayTracker.trackEvent("ibt_didipay_topup_success_signup_sw");
    }

    public void onOperationItemClicked(WalletOperationItem walletOperationItem) {
        PayTracker.trackEvent("ibt_didipay_topup_success_signup_ck");
        if (walletOperationItem != null && !TextUtils.isEmpty(walletOperationItem.linkUrl)) {
            if (walletOperationItem.linkUrl.startsWith("http")) {
                WebBrowserUtil.startInternalWebActivity(this.mContext, walletOperationItem.linkUrl, "");
            } else {
                DRouter.build(walletOperationItem.linkUrl).start((Context) null);
            }
        }
    }

    public boolean isSupportCountdonw() {
        int i = this.f32117c;
        return (i == 256 || i == 260) ? false : true;
    }

    public void onCancelBtnClick() {
        this.mView.showLoadingDialog();
        this.mWalletPageModel.closeOrder(this.mProductLine, this.mOrderId, new RpcService.Callback<WBaseResp>() {
            public void onSuccess(WBaseResp wBaseResp) {
                WalletTopUpPayResultPresenter.this.mView.dismissLoadingDialog();
                if (wBaseResp.errno == 0) {
                    WalletToastNew.showSuccessMsg(WalletTopUpPayResultPresenter.this.mContext, WalletTopUpPayResultPresenter.this.mContext.getString(R.string.Fintech_Payment_optimization__xqKC));
                    WalletTopUpPayResultPresenter.this.mContext.setResult(-1);
                    WalletTopUpPayResultPresenter.this.mContext.finish();
                } else if (!TextUtils.isEmpty(wBaseResp.errmsg)) {
                    WalletToastNew.showFailedMsg(WalletTopUpPayResultPresenter.this.mContext, wBaseResp.errmsg);
                } else {
                    WalletToastNew.showFailedMsg(WalletTopUpPayResultPresenter.this.mContext, ResourcesHelper.getString(WalletTopUpPayResultPresenter.this.mContext, R.string.Fintech_Payment_optimization__cmex));
                }
            }

            public void onFailure(IOException iOException) {
                WalletTopUpPayResultPresenter.this.mView.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(WalletTopUpPayResultPresenter.this.mContext, ResourcesHelper.getString(WalletTopUpPayResultPresenter.this.mContext, R.string.pay_base_network_error));
            }
        });
    }

    public void executeTask() {
        if (isSupportCountdonw()) {
            startPollingStatus();
            return;
        }
        this.mView.showLoadingDialog();
        queryOrderStatus(true);
    }

    public void startPollingStatus() {
        if (this.f32118d == null) {
            this.mView.showLoadingStart();
            C112352 r1 = new CountDownTimer(10000, 1000) {
                public void onTick(long j) {
                    int i = (int) (j / 1000);
                    WalletTopUpPayResultPresenter.this.mView.showCountdownLoading(i, 10 - i);
                    if (i / 2 == 0) {
                        WalletTopUpPayResultPresenter.this.queryOrderStatus(false);
                    }
                }

                public void onFinish() {
                    WalletTopUpPayResultPresenter.this.m22800a();
                    WalletTopUpPayResultPresenter.this.queryOrderStatus(true);
                }
            };
            this.f32118d = r1;
            r1.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22800a() {
        if (this.mProductLine == 605) {
            PayTracker.trackEvent("ibt_gp_didipay_phonebill_result_polling_success_sw");
        }
    }

    /* access modifiers changed from: protected */
    public void queryOrderStatus(final boolean z) {
        this.mWalletPageModel.getOrderStatus(this.mProductLine, this.mOrderId, new RpcService.Callback<WalletPayResultResp>() {
            public void onSuccess(WalletPayResultResp walletPayResultResp) {
                if (walletPayResultResp.errno != 0 || walletPayResultResp.data == null) {
                    onFinish((WalletPayResultResp.PayResultData) null);
                    return;
                }
                WalletTopUpPayResultPresenter.this.mData = walletPayResultResp.data;
                if (!WalletTopUpPayResultPresenter.this.isSupportCountdonw()) {
                    onFinish(walletPayResultResp.data);
                    WalletTopUpPayResultPresenter.this.m22807c();
                } else if (walletPayResultResp.data.status != 0 || z) {
                    WalletTopUpPayResultPresenter.this.m22804b();
                    WalletTopUpPayResultPresenter.this.m22800a();
                    onFinish(walletPayResultResp.data);
                    if (z) {
                        WalletTopUpPayResultPresenter.this.m22807c();
                    }
                }
            }

            public void onFailure(IOException iOException) {
                onFinish((WalletPayResultResp.PayResultData) null);
            }

            private void onFinish(WalletPayResultResp.PayResultData payResultData) {
                WalletTopUpPayResultPresenter.this.mView.showLoadingFinish(payResultData);
                if (!WalletTopUpPayResultPresenter.this.isSupportCountdonw()) {
                    WalletTopUpPayResultPresenter.this.mView.dismissLoadingDialog();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m22804b() {
        CountDownTimer countDownTimer = this.f32118d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void handleBackClick() {
        EventBus.getDefault().post(new WalletRefreshDataEvent());
        this.mContext.finish();
    }

    public void handleConfirmClick() {
        WalletPayResultResp.PayResultData payResultData = this.mData;
        if (payResultData == null) {
            this.mContext.finish();
        } else if (payResultData.status != 6 || TextUtils.isEmpty(this.mData.outTradeId)) {
            trackConfirmClick();
            EventBus.getDefault().post(new WalletRefreshDataEvent());
            this.mContext.finish();
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
            hashMap.put("g_BizId", "Boleto");
            hashMap.put("button_name", "Pay");
            PayTracker.trackEvent("fin_boleto_unpaidpage_btn_ck", hashMap);
            m22803a(this.mData.outTradeId);
        }
    }

    /* renamed from: a */
    private void m22803a(final String str) {
        if (NewCashierApolloUtils.useNewCashier()) {
            CashierParam cashierParam = new CashierParam();
            cashierParam.setOutTradeId(str);
            CashierFacade.getInstance().launchForResult((Activity) this.mContext, 200, cashierParam, (CashierLaunchListener) new CashierLaunchListener() {
                public void onCashierLaunch(boolean z) {
                    if (!z) {
                        WalletTopUpPayResultPresenter.this.m22806b(str);
                    }
                }
            });
            return;
        }
        m22806b(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m22806b(String str) {
        Object terminalId;
        PayParam payParam = new PayParam();
        payParam.outTradeId = str;
        payParam.omegaAttrs = new HashMap();
        payParam.omegaAttrs.put("product_line", Integer.valueOf(this.mProductLine));
        CommonProxyHolder.ICommonProxy proxy = CommonProxyHolder.getProxy();
        if (!(proxy == null || (terminalId = proxy.getTerminalId(this.mContext.getApplicationContext())) == null)) {
            payParam.omegaAttrs.put("wallet_terminal_id", terminalId);
        }
        WalletTopUpUniPayActivity.launch(this.mContext, payParam, 100);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m22807c() {
        /*
            r8 = this;
            com.didi.payment.wallet.global.model.resp.WalletPayResultResp$PayResultData r0 = r8.mData
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.didi.payment.wallet.global.model.resp.WalletPayResultResp$PayResultData r1 = r8.mData
            int r1 = r1.status
            java.lang.String r2 = "page_source"
            r3 = 0
            java.lang.String r4 = "order_type"
            r5 = 605(0x25d, float:8.48E-43)
            r6 = 606(0x25e, float:8.49E-43)
            r7 = 1
            if (r1 != r7) goto L_0x0039
            int r1 = r8.mProductLine
            if (r1 != r6) goto L_0x0021
            java.lang.String r1 = "ibt_gp_didipay_lifebill_paysuccess_sw"
            goto L_0x005a
        L_0x0021:
            if (r1 != r5) goto L_0x0058
            int r1 = r8.mOrderType
            if (r1 != r7) goto L_0x0028
            r3 = 1
        L_0x0028:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r0.put(r4, r1)
            java.lang.String r1 = r8.m22809d()
            r0.put(r2, r1)
            java.lang.String r1 = "ibt_gp_didipay_phonebill_paysuccess_sw"
            goto L_0x005a
        L_0x0039:
            int r1 = r8.mProductLine
            if (r1 != r6) goto L_0x0040
            java.lang.String r1 = "ibt_gp_didipay_lifebill_payfail_sw"
            goto L_0x005a
        L_0x0040:
            if (r1 != r5) goto L_0x0058
            int r1 = r8.mOrderType
            if (r1 != r7) goto L_0x0047
            r3 = 1
        L_0x0047:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r0.put(r4, r1)
            java.lang.String r1 = r8.m22809d()
            r0.put(r2, r1)
            java.lang.String r1 = "ibt_gp_didipay_phonebill_fail_sw"
            goto L_0x005a
        L_0x0058:
            java.lang.String r1 = ""
        L_0x005a:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0063
            com.didi.payment.base.tracker.PayTracker.trackEvent(r1, r0)
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.presenter.WalletTopUpPayResultPresenter.m22807c():void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        if (r1 == 605) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        r3 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0025, code lost:
        if (r1 == 605) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trackConfirmClick() {
        /*
            r8 = this;
            com.didi.payment.wallet.global.model.resp.WalletPayResultResp$PayResultData r0 = r8.mData
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.didi.payment.wallet.global.model.resp.WalletPayResultResp$PayResultData r1 = r8.mData
            int r1 = r1.status
            r2 = 1
            java.lang.String r3 = "ibt_gp_didipay_phonebill_confirm_ck"
            java.lang.String r4 = "ibt_gp_didipay_lifebill_confirm_ck"
            r5 = 605(0x25d, float:8.48E-43)
            r6 = 606(0x25e, float:8.49E-43)
            java.lang.String r7 = "page"
            if (r1 != r2) goto L_0x0028
            java.lang.String r1 = "paysuccess"
            r0.put(r7, r1)
            int r1 = r8.mProductLine
            if (r1 != r6) goto L_0x0025
            goto L_0x0031
        L_0x0025:
            if (r1 != r5) goto L_0x0036
            goto L_0x0038
        L_0x0028:
            java.lang.String r1 = "payfail"
            r0.put(r7, r1)
            int r1 = r8.mProductLine
            if (r1 != r6) goto L_0x0033
        L_0x0031:
            r3 = r4
            goto L_0x0038
        L_0x0033:
            if (r1 != r5) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            java.lang.String r3 = ""
        L_0x0038:
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 != 0) goto L_0x0041
            com.didi.payment.base.tracker.PayTracker.trackEvent(r3, r0)
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.presenter.WalletTopUpPayResultPresenter.trackConfirmClick():void");
    }

    /* renamed from: d */
    private String m22809d() {
        int intExtra = this.mContext.getIntent().getIntExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, -1);
        if (intExtra == 258) {
            return "amount_select";
        }
        return intExtra == 256 ? "hisotry" : "push";
    }

    /* renamed from: e */
    private void m22810e() {
        int i = this.mProductLine;
        String str = i == 606 ? "ibt_gp_didipay_lifebill_paywait_sw" : i == 605 ? "ibt_gp_didipay_phonebill_paywait_sw" : "";
        if (!TextUtils.isEmpty(str)) {
            PayTracker.trackEvent(str);
        }
    }
}
