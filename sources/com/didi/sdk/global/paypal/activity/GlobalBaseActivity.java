package com.didi.sdk.global.paypal.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.payment.base.utils.PayBaseConfigUtil;
import com.didi.payment.base.view.PayGlobalLoading;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.paypal.contract.CreditCardBaseContract;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;

public abstract class GlobalBaseActivity extends FragmentActivity implements CreditCardBaseContract.IView {
    public Activity getActivity() {
        return this;
    }

    public Context getContext() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        m25563a();
        super.onCreate(bundle);
        overridePendingTransition(R.anim.one_payment_creditcard_in_from_right, R.anim.one_payment_creditcard_out_to_left);
        if (!PayBaseConfigUtil.isDebugMode()) {
            getWindow().setFlags(8192, 8192);
        }
    }

    /* renamed from: a */
    private void m25563a() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }

    public void finish() {
        overridePendingTransition(R.anim.one_payment_creditcard_in_from_left, R.anim.one_payment_creditcard_out_to_right);
        super.finish();
    }

    public void showToast(String str) {
        if (str == null) {
            str = "";
        }
        if (str.length() > 30) {
            ToastHelper.showLongInfo((Context) this, str);
        } else {
            ToastHelper.showShortInfo((Context) this, str);
        }
    }

    public void showLoadingDialog(String str) {
        PayGlobalLoading.show((Activity) this, (int) R.id.layout_title_bar);
    }

    public void dismissLoadingDialog() {
        PayGlobalLoading.hide();
    }
}
