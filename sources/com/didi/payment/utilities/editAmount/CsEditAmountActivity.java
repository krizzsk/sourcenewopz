package com.didi.payment.utilities.editAmount;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.MathUtil;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.p129ui.helper.NFloatInputHelper;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.utilities.base.CsBaseActivity;
import com.didi.payment.utilities.details.CsBillDetailActivity;
import com.didi.payment.utilities.resp.CsGetBillResp;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.taxis99.R;
import java.io.Serializable;
import java.util.HashMap;

public class CsEditAmountActivity extends CsBaseActivity {
    public static final String ERROR_INFO = "error_info";
    public static final String MAX_VALUE_CENT = "max_value_cent";
    public static final String MIN_VALUE_CENT = "min_value_cent";

    /* renamed from: h */
    private static final int f31599h = 0;

    /* renamed from: i */
    private static final int f31600i = 1;

    /* renamed from: a */
    NFloatInputHelper f31601a = new NFloatInputHelper();

    /* renamed from: b */
    CsGetBillResp f31602b;

    /* renamed from: c */
    String f31603c = "";

    /* renamed from: d */
    private TextView f31604d;

    /* renamed from: e */
    private TextView f31605e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f31606f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public AppCompatEditText f31607g;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public long f31608j = 100;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public long f31609k = 500000;

    public static void launch(Context context, long j, long j2, String str, CsGetBillResp csGetBillResp) {
        Intent intent = new Intent(context, CsEditAmountActivity.class);
        intent.putExtra(MAX_VALUE_CENT, j);
        intent.putExtra(MIN_VALUE_CENT, j2);
        intent.putExtra("data", csGetBillResp);
        intent.putExtra(ERROR_INFO, str);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.cs_activity_edit_amount_layout);
        m22353c();
        m22346a();
        m22355d();
    }

    /* renamed from: a */
    private void m22346a() {
        this.f31604d = (TextView) findViewById(R.id.tv_main_title);
        this.f31605e = (TextView) findViewById(R.id.tv_error_info);
        this.f31607g = (AppCompatEditText) findViewById(R.id.et_amount);
        TextView textView = (TextView) findViewById(R.id.tv_pay);
        this.f31606f = textView;
        textView.setEnabled(false);
        this.f31606f.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                CsEditAmountActivity.this.m22357e();
                if (CsEditAmountActivity.this.f31607g.getText() != null && CsEditAmountActivity.this.f31602b != null && CsEditAmountActivity.this.f31602b.data != null) {
                    long dollarToCent = (long) MathUtil.dollarToCent(CsEditAmountActivity.this.f31601a.parseFloatValue(CsEditAmountActivity.this.f31607g.getText().toString()));
                    double d = (double) dollarToCent;
                    CsEditAmountActivity.this.f31602b.data.amount = MathUtil.centToDollar(Double.valueOf(d * 1.0d));
                    CsEditAmountActivity.this.f31602b.data.amountCent = dollarToCent;
                    CsEditAmountActivity.this.f31602b.data.amountInDouble = d / 100.0d;
                    MetaData metaData = (MetaData) new Gson().fromJson(CsEditAmountActivity.this.f31602b.data.metadata, MetaData.class);
                    metaData.price = dollarToCent;
                    CsEditAmountActivity.this.f31602b.data.metadata = new Gson().toJson((Object) metaData);
                    CsBillDetailActivity.startActivity(CsEditAmountActivity.this.f31602b, CsEditAmountActivity.this.getContext(), OmegaComParams.BOLETO_EDIT_AMOUNT_PAGE);
                    CsEditAmountActivity.this.finish();
                }
            }
        });
        m22351b();
        m22347a(1);
    }

    /* renamed from: b */
    private void m22351b() {
        this.f31607g.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    CsEditAmountActivity.this.m22347a(1);
                    CsEditAmountActivity.this.f31606f.setEnabled(false);
                    return;
                }
                String obj = editable.toString();
                if (CsEditAmountActivity.this.f31608j >= 100 && (obj.startsWith(".") || obj.startsWith(",") || obj.startsWith("0.") || obj.startsWith("0,"))) {
                    CsEditAmountActivity.this.f31606f.setEnabled(false);
                    CsEditAmountActivity.this.m22347a(0);
                } else if (obj.startsWith(DCryptoMainFragment.DCRYPTO_ZERO) || obj.startsWith("0,00")) {
                    CsEditAmountActivity.this.f31606f.setEnabled(false);
                    CsEditAmountActivity.this.m22347a(0);
                } else {
                    int dollarToCent = MathUtil.dollarToCent(CsEditAmountActivity.this.f31601a.parseFloatValue(obj));
                    long j = (long) dollarToCent;
                    if (j < CsEditAmountActivity.this.f31608j) {
                        CsEditAmountActivity.this.f31606f.setEnabled(false);
                        if (dollarToCent != 0) {
                            CsEditAmountActivity.this.m22347a(0);
                        }
                    } else if (j > CsEditAmountActivity.this.f31609k) {
                        CsEditAmountActivity.this.f31606f.setEnabled(false);
                        CsEditAmountActivity.this.m22347a(0);
                    } else {
                        CsEditAmountActivity.this.f31606f.setEnabled(true);
                        CsEditAmountActivity.this.m22347a(1);
                    }
                }
            }
        });
        this.f31607g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10), new NFloatInputHelper.NumberDecimalInputFilter(2, this.f31601a.decimalSeperatorBySys)});
    }

    /* renamed from: c */
    private void m22353c() {
        if (getIntent() != null) {
            this.f31609k = getIntent().getLongExtra(MAX_VALUE_CENT, 500000);
            this.f31608j = getIntent().getLongExtra(MIN_VALUE_CENT, 100);
            this.f31602b = (CsGetBillResp) getIntent().getSerializableExtra("data");
            this.f31603c = getIntent().getStringExtra(ERROR_INFO);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22347a(int i) {
        if (i == 0) {
            this.f31605e.setTextColor(Color.parseColor("#FF525D"));
        } else {
            this.f31605e.setTextColor(Color.parseColor("#919599"));
        }
        this.f31605e.setText(this.f31603c);
    }

    class MetaData implements Serializable {
        @SerializedName("currency")
        String currency;
        @SerializedName("price")
        long price;
        @SerializedName("sku")
        String sku;

        MetaData() {
        }
    }

    /* renamed from: d */
    private void m22355d() {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        hashMap.put("g_BizId", "Boleto");
        FinOmegaSDK.trackEvent("fin_boleto_billamt_sw", hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m22357e() {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        hashMap.put("g_BizId", "Boleto");
        FinOmegaSDK.trackEvent("fin_boleto_billamt_btn_ck", hashMap);
    }
}
