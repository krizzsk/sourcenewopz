package com.didi.sdk.app;

import android.app.Application;
import android.content.res.Configuration;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.delegate.ApplicationDelegate;
import com.didi.sdk.logtime.DDMethodIntervalTrack;
import com.didi.sdk.spi.AbstractDelegateManager;
import com.didi.sdk.util.LogTimer;
import java.util.Iterator;
import java.util.LinkedList;

class ApplicationDelegateManager extends AbstractDelegateManager<ApplicationDelegate> {
    private Application application;
    /* access modifiers changed from: private */
    public LinkedList<ApplicationDelegate> delegates = new LinkedList<>();
    private LogTimer.ElapsedTime elapsedTime = new LogTimer.ElapsedTime();

    ApplicationDelegateManager(Application application2) {
        this.application = application2;
        loadDelegates(ApplicationDelegate.class, new AbstractDelegateManager.DelegateListener<ApplicationDelegate>() {
            public void onDelegate(String str, ApplicationDelegate applicationDelegate) {
                if ("CommonProductApplicationDelegate".equals(str)) {
                    ApplicationDelegateManager.this.delegates.add(0, applicationDelegate);
                } else {
                    ApplicationDelegateManager.this.delegates.add(applicationDelegate);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void addApplicationDelegate(ApplicationDelegate applicationDelegate) {
        this.delegates.add(applicationDelegate);
    }

    /* access modifiers changed from: package-private */
    public void removeApplicationDelegate(ApplicationDelegate applicationDelegate) {
        this.delegates.remove(applicationDelegate);
    }

    /* access modifiers changed from: package-private */
    public void notifyAttachBaseContextMethod() {
        Iterator it = this.delegates.iterator();
        while (it.hasNext()) {
            ApplicationDelegate applicationDelegate = (ApplicationDelegate) it.next();
            SystemUtils.log(3, "delegate", "delegate:" + applicationDelegate.getClass().getName(), (Throwable) null, "com.didi.sdk.app.ApplicationDelegateManager", 58);
            applicationDelegate.attachBaseContext(this.application);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyOnCreateMethod() {
        Iterator it = this.delegates.iterator();
        while (it.hasNext()) {
            ApplicationDelegate applicationDelegate = (ApplicationDelegate) it.next();
            SystemUtils.log(3, "delegate", "delegate:" + applicationDelegate.getClass().getName(), (Throwable) null, "com.didi.sdk.app.ApplicationDelegateManager", 65);
            Class<?> cls = applicationDelegate.getClass();
            DDMethodIntervalTrack.get().methodStart(cls.getSimpleName());
            applicationDelegate.onCreate(this.application);
            DDMethodIntervalTrack.get().methodEnd(cls.getSimpleName());
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyLoadForground() {
        Iterator it = this.delegates.iterator();
        while (it.hasNext()) {
            ((ApplicationDelegate) it.next()).onLoadForground(this.application);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyOnLowMemoryMethod() {
        Iterator it = this.delegates.iterator();
        while (it.hasNext()) {
            ((ApplicationDelegate) it.next()).onLowMemory(this.application);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyOnTrimMemoryMethod(int i) {
        Iterator it = this.delegates.iterator();
        while (it.hasNext()) {
            ((ApplicationDelegate) it.next()).onTrimMemory(this.application, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyOnConfigurationChanged(Configuration configuration, Application application2) {
        Iterator it = this.delegates.iterator();
        while (it.hasNext()) {
            ((ApplicationDelegate) it.next()).onConfigurationChanged(configuration, application2);
        }
    }
}
