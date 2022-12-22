package com.didi.travel.psnger;

import android.app.Application;
import java.lang.ref.WeakReference;

public class TEBridgeConfig {

    /* renamed from: a */
    private WeakReference<Application> f44021a;

    /* renamed from: b */
    private IClientConfig f44022b;

    /* renamed from: c */
    private IHostConfig f44023c;

    public void setApplication(Application application) {
        this.f44021a = new WeakReference<>(application);
    }

    public void setClientConfig(IClientConfig iClientConfig) {
        this.f44022b = iClientConfig;
    }

    public void setHostConfig(IHostConfig iHostConfig) {
        this.f44023c = iHostConfig;
    }

    public Application getApplication() {
        WeakReference<Application> weakReference = this.f44021a;
        if (weakReference != null) {
            return (Application) weakReference.get();
        }
        return null;
    }

    public IClientConfig getClientConfig() {
        return this.f44022b;
    }

    public IHostConfig getHostConfig() {
        return this.f44023c;
    }
}
