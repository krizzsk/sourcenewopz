package com.didi.global.loading;

import android.os.Bundle;
import java.util.Arrays;

public class LoadingConfig {
    public static final int DEFAULT_MASK_LAYER_BACKGROUND_COLOR = 1291845631;

    /* renamed from: a */
    private LoadingRenderType f22643a;

    /* renamed from: b */
    private Bundle f22644b;

    /* renamed from: c */
    private boolean f22645c;

    /* renamed from: d */
    private int f22646d;

    /* renamed from: e */
    private int f22647e;

    /* renamed from: f */
    private long f22648f;

    public static Builder create() {
        LoadingConfig loadingConfig = new LoadingConfig();
        loadingConfig.m16318a(300);
        loadingConfig.setLoadingGravity(80);
        loadingConfig.setRenderType(LoadingRenderType.ANIMATION);
        loadingConfig.setMaskBackgroundColor(DEFAULT_MASK_LAYER_BACKGROUND_COLOR);
        return new Builder(loadingConfig);
    }

    public void merge(LoadingConfig loadingConfig) {
        if (loadingConfig != null) {
            if (loadingConfig.getStartDelay() > 0) {
                m16318a(loadingConfig.getStartDelay());
            }
            setWithMaskLayer(loadingConfig.isWithMaskLayer());
            if (loadingConfig.getRenderType() != null) {
                setRenderType(loadingConfig.getRenderType());
            }
            if (loadingConfig.getMaskBackgroundColor() != 0) {
                setMaskBackgroundColor(loadingConfig.getMaskBackgroundColor());
            }
            if (loadingConfig.getLoadingGravity() != 0) {
                setLoadingGravity(loadingConfig.getLoadingGravity());
            }
            if (loadingConfig.getRenderParams() != null) {
                Bundle renderParams = getRenderParams();
                if (renderParams != null) {
                    renderParams.putAll(loadingConfig.getRenderParams());
                } else {
                    setRenderParams(loadingConfig.getRenderParams());
                }
            }
        }
    }

    public static class Builder {
        private LoadingConfig config;

        Builder(LoadingConfig loadingConfig) {
            this.config = loadingConfig;
        }

        public Builder setStartDelay(long j) {
            this.config.m16318a(j);
            return this;
        }

        public Builder setRenderType(LoadingRenderType loadingRenderType) {
            this.config.setRenderType(loadingRenderType);
            return this;
        }

        public Builder setRenderParams(Bundle bundle) {
            this.config.setRenderParams(bundle);
            return this;
        }

        public Builder setWithMaskLayer(boolean z) {
            this.config.setWithMaskLayer(z);
            return this;
        }

        public Builder setLoadingGravity(int i) {
            this.config.setLoadingGravity(i);
            return this;
        }

        public Builder setMaskBackgroundColor(int i) {
            this.config.setMaskBackgroundColor(i);
            return this;
        }

        public LoadingConfig build() {
            return this.config;
        }
    }

    public long getStartDelay() {
        return this.f22648f;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16318a(long j) {
        this.f22648f = j;
    }

    public LoadingRenderType getRenderType() {
        return this.f22643a;
    }

    public void setRenderType(LoadingRenderType loadingRenderType) {
        this.f22643a = loadingRenderType;
    }

    public Bundle getRenderParams() {
        return this.f22644b;
    }

    public void setRenderParams(Bundle bundle) {
        this.f22644b = bundle;
    }

    public void setMaskBackgroundColor(int i) {
        this.f22646d = i;
    }

    public int getMaskBackgroundColor() {
        return this.f22646d;
    }

    public boolean isWithMaskLayer() {
        return this.f22645c;
    }

    public void setWithMaskLayer(boolean z) {
        this.f22645c = z;
    }

    public int getLoadingGravity() {
        return this.f22647e;
    }

    public void setLoadingGravity(int i) {
        if (i == 48 || i == 80) {
            this.f22647e = i;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LoadingConfig loadingConfig = (LoadingConfig) obj;
        if (this.f22645c == loadingConfig.f22645c && this.f22647e == loadingConfig.f22647e && this.f22648f == loadingConfig.f22648f && this.f22643a == loadingConfig.f22643a && m16320a((Object) this.f22644b, (Object) loadingConfig.f22644b)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m16320a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f22643a, this.f22644b, Boolean.valueOf(this.f22645c), Integer.valueOf(this.f22647e), Long.valueOf(this.f22648f)});
    }
}
