package com.xiaojuchefu.prism.monitor;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import com.taxis99.R;
import com.xiaojuchefu.prism.monitor.core.GlobalWindowManager;
import com.xiaojuchefu.prism.monitor.core.WindowCallbacks;
import com.xiaojuchefu.prism.monitor.core.WindowObserver;
import com.xiaojuchefu.prism.monitor.event.ActivityLifecycleCallbacks;
import com.xiaojuchefu.prism.monitor.event.PrismMonitorWindowCallbacks;
import com.xiaojuchefu.prism.monitor.event.ScreenObserver;
import com.xiaojuchefu.prism.monitor.handler.IPrismApolloService;
import com.xiaojuchefu.prism.monitor.handler.IViewContainerHandler;
import com.xiaojuchefu.prism.monitor.handler.IViewContentHandler;
import com.xiaojuchefu.prism.monitor.handler.IViewTagHandler;
import com.xiaojuchefu.prism.monitor.model.EventData;
import java.util.ArrayList;
import java.util.List;

public class PrismMonitor {

    /* renamed from: a */
    private static PrismMonitor f56078a = null;
    public static int sTouchSlop = -1;

    /* renamed from: b */
    private boolean f56079b;

    /* renamed from: c */
    private boolean f56080c;

    /* renamed from: d */
    private boolean f56081d;

    /* renamed from: e */
    private boolean f56082e;

    /* renamed from: f */
    private List<OnPrismMonitorListener> f56083f;

    /* renamed from: g */
    private ActivityLifecycleCallbacks f56084g;

    /* renamed from: h */
    private WindowObserver.WindowObserverListener f56085h;

    /* renamed from: i */
    private IViewContainerHandler f56086i;

    /* renamed from: j */
    private IViewContentHandler f56087j;

    /* renamed from: k */
    private IViewTagHandler f56088k;

    /* renamed from: l */
    private IPrismApolloService f56089l;

    /* renamed from: m */
    private String f56090m = "";
    public Application mApplication;

    /* renamed from: n */
    private String f56091n = "";

    /* renamed from: o */
    private String f56092o = "";

    /* renamed from: p */
    private long f56093p;

    public interface OnPrismMonitorListener {
        void onEvent(EventData eventData);
    }

    private PrismMonitor() {
    }

    public static PrismMonitor getInstance() {
        if (f56078a == null) {
            synchronized (PrismMonitor.class) {
                if (f56078a == null) {
                    f56078a = new PrismMonitor();
                }
            }
        }
        return f56078a;
    }

    public boolean isMonitoring() {
        return this.f56080c;
    }

    public boolean isTest() {
        return this.f56081d;
    }

    public void setTest(boolean z) {
        this.f56081d = z;
    }

    public void setKeepMonitoring(boolean z) {
        this.f56082e = z;
    }

    public void init(Application application) {
        if (!this.f56079b) {
            this.f56079b = true;
            this.mApplication = application;
            this.f56083f = new ArrayList();
            Context applicationContext = application.getApplicationContext();
            sTouchSlop = ViewConfiguration.get(applicationContext).getScaledTouchSlop();
            ScreenObserver screenObserver = new ScreenObserver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            try {
                applicationContext.registerReceiver(screenObserver, intentFilter);
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
            GlobalWindowManager.getInstance().init(applicationContext);
            this.f56084g = new ActivityLifecycleCallbacks();
            this.f56085h = new WindowObserver.WindowObserverListener() {
                public void remove(Window window) {
                }

                public void add(Window window) {
                    PrismMonitor.this.m40385a(window);
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
            boolean r0 = r5.f56079b
            if (r0 == 0) goto L_0x0052
            boolean r0 = r5.f56080c
            if (r0 == 0) goto L_0x0009
            goto L_0x0052
        L_0x0009:
            android.app.Application r0 = r5.mApplication
            com.xiaojuchefu.prism.monitor.event.ActivityLifecycleCallbacks r1 = r5.f56084g
            r0.registerActivityLifecycleCallbacks(r1)
            com.xiaojuchefu.prism.monitor.core.GlobalWindowManager r0 = com.xiaojuchefu.prism.monitor.core.GlobalWindowManager.getInstance()
            com.xiaojuchefu.prism.monitor.core.WindowObserver r0 = r0.getWindowObserver()
            com.xiaojuchefu.prism.monitor.core.WindowObserver$WindowObserverListener r1 = r5.f56085h
            r0.addWindowObserverListener(r1)
            r1 = 0
        L_0x001e:
            int r2 = r0.size()
            if (r1 >= r2) goto L_0x004f
            java.lang.Object r2 = r0.get(r1)
            android.view.View r2 = (android.view.View) r2
            r3 = 2131433448(0x7f0b17e8, float:1.8488682E38)
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
            boolean r2 = r2 instanceof com.xiaojuchefu.prism.monitor.core.WindowCallbacks
            if (r2 != 0) goto L_0x004c
            r5.m40385a(r4)
        L_0x004c:
            int r1 = r1 + 1
            goto L_0x001e
        L_0x004f:
            r0 = 1
            r5.f56080c = r0
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaojuchefu.prism.monitor.PrismMonitor.start():void");
    }

    public void stop() {
        if (this.f56079b && this.f56080c && !this.f56082e) {
            this.f56080c = false;
            this.mApplication.unregisterActivityLifecycleCallbacks(this.f56084g);
            WindowObserver windowObserver = GlobalWindowManager.getInstance().getWindowObserver();
            windowObserver.removeWindowObserverListener(this.f56085h);
            for (int i = 0; i < windowObserver.size(); i++) {
                Window window = (Window) ((View) windowObserver.get(i)).getTag(R.id.prism_window);
                if (window != null && (window.getCallback() instanceof WindowCallbacks)) {
                    window.setCallback(((WindowCallbacks) window.getCallback()).getCallBack());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40385a(Window window) {
        if (window != null && !(window.getCallback() instanceof WindowCallbacks)) {
            window.setCallback(new PrismMonitorWindowCallbacks(window));
        }
    }

    public void post(int i) {
        post(new EventData(i));
    }

    public void post(EventData eventData) {
        if (this.f56079b && this.f56080c) {
            for (int i = 0; i < this.f56083f.size(); i++) {
                OnPrismMonitorListener onPrismMonitorListener = this.f56083f.get(i);
                if (onPrismMonitorListener != null) {
                    onPrismMonitorListener.onEvent(eventData);
                }
            }
        }
    }

    public IViewContainerHandler getViewContainerHandler() {
        return this.f56086i;
    }

    public void setViewContainerHandler(IViewContainerHandler iViewContainerHandler) {
        this.f56086i = iViewContainerHandler;
    }

    public IViewContentHandler getViewContentHandler() {
        return this.f56087j;
    }

    public void setViewContentHandler(IViewContentHandler iViewContentHandler) {
        this.f56087j = iViewContentHandler;
    }

    public IViewTagHandler getViewTagHandler() {
        return this.f56088k;
    }

    public void setViewTagHandler(IViewTagHandler iViewTagHandler) {
        this.f56088k = iViewTagHandler;
    }

    public void setBlackPhoneToggle(String str) {
        this.f56090m = str;
    }

    public String getBlackPhoneToggle() {
        return this.f56090m;
    }

    public void setPhoneBrand(String str) {
        this.f56091n = str;
    }

    public String getPhoneBrand() {
        return this.f56091n;
    }

    public void setPhoneModel(String str) {
        this.f56092o = str;
    }

    public String getPhoneModel() {
        return this.f56092o;
    }

    public void setTotalMem(long j) {
        this.f56093p = j;
    }

    public long getTotalMem() {
        return this.f56093p;
    }

    public void setApolloService(IPrismApolloService iPrismApolloService) {
        this.f56089l = iPrismApolloService;
    }

    public boolean allow(String str) {
        IPrismApolloService iPrismApolloService = this.f56089l;
        if (iPrismApolloService == null) {
            return false;
        }
        return iPrismApolloService.allow(str);
    }

    public <T> T getParams(String str, String str2, T t) {
        IPrismApolloService iPrismApolloService = this.f56089l;
        if (iPrismApolloService == null) {
            return t;
        }
        return iPrismApolloService.getParams(str, str2, t);
    }

    public void addOnPrismMonitorListener(OnPrismMonitorListener onPrismMonitorListener) {
        if (this.f56079b) {
            this.f56083f.add(onPrismMonitorListener);
        }
    }

    public void removeOnPrismMonitorListener(OnPrismMonitorListener onPrismMonitorListener) {
        if (this.f56079b) {
            this.f56083f.remove(onPrismMonitorListener);
        }
    }
}
