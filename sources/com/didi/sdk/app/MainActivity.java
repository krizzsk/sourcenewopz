package com.didi.sdk.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import com.didi.commoninterfacelib.permission.PermissionContext;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.common.TaskScheduler;
import com.didi.sdk.util.ApplicationLifeUtils;
import com.didi.sdk.util.RunTimeStatistics;

public class MainActivity extends FragmentActivity implements PermissionContext {

    /* renamed from: a */
    private boolean f35175a = false;

    /* renamed from: b */
    private ActivityDelegateManager f35176b;

    /* renamed from: c */
    private ActivityLifecycleManager.AppStateListener f35177c;

    /* renamed from: d */
    private ActivityLifecycleManager.AppStateListener f35178d;

    public Context getContextByPermissionContext() {
        return this;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        new RunTimeStatistics.SliceTime().setStart(System.currentTimeMillis());
        ActivityDelegateManager activityDelegateManager = new ActivityDelegateManager(this);
        this.f35176b = activityDelegateManager;
        activityDelegateManager.notifyOnPreCreateMethod();
        super.onCreate(bundle);
        m24860a(false);
        this.f35176b.notifyOnCreateMethod();
        ActivityLifecycleManager.getInstance().addAppStateListener(this.f35178d);
        m24862b();
        m24863c();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f35176b.notifyOnWindowFocusChanged(z);
        if (z && !m24861a()) {
            TaskScheduler.getDefault().notify(2);
            m24860a(true);
        }
    }

    /* renamed from: a */
    private boolean m24861a() {
        return this.f35175a;
    }

    /* renamed from: a */
    private void m24860a(boolean z) {
        this.f35175a = z;
    }

    /* renamed from: b */
    private void m24862b() {
        this.f35177c = new ActivityLifecycleManager.AppStateListener() {
            public void onStateChanged(int i) {
            }
        };
        ActivityLifecycleManager.getInstance().addAppStateListener(this.f35177c);
    }

    /* renamed from: c */
    private void m24863c() {
        this.f35178d = new ActivityLifecycleManager.AppStateListener() {
            public void onStateChanged(int i) {
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f35176b.notifyOnStartMethod();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f35176b.notifyOnResumeMethod();
        ApplicationLifeUtils.setApplicationFinishInit(this);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.f35176b.notifyOnStopMethod();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f35176b.notifyOnPauseMethod();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        TaskScheduler.getDefault().clear();
        this.f35176b.notifyOnDestroyMethod();
        ActivityLifecycleManager.getInstance().removeAppStateListener(this.f35177c);
        ActivityLifecycleManager.getInstance().removeAppStateListener(this.f35178d);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f35176b.notifyOnNewIntent();
    }

    public void startActivityByPermissionContext(Intent intent) {
        startActivity(intent);
    }

    public void startActivityForResultByPermissionContext(Intent intent, int i) {
        startActivityForResult(intent, i);
    }

    public void requestPermissionsByPermissionContext(String[] strArr, int i) {
        ActivityCompat.requestPermissions(this, strArr, i);
    }
}
