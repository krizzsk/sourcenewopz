package com.didichuxing.security.cardverify.activity;

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
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.LEGODrawerDismissListener;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.security.cardverify.DiCardVerifyCallback;
import com.didichuxing.security.cardverify.DiCardVerifyParam;
import com.didichuxing.security.cardverify.contract.CreditCardVerifyContract;
import com.didichuxing.security.cardverify.model.CardVerifyInfo;
import com.didichuxing.security.cardverify.presenter.VerificationPresenter;
import com.didichuxing.security.cardverify.report.DiCardVerifyTracker;
import com.didichuxing.security.cardverify.utils.VerifyDialogUtil;
import com.didichuxing.security.cardverify.view.DecimalEditText;
import com.google.gson.Gson;
import com.taxis99.R;
import java.lang.ref.WeakReference;

public class CardVerificationActivity extends CardVerifyBaseActivity implements CreditCardVerifyContract.IView {

    /* renamed from: a */
    private static final String f48879a = "KEY_INFO";

    /* renamed from: b */
    private static final String f48880b = "KEY_PARAM";
    public static DiCardVerifyCallback callback;

    /* renamed from: m */
    private static WeakReference<CardVerificationActivity> f48881m;

    /* renamed from: c */
    private ImageView f48882c;

    /* renamed from: d */
    private TextView f48883d;

    /* renamed from: e */
    private TextView f48884e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f48885f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public DecimalEditText f48886g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f48887h;

    /* renamed from: i */
    private VerificationPresenter f48888i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public CardVerifyInfo f48889j;

    /* renamed from: k */
    private DiCardVerifyParam f48890k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public LEGODrawer f48891l = null;

    public static void startActivity(Context context, DiCardVerifyParam diCardVerifyParam, CardVerifyInfo cardVerifyInfo, DiCardVerifyCallback diCardVerifyCallback) {
        callback = diCardVerifyCallback;
        Intent intent = new Intent();
        intent.setClass(context, CardVerificationActivity.class);
        intent.putExtra("KEY_PARAM", new Gson().toJson((Object) diCardVerifyParam));
        intent.putExtra(f48879a, cardVerifyInfo);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void onCardRemoved() {
        CardVerificationActivity cardVerificationActivity;
        WeakReference<CardVerificationActivity> weakReference = f48881m;
        if (weakReference != null && (cardVerificationActivity = (CardVerificationActivity) weakReference.get()) != null && !cardVerificationActivity.isFinishing()) {
            cardVerificationActivity.runOnUiThread(new Runnable(cardVerificationActivity) {
                final /* synthetic */ CardVerificationActivity val$activity;

                {
                    this.val$activity = r1;
                }

                public void run() {
                    this.val$activity.finish();
                }
            });
        }
    }

    public static void onRemoveCardFail(final String str) {
        CardVerificationActivity cardVerificationActivity;
        WeakReference<CardVerificationActivity> weakReference = f48881m;
        if (weakReference != null && (cardVerificationActivity = (CardVerificationActivity) weakReference.get()) != null && !cardVerificationActivity.isFinishing()) {
            cardVerificationActivity.runOnUiThread(new Runnable(cardVerificationActivity) {
                final /* synthetic */ CardVerificationActivity val$activity;

                {
                    this.val$activity = r1;
                }

                public void run() {
                    LEGOToastHelper.showShortNagToast(this.val$activity, str);
                    if (this.val$activity.f48891l != null && this.val$activity.f48891l.isShowing()) {
                        this.val$activity.f48891l.dismiss();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        f48881m = new WeakReference<>(this);
        setContentView((int) R.layout.didi_security_card_verify_activity_verify);
        if (m35067a()) {
            m35069b();
            return;
        }
        SystemUtils.log(3, "VerificationActivity", "onCreate: data is invalidate", (Throwable) null, "com.didichuxing.security.cardverify.activity.CardVerificationActivity", 117);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        callback = null;
        f48881m = null;
    }

    /* renamed from: a */
    private boolean m35067a() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f48889j = (CardVerifyInfo) intent.getSerializableExtra(f48879a);
            this.f48890k = (DiCardVerifyParam) new Gson().fromJson(intent.getStringExtra("KEY_PARAM"), DiCardVerifyParam.class);
            if (TextUtils.isEmpty(this.f48889j.defaultText)) {
                this.f48889j.defaultText = DCryptoMainFragment.DCRYPTO_ZERO;
            }
            this.f48888i = new VerificationPresenter(this, this.f48890k);
            return true;
        }
        this.f48888i = new VerificationPresenter(this, new DiCardVerifyParam.Builder(this).build());
        return false;
    }

    /* renamed from: b */
    private void m35069b() {
        this.f48882c = (ImageView) findViewById(R.id.iv_close);
        this.f48883d = (TextView) findViewById(R.id.tv_remove);
        this.f48884e = (TextView) findViewById(R.id.tv_content);
        if (this.f48889j.isCurrencySuffix) {
            this.f48885f = (TextView) findViewById(R.id.suffix_verify_tv_currency);
        } else {
            this.f48885f = (TextView) findViewById(R.id.prefix_verify_tv_currency);
        }
        DecimalEditText decimalEditText = (DecimalEditText) findViewById(R.id.et_money);
        this.f48886g = decimalEditText;
        decimalEditText.setHint(this.f48889j.defaultText);
        TextView textView = (TextView) findViewById(R.id.btn_commit);
        this.f48887h = textView;
        textView.setEnabled(false);
        this.f48886g.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    CardVerificationActivity.this.f48886g.setHint("");
                    CardVerificationActivity.this.f48887h.setEnabled(true);
                    CardVerificationActivity.this.f48885f.setVisibility(0);
                    return;
                }
                CardVerificationActivity.this.f48886g.setHint(CardVerificationActivity.this.f48889j.defaultText);
                CardVerificationActivity.this.f48887h.setEnabled(false);
                CardVerificationActivity.this.f48885f.setVisibility(8);
            }
        });
        if (!this.f48889j.isShowDecimal) {
            this.f48886g.setDecimalNumber(0);
        }
        this.f48882c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CardVerificationActivity.this.onBackPressed();
            }
        });
        this.f48883d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CardVerificationActivity.this.m35075e();
            }
        });
        this.f48887h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CardVerificationActivity.this.m35073d();
            }
        });
        findViewById(R.id.input_ll).setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                CardVerificationActivity cardVerificationActivity = CardVerificationActivity.this;
                cardVerificationActivity.m35063a((View) cardVerificationActivity.f48886g, CardVerificationActivity.this.getContext());
                return false;
            }
        });
        this.f48884e.setText(this.f48889j.pageContent);
        this.f48885f.setText(this.f48889j.currencyText);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35063a(View view, Context context) {
        InputMethodManager inputMethodManager;
        if (view.requestFocus() && (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) != null) {
            inputMethodManager.showSoftInput(view, 1);
        }
    }

    public void onVerifySuccess() {
        DiCardVerifyTracker.trackVerifySucceed();
        m35064a(callback, 0, "verify success");
        finish();
    }

    public void onVerifyFailure() {
        DiCardVerifyTracker.trackVerifyFailed();
    }

    public void onVerifyMultiFailure(final String str, final String str2) {
        DiCardVerifyTracker.trackVerifyFailed();
        LEGODrawer lEGODrawer = this.f48891l;
        if (lEGODrawer == null || !lEGODrawer.isShowing()) {
            this.f48891l = m35062a(str, str2);
            return;
        }
        this.f48891l.setDismissListener(new LEGODrawerDismissListener() {
            public void onDismiss() {
                CardVerificationActivity cardVerificationActivity = CardVerificationActivity.this;
                LEGODrawer unused = cardVerificationActivity.f48891l = cardVerificationActivity.m35062a(str, str2);
            }
        });
        this.f48891l.dismiss();
    }

    public void onVerifyException() {
        DiCardVerifyTracker.trackVerifyFailed();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public LEGODrawer m35062a(String str, final String str2) {
        return VerifyDialogUtil.showVerifyFailureDialog(this, str, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CardVerificationActivity.this.finish();
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CardVerificationActivity.this.m35064a(CardVerificationActivity.callback, 4, TextUtils.isEmpty(str2) ? CardVerificationActivity.this.m35071c() : str2);
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (CardVerificationActivity.this.f48891l != null && CardVerificationActivity.this.f48891l.isShowing()) {
                    CardVerificationActivity.this.f48891l.dismiss();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public String m35071c() {
        return (TextUtils.isEmpty(this.f48890k.getCountry()) || !this.f48890k.getCountry().toUpperCase().contains("BR")) ? "https://help.didiglobal.com/passenger-index.html?source=app_globalck_home" : "https://help.99taxis.mobi/static/index.html?source=app_brck_home";
    }

    public void onBackPressed() {
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m35073d() {
        DiCardVerifyTracker.trackVerifyCk();
        String trim = this.f48886g.getText().toString().trim();
        if (trim.lastIndexOf(46) == trim.length() - 1) {
            trim = trim.substring(0, trim.length() - 1);
        }
        this.f48888i.verifyCard(trim, this.f48890k.getPhone());
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m35075e() {
        LEGODrawer lEGODrawer = this.f48891l;
        if (lEGODrawer == null || !lEGODrawer.isShowing()) {
            this.f48891l = m35076f();
            return;
        }
        this.f48891l.setDismissListener(new LEGODrawerDismissListener() {
            public void onDismiss() {
                CardVerificationActivity cardVerificationActivity = CardVerificationActivity.this;
                LEGODrawer unused = cardVerificationActivity.f48891l = cardVerificationActivity.m35076f();
            }
        });
        this.f48891l.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public LEGODrawer m35076f() {
        return VerifyDialogUtil.showCancelSignConfirmDialog(this, getString(R.string.didi_security_card_verify_dialog_remove_card_content), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (CardVerificationActivity.this.f48891l != null) {
                    CardVerificationActivity.this.f48891l.showLoading();
                }
                CardVerificationActivity.this.m35064a(CardVerificationActivity.callback, 3, "remove card");
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (CardVerificationActivity.this.f48891l != null) {
                    CardVerificationActivity.this.f48891l.dismiss();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35064a(DiCardVerifyCallback diCardVerifyCallback, int i, String str) {
        if (diCardVerifyCallback != null) {
            diCardVerifyCallback.onCallback(i, str);
        }
    }

    public void finish() {
        LEGODrawer lEGODrawer = this.f48891l;
        if (lEGODrawer == null || !lEGODrawer.isShowing()) {
            super.finish();
            return;
        }
        this.f48891l.setDismissListener(new LEGODrawerDismissListener() {
            public void onDismiss() {
                CardVerificationActivity.super.finish();
            }
        });
        this.f48891l.dismiss();
    }
}
