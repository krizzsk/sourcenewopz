package com.didi.rlab.uni_foundation.omega;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.HashMap;
import java.util.Map;

public class ErrorTrackerModel extends UniModel {

    /* renamed from: a */
    private String f34085a;

    /* renamed from: b */
    private String f34086b;

    /* renamed from: c */
    private String f34087c;

    /* renamed from: d */
    private String f34088d;

    /* renamed from: e */
    private Map<String, Object> f34089e;

    public String getModuleName() {
        return this.f34085a;
    }

    public void setModuleName(String str) {
        this.f34085a = str;
    }

    public String getErrorName() {
        return this.f34086b;
    }

    public void setErrorName(String str) {
        this.f34086b = str;
    }

    public String getErrorCode() {
        return this.f34087c;
    }

    public void setErrorCode(String str) {
        this.f34087c = str;
    }

    public String getErrorMsg() {
        return this.f34088d;
    }

    public void setErrorMsg(String str) {
        this.f34088d = str;
    }

    public Map<String, Object> getParameters() {
        return this.f34089e;
    }

    public void setParameters(Map<String, Object> map) {
        this.f34089e = map;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("moduleName", this.f34085a);
        hashMap.put("errorName", this.f34086b);
        hashMap.put(Constants.ERROR_CODE, this.f34087c);
        hashMap.put("errorMsg", this.f34088d);
        hashMap.put("parameters", this.f34089e);
        return hashMap;
    }

    public static ErrorTrackerModel fromMap(Map<String, Object> map) {
        ErrorTrackerModel errorTrackerModel = new ErrorTrackerModel();
        String str = "";
        errorTrackerModel.f34085a = (!map.containsKey("moduleName") || map.get("moduleName") == null) ? str : (String) map.get("moduleName");
        errorTrackerModel.f34086b = (!map.containsKey("errorName") || map.get("errorName") == null) ? str : (String) map.get("errorName");
        errorTrackerModel.f34087c = (!map.containsKey(Constants.ERROR_CODE) || map.get(Constants.ERROR_CODE) == null) ? str : (String) map.get(Constants.ERROR_CODE);
        if (map.containsKey("errorMsg") && map.get("errorMsg") != null) {
            str = (String) map.get("errorMsg");
        }
        errorTrackerModel.f34088d = str;
        errorTrackerModel.f34089e = (!map.containsKey("parameters") || map.get("parameters") == null) ? new HashMap<>() : (Map) map.get("parameters");
        return errorTrackerModel;
    }
}
