package com.didi.unifiedPay.component.presenter;

import android.os.Bundle;
import com.didi.unifiedPay.component.view.IView;
import com.didi.unifiedPay.util.LogUtil;

public abstract class AbsBasePresenter<T extends IView> implements IPresenter<T> {
    private static final String TAG = "AbsPaymentPresenter";
    /* access modifiers changed from: protected */
    public T mView;

    public void setIView(T t) {
        this.mView = t;
    }

    public void onPageStart() {
        LogUtil.m31684d(TAG, "onPageStart");
    }

    public void onPageResume() {
        LogUtil.m31684d(TAG, "onPageResume");
    }

    public void onPagePause() {
        LogUtil.m31684d(TAG, "onPagePause");
    }

    public void onPageStop() {
        LogUtil.m31684d(TAG, "onPageStop");
    }

    public void onRemove() {
        LogUtil.m31684d(TAG, "onRemove");
    }

    public void onDateClean() {
        LogUtil.m31684d(TAG, "onDateClean");
    }

    public void onPageShow() {
        LogUtil.m31684d(TAG, "onPageShow");
    }

    public void onPageHide() {
        LogUtil.m31684d(TAG, "onPageHide");
    }

    public void onLeaveHome() {
        LogUtil.m31684d(TAG, "onLeaveHome");
    }

    public void onBackHome(Bundle bundle) {
        LogUtil.m31684d(TAG, "onBackHome");
    }
}
