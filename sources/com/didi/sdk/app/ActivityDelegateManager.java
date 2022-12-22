package com.didi.sdk.app;

import android.app.Activity;
import com.didi.sdk.app.delegate.ActivityDelegate;
import com.didi.sdk.spi.AbstractDelegateManager;
import com.didi.sdk.util.LogTimer;
import com.didi.security.uuid.Constants;
import com.didichuxing.apollo.sdk.Apollo;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class ActivityDelegateManager extends AbstractDelegateManager<ActivityDelegate> {
    private Activity activity;
    private boolean allow;
    /* access modifiers changed from: private */
    public Set<ActivityDelegate> delegates = new LinkedHashSet();
    private LogTimer.ElapsedTime elapsedTime = new LogTimer.ElapsedTime();

    ActivityDelegateManager(Activity activity2) {
        this.activity = activity2;
        this.allow = Apollo.getToggle("delegate_activity_time").allow();
        loadDelegates(ActivityDelegate.class, new AbstractDelegateManager.DelegateListener<ActivityDelegate>() {
            public void onDelegate(String str, ActivityDelegate activityDelegate) {
                ActivityDelegateManager.this.delegates.add(activityDelegate);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void addActivityDelegate(ActivityDelegate activityDelegate) {
        this.delegates.add(activityDelegate);
    }

    /* access modifiers changed from: package-private */
    public void removeActivityDelegate(ActivityDelegate activityDelegate) {
        this.delegates.remove(activityDelegate);
    }

    /* access modifiers changed from: package-private */
    public void notifyOnPreCreateMethod() {
        for (ActivityDelegate next : this.delegates) {
            System.currentTimeMillis();
            next.getClass();
            next.onPreCreate(this.activity);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyOnCreateMethod() {
        for (ActivityDelegate next : this.delegates) {
            long currentTimeMillis = System.currentTimeMillis();
            Class<?> cls = next.getClass();
            next.onCreate(this.activity);
            if (this.allow) {
                HashMap hashMap = new HashMap();
                hashMap.put("class", cls.toString());
                hashMap.put("time", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                hashMap.put("type", Constants.CREATE_NAME);
                OmegaSDKAdapter.trackEvent("delegate_activity_time", (Map<String, Object>) hashMap);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyOnStartMethod() {
        for (ActivityDelegate next : this.delegates) {
            long currentTimeMillis = System.currentTimeMillis();
            Class<?> cls = next.getClass();
            next.onStart(this.activity);
            if (this.allow) {
                HashMap hashMap = new HashMap();
                hashMap.put("class", cls.toString());
                hashMap.put("time", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                hashMap.put("type", "start");
                OmegaSDKAdapter.trackEvent("delegate_activity_time", (Map<String, Object>) hashMap);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyOnResumeMethod() {
        for (ActivityDelegate next : this.delegates) {
            long currentTimeMillis = System.currentTimeMillis();
            Class<?> cls = next.getClass();
            next.onResume(this.activity);
            if (this.allow) {
                HashMap hashMap = new HashMap();
                hashMap.put("class", cls.toString());
                hashMap.put("time", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                hashMap.put("type", "resume");
                OmegaSDKAdapter.trackEvent("delegate_activity_time", (Map<String, Object>) hashMap);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyOnPauseMethod() {
        for (ActivityDelegate next : this.delegates) {
            Class<?> cls = next.getClass();
            LogTimer.get().methodStart(this.elapsedTime, String.format("    %s#onPause()", new Object[]{cls}));
            next.onPause(this.activity);
            LogTimer.get().methodEnd(this.elapsedTime, String.format("    %s#onPause()", new Object[]{cls}));
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyOnStopMethod() {
        for (ActivityDelegate next : this.delegates) {
            Class<?> cls = next.getClass();
            LogTimer.get().methodStart(this.elapsedTime, String.format("    %s#onStop()", new Object[]{cls}));
            next.onStop(this.activity);
            LogTimer.get().methodEnd(this.elapsedTime, String.format("    %s#onStop()", new Object[]{cls}));
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyOnDestroyMethod() {
        for (ActivityDelegate next : this.delegates) {
            Class<?> cls = next.getClass();
            LogTimer.get().methodStart(this.elapsedTime, String.format("    %s#onDestroy()", new Object[]{cls}));
            next.onDestroy(this.activity);
            LogTimer.get().methodEnd(this.elapsedTime, String.format("    %s#onDestroy()", new Object[]{cls}));
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyOnNewIntent() {
        for (ActivityDelegate next : this.delegates) {
            Class<?> cls = next.getClass();
            LogTimer.get().methodStart(this.elapsedTime, String.format("    %s#notifyOnNewIntent()", new Object[]{cls}));
            next.onNewIntent(this.activity.getIntent());
            LogTimer.get().methodEnd(this.elapsedTime, String.format("    %s#notifyOnNewIntent()", new Object[]{cls}));
        }
    }

    public void notifyOnWindowFocusChanged(boolean z) {
        for (ActivityDelegate onWindowFocusChanged : this.delegates) {
            onWindowFocusChanged.onWindowFocusChanged(z);
        }
    }
}
