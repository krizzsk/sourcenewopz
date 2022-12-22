package com.didi.payment.paymethod.sign.channel.paypal.activity;

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
import com.didi.payment.paymethod.sign.channel.paypal.contract.PayPalSignWebContract;
import com.didi.payment.paymethod.sign.channel.paypal.presenter.PayPalSignWebPresenter;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class PayPalSignWebActivity extends PayBaseWebActivity implements PayPalSignWebContract.View {

    /* renamed from: a */
    private static final String f30977a = "backUrl";

    /* renamed from: b */
    private static final String f30978b = "pollingTimes";

    /* renamed from: c */
    private static final String f30979c = "pollingFrequency";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f30980d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f30981e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f30982f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public PayPalSignWebContract.Presenter f30983g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f30984h;

    public Activity getActivity() {
        return this;
    }

    public static void launch(Activity activity, String str, String str2, int i, int i2, ActivityLauncher.Callback callback) {
        Intent intent = new Intent(activity, PayPalSignWebActivity.class);
        intent.putExtra(PayBaseWebActivity.EXTRA_URL, str);
        intent.putExtra("backUrl", str2);
        intent.putExtra(f30978b, i);
        intent.putExtra(f30979c, i2);
        ActivityLauncher.init(activity).startActivityForResult(intent, callback);
    }

    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.mWebTitleBar.setBackBtnImg(R.drawable.paymethod_global_btn_title_back_selector);
        m21783b();
        m21780a();
    }

    /* renamed from: a */
    private void m21780a() {
        Intent intent = getIntent();
        if (intent == null) {
            finishWithResultCodeCanceled();
        }
        this.f30980d = intent.getStringExtra("backUrl");
        this.f30981e = intent.getIntExtra(f30978b, 10);
        this.f30982f = intent.getIntExtra(f30978b, 5);
        this.f30983g = new PayPalSignWebPresenter(this);
    }

    /* renamed from: b */
    private void m21783b() {
        addOverrideUrlLoader(new OverrideUrlLoader() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(PayPalSignWebActivity.this.f30980d) || !str.contains(PayPalSignWebActivity.this.f30980d)) {
                    return false;
                }
                boolean unused = PayPalSignWebActivity.this.f30984h = true;
                PayPalSignWebActivity.this.f30983g.pollSignResult(PayPalSignWebActivity.this.f30981e, PayPalSignWebActivity.this.f30982f);
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
        GlobalOmegaUtils.trackAddPayPalSuccess(this);
        finishWithResultCodeOK();
    }

    public void onSignFailure(String str) {
        PayBaseToast.showInfo((Context) this, str);
        finishWithResultCodeCanceled();
    }

    /* access modifiers changed from: protected */
    public void finishWithResultCodeOK() {
        if (this.f30984h) {
            super.finishWithResultCodeOK();
        } else {
            finishWithResultCodeCanceled();
        }
    }
}
