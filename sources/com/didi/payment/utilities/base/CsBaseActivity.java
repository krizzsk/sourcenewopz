package com.didi.payment.utilities.base;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.commoninterfacelib.permission.TheOneBaseActivity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.global.loading.Loading;
import com.didi.global.loading.LoadingRenderType;
import com.didi.payment.base.anti.AccessBlockEvent;
import com.didi.payment.base.anti.IAccessBlock;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class CsBaseActivity extends TheOneBaseActivity implements IAccessBlock, WalletLoadingContract {

    /* renamed from: a */
    private View f31547a;

    public Context getContext() {
        return this;
    }

    public boolean isNeedFinish() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        initStatusBar();
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }

    /* access modifiers changed from: protected */
    public void initProgressDialog(FragmentActivity fragmentActivity, int i) {
        this.f31547a = fragmentActivity.findViewById(i);
    }

    /* access modifiers changed from: protected */
    public View getLoadingAnchorView() {
        return this.f31547a;
    }

    public void showLoadingDialog() {
        View loadingAnchorView = getLoadingAnchorView();
        if (loadingAnchorView != null) {
            Loading.make((Context) this, LoadingRenderType.ANIMATION, loadingAnchorView, true).show();
        }
    }

    public void dismissLoadingDialog() {
        View loadingAnchorView = getLoadingAnchorView();
        if (loadingAnchorView != null) {
            Loading.hide(loadingAnchorView);
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(m22285a(context));
    }

    /* renamed from: a */
    private Context m22285a(Context context) {
        Locale b = m22287b(context.getApplicationContext());
        return b != null ? m22286a(context, b) : context;
    }

    /* renamed from: b */
    private Locale m22287b(Context context) {
        if (context != null) {
            return context.getResources().getConfiguration().locale;
        }
        return null;
    }

    /* renamed from: a */
    private Context m22286a(Context context, Locale locale) {
        if (Build.VERSION.SDK_INT < 24) {
            return context;
        }
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        return context.createConfigurationContext(configuration);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAccessBlock(AccessBlockEvent accessBlockEvent) {
        if (isNeedFinish()) {
            finish();
        }
    }
}
