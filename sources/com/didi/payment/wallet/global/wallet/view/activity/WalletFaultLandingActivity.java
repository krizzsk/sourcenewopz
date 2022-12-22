package com.didi.payment.wallet.global.wallet.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;

public class WalletFaultLandingActivity extends WalletBaseActivity {

    /* renamed from: a */
    private ImageView f32139a;

    /* renamed from: b */
    private ImageView f32140b;

    /* renamed from: c */
    private TextView f32141c;

    /* renamed from: d */
    private TextView f32142d;

    /* renamed from: e */
    private TextView f32143e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public WalletPageModel f32144f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f32145g;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_fault_landing_activity);
        this.f32139a = (ImageView) findViewById(R.id.iv_left);
        this.f32140b = (ImageView) findViewById(R.id.iv_error_image);
        this.f32141c = (TextView) findViewById(R.id.tv_main_title);
        this.f32142d = (TextView) findViewById(R.id.tv_sub_title);
        this.f32143e = (TextView) findViewById(R.id.tv_remind);
        initLoadingDialog(this, R.id.layout_title_bar);
        m22820a();
        this.f32144f = new WalletPageModel(this);
        this.f32143e.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                WalletFaultLandingActivity.this.trackBtnCK();
                WalletFaultLandingActivity.this.showLoadingDialog();
                WalletFaultLandingActivity.this.f32144f.subscribeRecoverNotice(WalletFaultLandingActivity.this.f32145g, new RpcService.Callback<WBaseResp>() {
                    public void onSuccess(WBaseResp wBaseResp) {
                        WalletFaultLandingActivity.this.dismissLoadingDialog();
                        WalletToastNew.showSuccessMsg(WalletFaultLandingActivity.this.getContext(), WalletFaultLandingActivity.this.getString(R.string.Fintech_Payment_optimization__AWey));
                    }

                    public void onFailure(IOException iOException) {
                        WalletFaultLandingActivity.this.dismissLoadingDialog();
                        WalletToastNew.showFailedMsg(WalletFaultLandingActivity.this.getContext(), WalletFaultLandingActivity.this.getString(R.string.Fintech_Payment_optimization__JivK));
                    }
                });
            }
        });
        this.f32139a.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                WalletFaultLandingActivity.this.onBackPressed();
            }
        });
    }

    /* renamed from: a */
    private void m22820a() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f32145g = intent.getStringExtra(WalletExtraConstant.Key.CRASH_TYPE);
            String stringExtra = intent.getStringExtra(WalletExtraConstant.Key.CRASH_PAGE_TITLE);
            String stringExtra2 = intent.getStringExtra(WalletExtraConstant.Key.CRASH_PAGE_SUBTITLE);
            this.f32141c.setText(stringExtra);
            this.f32142d.setText(stringExtra2);
        }
        trackPageSW();
    }

    public void onBackPressed() {
        finish();
    }

    public void trackPageSW() {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        hashMap.put("pub_from_page", this.f32145g);
        FinOmegaSDK.trackEvent("fin_errorpage_sw", hashMap);
    }

    public void trackBtnCK() {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        hashMap.put("pub_from_page", this.f32145g);
        FinOmegaSDK.trackEvent("fin_errorpage_ck", hashMap);
    }
}
