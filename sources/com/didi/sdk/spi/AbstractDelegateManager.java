package com.didi.sdk.spi;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractDelegateManager<S> {
    private static Logger log = LoggerFactory.getLogger("AbstractDelegateManager");
    private static boolean resourcesInited;

    public interface DelegateListener<S> {
        void onDelegate(String str, S s);
    }

    private static synchronized void initResources() {
        synchronized (AbstractDelegateManager.class) {
            if (!resourcesInited) {
                resourcesInited = true;
            }
        }
    }

    protected AbstractDelegateManager() {
        initResources();
    }

    /* access modifiers changed from: protected */
    public void loadDelegates(Class<S> cls, final Collection<S> collection) {
        loadDelegates(cls, new DelegateListener<S>() {
            public void onDelegate(String str, S s) {
                collection.add(s);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void loadDelegates(Class<S> cls, DelegateListener<S> delegateListener) {
        Iterator<S> it = ServiceLoader.load(cls).iterator();
        while (it.hasNext()) {
            S next = it.next();
            delegateListener.onDelegate(((ServiceProvider) next.getClass().getAnnotation(ServiceProvider.class)).alias(), next);
        }
    }

    /* access modifiers changed from: protected */
    public void loadDelegateClasses(Class<S> cls, DelegateListener<Class<? extends S>> delegateListener) {
        SystemUtils.log(3, "AbstractDelegateManager", "class = " + cls, (Throwable) null, "com.didi.sdk.spi.AbstractDelegateManager", 49);
        ServiceLoader<S> load = ServiceLoader.load(cls);
        SystemUtils.log(3, "AbstractDelegateManager", "ServiceLoader = " + load, (Throwable) null, "com.didi.sdk.spi.AbstractDelegateManager", 51);
        Iterator<S> it = load.iterator();
        while (it.hasNext()) {
            S next = it.next();
            SystemUtils.log(3, "AbstractDelegateManager", "s = " + next, (Throwable) null, "com.didi.sdk.spi.AbstractDelegateManager", 53);
            delegateListener.onDelegate(((ServiceProvider) next.getClass().getAnnotation(ServiceProvider.class)).alias(), next.getClass());
        }
    }
}
