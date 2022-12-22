package com.didiglobal.omegasdkadapter;

import java.util.concurrent.CopyOnWriteArrayList;

public class OmegaAdapterInterceptorManager {
    private final CopyOnWriteArrayList<OmegaAdapterInterceptor> mOmegaAdapterInterceptors;

    public interface OmegaAdapterInterceptor {
        EventWrapper intercept(EventWrapper eventWrapper);
    }

    private OmegaAdapterInterceptorManager() {
        this.mOmegaAdapterInterceptors = new CopyOnWriteArrayList<>();
    }

    private static final class Singleton {
        /* access modifiers changed from: private */
        public static final OmegaAdapterInterceptorManager sInstance = new OmegaAdapterInterceptorManager();

        private Singleton() {
        }
    }

    public static OmegaAdapterInterceptorManager getInstance() {
        return Singleton.sInstance;
    }

    public void registerOmegaAdapterInterceptors(OmegaAdapterInterceptor omegaAdapterInterceptor) {
        this.mOmegaAdapterInterceptors.add(omegaAdapterInterceptor);
    }

    public void unregisterOmegaAdapterInterceptors(OmegaAdapterInterceptor omegaAdapterInterceptor) {
        this.mOmegaAdapterInterceptors.remove(omegaAdapterInterceptor);
    }

    /* access modifiers changed from: package-private */
    public CopyOnWriteArrayList<OmegaAdapterInterceptor> getInterceptors() {
        return this.mOmegaAdapterInterceptors;
    }
}
