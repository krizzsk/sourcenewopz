package com.didi.entrega.customer.widget.loading;

import android.os.Bundle;
import java.util.Arrays;

public class LoadingConfig {

    /* renamed from: a */
    private LoadingRenderType f20547a;

    /* renamed from: b */
    private Bundle f20548b;

    /* renamed from: c */
    private boolean f20549c;

    /* renamed from: d */
    private int f20550d;

    public LoadingConfig() {
    }

    public LoadingConfig(LoadingRenderType loadingRenderType, Bundle bundle, boolean z, int i) {
        this.f20547a = loadingRenderType;
        this.f20548b = bundle;
        this.f20549c = z;
        this.f20550d = i;
    }

    /* renamed from: a */
    private static boolean m15042a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LoadingConfig loadingConfig = (LoadingConfig) obj;
        if (this.f20549c == loadingConfig.f20549c && this.f20550d == loadingConfig.f20550d && this.f20547a == loadingConfig.f20547a && m15042a(this.f20548b, loadingConfig.f20548b)) {
            return true;
        }
        return false;
    }

    public int getLoadingGravity() {
        return this.f20550d;
    }

    public void setLoadingGravity(int i) {
        if (i == 48 || i == 80) {
            this.f20550d = i;
        }
    }

    public Bundle getRenderParams() {
        return this.f20548b;
    }

    public void setRenderParams(Bundle bundle) {
        this.f20548b = bundle;
    }

    public LoadingRenderType getRenderType() {
        return this.f20547a;
    }

    public void setRenderType(LoadingRenderType loadingRenderType) {
        this.f20547a = loadingRenderType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f20547a, this.f20548b, Boolean.valueOf(this.f20549c), Integer.valueOf(this.f20550d)});
    }

    public boolean isWithMaskLayer() {
        return this.f20549c;
    }

    public void setWithMaskLayer(boolean z) {
        this.f20549c = z;
    }
}
