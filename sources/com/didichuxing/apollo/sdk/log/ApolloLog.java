package com.didichuxing.apollo.sdk.log;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ApolloLog {

    /* renamed from: a */
    private Map<String, String> f45616a = new HashMap();

    /* renamed from: b */
    private IToggle f45617b;

    /* renamed from: c */
    private String f45618c;

    public ApolloLog(IToggle iToggle, String str) {
        this.f45618c = str;
        this.f45617b = iToggle;
        if (iToggle != null && iToggle.allow()) {
            String namespace = Apollo.getNamespace();
            this.f45616a.put("apollo_ns", (namespace == null || namespace.isEmpty()) ? "_" : namespace);
            this.f45616a.put("apollo_allow", "1");
            this.f45616a.put("apollo_testkey", getTestKey());
            Map<String, String> map = this.f45616a;
            String str2 = this.f45618c;
            map.put("apollo_key", str2 == null ? "" : str2);
        }
    }

    public ApolloLog(String str, String str2) {
        String namespace = Apollo.getNamespace();
        this.f45616a.put("apollo_ns", (namespace == null || namespace.isEmpty()) ? "_" : namespace);
        this.f45616a.put("apollo_allow", "1");
        this.f45616a.put("apollo_testkey", str);
        this.f45616a.put("apollo_key", "1234567890");
        this.f45616a.put("apollo_extra", str2);
    }

    public String getTestKey() {
        IExperiment experiment;
        String testKey;
        IToggle iToggle = this.f45617b;
        if (iToggle == null || (experiment = iToggle.getExperiment()) == null || (testKey = experiment.getTestKey()) == null) {
            return "";
        }
        return testKey;
    }

    public Set<Map.Entry<String, String>> getLogEntrySet() {
        return this.f45616a.entrySet();
    }

    public Map<String, String> getLogMap() {
        return this.f45616a;
    }

    public Integer getLogRate() {
        IToggle iToggle = this.f45617b;
        if (iToggle == null) {
            return null;
        }
        return iToggle.getLogRate();
    }

    public String getToggleName() {
        IToggle iToggle = this.f45617b;
        if (iToggle == null) {
            return "";
        }
        return iToggle.getName();
    }
}
