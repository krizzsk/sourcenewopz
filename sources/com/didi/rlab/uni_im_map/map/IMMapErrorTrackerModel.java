package com.didi.rlab.uni_im_map.map;

import com.didi.rlab.uni_im_map.uniapi.UniModel;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.HashMap;
import java.util.Map;

public class IMMapErrorTrackerModel extends UniModel {

    /* renamed from: a */
    private String f34199a;

    /* renamed from: b */
    private String f34200b;

    /* renamed from: c */
    private String f34201c;

    /* renamed from: d */
    private String f34202d;

    /* renamed from: e */
    private Map<String, Object> f34203e;

    public String getModuleName() {
        return this.f34199a;
    }

    public void setModuleName(String str) {
        this.f34199a = str;
    }

    public String getErrorName() {
        return this.f34200b;
    }

    public void setErrorName(String str) {
        this.f34200b = str;
    }

    public String getErrorCode() {
        return this.f34201c;
    }

    public void setErrorCode(String str) {
        this.f34201c = str;
    }

    public String getErrorMsg() {
        return this.f34202d;
    }

    public void setErrorMsg(String str) {
        this.f34202d = str;
    }

    public Map<String, Object> getParameters() {
        return this.f34203e;
    }

    public void setParameters(Map<String, Object> map) {
        this.f34203e = map;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("moduleName", this.f34199a);
        hashMap.put("errorName", this.f34200b);
        hashMap.put(Constants.ERROR_CODE, this.f34201c);
        hashMap.put("errorMsg", this.f34202d);
        hashMap.put("parameters", this.f34203e);
        return hashMap;
    }

    public static IMMapErrorTrackerModel fromMap(Map<String, Object> map) {
        IMMapErrorTrackerModel iMMapErrorTrackerModel = new IMMapErrorTrackerModel();
        String str = "";
        iMMapErrorTrackerModel.f34199a = (!map.containsKey("moduleName") || map.get("moduleName") == null) ? str : (String) map.get("moduleName");
        iMMapErrorTrackerModel.f34200b = (!map.containsKey("errorName") || map.get("errorName") == null) ? str : (String) map.get("errorName");
        iMMapErrorTrackerModel.f34201c = (!map.containsKey(Constants.ERROR_CODE) || map.get(Constants.ERROR_CODE) == null) ? str : (String) map.get(Constants.ERROR_CODE);
        if (map.containsKey("errorMsg") && map.get("errorMsg") != null) {
            str = (String) map.get("errorMsg");
        }
        iMMapErrorTrackerModel.f34202d = str;
        iMMapErrorTrackerModel.f34203e = (!map.containsKey("parameters") || map.get("parameters") == null) ? new HashMap<>() : (Map) map.get("parameters");
        return iMMapErrorTrackerModel;
    }
}
