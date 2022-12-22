package com.didi.payment.wallet.global.wallet.view.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.payment.base.anti.AccessBlockEvent;
import com.didi.payment.base.anti.IAccessBlock;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.payment.base.view.PayGlobalLoading;
import com.didi.payment.wallet.global.model.event.PagePopupStack;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class WalletBaseActivity extends FragmentActivity implements IAccessBlock, WalletLoadingContract {

    /* renamed from: a */
    private boolean f32122a = false;

    /* renamed from: b */
    private LoadingProxyHolder.ILoadingProxy f32123b;

    public Context getContext() {
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean interceptPopupAction() {
        return false;
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
    public void initStatusBar() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.transparent));
    }

    public void initLoadingDialog(final Activity activity, final int i) {
        this.f32123b = new LoadingProxyHolder.ILoadingProxy() {
            public void showLoading() {
                PayGlobalLoading.show(activity, i, true);
            }

            public void dismissLoading() {
                PayGlobalLoading.hide();
            }
        };
    }

    public void showLoadingDialog() {
        LoadingProxyHolder.ILoadingProxy iLoadingProxy = this.f32123b;
        if (iLoadingProxy != null) {
            iLoadingProxy.showLoading();
        }
    }

    public void dismissLoadingDialog() {
        LoadingProxyHolder.ILoadingProxy iLoadingProxy = this.f32123b;
        if (iLoadingProxy != null) {
            iLoadingProxy.dismissLoading();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f32122a = true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f32122a = false;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPopupStack(PagePopupStack pagePopupStack) {
        SystemUtils.log(3, "hgl_tag", "activity popup :" + getClass().getSimpleName(), (Throwable) null, "com.didi.payment.wallet.global.wallet.view.activity.WalletBaseActivity", 105);
        if (!interceptPopupAction()) {
            finish();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAccessBlock(AccessBlockEvent accessBlockEvent) {
        if (isNeedFinish()) {
            finish();
        }
    }

    public boolean isVisible2User() {
        return this.f32122a;
    }
}
