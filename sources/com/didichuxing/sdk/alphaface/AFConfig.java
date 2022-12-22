package com.didichuxing.sdk.alphaface;

import android.content.Context;

public class AFConfig {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f48601a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f48602b;

    private AFConfig() {
    }

    public boolean isDebug() {
        return this.f48601a;
    }

    public Context getAppContext() {
        return this.f48602b;
    }

    public static class Builder {
        private AFConfig config = new AFConfig();

        public Builder setDebug(boolean z) {
            boolean unused = this.config.f48601a = z;
            return this;
        }

        public Builder setAppContext(Context context) {
            Context unused = this.config.f48602b = context.getApplicationContext();
            return this;
        }

        public AFConfig create() {
            return this.config;
        }
    }
}
