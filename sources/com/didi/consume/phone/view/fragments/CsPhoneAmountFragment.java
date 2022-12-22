package com.didi.consume.phone.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.consume.base.CsOmegaUtils;
import com.didi.consume.phone.model.CsAmountListResp;
import com.didi.consume.phone.model.CsCouponOrderBody;
import com.didi.consume.phone.model.CsCreateOrderBody;
import com.didi.consume.phone.model.CsCreateOrderResp;
import com.didi.consume.phone.model.CsVoucherResponse;
import com.didi.consume.phone.view.adapter.CsMobileAmountAdapter;
import com.didi.consume.phone.view.contract.CsPhoneAmountContract;
import com.didi.consume.phone.view.prsenter.CsPhoneAmountPresenter;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.CashierLaunchListener;
import com.didi.global.fintech.cashier.user.facade.FastPayFacade;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.payment.base.proxy.CommonProxyHolder;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.NewCashierApolloUtils;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.base.view.webview.PayBaseWebActivity;
import com.didi.payment.base.view.webview.WalletWebActivity;
import com.didi.payment.base.view.webview.WebModel;
import com.didi.payment.base.view.webview.fusion.model.UrlUtil;
import com.didi.payment.base.web.WalletDiminaUtil;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.fastpay.FastPayUT;
import com.didi.payment.creditcard.global.widget.NoDoubleClickListener;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpPayResultActivity;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpUniPayActivity;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.wallet.dimina.DiminaLaunchModel;
import com.google.gson.Gson;
import com.taxis99.R;
import java.util.HashMap;

public class CsPhoneAmountFragment extends Fragment implements CsPhoneAmountContract.View {

    /* renamed from: a */
    private static final String f16276a = "param_country_code";

    /* renamed from: b */
    private static final String f16277b = "param_phone_num";

    /* renamed from: c */
    private static final String f16278c = "param_phone_operatorid";

    /* renamed from: d */
    private static final String f16279d = "param_order_type";

    /* renamed from: e */
    private static final String f16280e = "param_extra";

    /* renamed from: f */
    private static final int f16281f = 101;

    /* renamed from: A */
    private String f16282A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public boolean f16283B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public String f16284C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public String f16285D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public String f16286E;

    /* renamed from: F */
    private CsVoucherResponse.DataBean f16287F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public String f16288G;

    /* renamed from: H */
    private CsAmountListResp.DataBean f16289H;

    /* renamed from: I */
    private CsMobileAmountAdapter.OnAmountClickListener f16290I = new CsMobileAmountAdapter.OnAmountClickListener() {
        public void onClick(CsAmountListResp.Amount amount, String str) {
            CsPhoneAmountFragment csPhoneAmountFragment = CsPhoneAmountFragment.this;
            int unused = csPhoneAmountFragment.f16310z = csPhoneAmountFragment.getActivity().getIntent().getIntExtra("order_type", -1);
            HashMap hashMap = new HashMap();
            int i = 1;
            if (CsPhoneAmountFragment.this.f16310z != 1) {
                i = 0;
            }
            hashMap.put("order_type", Integer.valueOf(i));
            if ("1".equalsIgnoreCase(amount.disabled)) {
                if (TextUtil.isEmpty(str)) {
                    str = CsPhoneAmountFragment.this.getString(R.string.wallet_topup_amount_disable_reason);
                }
                ToastHelper.showShortInfo((Context) CsPhoneAmountFragment.this.getActivity(), str, (int) R.drawable.wallet_toast_icon_fail);
                FinOmegaSDK.trackEvent("ibt_gp_didipay_drv_phone_topup_toast_sw", hashMap);
                return;
            }
            CsPhoneAmountFragment.this.f16298n.refreshSelectAmount(amount);
            String unused2 = CsPhoneAmountFragment.this.f16284C = amount.amount;
            String unused3 = CsPhoneAmountFragment.this.f16285D = amount.payAmount;
            if (CsPhoneAmountFragment.this.f16283B) {
                CsPhoneAmountFragment.this.f16307w.getVoucherDiscount(605, CsPhoneAmountFragment.this.f16285D);
            }
            CsPhoneAmountFragment.this.m11939a(amount.currencySymbol, amount.amount);
            CsOmegaUtils.trackPhoneBillAmountSelected(hashMap);
        }
    };

    /* renamed from: g */
    private String f16291g;

    /* renamed from: h */
    private String f16292h;

    /* renamed from: i */
    private String f16293i;

    /* renamed from: j */
    private String f16294j;

    /* renamed from: k */
    private boolean f16295k;

    /* renamed from: l */
    private LinearLayout f16296l;

    /* renamed from: m */
    private RecyclerView f16297m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public CsMobileAmountAdapter f16298n;

    /* renamed from: o */
    private TextView f16299o;

    /* renamed from: p */
    private TextView f16300p;

    /* renamed from: q */
    private TextView f16301q;

    /* renamed from: r */
    private TextView f16302r;

    /* renamed from: s */
    private ConstraintLayout f16303s;

    /* renamed from: t */
    private ConstraintLayout f16304t;

    /* renamed from: u */
    private LinearLayout f16305u;

    /* renamed from: v */
    private TextView f16306v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public CsPhoneAmountContract.Presenter f16307w;

    /* renamed from: x */
    private OnFragmentAmountInteractionListener f16308x;

    /* renamed from: y */
    private WalletLoadingContract f16309y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f16310z = -1;

    public interface OnFragmentAmountInteractionListener {
        void onFragmentAmountInteraction();
    }

    public static CsPhoneAmountFragment newInstance(String str, String str2, String str3, int i, String str4) {
        CsPhoneAmountFragment csPhoneAmountFragment = new CsPhoneAmountFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(f16276a, str);
        bundle.putSerializable(f16277b, str2);
        bundle.putSerializable(f16278c, str3);
        bundle.putInt(f16279d, i);
        bundle.putString(f16280e, str4);
        csPhoneAmountFragment.setArguments(bundle);
        return csPhoneAmountFragment;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentAmountInteractionListener) {
            this.f16308x = (OnFragmentAmountInteractionListener) context;
            if (context instanceof WalletLoadingContract) {
                this.f16309y = (WalletLoadingContract) context;
                return;
            }
            throw new RuntimeException(context.toString() + " must implement WalletLoadingContract");
        }
        throw new RuntimeException(context.toString() + " must implement OnFragmentZipCodeInteractionListener");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f16291g = (String) getArguments().getSerializable(f16276a);
            this.f16292h = (String) getArguments().getSerializable(f16277b);
            this.f16293i = (String) getArguments().getSerializable(f16278c);
            this.f16310z = getArguments().getInt(f16279d);
            this.f16282A = getArguments().getString(f16280e);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.cs_fragment_amount, viewGroup, false);
        m11932a(inflate);
        m11931a();
        this.f16307w = new CsPhoneAmountPresenter(getActivity(), this, this.f16309y);
        return inflate;
    }

    public void onStart() {
        super.onStart();
        if (this.f16298n == null) {
            this.f16307w.getAmountList(605, this.f16291g, this.f16292h, this.f16293i, this.f16282A);
        }
    }

    /* renamed from: a */
    private void m11932a(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_amount_content);
        this.f16296l = linearLayout;
        this.f16297m = (RecyclerView) linearLayout.findViewById(R.id.rv_amount_list);
        this.f16299o = (TextView) this.f16296l.findViewById(R.id.btn_amount_next);
        this.f16300p = (TextView) this.f16296l.findViewById(R.id.tv_sub_title);
        this.f16301q = (TextView) this.f16296l.findViewById(R.id.tv_voucher_price);
        this.f16302r = (TextView) this.f16296l.findViewById(R.id.tv_voucher_status);
        this.f16303s = (ConstraintLayout) this.f16296l.findViewById(R.id.voucher_price_container);
        this.f16304t = (ConstraintLayout) this.f16296l.findViewById(R.id.voucher_container);
        this.f16305u = (LinearLayout) this.f16296l.findViewById(R.id.ll_switch_pay_method_container);
        this.f16306v = (TextView) this.f16296l.findViewById(R.id.tv_pay_method_title);
        this.f16303s.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (!TextUtils.isEmpty(CsPhoneAmountFragment.this.f16288G)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("miniCouponId", CsPhoneAmountFragment.this.f16286E);
                    hashMap.put("amount", CsPhoneAmountFragment.this.f16285D);
                    hashMap.put(ErrorConst.ModuleName.SKU, "phonerecharge");
                    hashMap.put(DiminaLaunchModel.PRODUCT_LINE, String.valueOf(605));
                    WebModel webModel = new WebModel("", UrlUtil.Companion.buildParamsUrl(CsPhoneAmountFragment.this.f16288G, hashMap));
                    Intent intent = new Intent(CsPhoneAmountFragment.this.getContext(), WalletWebActivity.class);
                    intent.putExtra(PayBaseWebActivity.EXTRA_WEB_MODEL, webModel);
                    CsPhoneAmountFragment.this.startActivityForResult(intent, 101);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
                    hashMap2.put("g_BizId", "phonebill");
                    hashMap2.put("uid", WalletCommonParamsUtil.getUID(CsPhoneAmountFragment.this.getContext()));
                    CsOmegaUtils.trackPhoneVoucherClick(hashMap2);
                }
            }
        });
    }

    /* renamed from: a */
    private void m11931a() {
        this.f16299o.setOnClickListener(new NoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                boolean d = CsPhoneAmountFragment.this.m11945b();
                CsPhoneAmountFragment.this.m11940a(d);
                if (d) {
                    FastPayUT.INSTANCE.trackFastPayBtnClk(605);
                }
            }
        });
        this.f16305u.setOnClickListener(new NoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                CsPhoneAmountFragment.this.m11940a(false);
                FastPayUT.INSTANCE.trackFastPay2CashierBtnClk(605);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11940a(boolean z) {
        CsMobileAmountAdapter csMobileAmountAdapter = this.f16298n;
        if (csMobileAmountAdapter != null && csMobileAmountAdapter.getCurrentSelectItem() != null) {
            this.f16299o.setEnabled(false);
            this.f16307w.trackOmega(0);
            CsCreateOrderBody csCreateOrderBody = new CsCreateOrderBody();
            csCreateOrderBody.phoneCountryCode = this.f16291g;
            csCreateOrderBody.phoneNumber = this.f16292h;
            csCreateOrderBody.operatorId = this.f16293i;
            csCreateOrderBody.orderType = this.f16310z;
            csCreateOrderBody.extraData = this.f16282A;
            csCreateOrderBody.fraudStatus = Boolean.valueOf(this.f16295k);
            csCreateOrderBody.useFastPay = Boolean.valueOf(z);
            CsCouponOrderBody csCouponOrderBody = new CsCouponOrderBody();
            if (this.f16283B) {
                csCouponOrderBody.couponId = this.f16286E;
                csCouponOrderBody.couponAmount = this.f16287F.couponAmount;
                csCouponOrderBody.originalAmount = this.f16287F.originalAmount;
                csCouponOrderBody.afterCouponAmount = this.f16287F.afterCouponAmount;
                csCouponOrderBody.utcOffset = this.f16287F.utcOffset;
                csCouponOrderBody.batchNo = this.f16287F.batchNo;
                csCouponOrderBody.hasCoupons = true;
            }
            this.f16307w.createPhoneRefillOrder(605, this.f16298n.getCurrentSelectItem().metadata, csCreateOrderBody, csCouponOrderBody);
        }
    }

    public void showAmountList(CsAmountListResp.DataBean dataBean) {
        if (dataBean != null) {
            this.f16289H = dataBean;
            this.f16295k = dataBean.fraudStatus.booleanValue();
            int i = 1;
            this.f16283B = dataBean.hasCoupons != null && dataBean.hasCoupons.booleanValue();
            if (dataBean.cashBackMessage != null) {
                dataBean.cashBackMessage.bindTextView(this.f16300p);
            }
            this.f16298n = new CsMobileAmountAdapter(getContext(), dataBean.items, dataBean.disabledReason, this.f16290I);
            this.f16297m.setLayoutManager(new GridLayoutManager(getContext(), 2));
            this.f16297m.setAdapter(this.f16298n);
            HashMap hashMap = new HashMap();
            if (this.f16310z != 1) {
                i = 0;
            }
            hashMap.put("order_type", Integer.valueOf(i));
            if (!(dataBean.items == null || dataBean.items.isEmpty() || dataBean.items.get(0) == null)) {
                this.f16298n.refreshSelectAmount(dataBean.items.get(0));
                this.f16284C = dataBean.items.get(0).amount;
                m11939a(dataBean.items.get(0).currencySymbol, dataBean.items.get(0).amount);
            }
            m11943b(dataBean);
            m11933a(dataBean);
            if (!(!this.f16283B || dataBean.items == null || dataBean.items.get(0) == null)) {
                String str = dataBean.items.get(0).payAmount;
                this.f16285D = str;
                this.f16307w.getVoucherDiscount(605, str);
            }
            CsOmegaUtils.trackPhoneBillAmountDisplay(hashMap);
            HashMap hashMap2 = new HashMap();
            if (this.f16283B) {
                hashMap2.put("coupon_sw", "1");
            } else {
                hashMap2.put("coupon_sw", "0");
            }
            hashMap2.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
            hashMap2.put("g_BizId", "phonebill");
            hashMap2.put("uid", WalletCommonParamsUtil.getUID(getContext()));
            CsOmegaUtils.trackPhoneVoucherShow(hashMap2);
        }
    }

    /* renamed from: a */
    private void m11933a(CsAmountListResp.DataBean dataBean) {
        if (m11945b()) {
            this.f16305u.setVisibility(0);
            this.f16306v.setText(dataBean.fastPayData.getPaymentMethodText());
            FastPayUT.INSTANCE.trackFastPayBtnShow(605);
            return;
        }
        this.f16305u.setVisibility(8);
    }

    /* renamed from: b */
    private void m11943b(CsAmountListResp.DataBean dataBean) {
        if (dataBean != null) {
            if (dataBean.hasCoupons != null && dataBean.hasCoupons.booleanValue()) {
                this.f16304t.setVisibility(0);
            } else {
                this.f16304t.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11939a(String str, String str2) {
        this.f16299o.setEnabled(true);
        if (m11945b()) {
            this.f16299o.setText(this.f16289H.fastPayData.getFastPayButtonText());
            return;
        }
        this.f16299o.setText(getString(R.string.Fintech_Payment_SKUs_Payment_Pay_GOTT, str, str2));
    }

    public void showVoucherAmount(CsVoucherResponse.DataBean dataBean) {
        this.f16287F = dataBean;
        if (dataBean.formattedCouponAmount == null || dataBean.formattedCouponAmount.isEmpty() || dataBean.afterCouponAmount < 100) {
            this.f16302r.setVisibility(0);
            this.f16301q.setVisibility(8);
            if (dataBean.isSelectNoVoucher) {
                this.f16302r.setText(R.string.Fintech_Payment_display_Do_not_irKT);
            } else {
                this.f16302r.setText(R.string.Fintech_Payment_display_No_coupon_AQlR);
            }
            this.f16286E = "";
        } else {
            this.f16302r.setVisibility(8);
            this.f16301q.setVisibility(0);
            TextView textView = this.f16301q;
            textView.setText("-R$" + dataBean.formattedCouponAmount);
            this.f16286E = dataBean.couponId;
        }
        if (dataBean.formattedAfterCouponAmount != null && dataBean.afterCouponAmount >= 100) {
            m11939a(dataBean.currencySymbol, dataBean.formattedAfterCouponAmount);
        }
        if (dataBean.couponLinkUrl != null && !dataBean.couponLinkUrl.isEmpty()) {
            this.f16288G = dataBean.couponLinkUrl;
        }
    }

    public void goToUniPay(FragmentActivity fragmentActivity, CsCreateOrderResp.DataBean dataBean) {
        this.f16299o.setEnabled(true);
        if (dataBean != null) {
            this.f16294j = dataBean.orderId;
            if (NewCashierApolloUtils.useNewCashier()) {
                m11934a(dataBean);
            } else {
                m11944b(dataBean);
            }
        }
    }

    /* renamed from: a */
    private void m11934a(final CsCreateOrderResp.DataBean dataBean) {
        CashierParam cashierParam = new CashierParam();
        cashierParam.setOutTradeId(dataBean.outTradeId);
        if (dataBean.cashierType == 1) {
            FastPayFacade.getInstance().pay((Fragment) this, 200, cashierParam);
        } else {
            CashierFacade.getInstance().launchForResult((Fragment) this, 200, cashierParam, (CashierLaunchListener) new CashierLaunchListener() {
                public void onCashierLaunch(boolean z) {
                    if (!z) {
                        CsPhoneAmountFragment.this.m11944b(dataBean);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11944b(CsCreateOrderResp.DataBean dataBean) {
        Object terminalId;
        PayParam payParam = new PayParam();
        payParam.outTradeId = dataBean.outTradeId;
        payParam.omegaAttrs = new HashMap();
        payParam.omegaAttrs.put("product_line", 605);
        CommonProxyHolder.ICommonProxy proxy = CommonProxyHolder.getProxy();
        if (!(proxy == null || (terminalId = proxy.getTerminalId(getContext())) == null)) {
            payParam.omegaAttrs.put("wallet_terminal_id", terminalId);
        }
        WalletTopUpUniPayActivity.launchInFragment(this, payParam, 100);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3;
        if (i2 == -1) {
            if (i == 200) {
                i3 = intent.getIntExtra("code", 3);
                if (!(i3 != 1 || this.f16294j == null || getActivity() == null)) {
                    getActivity().finish();
                    m11938a(this.f16294j);
                }
            } else if (i != 101) {
                i3 = intent.getIntExtra("code", 3);
                if (!(i3 != 1 || this.f16294j == null || getActivity() == null)) {
                    getActivity().finish();
                    m11938a(this.f16294j);
                }
            } else if (intent != null) {
                CsVoucherResponse csVoucherResponse = null;
                try {
                    csVoucherResponse = (CsVoucherResponse) new Gson().fromJson(intent.getStringExtra(WalletDiminaUtil.DIMINA_NATIVE_H5_CALLBACK), CsVoucherResponse.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (csVoucherResponse != null && csVoucherResponse.data != null) {
                    if (csVoucherResponse.data.couponId == null) {
                        csVoucherResponse.data.isSelectNoVoucher = true;
                    }
                    showVoucherAmount(csVoucherResponse.data);
                    return;
                }
                return;
            } else {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("exit_code", Integer.valueOf(i3));
            PayTracker.trackEvent("ibt_gp_didipay_phonebill_cashier_sdk_finished_bt", hashMap);
        }
    }

    /* renamed from: a */
    private void m11938a(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("product_line", 605);
        bundle.putString("order_id", str);
        bundle.putInt("order_type", -1);
        bundle.putInt(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, 258);
        WalletTopUpPayResultActivity.launch(getActivity(), 100, bundle);
    }

    public void onNetworkError() {
        this.f16299o.setEnabled(true);
    }

    public void showVoucherLoading() {
        this.f16302r.setVisibility(0);
        this.f16301q.setVisibility(8);
        this.f16302r.setText(R.string.Fintech_Payment_display_In_calculation_VGdP);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m11945b() {
        CsAmountListResp.DataBean dataBean = this.f16289H;
        return (dataBean == null || dataBean.fastPayData == null || !this.f16289H.fastPayData.isSupportFastPay()) ? false : true;
    }
}
