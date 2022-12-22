package com.didi.xengine.config;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class EngineInitInstance {

    /* renamed from: a */
    private Map<String, EngineConfig> f45189a;

    private EngineInitInstance() {
        this.f45189a = new HashMap();
    }

    public EngineConfig getConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            for (String str2 : this.f45189a.keySet()) {
                EngineConfig engineConfig = this.f45189a.get(str2);
                if (engineConfig != null) {
                    return engineConfig;
                }
            }
        }
        return this.f45189a.get(str);
    }

    public void setConfig(String str, EngineConfig engineConfig) {
        this.f45189a.put(str, engineConfig);
    }

    private static class SingleTonHolder {
        /* access modifiers changed from: private */
        public static final EngineInitInstance INSTANCE = new EngineInitInstance();

        private SingleTonHolder() {
        }
    }

    public static EngineInitInstance getInstance() {
        return SingleTonHolder.INSTANCE;
    }
}
