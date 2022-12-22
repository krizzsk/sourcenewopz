package com.didi.onehybrid.resource;

public class FusionCacheConfig {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f29679a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f29680b = true;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f29681c = true;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f29682d = true;

    public boolean isUseNetStream() {
        return this.f29679a;
    }

    public boolean isIgnoreHtml() {
        return this.f29680b;
    }

    public boolean needBlockImage() {
        return this.f29681c;
    }

    public boolean isCacheOnly() {
        return this.f29682d;
    }

    public static class Builder {
        private FusionCacheConfig fusionCacheConfig = new FusionCacheConfig();

        public Builder setUseNetStream(boolean z) {
            boolean unused = this.fusionCacheConfig.f29679a = z;
            return this;
        }

        public Builder setIgnoreHtml(boolean z) {
            boolean unused = this.fusionCacheConfig.f29680b = z;
            return this;
        }

        public Builder setBlockNetworkImage(boolean z) {
            boolean unused = this.fusionCacheConfig.f29681c = z;
            return this;
        }

        public Builder setCacheOnly(boolean z) {
            boolean unused = this.fusionCacheConfig.f29682d = z;
            return this;
        }

        public FusionCacheConfig build() {
            return this.fusionCacheConfig;
        }
    }
}
