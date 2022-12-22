package com.didi.dimina.webview.resource;

public class FusionCacheConfig {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f18330a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f18331b = true;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f18332c = true;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f18333d = true;

    public boolean isUseNetStream() {
        return this.f18330a;
    }

    public boolean isIgnoreHtml() {
        return this.f18331b;
    }

    public boolean needBlockImage() {
        return this.f18332c;
    }

    public boolean isCacheOnly() {
        return this.f18333d;
    }

    public static class Builder {
        private final FusionCacheConfig fusionCacheConfig = new FusionCacheConfig();

        public Builder setUseNetStream(boolean z) {
            boolean unused = this.fusionCacheConfig.f18330a = z;
            return this;
        }

        public Builder setIgnoreHtml(boolean z) {
            boolean unused = this.fusionCacheConfig.f18331b = z;
            return this;
        }

        public Builder setBlockNetworkImage(boolean z) {
            boolean unused = this.fusionCacheConfig.f18332c = z;
            return this;
        }

        public Builder setCacheOnly(boolean z) {
            boolean unused = this.fusionCacheConfig.f18333d = z;
            return this;
        }

        public FusionCacheConfig build() {
            return this.fusionCacheConfig;
        }
    }
}
