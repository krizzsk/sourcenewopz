package com.didi.payment.paymethod.sign.channel.paypay.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.didi.payment.base.router.ActivityLauncher;
import com.didi.payment.base.view.PayBaseToast;
import com.didi.payment.base.view.PayGlobalLoading;
import com.didi.payment.base.view.webview.PayBaseWebActivity;
import com.didi.payment.base.view.webview.overrider.OverrideUrlLoader;
import com.didi.payment.paymethod.omega.GlobalOmegaUtils;
import com.didi.payment.paymethod.sign.channel.paypay.contract.PayPaySignWebContract;
import com.didi.payment.paymethod.sign.channel.paypay.presenter.PayPaySignWebPresenter;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class PayPaySignWebActivity extends PayBaseWebActivity implements PayPaySignWebContract.View {

    /* renamed from: a */
    private static final String f31000a = "backUrl";

    /* renamed from: b */
    private static final String f31001b = "pollingTimes";

    /* renamed from: c */
    private static final String f31002c = "pollingFrequency";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f31003d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f31004e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f31005f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public PayPaySignWebContract.Presenter f31006g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f31007h;

    public Activity getActivity() {
        return this;
    }

    public static void launch(Activity activity, String str, String str2, int i, int i2, ActivityLauncher.Callback callback) {
        Intent intent = new Intent(activity, PayPaySignWebActivity.class);
        intent.putExtra(PayBaseWebActivity.EXTRA_URL, str);
        intent.putExtra("backUrl", str2);
        intent.putExtra(f31001b, i);
        intent.putExtra(f31002c, i2);
        ActivityLauncher.init(activity).startActivityForResult(intent, callback);
    }

    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.mWebTitleBar.setBackBtnImg(R.drawable.paymethod_global_btn_title_back_selector);
        m21802b();
        m21799a();
    }

    /* renamed from: a */
    private void m21799a() {
        Intent intent = getIntent();
        if (intent == null) {
            finishWithResultCodeCanceled();
        }
        this.f31003d = intent.getStringExtra("backUrl");
        this.f31004e = intent.getIntExtra(f31001b, 10);
        this.f31005f = intent.getIntExtra(f31001b, 5);
        this.f31006g = new PayPaySignWebPresenter(this);
    }

    /* renamed from: b */
    private void m21802b() {
        addOverrideUrlLoader(new OverrideUrlLoader() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(PayPaySignWebActivity.this.f31003d) || !str.contains(PayPaySignWebActivity.this.f31003d)) {
                    return false;
                }
                boolean unused = PayPaySignWebActivity.this.f31007h = true;
                PayPaySignWebActivity.this.f31006g.pollSignResult(PayPaySignWebActivity.this.f31004e, PayPaySignWebActivity.this.f31005f);
                return true;
            }
        });
    }

    public void showLoadingDialog() {
        PayGlobalLoading.show((Activity) this, (int) R.id.web_title_bar, true);
    }

    public void dismissLoadingDialog() {
        PayGlobalLoading.hide();
    }

    public void onSignSuccess(String str) {
        PayBaseToast.showSucc((Context) this, str);
        GlobalOmegaUtils.trackAddPayPaySuccess(this);
        finishWithResultCodeOK();
    }

    public void onSignFailure(String str) {
        PayBaseToast.showInfo((Context) this, str);
    }

    /* access modifiers changed from: protected */
    public void finishWithResultCodeOK() {
        if (this.f31007h) {
            super.finishWithResultCodeOK();
        } else {
            finishWithResultCodeCanceled();
        }
    }
}
