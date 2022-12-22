package com.didi.dimina.webview;

import java.util.HashMap;
import java.util.Map;

public class FusionInitConfig {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f18214a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f18215b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f18216c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f18217d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Map<String, Object> f18218e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public BusinessAgent f18219f;

    public String getAppKey() {
        return this.f18216c;
    }

    public String getPhone() {
        return this.f18214a;
    }

    public int getCityId() {
        return this.f18215b;
    }

    public String getHybridUrl() {
        return this.f18217d;
    }

    public BusinessAgent getBusinessAgent() {
        return this.f18219f;
    }

    public Map<String, Object> getExtraAttrsMap() {
        return this.f18218e;
    }

    private FusionInitConfig() {
    }

    public static class Builder {
        String appKey;
        BusinessAgent businessAgent;
        int cityId;
        Map<String, Object> extraAttrsMap = new HashMap();
        String hybridUrl;
        String phone;

        public Builder setPhone(String str) {
            this.phone = str;
            return this;
        }

        public Builder setCityId(int i) {
            this.cityId = i;
            return this;
        }

        public Builder setBusinessAgent(BusinessAgent businessAgent2) {
            this.businessAgent = businessAgent2;
            return this;
        }

        public Builder setAppKey(String str) {
            this.appKey = str;
            return this;
        }

        public Builder setHybridUrl(String str) {
            this.hybridUrl = str;
            return this;
        }

        public Builder addExtraAttr(String str, Object obj) {
            this.extraAttrsMap.put(str, obj);
            return this;
        }

        public FusionInitConfig build() {
            FusionInitConfig fusionInitConfig = new FusionInitConfig();
            String unused = fusionInitConfig.f18216c = this.appKey;
            String unused2 = fusionInitConfig.f18214a = this.phone;
            int unused3 = fusionInitConfig.f18215b = this.cityId;
            String unused4 = fusionInitConfig.f18217d = this.hybridUrl;
            BusinessAgent unused5 = fusionInitConfig.f18219f = this.businessAgent;
            Map unused6 = fusionInitConfig.f18218e = this.extraAttrsMap;
            return fusionInitConfig;
        }
    }
}
