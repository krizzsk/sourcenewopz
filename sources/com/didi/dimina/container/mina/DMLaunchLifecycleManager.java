package com.didi.dimina.container.mina;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.page.DMPage;
import java.util.ArrayList;
import java.util.Iterator;

public class DMLaunchLifecycleManager {

    /* renamed from: a */
    private final ArrayList<LaunchLifecycleCallback> f16882a = new ArrayList<>();

    public static abstract class LaunchLifecycleCallback {
        public void onAppConfigReady(DMMina dMMina) {
        }

        public void onAppLaunch(DMMina dMMina) {
        }

        public void onFirstPageDomReady(DMMina dMMina, DMPage dMPage) {
        }

        public void onFirstPageLaunch(DMMina dMMina) {
        }

        public void onJSEnginePreload(DMMina dMMina) {
        }

        public void onJSEngineReady(DMMina dMMina) {
        }

        public void onPageDomReady(DMMina dMMina, DMPage dMPage) {
        }
    }

    public static DMLaunchLifecycleManager getInstance() {
        return Holder.HOLD;
    }

    DMLaunchLifecycleManager() {
    }

    public void registerPageLifecycleCallback(LaunchLifecycleCallback launchLifecycleCallback) {
        this.f16882a.add(launchLifecycleCallback);
    }

    public void unregisterPageLifecycleCallback(LaunchLifecycleCallback launchLifecycleCallback) {
        this.f16882a.remove(launchLifecycleCallback);
    }

    public void hookPageDomReady(DMMina dMMina, DMPage dMPage) {
        Iterator<LaunchLifecycleCallback> it = this.f16882a.iterator();
        while (it.hasNext()) {
            LaunchLifecycleCallback next = it.next();
            if (next != null) {
                try {
                    next.onPageDomReady(dMMina, dMPage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void hookJSEnginePreload(DMMina dMMina) {
        Iterator<LaunchLifecycleCallback> it = this.f16882a.iterator();
        while (it.hasNext()) {
            LaunchLifecycleCallback next = it.next();
            if (next != null) {
                next.onJSEnginePreload(dMMina);
            }
        }
    }

    public void hookAppLaunch(DMMina dMMina) {
        Iterator<LaunchLifecycleCallback> it = this.f16882a.iterator();
        while (it.hasNext()) {
            LaunchLifecycleCallback next = it.next();
            if (next != null) {
                next.onAppLaunch(dMMina);
            }
        }
    }

    public void hookAppConfigReady(DMMina dMMina) {
        Iterator<LaunchLifecycleCallback> it = this.f16882a.iterator();
        while (it.hasNext()) {
            LaunchLifecycleCallback next = it.next();
            if (next != null) {
                next.onAppConfigReady(dMMina);
            }
        }
    }

    public void hookJSEngineReady(DMMina dMMina) {
        Iterator<LaunchLifecycleCallback> it = this.f16882a.iterator();
        while (it.hasNext()) {
            LaunchLifecycleCallback next = it.next();
            if (next != null) {
                next.onJSEngineReady(dMMina);
            }
        }
    }

    public void hookFirstPageLaunch(DMMina dMMina) {
        Iterator<LaunchLifecycleCallback> it = this.f16882a.iterator();
        while (it.hasNext()) {
            LaunchLifecycleCallback next = it.next();
            if (next != null) {
                next.onFirstPageLaunch(dMMina);
            }
        }
    }

    public void hookFirstPageDomReady(DMMina dMMina, DMPage dMPage) {
        Iterator<LaunchLifecycleCallback> it = this.f16882a.iterator();
        while (it.hasNext()) {
            LaunchLifecycleCallback next = it.next();
            if (next != null) {
                next.onFirstPageDomReady(dMMina, dMPage);
            }
        }
    }

    private static class Holder {
        /* access modifiers changed from: private */
        public static final DMLaunchLifecycleManager HOLD = new DMLaunchLifecycleManager();

        private Holder() {
        }
    }
}
