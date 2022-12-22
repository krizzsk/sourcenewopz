package com.didi.payment.creditcard.global.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.creditcard.global.contract.CreditCardVerifyContract;
import com.didi.payment.creditcard.global.model.GlobalCardVerifyInfo;
import com.didi.payment.creditcard.global.omega.GlobalOmegaUtils;
import com.didi.payment.creditcard.global.presenter.GlobalVerificationPresenter;
import com.didi.payment.creditcard.global.utils.GlobalDialogUtil;
import com.didi.payment.creditcard.global.widget.DecimalEditText;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class GlobalCreditCardVerificationActivity extends GlobalBaseActivity implements CreditCardVerifyContract.IView {

    /* renamed from: a */
    private static final String f30349a = "RESULT_KEY_TYPE";

    /* renamed from: b */
    private static final int f30350b = 1;

    /* renamed from: c */
    private static final int f30351c = 2;

    /* renamed from: d */
    private static final String f30352d = "KEY_INFO";

    /* renamed from: e */
    private ImageView f30353e;

    /* renamed from: f */
    private TextView f30354f;

    /* renamed from: g */
    private TextView f30355g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f30356h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public DecimalEditText f30357i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public TextView f30358j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public GlobalVerificationPresenter f30359k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public GlobalCardVerifyInfo f30360l;

    public void onVerifyFailure() {
    }

    public static void startActivityForResult(Activity activity, int i, GlobalCardVerifyInfo globalCardVerifyInfo) {
        Intent intent = new Intent();
        intent.setClass(activity, GlobalCreditCardVerificationActivity.class);
        intent.putExtra(f30352d, globalCardVerifyInfo);
        activity.startActivityForResult(intent, i);
    }

    public static void startActivityForResult(Fragment fragment, int i, GlobalCardVerifyInfo globalCardVerifyInfo) {
        Intent intent = new Intent();
        intent.setClass(fragment.getActivity(), GlobalCreditCardVerificationActivity.class);
        intent.putExtra(f30352d, globalCardVerifyInfo);
        fragment.startActivityForResult(intent, i);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.one_payment_creditcard_global_activity_verify);
        if (m21326a()) {
            m21328b();
            return;
        }
        SystemUtils.log(3, "VerificationActivity", "onCreate: data is invalidate", (Throwable) null, "com.didi.payment.creditcard.global.activity.GlobalCreditCardVerificationActivity", 75);
        finish();
    }

    /* renamed from: a */
    private boolean m21326a() {
        this.f30359k = new GlobalVerificationPresenter(this);
        Intent intent = getIntent();
        if (intent == null) {
            return false;
        }
        GlobalCardVerifyInfo globalCardVerifyInfo = (GlobalCardVerifyInfo) intent.getSerializableExtra(f30352d);
        this.f30360l = globalCardVerifyInfo;
        if (!TextUtils.isEmpty(globalCardVerifyInfo.defaultText)) {
            return true;
        }
        this.f30360l.defaultText = DCryptoMainFragment.DCRYPTO_ZERO;
        return true;
    }

    /* renamed from: b */
    private void m21328b() {
        this.f30353e = (ImageView) findViewById(R.id.iv_close);
        this.f30354f = (TextView) findViewById(R.id.tv_remove);
        this.f30355g = (TextView) findViewById(R.id.tv_content);
        if (this.f30360l.isCurrencySuffix) {
            this.f30356h = (TextView) findViewById(R.id.suffix_verify_tv_currency);
        } else {
            this.f30356h = (TextView) findViewById(R.id.prefix_verify_tv_currency);
        }
        DecimalEditText decimalEditText = (DecimalEditText) findViewById(R.id.et_money);
        this.f30357i = decimalEditText;
        decimalEditText.setHint(this.f30360l.defaultText);
        TextView textView = (TextView) findViewById(R.id.btn_commit);
        this.f30358j = textView;
        textView.setEnabled(false);
        this.f30357i.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    GlobalCreditCardVerificationActivity.this.f30358j.setEnabled(true);
                    GlobalCreditCardVerificationActivity.this.f30356h.setVisibility(0);
                    GlobalCreditCardVerificationActivity.this.f30357i.setWidth((int) GlobalCreditCardVerificationActivity.this.f30357i.getPaint().measureText(editable.toString()));
                    return;
                }
                GlobalCreditCardVerificationActivity.this.f30358j.setEnabled(false);
                GlobalCreditCardVerificationActivity.this.f30356h.setVisibility(8);
                GlobalCreditCardVerificationActivity.this.f30357i.setWidth((int) GlobalCreditCardVerificationActivity.this.f30357i.getPaint().measureText(GlobalCreditCardVerificationActivity.this.f30360l.defaultText));
            }
        });
        if (!this.f30360l.isShowDecimal) {
            this.f30357i.setDecimalNumber(0);
        }
        this.f30353e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardVerificationActivity.this.onBackPressed();
            }
        });
        this.f30354f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardVerificationActivity.this.m21332d();
            }
        });
        this.f30358j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardVerificationActivity.this.m21330c();
            }
        });
        findViewById(R.id.input_ll).setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                GlobalCreditCardVerificationActivity globalCreditCardVerificationActivity = GlobalCreditCardVerificationActivity.this;
                globalCreditCardVerificationActivity.m21322a((View) globalCreditCardVerificationActivity.f30357i, GlobalCreditCardVerificationActivity.this.getContext());
                return false;
            }
        });
        this.f30355g.setText(this.f30360l.pageContent);
        this.f30356h.setText(this.f30360l.currencyText);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21322a(View view, Context context) {
        InputMethodManager inputMethodManager;
        if (view.requestFocus() && (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) != null) {
            inputMethodManager.showSoftInput(view, 1);
        }
    }

    public void onCancelSignSuccess() {
        Intent intent = new Intent();
        intent.putExtra(f30349a, 2);
        setResult(-1, intent);
        finish();
    }

    public void onVerifySuccess() {
        Intent intent = new Intent();
        intent.putExtra(f30349a, 1);
        setResult(-1, intent);
        finish();
    }

    public void onVerifyMultiFailure(String str, final String str2) {
        GlobalDialogUtil.showVerifyFailureDialog(this, str, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardVerificationActivity.this.setResult(0);
                GlobalCreditCardVerificationActivity.this.finish();
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardVerificationActivity.this.m21325a(str2);
                GlobalCreditCardVerificationActivity.this.setResult(0);
                GlobalCreditCardVerificationActivity.this.finish();
            }
        });
    }

    public void onBackPressed() {
        setResult(0);
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m21330c() {
        this.f30359k.verifyCard(this.f30357i.getText().toString().trim(), this.f30360l.cardIndex, this.f30360l.productId);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21325a(String str) {
        if (TextUtils.isEmpty(str)) {
            String stringParam = PayBaseParamUtil.getStringParam(getContext(), "country");
            str = (TextUtils.isEmpty(stringParam) || !stringParam.toUpperCase().contains("BR")) ? "https://help.didiglobal.com/passenger-index.html?source=app_globalck_home" : "https://help.99taxis.mobi/static/index.html?source=app_brck_home";
        }
        WebBrowserUtil.startInternalWebActivity(this, str, "");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m21332d() {
        GlobalDialogUtil.showCancelSignConfirmDialog(this, getString(R.string.one_payment_creditcard_global_detail_page_dialog_remove_card_content), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardVerificationActivity.this.f30359k.removeCard(GlobalCreditCardVerificationActivity.this.f30360l.cardIndex);
                GlobalOmegaUtils.trackCardDetailPageRemoveOKCk(GlobalCreditCardVerificationActivity.this);
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackCardDetailPageRemoveCancelCk(GlobalCreditCardVerificationActivity.this);
            }
        });
    }
}
