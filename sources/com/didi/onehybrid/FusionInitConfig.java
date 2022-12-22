package com.didi.onehybrid;

import java.util.HashMap;
import java.util.Map;

public class FusionInitConfig {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f29500a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f29501b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f29502c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f29503d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Map<String, Object> f29504e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public BusinessAgent f29505f;

    public String getAppKey() {
        return this.f29502c;
    }

    public String getPhone() {
        return this.f29500a;
    }

    public int getCityId() {
        return this.f29501b;
    }

    public String getHybridUrl() {
        return this.f29503d;
    }

    public BusinessAgent getBusinessAgent() {
        return this.f29505f;
    }

    public Map<String, Object> getExtraAttrsMap() {
        return this.f29504e;
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
            String unused = fusionInitConfig.f29502c = this.appKey;
            String unused2 = fusionInitConfig.f29500a = this.phone;
            int unused3 = fusionInitConfig.f29501b = this.cityId;
            String unused4 = fusionInitConfig.f29503d = this.hybridUrl;
            BusinessAgent unused5 = fusionInitConfig.f29505f = this.businessAgent;
            Map unused6 = fusionInitConfig.f29504e = this.extraAttrsMap;
            return fusionInitConfig;
        }
    }
}
