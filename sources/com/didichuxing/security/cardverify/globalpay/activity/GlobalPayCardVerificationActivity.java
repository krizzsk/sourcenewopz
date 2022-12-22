package com.didichuxing.security.cardverify.globalpay.activity;

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
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.security.cardverify.DiCardVerifyCallback;
import com.didichuxing.security.cardverify.DiCardVerifyParam;
import com.didichuxing.security.cardverify.activity.CardVerifyBaseActivity;
import com.didichuxing.security.cardverify.contract.CreditCardVerifyContract;
import com.didichuxing.security.cardverify.globalpay.utils.GlobalPayToast;
import com.didichuxing.security.cardverify.globalpay.view.GlobalPayLottieLoadingView;
import com.didichuxing.security.cardverify.globalpay.view.GlobalPayShadowLayout;
import com.didichuxing.security.cardverify.model.CardVerifyInfo;
import com.didichuxing.security.cardverify.presenter.VerificationPresenter;
import com.didichuxing.security.cardverify.report.DiCardVerifyTracker;
import com.didichuxing.security.cardverify.view.DecimalEditText;
import com.google.gson.Gson;
import com.taxis99.R;
import java.lang.ref.WeakReference;

public class GlobalPayCardVerificationActivity extends CardVerifyBaseActivity implements CreditCardVerifyContract.IView {

    /* renamed from: a */
    private static final String f48898a = "KEY_INFO";

    /* renamed from: b */
    private static final String f48899b = "KEY_PARAM";
    public static DiCardVerifyCallback callback;

    /* renamed from: n */
    private static WeakReference<GlobalPayCardVerificationActivity> f48900n;

    /* renamed from: c */
    private boolean f48901c = true;

    /* renamed from: d */
    private ImageView f48902d;

    /* renamed from: e */
    private TextView f48903e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f48904f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public DecimalEditText f48905g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f48906h;

    /* renamed from: i */
    private GlobalPayShadowLayout f48907i;

    /* renamed from: j */
    private GlobalPayLottieLoadingView f48908j;

    /* renamed from: k */
    private VerificationPresenter f48909k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public CardVerifyInfo f48910l;

    /* renamed from: m */
    private DiCardVerifyParam f48911m;

    public void showToastCompleted(String str) {
    }

    public static void startActivity(Context context, DiCardVerifyParam diCardVerifyParam, CardVerifyInfo cardVerifyInfo, DiCardVerifyCallback diCardVerifyCallback) {
        callback = diCardVerifyCallback;
        Intent intent = new Intent();
        intent.setClass(context, GlobalPayCardVerificationActivity.class);
        intent.putExtra("KEY_PARAM", new Gson().toJson((Object) diCardVerifyParam));
        intent.putExtra(f48898a, cardVerifyInfo);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        f48900n = new WeakReference<>(this);
        setContentView((int) R.layout.didi_security_card_verify_global_pay_activity);
        if (m35095a()) {
            m35097b();
            return;
        }
        SystemUtils.log(3, "VerificationActivity", "onCreate: data is invalidate", (Throwable) null, "com.didichuxing.security.cardverify.globalpay.activity.GlobalPayCardVerificationActivity", 82);
        finish();
    }

    public void showToast(String str) {
        if (str == null) {
            str = "";
        }
        GlobalPayToast.show(getApplicationContext(), str);
    }

    public void onBackPressed() {
        if (this.f48901c) {
            m35092a(callback, 2, "user cancel");
            super.onBackPressed();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f48901c) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    public void showLoadingDialog(String str) {
        this.f48908j.show();
        this.f48907i.setVisibility(0);
        this.f48906h.setEnabled(false);
        this.f48901c = false;
    }

    public void dismissLoadingDialog() {
        this.f48908j.hide();
        this.f48907i.setVisibility(8);
        this.f48906h.setEnabled(true);
        this.f48901c = true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        callback = null;
        f48900n = null;
    }

    /* renamed from: a */
    private boolean m35095a() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f48910l = (CardVerifyInfo) intent.getSerializableExtra(f48898a);
            this.f48911m = (DiCardVerifyParam) new Gson().fromJson(intent.getStringExtra("KEY_PARAM"), DiCardVerifyParam.class);
            if (TextUtils.isEmpty(this.f48910l.defaultText)) {
                this.f48910l.defaultText = DCryptoMainFragment.DCRYPTO_ZERO;
            }
            this.f48909k = new VerificationPresenter(this, this.f48911m);
            return true;
        }
        this.f48909k = new VerificationPresenter(this, new DiCardVerifyParam.Builder(this).build());
        return false;
    }

    /* renamed from: b */
    private void m35097b() {
        this.f48902d = (ImageView) findViewById(R.id.iv_close);
        this.f48903e = (TextView) findViewById(R.id.tv_content);
        if (this.f48910l.isCurrencySuffix) {
            this.f48904f = (TextView) findViewById(R.id.suffix_verify_tv_currency);
        } else {
            this.f48904f = (TextView) findViewById(R.id.prefix_verify_tv_currency);
        }
        DecimalEditText decimalEditText = (DecimalEditText) findViewById(R.id.et_money);
        this.f48905g = decimalEditText;
        decimalEditText.setHint(this.f48910l.defaultText);
        TextView textView = (TextView) findViewById(R.id.btn_commit);
        this.f48906h = textView;
        textView.setText(getResources().getString(R.string.didi_security_card_verify_verify_page_btn_submit));
        this.f48906h.setEnabled(false);
        this.f48907i = (GlobalPayShadowLayout) findViewById(R.id.loading_view_container);
        this.f48908j = (GlobalPayLottieLoadingView) findViewById(R.id.loading_view);
        this.f48905g.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    GlobalPayCardVerificationActivity.this.f48905g.setHint("");
                    GlobalPayCardVerificationActivity.this.f48906h.setEnabled(true);
                    GlobalPayCardVerificationActivity.this.f48904f.setVisibility(0);
                    return;
                }
                GlobalPayCardVerificationActivity.this.f48905g.setHint(GlobalPayCardVerificationActivity.this.f48910l.defaultText);
                GlobalPayCardVerificationActivity.this.f48906h.setEnabled(false);
                GlobalPayCardVerificationActivity.this.f48904f.setVisibility(8);
            }
        });
        if (!this.f48910l.isShowDecimal) {
            this.f48905g.setDecimalNumber(0);
        }
        this.f48902d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalPayCardVerificationActivity.this.m35092a(GlobalPayCardVerificationActivity.callback, 2, "user cancel");
                GlobalPayCardVerificationActivity.this.finish();
            }
        });
        this.f48906h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalPayCardVerificationActivity.this.m35099c();
            }
        });
        findViewById(R.id.input_ll).setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                GlobalPayCardVerificationActivity globalPayCardVerificationActivity = GlobalPayCardVerificationActivity.this;
                globalPayCardVerificationActivity.m35091a(globalPayCardVerificationActivity.f48905g, GlobalPayCardVerificationActivity.this.getContext());
                return false;
            }
        });
        this.f48903e.setText(this.f48910l.pageContent);
        this.f48904f.setText(this.f48910l.currencyText);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35091a(View view, Context context) {
        InputMethodManager inputMethodManager;
        if (view.requestFocus() && (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) != null) {
            inputMethodManager.showSoftInput(view, 1);
        }
    }

    public void onVerifySuccess() {
        DiCardVerifyTracker.trackVerifySucceed();
        finish();
        m35092a(callback, 0, "verify success");
    }

    public void onVerifyFailure() {
        DiCardVerifyTracker.trackVerifyFailed();
    }

    public void onVerifyMultiFailure(String str, String str2) {
        DiCardVerifyTracker.trackVerifyFailed();
        finish();
        m35092a(callback, 5, "verify fail");
    }

    public void onVerifyException() {
        DiCardVerifyTracker.trackVerifyFailed();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m35099c() {
        DiCardVerifyTracker.trackVerifyCk();
        String trim = this.f48905g.getText().toString().trim();
        if (trim.lastIndexOf(46) == trim.length() - 1) {
            trim = trim.substring(0, trim.length() - 1);
        }
        this.f48909k.verifyCard(trim, this.f48911m.getPhone());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35092a(DiCardVerifyCallback diCardVerifyCallback, int i, String str) {
        if (diCardVerifyCallback != null) {
            diCardVerifyCallback.onCallback(i, str);
        }
    }
}
