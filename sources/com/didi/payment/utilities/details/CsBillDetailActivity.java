package com.didi.payment.utilities.details;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.Consumer;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.RouterCallback;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.CashierLaunchListener;
import com.didi.global.fintech.cashier.user.facade.FastPayFacade;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGOBaseDrawerModel;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.payment.base.proxy.CommonProxyHolder;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.MathUtil;
import com.didi.payment.base.utils.NewCashierApolloUtils;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.base.utils.WalletToast;
import com.didi.payment.base.view.webview.PayBaseWebActivity;
import com.didi.payment.base.view.webview.WalletWebActivity;
import com.didi.payment.base.view.webview.WebModel;
import com.didi.payment.base.view.webview.fusion.model.UrlUtil;
import com.didi.payment.base.web.WalletDiminaUtil;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.fastpay.FastPayData;
import com.didi.payment.commonsdk.fastpay.FastPayUT;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.creditcard.global.omega.GlobalOmegaConstant;
import com.didi.payment.creditcard.global.widget.NoDoubleClickListener;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.utilities.CsInputFilter;
import com.didi.payment.utilities.base.CsBaseActivity;
import com.didi.payment.utilities.base.CsNetModel;
import com.didi.payment.utilities.base.CsOmegaUtils;
import com.didi.payment.utilities.base.CsRouter;
import com.didi.payment.utilities.resp.BoletoBillLimitRiskDetailVo;
import com.didi.payment.utilities.resp.CsAccountStatus;
import com.didi.payment.utilities.resp.CsCashbackResp;
import com.didi.payment.utilities.resp.CsCouponResp;
import com.didi.payment.utilities.resp.CsCreateOrderResp;
import com.didi.payment.utilities.resp.CsGetBillResp;
import com.didi.payment.utilities.resp.CsOrderCashbackModel;
import com.didi.payment.utilities.resp.CsOrderCouponModel;
import com.didi.payment.wallet.global.model.NightlyLimitSettingModel;
import com.didi.payment.wallet.global.model.resp.GetNightlyLimitResp;
import com.didi.payment.wallet.global.omega.GlobalOmegaConstant;
import com.didi.payment.wallet.global.risk.LimitRiskReminderHandler;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpUniPayActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.wallet.dimina.DiminaLaunchModel;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.pay.paysecure.omega.OmegaUtilKt;
import com.google.gson.Gson;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;

public class CsBillDetailActivity extends CsBaseActivity {
    public static final String PARAM_FROM = "param_from";

    /* renamed from: V */
    private static final int f31551V = 101;

    /* renamed from: a */
    private static final int f31552a = 100;

    /* renamed from: b */
    private static final String f31553b = "param_key";

    /* renamed from: c */
    private static final String f31554c = "param_barcode";

    /* renamed from: A */
    private TextView f31555A;

    /* renamed from: B */
    private ConstraintLayout f31556B;

    /* renamed from: C */
    private ConstraintLayout f31557C;

    /* renamed from: D */
    private TextView f31558D;

    /* renamed from: E */
    private TextView f31559E;

    /* renamed from: F */
    private TextView f31560F;

    /* renamed from: G */
    private TextView f31561G;

    /* renamed from: H */
    private TextView f31562H;

    /* renamed from: I */
    private TextView f31563I;

    /* renamed from: J */
    private TextView f31564J;

    /* renamed from: K */
    private TextView f31565K;

    /* renamed from: L */
    private LinearLayout f31566L;

    /* renamed from: M */
    private LinearLayout f31567M;

    /* renamed from: N */
    private LinearLayout f31568N;

    /* renamed from: O */
    private Boolean f31569O = false;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public LEGODrawer f31570P;

    /* renamed from: Q */
    private LimitRiskReminderHandler f31571Q = new LimitRiskReminderHandler();
    /* access modifiers changed from: private */

    /* renamed from: R */
    public boolean f31572R;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public String f31573S;

    /* renamed from: T */
    private NightlyLimitSettingModel f31574T;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public GetNightlyLimitResp.NightlyLimitVo f31575U;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CsGetBillResp.Data f31576d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f31577e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CsCreateOrderResp.DataBean f31578f;

    /* renamed from: g */
    private CsCouponResp.CsCouponData f31579g;

    /* renamed from: h */
    private String f31580h;

    /* renamed from: i */
    private String f31581i;

    /* renamed from: j */
    private boolean f31582j = true;

    /* renamed from: k */
    private boolean f31583k = false;

    /* renamed from: l */
    private boolean f31584l;

    /* renamed from: m */
    private int f31585m;

    /* renamed from: n */
    private int f31586n;

    /* renamed from: o */
    private View f31587o;

    /* renamed from: p */
    private TextView f31588p;

    /* renamed from: q */
    private TextView f31589q;

    /* renamed from: r */
    private TextView f31590r;

    /* renamed from: s */
    private TextView f31591s;

    /* renamed from: t */
    private TextView f31592t;

    /* renamed from: u */
    private TextView f31593u;

    /* renamed from: v */
    private View f31594v;

    /* renamed from: w */
    private View f31595w;

    /* renamed from: x */
    private LinearLayout f31596x;

    /* renamed from: y */
    private TextView f31597y;

    /* renamed from: z */
    private TextView f31598z;

    /* renamed from: a */
    private boolean m22311a(long j, long j2) {
        return j2 < 0 || j <= j2;
    }

    public static void startActivity(CsGetBillResp csGetBillResp, Context context, String str) {
        Intent intent = new Intent(context, CsBillDetailActivity.class);
        intent.putExtra(f31553b, csGetBillResp);
        intent.putExtra(PARAM_FROM, str);
        context.startActivity(intent);
    }

    public static void startActivity(String str, Context context) {
        Intent intent = new Intent(context, CsBillDetailActivity.class);
        intent.putExtra(f31554c, str);
        context.startActivity(intent);
    }

    public static void startActivity(String str, Context context, String str2) {
        Intent intent = new Intent(context, CsBillDetailActivity.class);
        intent.putExtra(f31554c, str);
        intent.putExtra(PARAM_FROM, str2);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.cs_activity_bill_details_layout);
        m22315b();
        m22319c();
        m22327e();
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f31572R) {
            m22344m();
            this.f31572R = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22292a() {
        CsGetBillResp csGetBillResp = (CsGetBillResp) getIntent().getSerializableExtra(f31553b);
        HashMap hashMap = new HashMap();
        String stringExtra = getIntent().getStringExtra(PARAM_FROM);
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f31573S = stringExtra;
        } else if (csGetBillResp == null || csGetBillResp.data == null) {
            this.f31573S = "auto_scan";
        } else {
            this.f31573S = GlobalOmegaConstant.AddCardPage.EventKey.MANUAL_INPUT;
        }
        hashMap.put("boleto_recognize_success_from", this.f31573S);
        CsGetBillResp.Data data = this.f31576d;
        hashMap.put("boleto_code", data == null ? "" : data.barCode);
        PayTracker.trackEvent("ibt_gp_didipay_lifebill_detailsuccess_sw", hashMap);
    }

    /* renamed from: b */
    private void m22315b() {
        initProgressDialog(this, R.id.pay_result_title_bar);
        this.f31587o = findViewById(R.id.pay_result_back_btn);
        this.f31588p = (TextView) findViewById(R.id.pay_result_card_desc_content);
        this.f31589q = (TextView) findViewById(R.id.pay_result_card_time_content);
        this.f31590r = (TextView) findViewById(R.id.pay_result_card_number_title);
        this.f31591s = (TextView) findViewById(R.id.pay_result_card_number_content);
        this.f31592t = (TextView) findViewById(R.id.pay_result_amount_price_tv);
        this.f31593u = (TextView) findViewById(R.id.pay_result_amount_symbol_tv);
        this.f31563I = (TextView) findViewById(R.id.cs_bill_details_btn);
        this.f31594v = findViewById(R.id.sv_bill_details_content);
        this.f31595w = findViewById(R.id.ll_bill_details_empty);
        this.f31596x = (LinearLayout) findViewById(R.id.cs_bill_bottom_tip_layout);
        this.f31597y = (TextView) findViewById(R.id.cs_bill_bottom_tip);
        this.f31598z = (TextView) findViewById(R.id.tv_night_limit);
        this.f31555A = (TextView) findViewById(R.id.tv_month_limit_info);
        this.f31556B = (ConstraintLayout) findViewById(R.id.boleto_coupon_container);
        this.f31557C = (ConstraintLayout) findViewById(R.id.container_coupon_more);
        this.f31558D = (TextView) findViewById(R.id.tv_coupon_amount);
        this.f31559E = (TextView) findViewById(R.id.tv_coupon_no_select);
        this.f31564J = (TextView) findViewById(R.id.boleto_bill_fastpay_btn);
        this.f31565K = (TextView) findViewById(R.id.tv_pay_method_title);
        this.f31566L = (LinearLayout) findViewById(R.id.ll_switch_pay_method_container);
        this.f31567M = (LinearLayout) findViewById(R.id.boleto_bill_fastpay_container);
        this.f31568N = (LinearLayout) findViewById(R.id.cs_bill_bottom_container);
        this.f31598z.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put(OmegaUtilKt.ENTRANCE_PAGE_ID, "boleto_page_id");
                hashMap.put("beyond_limit_amount", Double.valueOf(CsBillDetailActivity.this.f31576d.amountInDouble));
                PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_boleto_page_ck", hashMap);
                if (CsBillDetailActivity.this.f31575U == null || !TextUtils.isEmpty(CsBillDetailActivity.this.f31575U.effectiveTime)) {
                    DRouter.build("99pay://one/nightly_limit_result").start(CsBillDetailActivity.this);
                } else {
                    ((Request) DRouter.build("99pay://one/nightly_limit_setting").putExtra("pageFrom", "boleto_page_id")).start(CsBillDetailActivity.this, new RouterCallback.ActivityCallback() {
                        public void onActivityResult(int i, Intent intent) {
                            if (i == -1) {
                                CsBillDetailActivity.this.m22340j();
                                String str = null;
                                if (intent != null) {
                                    str = intent.getStringExtra("effectiveTime");
                                }
                                if (!TextUtils.isEmpty(str)) {
                                    CsBillDetailActivity.this.f31575U.effectiveTime = str;
                                    CsBillDetailActivity.this.m22342k();
                                }
                            }
                        }
                    });
                }
            }
        });
        this.f31555A.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                BoletoBillLimitRiskDetailVo boletoBillLimitRiskDetailVo;
                if (CsBillDetailActivity.this.f31576d != null && (boletoBillLimitRiskDetailVo = CsBillDetailActivity.this.f31576d.limitRiskDetail) != null) {
                    DRouter.build(boletoBillLimitRiskDetailVo.link).start(CsBillDetailActivity.this);
                }
            }
        });
        this.f31587o.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CsBillDetailActivity.this.onBackPressed();
            }
        });
        this.f31595w.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CsBillDetailActivity.this.m22331f();
            }
        });
        this.f31557C.setOnClickListener(new NoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                CsBillDetailActivity.this.m22323d();
            }
        });
        TextView textView = (TextView) findViewById(R.id.bill_origin_price);
        this.f31560F = textView;
        textView.getPaint().setFlags(16);
        this.f31561G = (TextView) findViewById(R.id.pay_result_card_cashback_title);
        this.f31562H = (TextView) findViewById(R.id.pay_result_card_cashback_amount);
    }

    /* renamed from: c */
    private void m22319c() {
        this.f31563I.setOnClickListener(new NoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                CsBillDetailActivity.this.payOrder(false);
            }
        });
        this.f31566L.setOnClickListener(new NoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                CsBillDetailActivity.this.payOrder(false);
                FastPayUT.INSTANCE.trackFastPay2CashierBtnClk(606);
            }
        });
        this.f31564J.setOnClickListener(new NoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                CsBillDetailActivity.this.payOrder(true);
                FastPayUT.INSTANCE.trackFastPayBtnClk(606);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m22323d() {
        if (!TextUtils.isEmpty(this.f31580h)) {
            HashMap hashMap = new HashMap();
            hashMap.put("miniCouponId", this.f31581i);
            hashMap.put("amount", String.valueOf(this.f31576d.amountInDouble));
            hashMap.put(ErrorConst.ModuleName.SKU, "bill");
            hashMap.put(DiminaLaunchModel.PRODUCT_LINE, String.valueOf(606));
            WebModel webModel = new WebModel("", UrlUtil.Companion.buildParamsUrl(this.f31580h, hashMap));
            Intent intent = new Intent(this, WalletWebActivity.class);
            intent.putExtra(PayBaseWebActivity.EXTRA_WEB_MODEL, webModel);
            startActivityForResult(intent, 101);
            CsOmegaUtils.trackBoletoCouponCk(WalletCommonParamsUtil.getUID(getContext()));
        }
    }

    /* renamed from: e */
    private void m22327e() {
        this.f31574T = new NightlyLimitSettingModel(this);
        CsGetBillResp csGetBillResp = (CsGetBillResp) getIntent().getSerializableExtra(f31553b);
        if (csGetBillResp == null || csGetBillResp.data == null) {
            m22331f();
            return;
        }
        m22318b(csGetBillResp);
        m22292a();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m22331f() {
        String stringExtra = getIntent().getStringExtra(f31554c);
        if (!TextUtils.isEmpty(stringExtra)) {
            String removeNonNumber = CsInputFilter.removeNonNumber(stringExtra);
            showLoadingDialog();
            CsNetModel.getIns(this).getBillInfo(606, removeNonNumber, new RpcService.Callback<CsGetBillResp>() {
                public void onSuccess(CsGetBillResp csGetBillResp) {
                    CsBillDetailActivity.this.m22304a(csGetBillResp);
                    CsBillDetailActivity.this.m22292a();
                }

                public void onFailure(IOException iOException) {
                    CsBillDetailActivity.this.m22304a((CsGetBillResp) null);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22304a(CsGetBillResp csGetBillResp) {
        dismissLoadingDialog();
        if (csGetBillResp == null || csGetBillResp.errno != 0 || csGetBillResp.data == null) {
            if (!(csGetBillResp == null || csGetBillResp.errno == 0 || TextUtils.isEmpty(csGetBillResp.errmsg))) {
                WalletToast.showFailedMsg(this, csGetBillResp.errmsg);
            }
            m22333g();
            return;
        }
        m22318b(csGetBillResp);
    }

    /* renamed from: g */
    private void m22333g() {
        this.f31595w.setVisibility(0);
        this.f31594v.setVisibility(8);
        this.f31568N.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m22335h() {
        this.f31595w.setVisibility(8);
        this.f31594v.setVisibility(0);
        this.f31568N.setVisibility(0);
        m22338i();
    }

    /* renamed from: b */
    private void m22318b(CsGetBillResp csGetBillResp) {
        this.f31576d = csGetBillResp.data;
        m22307a(String.valueOf(csGetBillResp.data.amountInDouble), "", false, "0");
        this.f31588p.setText(this.f31576d.barCode);
        this.f31589q.setText(this.f31576d.payee);
        if (!TextUtils.isEmpty(this.f31576d.dueDate)) {
            this.f31590r.setVisibility(0);
            this.f31591s.setVisibility(0);
            this.f31591s.setText(this.f31576d.dueDate);
        } else {
            this.f31590r.setVisibility(8);
            this.f31591s.setVisibility(8);
        }
        this.f31592t.setText(this.f31576d.amount);
        this.f31593u.setText(this.f31576d.currencySymbol);
        if (!TextUtils.isEmpty(this.f31576d.cashBack)) {
            this.f31596x.setVisibility(0);
            this.f31597y.setText(this.f31576d.cashBack);
        } else {
            this.f31596x.setVisibility(8);
        }
        m22340j();
        if (!TextUtils.isEmpty(this.f31576d.currencySymbol) && !TextUtils.isEmpty(this.f31576d.amount)) {
            this.f31563I.setText(String.format(getString(R.string.Fintech_Payment_SKUs_Payment_Pay_GOTT), new Object[]{this.f31576d.currencySymbol, this.f31576d.amount}));
        }
        FastPayData fastPayData = this.f31576d.fastPayData;
        if (fastPayData != null && !TextUtils.isEmpty(fastPayData.getPaymentMethodText())) {
            this.f31565K.setText(fastPayData.getPaymentMethodText());
            this.f31564J.setText(fastPayData.getFastPayButtonText());
        }
    }

    /* renamed from: i */
    private void m22338i() {
        if (m22345n()) {
            this.f31563I.setVisibility(8);
            this.f31567M.setVisibility(0);
            FastPayUT.INSTANCE.trackFastPayBtnShow(606);
            return;
        }
        this.f31563I.setVisibility(0);
        this.f31567M.setVisibility(8);
    }

    /* renamed from: a */
    private void m22307a(String str, String str2, final boolean z, String str3) {
        CsNetModel.getIns(this).getCouponData(606, str, str2, str3, new RpcService.Callback<CsCashbackResp>() {
            public void onSuccess(CsCashbackResp csCashbackResp) {
                if (csCashbackResp == null) {
                    WalletToast.showFailedMsg(CsBillDetailActivity.this.getContext(), CsBillDetailActivity.this.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                } else if (csCashbackResp.data == null || csCashbackResp.errno != 0) {
                    WalletToast.showFailedMsg(CsBillDetailActivity.this.getContext(), csCashbackResp.errmsg);
                } else {
                    CsBillDetailActivity.this.m22301a(csCashbackResp.data, z);
                }
            }

            public void onFailure(IOException iOException) {
                WalletToast.showFailedMsg(CsBillDetailActivity.this.getContext(), CsBillDetailActivity.this.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22301a(CsCashbackResp.DataBean dataBean, boolean z) {
        if (dataBean.couponData != null && !z) {
            CsCouponResp.CsCouponData csCouponData = new CsCouponResp.CsCouponData();
            csCouponData.couponId = dataBean.couponData.couponId;
            if (dataBean.couponData.couponAmountFormatted != null) {
                csCouponData.formattedCouponAmount = dataBean.couponData.couponAmountFormatted.value;
            }
            if (dataBean.totalAmountFormatted != null && !TextUtils.isEmpty(dataBean.totalAmountFormatted.value)) {
                csCouponData.formattedOriginalAmount = dataBean.totalAmountFormatted.value;
            }
            if (dataBean.couponData.afterCouponAmountFormatted != null) {
                csCouponData.formattedAfterCouponAmount = dataBean.couponData.afterCouponAmountFormatted.value;
                csCouponData.currencySymbol = dataBean.couponData.afterCouponAmountFormatted.symbol;
            }
            csCouponData.couponAmount = dataBean.couponData.couponAmount;
            csCouponData.originalAmount = dataBean.totalAmountFen;
            csCouponData.afterCouponAmount = dataBean.payAmountFen;
            csCouponData.hasCoupons = true;
            csCouponData.batchNo = dataBean.couponData.batchNo;
            csCouponData.utcOffset = dataBean.couponData.utcOffset;
            csCouponData.couponLinkUrl = dataBean.couponLinkUrl;
            m22302a(csCouponData);
        }
        m22300a(dataBean.cashbackData);
        String str = "";
        String str2 = (dataBean.cashbackData == null || dataBean.cashbackData.cashbackAmountFormatted == null || TextUtils.isEmpty(dataBean.cashbackData.cashbackAmountFormatted.value)) ? str : dataBean.cashbackData.cashbackAmountFormatted.value;
        if (this.f31582j) {
            this.f31582j = false;
            Intent intent = getIntent();
            if (!(intent == null || intent.getStringExtra(PARAM_FROM) == null)) {
                str = intent.getStringExtra(PARAM_FROM);
            }
            CsOmegaUtils.trackBoletoCouponSw(this.f31584l, WalletCommonParamsUtil.getUID(getContext()), this.f31583k, str2, str);
        }
    }

    /* renamed from: a */
    private void m22300a(CsCashbackResp.CashBackData cashBackData) {
        if (cashBackData == null || TextUtils.isEmpty(cashBackData.cashbackDisplay)) {
            this.f31585m = 0;
            this.f31561G.setVisibility(8);
            this.f31562H.setVisibility(8);
            return;
        }
        this.f31585m = cashBackData.cashbackAmount;
        this.f31586n = cashBackData.activityId;
        this.f31583k = true;
        this.f31561G.setVisibility(0);
        this.f31562H.setVisibility(0);
        this.f31562H.setText(cashBackData.cashbackDisplay);
    }

    /* renamed from: a */
    private void m22302a(CsCouponResp.CsCouponData csCouponData) {
        this.f31579g = csCouponData;
        if (csCouponData.hasCoupons) {
            this.f31556B.setVisibility(0);
            this.f31584l = csCouponData.hasCoupons;
        }
        if (!TextUtils.isEmpty(this.f31579g.couponLinkUrl)) {
            this.f31580h = this.f31579g.couponLinkUrl;
        }
        if (csCouponData.couponId == null || csCouponData.couponId.isEmpty()) {
            this.f31558D.setVisibility(8);
            this.f31559E.setVisibility(0);
            this.f31560F.setVisibility(8);
            if (csCouponData.isSelectNoVoucher) {
                this.f31559E.setText(getString(R.string.Fintech_Payment_display_Do_not_irKT));
                this.f31592t.setText(this.f31576d.amount);
                CsGetBillResp.Data data = this.f31576d;
                if (data == null || data.limitRiskDetail == null || TextUtils.isEmpty(this.f31576d.limitRiskDetail.payButtonText)) {
                    this.f31563I.setText(String.format(getString(R.string.Fintech_Payment_SKUs_Payment_Pay_GOTT), new Object[]{this.f31576d.currencySymbol, this.f31576d.amount}));
                }
            } else {
                this.f31559E.setText(getString(R.string.Fintech_Payment_display_No_coupon_AQlR));
            }
            this.f31581i = "";
            return;
        }
        this.f31558D.setVisibility(0);
        this.f31559E.setVisibility(8);
        this.f31560F.setVisibility(0);
        if (!TextUtils.isEmpty(csCouponData.formattedCouponAmount)) {
            this.f31558D.setText(String.format(getString(R.string.Fintech_Payment_Coupon_Amount), new Object[]{csCouponData.currencySymbol, csCouponData.formattedCouponAmount}));
        }
        this.f31581i = csCouponData.couponId;
        if (!TextUtils.isEmpty(csCouponData.formattedOriginalAmount)) {
            this.f31560F.setText(String.format(getString(R.string.Fintech_Payment_Amount), new Object[]{csCouponData.currencySymbol, csCouponData.formattedOriginalAmount}));
        }
        if (!TextUtils.isEmpty(csCouponData.formattedAfterCouponAmount)) {
            this.f31592t.setText(csCouponData.formattedAfterCouponAmount);
            CsGetBillResp.Data data2 = this.f31576d;
            if (data2 == null || data2.limitRiskDetail == null || TextUtils.isEmpty(this.f31576d.limitRiskDetail.payButtonText)) {
                this.f31563I.setText(String.format(getString(R.string.Fintech_Payment_SKUs_Payment_Pay_GOTT), new Object[]{csCouponData.currencySymbol, csCouponData.formattedAfterCouponAmount}));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m22340j() {
        showLoadingDialog();
        this.f31574T.getNightlyLimit(606, new RpcService.Callback<GetNightlyLimitResp>() {
            public void onSuccess(GetNightlyLimitResp getNightlyLimitResp) {
                CsBillDetailActivity.this.dismissLoadingDialog();
                if (getNightlyLimitResp.errno == 0 && getNightlyLimitResp.data != null) {
                    GetNightlyLimitResp.NightlyLimitVo unused = CsBillDetailActivity.this.f31575U = getNightlyLimitResp.data;
                    CsBillDetailActivity.this.m22342k();
                }
                CsBillDetailActivity.this.m22335h();
            }

            public void onFailure(IOException iOException) {
                CsBillDetailActivity.this.dismissLoadingDialog();
                GetNightlyLimitResp.NightlyLimitVo unused = CsBillDetailActivity.this.f31575U = null;
                CsBillDetailActivity.this.m22342k();
                CsBillDetailActivity.this.m22335h();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m22342k() {
        BoletoBillLimitRiskDetailVo boletoBillLimitRiskDetailVo;
        boolean z;
        long j;
        String str;
        long j2;
        CsGetBillResp.Data data = this.f31576d;
        if (data != null) {
            j = (long) MathUtil.dollarToCent(data.amountInDouble);
            BoletoBillLimitRiskDetailVo boletoBillLimitRiskDetailVo2 = this.f31576d.limitRiskDetail;
            z = this.f31576d.isNightLimitHit;
            boletoBillLimitRiskDetailVo = boletoBillLimitRiskDetailVo2;
        } else {
            j = 0;
            z = false;
            boletoBillLimitRiskDetailVo = null;
        }
        long j3 = j;
        GetNightlyLimitResp.NightlyLimitVo nightlyLimitVo = this.f31575U;
        if (nightlyLimitVo == null || !z) {
            str = null;
            j2 = -1;
        } else {
            j2 = nightlyLimitVo.remainingLimit;
            str = this.f31575U.effectiveTime;
        }
        m22293a(j3, j2, str, boletoBillLimitRiskDetailVo);
    }

    /* renamed from: a */
    private void m22293a(long j, long j2, String str, BoletoBillLimitRiskDetailVo boletoBillLimitRiskDetailVo) {
        String str2;
        long j3;
        String str3 = null;
        if (boletoBillLimitRiskDetailVo != null) {
            str3 = boletoBillLimitRiskDetailVo.payButtonText;
            j3 = boletoBillLimitRiskDetailVo.riskLimitQuota;
            str2 = boletoBillLimitRiskDetailVo.description;
        } else {
            j3 = -1;
            str2 = null;
        }
        this.f31569O = false;
        if (m22311a(j, j3) || TextUtils.isEmpty(str3)) {
            this.f31555A.setVisibility(8);
        } else {
            this.f31563I.setText(str3);
            this.f31555A.setText(str2);
            this.f31555A.setVisibility(TextUtils.isEmpty(str2) ? 8 : 0);
            this.f31569O = true;
        }
        if (m22311a(j, j2)) {
            this.f31563I.setEnabled(true);
            this.f31598z.setVisibility(8);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f31598z.setText(R.string.GRider_limit_Beyond_the_GuvV);
        } else {
            this.f31598z.setText(R.string.GRider_2_When_the_QyBM);
        }
        this.f31598z.setVisibility(0);
        CsCouponResp.CsCouponData csCouponData = this.f31579g;
        if (csCouponData == null || TextUtils.isEmpty(csCouponData.formattedAfterCouponAmount)) {
            this.f31563I.setText(String.format(getString(R.string.Fintech_Payment_SKUs_Payment_Pay_GOTT), new Object[]{this.f31576d.currencySymbol, this.f31576d.amount}));
        } else {
            this.f31563I.setText(String.format(getString(R.string.Fintech_Payment_SKUs_Payment_Pay_GOTT), new Object[]{this.f31579g.currencySymbol, this.f31579g.formattedAfterCouponAmount}));
        }
        this.f31555A.setVisibility(8);
        HashMap hashMap = new HashMap();
        hashMap.put(OmegaUtilKt.ENTRANCE_PAGE_ID, "boleto_page_id");
        hashMap.put("beyond_limit_amount", Double.valueOf(this.f31576d.amountInDouble));
        PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_boleto_page_bt", hashMap);
        this.f31563I.setEnabled(false);
        this.f31569O = true;
    }

    public void payOrder(boolean z) {
        m22310a(z);
        String str = this.f31573S;
        CsGetBillResp.Data data = this.f31576d;
        CsOmegaUtils.trackConfirmBtnClicked("detailsuccess", str, data == null ? "" : data.barCode);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22303a(final CsCreateOrderResp.DataBean dataBean) {
        if (dataBean != null) {
            this.f31571Q.show(dataBean.limitRiskReminder, this, GlobalOmegaConstant.SkuRiskLimit.PUB_PAGE_BOLETO_BILL_DETAIL, 606, new Consumer<Integer>() {
                public void accept(Integer num) {
                    if (num.intValue() != 1) {
                        CsCreateOrderResp.DataBean unused = CsBillDetailActivity.this.f31578f = null;
                    } else if (!TextUtils.isEmpty(dataBean.outTradeId)) {
                        CsBillDetailActivity.this.m22317b(dataBean);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m22317b(CsCreateOrderResp.DataBean dataBean) {
        if (NewCashierApolloUtils.useNewCashier()) {
            m22322c(dataBean);
        } else {
            m22325d(dataBean);
        }
    }

    /* renamed from: c */
    private void m22322c(final CsCreateOrderResp.DataBean dataBean) {
        CashierParam cashierParam = new CashierParam();
        cashierParam.setOutTradeId(dataBean.outTradeId);
        if (dataBean.cashierType == 1) {
            FastPayFacade.getInstance().pay((Activity) this, 200, cashierParam);
        } else {
            CashierFacade.getInstance().launchForResult((Activity) this, 200, cashierParam, (CashierLaunchListener) new CashierLaunchListener() {
                public void onCashierLaunch(boolean z) {
                    if (!z) {
                        CsBillDetailActivity.this.m22325d(dataBean);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m22325d(CsCreateOrderResp.DataBean dataBean) {
        Object terminalId;
        PayParam payParam = new PayParam();
        payParam.outTradeId = dataBean.outTradeId;
        payParam.omegaAttrs = new HashMap();
        payParam.omegaAttrs.put("product_line", 606);
        CommonProxyHolder.ICommonProxy proxy = CommonProxyHolder.getProxy();
        if (!(proxy == null || (terminalId = proxy.getTerminalId(getContext())) == null)) {
            payParam.omegaAttrs.put("wallet_terminal_id", terminalId);
        }
        WalletTopUpUniPayActivity.launch(this, payParam, 100);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22310a(final boolean z) {
        showLoadingDialog();
        CsOrderCouponModel csOrderCouponModel = new CsOrderCouponModel();
        if (this.f31584l) {
            csOrderCouponModel.couponId = this.f31581i;
            csOrderCouponModel.couponAmount = this.f31579g.couponAmount;
            csOrderCouponModel.originalAmount = this.f31579g.originalAmount;
            csOrderCouponModel.afterCouponAmount = this.f31579g.afterCouponAmount;
            csOrderCouponModel.utcOffset = this.f31579g.utcOffset;
            csOrderCouponModel.batchNo = this.f31579g.batchNo;
            csOrderCouponModel.hasCoupons = "true";
        }
        CsOrderCashbackModel csOrderCashbackModel = new CsOrderCashbackModel();
        if (this.f31585m > 0) {
            csOrderCashbackModel.activityId = String.valueOf(this.f31586n);
            csOrderCashbackModel.cashbackAmount = this.f31585m;
        }
        CsNetModel.getIns(this).createUtilitiesOrder(606, this.f31576d.metadata, this.f31576d.bizContent, Boolean.valueOf(z), csOrderCouponModel, csOrderCashbackModel, new RpcService.Callback<CsCreateOrderResp>() {
            public void onSuccess(CsCreateOrderResp csCreateOrderResp) {
                if (csCreateOrderResp == null) {
                    CsBillDetailActivity.this.dismissLoadingDialog();
                    return;
                }
                KycOmega.Companion.fin_tech_wallet_http_req_lite_en(csCreateOrderResp.errno, csCreateOrderResp.errmsg, "/v0/didipay/order");
                if (csCreateOrderResp.errno == 0 && csCreateOrderResp.data != null) {
                    CsBillDetailActivity.this.dismissLoadingDialog();
                    String unused = CsBillDetailActivity.this.f31577e = csCreateOrderResp.data.orderId;
                    CsCreateOrderResp.DataBean unused2 = CsBillDetailActivity.this.f31578f = csCreateOrderResp.data;
                    if (!CsBillDetailActivity.this.m22330e(csCreateOrderResp.data)) {
                        CsBillDetailActivity.this.m22317b(csCreateOrderResp.data);
                    }
                    CsCreateOrderResp.ToastInfo toastInfo = csCreateOrderResp.data.toastInfo;
                    if (toastInfo != null && toastInfo.isErrorToast()) {
                        ToastHelper.showShortInfo((Context) CsBillDetailActivity.this, toastInfo.message, (int) R.drawable.wallet_toast_icon_fail);
                    }
                } else if (csCreateOrderResp.errno == 30108 && csCreateOrderResp.data != null) {
                    CsBillDetailActivity.this.m22303a(csCreateOrderResp.data);
                    CsBillDetailActivity.this.dismissLoadingDialog();
                } else if (csCreateOrderResp.errno == 60104) {
                    if (csCreateOrderResp.data != null) {
                        CsBillDetailActivity.this.m22309a(csCreateOrderResp.data.orderId, z, csCreateOrderResp.errmsg);
                    }
                    CsBillDetailActivity.this.dismissLoadingDialog();
                } else if (!TextUtils.isEmpty(csCreateOrderResp.errmsg)) {
                    WalletToast.showFailedMsg(CsBillDetailActivity.this.getContext(), csCreateOrderResp.errmsg);
                    CsBillDetailActivity.this.dismissLoadingDialog();
                } else {
                    WalletToast.showFailedMsg(CsBillDetailActivity.this.getContext(), CsBillDetailActivity.this.getString(R.string.pay_base_network_error));
                    CsBillDetailActivity.this.dismissLoadingDialog();
                }
            }

            public void onFailure(IOException iOException) {
                CsBillDetailActivity.this.dismissLoadingDialog();
                WalletToast.showFailedMsg(CsBillDetailActivity.this.getContext(), CsBillDetailActivity.this.getString(R.string.pay_base_network_error));
                KycOmega.Companion.fin_tech_wallet_http_req_lite_en(-11, "", "/v0/didipay/order");
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        dismissLoadingDialog();
        if (i2 != -1) {
            return;
        }
        if (i == 100) {
            if (intent.getIntExtra("code", 3) == 1) {
                m22343l();
            }
        } else if (i == 200) {
            if (intent.getIntExtra("code", 3) == 1) {
                m22343l();
            }
        } else if (i == 101 && intent != null && !TextUtils.isEmpty(intent.getStringExtra(WalletDiminaUtil.DIMINA_NATIVE_H5_CALLBACK))) {
            m22305a(intent.getStringExtra(WalletDiminaUtil.DIMINA_NATIVE_H5_CALLBACK));
        }
    }

    /* renamed from: a */
    private void m22305a(String str) {
        CsCouponResp csCouponResp;
        try {
            csCouponResp = (CsCouponResp) new Gson().fromJson(str, CsCouponResp.class);
        } catch (Exception e) {
            e.printStackTrace();
            csCouponResp = null;
        }
        if (csCouponResp != null && csCouponResp.data != null) {
            if (csCouponResp.data.couponId == null) {
                csCouponResp.data.isSelectNoVoucher = true;
            }
            m22302a(csCouponResp.data);
            String valueOf = String.valueOf(this.f31576d.amountInDouble);
            String str2 = this.f31581i;
            m22307a(valueOf, str2, true, TextUtils.isEmpty(str2) ? "1" : "0");
        }
    }

    /* renamed from: l */
    private void m22343l() {
        finish();
        CsRouter.startPayResultActivity(this, 606, this.f31577e, -1);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m22330e(final CsCreateOrderResp.DataBean dataBean) {
        boolean z = false;
        if (!(dataBean == null || dataBean.extraInfo == null || dataBean.extraInfo.prePayDialogInfo == null || dataBean.extraInfo.accountInfo == null)) {
            CsCreateOrderResp.PrePayDialogInfo prePayDialogInfo = dataBean.extraInfo.prePayDialogInfo;
            boolean isNewPayMethodListEnable = WalletApolloUtil.isNewPayMethodListEnable();
            String str = prePayDialogInfo.title;
            String str2 = prePayDialogInfo.posBtnText;
            String str3 = prePayDialogInfo.negBtnText;
            if (isNewPayMethodListEnable) {
                if (!TextUtil.isEmpty(prePayDialogInfo.newTitle)) {
                    str = prePayDialogInfo.newTitle;
                }
                if (!TextUtil.isEmpty(prePayDialogInfo.newPosBtnText)) {
                    str2 = prePayDialogInfo.newPosBtnText;
                }
                if (!TextUtil.isEmpty(prePayDialogInfo.newNegBtnText)) {
                    str3 = prePayDialogInfo.newNegBtnText;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                if (this.f31570P != null && this.f31570P.isShowing()) {
                    this.f31570P.dismiss();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (2 == dataBean.extraInfo.accountStatus || 3 == dataBean.extraInfo.accountStatus) {
                str = getString(R.string.GRider_reminder_In_the_cnSS);
                str2 = getString(R.string.GRider_reminder_I_see_YkJW);
                m22306a(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_NO_KYC_PENDING_SW, dataBean);
            } else if (dataBean.extraInfo.prePayDialogInfo.canUseOtherPay) {
                m22306a("ibt_gp_didipay_not_gen_boleto_sw", dataBean);
            } else {
                m22306a(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_NO_KYC_GEN_BOLETO_SW, dataBean);
            }
            z = true;
            LEGOBaseDrawerModel isShowCloseImg = new LEGODrawerModel1(str, new LEGOBtnTextAndCallback(str2, new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (CsBillDetailActivity.this.f31570P != null && CsBillDetailActivity.this.f31570P.isShowing()) {
                        CsBillDetailActivity.this.f31570P.dismiss();
                    }
                    if (2 == dataBean.extraInfo.accountStatus || 3 == dataBean.extraInfo.accountStatus) {
                        CsBillDetailActivity.this.finish();
                        return;
                    }
                    if (dataBean.extraInfo.prePayDialogInfo.canUseOtherPay) {
                        CsBillDetailActivity.this.m22306a("ibt_gp_didipay_not_gen_boleto_pk_didi_ck", dataBean);
                    } else {
                        CsBillDetailActivity.this.m22306a(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_NO_KYC_SIGNUP_CK, dataBean);
                    }
                    CsRouter.gotoAccountStatusPage(CsBillDetailActivity.this, dataBean);
                    boolean unused = CsBillDetailActivity.this.f31572R = true;
                }
            })).setIsShowCloseImg(true);
            if (dataBean.extraInfo.accountStatus == 0) {
                isShowCloseImg.addMinorBtn(new LEGOBtnTextAndCallback(str3, new LEGOOnAntiShakeClickListener() {
                    public void onAntiShakeClick(View view) {
                        if (CsBillDetailActivity.this.f31570P != null && CsBillDetailActivity.this.f31570P.isShowing()) {
                            CsBillDetailActivity.this.f31570P.dismiss();
                        }
                        if (dataBean.extraInfo.prePayDialogInfo.canUseOtherPay) {
                            CsBillDetailActivity.this.m22306a("ibt_gp_didipay_not_gen_boleto_pk_other_ck", dataBean);
                            CsBillDetailActivity.this.m22303a(dataBean);
                            return;
                        }
                        CsBillDetailActivity.this.m22306a(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_NO_KYC_GOT_IT_CK, dataBean);
                    }
                }));
            }
            if (!TextUtils.isEmpty(dataBean.extraInfo.prePayDialogInfo.subTitle)) {
                isShowCloseImg.setSubTitle(dataBean.extraInfo.prePayDialogInfo.subTitle);
            }
            isShowCloseImg.setShowCloseImgListener(new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (CsBillDetailActivity.this.f31570P != null && CsBillDetailActivity.this.f31570P.isShowing()) {
                        CsBillDetailActivity.this.f31570P.dismiss();
                    }
                    CsBillDetailActivity.this.m22306a(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_NO_KYC_GOT_IT_CK, dataBean);
                }
            });
            this.f31570P = LEGOUICreator.showDrawerTemplate(this, isShowCloseImg);
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22306a(String str, CsCreateOrderResp.DataBean dataBean) {
        if (dataBean != null && dataBean.extraInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, Integer.valueOf(dataBean.extraInfo.accountStatus));
            CsGetBillResp.Data data = this.f31576d;
            hashMap.put("boleto_code", data == null ? "" : data.barCode);
            hashMap.put("boleto_recognize_success_from", this.f31573S);
            hashMap.put("biz_order_id", dataBean.orderId);
            hashMap.put("no_kyc_popup_from", "payment_details");
            PayTracker.trackEvent(str, hashMap);
        }
    }

    /* renamed from: m */
    private void m22344m() {
        showLoadingDialog();
        CsNetModel.getIns(this).checkAccountStatus(new RpcService.Callback<CsAccountStatus>() {
            public void onSuccess(CsAccountStatus csAccountStatus) {
                CsBillDetailActivity.this.dismissLoadingDialog();
                if (csAccountStatus != null && csAccountStatus.data != null && CsBillDetailActivity.this.f31578f != null) {
                    if (1 == csAccountStatus.data.status) {
                        CsBillDetailActivity csBillDetailActivity = CsBillDetailActivity.this;
                        csBillDetailActivity.m22303a(csBillDetailActivity.f31578f);
                    } else if (2 == csAccountStatus.data.status || 3 == csAccountStatus.data.status) {
                        if (CsBillDetailActivity.this.f31578f.extraInfo != null) {
                            CsBillDetailActivity.this.f31578f.extraInfo.accountStatus = 2;
                            CsBillDetailActivity csBillDetailActivity2 = CsBillDetailActivity.this;
                            boolean unused = csBillDetailActivity2.m22330e(csBillDetailActivity2.f31578f);
                        }
                    } else if (csAccountStatus.data.status == 0) {
                        CsBillDetailActivity csBillDetailActivity3 = CsBillDetailActivity.this;
                        boolean unused2 = csBillDetailActivity3.m22330e(csBillDetailActivity3.f31578f);
                    }
                }
            }

            public void onFailure(IOException iOException) {
                CsBillDetailActivity.this.dismissLoadingDialog();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22309a(final String str, final boolean z, String str2) {
        if (this.f31576d != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                if (this.f31570P != null && this.f31570P.isShowing()) {
                    this.f31570P.dismiss();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            LEGOBaseDrawerModel isShowCloseImg = new LEGODrawerModel1(str2, new LEGOBtnTextAndCallback(getString(R.string.GRider_reminder_Payments_now_kcFN), new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (CsBillDetailActivity.this.f31570P != null && CsBillDetailActivity.this.f31570P.isShowing()) {
                        CsBillDetailActivity.this.f31570P.dismiss();
                    }
                    CsBillDetailActivity.this.m22308a(str, z);
                    CsOmegaUtils.trackBoletoPayExpiredCk(CsBillDetailActivity.this.f31576d.barCode, CsBillDetailActivity.this.f31573S, str);
                }
            })).setIsShowCloseImg(true);
            isShowCloseImg.setShowCloseImgListener(new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    CsOmegaUtils.trackBoletoPayExpiredExitCk(CsBillDetailActivity.this.f31576d.barCode, CsBillDetailActivity.this.f31573S, str);
                }
            });
            this.f31570P = LEGOUICreator.showDrawerTemplate(this, isShowCloseImg);
            CsOmegaUtils.trackBoletoPayExpiredSw(this.f31576d.barCode, this.f31573S, str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22308a(String str, final boolean z) {
        showLoadingDialog();
        CsNetModel.getIns(this).closeOrder(606, str, new RpcService.Callback<WBaseResp>() {
            public void onSuccess(WBaseResp wBaseResp) {
                CsBillDetailActivity.this.dismissLoadingDialog();
                CsBillDetailActivity.this.m22310a(z);
            }

            public void onFailure(IOException iOException) {
                CsBillDetailActivity.this.dismissLoadingDialog();
                WalletToast.showFailedMsg(CsBillDetailActivity.this.getApplicationContext(), ResourcesHelper.getString(CsBillDetailActivity.this.getApplicationContext(), R.string.pay_base_network_error));
            }
        });
    }

    /* renamed from: n */
    private boolean m22345n() {
        CsGetBillResp.Data data = this.f31576d;
        return data != null && data.fastPayData != null && this.f31576d.fastPayData.isSupportFastPay() && !this.f31569O.booleanValue();
    }
}
