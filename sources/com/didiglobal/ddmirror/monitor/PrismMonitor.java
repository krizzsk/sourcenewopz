package com.didiglobal.ddmirror.monitor;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.didiglobal.ddmirror.monitor.core.GlobalWindowManager;
import com.didiglobal.ddmirror.monitor.core.WindowCallbacks;
import com.didiglobal.ddmirror.monitor.core.WindowObserver;
import com.didiglobal.ddmirror.monitor.event.ActivityLifecycleCallbacks;
import com.didiglobal.ddmirror.monitor.event.AppLifecycleObserver;
import com.didiglobal.ddmirror.monitor.event.PrismMonitorWindowCallbacks;
import com.didiglobal.ddmirror.monitor.model.EventData;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class PrismMonitor {
    private static PrismMonitor sPrismMonitor = null;
    public static int sTouchSlop = -1;
    private boolean isInitialized;
    private boolean isMonitoring;
    private ActivityLifecycleCallbacks mActivityLifecycleCallbacks;
    private AppLifecycleObserver mAppLifecycleObserver;
    public Application mApplication;
    private List<OnPrismMonitorListener> mListeners;
    private WindowObserver.WindowObserverListener mWindowObserverListener;

    public interface OnPrismMonitorListener {
        void onEvent(EventData eventData);
    }

    private PrismMonitor() {
    }

    public static PrismMonitor getInstance() {
        if (sPrismMonitor == null) {
            synchronized (PrismMonitor.class) {
                if (sPrismMonitor == null) {
                    sPrismMonitor = new PrismMonitor();
                }
            }
        }
        return sPrismMonitor;
    }

    public boolean isMonitoring() {
        return this.isMonitoring;
    }

    public void init(Application application) {
        if (!this.isInitialized) {
            this.isInitialized = true;
            this.mApplication = application;
            this.mListeners = new ArrayList();
            Context applicationContext = application.getApplicationContext();
            sTouchSlop = ViewConfiguration.get(applicationContext).getScaledTouchSlop();
            this.mAppLifecycleObserver = new AppLifecycleObserver();
            ProcessLifecycleOwner.get().getLifecycle().addObserver(this.mAppLifecycleObserver);
            GlobalWindowManager.getInstance().init(applicationContext);
            this.mActivityLifecycleCallbacks = new ActivityLifecycleCallbacks();
            this.mWindowObserverListener = new WindowObserver.WindowObserverListener() {
                public void remove(Window window) {
                }

                public void add(Window window) {
                    PrismMonitor.this.setWindowCallback(window);
                }
            };
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: android.view.Window} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start() {
        /*
            r5 = this;
            boolean r0 = r5.isInitialized
            if (r0 == 0) goto L_0x0052
            boolean r0 = r5.isMonitoring
            if (r0 == 0) goto L_0x0009
            goto L_0x0052
        L_0x0009:
            android.app.Application r0 = r5.mApplication
            com.didiglobal.ddmirror.monitor.event.ActivityLifecycleCallbacks r1 = r5.mActivityLifecycleCallbacks
            r0.registerActivityLifecycleCallbacks(r1)
            com.didiglobal.ddmirror.monitor.core.GlobalWindowManager r0 = com.didiglobal.ddmirror.monitor.core.GlobalWindowManager.getInstance()
            com.didiglobal.ddmirror.monitor.core.WindowObserver r0 = r0.getWindowObserver()
            com.didiglobal.ddmirror.monitor.core.WindowObserver$WindowObserverListener r1 = r5.mWindowObserverListener
            r0.addWindowObserverListener(r1)
            r1 = 0
        L_0x001e:
            int r2 = r0.size()
            if (r1 >= r2) goto L_0x004f
            java.lang.Object r2 = r0.get(r1)
            android.view.View r2 = (android.view.View) r2
            r3 = 2131430040(0x7f0b0a98, float:1.848177E38)
            java.lang.Object r4 = r2.getTag(r3)
            android.view.Window r4 = (android.view.Window) r4
            if (r4 != 0) goto L_0x003f
            r0.bindWindow(r2)
            java.lang.Object r2 = r2.getTag(r3)
            r4 = r2
            android.view.Window r4 = (android.view.Window) r4
        L_0x003f:
            if (r4 == 0) goto L_0x004c
            android.view.Window$Callback r2 = r4.getCallback()
            boolean r2 = r2 instanceof com.didiglobal.ddmirror.monitor.core.WindowCallbacks
            if (r2 != 0) goto L_0x004c
            r5.setWindowCallback(r4)
        L_0x004c:
            int r1 = r1 + 1
            goto L_0x001e
        L_0x004f:
            r0 = 1
            r5.isMonitoring = r0
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.ddmirror.monitor.PrismMonitor.start():void");
    }

    public void stop() {
        if (this.isInitialized && this.isMonitoring) {
            this.isMonitoring = false;
            this.mApplication.unregisterActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
            WindowObserver windowObserver = GlobalWindowManager.getInstance().getWindowObserver();
            windowObserver.removeWindowObserverListener(this.mWindowObserverListener);
            for (int i = 0; i < windowObserver.size(); i++) {
                Window window = (Window) ((View) windowObserver.get(i)).getTag(R.id.ddmirror_window);
                if (window != null && (window.getCallback() instanceof WindowCallbacks)) {
                    window.setCallback(((WindowCallbacks) window.getCallback()).getCallBack());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void setWindowCallback(Window window) {
        if (window != null && !(window.getCallback() instanceof WindowCallbacks)) {
            window.setCallback(new PrismMonitorWindowCallbacks(window));
        }
    }

    public void post(int i) {
        post(new EventData(i));
    }

    public void post(EventData eventData) {
        if (this.isInitialized && this.isMonitoring) {
            for (int i = 0; i < this.mListeners.size(); i++) {
                OnPrismMonitorListener onPrismMonitorListener = this.mListeners.get(i);
                if (onPrismMonitorListener != null) {
                    onPrismMonitorListener.onEvent(eventData);
                }
            }
        }
    }

    public void addOnPrismMonitorListener(OnPrismMonitorListener onPrismMonitorListener) {
        if (this.isInitialized) {
            this.mListeners.add(onPrismMonitorListener);
        }
    }

    public void removeOnPrismMonitorListener(OnPrismMonitorListener onPrismMonitorListener) {
        if (this.isInitialized) {
            this.mListeners.remove(onPrismMonitorListener);
        }
    }
}
