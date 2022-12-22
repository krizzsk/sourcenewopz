package com.didichuxing.security.cardverify.activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.global.loading.LoadingConfig;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.security.cardverify.contract.CreditCardBaseContract;
import com.didichuxing.security.cardverify.view.PayLoading;
import com.taxis99.R;
import java.util.Locale;

public abstract class CardVerifyBaseActivity extends FragmentActivity implements CreditCardBaseContract.IView {

    /* renamed from: a */
    private static final int f48892a = -1711276033;

    public Activity getActivity() {
        return this;
    }

    public Context getContext() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        m35085a();
        super.onCreate(bundle);
        overridePendingTransition(R.anim.didi_security_card_verify_in_from_right, R.anim.didi_security_card_verify_out_to_left);
    }

    /* renamed from: a */
    private void m35085a() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }

    public void finish() {
        overridePendingTransition(R.anim.didi_security_card_verify_in_from_left, R.anim.didi_security_card_verify_out_to_right);
        super.finish();
    }

    public void showToast(String str) {
        if (str == null) {
            str = "";
        }
        LEGOToastHelper.showShortNagToast(this, str);
    }

    public void showToastCompleted(String str) {
        if (str == null) {
            str = "";
        }
        LEGOToastHelper.showShortPosToast(this, str);
    }

    public void showLoadingDialog(String str) {
        PayLoading.show((Activity) this, (int) R.id.layout_title_bar);
    }

    public void showMaskLoadingDialog(String str) {
        PayLoading.show((Activity) this, (int) R.id.layout_title_bar, LoadingConfig.create().setWithMaskLayer(true).setMaskBackgroundColor(f48892a).build());
    }

    public void dismissLoadingDialog() {
        PayLoading.hide();
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(m35083a(context));
    }

    /* renamed from: a */
    private Context m35083a(Context context) {
        Locale b = m35086b(context.getApplicationContext());
        return b != null ? m35084a(context, b) : context;
    }

    /* renamed from: b */
    private Locale m35086b(Context context) {
        if (context != null) {
            return context.getResources().getConfiguration().locale;
        }
        return null;
    }

    /* renamed from: a */
    private Context m35084a(Context context, Locale locale) {
        if (Build.VERSION.SDK_INT < 24) {
            return context;
        }
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        return context.createConfigurationContext(configuration);
    }
}
