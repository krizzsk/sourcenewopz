package com.didi.payment.wallet.global.wallet.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.wallet.global.exts.CurrencyUtils;
import com.didi.payment.wallet.global.model.resp.QueryNightlyLimitSettingResp;
import com.didi.payment.wallet.global.wallet.contract.WalletChangeLimitResultContract;
import com.didi.payment.wallet.global.wallet.presenter.WalletChangeLimitResultPresenter;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.HashMap;

public class WalletChangeLimitResultActivity extends WalletBaseActivity implements WalletChangeLimitResultContract.IView {

    /* renamed from: a */
    private View f32130a;

    /* renamed from: b */
    private View f32131b;

    /* renamed from: c */
    private ImageView f32132c;

    /* renamed from: d */
    private TextView f32133d;

    /* renamed from: e */
    private TextView f32134e;

    /* renamed from: f */
    private TextView f32135f;

    /* renamed from: g */
    private TextView f32136g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public WalletChangeLimitResultContract.IPresenter f32137h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo f32138i;

    public static void start(Context context, QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo queryNightlyLimitSettingVo) {
        Intent intent = new Intent(context, WalletChangeLimitResultActivity.class);
        if (queryNightlyLimitSettingVo != null) {
            intent.putExtra("value", queryNightlyLimitSettingVo);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_global_activity_change_limit_result);
        this.f32137h = new WalletChangeLimitResultPresenter(this, this);
        this.f32130a = findViewById(R.id.ll_content);
        this.f32131b = findViewById(R.id.ll_empty);
        this.f32132c = (ImageView) findViewById(R.id.iv_state);
        this.f32133d = (TextView) findViewById(R.id.tv_limit_title);
        this.f32135f = (TextView) findViewById(R.id.tv_effect_time);
        this.f32136g = (TextView) findViewById(R.id.tv_limit_result);
        this.f32134e = (TextView) findViewById(R.id.tv_confirm);
        initLoadingDialog(this, R.id.fake_title_bar);
        Intent intent = getIntent();
        if (intent != null) {
            QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo queryNightlyLimitSettingVo = (QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo) intent.getSerializableExtra("value");
            if (queryNightlyLimitSettingVo != null) {
                showResult(queryNightlyLimitSettingVo);
            } else {
                this.f32137h.requestData();
            }
        } else {
            this.f32137h.requestData();
        }
        this.f32131b.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                WalletChangeLimitResultActivity.this.f32137h.requestData();
            }
        });
        this.f32134e.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                HashMap hashMap = new HashMap();
                if (WalletChangeLimitResultActivity.this.f32138i != null) {
                    if (WalletChangeLimitResultActivity.this.f32138i.limitUnderAnalysis > WalletChangeLimitResultActivity.this.f32138i.limitInEffective) {
                        hashMap.put("adjusted_type", 1);
                    } else {
                        hashMap.put("adjusted_type", 2);
                    }
                    hashMap.put("adjusted_amount", CurrencyUtils.centToDollar(Long.valueOf(WalletChangeLimitResultActivity.this.f32138i.limitUnderAnalysis)));
                }
                PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_night_transfer_limit_final_confirm_ck", hashMap);
                WalletChangeLimitResultActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f32137h.destroy();
        super.onDestroy();
    }

    public void showNetworkError() {
        this.f32130a.setVisibility(8);
        this.f32131b.setVisibility(0);
    }

    public void showResult(QueryNightlyLimitSettingResp.QueryNightlyLimitSettingVo queryNightlyLimitSettingVo) {
        this.f32138i = queryNightlyLimitSettingVo;
        this.f32130a.setVisibility(0);
        this.f32131b.setVisibility(8);
        if (!TextUtils.isEmpty(queryNightlyLimitSettingVo.effectiveTime)) {
            this.f32132c.setImageResource(R.drawable.wallet_img_change_limit_pending);
            this.f32135f.setVisibility(0);
            this.f32133d.setText(R.string.GRider_limit_The_cap_MmsS);
            this.f32135f.setText(queryNightlyLimitSettingVo.effectiveTime);
        } else {
            this.f32132c.setImageResource(R.drawable.wallet_img_change_limit_success);
            this.f32135f.setVisibility(8);
            this.f32133d.setText(R.string.GRider_limit_The_cap_JOMO);
        }
        TextView textView = this.f32136g;
        textView.setText(getString(R.string.GRider_limit_Transfer_limit_ESiw, new Object[]{"R$" + CurrencyUtils.currencyFormat(CurrencyUtils.centToDollar(Long.valueOf(queryNightlyLimitSettingVo.limitInEffective)), getResources().getConfiguration().locale), "R$" + CurrencyUtils.currencyFormat(CurrencyUtils.centToDollar(Long.valueOf(queryNightlyLimitSettingVo.limitUnderAnalysis)), getResources().getConfiguration().locale)}));
    }
}
