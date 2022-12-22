package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.activities;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.WalletToast;
import com.didi.payment.commonsdk.utils.NWRouter;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.contract.WalletSendEmailContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.contract.WalletViewBoletoContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.presenter.WalletViewBoletoPresenter;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.widget.BoletoSendEmailDialogFragment;
import com.didi.payment.wallet.global.wallet.view.activity.WalletBaseActivity;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class WalletViewBoletoActivity extends WalletBaseActivity implements WalletSendEmailContract, WalletViewBoletoContract.View {

    /* renamed from: d */
    private static final String f31972d = "boleto";

    /* renamed from: a */
    RelativeLayout f31973a;

    /* renamed from: b */
    ImageView f31974b;

    /* renamed from: c */
    TextView f31975c;

    /* renamed from: e */
    private TextView f31976e;

    /* renamed from: f */
    private TextView f31977f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f31978g;

    /* renamed from: h */
    private TextView f31979h;

    /* renamed from: i */
    private TextView f31980i;

    /* renamed from: j */
    private TextView f31981j;

    /* renamed from: k */
    private WalletViewBoletoContract.Presenter f31982k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public WalletBoletoResp f31983l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public BoletoSendEmailDialogFragment f31984m;

    public void onNetworkError() {
    }

    public static void launch(Context context, WalletBoletoResp walletBoletoResp) {
        Intent intent = new Intent(context, WalletViewBoletoActivity.class);
        intent.putExtra(f31972d, walletBoletoResp);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, 100);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_global_activity_boleto_view);
        m22637a();
        m22641b();
        this.f31982k = new WalletViewBoletoPresenter(this, this, this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            WalletBoletoResp walletBoletoResp = (WalletBoletoResp) extras.getSerializable(f31972d);
            this.f31983l = walletBoletoResp;
            if (walletBoletoResp != null) {
                refreshUI(walletBoletoResp);
                GlobalOmegaUtils.trackBillViewSW();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        initLoadingDialog(this, R.id.wallet_view_boleto_title_bar);
    }

    /* renamed from: a */
    private void m22637a() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.wallet_view_boleto_title_bar);
        this.f31973a = relativeLayout;
        this.f31974b = (ImageView) relativeLayout.findViewById(R.id.iv_left);
        this.f31975c = (TextView) this.f31973a.findViewById(R.id.tv_title);
        this.f31976e = (TextView) findViewById(R.id.tv_view_boleto_amount_title);
        this.f31977f = (TextView) findViewById(R.id.tv_view_boleto_expiration);
        this.f31978g = (TextView) findViewById(R.id.tv_view_boleto_number);
        this.f31979h = (TextView) findViewById(R.id.iv_view_boleto_copy_number);
        this.f31980i = (TextView) findViewById(R.id.btn_view_boleto_send_email);
        this.f31981j = (TextView) findViewById(R.id.tv_view_boleto_viewing_in_web_view);
        this.f31984m = new BoletoSendEmailDialogFragment();
    }

    /* renamed from: b */
    private void m22641b() {
        this.f31974b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletViewBoletoActivity.this.onBackPressed();
            }
        });
        this.f31979h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackBillCopyCK();
                WalletViewBoletoActivity walletViewBoletoActivity = WalletViewBoletoActivity.this;
                walletViewBoletoActivity.m22638a(walletViewBoletoActivity.getContext(), WalletViewBoletoActivity.this.f31978g.getText().toString());
                WalletToast.showSuccessMsg(WalletViewBoletoActivity.this.getContext(), WalletViewBoletoActivity.this.getContext().getResources().getString(R.string.wallet_view_boleto_copy_number_toast_msg));
            }
        });
        this.f31980i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackSendEmailCK();
                if (WalletViewBoletoActivity.this.f31983l != null && WalletViewBoletoActivity.this.f31983l.accountEmail != null) {
                    WalletViewBoletoActivity.this.f31984m.setData(WalletViewBoletoActivity.this.f31983l.accountEmail);
                    WalletViewBoletoActivity.this.f31984m.setWalletSendEmailContract(WalletViewBoletoActivity.this);
                    WalletViewBoletoActivity.this.f31984m.show(WalletViewBoletoActivity.this.getSupportFragmentManager(), "topuperror");
                }
            }
        });
        this.f31981j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackBillDetailCK();
                if (WalletViewBoletoActivity.this.f31983l != null && WalletViewBoletoActivity.this.f31983l.url != null) {
                    NWRouter nWRouter = NWRouter.INSTANCE;
                    WalletViewBoletoActivity walletViewBoletoActivity = WalletViewBoletoActivity.this;
                    nWRouter.gotoPDFPage(walletViewBoletoActivity, walletViewBoletoActivity.f31983l.url);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22638a(Context context, String str) {
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Copied Text", str));
    }

    public void refreshUI(WalletBoletoResp walletBoletoResp) {
        if (walletBoletoResp != null) {
            walletBoletoResp.amount.bindTextView(this.f31976e);
            this.f31977f.setText(getString(R.string.wallet_view_boleto_expirytime_prefix) + " " + walletBoletoResp.expiryTime);
            this.f31978g.setText(walletBoletoResp.typeableLine);
        }
    }

    public void onEmailSentSuccess() {
        this.f31984m.dismissEmailDialog();
        WalletToast.showSuccessMsg(this, getResources().getString(R.string.boleto_send_email_success_msg));
    }

    public void onSendClick(String str) {
        WalletBoletoResp walletBoletoResp = this.f31983l;
        if (walletBoletoResp != null) {
            walletBoletoResp.receiverEmail = str;
            this.f31982k.sendEmail(this.f31983l);
        }
    }
}
