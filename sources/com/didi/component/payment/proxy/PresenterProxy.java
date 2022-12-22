package com.didi.component.payment.proxy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.didi.component.business.util.UniPayManager;
import com.didi.component.core.IPresenter;
import com.didi.sdk.webview.PassengerProxyWebActivity;
import com.didi.unifiedPay.component.IViewCallback;
import com.didi.unifiedPay.component.model.BackKeyType;
import global.didi.pay.presenter.GlobalAbsPaymentPresenter;

public class PresenterProxy extends IPresenter<ViewProxy> implements IViewCallback {

    /* renamed from: a */
    private String f15106a;

    /* renamed from: b */
    private GlobalAbsPaymentPresenter f15107b;

    public void closeView() {
    }

    public PresenterProxy(Context context, String str) {
        super(context);
        this.f15106a = str;
    }

    public void setRealPresenter(GlobalAbsPaymentPresenter globalAbsPaymentPresenter) {
        this.f15107b = globalAbsPaymentPresenter;
    }

    public GlobalAbsPaymentPresenter getRealPresenter() {
        return this.f15107b;
    }

    public void setIView(ViewProxy viewProxy) {
        super.setIView(viewProxy);
        this.f15107b.setIView(viewProxy.getRealView());
    }

    public void callStartActivityForResult(Intent intent, int i) {
        if (intent != null && intent.getClass() == null) {
            intent.setClass(this.mContext, PassengerProxyWebActivity.class);
        }
        intent.setPackage(UniPayManager.getPackageName(this.mContext));
        startActivityForResult(intent, i);
    }

    public void callStartActivity(Intent intent) {
        if (intent != null && intent.getClass() == null) {
            intent.setClass(this.mContext, PassengerProxyWebActivity.class);
        }
        intent.setPackage(UniPayManager.getPackageName(this.mContext));
        startActivity(intent);
    }

    public int requestCode(int i) {
        return super.requestCodeForHost(i);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f15107b.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        if (backType == IPresenter.BackType.BackKey) {
            return this.f15107b.onBackPressed(BackKeyType.BackKey);
        }
        if (backType == IPresenter.BackType.TopLeft) {
            return this.f15107b.onBackPressed(BackKeyType.TopLeft);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f15107b.onAdd(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        this.f15107b.onRemove();
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        this.f15107b.onBackHome(bundle);
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
        this.f15107b.onLeaveHome();
    }

    /* access modifiers changed from: protected */
    public void onPageHide() {
        super.onPageHide();
        this.f15107b.onPageHide();
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
        this.f15107b.onPagePause();
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        this.f15107b.onPageResume();
    }

    /* access modifiers changed from: protected */
    public void onPageShow() {
        super.onPageShow();
        this.f15107b.onPageShow();
    }

    /* access modifiers changed from: protected */
    public void onPageStart() {
        super.onPageStart();
        this.f15107b.onPageStart();
    }

    /* access modifiers changed from: protected */
    public void onPageStop() {
        super.onPageStop();
        this.f15107b.onPageStop();
    }
}
