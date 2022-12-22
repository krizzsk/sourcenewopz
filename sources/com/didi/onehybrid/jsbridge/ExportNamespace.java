package com.didi.onehybrid.jsbridge;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public class ExportNamespace {

    /* renamed from: a */
    private static final String f29611a = ExportNamespace.class.getName();

    /* renamed from: b */
    private String f29612b;

    /* renamed from: c */
    private Class f29613c;

    /* renamed from: d */
    private Map<String, Method> f29614d;

    public ExportNamespace(String str, Class cls) {
        this.f29612b = str;
        this.f29613c = cls;
    }

    public String getExportModuleName() {
        return this.f29612b;
    }

    public Class getExportClass() {
        return this.f29613c;
    }

    public Method getTargetMethod(String str) {
        if (this.f29614d == null) {
            this.f29614d = m20809a();
        }
        return this.f29614d.get(str);
    }

    public JSONArray getExportMethodNames() {
        JSONArray jSONArray = new JSONArray();
        if (this.f29614d == null) {
            this.f29614d = m20809a();
        }
        for (String put : this.f29614d.keySet()) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    /* renamed from: a */
    private Map<String, Method> m20809a() {
        HashMap hashMap = new HashMap();
        for (Method method : this.f29613c.getMethods()) {
            JsInterface jsInterface = (JsInterface) method.getAnnotation(JsInterface.class);
            if (jsInterface != null) {
                for (String put : jsInterface.value()) {
                    hashMap.put(put, method);
                }
            }
        }
        return hashMap;
    }
}
