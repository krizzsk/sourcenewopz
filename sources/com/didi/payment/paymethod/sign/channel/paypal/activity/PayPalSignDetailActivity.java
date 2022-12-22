package com.didi.payment.paymethod.sign.channel.paypal.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.payment.base.router.ActivityLauncher;
import com.didi.payment.base.view.PayBaseToast;
import com.didi.payment.base.view.PayGlobalLoading;
import com.didi.payment.paymethod.omega.GlobalOmegaUtils;
import com.didi.payment.paymethod.sign.channel.paypal.contract.PayPalSignDetailContract;
import com.didi.payment.paymethod.sign.channel.paypal.presenter.PayPalSignDetailPresenter;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.taxis99.R;

public class PayPalSignDetailActivity extends FragmentActivity implements PayPalSignDetailContract.View {

    /* renamed from: a */
    private static final String f30969a = "email";

    /* renamed from: b */
    private ImageView f30970b;

    /* renamed from: c */
    private TextView f30971c;

    /* renamed from: d */
    private TextView f30972d;

    /* renamed from: e */
    private TextView f30973e;

    /* renamed from: f */
    private TextView f30974f;

    /* renamed from: g */
    private String f30975g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public PayPalSignDetailContract.Presenter f30976h;

    public Activity getActivity() {
        return this;
    }

    public static void launch(Activity activity, String str, ActivityLauncher.Callback callback) {
        Intent intent = new Intent(activity, PayPalSignDetailActivity.class);
        intent.putExtra("email", str);
        ActivityLauncher.init(activity).startActivityForResult(intent, callback);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        m21777c();
        m21778d();
        super.onCreate(bundle);
        setContentView((int) R.layout.paymethod_activity_global_paypal_detail);
        m21773a();
        m21776b();
    }

    /* renamed from: a */
    private void m21773a() {
        Intent intent = getIntent();
        if (intent == null) {
            setResult(0);
            finish();
        } else {
            this.f30975g = intent.getStringExtra("email");
        }
        this.f30976h = new PayPalSignDetailPresenter(this);
    }

    /* renamed from: b */
    private void m21776b() {
        this.f30971c = (TextView) findViewById(R.id.tv_email);
        this.f30973e = (TextView) findViewById(R.id.tv_title);
        this.f30972d = (TextView) findViewById(R.id.tv_right);
        this.f30970b = (ImageView) findViewById(R.id.iv_left);
        this.f30974f = (TextView) findViewById(R.id.tv_content_title);
        this.f30973e.setText(R.string.one_payment_global_detail_page_paypal_title);
        this.f30972d.setText(R.string.one_payment_global_detail_page_remove_btn);
        this.f30974f.setText(R.string.one_payment_global_detail_page_paypal_title);
        this.f30971c.setText(this.f30975g);
        this.f30972d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackPayPalRemoveCK(PayPalSignDetailActivity.this);
                PayPalSignDetailActivity payPalSignDetailActivity = PayPalSignDetailActivity.this;
                payPalSignDetailActivity.m21774a((FragmentActivity) payPalSignDetailActivity);
            }
        });
        this.f30970b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                PayPalSignDetailActivity.this.onBackPressed();
            }
        });
    }

    public void showLoadingDialog() {
        PayGlobalLoading.show((Activity) this, (int) R.id.layout_title_bar, true);
    }

    public void dismissLoadingDialog() {
        PayGlobalLoading.hide();
    }

    public void onCancelSignSuccess(String str) {
        PayBaseToast.showSucc((Context) this, str);
        setResult(-1);
        finish();
    }

    public void onCancelSignFailure(String str) {
        PayBaseToast.showInfo((Context) this, str);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    /* renamed from: c */
    private void m21777c() {
        setTheme(R.style.GlobalActivityTheme);
    }

    /* renamed from: d */
    private void m21778d() {
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21774a(FragmentActivity fragmentActivity) {
        final AlertDialogFragment create = new AlertDialogFragment.Builder(fragmentActivity).setMessage(fragmentActivity.getString(R.string.one_payment_global_detail_page_paypal_dialog_remove_paypal_content)).setIcon(AlertController.IconType.INFO).setPositiveButtonDefault().setNegativeButton((int) R.string.one_payment_global_detail_page_dialog_remove_negative, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                GlobalOmegaUtils.trackPayPalRemoveCancelCK(PayPalSignDetailActivity.this);
            }
        }).setPositiveButton((int) R.string.one_payment_global_detail_page_dialog_remove_positive, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                PayPalSignDetailActivity.this.f30976h.requestCancelSign();
                GlobalOmegaUtils.trackPayPalRemoveOKCK(PayPalSignDetailActivity.this);
            }
        }).create();
        create.show(fragmentActivity.getSupportFragmentManager(), "tag");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                if (create.getDialog() != null) {
                    create.getDialog().setCanceledOnTouchOutside(false);
                }
            }
        }, 500);
    }
}
