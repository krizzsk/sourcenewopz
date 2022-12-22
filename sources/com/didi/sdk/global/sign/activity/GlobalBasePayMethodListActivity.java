package com.didi.sdk.global.sign.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.payment.base.view.PayGlobalLoading;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.sign.presenter.PayMethodSelectAdapter;
import com.taxis99.R;

public abstract class GlobalBasePayMethodListActivity extends FragmentActivity {
    public static final int REQ_CODE_ADD_CARD = 1;
    public static final int REQ_CODE_ADD_PAYPAL = 3;
    public static final int REQ_CODE_BALANCE_ACCOUNT_DETAIL = 7;
    public static final int REQ_CODE_CARD_DETAIL = 2;
    public static final int REQ_CODE_ENTERPRISE = 5;
    public static final int REQ_CODE_PAYPAL_DETAIL = 4;
    public static final int REQ_CODE_TOPUP_AMOUNT = 8;
    public static final int REQ_CODE_TOPUP_CHANNEL = 10;
    public static final int REQ_CODE_VERIFY_BALANCE = 6;
    public static final int REQ_CODE_WALLET_HOME = 9;
    public static PayMethodSelectAdapter sAdapter;
    protected Context mContext;
    protected DidiGlobalPayMethodListData.PayMethodListParam mParam;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        LoadingProxyHolder.setProxy(new LoadingProxyHolder.ILoadingProxy() {
            public void showLoading() {
                GlobalBasePayMethodListActivity.this.showLoadingDialog();
            }

            public void dismissLoading() {
                GlobalBasePayMethodListActivity.this.hideLoadingDialog();
            }
        });
        this.mContext = this;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        LoadingProxyHolder.releaseProxy();
    }

    /* access modifiers changed from: protected */
    public void initBase() {
        m25577a();
        getIntentParams();
    }

    /* access modifiers changed from: protected */
    public void setResult(DidiGlobalPayMethodListData.PayMethodListResult payMethodListResult) {
        Intent intent = new Intent();
        intent.putExtra("pay_method_list_result", payMethodListResult);
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: protected */
    public void getIntentParams() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mParam = (DidiGlobalPayMethodListData.PayMethodListParam) intent.getSerializableExtra("pay_method_list_param");
        }
        if (this.mParam == null) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }

    /* renamed from: a */
    private void m25577a() {
        final TextView textView = (TextView) findViewById(R.id.tv_payment_method_title);
        if (textView != null) {
            textView.postDelayed(new Runnable() {
                public void run() {
                    textView.setFocusable(true);
                    textView.sendAccessibilityEvent(128);
                }
            }, 60);
        }
    }

    public void showLoadingDialog() {
        PayGlobalLoading.show((Activity) this, (int) R.id.layout_title_bar, true);
    }

    public void hideLoadingDialog() {
        PayGlobalLoading.hide();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_none, R.anim.bottom_out);
    }
}
