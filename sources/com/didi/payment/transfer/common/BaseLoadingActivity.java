package com.didi.payment.transfer.common;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.payment.base.anti.IAccessBlock;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.payment.base.view.PayGlobalLoading;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import org.greenrobot.eventbus.EventBus;

public class BaseLoadingActivity extends FragmentActivity implements IAccessBlock, IPageLoading {
    protected boolean isInActive = false;

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
    public boolean isSupportEventBus() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        m22050a();
        super.onCreate(bundle);
        if (isSupportEventBus()) {
            EventBus.getDefault().register(this);
        }
    }

    /* renamed from: a */
    private void m22050a() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }

    public void initProgressDialog(final Activity activity, final int i) {
        if (i > 0) {
            LoadingProxyHolder.setProxy(new LoadingProxyHolder.ILoadingProxy() {
                public void showLoading() {
                    PayGlobalLoading.show(activity, i, true);
                }

                public void dismissLoading() {
                    PayGlobalLoading.hide();
                }
            });
        }
    }

    public void onShowPageLoadding() {
        if (LoadingProxyHolder.getProxy() != null) {
            LoadingProxyHolder.getProxy().showLoading();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.isInActive = true;
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.isInActive = false;
    }

    public void onDismissPageLoadding() {
        if (LoadingProxyHolder.getProxy() != null) {
            LoadingProxyHolder.getProxy().dismissLoading();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (isSupportEventBus()) {
            EventBus.getDefault().unregister(this);
        }
    }
}
