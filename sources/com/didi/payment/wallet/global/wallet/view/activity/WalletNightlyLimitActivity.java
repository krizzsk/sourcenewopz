package com.didi.payment.wallet.global.wallet.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.p129ui.helper.NFloatInputHelper;
import com.didi.payment.creditcard.global.utils.InputTools;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.exts.CurrencyUtils;
import com.didi.payment.wallet.global.model.resp.QueryNightlyLimitSettingResp;
import com.didi.payment.wallet.global.wallet.contract.WalletNightlyLimitContract;
import com.didi.payment.wallet.global.wallet.presenter.WalletNightlyLimitPresenter;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ToastHelper;
import com.didiglobal.pay.paysecure.omega.OmegaUtilKt;
import com.taxis99.R;
import java.text.DecimalFormat;
import java.util.HashMap;

public class WalletNightlyLimitActivity extends WalletBaseActivity implements WalletNightlyLimitContract.IView {

    /* renamed from: a */
    private View f32176a;

    /* renamed from: b */
    private View f32177b;

    /* renamed from: c */
    private ImageView f32178c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public EditText f32179d;

    /* renamed from: e */
    private TextView f32180e;

    /* renamed from: f */
    private TextView f32181f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f32182g;

    /* renamed from: h */
    private View f32183h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View f32184i;

    /* renamed from: j */
    private View f32185j;

    /* renamed from: k */
    private DecimalFormat f32186k = new DecimalFormat(DCryptoMainFragment.DCRYPTO_ZERO);

    /* renamed from: l */
    private float f32187l = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public float f32188m = 20000.0f;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public WalletNightlyLimitContract.IPresenter f32189n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo f32190o;

    /* renamed from: p */
    private String f32191p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public NFloatInputHelper f32192q;

    public static void start(Context context) {
        context.startActivity(new Intent(context, WalletNightlyLimitActivity.class));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.f32191p = intent.getStringExtra("pageFrom");
        }
        setContentView((int) R.layout.wallet_global_activity_nightly_limit);
        this.f32189n = new WalletNightlyLimitPresenter(this, this);
        this.f32176a = findViewById(R.id.layout_title_bar);
        this.f32179d = (EditText) findViewById(R.id.et_amount);
        this.f32183h = findViewById(R.id.ll_input);
        this.f32184i = findViewById(R.id.ll_empty);
        this.f32185j = findViewById(R.id.nsv_content);
        TextView textView = (TextView) findViewById(R.id.tv_limit_range);
        this.f32180e = textView;
        textView.setText(getString(R.string.GRider_limit_Limit_range_VIcO, new Object[]{"R$" + CurrencyUtils.currencyFormat(Float.valueOf(this.f32187l), getResources().getConfiguration().locale), "R$" + CurrencyUtils.currencyFormat(Float.valueOf(this.f32188m), getResources().getConfiguration().locale)}));
        this.f32181f = (TextView) findViewById(R.id.tv_currency);
        this.f32182g = (TextView) findViewById(R.id.tv_confirm);
        this.f32177b = findViewById(R.id.iv_left);
        this.f32178c = (ImageView) findViewById(R.id.iv_right);
        this.f32176a.setBackground((Drawable) null);
        this.f32184i.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                WalletNightlyLimitActivity.this.f32184i.setVisibility(8);
                WalletNightlyLimitActivity.this.f32189n.requestData();
            }
        });
        this.f32183h.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                InputTools.showKeyboard(WalletNightlyLimitActivity.this.f32179d);
            }
        });
        this.f32177b.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_night_transfer_limit_page_ex");
                WalletNightlyLimitActivity.this.finish();
            }
        });
        this.f32178c.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_night_transfer_limit_page_faq_ck");
                WebBrowserUtil.startInternalWebActivity(WalletNightlyLimitActivity.this, WalletConstant.URL.H5_NIGHTLY_LIMIT_HELP, "");
            }
        });
        NFloatInputHelper nFloatInputHelper = new NFloatInputHelper();
        this.f32192q = nFloatInputHelper;
        this.f32179d.setFilters(new InputFilter[]{new NFloatInputHelper.NumberDecimalInputFilter(2, nFloatInputHelper.decimalSeperatorBySys), new InputFilter.LengthFilter(10)});
        this.f32179d.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    try {
                        if (editable.length() != 0) {
                            float parseFloatValue = WalletNightlyLimitActivity.this.f32192q.parseFloatValue(editable.toString());
                            if (parseFloatValue <= WalletNightlyLimitActivity.this.f32188m) {
                                WalletNightlyLimitActivity.this.m22843a(parseFloatValue);
                                return;
                            } else {
                                WalletNightlyLimitActivity.this.m22846a(Float.valueOf(parseFloatValue), WalletNightlyLimitActivity.this.f32188m);
                                return;
                            }
                        }
                    } catch (Exception unused) {
                        return;
                    }
                }
                WalletNightlyLimitActivity.this.f32182g.setEnabled(false);
            }
        });
        this.f32182g.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                String obj = WalletNightlyLimitActivity.this.f32179d.getText().toString();
                HashMap hashMap = new HashMap();
                hashMap.put("confirm_limit_amount", obj);
                PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_night_transfer_limit_confirm_ck", hashMap);
                if (TextUtils.isEmpty(obj)) {
                    obj = "0";
                }
                long j = 0;
                try {
                    if (WalletNightlyLimitActivity.this.f32190o != null) {
                        j = WalletNightlyLimitActivity.this.f32190o.limitInEffective;
                    }
                    WalletNightlyLimitActivity.this.f32189n.submit(j, CurrencyUtils.dollarToCents(Float.valueOf(WalletNightlyLimitActivity.this.f32192q.parseFloatValue(obj))));
                } catch (Exception unused) {
                }
            }
        });
        initLoadingDialog(this, R.id.layout_title_bar);
        this.f32189n.requestData();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22843a(float f) {
        this.f32180e.setTextColor(-16777216);
        long dollarToCents = CurrencyUtils.dollarToCents(Float.valueOf(f));
        QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo queryNightlyLimitSettingVo = this.f32190o;
        boolean z = true;
        if (queryNightlyLimitSettingVo != null) {
            TextView textView = this.f32182g;
            if (Double.compare((double) queryNightlyLimitSettingVo.limitInEffective, (double) dollarToCents) == 0) {
                z = false;
            }
            textView.setEnabled(z);
            return;
        }
        this.f32182g.setEnabled(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22846a(Float f, float f2) {
        if (f != null && f.floatValue() > f2) {
            HashMap hashMap = new HashMap();
            hashMap.put("beyond_limit_amount", f);
            PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_night_transfer_limit_amount_bt", hashMap);
            this.f32180e.setTextColor(-65536);
        }
        this.f32182g.setEnabled(false);
    }

    public void onNetworkError() {
        this.f32184i.setVisibility(0);
        this.f32185j.setVisibility(8);
    }

    public void showSettingLimit(QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo queryNightlyLimitSettingVo) {
        this.f32190o = queryNightlyLimitSettingVo;
        if (!TextUtils.isEmpty(queryNightlyLimitSettingVo.effectiveTime)) {
            WalletChangeLimitResultActivity.start(this, queryNightlyLimitSettingVo);
            finish();
            return;
        }
        this.f32184i.setVisibility(8);
        int i = 0;
        this.f32185j.setVisibility(0);
        HashMap hashMap = new HashMap();
        hashMap.put(OmegaUtilKt.ENTRANCE_PAGE_ID, this.f32191p);
        PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_night_transfer_limit_page_sw", hashMap);
        this.f32179d.setText(CurrencyUtils.currencyFormat(CurrencyUtils.centToDollar(Long.valueOf(queryNightlyLimitSettingVo.limitInEffective)), this.f32186k));
        InputTools.showKeyboard(this.f32179d);
        Editable text = this.f32179d.getText();
        if (text != null) {
            i = text.length();
        }
        this.f32179d.setSelection(i);
    }

    public void onChangeSuccess(QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo queryNightlyLimitSettingVo) {
        WalletChangeLimitResultActivity.start(this, queryNightlyLimitSettingVo);
        Intent intent = new Intent();
        String str = queryNightlyLimitSettingVo.effectiveTime;
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("effectiveTime", str);
        }
        setResult(-1, intent);
        finish();
    }

    public void onChangeFailed(String str) {
        if (!TextUtils.isEmpty(str)) {
            ToastHelper.showShortInfo(getContext(), str, (int) R.drawable.wallet_toast_icon_fail);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f32189n.destroy();
        super.onDestroy();
    }
}
