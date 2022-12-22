package com.didi.soda.customer.widget.loading;

import android.os.Bundle;
import java.util.Arrays;

public class LoadingConfig {

    /* renamed from: a */
    private LoadingRenderType f42083a;

    /* renamed from: b */
    private Bundle f42084b;

    /* renamed from: c */
    private boolean f42085c;

    /* renamed from: d */
    private int f42086d;

    public LoadingConfig() {
    }

    public LoadingConfig(LoadingRenderType loadingRenderType, Bundle bundle, boolean z, int i) {
        this.f42083a = loadingRenderType;
        this.f42084b = bundle;
        this.f42085c = z;
        this.f42086d = i;
    }

    /* renamed from: a */
    private static boolean m29688a(Object obj, Object obj2) {
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
        if (this.f42085c == loadingConfig.f42085c && this.f42086d == loadingConfig.f42086d && this.f42083a == loadingConfig.f42083a && m29688a(this.f42084b, loadingConfig.f42084b)) {
            return true;
        }
        return false;
    }

    public int getLoadingGravity() {
        return this.f42086d;
    }

    public void setLoadingGravity(int i) {
        if (i == 48 || i == 80) {
            this.f42086d = i;
        }
    }

    public Bundle getRenderParams() {
        return this.f42084b;
    }

    public void setRenderParams(Bundle bundle) {
        this.f42084b = bundle;
    }

    public LoadingRenderType getRenderType() {
        return this.f42083a;
    }

    public void setRenderType(LoadingRenderType loadingRenderType) {
        this.f42083a = loadingRenderType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f42083a, this.f42084b, Boolean.valueOf(this.f42085c), Integer.valueOf(this.f42086d)});
    }

    public boolean isWithMaskLayer() {
        return this.f42085c;
    }

    public void setWithMaskLayer(boolean z) {
        this.f42085c = z;
    }
}
