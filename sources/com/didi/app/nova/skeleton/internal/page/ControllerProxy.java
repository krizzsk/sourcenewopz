package com.didi.app.nova.skeleton.internal.page;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.PageFactory;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.ControllerChangeType;
import com.didi.app.nova.skeleton.conductor.RouterTransaction;
import com.didichuxing.sofa.permission.PermissionRequest;
import java.util.List;

public final class ControllerProxy extends RefWatchingController {

    /* renamed from: d */
    private static final String f8489d = "ControllerProxy.Page.className";

    /* renamed from: c */
    PageWrapper f8490c;

    public ControllerProxy(Bundle bundle) {
        super(bundle);
    }

    /* access modifiers changed from: protected */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return this.f8490c.onInflateView(layoutInflater, viewGroup);
    }

    /* access modifiers changed from: protected */
    public void onAttach(View view) {
        super.onAttach(view);
        this.f8490c.callStart();
    }

    /* access modifiers changed from: protected */
    public void onDetach(View view) {
        super.onDetach(view);
        this.f8490c.callStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroyView(View view) {
        super.onDestroyView(view);
        this.f8490c.callDestroy();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f8490c.onFinalize();
    }

    public boolean handleBack() {
        boolean handleBack = super.handleBack();
        return !handleBack ? this.f8490c.onHandleBack() : handleBack;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(f8489d, this.f8490c.getClass().getName());
        this.f8490c.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        Page newInstance = PageFactory.newInstance(bundle.getString(f8489d), getArgs());
        this.f8490c = newInstance;
        newInstance.attach(getActivity(), new PageInstrumentImpl(getRouter()), this);
        this.f8490c.onRestoreInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onSaveViewState(View view, Bundle bundle) {
        super.onSaveViewState(view, bundle);
        this.f8490c.onSaveViewState(view, bundle);
    }

    /* access modifiers changed from: protected */
    public void onRestoreViewState(View view, Bundle bundle) {
        this.f8490c.onRestoreViewState(view, bundle);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f8490c.onCreateOptionsMenu(menu, menuInflater);
    }

    /* access modifiers changed from: protected */
    public void onChangeStarted(ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
        setOptionsMenuHidden(!controllerChangeType.isEnter);
        this.f8490c.onChangeStarted(controllerChangeHandler, controllerChangeType);
    }

    /* access modifiers changed from: protected */
    public void onChangeEnded(ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
        super.onChangeEnded(controllerChangeHandler, controllerChangeType);
        this.f8490c.onChangeEnded(controllerChangeHandler, controllerChangeType);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.f8490c.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: protected */
    public void onActivityResumed(Activity activity) {
        super.onActivityResumed(activity);
        List<RouterTransaction> backstack = getRouter().getBackstack();
        if (!backstack.isEmpty() && backstack.get(backstack.size() - 1).controller() == this) {
            this.f8490c.callResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityPaused(Activity activity) {
        super.onActivityPaused(activity);
        List<RouterTransaction> backstack = getRouter().getBackstack();
        if (!backstack.isEmpty() && backstack.get(backstack.size() - 1).controller() == this) {
            this.f8490c.callPause();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f8490c.onActivityResult(i, i2, intent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.f8490c.onRequestPermissionsResult(i, strArr, iArr);
    }

    public PageWrapper getPage() {
        return this.f8490c;
    }

    public void onPermissionGranted() {
        super.onPermissionGranted();
        this.f8490c.onPermissionGranted();
    }

    public void onPermissionDenied(String[] strArr) {
        super.onPermissionDenied(strArr);
        this.f8490c.onPermissionDenied(strArr);
    }

    public boolean onShowPermissionExplanation(PermissionRequest permissionRequest) {
        return super.onShowPermissionExplanation(permissionRequest) && this.f8490c.showPermissionExplanation(permissionRequest);
    }

    public String toString() {
        return super.toString() + "{innerPage=" + this.f8490c + "}";
    }
}
