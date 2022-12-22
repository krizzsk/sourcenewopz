package com.didi.soda.web;

import com.didi.onehybrid.BusinessAgent;

public class SodaFusionEngine {

    /* renamed from: a */
    private static BusinessAgent f43860a;

    /* renamed from: b */
    private static Class<? extends GlobalJsBridge> f43861b;

    public static void init(SodaConfingBuilder sodaConfingBuilder) {
        f43860a = sodaConfingBuilder.businessAgent;
        f43861b = sodaConfingBuilder.globalJsBridge;
    }

    public static BusinessAgent getBusinessAgent() {
        return f43860a;
    }

    public static Class<? extends GlobalJsBridge> getGlobalJsBridge() {
        return f43861b;
    }

    public static class SodaConfingBuilder {
        BusinessAgent businessAgent;
        Class<? extends GlobalJsBridge> globalJsBridge;

        public SodaConfingBuilder setBusinessAgent(BusinessAgent businessAgent2) {
            this.businessAgent = businessAgent2;
            return this;
        }

        public void setGlobalJsBridge(Class<? extends GlobalJsBridge> cls) {
            this.globalJsBridge = cls;
        }
    }
}
