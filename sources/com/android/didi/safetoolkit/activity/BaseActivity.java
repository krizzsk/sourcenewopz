package com.android.didi.safetoolkit.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.android.didi.safetoolkit.activity.permisstion.PermissionToolsCompat;
import com.android.didi.safetoolkit.activity.permisstion.callback.PermissionCallback;
import com.android.didi.safetoolkit.observer.action.ActionObserverCompat;
import com.android.didi.safetoolkit.observer.action.IActionObservable;
import com.android.didi.safetoolkit.observer.action.IActionObserver;
import com.android.didi.safetoolkit.observer.lifecycle.ILifecycleObservable;
import com.android.didi.safetoolkit.observer.lifecycle.ILifecycleObserver;
import com.android.didi.safetoolkit.observer.lifecycle.LifecycleObserverCompat;
import com.didi.global.loading.app.AbsLoadingAppCompatActivity;
import com.didi.sdk.apm.SystemUtils;

public abstract class BaseActivity extends AbsLoadingAppCompatActivity implements IActionObservable, ILifecycleObservable {
    private ActionObserverCompat mActionObserverCompat = null;
    protected LayoutInflater mInflater = null;
    protected View mInnerLayout = null;
    private boolean mIsDestory;
    private LifecycleObserverCompat mLifeObserverCompat = null;
    private PermissionToolsCompat mPermissionToolsCompat;

    /* access modifiers changed from: protected */
    public void beforeContentViewLoaded() {
    }

    /* access modifiers changed from: protected */
    public abstract void findViews();

    /* access modifiers changed from: protected */
    public abstract int getBasicContentLayoutResId();

    public Context getContext() {
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract void initData();

    /* access modifiers changed from: protected */
    public abstract void initObjects();

    /* access modifiers changed from: protected */
    public boolean isAutoCall() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onActivityResult(int i, int i2, Intent intent, boolean z) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressedCall() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onContentViewLoaded() {
    }

    /* access modifiers changed from: protected */
    public void onInstanceStateRestore(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public abstract void parseBundle(Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract void setListener();

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        if (bundle != null) {
            bundle.remove("android:support:fragments");
        }
        initBaseSelf();
        super.onCreate(bundle);
        beforeContentViewLoaded();
        inflateContentView();
        onContentViewLoaded();
        onInstanceStateRestore(bundle);
        if (isAutoCall()) {
            parseBundle(getIntent().getExtras());
            findViews();
            initObjects();
            initData();
            setListener();
        }
        this.mLifeObserverCompat.onCreate();
    }

    /* access modifiers changed from: protected */
    public void initBaseSelf() {
        this.mPermissionToolsCompat = new PermissionToolsCompat(this);
        this.mActionObserverCompat = new ActionObserverCompat();
        this.mLifeObserverCompat = new LifecycleObserverCompat();
    }

    /* access modifiers changed from: protected */
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            parseBundle(intent.getExtras());
        }
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.mInflater = LayoutInflater.from(this);
        setContentView(getBasicContentLayoutResId());
    }

    public final void addLifecycleObserver(ILifecycleObserver iLifecycleObserver) {
        this.mLifeObserverCompat.addLifecycleObserver(iLifecycleObserver);
    }

    public final boolean removeLifecycleObserver(ILifecycleObserver iLifecycleObserver) {
        return this.mLifeObserverCompat.removeLifecycleObserver(iLifecycleObserver);
    }

    public void addActionObserver(IActionObserver iActionObserver) {
        this.mActionObserverCompat.addActionObserver(iActionObserver);
    }

    public boolean removeActionObserver(IActionObserver iActionObserver) {
        return this.mActionObserverCompat.removeActionObserver(iActionObserver);
    }

    public final void requestPermission(PermissionCallback permissionCallback, String... strArr) {
        this.mPermissionToolsCompat.requestPermission(permissionCallback, strArr);
    }

    public final void launchPermissionSetting() {
        this.mPermissionToolsCompat.launchPermissionSettingPageOnThePhone(this);
    }

    public final boolean checkPermissionsIsGranted(String... strArr) {
        return this.mPermissionToolsCompat.checkPermissionsIsGranted(strArr);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.mPermissionToolsCompat.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.mLifeObserverCompat.onStart();
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        this.mLifeObserverCompat.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mLifeObserverCompat.onPause();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.mLifeObserverCompat.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.mIsDestory = true;
        super.onDestroy();
        this.mLifeObserverCompat.onDestroy();
    }

    public boolean isDestroyed() {
        if (Build.VERSION.SDK_INT >= 17) {
            return super.isDestroyed();
        }
        return this.mIsDestory;
    }

    public final void onBackPressed() {
        if (onBackPressedCall()) {
            super.onBackPressed();
        }
        this.mActionObserverCompat.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if ((i >> 16) != 0) {
            onActivityResult(i, i2, intent, true);
        } else if (!onActivityResult(i, i2, intent, false)) {
            this.mActionObserverCompat.onActivityResult(i, i2, intent);
        }
    }
}
