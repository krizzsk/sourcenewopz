package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.dialog.VerifyDialogFragment;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.view.PayBaseToast;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.contract.WalletBoletoCashinContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.presenter.WalletBoletoCashinPresenter;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.widget.BrazilDecimalEditText;
import com.didi.payment.wallet.global.utils.TextViewUtils;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.view.activity.WalletBaseActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;

public class WalletBoletoCashinActivity extends WalletBaseActivity implements WalletBoletoCashinContract.View {

    /* renamed from: a */
    RelativeLayout f31954a;

    /* renamed from: b */
    ImageView f31955b;

    /* renamed from: c */
    TextView f31956c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WalletBoletoCashinContract.Presenter f31957d;

    /* renamed from: e */
    private RelativeLayout f31958e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public BrazilDecimalEditText f31959f;

    /* renamed from: g */
    private ImageView f31960g;

    /* renamed from: h */
    private TextView f31961h;

    /* renamed from: i */
    private TextView f31962i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public WalletTopUpChannelResp.ChannelExtraData f31963j = null;

    /* renamed from: a */
    private void m22622a(EditText editText) {
    }

    public void onNetworkError() {
    }

    public static void launch(Context context) {
        Intent intent = new Intent(context, WalletBoletoCashinActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void launch(Context context, WalletTopUpChannelResp.ChannelExtraData channelExtraData) {
        Intent intent = new Intent(context, WalletBoletoCashinActivity.class);
        intent.putExtra("extraData", channelExtraData);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_global_activity_boleto_cashin_regular);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f31963j = (WalletTopUpChannelResp.ChannelExtraData) extras.getSerializable("extraData");
        }
        m22621a();
        m22633h();
        this.f31957d = new WalletBoletoCashinPresenter(this, this, this);
        GlobalOmegaUtils.trackBoletoCashinPageSW();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        initLoadingDialog(this, R.id.wallet_balance_top_up_boleto_regular_title_bar);
    }

    /* renamed from: a */
    private void m22621a() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.wallet_balance_top_up_boleto_regular_title_bar);
        this.f31954a = relativeLayout;
        this.f31955b = (ImageView) relativeLayout.findViewById(R.id.iv_left);
        this.f31956c = (TextView) this.f31954a.findViewById(R.id.tv_title);
        this.f31958e = (RelativeLayout) findViewById(R.id.rl_wallet_balance_boleto_cashin_history_entry);
        this.f31959f = (BrazilDecimalEditText) findViewById(R.id.et_wallet_boleto_cashin_regular_amount);
        ImageView imageView = (ImageView) findViewById(R.id.tv_wallet_boleto_cashin_amount_delete_btn);
        this.f31960g = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletBoletoCashinActivity.this.f31959f.setText("");
            }
        });
        this.f31961h = (TextView) findViewById(R.id.tv_wallet_boleto_cashin_minimum_amount);
        this.f31962i = (TextView) findViewById(R.id.btn_wallet_boleto_cashin_regular_generate);
    }

    public void updateUIAfterEditTextChanged() {
        this.f31959f.setTextColor(ResourcesCompat.getColor(getResources(), R.color.black, getTheme()));
        m22628c();
        m22629d();
        m22626b();
    }

    /* renamed from: b */
    private void m22626b() {
        if (m22631f() || m22632g()) {
            this.f31961h.setTextColor(ResourcesCompat.getColor(getResources(), R.color.wallet_boleto_cashin_tv_min_value_default, getTheme()));
        } else {
            this.f31961h.setTextColor(ResourcesCompat.getColor(getResources(), R.color.wallet_boleto_cashin_tv_min_value_red, getTheme()));
        }
    }

    /* renamed from: c */
    private void m22628c() {
        if (!m22631f()) {
            this.f31960g.setVisibility(0);
        } else {
            this.f31960g.setVisibility(8);
        }
    }

    /* renamed from: d */
    private void m22629d() {
        if (m22630e()) {
            this.f31962i.setEnabled(true);
        } else {
            this.f31962i.setEnabled(false);
        }
    }

    /* renamed from: e */
    private boolean m22630e() {
        return !m22631f() && m22632g();
    }

    /* renamed from: f */
    private boolean m22631f() {
        return TextUtils.isEmpty(BrazilDecimalEditText.trimStringToNormalDecimalFormat(this.f31959f.getText().toString()));
    }

    /* renamed from: g */
    private boolean m22632g() {
        String trimStringToNormalDecimalFormat = BrazilDecimalEditText.trimStringToNormalDecimalFormat(this.f31959f.getText().toString());
        return (TextUtils.isEmpty(trimStringToNormalDecimalFormat) ? 0.0d : Double.parseDouble(trimStringToNormalDecimalFormat)) >= 7.0d;
    }

    /* renamed from: h */
    private void m22633h() {
        this.f31955b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletBoletoCashinActivity.this.finish();
            }
        });
        this.f31958e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackBoletoCashinHistoryPageCK();
                WalletRouter.gotoBoletoHistoryPage(WalletBoletoCashinActivity.this);
            }
        });
        this.f31962i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackBoletoCashinBtnCK();
                long parseDouble = (long) (Double.parseDouble(BrazilDecimalEditText.trimStringToNormalDecimalFormat(WalletBoletoCashinActivity.this.f31959f.getText().toString())) * 100.0d);
                if (parseDouble < 700) {
                    try {
                        WalletBoletoCashinActivity.this.f31959f.setText("");
                        PayBaseToast.showInfo((Context) WalletBoletoCashinActivity.this, (int) R.string.wallet_boleto_cashin_minimum_amount);
                    } catch (Exception unused) {
                    }
                } else if (WalletBoletoCashinActivity.this.f31963j == null || parseDouble <= ((long) Integer.parseInt(WalletBoletoCashinActivity.this.f31963j.maximumAmount))) {
                    WalletBoletoCashinActivity.this.f31957d.submitBoleto(Long.valueOf(parseDouble));
                } else {
                    WalletBoletoCashinActivity.this.m22624a(WalletBoletoCashinActivity.this.f31963j.dialog.title, WalletBoletoCashinActivity.this.f31963j.dialog.desc, WalletBoletoCashinActivity.this.f31963j.dialog.kycLink);
                }
            }
        });
        WalletTopUpChannelResp.ChannelExtraData channelExtraData = this.f31963j;
        if (channelExtraData != null) {
            TextViewUtils.appendDrawableLast(this.f31961h, channelExtraData.inputAmountRuleText, R.drawable.common_main_list_right_arrow_icon);
            this.f31961h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WebBrowserUtil.startInternalWebActivity(WalletBoletoCashinActivity.this.getContext(), WalletBoletoCashinActivity.this.f31963j.link, "");
                }
            });
            return;
        }
        this.f31961h.setText(ResourcesHelper.getString(getContext(), R.string.wallet_boleto_cashin_minimum_amount));
    }

    public void displayBoleto(WalletBoletoResp walletBoletoResp) {
        WalletRouter.gotoBoletoDetailPage(this, walletBoletoResp);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22624a(String str, String str2, final String str3) {
        new VerifyDialogFragment.Builder().showCloseBtn(false).setImageRes(R.drawable.one_pay_base_transfer_failed).setTitle(str).setContent(str2).setClickListener(getString(R.string.wallet_common_btn_verify_now), getString(R.string.wallet_common_btn_next_time), new VerifyDialogFragment.OnClickListener() {
            public void onPositiveClick(VerifyDialogFragment verifyDialogFragment) {
                DRouter.build(str3).start((Context) null);
                FinOmegaSDK.trackEvent("ibt_didipay_recharge_verify_ck");
                verifyDialogFragment.dismiss();
            }

            public void onNegativeClick(VerifyDialogFragment verifyDialogFragment) {
                FinOmegaSDK.trackEvent("ibt_didipay_recharge_details_ck");
                verifyDialogFragment.dismiss();
            }
        }).create().show(getSupportFragmentManager(), "verify_dialog_fragment");
    }
}
