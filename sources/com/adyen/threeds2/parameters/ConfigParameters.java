package com.adyen.threeds2.parameters;

import com.adyen.threeds2.exception.InvalidInputException;
import com.adyen.threeds2.util.Preconditions;
import java.util.HashMap;
import java.util.Map;

public final class ConfigParameters {

    /* renamed from: a */
    private final Map<String, Map<String, String>> f1086a = new HashMap();

    /* renamed from: a */
    private Map<String, String> m1215a(String str, boolean z) {
        Map<String, String> map = this.f1086a.get(str);
        if (!z || map != null) {
            return map;
        }
        HashMap hashMap = new HashMap();
        this.f1086a.put(str, hashMap);
        return hashMap;
    }

    public void addParam(String str, String str2, String str3) throws InvalidInputException {
        Preconditions.requireNonNull("paramName", str2);
        m1215a(str, true).put(str2, str3);
    }

    public Map<String, String> getGroup(String str) {
        return m1215a(str, false);
    }

    public String getParamValue(String str, String str2) throws InvalidInputException {
        Preconditions.requireNonNull("paramName", str2);
        Map<String, String> a = m1215a(str, false);
        if (a != null) {
            return a.get(str2);
        }
        return null;
    }

    public String removeParam(String str, String str2) throws InvalidInputException {
        Preconditions.requireNonNull("paramName", str2);
        Map<String, String> a = m1215a(str, false);
        if (a != null) {
            return a.remove(str2);
        }
        return null;
    }
}
