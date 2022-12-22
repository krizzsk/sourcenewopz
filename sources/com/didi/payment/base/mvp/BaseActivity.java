package com.didi.payment.base.mvp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.didi.commoninterfacelib.permission.TheOneBaseActivity;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.payment.base.mvp.IBasePresenter;
import com.didi.payment.base.view.PayGlobalLoading;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;

public abstract class BaseActivity<T extends IBasePresenter> extends TheOneBaseActivity implements IBaseView {
    protected T mPresenter;

    /* access modifiers changed from: protected */
    public abstract View getTitleBarView();

    /* access modifiers changed from: protected */
    public abstract T initPresenter();

    /* access modifiers changed from: protected */
    public abstract void onActivityCreate(Bundle bundle);

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        m20982a();
        super.onCreate(bundle);
        this.mPresenter = initPresenter();
        onActivityCreate(bundle);
        T t = this.mPresenter;
        if (t != null) {
            t.attachView(this);
            this.mPresenter.setContext(this);
            this.mPresenter.onCreate(getIntent());
        }
    }

    /* renamed from: a */
    private void m20982a() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }

    public void showLoading() {
        if (getTitleBarView() != null) {
            PayGlobalLoading.show(getTitleBarView(), true);
        }
    }

    public void hideLoading() {
        if (getTitleBarView() != null) {
            PayGlobalLoading.hide(getTitleBarView());
        }
    }

    public void showToastComplete(String str) {
        if (str == null) {
            str = "";
        }
        if (str.length() > 30) {
            ToastHelper.showShortCompleted((Context) this, str);
        } else {
            ToastHelper.showLongCompleted((Context) this, str);
        }
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

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        T t = this.mPresenter;
        if (t != null) {
            t.onStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        T t = this.mPresenter;
        if (t != null) {
            t.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        T t = this.mPresenter;
        if (t != null) {
            t.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        T t = this.mPresenter;
        if (t != null) {
            t.onStop();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        T t = this.mPresenter;
        if (t != null) {
            t.onDestroy();
        }
    }
}
