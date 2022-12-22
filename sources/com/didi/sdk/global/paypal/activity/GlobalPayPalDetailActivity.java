package com.didi.sdk.global.paypal.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.paypal.contract.PayPalDetailContract;
import com.didi.sdk.global.paypal.presenter.GlobalRemovePayPalPresenter;
import com.didi.sdk.global.util.DialogUtil;
import com.didi.sdk.global.util.GlobalOmegaUtils;
import com.taxis99.R;

public class GlobalPayPalDetailActivity extends GlobalBaseActivity implements PayPalDetailContract.View {

    /* renamed from: a */
    private TextView f36199a;

    /* renamed from: b */
    private ImageView f36200b;

    /* renamed from: c */
    private TextView f36201c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public PayPalDetailContract.Presenter f36202d;

    public static void launch(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, GlobalPayPalDetailActivity.class), i);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.one_payment_activity_global_paypal_detail);
        m25565a();
        m25566b();
        GlobalOmegaUtils.trackPayPalDetailPageSW(this);
    }

    /* renamed from: a */
    private void m25565a() {
        this.f36202d = new GlobalRemovePayPalPresenter(this);
    }

    /* renamed from: b */
    private void m25566b() {
        this.f36199a = (TextView) findViewById(R.id.tv_title);
        this.f36200b = (ImageView) findViewById(R.id.iv_left);
        this.f36201c = (TextView) findViewById(R.id.tv_right);
        this.f36199a.setText(getString(R.string.one_payment_global_detail_page_paypal_title));
        this.f36200b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalPayPalDetailActivity.this.onBackPressed();
                GlobalOmegaUtils.trackPayPalDetailPageReturnCK(GlobalPayPalDetailActivity.this);
            }
        });
        this.f36201c.setText(getString(R.string.one_payment_global_detail_page_credit_card_remove_btn));
        this.f36201c.setVisibility(0);
        this.f36201c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalPayPalDetailActivity.this.showCancelSignConfirmDialog();
                GlobalOmegaUtils.trackPayPalDetailPageRemoveCK(GlobalPayPalDetailActivity.this);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void showCancelSignConfirmDialog() {
        DialogUtil.showCancelSignConfirmDialog(this, getString(R.string.one_payment_global_detail_page_paypal_dialog_remove_paypal_content), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalPayPalDetailActivity.this.f36202d.removeCard(152);
                GlobalOmegaUtils.trackPayPalDetailPageRemoveOkCK(GlobalPayPalDetailActivity.this);
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackPayPalDetailPageRemoveCancelCK(GlobalPayPalDetailActivity.this);
            }
        });
    }

    public void onCancelSignSuccess() {
        setResult(-1);
        finish();
        overridePendingTransition(R.anim.one_payment_in_from_left, R.anim.one_payment_out_to_right);
    }
}
